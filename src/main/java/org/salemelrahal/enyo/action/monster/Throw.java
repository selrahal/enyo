package org.salemelrahal.enyo.action.monster;

import org.salemelrahal.enyo.enemy.Enemy;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.Direction;
import bothack.bot.IGame;

public class Throw implements TargetEnemyAction{
	private Character slot;
	private Enemy target;
	public Throw(Character slot, Enemy enemy) {
		this.slot = slot;
		this.target = enemy;
	}
	
	public IAction delegate(IGame game) {
		return Actions.Throw(slot, Direction.towards(game.player(), target.getPosition()));
	}
	
	public Enemy getTarget() {
		return this.target;
	}
}
