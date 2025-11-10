package OOP;

import java.awt.*;

interface GeometricObjec {
    public double getPerimeter();
    public double getArea();
}

class Circle implements GeometricObjec {
    protected double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    @Override
    public String toString(){
        return "Circle[radius="+this.radius+"]";
    }
    @Override
    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }
    @Override
    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }
}

interface Resizable{
    public void resize(int percent);
}

class ResizableCircle extends Circle implements Resizable{
    public ResizableCircle(double radius){
        super(radius);
    }
    @Override
    public String toString(){
        return "Resizable[Circle[radius="+this.radius+"]]";
}

    public void resize(int percent){
        this.radius *= percent/100.0;
    }

}

class Rectangle implements GeometricObjec{
    private double width;
    private double length;

    public Rectangle(double width, double length){
        this.width=width;
        this.length=length;
    }
    @Override
    public double getArea() {
        return width * length;
    }
    @Override
    public double getPerimeter(){
        return 2*(length+width);

    }
    @Override
    public String toString() {
        return  "Rectangle[ width ="+this.width+",length="+this.length+"]";
    }
}






class TestGeometricObjec {
    public static void main(String[] args) {
        Circle c1 = new Circle(2.5);
        Rectangle r1= new Rectangle(2,3);

        System.out.println(r1.toString());

        System.out.printf("Perimeter of  rectangle :%.2f ", r1.getPerimeter());
        System.out.println();


        System.out.println(c1.toString());
        System.out.printf("Area of  circle:%.2f\n",c1.getArea());

        ResizableCircle c2 = new ResizableCircle(4);
        c2.resize(2);
        System.out.println(c2.toString());


    }
}


