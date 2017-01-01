package JavaPro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class CompPaddle extends Objects {

Handler hand;
	
	public CompPaddle(int x, int y, ID id, Handler hand) {
		super(x, y, id);
		this.hand = hand;
		//velY=30;
		
	}
	public Rectangle getBounds(){
		return new Rectangle(x,y,32,128);
	}	//getBounds
	


	public void update() {
		//updates or loops through the object
		//this changes the position of the object
		y += velY;//increments y by what ever we have set velX to be
		
		for(int i = 0; i < hand.gameObject.size(); i++){
			
			Objects tempGameObject = hand.gameObject.get(i);
		
			if( tempGameObject.getId() == ID.Ball){
			  
				if(tempGameObject.y <y && y>=0)//if y is less than y of Ball or the ball is higher on screen than the computer paddle
					velY--;//go up
				//if ball is stuck on paddle
				else if(tempGameObject.y == y && tempGameObject.x == x && y>=0)
					velY--;
				else if(tempGameObject.y == y && tempGameObject.x == x && y <= Game.HEIGHT  -175)
					velY++;
				else if (tempGameObject.y >y && y <= Game.HEIGHT  -150 )//if y is greater than y of Ball 
					//or the ball is lower than the computer paddle
					velY++;//go down
				}//if
			
		}//for
		if( y <= 0 || y >= Game.HEIGHT  -150 ){
			velY =0;
			
		}
		if(y <= 0 && velY==0)
		{
			velY++;
		}
		if(y >= Game.HEIGHT  -150 && velY==0)
		{
			velY--;
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

