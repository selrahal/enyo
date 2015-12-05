package org.salemelrahal.enyo.util;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.slf4j.Logger;

public class RuleNameLogger extends DefaultAgendaEventListener {
	private final Logger logger;
	
	public RuleNameLogger(Logger logger) {
		this.logger = logger;
	}

	public void afterMatchFired(AfterMatchFiredEvent event) {
		logger.info("---Match fired: " + event.getMatch().getRule().getName());
		
		for (String key : event.getMatch().getDeclarationIds()) {
			logger.info("-------" + key + ":" + event.getMatch().getDeclarationValue(key));
		}
		
		for (Object fact : event.getMatch().getObjects()) {
			logger.info("------*" + fact);
		}
		
	}
}