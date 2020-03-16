package lab410;

import java.awt.Container;
import java.text.DecimalFormat;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class TeacherGUI {
	public static void main(String[] args)
	{
		
			JFrame gui = new JFrame("Teacher - 4.10 Lab");
			gui.setSize(1200,400);
			gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
			//option whether they want to read from file
			
			int fileread = JOptionPane.showConfirmDialog(null, "Would you like to read from a file?");
			
			if(fileread == JOptionPane.YES_OPTION) //this means the the user will read from the file
			{
				try {
					TeacherFiles filer = new TeacherFiles();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
				DecimalFormat df = new DecimalFormat("#.##");

				
				//Setting the array for Years to use in the vectors
					int[] arrayYears = new int[20];
					for(int i = 0; i <= 19; i++) {
						int j = i;
						arrayYears[i] = (++j);
					}
				
				//Instantiating an object ffor Lab410
					Lab410 lab = new Lab410(40000, "M", 12);
				
				//Creates the Pane off of the GUI
					Container pane = gui.getContentPane();
				
				//Runs the first methods from the lab object
					double perc = lab.findPercentage();
					lab.findSalaries(perc);

						
				//outputting the chart to console
					System.out.println("       Bachelor   Master   PhD");
					for(int i = 0; i <= 19; i++) {
						int j = i;
						 System.out.println("Year " + Integer.toString(j+1) + "   " + Double.parseDouble(df.format(lab.getEndSalB()[j]))
						 	+ "   " +  Double.parseDouble(df.format(lab.getEndSalM()[j])) + "   " + Double.parseDouble(df.format(lab.getEndSalPhD()[j])));
					}
				
				//For the table
					Vector<String> vColumns = new Vector<String>();		
					Vector<Double> vBachelors = new Vector<Double>();
					Vector<Double> vMasters = new Vector<Double>();
					Vector<Double> vPhD = new Vector<Double>();


					for(int i = 0; i<=19; i++) {
						vColumns.add("Year "+Integer.toString(arrayYears[i]));
						vBachelors.add(lab.getEndSalB()[i]);
						vMasters.add(lab.getEndSalM()[i]);
						vPhD.add(lab.getEndSalPhD()[i]);
					}
			
					Vector<Vector> vData = new Vector<Vector>();
					vData.addElement(vBachelors);
					vData.addElement(vMasters);
					vData.addElement(vPhD);
					
				//Creates the chart, inputs vectors for the table4
					JTable chart = new JTable(vData, vColumns);
				
				//Scroll Pane, creating the char
					JScrollPane scrollPane = new JScrollPane(chart);
				    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS); //Making the table  have a horizontal bar
					scrollPane.getHorizontalScrollBar();

			    //Adds the table to the Gui
				    gui.add(scrollPane);
				    gui.setResizable(true);
					gui.setVisible(true);   
				    JOptionPane.showMessageDialog(null, "Ending Salary: " + Double.parseDouble(df.format(lab.getEndSalary())));

			
				
				//40000 masters 12			
			}
			else //the user choose the input
			{
				double startingSalary = Double.parseDouble(JOptionPane.showInputDialog("Input Starting Salary Here:"));
				String educationLvl = JOptionPane.showInputDialog("Input Your Education Level(PhD, M, B):");
				int years = Integer.parseInt(JOptionPane.showInputDialog("Input the # of Years You've Worked:"));

				//Decimal Formattig for all the numbers
				DecimalFormat df = new DecimalFormat("#.##");

				
			//Setting the array for Years to use in the vectors
				int[] arrayYears = new int[20];
				for(int i = 0; i <= 19; i++) {
					int j = i;
					arrayYears[i] = (++j);
				}
			
			//Instantiating an object ffor Lab410
				Lab410 lab = new Lab410(startingSalary, educationLvl, years);
			
			//Creates the Pane off of the GUI
				Container pane = gui.getContentPane();
			
			//Runs the first methods from the lab object
				double perc = lab.findPercentage();
				lab.findSalaries(perc);

					
			//outputting the chart to console
				System.out.println("       Bachelor   Master   PhD");
				for(int i = 0; i <= 19; i++) {
					int j = i;
					 System.out.println("Year " + Integer.toString(j+1) + "   " + Double.parseDouble(df.format(lab.getEndSalB()[j]))
					 	+ "   " +  Double.parseDouble(df.format(lab.getEndSalM()[j])) + "   " + Double.parseDouble(df.format(lab.getEndSalPhD()[j])));
				}
			
			//For the table
				Vector<String> vColumns = new Vector<String>();		
				Vector<Double> vBachelors = new Vector<Double>();
				Vector<Double> vMasters = new Vector<Double>();
				Vector<Double> vPhD = new Vector<Double>();


				for(int i = 0; i<=19; i++) {
					vColumns.add("Year "+Integer.toString(arrayYears[i]));
					vBachelors.add(lab.getEndSalB()[i]);
					vMasters.add(lab.getEndSalM()[i]);
					vPhD.add(lab.getEndSalPhD()[i]);
				}
		
				Vector<Vector> vData = new Vector<Vector>();
				vData.addElement(vBachelors);
				vData.addElement(vMasters);
				vData.addElement(vPhD);
				
				System.out.println("Hello");
			//Creates the chart, inputs vectors for the table4
				JTable chart = new JTable(vData, vColumns);
			
			//Scroll Pane, creating the char
				JScrollPane scrollPane = new JScrollPane(chart);
			    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS); //Making the table  have a horizontal bar
				scrollPane.getHorizontalScrollBar();

		    //Adds the table to the Gui
			    gui.add(scrollPane);
			    gui.setResizable(true);
				gui.setVisible(true);   
			    JOptionPane.showMessageDialog(null, "Ending Salary: " + Double.parseDouble(df.format(lab.getEndSalary())));
			}
	}
}
