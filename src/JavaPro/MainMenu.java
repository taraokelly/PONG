package JavaPro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MainMenu extends JFrame{
	

	private static final long serialVersionUID = 3931037139745287768L;
	JFrame frame;
	
	//public static boolean bonus;
	int screenHeight =400;
	int screenWidth =500;
	
	int buttonHeight = 80;
	int buttonWidth =200;
	
	JButton Play, Quit;
	JCheckBox bonusBall, singlePlayerGame;
	
	public MainMenu(){
		addButtons();
		addActions();
		
		getContentPane().setLayout(null);
		
		Play.setBounds((screenWidth - buttonWidth)/2, 50, buttonWidth, buttonHeight);//positions buttons
		Quit.setBounds((screenWidth - buttonWidth)/2, 150, buttonWidth, buttonHeight);//positions buttons
		bonusBall.setBounds((int) ((screenWidth - buttonWidth)/1.6), 280, buttonWidth, buttonHeight);//positions check box
		singlePlayerGame.setBounds((int) ((screenWidth - buttonWidth)/1.6), 230, buttonWidth, buttonHeight);
		
		//adding buttons
		
		getContentPane().add(Play);//Add the button to JFrame
		getContentPane().add(Quit);//Add the button to JFrame
		getContentPane().add(bonusBall);//Add the check box to the JFrame
		getContentPane().add(singlePlayerGame);//Add the check box to the JFrame
		
		//JFrame
		pack();//takes everything and packs it into the JFrame
		setVisible(true);//visible
		setLocationRelativeTo(null);//center
		setSize(screenWidth,screenHeight);//size
		setTitle("PONG");//title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
	}
	
	private void addButtons() {
		
		Play = new JButton("Play");
		Quit = new JButton ("Quit");
		bonusBall = new JCheckBox("Add Bonus Ball?");	
		singlePlayerGame = new JCheckBox("Single Player?");
		
	}
	
	public void addActions(){
		
		Play.addActionListener(new ActionListener(){//takes play button and adds a new action listener to the button
			public void actionPerformed(ActionEvent e){//turn the action performed to a variable for use
				dispose();//gets rid of JFrame
				
				if(bonusBall.isSelected())
				{	//bonus =true;
					Game.bonus = true;
				}
				else 
				{
					Game.bonus = false;
				}
				if(singlePlayerGame.isSelected())
				{
					Game.singlePlayer = true;
				}
				else
				{
					Game.singlePlayer = false;
				}
				
					Game game= new Game();
				
				//starts game
				//game.start();
			}
		});//play button
		
		Quit.addActionListener(new ActionListener(){//takes quit button and adds a new action listener to the button
			public void actionPerformed(ActionEvent e){//turn the action performed to a variable for use
				System.exit(0);//shut down program
			}
		});//quit button
	}
}
