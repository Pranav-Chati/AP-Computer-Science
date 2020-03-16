package payroll;

public class Employee {
		 String fname; //first name
	public String lname; //last name
	public int idNum; //id number
	public Double hourlyWage; //wage hourly
	public int hoursWorked; //hours worked
	public int numDependents; //number of dependents
	public int age; //age of the employee
	
	public String toString() {
		return("Name: " +fname + " " + lname+
				"\nID: " + Integer.toString(idNum) + 
				"\nHours Worked: " + Integer.toString(hoursWorked) +
				"\nHourly Wage: " + Double.toString(hourlyWage) +
				"\nNumber of Dependents: "  + Integer.toString(numDependents) +
				"\nAge: " + Integer.toString(age));
	}
}
