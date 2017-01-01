package JavaPro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public class Player extends Objects {
	
	Handler hand;

	public Player(int x, int y, ID id, Handler hand) {
		super(x, y, id);
		this.hand = hand;
		//velX =1;
		//velY =5;
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,32,128);
	}	//getBounds
	


	public void update() {
		//updates or loops through the object
		//this changes the position of the object
		y += velY;//increments y by what ever we have set velX to be
		
		if( y <= 0 || y >= Game.HEIGHT  -178 ){
			velY *=0;
				
		}
		
		
		collider();
	}

	public void go(Graphics g) {
		
		Graphics2D g2 = (Graphics2D)g;
		g.setColor(Color.white);
		g.fillRect(x, y, 32, 128);
		
	}
	public void collider(){

		for (int i = 0 ; i < hand.gameObject.size(); i++){
			Objects obj =  hand.gameObject.get(i);
			
			if(obj.getId() == ID.Ball){
				if(getBounds().intersects(obj.getBounds())){

					obj.velX *= -1;
					obj.velY *= -1;
					
				
				}//if
			}//if
		}//for
	}//collide	
}




	
	

