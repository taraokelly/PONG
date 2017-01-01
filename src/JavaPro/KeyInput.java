package JavaPro;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	//create an instance of the handler class
	private Handler handler;
	
	public KeyInput(Handler handler){
		//game.addKeyListener(this);
		this.handler = handler;
		//whatever is put into the constructor handler will 
		//be equal to the instance of the handler class
	}
	public void keyPressed(KeyEvent e){
		//creating variable key
		//setting the variable to a letter binding
		int key= e.getKeyCode();
		//when you press a key on keyboard 
		//it will get the number value corresponding with the letter
		// create a for loop to loop through all of the objects in the game
		for(int i = 0; i < handler.gameObject.size(); i++){
			
			Objects tempGameObject = handler.gameObject.get(i);
		
			if( tempGameObject.getId() == ID.Player){
				//key events for player 
				
				if(key == KeyEvent.VK_W)tempGameObject.setVelY(-30);
				if(key == KeyEvent.VK_S)tempGameObject.setVelY(30);

			
					//collider
					if(tempGameObject.y <0)
					{
						if(key == KeyEvent.VK_W)tempGameObject.setVelY(0);
					}
					if(tempGameObject.y >= Game.HEIGHT  -178)
					{
						if(key == KeyEvent.VK_S)tempGameObject.setVelY(0);
					}
			}	
			if(tempGameObject.getId() ==ID.Player2){
				//key events for player 2
				
				if(key == KeyEvent.VK_UP)tempGameObject.setVelY(-30);
				if(key == KeyEvent.VK_DOWN)tempGameObject.setVelY(30);
			
				//collider
				if(tempGameObject.y <0)
				{
					if(key == KeyEvent.VK_UP)tempGameObject.setVelY(0);
				}
				if(tempGameObject.y >= Game.HEIGHT  -178)
				{
					if(key == KeyEvent.VK_DOWN)tempGameObject.setVelY(0);
				}//if
				
			}//if
		}//for
		
		if (Game.gameOver==true)
		{
			if(key == KeyEvent.VK_ENTER)new MainMenu();
		}
	}
	public void keyReleased(KeyEvent e){
		int key= e.getKeyCode();
		//when you press a key on keyboard 
		//it will get the number value corresponding with the letter
		// create a for loop to loop through all of the objects in the game
		for(int i = 0; i < handler.gameObject.size(); i++){
			
			Objects tempGameObject = handler.gameObject.get(i);
		
			if( tempGameObject.getId() == ID.Player){
				//key events for player 
				
				if(key == KeyEvent.VK_W)tempGameObject.setVelY(0);
				if(key == KeyEvent.VK_S)tempGameObject.setVelY(0);
				
			}	
			if(tempGameObject.getId() ==ID.Player2){
				//key events for player 2
				
				if(key == KeyEvent.VK_UP)tempGameObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN)tempGameObject.setVelY(0);

				
			}
		
		}
	}
}
