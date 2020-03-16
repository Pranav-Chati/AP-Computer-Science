package lab410;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TeacherFiles{
	private static double startingS;
	private static int years;
	private static String lvl; //Education lvl
	static 	Scanner reader = new Scanner("salaries.txt");
	
	TeacherFiles() throws Exception{
		
	}
	public void readFromFile() throws Exception{
		for(int i = 0; i < 3;i++)
		{
			if(reader.hasNext())
			{
				if(reader.hasNextDouble()) {
					startingS = reader.nextDouble(); //gets the double
				} else if(reader.hasNextInt()) { 
					years = reader.nextInt();//gets the number of years
				} else {
					 lvl = reader.next(); //gets the string
				}
				
			}	
		}
	}
	
	public void writeFromFile() throws Exception{
		PrintWriter writer = new PrintWriter(new File("schedule.txt"));
		while(reader.hasNext()) {
			int number = reader.nextInt();
			if(number != 0)
			{
				writer.println(number);
			}
		}
		
		
	}
}
