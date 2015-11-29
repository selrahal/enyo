package org.salemelrahal.enyo.item;

import bothack.bot.items.IItem;

public class ItemInInventory {
	private final Character slot;
	private final IItem item;
	
	public static ItemInInventory create(Character slot, IItem item) {
		return (item != null ? new ItemInInventory(slot, item) : null);
	}
	
	private ItemInInventory(Character slot, IItem item) {
		this.slot = slot;
		this.item = item;
	}
	
	public Character getSlot() {
		return slot;
	}
	public IItem getItem() {
		return item;
	}
}