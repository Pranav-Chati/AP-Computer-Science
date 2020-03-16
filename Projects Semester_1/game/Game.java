package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Game extends JPanel {
	public Game(Color backColor) {
		setBackground(backColor); //change so that it inputs an image
		//addKeyListener(new Movement());		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Image img = null;
		try {
		    File pathToFile = new File("F:/background.png");
		    img = ImageIO.read(pathToFile);
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
        g.drawImage(img,0,0,this);
        
        
	}
}
