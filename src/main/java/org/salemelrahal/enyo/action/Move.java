package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.actions.Navigation.IPath;
import bothack.bot.Direction;
import bothack.bot.IGame;

public class Move implements Action{
	private IAction delegate;
	public Move(Direction dir) {
		delegate = Actions.Move(dir);
	}
	
	public Move(IAction move) {
		delegate = move;
	}
	
	public Move(IPath path) {
		delegate = path.step();
	}
	
	public IAction delegate(IGame game) {
		return delegate;
	}
}
