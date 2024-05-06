package obj;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Organic extends Trash{

	public Organic(int xPos, int yPos) {

		Random random = new Random();
		int n = random.nextInt(3);
		
		
		x = xPos;
		y = yPos;
		type = "Organic";
		try { 
			switch(n) {
			case 0:
				image = ImageIO.read(getClass().getResourceAsStream("/objects/organic1.png"));
				break;
			case 1:
				image = ImageIO.read(getClass().getResourceAsStream("/objects/organic2.png"));
				break;
			case 2:
				image = ImageIO.read(getClass().getResourceAsStream("/objects/organic3.png"));
				break;
			} 
		} catch(IOException e) { e.printStackTrace(); }
		
	}

}
