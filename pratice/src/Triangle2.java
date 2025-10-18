package OOP_LAB;

import java.util.Scanner;

public class Triangle2 {
    Point2D p1;
    Point2D p2;
    Point2D p3;


    public Triangle2(Point2D p1, Point2D p2, Point2D p3){
        this.p1 =  p1;
        this.p2 = p2;
        this.p3 = p3;

    }
    public static double perimeter(Point2D p1, Point2D p2, Point2D p3){
        double a = Point2D.distance(p1,p2);
        double b = Point2D.distance(p1,p3);
        double c = Point2D.distance(p2,p3);
        return a + b +c ;
    }
    public static double area(Point2D p1, Point2D p2, Point2D p3){
        return 0.5*Math.abs(p1.x*(p2.y- p3.y)+p2.x*(p3.y- p1.y)+p3.x*(p1.y- p2.y));
    }
}

class CheckTriangle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input x and y for p1: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print("Input x and y for p2: ");
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.print("Input x and y for p2: ");
        int e = sc.nextInt();
        int f = sc.nextInt();



        Point2D p1 = new Point2D(a,b);
        Point2D p2 = new Point2D(c,d);
        Point2D p3 = new Point2D(e,f);

        System.out.printf("Perimeter of triangle based on given points : %.2f\n ",Triangle2.perimeter(p1,p2,p3));
        System.out.printf("Area of triangle based on given points : %.2f\n ",Triangle2.area(p1,p2,p3));

    }
}
