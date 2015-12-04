package org.salemelrahal.enyo.actionhandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.ObjectFilter;
import org.salemelrahal.enyo.action.Action;
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
	private static final ObjectFilter ACTIONS = new ClassObjectFilter(Action.class);
	
	public DroolsActionHandler(KieBase kieBase) {
		this.kieBase = kieBase;
		this.logger = LoggerFactory.getLogger("drools");
	}

	public IAction chooseAction(IGame gamestate) {
		KieSession kieSession = kieBase.newKieSession();
		this.initKieSession(kieSession, gamestate);
		kieSession.fireAllRules();
		Action action = this.getReasonedAction(kieSession);
		this.persistentFacts = this.getPersistentFacts(kieSession);
		
		logger.info("Rule set chose " + action);
		
		this.cleanupKieSession(kieSession);
		
		return action.delegate(gamestate);
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
	
	private Action getReasonedAction(KieSession kieSession) {
		Collection<?> actionFacts = kieSession.getObjects(ACTIONS);
		List<Action> toReturn = new ArrayList<Action>(actionFacts.size());
		for (Object o : actionFacts) {
			toReturn.add((Action)o);
		}
		if (toReturn.size() != 1) {
			logger.error("Rule set chose more than one action, choosing arbitrarely!");
			for (Action action : toReturn) {
				logger.info("-" + action);
			}
			System.exit(0);
		}
		return toReturn.get(0);	
	}
	
	

}
