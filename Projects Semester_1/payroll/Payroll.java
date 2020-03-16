package payroll;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Payroll {
	PayEmployee[] pemp = new PayEmployee[100];
	int toStringCheck;
	double netPay, sTax, lTax, fedTax;
	
	Payroll(File filename) throws IOException {
		//this actually creates the mini sets of data
		for(int i =0; i < pemp.length;i++) 
			pemp[i] = new PayEmployee();
		
		Scanner reader = new Scanner(filename);
		int empNum = 0; //this is a counter to figure out which pemp we are on
		int j;
		
		//the file
		for(int i = 0; i <= (filename.length() - 1); i++) {
			if(reader.hasNextLine()) {
							
				j = i % 7;
				
				switch(j) {
				case 0:
					pemp[empNum].fname = reader.next();
					break;
				
				case 1:
					pemp[empNum].lname = reader.next();

					break;
					
				case 2:
					pemp[empNum].idNum = reader.nextInt();

					break;
					
				case 3:
					pemp[empNum].hoursWorked = reader.nextInt();
					break;
					
				case 4:
					pemp[empNum].hourlyWage = reader.nextDouble();
					break;
					
				case 5:
					pemp[empNum].numDependents = reader.nextInt();
					break;
					
				case 6:
					pemp[empNum].age = reader.nextInt();
					empNum++;

					break;
				} //end of the switch
			} //end of the if

		} //end of the for loop
			
	}//end of the constructor	
	
	Payroll(int numEmps, File fileName) throws IOException{
		//User wil input a number of emps they want to get out,
		//this actually creates the mini sets of data
		for(int i =0; i<pemp.length;i++) 
			pemp[i] = new PayEmployee();
		
		Scanner reader = new Scanner(fileName);
		int empNum = 0; //this is a counter to figure out which pemp we are on
		int j;
		
		//the file
		for(int i = 0; i <= numEmps; i++) {
			if(reader.hasNextLine()) {
							
				j = i % 7;
				
				switch(j) {
				case 0:
					pemp[empNum].fname = reader.next();
					break;
				
				case 1:
					pemp[empNum].lname = reader.next();

					break;
					
				case 2:
					pemp[empNum].idNum = reader.nextInt();

					break;
					
				case 3:
					pemp[empNum].hoursWorked = reader.nextInt();
					break;
					
				case 4:
					pemp[empNum].hourlyWage = reader.nextDouble();
					break;
					
				case 5:
					pemp[empNum].numDependents = reader.nextInt();
					break;
					
				case 6:
					pemp[empNum].age = reader.nextInt();
					empNum++;

					break;
				} //end of the switch
			} //end of the if

		} //end of the for loop
	}
	
	public void RunPayRoll() {
		//the for loop fills everything up
		for(int i =0; i<= (pemp.length-1); i++) {
			pemp[i].yearlyWage = pemp[i].findYearlyWage();
			pemp[i].grossPay = pemp[i].findGrossPay();
			pemp[i].localTax = pemp[i].findLocalTax();
			pemp[i].stateTax = pemp[i].findStateTax();
			pemp[i].fedTax = pemp[i].findFedTax();
			pemp[i].ssTax = pemp[i].findSSTax();
			pemp[i].ficaTax = pemp[i].findFICA();
			pemp[i].mcTax = pemp[i].findMedicare();
			pemp[i].netPay = pemp[i].findNetPay();
			pemp[i].ytd = pemp[i].calcYTD(pemp[i].yearlyWage);
		}
	}
	
	public String RunningTotals() {
		DecimalFormat df = new DecimalFormat("#.##");
		for(int i =0; i< pemp.length; i++) {
			netPay += pemp[i].netPay;
			sTax += pemp[i].netPay;
			lTax += pemp[i].netPay;
			fedTax += pemp[i].netPay;
		}
		return ("Total NetPay for Company: $" + df.format(netPay) +
				"\nTotal Local Tax for Company: $" + df.format(lTax) +
				"\nTotal State Tax for Company: $" + df.format(sTax) + 
				"\nTotal Federal Tax for Company: $" + df.format(fedTax));
	}
	
	public String toString(int i) {
		DecimalFormat df = new DecimalFormat("#.##");
			return (pemp[i].toString()
					/*"\n\tYearly Wage: $"+ df.format(pemp[i].yearlyWage) +
					"\n\tGross Pay: $" + df.format(pemp[i].grossPay) + 
					"\n\tLocal Tax: $" + df.format(pemp[i].localTax) + 
					"\n\tState Tax: $" + df.format(pemp[i].stateTax) +
					"\n\tFederal Tax: $" + df.format(pemp[i].fedTax) + 
					"\n\tSocial Security Tax: $" + df.format(pemp[i].ssTax) +
					"\n\tFICA Tax: $" + df.format(pemp[i].ficaTax) +
					"\n\tMedicare Tax: $" + df.format(pemp[i].mcTax) +
					"\n\tNet Pay: $" + df.format(pemp[i].netPay)*/
					);
		}
	}
