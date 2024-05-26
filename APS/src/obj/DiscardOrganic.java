package obj;

import java.io.IOException;

import javax.imageio.ImageIO;

public class DiscardOrganic extends Trash {
	
	public DiscardOrganic() {
	
		type = "dOrganic";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/t5.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
