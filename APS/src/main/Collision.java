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
	
			System.out.println("oi");
			
			elementTopRow = (elementTopPlayerY - player.speed)/gp.tileSize;
			tileOne = gp.tileM.mapTileNum[elementLeftCol][elementTopRow];
			tileTwo = gp.tileM.mapTileNum[elementRightCol][elementTopRow];
			
			if(gp.tileM.tile[tileOne].collision == true || gp.tileM.tile[tileTwo].collision == true) {
				player.collisionOn = true;
				
			}
			
			break;
			
		case 1:
			
			
			break;
			
		case 2:

			break;
			
		case 3:
			
			
			break;
			
		default: System.out.println("oi");
		}
		
	}

}
