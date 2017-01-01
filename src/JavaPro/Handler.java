package JavaPro;

import java.awt.Graphics;
import java.util.LinkedList;
//this class will maintain and update all objects individually
public class Handler {
	//create a list for all the game objects
	LinkedList<Objects> gameObject = new LinkedList<Objects>();
	
	//loops and updates all of the game objects
	public void update(){
		//updates the objects
		for(int i = 0; i < gameObject.size(); i++){
			//creating a temporary gameObject
			Objects tempGameObject = gameObject.get(i);
			//setting the temporary object to a function within
			//the linked list with allows us to get the ID of what ever 
			//object we are at
			tempGameObject.update();		
		}
	}
	public void go(Graphics g){
		//makes or implements the game objects
		for(int i = 0; i < gameObject.size(); i++){
			
		Objects tempGameObject = gameObject.get(i);
		
		tempGameObject.go(g);	
		}
	}
	//function to add objects to the list using dot add operator
	public void addGameObject(Objects gameObject){
		this.gameObject.add(gameObject);
		}
	//function to remove objects from the list using the dot remove operator
	public void removeGameObject(Objects gameObject){
		this.gameObject.remove(gameObject);
	}
	//these functions will handle adding and removing objects to the list

}
