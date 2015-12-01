package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.IGame;

public class DipForExcalibur implements Action{
	private Character slot;
	public DipForExcalibur(Character slot) {
		this.slot = slot;
	}
	
	public IAction delegate(IGame game) {
		return Actions.Dip(slot, '.');
	}
}
