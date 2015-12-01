package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;

public class Wait implements Action{
	private IAction delegate;
	public Wait() {
		delegate = Actions.Search();
	}
	
	public IAction delegate() {
		return delegate;
	}
}
