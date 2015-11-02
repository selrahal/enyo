package org.salemelrahal.drhack.action;


public class PrioritizedActionComparator implements java.util.Comparator<PrioritizedAction> {
	public int compare(PrioritizedAction arg0, PrioritizedAction arg1) {
		return (Integer.compare(arg1.getPriority(), arg0.getPriority()));
	}
}
