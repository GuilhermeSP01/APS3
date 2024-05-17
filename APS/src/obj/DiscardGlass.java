package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class DiscardGlass extends Trash {
	
	public void ObjDiscardGlass() {
		
		type = "dGlass";
		try {
			image = ImageIO.read(getClass().getResourceAsStream(""));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
