package org.salemelrahal.enyo.action.branch;

import org.salemelrahal.enyo.action.Action;

import bothack.actions.IAction;
import bothack.actions.Navigation;
import bothack.bot.IGame;
import bothack.bot.dungeon.Branch;

public class ExploreMainBranch implements Action{
	private IAction delegate;
	public ExploreMainBranch(IGame game) {
		delegate = Navigation.explore(game, Branch.MAIN);
	}
	
	public IAction delegate() {
		return delegate;
	}
}
