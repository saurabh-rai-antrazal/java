package day25;

// inheritance

class Super {
    
    public void fun(){
        System.out.println("super fxn");
    }

    public static void className(){
        System.out.println("Super");
    }
}

class Sub extends Super {
    @Override
    public void fun(){
        System.out.println("sub fxn");
    }

    public static void className(){
        System.out.println("sub");
    }
}

public class Temp {
    public static void main(String[] args){
        Super obj1 = new Sub(); // pc
        Super obj2 = new Super(); // pp
        Sub obj3 = new Sub(); // cc

        obj1.fun();
        obj2.fun();
        obj3.fun();

        obj1.className();
        obj2.className();
        obj3.className();
    }
}