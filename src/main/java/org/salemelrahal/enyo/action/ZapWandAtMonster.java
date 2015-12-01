package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.Direction;
import bothack.bot.IPlayer;
import bothack.bot.monsters.IMonster;

public class ZapWandAtMonster implements Action{
	private IAction delegate;
	public ZapWandAtMonster(Character slot, IPlayer player, IMonster monster) {
		delegate = Actions.ZapWandAt(slot,Direction.towards(player, monster));
	}
	
	public IAction delegate() {
		return delegate;
	}
}
