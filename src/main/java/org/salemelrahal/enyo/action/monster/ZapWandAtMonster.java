package org.salemelrahal.enyo.action.monster;

import org.salemelrahal.enyo.enemy.Enemy;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.Direction;
import bothack.bot.IGame;

public class ZapWandAtMonster implements TargetEnemyAction{
	private Character slot;
	private Enemy target;
	
	public ZapWandAtMonster(Character slot, Enemy enemy) {
		this.slot = slot;
		this.target = enemy;
	}
	
	public IAction delegate(IGame game) {
		return Actions.ZapWandAt(slot,Direction.towards(game.player(), target.getPosition()));
	}
	
	public Enemy getTarget() {
		return this.target;
	}
}
