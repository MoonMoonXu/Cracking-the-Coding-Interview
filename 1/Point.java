import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }


    public double slopeTo(Point that) {
    	if(this.x==that.x && this.y==that.y) return Double.NEGATIVE_INFINITY;
    	else if(this.y==that.y) return +0;
    	else if(this.x==that.x) return Double.POSITIVE_INFINITY;
    	else return (double)(this.y-that.y)/(double)(this.x-that.x);
    }

    public int compareTo(Point that) {
    	if(this.y<that.y)return -1;
    	else if(this.y==that.y && this.x<that.x)return -1;
    	else if(this.y==that.y && this.x==that.x)return 0;
    	else return 1;
    }

    
    public Comparator<Point> slopeOrder() {
    	return new SlopeOrder();
    }

    private class SlopeOrder implements Comparator<Point>
    {
    	public int compare(Point point1, Point point2)
    	{
    		if(slopeTo(point1) < slopeTo(point2)) return -1;
    		else if(slopeTo(point1) == slopeTo(point2)) return 0;
    		else return 1;
    	}
    }
    
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        /* YOUR CODE HERE */
    }
}