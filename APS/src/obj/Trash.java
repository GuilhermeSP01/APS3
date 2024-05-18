package obj;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Trash {

	public BufferedImage image;
	public String type;
	public boolean collision = false;
	public int x, y;
	public Rectangle solidArea = new Rectangle(0, 0, 64, 64);
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;

	public void draw(Graphics2D g2, GamePanel gp) {
		
		int screenX = x - gp.player.x + gp.player.screenX;
		int screenY = y - gp.player.y + gp.player.screenY;
		
		if(x + gp.tileSize > gp.player.x - gp.player.screenX &&
		   x - gp.tileSize < gp.player.x + gp.player.screenX &&
		   y + gp.tileSize > gp.player.y - gp.player.screenY &&
		   y - gp.tileSize < gp.player.x + gp.player.screenY) {
			
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
			
		}

	}
	
	
}
