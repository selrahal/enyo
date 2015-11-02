package org.salemelrahal.drhack.util;

import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.DefaultAgendaEventListener;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleNameLogger extends DefaultAgendaEventListener {
	private static final Logger LOG = LoggerFactory.getLogger(RuleNameLogger.class);

	public void matchCreated(MatchCreatedEvent event) {
		LOG.info("Match created: " + event.getMatch().getRule().getName());
	}

	public void afterMatchFired(AfterMatchFiredEvent event) {
		LOG.info("Match fired: " + event.getMatch().getRule().getName());
	}

}
