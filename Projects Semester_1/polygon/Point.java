package polygon;


public class Point {
	public int myx;
	public int myy;
	
	Point(){
		myx = 0;
		myy = 0;
	}
	
	Point(int x, int y){
		myx = x;
		myy = y;
	}
	
	public String toString() {
		return("Point: (" + Integer.toString(myx) + "," + Integer.toString(myy) + ")");
	}
}
