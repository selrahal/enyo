package org.salemelrahal.drhack.enemy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bothack.bot.monsters.IMonster;
import bothack.bot.monsters.IMonsterType;

public class Enemy {
	private static final Logger LOG = LoggerFactory.getLogger("drools");
	private final IMonster target;
	private final IMonsterType type;
	private final boolean isAdjacent;
	private boolean marked;
	public Enemy(IMonster target, boolean isAdjacent) {
		LOG.info("target=" + target + " isAdjacent = " + isAdjacent);
		this.target = target;
		this.type = target.type();
		this.isAdjacent = isAdjacent;
	}
	
	public IMonster getTarget() {
		return target;
	}
	
	public boolean respectsElbereth() {
		if (type == null || type.respectsElbereth() == null)
			return false;
		return type.respectsElbereth();
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
