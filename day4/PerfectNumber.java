// exercise 23
package day4;

public class PerfectNumber {
    // write code here
    public static boolean isPerfectNumber (int number){
        if(number <= 0) return false;
        int i = 1;
        int sum = 0;
        while(i < number){
            if(number % i == 0) sum += i;
            i += 1;
        }
        return sum == number;
    }
    
}
