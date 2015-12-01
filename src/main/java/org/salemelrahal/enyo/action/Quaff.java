package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.IGame;

public class Quaff implements Action{
	private Character slot;
	public Quaff(Character slot) {
		this.slot = slot; 
	}
	
	public IAction delegate(IGame game) {
		return Actions.Quaff(slot);
	}
}
