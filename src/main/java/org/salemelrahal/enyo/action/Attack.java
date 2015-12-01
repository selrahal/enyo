package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.Direction;
import bothack.bot.IPlayer;
import bothack.bot.monsters.IMonster;

public class Attack implements Action{
	private IAction delegate;
	public Attack(IPlayer player, IMonster monster) {
		delegate = Actions.Move(Direction.towards(player, monster));
	}
	
	public IAction delegate() {
		return delegate;
	}
}
