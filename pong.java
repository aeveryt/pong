import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pong implements ActionListener, KeyListener, MouseListener{
	//Properties
	JFrame frame;
	AnimationPanelPong panel;
	Timer timer;
	
	//Methods
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == timer){
			panel.repaint();
		}
	}
	
	public void keyReleased(KeyEvent evt){
		if(evt.getKeyCode() == 38){
			panel.blnP1Moves = true;
			panel.blnUp = false;
		}
		else if(evt.getKeyCode() == 40){
			panel.blnP1Moves = true;
			panel.blnDown = false;
		}
	}
	
	public void keyPressed(KeyEvent evt){
		if(evt.getKeyCode() == 38){
			panel.blnP1Moves = true;
			panel.blnUp = true;
		}
		else if(evt.getKeyCode() == 40){
			panel.blnP1Moves = true;
			panel.blnDown = true;
		}
	}
	
	public void keyTyped(KeyEvent evt){
	}
	
	public void mouseMoved(MouseEvent evt){
	}
	
	public void mouseDragged(MouseEvent evt){
	}
	
	public void mouseExited(MouseEvent evt){
	}
	
	public void mouseEntered(MouseEvent evt){
	}
	
	public void mouseReleased(MouseEvent evt){
		panel.intBar2Y = evt.getY();	
	}
	
	public void mousePressed(MouseEvent evt){
		panel.intBar2Y = evt.getY();
	}
	
	public void mouseClicked(MouseEvent evt){
		panel.intBar2Y = evt.getY();
	}
	
	//Constructor
	public pong(){
		frame = new JFrame();
		panel = new AnimationPanelPong();
		
		//set panel
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(700,700));
		panel.addMouseListener(this);
		
		//frame
		frame.addKeyListener(this);
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		//timer
		timer = new Timer (1000/60, this);
		timer.start();
	}
	
	//Main Method
	public static void main (String [] args){
		new pong();
	}	
}
