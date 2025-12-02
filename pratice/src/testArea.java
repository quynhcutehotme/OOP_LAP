package OOP;

interface Shape {
    double area();
}

class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }
    @Override
    public double area() {
        return side * side;
    }
}

class AreaCalculator {
    public double totalArea(Shape[] shapes) {
        double total = 0;
        for (Shape s : shapes) {
            total += s.area();
        }
        return total;
    }
}

class Triangle implements Shape {
    private final double base;
    private final double height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double area() {
        // Area of a triangle is 0.5 * base * height
        return 0.5 * base * height;
    }
}

public class testArea {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
                new Circle(5.0),
                new Square(4.0)
        };

        AreaCalculator calculator = new AreaCalculator();
        double initialTotalArea = calculator.totalArea(shapes);

        System.out.println("--- Initial Calculation ---");
        System.out.println("Area of Circle (r=5.0): " + new Circle(5.0).area());
        System.out.println("Area of Square (s=4.0): " + new Square(4.0).area());
        System.out.println("Total Area: " + initialTotalArea);}}