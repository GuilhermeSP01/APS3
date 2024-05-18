package main;

import obj.DiscardGlass;
import obj.DiscardOrganic;
import obj.DiscardPaper;
import obj.DiscardPlastic;

public class SetDiscardObject {
	
	GamePanel gp;
	
	public SetDiscardObject(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		
		gp.discard[0] = new DiscardGlass();
		gp.discard[0].x = 8 * gp.tileSize;
		gp.discard[0].y = 11 * gp.tileSize;
		
		gp.discard[1] = new DiscardOrganic();
		gp.discard[1].x = 18 * gp.tileSize;
		gp.discard[1].y = 4 * gp.tileSize;
		
		gp.discard[2] = new DiscardOrganic();
		gp.discard[2].x = 19 * gp.tileSize;
		gp.discard[2].y = 4 * gp.tileSize;
		
		gp.discard[3] = new DiscardPaper();
		gp.discard[3].x = 38 * gp.tileSize;
		gp.discard[3].y = 22 * gp.tileSize;
		
		gp.discard[4] = new DiscardPlastic();
		gp.discard[4].x = 27 * gp.tileSize;
		gp.discard[4].y = 29 * gp.tileSize;
		
		gp.discard[5] = new DiscardPlastic();
		gp.discard[5].x = 28 * gp.tileSize;
		gp.discard[5].y = 29 * gp.tileSize;
		
	}
}
