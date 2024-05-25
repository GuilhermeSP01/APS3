package main;

import java.util.Random;

import obj.Glass;
import obj.Organic;
import obj.Paper;
import obj.Plastic;
import obj.Trash;

public class InitObject {

	GamePanel gp;
	
	public InitObject(GamePanel gp) {
		this.gp = gp;
	}

	public Trash newObj() {
		Random random = new Random();
		int type = random.nextInt(4);
		int coordsY = random.nextInt(6);
		int x = 0, y = 0;
		int[][] coordsX = {{9, 28}, 
				{14, 18, 19, 23, 28}, 
				{18, 23, 27, 32, 37},
				{9, 14, 19, 28},
				{18, 23, 27, 28, 32}, 
				{18, 37}};
		
		switch(coordsY) {
		case 0:	y = 5;	break;
		case 1:	y = 11;	break;
		case 2:	y = 16;	break;
		case 3:	y = 17;	break;
		case 4:	y = 22;	break;
		case 5:	y = 28;	break;
		}
		
		x = coordsX[coordsY][random.nextInt(coordsX[coordsY].length)];
		
		switch(type) {
		case 0:	return new Plastic(gp.tileSize * x, gp.tileSize * y);
		case 1:	return new Paper(gp.tileSize * x, gp.tileSize * y);
		case 2:	return new Organic(gp.tileSize * x, gp.tileSize * y);
		case 3:	return new Glass(gp.tileSize * x, gp.tileSize * y);
		}
		
		return new Trash();
		
	}
}
