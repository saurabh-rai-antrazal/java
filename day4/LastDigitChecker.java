// Exercise 20

package day4;

public class LastDigitChecker {
    // write code here
    public static boolean isValid(int num){
        return ((num >= 10) && (num <= 1000));
    }
    
    public static boolean hasSameLastDigit(int a, int b, int c){
        if(!isValid(a)) return false;
        if(!isValid(b)) return false;
        if(!isValid(c)) return false;
        return ((a % 10) == (b % 10) || (b % 10) == (c % 10) || (c % 10) == (a % 10));
    }
}
