package org.salemelrahal.enyo.action.branch;

import org.salemelrahal.enyo.action.Action;

import bothack.actions.ActionsComplex;
import bothack.actions.IAction;
import bothack.bot.IGame;

public class DoSokoban implements Action{
	private IAction delegate;
	public DoSokoban(IGame game) {
		delegate = ActionsComplex.doSokoban(game);
	}
	
	public IAction delegate() {
		return delegate;
	}
}
