package day5.inheritance;

class Circle {
    double radius;
    Circle (double radius){
        this.radius = radius;
    }
    double area(){
        return Math.PI * radius * radius;
    }
    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Cylinder extends Circle{
    double height;
    
    Cylinder (double radius, double height){
        this.radius = radius;
        this.height = height;
    }

    double volume(){
        return Math.PI * radius * radius * height;
    }

}

public class Inheritance {
    public static void main(String[] args) {
        
    }
}
