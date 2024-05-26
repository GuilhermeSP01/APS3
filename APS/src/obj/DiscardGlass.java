package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class DiscardGlass extends Trash {
	
	public DiscardGlass() {
		
		type = "Glass";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/t5.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}
	
