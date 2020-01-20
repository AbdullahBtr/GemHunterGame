package window;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	
	
	
	public Window( int w, int h,Game game) {
	game.setPreferredSize(new Dimension(w,h));
	game.setMaximumSize(new Dimension(w,h));
	game.setMinimumSize(new Dimension(w,h));
		
	
	JFrame frame= new JFrame();
	frame.add(game);
	frame.pack();
	frame.setTitle("Gem Hunter 1.0");
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	
	game.start();
	}

}
