package org.salemelrahal.enyo.actionhandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.salemelrahal.enyo.action.PrioritizedAction;
import org.salemelrahal.enyo.action.PrioritizedActionComparator;
import org.salemelrahal.enyo.fact.PathToAdvantageousTile;
import org.salemelrahal.enyo.fact.PathToFountainTile;
import org.salemelrahal.enyo.fact.PathToGoldTile;
import org.salemelrahal.enyo.fact.Persistent;
import org.salemelrahal.enyo.util.MapUtil;
import org.salemelrahal.enyo.util.RuleNameLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bothack.actions.IAction;
import bothack.actions.Navigation;
import bothack.bot.IGame;
import bothack.prompts.IActionHandler;

public class DroolsActionHandler implements IActionHandler {
	private final KieBase kieBase;
	private final Logger logger;
	
	private Collection<Persistent> persistentFacts = new ArrayList<Persistent>(0);
	private static final ObjectFilter PERSISTABLE = new ClassObjectFilter(Persistent.class);
	private static final ObjectFilter ACTIONS = new ClassObjectFilter(PrioritizedAction.class);
	
	public DroolsActionHandler(KieBase kieBase) {
		this.kieBase = kieBase;
		this.logger = LoggerFactory.getLogger("drools");
	}

	public IAction chooseAction(IGame gamestate) {
		KieSession kieSession = kieBase.newKieSession();
		this.initKieSession(kieSession, gamestate);
		kieSession.fireAllRules();
		List<PrioritizedAction> actions = this.getActions(kieSession);
		this.persistentFacts = this.getPersistentFacts(kieSession);
		
		
		if (actions.size() > 1) {
			for (PrioritizedAction action : actions) {
				logger.info(action.getPriority() + " - " + action.getAction() + " - " + action.getReason());
			}
		}
		PrioritizedAction toReturn = actions.get(0);
		logger.info("Rule set chose " + toReturn.getAction() + " - " + toReturn.getReason());
		
		
		this.cleanupKieSession(kieSession);
		
		return toReturn.getAction();
	}
	
	private void initKieSession(KieSession kieSession, IGame gamestate) {
		kieSession.addEventListener(new RuleNameLogger(logger));
		kieSession.setGlobal("logger", logger);
		for (Persistent fact : this.persistentFacts) {
			logger.info("Adding persistent fact=" + fact);
			kieSession.insert(fact);
		}
		kieSession.insert(gamestate);
		kieSession.insert(new PathToAdvantageousTile(Navigation.navigate(gamestate, MapUtil.ADVANTAGEOUS_TILE(gamestate))));
		kieSession.insert(new PathToFountainTile(Navigation.navigate(gamestate, MapUtil.FOUNTAIN(gamestate))));
		kieSession.insert(new PathToGoldTile(Navigation.navigate(gamestate, MapUtil.GOLD_TILE)));
	}
	
	private void cleanupKieSession(KieSession kieSession) {
		kieSession.dispose();
	}
	
	private Collection<Persistent> getPersistentFacts(KieSession kieSession) {
		Collection<?> persistFacts = kieSession.getObjects(PERSISTABLE);
		List<Persistent> toReturn = new ArrayList<Persistent>(persistFacts.size());
		for (Object o : persistFacts) {
			logger.info("Saving persistent fact=" + o);
			toReturn.add((Persistent)o);
		}
		return toReturn;
	}
	
	private List<PrioritizedAction> getActions(KieSession kieSession) {
		Collection<?> actionFacts = kieSession.getObjects(PERSISTABLE);
		List<PrioritizedAction> toReturn = new ArrayList<PrioritizedAction>(actionFacts.size());
		for (Object o : actionFacts) {
			toReturn.add((PrioritizedAction)o);
		}
		Collections.sort(toReturn, new PrioritizedActionComparator());
		return toReturn;	
	}
	
	

}
