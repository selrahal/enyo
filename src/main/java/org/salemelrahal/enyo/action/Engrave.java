package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.IGame;

public class Engrave implements Action{
	private Character slot;
	private String message;
	public Engrave(Character slot, String message) {
		this.slot = slot;
		this.message = message;
	}
	
	public IAction delegate(IGame game) {
		return Actions.EngraveOverwriting(slot, message);
	}

	public Character getSlot() {
		return slot;
	}

	public String getMessage() {
		return message;
	}

}