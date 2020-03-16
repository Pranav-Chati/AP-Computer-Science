/* By: Pranav Chati
 * Data of Completion: 10/14/2019
 * Grade: A+
 * Purpose: The purpose was to create a payroll table with taxes, gross pay and all based off of the 5 private datatypes from employee
 * What went wrong: The YTD was incorrect so i missed points on that, likewise, didn't do checks
 */
package payroll;

import java.awt.Container;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;


public class PayRollTester {
	String[][] data;
	String[] columns;

	
	public static void main(String[] args) throws IOException {
		DecimalFormat df = new DecimalFormat("#.##");
		
		//Console outputting
		//File empFile = new File("APCompSci\\Projects\\payroll\\employees100.txt");

			File empFile = new File("C:\\Users\\pchat\\employees100.txt");
			//int option = Integer.parseInt(JOptionPane.showInputDialog("Enter the amount of Employees you want to see"));
			//add joption pane
			Payroll pr;
				pr = new Payroll(empFile);
				pr.RunPayRoll();
				
				for(int i =0; i < pr.pemp.length; i++)
					System.out.println(pr.toString(i));
				
				System.out.println(pr.RunningTotals());	
		
		//the gui stuff
			JFrame gui = new JFrame("Employees");
			gui.setSize(600,300);
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
			//Class Instantiating 
				//PayChecks pChecks = new PayChecks();
				PayList pList = new PayList();
				PayInfo pInfo = new PayInfo();
			
				JSplitPane split = new JSplitPane(SwingConstants.VERTICAL, pList, pInfo); 
				split.setDividerLocation(200); //sets the location in the middle of the screen
				split.setEnabled(false);
				split.setDividerSize(1);
				
			//Working with pList
				String[] names = new String[100];
				
				//adjust for loop for user input option pane
				for(int i = 0; i < pr.pemp.length; i++) 
					names[i] = pr.pemp[i].fname + " " + pr.pemp[i].lname;	
				pList.getJList(names);
				

				
			//Working with pInfo
			   pList.listEmps.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						pList.selected = pList.listEmps.getSelectedIndex();
						//This is for the jtable 
						
						String[][] data = {
								{"Yearly Wage", "$" + df.format(pr.pemp[pList.selected].yearlyWage)},
								{"Gross Pay", "$" + df.format(pr.pemp[pList.selected].grossPay)},
								{"Local Tax", "$" + df.format(pr.pemp[pList.selected].localTax)},
								{"State Tax", "$" + df.format(pr.pemp[pList.selected].stateTax)},
								{"Federal Tax", "$" + df.format(pr.pemp[pList.selected].fedTax)},
								{"Social Security Tax", "$" + df.format(pr.pemp[pList.selected].ssTax)},
								{"FICA Tax", "$" + df.format(pr.pemp[pList.selected].ficaTax)},
								{"Medicare Tax", "$" + df.format(pr.pemp[pList.selected].mcTax)},
								{"Net Pay", "$" + df.format(pr.pemp[pList.selected].netPay)},
								{"YTD", "$" + df.format(pr.pemp[pList.selected].ytd)}
						};
					
						String[] columns = {"Taxes", "Money"};
							
						//Actually create the jlabels again
						   pInfo.setID(pr.pemp[pList.selected].idNum);
						   pInfo.setName(pr.pemp[pList.selected].fname, pr.pemp[pList.selected].lname);
						   pInfo.setHoursWorked(pr.pemp[pList.selected].hoursWorked);
						   pInfo.setHourlyWage(pr.pemp[pList.selected].hourlyWage);
						   pInfo.setAge(pr.pemp[pList.selected].age);
						   pInfo.setDependents(pr.pemp[pList.selected].numDependents);	
							pInfo.setTable(data, columns);
						   
						//Repeat all the labels to update them
						   pInfo.lblName.repaint();
						   pInfo.lblID.repaint();
						   pInfo.lblHours.repaint();
						   pInfo.lblHW.repaint();
						   pInfo.lblAge.repaint();
						   pInfo.lblND.repaint();
					}
				});
				
				   //creates the button
					//pInfo.btnChecks();

				
			Container pane = gui.getContentPane();
			pane.add(split);
			gui.setVisible(true);
	}

}
