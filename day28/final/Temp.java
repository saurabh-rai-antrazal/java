import java.util.*;
import javax.sound.sampled.SourceDataLine;

class A {
    private void method1(){
        System.out.println("private method");
    }
    void method2(){
        System.out.println("default method");
    }
    protected void method3(){
        System.out.println("protected method");
    }
    public void method4(){
        System.out.println("public method");
    }
}

class B extends A {
    @Override
    
}

public class Temp {
    public static void main(String[] args) {
        
    }
}
