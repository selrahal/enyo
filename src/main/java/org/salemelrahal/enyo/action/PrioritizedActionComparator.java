package org.salemelrahal.enyo.action;


public class PrioritizedActionComparator implements java.util.Comparator<PrioritizedAction> {
	public int compare(PrioritizedAction arg0, PrioritizedAction arg1) {
		int priority =  Integer.compare(arg1.getPriority(), arg0.getPriority());
		return (priority != 0 ? priority : arg1.getReason().compareTo(arg0.getReason()));
	}
}
