package polygon;

public class LineSeg {
	public Point start;
	public Point end;
	public double slope; //the slope which is just cy/cx
	public double cx; //change in x
	public double cy; //change in y
	public double distance; //the distance for the points

	//default constructor
	LineSeg(){
		start = new Point(0,0);
		end = new Point(0,1);
	}
	
	
	//fill constructor
	LineSeg(Point start, Point end) {
		this.start = start;
		this.end = end;
		
		cx = end.myx - start.myx;
		cy = end.myy - start.myy;
	}
	
	//Methods
	
		//Slope for the line
		public Double slopeP() {
			slope = cy/cx; //change in x over y
			return(slope);
		}
		
		public Double distanceP() {
			//distance formula includes 
			distance = Math.sqrt(Math.pow(cx, 2) + Math.pow(cy, 2));
			return(distance);
		}
		
		public String toString() {
			return("Line segment has a slope of " + Double.toString(slope) + "\nA Distance of: " + Double.toString(distance));
		}
}
