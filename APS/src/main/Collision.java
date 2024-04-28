package main;

import element.Element;

public class Collision {
	
	GamePanel gp;
	
	public Collision(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Element element) {
		
		int elementLeftWorldX = element.playerX + element.solidArea.x;
		int elementRightWorldX = element.playerX + element.solidArea.x + element.solidArea.width;
		int elementTopWorldY = element.playerY + element.solidArea.y;
		int elementBottomWorldY = element.playerY + element.solidArea.y + element.solidArea.height;
		
		int elementLeftCol = elementLeftWorldX/gp.tileSize;
		int elementRightCol = elementRightWorldX/gp.tileSize;
		int elementTopRow = elementTopWorldY/gp.tileSize;
		int elementBottomRow = elementBottomWorldY/gp.tileSize;
		
		int tileOne, tileTwo;
		
		switch(element.direction) {
		
		case "up":
			elementTopRow = (elementTopWorldY - element.)/gp.originalTileSize;
			
			break;
			
		case "down":
			break;
			
		case "left":
			break;
			
		case "right":
			break;
		}
		
	}

}
