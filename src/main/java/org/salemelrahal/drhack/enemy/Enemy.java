package org.salemelrahal.drhack.enemy;

import bothack.bot.monsters.IMonster;

public class Enemy {
	private final IMonster target;
	private final boolean isAdjacent;
	private boolean marked;
	public Enemy(IMonster target, boolean isAdjacent) {
		this.target = target;
		this.isAdjacent = isAdjacent;
	}
	
	public IMonster getTarget() {
		return target;
	}

	public boolean isAdjacent() {
		return isAdjacent;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}
}
