package org.salemelrahal.enyo.action;

import org.salemelrahal.enyo.enemy.Enemy;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.actions.Navigation.IPath;
import bothack.bot.Direction;
import bothack.bot.IGame;

public class MoveTowardsEnemy implements Action{
	private IAction delegate;
	private Enemy enemy;
	
	public MoveTowardsEnemy(Enemy enemy, IAction move) {
		this.delegate = move;
		this.enemy = enemy;
	}
	
	public MoveTowardsEnemy(Enemy enemy, Direction dir) {
		this(enemy, Actions.Move(dir));
	}
	
	public MoveTowardsEnemy(Enemy enemy, IPath path) {
		this(enemy, path.step());
	}
	
	public IAction delegate(IGame game) {
		return delegate;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
	
}
