package day29.Lec;

public class Lec290 {
    public static void main(String[] args) {
        String str = "Hello, World!";
        System.out.println(str.matches("Hello, World!"));


        String regex = "^[A-Z]{1}[a-zA-z ]*\\."; // or "[A-Z].*\\."
     


        str = "The bike is red.";

        System.out.println(str.matches(regex));


        // regex = "[A-Z].*[!?.]"; // or "[A-Z].*\\p";
        regex = "[A-Z].*[\\p]";

        System.out.println(str.matches(regex));



    }
}
