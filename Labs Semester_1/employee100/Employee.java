package employee100;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Employee {
	public static String[] fnamesMale = new String[50]; //male names array
	public static String[] fnamesFemale = new String[50];//female names array
	public static String[] lNames = new String[100]; //last names of everyone
	
	public static int[] hours = new int[100]; //number of hours of every employee
	public static int[] IDnum = new int[100]; //ID numbers(100) for each employee
	public static int[] numDependents = new int[100]; //number of dependents
	
	public static String[] names = new String[100]; //to keep everything in a list
	public static int[] age = new int[100];	
	public static double[] hourlyWage = new double[100];	
	
	//randomize the names
	public static void getNamesFile(Scanner readerM, Scanner readerF, Scanner readerLN, Random randNames) throws Exception {
		int counter = 0;
		 
		//this while loop gets the names(male and female) of 50 users each, creating 100
		while(counter <= 49)
		{
			if(readerM.hasNextLine()) {
				fnamesMale[counter] = readerM.next();
			}
			
			if(readerF.hasNextLine()) {
				fnamesFemale[counter] = readerF.next();
			}
			counter ++;
		}
		
		//resets the counter
		counter = 0;
		
		//gets 100 last names
		while(counter <= 99)
		{
			if(readerLN.hasNextLine())
			{
				lNames[counter]= readerLN.next();
			}
			counter ++;
		}
		
		//adding all of the names in one specific 
		
		  for(int i = 0; i<=49; i++) { 
			  names[i] = fnamesMale[i] + " " + lNames[i];
			  }
		  
		  for(int i = 50; i<=99;i++) { 
			  int j = i-50; 
			  names[i] = fnamesFemale[j] + " " + lNames[i];
		  }
		  
		 shuffleArray(names);
		
	}
	
	//this code will essentially will randomize an array making everything jumbled up
	   public static void shuffleArray(String[] names2) {
	        int n = names2.length;
	        Random random = new Random();
	        random.nextInt();
	        for (int i = 0; i < n; i++) {
	            int change = i + random.nextInt(n - i);
	            swap(names2, i, change);
	        }
	    }

	    private static void swap(String[] names2, int i, int change) {
	        String helper = names2[i];
	        names2[i] = names2[change];
	        names2[change] = helper;
	    }
	
	//randomly getsHours for all the 100 employees
	public static void getHours(Random randH) {
		//Creates an array of hours
		int i=0;
		
		while(i<=99) {
		hours[i] = randH.nextInt(45)+1;
			i++; //Terminal condition
		}
		
		i=0;
		
		while(i<=99) {
		age[i] = randH.nextInt(25)+20;
			i++; //Terminal condition
		}
		
		i=0;
		while(i<=99) {
			hourlyWage[i] = randH.nextInt(10) + 30;
			i++;
		}
	}

	
	//fix id's
	//randomly gets 2 digits, then connected them to the number 1
	public static void getIDNum(Random randID) {
		Vector<Integer> nums = new Vector();
		int numID;
		int j=0; //a second counter
		int l = 0;
		//uniqueness, no 2 employees can have the same id
		for(int i =0; i <=99; i++) {
			numID = randID.nextInt(99);
			nums.add(numID);
			
			while(j<=99) {
				if( IDnum[j] != numID) {
					IDnum[j] = numID;
				}//end for if
				j++;
			} //end for while
			l++;
			j=l;
		} //end of for
	}
	
	
	//Randomly gets digits for the number of dependents
	public static void getDependents(Random randD) {
		for(int i=0; i <=99; i++) {
			numDependents[i] = randD.nextInt(10);	
		}
		
	} 
	
	//add print writer
	public static void writeToFile(PrintWriter writer) throws Exception {
		for(int i=0;i<=99;i++) {
			
			writer.println("Names: " + names[i]);
			writer.println("ID: " + IDnum[i]);
			writer.println("Hours: " + hours[i]);
			writer.println("Dependents: " + numDependents[i]);	
			writer.println("Age: " + age[i]);
			writer.println("Hourly Wage: " + hourlyWage[i]);	
			writer.println(" ");
		}
		writer.close();
	}
}
