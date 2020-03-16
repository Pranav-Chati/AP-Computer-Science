package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class RSGame extends JPanel{
	
	
	public RSGame(Color backColor) {
		setBackground(backColor); //change so that it inputs an image
		//addKeyListener(new Movement());		
		addMouseListener(new PanelListener());
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//adding the backgorund to the pane
			Image img = null;
			try {
			    File pathToFile = new File("F:/gbackground.png");
			    img = ImageIO.read(pathToFile);
			} catch (IOException ex) {
			    ex.printStackTrace();
			}
	        g.drawImage(img,0,0,this);
        
        
		//adding the barriers and like the maze
			g.fillRect(200, 0, 5, 30);
			g.fillRect(105,30, 100,5);
			g.fillRect(150,220, 5, 80);
			g.fillRect(80,220, 70, 5);
			g.fillRect(80,130,5,90);
			g.fillRect(20,150,5, 70);
			g.fillRect(150,80,5,50);
			g.fillRect(150,100,50,5);
			g.fillRect(150,100,5,70);
	}
	
	public class PanelListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			System.out.println("Hello");
		}
	}

//	 public class Movement implements KeyListener {
//		
//	 }

	 public void keyPressed(KeyEvent e) {
         System.out.println("Hi");

			 if(e.getKeyCode() == KeyEvent.VK_A){
		            System.out.println("Hi");
		        }
		}
	
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	 
}
