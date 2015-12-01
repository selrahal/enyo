package org.salemelrahal.enyo.action;

import bothack.actions.IAction;

public class ReasonedAction {
	private final Action action;
	private final String reason;
	
	public static ReasonedAction create(Action action, String reason) {
		if (action != null && reason != null) {
			return new ReasonedAction(action, reason);
		} else {
			return null;
		}
	}
	
	private ReasonedAction(Action action, String reason) {
		super();
		this.action = action;
		this.reason = reason;
	}
	
	public Action getAction() {
		return action;
	}
	public String getReason() {
		return reason;
	}
	
	public IAction getDelegate() {
		return action.delegate();
	}

	@Override
	public String toString() {
		return "ReasonedAction [action=" + action + ", reason=" + reason + "]";
	}
	
}
