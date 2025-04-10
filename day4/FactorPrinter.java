
// Exercise 21
package day4;

public class FactorPrinter {
    // write code here
    public static void printFactors (int num){
        if(num < 0) System.out.print("Invalid Value"); 
        int i = 1;
        while(i <= num){
            if(num % i == 0) System.out.print(i + " ");
            i += 1;
        }
    }
}
