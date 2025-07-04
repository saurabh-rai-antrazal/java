package day21.Interface;

class A {
    A() {
        System.out.println("constructor A");
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}

// An abstract class can extend a concrete class
abstract class B extends A {
    abstract public void meth3();
}

interface I1 {
    public void meth1();
}

// An abstract class can implement an interface
abstract class A1 implements I1 {
    abstract public void meth2();
}

public class Temp2 {
    public static void main(String[] args) {
        
    }
}
