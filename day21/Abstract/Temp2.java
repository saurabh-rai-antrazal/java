package day21.Abstract;

abstract class Shape_2D {
    abstract double area();
    abstract double perimeter(); 
}

abstract class Shape_3D {
    abstract double volume();
}

class Rectangle extends Shape_2D {
    
    private double length;
    private double width;
    
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

class Cube extends Shape_3D {
    private double length;
    private double width;
    private double height;
    
    public Cube(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    double volume() {
        return length * width * height;
    }
}

public class Temp2 {
    public static void main(String[] args) {
        Shape_3D cube = new Cube(10, 15, 5);
        System.out.println(cube.volume());

        Shape_2D rectangle = new Rectangle(10, 5);
        System.out.println(rectangle.area());
        System.out.println(rectangle.perimeter());
    }
}
