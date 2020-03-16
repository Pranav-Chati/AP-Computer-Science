package lab410;

public class Lab410 {
		//variables
		private double startingSalary; //this is the users starting salary
		private String educationLvl; //PhD, masters, bachelors
		private double educationperc; //education percentage(the percentage gained by working
		private int years; //number of years
		
		private double endSalary;
		private double[] endSalPhD; //if you were a PhD, this would be your progression of salary
		private double[] endSalM;//masters end salary
		private double[] endSalB; //if you were a bachelors, this would be your progression of salary
		
		//constructors
			Lab410() {
				years =0;
				startingSalary = 0.0;
				educationLvl = "";
			}
			Lab410(double sS, String lvl, int years) {
				this.years = years;
				startingSalary = sS;
				educationLvl = lvl;
				
				 endSalPhD = new double[20];
				 endSalM = new double[20]; 
				 endSalB = new double[20];
			}
		
		//setters and getter
			//Salary
			public double getEndSalary() {
				return endSalary;
			}
	
			public void setEndSalary(double endSalary) {
				this.endSalary = endSalary;
			}
			
			//endSalB
			public double[] getEndSalB() {
				return endSalB;
			}
			public void setEndSalB(double[] endSalB) {
				this.endSalB = endSalB;
			}
			
			//endSalM
			public double[] getEndSalM() {
				return endSalM;
			}
			public void setEndSalM(double[] endSalM) {
				this.endSalM = endSalM;
			}
			
			//endSalPhD
			public double[] getEndSalPhD() {
				return endSalPhD;
			}
			public void setEndSalPhD(double[] endSalPhD) {
				this.endSalPhD = endSalPhD;
			}

		
		//methods
			//finds the percentages based on the lvl's
			public double findPercentage() {
				switch (educationLvl) {
				case"B":
					educationperc = 1.01;
					break;
				case "M":
					educationperc = 1.02;
					break;
				case "PhD":
					educationperc = 1.04;
					break;			
				default:
					educationperc = 1.00;
					break;
				}
				return educationperc;
			}
	
			//finds the salaries
			public void findSalaries(double perc) {
				for(int i=0; i <= (years-1); i++) {
					setEndSalary(startingSalary * Math.pow(1.02, (i)) * educationperc); //actual salary at that time	
				}
				for(int i=0; i <=19; i++) {
					getEndSalB()[i] = startingSalary * Math.pow((1.02), (i)); //regression of bachelors salary
					getEndSalM()[i] = startingSalary * Math.pow(1.02, (i)) * 1.02; //regression of masters salary
					getEndSalPhD()[i] = startingSalary * Math.pow(1.02, (i)) * 1.04;//regression of PhD salary
				}
				
			}
}
