package fim.fpb.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;


public class MainWindow extends JFrame {
	
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
		
	}
	
	
}
