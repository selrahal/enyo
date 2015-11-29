package org.salemelrahal.enyo;

import org.kie.api.KieServices;
import org.kie.api.builder.Message.Level;
import org.kie.api.runtime.KieContainer;
import org.salemelrahal.enyo.actionhandler.DroolsActionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bothack.bot.IBotHack;
import bothack.delegator.EatItHandler;

public class DroolsBot {
	private static final Logger logger = LoggerFactory.getLogger("drools");
	public DroolsBot(IBotHack bothack) {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		if (kieContainer.verify().hasMessages(Level.ERROR)) {
			throw new IllegalStateException("KJAR build Failed " + kieContainer.verify());
		}
		
		bothack.registerHandler(0, new DroolsActionHandler(kieContainer.getKieBase()));
		bothack.registerHandler(new EatItHandler() {
			
			public Object eat_it(Object arg0) {
				logger.info(arg0.toString());
				return null;
			}
		});
	}
}