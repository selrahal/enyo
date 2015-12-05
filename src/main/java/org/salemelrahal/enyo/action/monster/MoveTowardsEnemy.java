package org.salemelrahal.enyo.action.monster;

import org.salemelrahal.enyo.enemy.Enemy;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.actions.Navigation.IPath;
import bothack.bot.Direction;
import bothack.bot.IGame;

public class MoveTowardsEnemy implements TargetEnemyAction{
	private IAction delegate;
	private Enemy target;
	
	public MoveTowardsEnemy(Enemy enemy, IAction move) {
		this.delegate = move;
		this.target = enemy;
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

	public Enemy getTarget() {
		return target;
	}
	
}
