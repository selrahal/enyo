package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;

public class DipForExcalibur implements Action{
	private IAction delegate;
	public DipForExcalibur(Character slot) {
		delegate = Actions.Dip(slot, '.');
	}
	
	public IAction delegate() {
		return delegate;
	}
}
