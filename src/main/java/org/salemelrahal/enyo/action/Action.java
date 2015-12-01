package org.salemelrahal.enyo.action;

import bothack.actions.IAction;
import bothack.bot.IGame;

public interface Action {
	public IAction delegate(IGame game);
}
