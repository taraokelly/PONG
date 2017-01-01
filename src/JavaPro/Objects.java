package JavaPro;

import java.awt.Graphics;
import java.awt.Rectangle;

//abstract class 
//all of the objects within the game will inherit 
//the functions from the superclass 'Objects'
public abstract class Objects {
	//these protected variables can only be accessed
	//by the objects that inherits 'Objects'
	protected int x, y;//will assign these variables a value in the subclasses 
	protected ID id; //identification/character of object
	protected int velX, velY;
	
	//constructors to set variables
	public Objects(int x, int y, ID id){
		//set the variables in the Objects class to
		//the variables in the Objects constructor
		this.x = x;
		this.y = y;
		this.id = id;
	}
	//using these abstract constructors in the subclasses
	//e.g player class
	public abstract void update();
	public abstract void go(Graphics g);
	public abstract Rectangle getBounds();
	
	
	//getters and setters to assign the variables value
	//setX
	public void setX(int x){
		this.x = x;
	}
	//setY
	public void setY(int y){
		this.y = y;
	}
	//getX
	public int getX(){
		return x;
	}
	//getY
	public int getY(){
		return y;
	}
	//setID
	public void setID(ID id){
		this.id = id;
	}
	//getID
	public ID getId(){
		return id;
	}
	//setVelX
	public void setVelX(int velX){
		this.velX = velX;
	}
	//setVelY
	public void setVelY(int velY) {
		this.velY = velY;
	}
	//getVelX
	public int getVelX() {
		return velX;
	}
	//getVelY
	public int getVelY(){
		return velY;
	}
}
