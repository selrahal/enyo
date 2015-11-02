package org.salemelrahal.drhack.item;

import bothack.bot.items.IItem;

public class ItemOnTile {
	private final IItem item;
	
	public static ItemOnTile create(IItem item) {
		return (item != null ? new ItemOnTile(item) : null);
	}
	
	private ItemOnTile(IItem item) {
		this.item = item;
	}
	
	public IItem getItem() {
		return item;
	}
}