package org.salemelrahal.drhack.actionhandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.salemelrahal.drhack.action.PrioritizedAction;
import org.salemelrahal.drhack.action.PrioritizedActionComparator;
import org.salemelrahal.drhack.fact.PathToAdvantageousTile;
import org.salemelrahal.drhack.fact.PathToFountainTile;
import org.salemelrahal.drhack.fact.PathToGoldTile;
import org.salemelrahal.drhack.util.MapUtil;
import org.salemelrahal.drhack.util.RuleNameLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bothack.actions.IAction;
import bothack.actions.Navigation;
import bothack.bot.IGame;
import bothack.prompts.IActionHandler;

public class DroolsActionHandler implements IActionHandler {
	private final KieBase kieBase;
	private final Logger logger;
	
	public DroolsActionHandler(KieBase kieBase) {
		this.kieBase = kieBase;
		this.logger = LoggerFactory.getLogger("drools");
	}

	public IAction chooseAction(IGame gamestate) {
		KieSession kieSession = kieBase.newKieSession();
		kieSession.addEventListener(new RuleNameLogger(logger));
		kieSession.setGlobal("logger", logger);
		kieSession.insert(gamestate);
		kieSession.insert(new PathToAdvantageousTile(Navigation.navigate(gamestate, MapUtil.ADVANTAGEOUS_TILE(gamestate))));
		kieSession.insert(new PathToFountainTile(Navigation.navigate(gamestate, MapUtil.FOUNTAIN(gamestate))));
		kieSession.insert(new PathToGoldTile(Navigation.navigate(gamestate, MapUtil.GOLD_TILE)));
		kieSession.fireAllRules();
		ObjectFilter actionFilter = new ClassObjectFilter(PrioritizedAction.class);
		Collection<?> facts = kieSession.getObjects(actionFilter);
		
		if (facts.size() == 0) {
			logger.info("Rules derived no actions");
			return null;
		} else {
			List<PrioritizedAction> actions = new ArrayList<PrioritizedAction>(facts.size());
			for (Object fact : facts) {
				actions.add((PrioritizedAction)fact);
			}
			Collections.sort(actions, new PrioritizedActionComparator());
			if (actions.size() > 1) {
				for (PrioritizedAction action : actions) {
					logger.info(action.getPriority() + " - " + action.getAction() + " - " + action.getReason());
				}
			}
			PrioritizedAction toReturn = actions.get(0);
			logger.info("Rule set chose " + toReturn.getAction() + " - " + toReturn.getReason());
			kieSession.dispose();		
			return toReturn.getAction();
		}
	}

}
