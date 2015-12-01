package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.Direction;
import bothack.bot.IGame;
import bothack.bot.monsters.IMonster;

public class Attack implements Action{
	private IMonster target;
	
	public Attack(IMonster monster) {
		target = monster;
	}
	
	public IAction delegate(IGame game) {
		return Actions.Move(Direction.towards(game.player(), target));
	}
}
