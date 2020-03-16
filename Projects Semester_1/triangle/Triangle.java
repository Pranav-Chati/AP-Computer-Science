package triangle;

public class Triangle {
	 public LineSeg L1;
	 public Double l1d;
	 
	 public LineSeg L2;
	 public Double l2d;
	 
	 public LineSeg L3;
	 public Double l3d;
	 
	 public double P; //perimeter
	 public double area;
	 public double s; //this for the use of the area(for heron's formula)
	 
	 public double angle1, angle2,angle3;
	 
	 Triangle(){
		 
	 }
	 
	 Triangle(LineSeg L1, LineSeg L2, LineSeg L3) {
		 this.L1 = L1;
		 this.L2 = L2;
		 this.L3 = L3;
		 
		 //set distances or the sides
		 l1d = this.L1.distance;
		 l2d =  this.L2.distance;
		 l3d =  this.L3.distance;
	 }
	 
	 public boolean isTriangle() {
		 //checks to see if this is a triangle
		 if ((l1d + l2d > l3d) && (l2d + l3d > l1d) && (l1d + l3d>l2d))
		 {
			 return(true);			 
		 }
		 else return(false); //returns false if it isn't a triangle
	 }
	 
	 public String kindofTri() {
		 
		 if(l1d == l2d && l2d == l3d && l1d == l3d)
		 {
			 return ("Equaliteral");
		 } 
		 else if (l1d != l2d && l2d != l3d && l1d != l3d)
		 {
			 return ("Scalene");
		 }
		 else
		 {
			 return("Isoceles");
		 }
	 }
	 
	 
	 public double findAngle1() {
		 angle1 = Math.acos((-Math.pow(l1d, 2)+Math.pow(l2d,2) + Math.pow(l3d, 2))/(2*l2d*l3d));
		 angle1 = (angle1*180)/Math.PI;
		 return(angle1);

	 }
	 
	 public double findAngle2() {
		 angle2 = Math.acos((-Math.pow(l3d, 2)+Math.pow(l2d,2) + Math.pow(l1d, 2))/(2*l1d*l2d));
		 angle2 = (angle2*180)/Math.PI;

		 return angle2;
	 }
	 
	 public double findAngle3() {
		 angle3 = Math.acos((-Math.pow(l2d, 2)+Math.pow(l1d,2) + Math.pow(l3d, 2))/(2*l1d*l3d));
		 angle3 = (angle3*180)/Math.PI;

		 return angle3;
	 }
	 
	 public Double areaTri() {
		 //finds the area of the triangle using Heron's formula
		 s = (l1d +l2d + l3d)/2;
		 area = Math.sqrt((s*(s-l1d)*(s-l2d)*(s-l3d)));
		 return(area);
	 }
	 
	 public Double perimeterTri() {
		 //finds the perimeter of the triangle
		 P = l1d + l2d + l3d;
		 return P;
	 }
	 
	 public String toString() {
		 return ("Triangl:\n\tArea: " + Double.toString(area)+ "\n\tPerimeter: " + Double.toString(P) + "\n\tThe triangle is: " + kindofTri()
		 +"\nAngle 1: "+ Double.toString(angle1) + "\nAngle 2: " + Double.toString(angle2)
		 +"\nAngle 3: " + Double.toString(angle3));
	 }
}
