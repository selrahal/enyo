package org.salemelrahal.drhack.fact;

import bothack.actions.Navigation.IPath;

public class PathToFountainTile {
	private IPath iPath;
	public PathToFountainTile(IPath iPath) {
		this.iPath = iPath;
	}
	
	public IPath path() {
		return this.iPath;
	}

}
