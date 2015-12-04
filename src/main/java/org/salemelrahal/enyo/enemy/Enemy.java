package org.salemelrahal.enyo.enemy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bothack.actions.Navigation;
import bothack.actions.Navigation.IPath;
import bothack.bot.IGame;
import bothack.bot.monsters.IMonster;
import bothack.bot.monsters.IMonsterType;

public class Enemy {
	private static final Logger LOG = LoggerFactory.getLogger("drools");
	private final IMonster target;
	private final IMonsterType type;
	private final boolean isAdjacent;
	private String name;
	private boolean marked;
	private boolean rangeMarked;
	private IPath pathTo;
	private Long difficulty;
	private Integer distance;
	public Enemy(IGame game, IMonster target, boolean isAdjacent) {
		LOG.info("target=" + target + " isAdjacent = " + isAdjacent);
		this.target = target;
		this.type = target.type();
		if (this.type != null) {
			this.name = this.type.name();
			this.difficulty = this.type.difficulty();
		} else {
			name = null;
		}
		
		this.isAdjacent = isAdjacent;
		this.pathTo = Navigation.navigate(game, target);
		if (this.pathTo != null) {
			this.distance = this.pathTo.path().size();
		} else {
			this.distance = Integer.MAX_VALUE;
		}
	}
	
	public String getName() {
		return name;
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
	
	public boolean isRangeMarked() {
		return rangeMarked;
	}

	public void setRangeMarked(boolean rangeMarked) {
		this.rangeMarked = rangeMarked;
	}

	public boolean isAwake() {
		return target.isAwake();
	}
	
	public IPath getPathTo() {
		return this.pathTo;
	}

	public Long getDifficulty() {
		return difficulty;
	}

	public Integer getDistance() {
		return distance;
	}
	
}
