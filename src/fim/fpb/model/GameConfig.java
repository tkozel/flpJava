package fim.fpb.model;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class GameConfig {
	private static GameConfig _instance=null;
	private List<Image> birdSprites;
	
	protected GameConfig() {
		birdSprites = new ArrayList<>();
		try {
			birdSprites.add(ImageIO.read(getClass().getResource("/fl1.png")));
			birdSprites.add(ImageIO.read(getClass().getResource("/fl2.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static GameConfig getInstance() {
		if (_instance == null) {
			_instance = new GameConfig();
		}
		return _instance;
	}
	
	public List<Image> getBirdSprites() {
		
		
		return birdSprites;
	}

}
