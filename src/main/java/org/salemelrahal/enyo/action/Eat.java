package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.IGame;
import bothack.bot.items.IItem;

public class Eat implements Action{
	private IAction delegate;
	public Eat(Character slot) {
		delegate = Actions.Eat(slot);
	}
	
	public Eat(IItem item) {
		delegate = Actions.Eat(item.label());
	}
	
	public IAction delegate(IGame game) {
		return delegate;
	}
}
