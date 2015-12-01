package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.Direction;
import bothack.bot.IGame;
import bothack.bot.monsters.IMonster;

public class Throw implements Action{
	private Character slot;
	private IMonster monster;
	public Throw(Character slot, IMonster monster) {
		this.slot = slot;
		this.monster = monster;
	}
	
	public IAction delegate(IGame game) {
		return Actions.Throw(slot, Direction.towards(game.player(), monster));
	}
}
