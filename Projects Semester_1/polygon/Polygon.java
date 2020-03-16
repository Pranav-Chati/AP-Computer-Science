package polygon;

public class Polygon {
	//methods	 
	 public LineSeg[] l;
	 public double P; //perimeter
	 public double area;
	 
	 
	 //CONSTRUCTORS
	 Polygon(){
		 
	 }

	 
	 //new constructor used for polygon class
	 Polygon(LineSeg[] l, int s) {
		 this.l = new LineSeg[s];
		 for(int i = 0; i < s; i ++) {
			 this.l[i] = new LineSeg();
		 }
		 
		 //setting the linesegs equal to each other
		 for(int i = 0; i < s; i ++) {
			 this.l[i] = l[i];
		 }
	 }
	 
	 public boolean isPolygon() {
		 //checks to see if the shape they have created is a polygon
		 return true;
	 }
	 
	 public String kindofPolygon() {
		 String kind = null;
		 Information info = new Information();
		 switch(info.AmountSelection()) {
		 case 3:
			 kind = "Triangle";
			break;
		case 4:
			kind = "Quadrilateral";
			break;
		case 5:
			kind = "Pentagon";
			break;
		case 6:
			kind = "Hexagon";
			break;
		case 7:
			kind = "Heptagon";
			break;
		case 8:
			kind = "Octagon";
			break;
		case 9:
			kind = "Nonagon";
			break;
		case 10:
			kind = "Decagon";
			break;
			
		 }
		 
		 return kind;
	}
	 
	 public Double periPolygon() {
		 //finds the perimeter of the triangle
		 for(int i = 0; i < l.length; i++) {
			 P += Math.abs(l[i].distanceP());
		 }
		 return P;
	 }
	 
	 public String toString() {
		 return ("Triangle\n\tArea: " + Double.toString(area)+ "\n\tPerimeter: " 
+ Double.toString(P) + "\n\tThe triangle is: " + kindofPolygon());
	 }
	 
	 
	 
	// Given three colinear points p, q, r, the function checks if 
	// point q lies on line segment 'pr' 
	public boolean onSegment(Point p, Point q, Point r) 
	{ 
	    if (q.myx <= Math.max(p.myx, r.myx) && q.myx >= Math.min(p.myx, r.myx) && 
	        q.myy <= Math.max(p.myy, r.myy) && q.myy >= Math.min(p.myy, r.myy)) 
	    return true; 
	  
	    return false; 
	} 
	  
	// To find orientation of ordered triplet (p, q, r). 
	// The function returns following values 
	// 0 --> p, q and r are colinear 
	// 1 --> Clockwise 
	// 2 --> Counterclockwise 
	public int orientation(Point p, Point q, Point r) 
	{ 
	    // See https://www.geeksforgeeks.org/orientation-3-ordered-points/ 
	    // for details of below formula. 
	    int val = (q.myy - p.myy) * (r.myx - q.myx) - 
	            (q.myx - p.myx) * (r.myy - q.myy); 
	  
	    if (val == 0) return 0; // colinear 
	  
	    return (val > 0)? 1: 2; // clock or counterclock wise 
	} 
	  
	// The main function that returns true if line segment 'p1q1' 
	// and 'p2q2' intersect. 
	public boolean doIntersect(Point p1, Point q1, Point p2, Point q2) 
	{ 
	    // Find the four orientations needed for general and 
	    // special cases 
	    int o1 = orientation(p1, q1, p2); 
	    int o2 = orientation(p1, q1, q2); 
	    int o3 = orientation(p2, q2, p1); 
	    int o4 = orientation(p2, q2, q1); 
	  
	    // General case 
	    if (o1 != o2 && o3 != o4) 
	        return true; 
	  
	    // Special Cases 
	    // p1, q1 and p2 are colinear and p2 lies on segment p1q1 
	    if (o1 == 0 && onSegment(p1, p2, q1)) return true; 
	  
	    // p1, q1 and q2 are colinear and q2 lies on segment p1q1 
	    if (o2 == 0 && onSegment(p1, q2, q1)) return true; 
	  
	    // p2, q2 and p1 are colinear and p1 lies on segment p2q2 
	    if (o3 == 0 && onSegment(p2, p1, q2)) return true; 
	  
	    // p2, q2 and q1 are colinear and q1 lies on segment p2q2 
	    if (o4 == 0 && onSegment(p2, q1, q2)) return true; 
	  
	    return false; // Doesn't fall in any of the above cases 
	} 
	  

}
