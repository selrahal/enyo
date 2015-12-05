package org.salemelrahal.enyo.action.branch;

import bothack.actions.IAction;
import bothack.actions.Navigation;
import bothack.bot.IGame;
import bothack.bot.dungeon.Branch;

public class ExploreMainBranch implements ExploreAction{
	public IAction delegate(IGame game) {
		return Navigation.explore(game, Branch.MAIN);
	}
}
