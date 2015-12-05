package org.salemelrahal.enyo.action.item;

import org.salemelrahal.enyo.item.ItemOnTile;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.IGame;

public class PickUpWeapon implements TargetItemAction{
	private ItemOnTile item;
	public PickUpWeapon(ItemOnTile item) {
		this.item = item;
	}
	
	public IAction delegate(IGame game) {
		return Actions.PickUp(item.getLabel());
	}
	
	public ItemOnTile getTarget() {
		return this.item;
	}
}
