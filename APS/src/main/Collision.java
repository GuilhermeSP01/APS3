package main;

import element.Element;

public class Collision {
	
	GamePanel gp;
	
	public Collision(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Player player) {
		
		int elementLeftPlayerX = player.x + player.solidArea.x;
		int elementRightPlayerX = player.x + player.solidArea.x + player.solidArea.width;
		int elementTopPlayerY = player.y + player.solidArea.y;
		int elementBottomPlayerY = player.y + player.solidArea.y + player.solidArea.height;
		
		int elementLeftCol = elementLeftPlayerX/gp.tileSize;
		int elementRightCol = elementRightPlayerX/gp.tileSize;
		int elementTopRow = elementTopPlayerY/gp.tileSize;
		int elementBottomRow = elementBottomPlayerY/gp.tileSize;
		
		int tileOne, tileTwo;

		switch(player.direction) {
		
		case 0:
	
			elementTopRow = (elementTopPlayerY - player.speed/10 - 4)/gp.tileSize;
			tileOne = gp.tileM.mapTileNum[elementLeftCol][elementTopRow];
			tileTwo = gp.tileM.mapTileNum[elementRightCol][elementTopRow];
			
			if(gp.tileM.tile[tileOne].collision == true || gp.tileM.tile[tileTwo].collision == true) {
				player.collisionOn = true;
			}
			
			break;
			
		case 4:
			
			elementRightCol = (elementRightPlayerX + player.speed/10 + 4)/gp.tileSize;
			tileOne = gp.tileM.mapTileNum[elementRightCol][elementTopRow];
			tileTwo = gp.tileM.mapTileNum[elementRightCol][elementBottomRow];
			
			if(gp.tileM.tile[tileOne].collision == true || gp.tileM.tile[tileTwo].collision == true) {
				player.collisionOn = true;
			}			
			
			break;
			
		case 8:
			
			elementBottomRow = (elementBottomPlayerY + player.speed/10 + 4)/gp.tileSize;
			tileOne = gp.tileM.mapTileNum[elementLeftCol][elementBottomRow];
			tileTwo = gp.tileM.mapTileNum[elementRightCol][elementBottomRow];
			
			if(gp.tileM.tile[tileOne].collision == true || gp.tileM.tile[tileTwo].collision == true) {
				player.collisionOn = true;
			}
			
			break;
			
		case 12:
			
			elementLeftCol = (elementLeftPlayerX - player.speed/10 - 4)/gp.tileSize;
			tileOne = gp.tileM.mapTileNum[elementLeftCol][elementTopRow];
			tileTwo = gp.tileM.mapTileNum[elementLeftCol][elementBottomRow];
			
			if(gp.tileM.tile[tileOne].collision == true || gp.tileM.tile[tileTwo].collision == true) {
				player.collisionOn = true;
				
			}

			break;
			
		}
		
	}

}
