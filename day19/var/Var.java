package day19.var;

class outerClass {

    /*
    * The 'var' keyword follows local scope.
    * We can't use it outside the local scope.
    * It is mostly used with generics to enhance readability.
    * It can't be a return type of any method.
    * We can't use it in method parameters.
    */

    // var x; 
    // outerClass(var val){
    //     this.x = val;
    // }

    public static void fun(){
        var x = "hello";
        System.out.println("function " + x);
    }

}


public class Var {
    public static void main(String[] args) {
        outerClass.fun();
    }

}
