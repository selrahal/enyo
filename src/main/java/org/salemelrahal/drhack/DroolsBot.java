package org.salemelrahal.drhack;

import org.kie.api.KieServices;
import org.kie.api.builder.Message.Level;
import org.kie.api.runtime.KieContainer;
import org.salemelrahal.drhack.actionhandler.DroolsActionHandler;

import bothack.bot.IBotHack;

public class DroolsBot {
	public DroolsBot(IBotHack bothack) {
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		if (kieContainer.verify().hasMessages(Level.ERROR)) {
			System.exit(1);
			throw new IllegalStateException("KJAR build Failed " + kieContainer.verify());
		}
		
		
		bothack.registerHandler(0, new DroolsActionHandler(kieContainer.getKieBase()));
	}
}
