package org.salemelrahal.enyo.item;

import bothack.bot.items.IItem;
import bothack.bot.items.IItemType;

public class ItemOnTile {
	private final IItem item;
	private String label;
	private Integer priority;
	private String name;
	
	public static ItemOnTile create(IItem item) {
		return (item != null ? new ItemOnTile(item) : null);
	}
	
	private ItemOnTile(IItem item) {
		this.item = item;
		this.name = item.name();
		this.label = item.label();
	}
	
	public IItem getItem() {
		return item;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getName() {
		return this.name;
	}
	
	public IItemType getType() {
		return this.item.type();
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
}