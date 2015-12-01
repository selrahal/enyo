package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;

public class Pray implements Action{
	private IAction delegate;
	public Pray() {
		delegate = Actions.Pray();
	}
	
	public IAction delegate() {
		return delegate;
	}
}
