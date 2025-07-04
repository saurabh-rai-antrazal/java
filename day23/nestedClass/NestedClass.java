package day23.nestedClass;


class Outer_Test {
    int num;

    private class Inner_Test {
       public void print() {
          System.out.println("This is an Our inner class");
       }
    }
     
    void display_Inner() {
       Inner_Test inner = new Inner_Test();
       inner.print();
    }
}
     

class outer {

    int val1 = 10;
    static int val2 = 20;

    static class inner{
        {
            System.out.println(val2);
            // outer ot = outer.new inner();
            // outer.new inner();
            outer objOt = new outer();
            // inner objIn = new objOt.inner();
            inner objIn = new outer.inner();

            System.out.println(objOt.val1);
            System.out.println(val2);
        }
    }

    private class innerPrivate {
    }

    abstract class InnerAbstract{
        public abstract void fun();
    }


}


public class NestedClass {
    public static void main(String[] args) {
        new outer.inner();

        outer ot = new outer();

        outer.InnerAbstract ia = new outer(). new InnerAbstract() {
            @Override
            public void fun(){
                System.out.println("Hello");
            }
        };
    }
}

