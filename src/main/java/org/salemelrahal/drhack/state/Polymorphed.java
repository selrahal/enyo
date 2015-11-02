package org.salemelrahal.drhack.state;

import bothack.bot.monsters.IMonsterType;

public class Polymorphed {
	private IMonsterType type;
	public Polymorphed(IMonsterType type) {
		this.type = type;
	}
	public IMonsterType getType() {
		return this.type;
	}
}
