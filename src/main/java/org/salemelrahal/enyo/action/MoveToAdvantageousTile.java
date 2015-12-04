package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.actions.Navigation.IPath;
import bothack.bot.Direction;
import bothack.bot.IGame;

public class MoveToAdvantageousTile implements Action{
	private IAction delegate;
	public MoveToAdvantageousTile(Direction dir) {
		delegate = Actions.Move(dir);
	}
	
	public MoveToAdvantageousTile(IAction move) {
		delegate = move;
	}
	
	public MoveToAdvantageousTile(IPath path) {
		delegate = path.step();
	}
	
	public IAction delegate(IGame game) {
		return delegate;
	}
}
