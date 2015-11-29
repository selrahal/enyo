package org.salemelrahal.enyo;

import org.junit.Assert;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.Message.Level;
import org.kie.api.runtime.KieContainer;

public class ValidKBaseTest {

	@Test
	public void testClasspathKieBase() {
		System.out.println("**** bot starting");
		KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
		if (kieContainer.verify().hasMessages(Level.ERROR)) {
			Assert.assertTrue("KJAR build Failed " + kieContainer.verify(), false);
		}
	}
}
