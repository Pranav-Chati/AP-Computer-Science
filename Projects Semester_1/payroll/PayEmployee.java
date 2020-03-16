package payroll;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class PayEmployee extends Employee {
	//GrossPay
		double grossPay;
		
	//Taxes
		 Double localTax;
		 Double stateTax;
		 Double fedTax;
		 Double ssTax; //social security tax
		 Double ficaTax; //FICA tax
		 Double mcTax; //medicare Tax
		 Double yearlyWage; //yearly wage
		 Double ytd;
	
	//NetPay
		 Double netPay;

	//toString
		 String payStub;
	
	//Decimal Formatting
		DecimalFormat df = new DecimalFormat("#.##");
		
	PayEmployee() {
		super();

		//employee datatypes
			super.fname = " ";
			super.lname = " ";
			super.idNum = 0;
			super.hourlyWage = 0.0;
			super.hoursWorked = 0;
			super.numDependents = 0;
			super.age = 0;
		
		//grosspay datatype
			grossPay = 0;
		
		// taxes datatype
			localTax = 0.0;
			stateTax = 0.0;
			fedTax = 0.0;
			ssTax = 0.0;
			ficaTax = 0.0;
			mcTax = 0.0;
			yearlyWage = 0.0;
			
		//NetPay
			netPay = 0.0;
		
	}
	
	public double findGrossPay() {
		grossPay = super.hourlyWage *super.hoursWorked; //calls upon the parent tax
		return grossPay;
	}

	//extra method
	public double findYearlyWage() {
		yearlyWage = super.hourlyWage *super.hoursWorked * 52; //52 weeks in a year
		return yearlyWage;
	}
	
	public double findLocalTax() {
		//https://www.imaginemason.org/business/financial-information/local-taxes/
		localTax = (yearlyWage * 1.12)/100; //tax in mason is 1.12%(constant)
		localTax -= (super.numDependents*0.02);
		return localTax;
	}
	
	public double findStateTax() {
		//https://www.creditkarma.com/tax/i/guide-to-filing-an-ohio-state-tax-return/
		//Getting the wages of specific people into their specific categories
			if(yearlyWage >= 0 && yearlyWage < 10850) {
				stateTax = 0.0;
			}
			else if(yearlyWage >= 10851 && yearlyWage < 16300) {
				stateTax = (yearlyWage * 1.980)/100 + 80.56;
			}
			else if(yearlyWage >= 16301 && yearlyWage < 21750) {
				stateTax = (yearlyWage * 2.476) / 100 + 188.471;
			}
			else if (yearlyWage >= 21752 && yearlyWage < 43450) {
				stateTax = (yearlyWage * 2.969)/100 + 323.41;
			}
			else if(yearlyWage >= 43451 && yearlyWage < 89900) {
				stateTax = (yearlyWage * 3.456) / 100 + 967.68;
			}
			else if(yearlyWage >= 89901 && yearlyWage < 108700) {
				stateTax = (yearlyWage * 3.960)/100 + 2473.22;
			}
			else if(yearlyWage >= 108701 && yearlyWage < 217400) {
				stateTax = (yearlyWage * 4.597) /100 + 3336.50;
			}
			else {
				stateTax = (yearlyWage * 4.997) /100; 
			}
		
		//Subtracting number of dependents
			if(stateTax == 0) {
				stateTax -= (super.numDependents*0.02);
			}

		return stateTax;
	}
	
	public double findFedTax() {
	//https://www.quickenloans.com/blog/federal-income-tax-brackets
		
		//federal tax brackets
			if(yearlyWage >= 0 && yearlyWage < 9525) {
				fedTax = (yearlyWage) * 0.1;
			}
			else if(yearlyWage >= 9526 && yearlyWage < 38700) {
				//fedTax = (yearlyWage -9525) * 0.12 + 952.20;
				fedTax = (yearlyWage) * 0.12;

			}
			else if(yearlyWage >= 38701 && yearlyWage < 82500) {
				//fedTax = (yearlyWage - 38700) * 0.22 + 4453.5;
				fedTax = (yearlyWage * 0.22);

			}
			else if (yearlyWage >= 82501 && yearlyWage < 157500) {
				//fedTax = (yearlyWage - 82500) * 0.24 + 14089.5;
				fedTax = yearlyWage * 0.24;
			}
			else if(yearlyWage >= 157501 && yearlyWage < 200000) {
				//fedTax = (yearlyWage-157500) * 0.32 + 32089.5;			
				fedTax = yearlyWage* 0.32;
			}
			else if(yearlyWage >= 200001 && yearlyWage < 500000) {
				//fedTax = (yearlyWage-200000) * 0.35 + 45689.50;
				fedTax = yearlyWage * 0.35;
			}
			else if(yearlyWage >= 501000) {
				//fedTax = (yearlyWage-500000) * 0.37 + 150689.50;
				fedTax = yearlyWage* 0.37;
			}
			
			fedTax -= (super.numDependents*0.02); //subtracting number of dependents

		return fedTax;
	}
	
	public double findSSTax() {
		//https://smallbusiness.chron.com/calculate-social-security-tax-payments-14482.html#targetText=Calculate%20Social%20Security%20Tax,of%20taxable%20earnings%20is%20%24132%2C900.
		//Find the social security tax
			if(yearlyWage >= 132900) {
				ssTax = 8239.8;
			}
			else {
				ssTax = (yearlyWage*0.062);
			}
			
		//social security tax doesn't take dependents into account
		return ssTax;
	}
	
	//extra method
	public double findFICA() {
		//this method is used to find the FICA tax
		ficaTax = (mcTax * 0.029) + (ssTax * 0.124);
		return ficaTax;
	}
	
	//extra method
	public double findMedicare() {
		//this method is used to find the medicare tax
		if(yearlyWage < 200000) {
			mcTax = yearlyWage*0.0145; //medicare tax
			
		} else {
			mcTax = yearlyWage*0.0235; //medicare tax
		}
		
		return mcTax;
	}

	public double calcYTD(double temp) {
		Calendar calOne = Calendar.getInstance();
		int dayOfYear = calOne.get(Calendar.DAY_OF_YEAR);
		int year = calOne.get(Calendar.YEAR);
		Calendar calTwo = new GregorianCalendar(year,11,31);
		int day = calTwo.get(Calendar.DAY_OF_YEAR);
		int total_days = day - dayOfYear;
		int tempD = 52 - ((int)(total_days/7));
		return (temp*tempD);
	}
	
	public double findNetPay() {
	//Find the netpay
		netPay = yearlyWage -ssTax - fedTax - localTax - stateTax - ficaTax - mcTax;	
		return netPay;
	}

	public String toString() {
		//may have to use formating to get everything alligned up
		payStub = super.toString() + "\n\tYearly Wage: $" + df.format(yearlyWage) + 
				"\n\tGross Pay: $" + df.format(grossPay) +
				"\n\tLocal Tax: $" + df.format(localTax) +
				"\n\tState Tax: $" + df.format(stateTax) +
				"\n\tFederal Tax: $" + df.format(fedTax) +
				"\n\tSocial Security Tax: $" + df.format(ssTax) +
				"\n\tMedicare Tax: $" + df.format(mcTax) +
				"\n\tFICA Tax: $" + df.format(ficaTax) +
				"\n\tNet Pay: $" + df.format(netPay) +
				"\n\tYTD: $" + df.format(ytd);
		return payStub;
	}
	
	//payemp to string includes all the variables and the paystub
}
