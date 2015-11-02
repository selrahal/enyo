package org.salemelrahal.drhack.util;

import bothack.bot.IGame;
import bothack.bot.IPredicate;
import bothack.bot.dungeon.ITile;
import bothack.bot.items.IItem;
import bothack.bot.items.IItemType;
import bothack.bot.items.ItemType;

public class MapUtil {
	static IItemType GOLD = ItemType.byName("gold piece");

	public static IPredicate<ITile> GOLD_TILE = new IPredicate<ITile>() {
		public boolean apply(ITile tile) {
			for (IItem i : tile.items()) {
				if (i.type().equals(GOLD)) {
					return true;
				}
			}
			return false;
		}
	};

	public static IPredicate<ITile> HAS_FOOD(final IGame game) {
		return new IPredicate<ITile>() {
			public boolean apply(ITile tile) {
				for (IItem i : tile.items()) {
					if (game.player().canEat(i)) {
						return true;
					}
				}
				return false;
			}
		};
	}
}
