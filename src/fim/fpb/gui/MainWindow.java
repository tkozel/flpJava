package fim.fpb.gui;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import fim.fpb.model.Direction;


public class MainWindow extends JFrame {
	
	private DrawingThread drawingThread;

	public MainWindow() {
		super("Flappy Bird - sample game application");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initGui();
		
		setSize(800,600);
		setLocationRelativeTo(null);
	}

	private void initGui() {
		FlCanvas canv =  new FlCanvas(800,600);
		add(new JScrollPane(canv),BorderLayout.CENTER);
		drawingThread = new DrawingThread(canv);
		drawingThread.start();
		
		addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_UP: drawingThread.moveDirection(Direction.UP);break;
					case KeyEvent.VK_DOWN: drawingThread.moveDirection(Direction.DOWN);break;
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_UP: 
					case KeyEvent.VK_DOWN: drawingThread.moveDirection(Direction.STABLE);break;
				}
			}
		});
	}
	
	
}
