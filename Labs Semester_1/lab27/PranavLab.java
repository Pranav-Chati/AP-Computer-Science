package lab27;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class PranavLab {
	public static void main(String[] args) {
		int ans;
		Scanner input = new Scanner(System.in);
		do {
		ans = 0;
			JFrame frame = new JFrame();
			frame.setTitle("Lab 2.7");
			frame.setSize(500,500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			
			Random randomG = new Random();
			int r = randomG.nextInt(256); //red
			int g = randomG.nextInt(256); //green
			int b = randomG.nextInt(256); //blue
			Color ranColorA = new Color(r, g, b);
			
			int r1 = randomG.nextInt(256); //red
			int g1 = randomG.nextInt(256); //green
			int b1 = randomG.nextInt(256); //blue
			Color ranColorB = new Color(r1, g1, b1);
			
			
			//Panels
			JPanel panel1 = new JPanel();
			panel1.setBackground(ranColorA);
			
			JPanel panel2 = new JPanel();
			panel2.setBackground(ranColorB);
			
			JPanel panel3 = new JPanel();
			panel3.setBackground(ranColorA);
			
			JPanel panel4 = new JPanel();
			panel4.setBackground(ranColorB);
			
			JPanel panel5 = new JPanel();
			panel5.setBackground(ranColorA);
			
			JPanel panel6 = new JPanel();
			panel6.setBackground(ranColorB);
			
			JPanel panel7 = new JPanel();
			panel7.setBackground(ranColorA);
			
			JPanel panel8 = new JPanel();
			panel8.setBackground(ranColorB);
			
			JPanel panel9 = new JPanel();
			panel9.setBackground(ranColorA);
			
	
			Container pane = frame.getContentPane();
			pane.setLayout(new GridLayout(3,3));	
			
			pane.add(panel1);
			pane.add(panel2);
			pane.add(panel3);
			pane.add(panel4);
			pane.add(panel5);
			pane.add(panel6);
			pane.add(panel7);
			pane.add(panel8);
			pane.add(panel9);
	
			
			frame.setVisible(true);
			
			System.out.println("Run Again? \n1-Yes\n2-No");
			ans = input.nextInt();
			
			if(ans ==1 )
			{
				frame.setVisible(false);
			}
		}while(ans == 1);
		
	}
}
