package org.salemelrahal.enyo.action;

import bothack.actions.IAction;

public class ReasonedAction {
	private final IAction action;
	private final String reason;
	
	public static ReasonedAction create(IAction action, String reason) {
		if (action != null && reason != null) {
			return new ReasonedAction(action, reason);
		} else {
			return null;
		}
	}
	
	private ReasonedAction(IAction action, String reason) {
		super();
		this.action = action;
		this.reason = reason;
	}
	
	public IAction getAction() {
		return action;
	}
	public String getReason() {
		return reason;
	}

	@Override
	public String toString() {
		return "ReasonedAction [action=" + action + ", reason=" + reason + "]";
	}
	
}
