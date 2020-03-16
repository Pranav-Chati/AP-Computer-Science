/*
 * By:Pranav Chati
 * Purpose: This is the first actual project in which you input 1 employee and can show 2/3 more employees
 * On this project, I got an A++ because of GUI(2 points), 3 more data(2 points), 4 more methods(1 points) and prolly some other stuff too
 *The employeetester is the B version for this project and the Employee.java contains the constructors and the actual code that I call for instantiating the objects
 */

package employee;

import javax.imageio.ImageIO;

//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import java.util.Scanner;
//import javax.swing.JTextField;
//import javax.swing.JPanel;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;


//import java.util.Random;
//import java.util.Scanner;

public class EmployeeGUI {
	// public variables here
	static String fnTF; //for the first name input
	static String lnTF; //for the last name input
	static double hoursTF; //for the hours input
	static int idTF; //for the id input
	static double wageTF; // for the wage input
	static String genderCB; //input for the gender combo-box
	static int ageTF;
	
	static int empcounter; //this is  for which employee is seen
	
	static int i;
	static boolean employed;
	static Employee e1;

	
	public static void main(String[] args) {
		int ans;
		Scanner input = new Scanner(System.in);


		JFrame frame = new JFrame();
		frame.setTitle("Employees");
		frame.setSize(500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

		
		//do {
		empcounter = 1;	
		
		// For this section, it will be all the textfields and other objects creating the main GUI for all the variables
		
		// Label & TextField - First Name
			JLabel lblFirstName = new JLabel("*First Name: "); // the label for the first name
			JTextField tfFirstName = new JTextField(10); // the text-field for the first name
			lblFirstName.setLabelFor(tfFirstName);

			
		// Label & TextField - Last Name
			JLabel lblLastName = new JLabel("*Last Name: "); // the label for the last name
			JTextField tfLastName = new JTextField(10); // the text-field for the last name
			lblLastName.setLabelFor(tfLastName);

	
		// Combo box - gender
			JLabel lblgen = new JLabel("Select Gender: ");
			//the options belonging to the gender combo box
			String[] genderoptions = { "N/A", "Male", "Female", "TransGender", "Prefer Not to Say" }; 
			JComboBox genderc = new JComboBox(genderoptions); // this is the instantiate of the class JCombobox
			genderc.setSelectedIndex(0);
			lblgen.setLabelFor(genderc);

			
		// the Hours worked
			JLabel lblhours = new JLabel("*Hours Worked: "); // label showing hours(doesn't change)
			JTextField tfhours = new JTextField(10); // input for hours
			lblhours.setLabelFor(tfhours);

			
		// Rate per hour /wage
			JLabel lblwage = new JLabel("*Wage: "); // label for showing wage
			JTextField tfwage = new JTextField(10); // input for wage
			lblwage.setLabelFor(tfwage);

			
		// ID
			JLabel lblID = new JLabel("*ID: ");
			JTextField tfID = new JTextField(10);
			lblID.setLabelFor(tfID);
			
			
		//Age
			JLabel lblAge = new JLabel("Age:");
			JTextField tfAge = new JTextField(10);
			lblAge.setLabelFor(tfAge);
			
			
		//Button to add Employee
			JButton addE = new JButton("Add Employee");

		//Button to view Employees
			JButton viewE = new JButton("View Employee");
			
			
			addE.setPreferredSize(new Dimension(125,25));
			viewE.setPreferredSize(new Dimension(125,25));
			
			
		// this is the listeners for the objects
			// firstname
				tfFirstName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fnTF = tfFirstName.getText();
					
					}
				});
	
				
			// lastname
				tfLastName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lnTF = tfLastName.getText();
					}
				});
	
				
			// Hours
				tfhours.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						hoursTF = Double.parseDouble(tfhours.getText());
					}
				});
	
				
			// Wage
				tfwage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						wageTF = Double.parseDouble(tfwage.getText());

					}
				});
				
	
			// ComboBox
				genderc.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						genderCB = (String)genderc.getSelectedItem();
					}
				});
				
				
			// id
				tfID.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						idTF = Integer.parseInt(tfID.getText());
					}
				});
			
				
			//Age
				tfAge.addActionListener(new ActionListener() {					
					public void actionPerformed(ActionEvent e) {
						ageTF = Integer.parseInt(tfAge.getText());
						
						if(ageTF > 65)
						{
							employed = false;
						}
						else
						{
							employed = true;
						}
					}
				});
				
				
			//Button - Add Employee
				addE.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if((ageTF == 0) & (genderCB == "N/A") ) {
							 e1 = new Employee(fnTF, lnTF, idTF, hoursTF, wageTF);
							System.out.println(e1.toString());
						}
						else {
							 e1 = new Employee(fnTF, lnTF, idTF, hoursTF, wageTF, ageTF, genderCB, employed);
							System.out.println(e1.toString());
						}
					}
				});
				
			//Button - view Next Employee
				
				viewE.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switch(empcounter)
						{
						case 1:
							Employee DwightS = new Employee("Dwight", "Schrute", 2980, 45, 50, 31, "Male", true);
							System.out.println(DwightS.toString());
							break;
							
						case 2:
							Employee JimH = new Employee("Jim", "Halpert", 2981, 30 , 45, 30, "Male", true);
							System.out.println(JimH.toString());
							break;
							
						case 3:
							Employee StanleyS = new Employee("Stanley", "Hudson", 2982, 35, 40, 53, "Male", true);
							System.out.println(StanleyS.toString());
							
							break;
							
						case 4:
							System.out.println(e1.toString());
							break;
						
						}
						
						if (empcounter >= 4)
						{
							empcounter=1;
						}
						else
						{
							empcounter++;
						}
					}
				});
				
				
		
		// the panel
				
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout());
				GridBagConstraints c = new GridBagConstraints();


			// FirstName
				c.gridx=0;
				c.gridy = 1;
				panel.add(lblFirstName,c);
				
				c.gridx = 1;
				c.gridy = 1;
				panel.add(tfFirstName,c);
			

			// LastName
				c.gridx = 2;
				c.gridy = 1;
				panel.add(lblLastName, c);
				
				c.gridx = 3;
				c.gridy = 1;
				panel.add(tfLastName, c);

				
			//Wage
				
				c.gridx =2;
				c.gridy = 3;
				panel.add(lblwage,c);
				
				c.gridx = 3;
				c.gridy = 3;
				panel.add(tfwage,c);
				
				
			//Hours
				c.gridx = 0;
				c.gridy = 3;
				
				panel.add(lblhours,c);
				
				c.gridx = 1;
				c.gridy =3;
				panel.add(tfhours,c);

				
			//ID
				c.gridx = 2;
				c.gridy=5;
				panel.add(lblID,c);
				
				c.gridx = 3;
				c.gridy=5;
				panel.add(tfID,c);
				
				
			//Adding the Combo-box
				c.gridx = 0;
				c.gridy=5;
				panel.add(lblgen,c);
				
				c.gridx = 1;
				c.gridy = 5;
				panel.add(genderc,c);
			
				
			//Button
				c.gridx=3;
				c.gridy = 9;
				panel.add(addE,c);
				
				
			//Age
				c.gridx=0;
				c.gridy=9;
				panel.add(lblAge,c);
				
				c.gridx = 1;
				c.gridy = 9;
				panel.add(tfAge,c);
				
			//View Employee
				c.gridx=3;
				c.gridy=10;
				panel.add(viewE,c);
				
				
				frame.add(panel);			


		frame.setVisible(true);
		
		
		
//		System.out.println("Do you want to run again? \n1-Yes\n2-No");
//		ans = input.nextInt();
//		ans = 1;
//		}while (ans == 1);

	}
}
