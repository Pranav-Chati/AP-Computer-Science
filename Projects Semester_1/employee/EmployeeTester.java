package employee;
import java.util.Scanner;

public class EmployeeTester {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		String fn, ln; //fn --> first name; ln -->last name
		int xid;
		double xrph, xhours;
		
		System.out.print("What is your first name? ");
		fn = input.nextLine();
		
		System.out.print("What is your last name? ");
		ln = input.nextLine();
		
		System.out.print("What is your id number(4 digits)? ");
		xid = input.nextInt();
		
		System.out.print("What is your wage? $");
		xrph = input.nextDouble();
		
		System.out.print("How many hours did you work? ");
		xhours = input.nextDouble();
		
		
		Employee e1 = new Employee(fn, ln, xid, xhours, xrph);
		System.out.println(e1.toString());
		
		Employee e2 = new Employee("Jim","Halpert", 2938, 8, 29);
		System.out.println(e2.toString());
		
		Employee e3 = new Employee("Dwight", "Schrute", 2968, 9, 31);
		System.out.println(e3.toString());
		
	}
}
