package org.salemelrahal.enyo.action.branch;

import org.salemelrahal.enyo.action.Action;

import bothack.actions.ActionsComplex;
import bothack.actions.IAction;
import bothack.bot.IGame;

public class DoSokoban implements Action{	
	public IAction delegate(IGame game) {
		return ActionsComplex.doSokoban(game);
	}
}
