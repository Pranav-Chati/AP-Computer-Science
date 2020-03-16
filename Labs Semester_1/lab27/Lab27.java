package lab27;

/*
 * Name:Pranav Chati
 * Date of Completetion/Graded:8/27/2019
 * Description: This is the program the lab 2.7 that will give 14/10 points on your lab
 * The extra-credit is from the the dimensions(array of inputs) and 
 */
import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension; //used for sizing the buttons
//import java.awt.GridLayout;
////import java.awt.event.MouseListener; //not used but commented out for reference
//
//import java.util.concurrent.TimeUnit;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import java.util.Random;
//import javax.swing.JPanel;

public class Lab27 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int dim; //dimensions
		int choice; //this is the choice for the menu
		int i; //counter
		int ans; //this is for the while loop at the end
		
		
		do
		{	
			System.out.print("What do you want your dimensions to be?");
			dim = input.nextInt();
			System.out.println("1-Normal\n2-Random Colors");
			choice = input.nextInt();
			
			
			//this is the main frame
			JFrame frame = new JFrame();
			frame.setTitle("Lab 2.7");
			frame.setSize(dim*100,dim*100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);

			
		     
				//this is the panel of the arrays being created
				JPanel[] panel = new JPanel[dim*dim];
				
				
				//this is needed to set each panel
				for (i=0; i<(dim*dim); i++)
				{
					panel[i]= new JPanel();
				}
				
				
				Random randomG = new Random();
				int r = randomG.nextInt(256); //red
				int g = randomG.nextInt(256); //green
				int b = randomG.nextInt(256); //blue
				Color ranColorA = new Color(r, g, b);

				int r1 = randomG.nextInt(256); //red
				int g1 = randomG.nextInt(256); //green
				int b1 = randomG.nextInt(256); //blue
				Color ranColorB = new Color(r1, g1, b1);
				
				if(choice == 1)
				{
					if((dim%2)!=0) //this is if the dimensions are odd
					{
						//this is adding each of the colors
						for(i=0;i<(dim*dim);i++)
						{
							if((i%2)==0)
							{
								panel[i].setBackground(Color.white);
							}
							else
							{
								panel[i].setBackground(Color.black);
							}
						}			
					}
					else //this is when the dimensions are even
					{
						
					}
				}
				else
				{
					if((dim%2)!=0) //odd
					{
						
						for(i=0;i<(dim*dim);i++)
						{
							if((i%2)==0)
							{
								panel[i].setBackground(ranColorA);
							}
							else
							{
								panel[i].setBackground(ranColorB);
							}
						}	
						
					} else { //even
						if (dim % 2 == 0) { //case even dim
						    for (i = 0; i < dim*dim; i++) {
						    JPanel newPanel = new JPanel();
						    if(((Math.floor(i/dim)) % 2) == 0) { //odd row
						    if(i % 2 == 0) {
						       	 newPanel.setBackground(ranColorA);    	
						    }
						    else {
						       	 newPanel.setBackground(ranColorB);    	
						    }
						    }
						    
						    else if (((Math.floor(i/dim)) % 2) == 1){ //even row
						    if(i % 2 == 0) {
						    	newPanel.setBackground(ranColorB);    	
						  }
						  else {
							  newPanel.setBackground(ranColorA);    	
						  }
						    }
						         panel[i] = newPanel;
						    }
						    }
					}
			
				}

				
				
				//the pane
				Container pane = frame.getContentPane();
				pane.setLayout(new GridLayout(dim,dim));
				
				for(i=0;i<(dim*dim);i++)
				{
					pane.add(panel[i]);
				}
				
		
			
			
			
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
