package day20.Abstract;

// A class must be abstract if it has at least one abstract method

abstract class Animals {

    // An abstract class can have concrete methods
    public void sleep() {
        System.out.println("sleep...");
    }

    public abstract void makeSound();
}

class Dog extends Animals {

    // The child class must override all abstract methods of the parent class
    // Otherwise, the child class must also be abstract

    @Override
    public void makeSound() {
        System.out.println("bark ...");
    }

}

public class Temp {
    public static void main(String[] args) {

        // Animals dog = new Animals(); 
        // We can't instantiate an abstract class
        // But we can take a reference of an abstract class

        Animals dog = new Dog();
        dog.makeSound();
    }

}
