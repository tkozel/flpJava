package fim.fpb.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import fim.fpb.model.GameConfig;

/**
 * Drawing thread
 * @author tom
 *
 */
public class DrawingThread extends Thread {
	private FlCanvas canvas;
	private boolean stopped;
	
	public DrawingThread(FlCanvas canvas) {
		this.canvas = canvas;
	}
	
	public void finish() {
		stopped = true;
	}
	
	@Override
	public void run() {
		Graphics2D g = canvas.getGraph();
		byte spriteIndex = 0;
		List<Image> birds = GameConfig.getInstance().getBirdSprites();
		while (!stopped) {
			synchronized (g) {
				g.drawImage(birds.get(spriteIndex++ % 2), 100, 100, canvas);
				if (spriteIndex<0) spriteIndex = 0;
				canvas.repaint();
			}
			
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
