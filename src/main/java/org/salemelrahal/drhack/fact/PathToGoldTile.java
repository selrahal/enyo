package org.salemelrahal.drhack.fact;

import bothack.actions.Navigation.IPath;

public class PathToGoldTile {
	private IPath iPath;
	public PathToGoldTile(IPath iPath) {
		this.iPath = iPath;
	}
	
	public IPath path() {
		return this.iPath;
	}

}
