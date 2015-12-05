package org.salemelrahal.enyo.action.monster;

import org.salemelrahal.enyo.action.Action;
import org.salemelrahal.enyo.enemy.Enemy;

public interface TargetEnemyAction extends Action{
	public Enemy getTarget();
}
