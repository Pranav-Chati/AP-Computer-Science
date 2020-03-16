package lab27;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension; //used for sizing the buttons
import java.awt.GridLayout;
//import java.awt.event.MouseListener; //not used but commented out for reference

import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Random;
import javax.swing.JPanel;

import java.lang.*;
import java.util.Scanner;
public class Tester {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int ans;
		do{
		JFrame frame = new JFrame();
		frame.setTitle("Lab 2.7");
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		//Panels
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.black);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.white);
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.gray);
		
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.black);
		
		JPanel panel6 = new JPanel();
		panel6.setBackground(Color.white);
		
		JPanel panel7 = new JPanel();
		panel7.setBackground(Color.black);
		
		JPanel panel8 = new JPanel();
		panel8.setBackground(Color.gray);
		
		JPanel panel9 = new JPanel();
		panel9.setBackground(Color.white);
		
		JPanel panel10 = new JPanel();
		panel10.setBackground(Color.black);
		
		JPanel panel11 = new JPanel();
		panel11.setBackground(Color.white);
		
		JPanel panel12 = new JPanel();
		panel12.setBackground(Color.gray);
		
		
		panel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				panel1.setBackground(Color.red);
			}
		});
		
		
		
		//buttons to panel 8 to control the colors
		JButton rand = new JButton("Random");
		JButton norm = new JButton("Normal");
		
		panel8.add(norm);	//black and white
		panel8.add(rand);	//black and white are random colors	

        norm.setPreferredSize(new Dimension(100, 25));
        rand.setPreferredSize(new Dimension(100,25));

		norm.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				//the user decides to normalize the board again, it will change
				// the panels back to black and white
				panel1.setBackground(Color.white);
				panel2.setBackground(Color.black);
				panel3.setBackground(Color.white);
				panel5.setBackground(Color.black);
				panel6.setBackground(Color.white);
				panel7.setBackground(Color.black);
				panel9.setBackground(Color.white);
				panel10.setBackground(Color.black);
				panel11.setBackground(Color.white);
			}
		});
		
		rand.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        //System.out.println("You clicked the button, using a MouseListenr");
				//this next lines of code add random numbers to r, g, and b
				//which corresponds to the RGB of the color
				Random randomG = new Random();
				int r = randomG.nextInt(256); //red
				int g = randomG.nextInt(256); //green
				int b = randomG.nextInt(256); //blue
				Color ranColorA = new Color(r, g, b);

				int r1 = randomG.nextInt(256); //red
				int g1 = randomG.nextInt(256); //green
				int b1 = randomG.nextInt(256); //blue
				Color ranColorB = new Color(r1, g1, b1);
				
		    	panel1.setBackground(ranColorA);
				panel2.setBackground(ranColorB);
				panel3.setBackground(ranColorA);
				panel5.setBackground(ranColorB);
				panel6.setBackground(ranColorA);
				panel7.setBackground(ranColorB);
				panel9.setBackground(ranColorA);
				panel10.setBackground(ranColorB);
				panel11.setBackground(ranColorA);
		    
		    }
		});
		

		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(3,4));	
		
		pane.add(panel1);
		pane.add(panel2);
		pane.add(panel3);
		pane.add(panel4);
		pane.add(panel5);
		pane.add(panel6);
		pane.add(panel7);
		pane.add(panel8);
		pane.add(panel9);
		pane.add(panel10);
		pane.add(panel11);
		pane.add(panel12);
		
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
