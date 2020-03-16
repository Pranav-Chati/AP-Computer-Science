
package employee;

public class Employee {
	private String lname; //last name
	private String fname; //first name
	private double hours; //hours worked
	private double rph; //rate per hour
	private int id; //id number
	
	private int age; //age
	private String gender; //male or female
	private boolean employed;
	
	private String info;
	private String isEmployed;
	
	
	
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getRph() {
		return rph;
	}

	public void setRph(double rph) {
		this.rph = rph;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isEmployed() {
		return employed;
	}

	public void setEmployed(boolean employed) {
		this.employed = employed;
	}



	//whether they are employed are not, if they are the age of 65 or over than no
	//default
	Employee(){
		
		lname = fname = "";
		this.id = 0;
		this.rph = this.hours = 0.0;
		this.age =0;
		this.gender = "";
		this.employed = false;
	}
	
	//fill
	Employee(String fn, String ln, int id, double hours, double rph){
		lname = ln;
		fname = fn;
		this.id = id;
		this.hours = hours;
		this.rph = rph;
		
		getInfo();
	}
	
	//overloaded fill with more datatypes
	Employee(String fn, String ln, int id, double hours, double rph, int age, String gender, boolean employed)
	{
		lname = ln;
		fname = fn;
		this.hours = hours;
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.employed = employed;
		this.rph = rph;
		
		getInfo1();
	}
	
	//polymorphic fill
	Employee(String fn, String ln)
	{
		lname = ln;
		fname = fn;
		this.id = 0;
		this.rph = this.hours = 0.0;
		this.age =0;
		this.gender = "";
		this.employed = false;
	}

	
	public String toString() {
		
		//must return a string
		return (info);
	}	
	
	
	
	public void getInfo()
	{
		info ="\nEmployee name:" + fname + " "+ lname
				+"\nId Number: "+ Integer.toString(id)
				+ "\nHours Worked: " + Double.toString(hours)
				+"\nRate per Hour: $" + Double.toString(rph);	
	}
	
	public void getInfo1()
	{
		tester();
		
		info ="\nEmployee name:" + fname + " "+ lname
				+"\nId Number: "+ Integer.toString(id)
				+ "\nHours Worked: " + Double.toString(hours)
				+"\nWage: $" + Double.toString(rph)
				+"\nAge: " + Integer.toString(age)
				+"\nEmployed: " + isEmployed
				+"\nGender:" + gender;
	}
	
	
	public void tester()
	{
		if(age < 65 & age > 16)
		{
			isEmployed = "Yes";
		}
		else
		{
			isEmployed = "No";
		}
			
	}
	
}
