package day26.innerClass;

// class A {
//     static class B {
//         public void fun () {
//             System.out.println("class B");
//         }
//     } 


//     public class C {
//         public void fun(){
//             System.out.println("class c");
//         }
//     }

//     private class D{
//         public void fun()
//     }
// }


// inner class
// class A {

//     public int bCnt;
//     public static int aCnt;

//     static {
//         aCnt = 0;
//     }

//     A(){
//         aCnt += 1;
//     }

//     public class B {
//         B(){
//             bCnt += 1;
//         }
//         public void fun(){
//             System.out.println("A = " + aCnt + "  |  B = " + bCnt);
//         }
//     }
// }



// static inner class
// class A {

//     public int bCnt;
//     public static int aCnt;

//     static {
//         aCnt = 0;
//     }

//     A(){
//         aCnt += 1;
//     }

//     public static class B {
//         B(){
//             // bCnt += 1;
//         }
//         public void fun(){
//             System.out.println("A = " + aCnt + "  |  B = ");
//         }
//     }
// }


// anonymous class

interface A {
    public void fun();
}





public class temp {
    public static void main(String[] args) {
        // A.B obj = new A.B();
        // A obj2 = new A();
        // A.B obj3 =new A.B();

    //     obj3.fun();

        // A obj = new A();
        // A.B obj2 = obj. new B();
        // obj2.fun();
        
        A obj = new A() {
            @Override
            public void fun() {
                System.out.println("hello");
            }
        };

        obj.fun();

    }
}
