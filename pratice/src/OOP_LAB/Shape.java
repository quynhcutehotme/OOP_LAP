package OOP;

public class Shape {
    String color="red";
    boolean filled = true;

    public Shape(){}

    public Shape(String color, boolean filled){
        this.color = color;
        this.filled= filled;
    }

    public String getColor(){return color;}
    public void setColor(String color){this.color = color;}
    public boolean isFilled(){return filled;}
    public void setFilled(boolean filled){this.filled = filled;}
    public String toString(){
        if (isFilled()){
            return  "Shape[color="+getColor()+",filled=true]";
        }
        else {return "Shape[color="+getColor()+",filled=none]";}
    }

}

class Circle extends Shape{
    double radious = 1.0;

    public Circle(){}

    public Circle(double radious,String color, boolean filled){
        super(color,filled);
        this.radious= radious;

    }

    public double getRadious() {
        return radious;
    }

    public void setRadious(double radious) {
        this.radious = radious;
    }

    public double getPerimeter(){return 2 * Math.PI * radious; }

    public double getArea() {
        return Math.PI * radious * radious;
    }

    @Override
    public String toString() {
        return  "Circle["+super.toString()+", radius ="+getRadious()+"]";
    }
}


class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {}

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * length;
    }

    public double getPerimeter(){
        return 2*(length+width);

    }

    @Override
    public String toString() {
        return  "Rectangle["+super.toString()+", width ="+getWidth()+",length="+getLength()+"]";
    }
}


class Square extends Rectangle {

    public Square() {}

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    @Override
    public void setWidth(double side) {
        setSide(side);
    }

    @Override
    public void setLength(double side) {
        setSide(side);
    }

    @Override
    public String toString() {
        return "Square["+super.toString() ;
    }
}




class TestShape {
    public static void main(String[] args) {
        Square square = new Square(2);
        Circle circle = new Circle(2,"pink",false);
        Rectangle restangle = new Rectangle(3,4,"black",true);

        System.out.println(square.toString());
        System.out.println(circle.toString());
        System.out.println(restangle.toString());

        System.out.println("The perimeter of square: "+square.getPerimeter());
        System.out.printf("The area of circle: %.2f ",circle.getArea());
    }

}

