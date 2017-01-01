package JavaPro;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Screen extends Canvas{

	
	private static final long serialVersionUID = 6595802056629421026L;

	public Screen(int width, int height, String title,Game game){
		JFrame frame = new JFrame(title);//set up the frame of the application with JFrame
		//set JFrame variable to frame
		//every time frame. is used frame. references the functions within JFrame 
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//to properly close and stop the game operations
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		frame.toFront();//position over other open applications
		game.start();//running start method
		
	}
	
	
	

}
