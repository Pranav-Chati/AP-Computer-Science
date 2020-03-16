package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LSGame extends JPanel{
	public LSGame(Color backColor) {
		setBackground(backColor); //change so that it inputs an image
		//ddKeyListener(new Movement());	
		
	}
	
	public void paintComponent(Graphics g) {
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
			g.fillRect(100, 0, 5, 30);
			g.fillRect(100,30, 100,5);
			g.fillRect(150,220, 5, 80);
			g.fillRect(150,220, 70, 5);
			g.fillRect(220,130,5,90);
			g.fillRect(270,150,5, 70);
			g.fillRect(150,80,5,50);
			g.fillRect(100,100,50,5);
			g.fillRect(150,100,5,70);
			
	}
	
	
}
