package OOP;

public abstract class Shape2 {
    protected String color="red";
    protected boolean filled = true;

    public Shape2(){}


    public Shape2(String color, boolean filled){
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
        else {return  "Shape[color="+getColor()+",filled=none]";}
    }
    public abstract double getPerimeter();
    public abstract double getArea();

}

class Circle extends Shape2{
    protected double radius = 1.0;

    public Circle(){}

    public Circle(double radius, String color, boolean filled){
        super(color,filled);
        this.radius = radius;

    }

    public double getRadius() {
        return radius;
    }



    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPerimeter(){return 2 * Math.PI * radius; }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return  "Circle["+super.toString()+", radius ="+ getRadius()+"]";
    }
}


class Rectangle extends Shape2 {
    protected double width = 1.0;
    protected double length = 1.0;

    public Rectangle(){}

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color,filled);
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
        return "Square["+super.toString();
    }
}




class TestShape {
    public static void main(String[] args) {
        Shape2 s1 = new Circle(5.5, "red", false); // Upcast Circle to Shape
        System.out.println(s1); // which version?
        System.out.println(s1.getArea()); // which version?
        System.out.println(s1.getPerimeter()); // which version?
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
//        System.out.println(s1.getRadius());   error1


        Circle c1 = (Circle)s1; // Downcast back to Circle
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius());

//        Shape2 s2 = new Shape2(); error2

        Shape2 s3 = new Rectangle(1.0, 2.0, "red", false); // Upcast
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
//        System.out.println(s3.getLength()); error3

        Rectangle r1 = (Rectangle)s3; // downcast
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getLength());

        Shape2 s4 = new Square(6.6); // Upcast
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
//        System.out.println(s4.getSide()); error4

// Take note that we downcast Shape s4 to Rectangle,
// which is a superclass of Square, instead of Square
        Rectangle r2 = (Rectangle)s4;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
//        System.out.println(r2.getSide()); error5
        System.out.println(r2.getLength());

// Downcast Rectangle r2 to Square
        Square sq1 = (Square)r2;
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide());
        System.out.println(sq1.getLength());

    }
}