package org.salemelrahal.enyo.action;

import org.salemelrahal.enyo.enemy.Enemy;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.Direction;
import bothack.bot.IGame;

public class Attack implements Action{
	private Enemy target;
	
	public Attack(Enemy monster) {
		target = monster;
	}
	
	public IAction delegate(IGame game) {
		return Actions.Move(Direction.towards(game.player(), target.getTarget()));
	}
	
	public Enemy getTarget() {
		return target;
	}
}
