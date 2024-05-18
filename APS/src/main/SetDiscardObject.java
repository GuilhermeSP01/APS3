package main;

import obj.DiscardGlass;

public class SetDiscardObject {
	
	GamePanel gp;
	
	public SetDiscardObject(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		
		gp.discard[0] = new DiscardGlass();
		gp.discard[0].x = 8 * gp.tileSize;
		gp.discard[0].y = 11 * gp.tileSize;
		
		
	}
}
