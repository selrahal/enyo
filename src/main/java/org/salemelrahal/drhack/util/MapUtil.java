package org.salemelrahal.drhack.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bothack.bot.IGame;
import bothack.bot.IPredicate;
import bothack.bot.dungeon.Feature;
import bothack.bot.dungeon.ITile;
import bothack.bot.items.IItem;
import bothack.bot.items.IItemType;
import bothack.bot.items.ItemType;

public class MapUtil {
	private static final Logger LOG = LoggerFactory.getLogger("drools");
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
	
	public static IPredicate<ITile> FOUNTAIN(final IGame game) {
		return new IPredicate<ITile>() {
			public boolean apply(ITile tile) {
				if (Feature.FOUNTAIN.equals(tile.feature())) {
						return true;
				}
				return false;
			}
		};
	}
	
	public static IPredicate<ITile> ADVANTAGEOUS_TILE(final IGame game) {
		return new IPredicate<ITile>() {
			public boolean apply(ITile tile) {
				return isAdvantageous(game, tile);
			}
		};
	}
	
	public static boolean isAdvantageous(final IGame game, final ITile tile) {
		Long nonRocks = game.currentLevel().neighbors(tile).stream().filter(x -> Feature.ROCK.equals(x.feature())).count();
		
		if (nonRocks == 2) {
				return true;
		}
		return false;
	}
}
