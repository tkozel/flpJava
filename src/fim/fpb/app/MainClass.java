package fim.fpb.app;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fim.fpb.gui.MainWindow;

public class MainClass {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			JFrame f = new MainWindow();
			f.setVisible(true);
		});
	}

}
