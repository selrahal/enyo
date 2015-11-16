package org.salemelrahal.drhack.util;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleNameLogger extends DefaultAgendaEventListener {
	private final Logger logger;
	
	public RuleNameLogger(Logger logger) {
		this.logger = logger;
	}

	public void matchCreated(MatchCreatedEvent event) {
		logger.info("Match created: " + event.getMatch().getRule().getName());
	}

	public void afterMatchFired(AfterMatchFiredEvent event) {
		logger.info("Match fired: " + event.getMatch().getRule().getName());
	}

}
