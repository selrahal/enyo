package org.salemelrahal.enyo.action;

import bothack.actions.IAction;

public class PrioritizedAction {
	private final Integer priority;
	private final IAction action;
	private final String reason;
	
	public static PrioritizedAction create(Integer priority, IAction action, String reason) {
		if (priority != null && action != null) {
			return new PrioritizedAction(priority, action, reason);
		} else {
			return null;
		}
	}
	
	private PrioritizedAction(Integer priority, IAction action, String reason) {
		super();
		this.priority = priority;
		this.action = action;
		this.reason = reason;
	}
	
	public Integer getPriority() {
		return priority;
	}
	public IAction getAction() {
		return action;
	}
	public String getReason() {
		return reason;
	}
	
}
