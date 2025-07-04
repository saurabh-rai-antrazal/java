package day21.Interface;

// All methods of an interface are abstract.
// They must not have any method with a body.
interface I1 {

    public static void hello(){
        System.out.println("hello1");
    }

    public int val = 10;   // All variables of an interface are by default final and static.
    public void math1();
    public void math2();
}

interface I2 {

    public static void hello(){
        System.out.println("hello2");
    }

    // private void priFun();
    default void fun(){
        System.out.println("default method");
    };

    public int val = 10;
    void math2();  // all methods of interface implicitly public and abstarct 
    public void meth3();
}

// A child class must override all the methods of the interfaces it implements.
// Otherwise, it must be declared as an abstract class.
class Child implements I1, I2 {
    // public int val = 10;
    @Override
    public void math1() {
        System.out.println("math1");
    }

    @Override
    public void math2() {
        System.out.println("math2");
    }

    @Override
    public void meth3() {
        System.out.println("math3");
    }
}

class C1 {
    public final int val = 100;
}

public class Temp {
    public static void main(String[] args) {
        System.out.println(I2.val);
        System.out.println(I1.val);
        Child obj = new Child();
        // obj.hello();
        obj.fun();
        // System.out.println(obj.val);   // This line will cause an error because val is ambiguous.
        System.out.println(new C1().val);

        I1.hello();
    }
}
