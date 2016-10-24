package fim.fpb.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

/**
 * Graphical canvas with BufferedImage
 * @author kozelto1
 *
 */
public class FlCanvas extends JComponent {
	private BufferedImage img;
	private Graphics2D graph;
	
	public FlCanvas(int width, int height) {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		graph = (Graphics2D) img.getGraphics();
		graph.setColor(Color.WHITE);
		graph.fillRect(0, 0, width, height);
		graph.setColor(Color.LIGHT_GRAY);
		graph.drawString("Flappy Canvas", 0, 20);
		Dimension dimension = new Dimension(width, height);
		setMinimumSize(dimension);
		setPreferredSize(dimension);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		((Graphics2D)g).drawImage(img, 0, 0, this);
	}
	
}
