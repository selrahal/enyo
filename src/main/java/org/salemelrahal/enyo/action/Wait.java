package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.IGame;

public class Wait implements Action{
	public IAction delegate(IGame game) {
		return Actions.Search();
	}
}
