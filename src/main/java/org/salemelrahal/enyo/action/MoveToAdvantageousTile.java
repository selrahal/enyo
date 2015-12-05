package org.salemelrahal.enyo.action;

import bothack.actions.Actions;
import bothack.actions.IAction;
import bothack.actions.Navigation.IPath;
import bothack.bot.Direction;
import bothack.bot.IGame;
import bothack.bot.IPosition;

public class MoveToAdvantageousTile implements Action{
	private Direction direction;
	private Integer distance;
	
	public MoveToAdvantageousTile(IPosition myPosition, IPath path) {
		direction =Direction.towards(myPosition, path.path().get(0));
		distance = path.path().size();
	}
	
	public IAction delegate(IGame game) {
		return Actions.Move(direction);
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public Integer getDistance() {
		return this.distance;
	}
}
