import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class AnimationPanelPong extends JPanel{
	//Properties
	int intBar1Y = 300;
	int intBar2Y = 300;
	int intBallX = 65;
	int intBallY = 330;
	
	int intP1Point = 0;
	int intP2Point = 0;
	
	boolean blnDown = false;
	boolean blnUp = false;
	boolean blnGame = false;
	boolean blnP1Hit = false;
	boolean blnP2Hit = false;
	
	
	//Methods
	public void paintComponent(Graphics g){
		
		//player coordinates
		if(intBar1Y > 630){
			intBar1Y = 630;
		}
		else if(intBar1Y<0){
			intBar1Y = 0;
		}
		if(intBar2Y > 630){
			intBar2Y = 630;
		}	
		else if(intBar2Y<0){
			intBar2Y = 0;
		}
		
		//possibility to hit
		if(intBallX == 65){
			blnP2Hit = false;
			blnP1Hit = true;
			
		}
		else if(intBallX == 630){
			blnP1Hit = false;
			blnP2Hit = true;
		}
		
		/*if(intBallY == 30){
			intBallY = intBallY + 5;
		}
		if(intBallY == 670){
			intBallY = intBallY - 5;
		}*/
		
		if(blnP1Hit){
			intBallX = intBallX + 5;
			//intBallY = intBallY + 5;
		}
		if(blnP2Hit){
			intBallX = intBallX - 5;
			//intBallY = intBallY - 5;
		}
		
		//screen
		g.setColor(Color.BLACK);
		g.fillRect(0,0,700,700);
		
		//players
		g.setColor(Color.WHITE);
		//-PLAYER 1
		g.fillRect(50,intBar1Y,15,70);
		//-PLAYER 2	
		g.fillRect(650,intBar2Y,15,70);
		
		//ball
		g.fillOval(intBallX, intBallY, 30,30);
		
		
		//player movements
		if(blnDown){
			intBar1Y = intBar1Y + 3;
		}
		if(blnUp){
			intBar1Y = intBar1Y - 3;
		}
		
	}
	//Constructor
	public AnimationPanelPong(){
		super();
	}
}
