package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Menu {
	static JPanel panel;
	
	public static void main(String[] args) throws IOException, FontFormatException{
		JFrame playg = new JFrame("Gun Game"); //playg is the frame that allows to either play the game or see the top ten list
		playg.setSize(300,300);
		playg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//instantiating objects used
			panel = new JPanel(); //the panel
			panel.setBorder(new EmptyBorder(new Insets(10, 50, 50, 50)));
			panel.setBackground(Color.black);//Color is black - set this to an image tho
		
		//add background to game
			ImageIcon img = new ImageIcon("F:/background.jpg");
			JLabel background = new JLabel("", img, JLabel.CENTER);
			background.setBounds(0, 0,300, 300);panel = new JPanel(); //the panel
			panel.setBorder(new EmptyBorder(new Insets(10, 50, 50, 50)));
			panel.setBackground(Color.black);//Color is black - set this to an image tho
			
		//objects used by user
			JButton btnPlay = new JButton("Play");
			JButton btnTop = new JButton("Top Ten");
			JButton btnQuit = new JButton("Quit");
			JLabel lblLogo = new JLabel("DUNGEON");
			
		//buttons - sizing
			btnPlay.setPreferredSize(new Dimension(200, 40));
			btnTop.setPreferredSize(new Dimension(200,40));
			btnQuit.setPreferredSize(new Dimension(200, 40));
			
		//label - making the font size and font
			File filen = new File("F:/Peepo.ttf"); //must change this file path when transferred
			Font pixels = Font.createFont(Font.TRUETYPE_FONT, filen);
			lblLogo.setFont(pixels);
			lblLogo.setFont(lblLogo.getFont().deriveFont(60f));	
			lblLogo.setForeground(Color.white);


		//adding objects used by user to panel
			panel.add(lblLogo,  Component.CENTER_ALIGNMENT);
			panel.add(btnPlay, Component.CENTER_ALIGNMENT);
			panel.add(btnTop,  Component.CENTER_ALIGNMENT);
			panel.add(btnQuit,  Component.CENTER_ALIGNMENT);
			playg.add(panel);
			playg.setVisible(true);
			playg.setResizable(false);
			
		//Add listeners	
			btnQuit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});

			btnTop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//calls the file class
				}
			});
			
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFrame game = new JFrame("Gun Game");
					game.setSize(500,500);
					game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					//instantiating the classes
						Game gameb = new Game(Color.black);
					//changing the visibility
						game.add(gameb);
						
						playg.setVisible(false);
						game.setVisible(true);
						game.setResizable(false);
				}
			});
	}	
	
}