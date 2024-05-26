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
	
			elementTopRow = (elementTopPlayerY - player.speed)/gp.tileSize;
			tileOne = gp.tileM.mapTileNum[elementLeftCol][elementTopRow];
			tileTwo = gp.tileM.mapTileNum[elementRightCol][elementTopRow];
			
			if(gp.tileM.tile[tileOne].collision == true || gp.tileM.tile[tileTwo].collision == true) {
				player.collisionOn = true;
			}
			
			break;
			
		case 4:
			
			elementRightCol = (elementRightPlayerX + player.speed)/gp.tileSize;
			tileOne = gp.tileM.mapTileNum[elementRightCol][elementTopRow];
			tileTwo = gp.tileM.mapTileNum[elementRightCol][elementBottomRow];
			
			if(gp.tileM.tile[tileOne].collision == true || gp.tileM.tile[tileTwo].collision == true) {
				player.collisionOn = true;
			}			
			
			break;
			
		case 8:
			
			elementBottomRow = (elementBottomPlayerY + player.speed)/gp.tileSize;
			tileOne = gp.tileM.mapTileNum[elementLeftCol][elementBottomRow];
			tileTwo = gp.tileM.mapTileNum[elementRightCol][elementBottomRow];
			
			if(gp.tileM.tile[tileOne].collision == true || gp.tileM.tile[tileTwo].collision == true) {
				player.collisionOn = true;
			}
			
			break;
			
		case 12:
			
			elementLeftCol = (elementLeftPlayerX - player.speed)/gp.tileSize;
			tileOne = gp.tileM.mapTileNum[elementLeftCol][elementTopRow];
			tileTwo = gp.tileM.mapTileNum[elementLeftCol][elementBottomRow];
			
			if(gp.tileM.tile[tileOne].collision == true || gp.tileM.tile[tileTwo].collision == true) {
				player.collisionOn = true;
				
			}

			break;
			
		}
		
	}
	
	public int checkObject(Player element, boolean player) {
		
		int index = 999;
		
		for(int i = 0; i < gp.objects.size(); i++) {
			
			element.solidArea.x = element.x + element.solidArea.x;
			element.solidArea.y = element.y + element.solidArea.y;
			
			gp.objects.get(i).solidArea.x = gp.objects.get(i).x + gp.objects.get(i).solidArea.x;
			gp.objects.get(i).solidArea.y = gp.objects.get(i).y + gp.objects.get(i).solidArea.y;
			
			switch(element.direction) {
			case 0:
				element.solidArea.y -= element.speed;
				if(element.solidArea.intersects(gp.objects.get(i).solidArea)) {
					if(player) { index = i; }
				}
				break;
			case 4:
				element.solidArea.x += element.speed;
				if(element.solidArea.intersects(gp.objects.get(i).solidArea)) {
					if(player) { index = i; }
				}
				break;
			case 8:
				element.solidArea.y += element.speed;
				if(element.solidArea.intersects(gp.objects.get(i).solidArea)) {
					if(player) { index = i; }
				}
				break;
			case 12:
				element.solidArea.x -= element.speed;
				if(element.solidArea.intersects(gp.objects.get(i).solidArea)) {
					if(player) { index = i; }
				}
				break;
			}
			
			element.solidArea.x = element.solidAreaDefaultX;
			element.solidArea.y = element.solidAreaDefaultY;
			gp.objects.get(i).solidArea.x = gp.objects.get(i).solidAreaDefaultX;
			gp.objects.get(i).solidArea.y = gp.objects.get(i).solidAreaDefaultY;
			
		}
		
		return index;
	}
				
}
