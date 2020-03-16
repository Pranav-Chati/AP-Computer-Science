/*Name: Pranav Chati
 * Date of Completion: 10.1.19
 * Grade: 10/10
 * What went wrong? I didn't do the super correctly, 
 * the redo Lab will be a better version of this.
 */

package employee100;

import java.io.File;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Employee100 extends Employee {
	
	public static void main(String[] args) throws Exception
	{
		Scanner readFemaleN = new Scanner(new File("C:\\Users\\pchat\\FemaleNamesDictionary.txt")); //reads the female names of the file
		Scanner readMaleN = new Scanner(new File("C:\\Users\\pchat\\MaleNamesDictionary.txt")); //readers the male names of the file
		
		Scanner readLN = new Scanner(new File("C:\\Users\\pchat\\LastNames.txt")); //reads the last names of the file

		Random randHours = new Random(); //Instantiates an object for the Random Class, random hours
		Random randID = new Random(); //Instantiates an object for accessing Random Class, random ID's
		Random randDependents = new Random(); //Instantiates an object for accessing Random Class, random amount of Dependent's

		PrintWriter writer = new PrintWriter(new File("C:\\Users\\pchat\\employees100.txt")); //writes to a file
		
		Random randNames = new Random(); //to fill the names array with random positions

		
		//hourly wage and yearlywage
		//hoursworked
		//age
		
		//make a better unique id's
		
		getHours(randHours); //generates 100 hours, some are repeating
		getIDNum(randID); //generates 100 random ID's
		getDependents(randDependents);	//generates random dependents
		
		getNamesFile(readMaleN, readFemaleN, readLN, randNames); //the method is from the getFile method, it was extended
		
		writeToFile(writer);
		
		//output to console
		for(int i=0;i<=99;i++) {
			System.out.println("Names:\t" + names[i] + "\nID:\t" + IDnum[i] + "\nHours:\t" + hours[i] + 
					"\nDependents: " + numDependents[i]);				
		}
		
		readFemaleN.close();
		readMaleN.close();
		readLN.close();

	}
}
