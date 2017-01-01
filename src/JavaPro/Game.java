package JavaPro;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -8939420250553115237L;
//make player2

//change controller

	
	static final int HEIGHT = 800;
	private Thread thread;//single thread for game
	private boolean run = false;//not running
    static final int WIDTH =1000;	
    private Handler handler;//create an instance of the handler
	//private Score score;
    private int p1Score=0;
    private int p2Score=0;
    static boolean bonus;
    static boolean singlePlayer;
    public static boolean gameOver;
	
	
	public Game(){
		
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		//tells the game there will be key input in the game
		new Screen(WIDTH, HEIGHT, "Tara O'Kelly - PONG", this); //setting the width and height to the static variables already initialized
		
		
		handler.addGameObject(new Player(10, 400,ID.Player,handler));
		handler.addGameObject(new Ball(375,680,ID.Ball));
		if (bonus==true)
		{
			handler.addGameObject(new Ball(870,380,ID.Ball));

		}
		if (!singlePlayer==true)
		handler.addGameObject(new Player2(950, 400,ID.Player2,handler));
		else
		handler.addGameObject(new CompPaddle(950, 400,ID.CompPaddle,handler));
		
		
			
	}
	
		
	
	
	public synchronized void start(){
		//start up the thread for the game
		thread=new Thread(this);//this thread referring to the game(where the new thread will be ran)
		thread.start();//start with the thread
		run = true;
		gameOver = false;
	}
	public synchronized void stop (){
		try{                          
			thread.join();       //try shut down 
			run = false;
		}
		catch(Exception e){		 //if not:
			e.printStackTrace(); //tells us why the code is not working(prints the error)
		}

}
	public void run(){
	
		this.requestFocus();
	long lastTime = System.nanoTime();													// also request the focus of windows to allow instant input
	double amountOfTicks = 60.0;
	double ns = 1000000000 / amountOfTicks;
	double delta = 0;
	long timer = System.currentTimeMillis();
	int frames = 0;
	
	while(run){ 																	// Game loop while running remains true
		long now = System.nanoTime();													// Create a time called now		
		delta += (now - lastTime) / ns;													// To Delta add (now minus lastTime) divided by ns
		lastTime = now;																	// lastTime will be set to now
																						//the above lines controls the speed which the game runs
		while(delta >= 1){																// Inner loop while delta is greater than or equals 1
			update();																		// Call the tick method
			delta--;																	// decrement delta
		}//inner while 
																						// Above will call an update if delta is >=1 and then decrement delta by 1
		if(run){																	
			go();																	
		}//if running call go
		frames++;																		// increment frames by 1
		
		if(System.currentTimeMillis() - timer > 1000){									// If the currentTime minus the timer is greater than 1000
			timer +=1000;																// add 1000 onto the timer
			//System.out.println("FPS: " + frames);
			// display the Frames per second
			frames = 0;																	// set the frames to 0
		}
	}
	stop();
	}
		//game loop
		
	public void setScore1(int p1Score)
	{
		this.p1Score=p1Score;
	} 
	public void setScore2(int p2Score)
	{
		this.p2Score=p2Score;
	} 
	public int getScore1()
	{
		return p1Score;
		
	}
	public int getScore2()
	{
		return p2Score;
	}
	
	private void update(){
		handler.update();
		
		//call the handler's method from inside the update method
		
		for(int i = 0; i < handler.gameObject.size(); i++){
			
			Objects tempGameObject = handler.gameObject.get(i);
		
			if( tempGameObject.getId() == ID.Ball){
				if(tempGameObject.getX()<=0)
					//this.p2Score++;
					p2Score++;
					
				else if(tempGameObject.getX()>=966)
					//this.p1Score++;
					p1Score++;
				}
			}
	}
	
	private void go() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null){
			this.createBufferStrategy(3);//creates buffers
			return;
			
		}
	Graphics g = bs.getDrawGraphics();
	
	g.setColor(Color.black);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	g.setColor(Color.yellow);
	int fontSize =20;
	Font F = new Font("Impact",Font.BOLD, fontSize);
	g.setFont(F);
	g.drawString("Player 1 : "+p1Score, 50, 50);
	g.drawString("Player 2 : " +p2Score, 840, 50);
	g.setColor(Color.white);
	int titleFontSize =60;
	Font Title = new Font("Impact",Font.BOLD, titleFontSize);
	g.setFont(Title);
	g.drawString("PONG", 410, 70);
	
	if (p1Score>= 10 || p2Score>=10)
	{
		gameOver = true;
		
		for(int i = 0; i < handler.gameObject.size(); i++){
			
			Objects tempGameObject = handler.gameObject.get(i);
		
			if( tempGameObject.getId() == ID.Player){
				this.handler.removeGameObject(tempGameObject);
				}
			
			if( tempGameObject.getId() == ID.Player2){
				this.handler.removeGameObject(tempGameObject);
				}
			
			if( tempGameObject.getId() == ID.Ball){
				this.handler.removeGameObject(tempGameObject);
				}
			if( tempGameObject.getId() == ID.CompPaddle){
				this.handler.removeGameObject(tempGameObject);
				}
			
			}
		g.setColor(Color.red);
		int gOverSize =100;
		Font gOver = new Font("Impact",Font.BOLD, gOverSize);
		g.setFont(gOver);
		g.drawString("GAME OVER", 230, 300);
		g.setColor(Color.green);
		int gSize =30;
		Font gO = new Font("Impact",Font.BOLD, gSize);
		g.setFont(gO);
			if(p1Score>=10)
				g.drawString("Player 1 Wins!", 390, 400);
			else
				g.drawString("Player 2 Wins!", 390, 400);
			g.setColor(Color.white);
		g.drawString("Press Enter to Continue", 330, 600);
		
	}
	
	
	
	handler.go(g);
	//call the handler's method from inside the go method
	g.dispose();//gets rid of unnecessary stuff
	bs.show();//displays objects
	}//go


	public static void main(String[] args) {
		
		new MainMenu();
		//new Game();
	}
		

	
}
