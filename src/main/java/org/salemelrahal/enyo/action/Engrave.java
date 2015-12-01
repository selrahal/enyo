package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;

public class Engrave implements Action{
	private IAction delegate;
	public Engrave(Character slot, String message) {
		delegate = Actions.EngraveOverwriting(slot, message);
	}
	
	public IAction delegate() {
		return delegate;
	}
}
