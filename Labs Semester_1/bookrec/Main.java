package bookrec;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Main {
	public static void main(String[] args) {
	
		
		JFrame gui = new JFrame("Book Recommendation");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(500,500);
		
		JPanel panel = new JPanel(); //the panel
		panel.setBorder(new EmptyBorder(new Insets(10, 50, 50, 50)));
		panel.setBackground(Color.gray);//Color is black - set this to an image tho		
		
		
		JList lstReaders = new JList();
		
		
		
		gui.add(panel);
		gui.setResizable(false);
		gui.setVisible(true);
		
	}
}
