package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.items.IItem;

public class PickUpItem implements Action{
	private IAction delegate;
	public PickUpItem(IItem item) {
		delegate = Actions.PickUp(item.label());
	}
	
	public IAction delegate() {
		return delegate;
	}
}
