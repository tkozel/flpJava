package fim.fpb.gui;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.List;

import fim.fpb.model.Direction;
import fim.fpb.model.GameConfig;

/**
 * Drawing thread
 * @author tom
 *
 */
public class DrawingThread extends Thread {
	private FlCanvas canvas;
	private boolean stopped;
	
	private Point pos = new Point(100,100);
	private Direction direction = Direction.STABLE;
	
	public DrawingThread(FlCanvas canvas) {
		this.canvas = canvas;
	}
	
	public void finish() {
		stopped = true;
	}
	
	@Override
	public void run() {
		Graphics2D g = canvas.getGraph();
		int spriteIndex = 0;
		List<Image> birds = GameConfig.getInstance().getBirdSprites();
		while (!stopped) {
			synchronized (g) {
				switch (direction) {
				case UP:  pos.y--;break;
				case DOWN:pos.y++;break;
				}
				
				g.drawImage(birds.get(spriteIndex++/100 % 2), pos.x, pos.y, canvas);
				if (spriteIndex<0) spriteIndex = 0;
				canvas.repaint();
				try {
					sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public Point getPos() {
		return pos;
	}

	public void moveDirection(Direction direction) {
		this.direction = direction;
	}
}
