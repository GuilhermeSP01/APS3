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
		int n = random.nextInt(4);
		int coords = random.nextInt(2);
		int x = 0, y = 0;
		
		switch(coords) {
		case 0:
			x = 12;
			y = 4;
			break;
		case 1:
			x = 12;
			y = 8;
		}
		
		switch(n) {
		case 0:
			return new Plastic(gp.tileSize * x, gp.tileSize * y);
		case 1:
			return new Paper(gp.tileSize * x, gp.tileSize * y);
		case 2:
			return new Organic(gp.tileSize * x, gp.tileSize * y);
		case 3:
			return new Glass(gp.tileSize * x, gp.tileSize * y);
		}
		
		return new Trash();
		
	}
}
