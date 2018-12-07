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
	
	boolean blnDown = false;
	boolean blnUp = false;
	boolean blnP1Moves = false;
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
		if(intBallX == 50){
			blnP1Hit = true;
			blnP2Hit = false;
		}
		if(intBallX == 650){
			blnP2Hit = true;
			blnP1Hit = false;
		}
		
		//ball moves
		if(blnP1Moves && intBallX >= 65 && intBallX<=630){
			if((intBallY >= intBar1Y || intBallY+30 <= intBar1Y+30)){
				intBallX = intBallX + 3;
			}
			//else if((intBallY >= intBar2Y || intBallY+30 <= intBar2Y+30)){
			//	intBallX = intBallX - 3;
			//}
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
		if(blnDown && blnP1Moves){
			intBar1Y = intBar1Y + 3;;
		}
		if(blnUp && blnP1Moves){
			intBar1Y = intBar1Y - 3;
		}
		
	}
	//Constructor
	public AnimationPanelPong(){
		super();
	}
}
