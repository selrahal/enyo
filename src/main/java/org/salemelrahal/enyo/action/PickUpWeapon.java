package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.IGame;
import bothack.bot.items.IItem;

public class PickUpWeapon implements Action{
	private IAction delegate;
	public PickUpWeapon(IItem item) {
		delegate = Actions.PickUp(item.label());
	}
	
	public IAction delegate(IGame game) {
		return delegate;
	}
}
