package JavaPro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Objects {
	

	public Ball(int x, int y, ID id) {
		super(x, y, id);
		velX = 11;
		velY = 11;
		
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,32,32);
	}	

	
	public void update() {
		
		x += velX;
		y += velY;
		
		
		if( y <= 0 || y >= Game.HEIGHT  -48 ){
			velY *= -1;
		}
		if( x <= 0 || x >= Game.WIDTH  -34){
			velX *= -1;
		}
		

	}

	
	public void go(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.white);
		g.fillOval(x, y, 32, 32);
		

	}

}
