package org.salemelrahal.enyo.action.monster;

import org.salemelrahal.enyo.action.Action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.bot.Direction;
import bothack.bot.IGame;

public class AttackEngulfer implements Action{
	public AttackEngulfer() {
	}
	
	public IAction delegate(IGame game) {
		return Actions.Move(Direction.E);
	}
}
