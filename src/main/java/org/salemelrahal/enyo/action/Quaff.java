package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;

public class Quaff implements Action{
	private IAction delegate;
	public Quaff(Character slot) {
		delegate = Actions.Quaff(slot);
	}
	
	public IAction delegate() {
		return delegate;
	}
}
