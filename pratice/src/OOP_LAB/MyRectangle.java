import java.awt.geom.*;
import java.util.*;

public class MyRectangle {

    // Data members: the two corner points
    private Point2D.Double bottomLeftPoint;
    private Point2D.Double topRightPoint;

    // Constructor: Take any two points and normalize them into bottom‑left and top‑right
    public MyRectangle(Point2D.Double pt1, Point2D.Double pt2) {
        double minX = Math.min(pt1.x, pt2.x);
        double minY = Math.min(pt1.y, pt2.y);
        double maxX = Math.max(pt1.x, pt2.x);
        double maxY = Math.max(pt1.y, pt2.y);
        this.bottomLeftPoint = new Point2D.Double(minX, minY);
        this.topRightPoint   = new Point2D.Double(maxX, maxY);
    }

    // Setter cho bottom-left
    public void setBottomLeftPoint (Point2D.Double pt) {
        this.bottomLeftPoint = pt;
    }

    // Setter cho top-right
    public void setTopRightPoint (Point2D.Double pt) {
        this.topRightPoint = pt;
    }

    // Getter cho bottom-left
    public Point2D.Double getBottomLeftPoint () {
        return bottomLeftPoint;
    }

    // Getter cho top-right
    public Point2D.Double getTopRightPoint () {
        return topRightPoint;
    }

    // Display the rectangle information
    public String toString() {
        return "(" + bottomLeftPoint.x + "," + bottomLeftPoint.y +
                "),(" + topRightPoint.x + "," + topRightPoint.y + ")]";
    }

    // Checking overlap/touch/disjoint
    public String relation(MyRectangle other) {
        double left   = Math.max(this.bottomLeftPoint.x, other.bottomLeftPoint.x);
        double right  = Math.min(this.topRightPoint.x, other.topRightPoint.x);
        double bottom = Math.max(this.bottomLeftPoint.y, other.bottomLeftPoint.y);
        double top    = Math.min(this.topRightPoint.y, other.topRightPoint.y);

        if (left < right && bottom < top) {
            double area = (right - left) * (top - bottom);
            return "Rectangles overlap. Overlapped area = " + area;
        } else if (left == right && bottom < top || bottom == top && left < right) {
            return "Rectangles touch.";
        } else if (left == right && bottom == top) {
            return "Rectangles touch at a point.";
        } else {
            return "Rectangles are disjoint.";
        }
    }

    //-----------------------------------------------------
    // main method used to test the MyRectangle class
    //-----------------------------------------------------
    public static void main (String[] args)  {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter one corner of 1st rectangle (x1 y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.print("Enter opp corner of 1st rectangle (x1 y1): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        MyRectangle rect1 = new MyRectangle(new Point2D.Double(x1,y1), new Point2D.Double(x2,y2));

        System.out.print("Enter one corner of 2nd rectangle (x1 y1): ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();
        System.out.print("Enter opp corner of 2nd rectangle (x1 y1): ");
        double x4 = scanner.nextDouble();
        double y4 = scanner.nextDouble();
        MyRectangle rect2 = new MyRectangle(new Point2D.Double(x3,y3), new Point2D.Double(x4,y4));

        System.out.println("Rectangle 1: " + rect1);
        System.out.println("Rectangle 2: " + rect2);

        System.out.println(rect1.relation(rect2));

        scanner.close();
    }
}
