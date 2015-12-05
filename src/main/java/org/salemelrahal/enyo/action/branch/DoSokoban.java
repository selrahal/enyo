package org.salemelrahal.enyo.action.branch;

import bothack.actions.ActionsComplex;
import bothack.actions.IAction;
import bothack.bot.IGame;

public class DoSokoban implements ExploreAction{	
	public IAction delegate(IGame game) {
		return ActionsComplex.doSokoban(game);
	}
}
