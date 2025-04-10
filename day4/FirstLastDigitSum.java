// Exercise 17

package day4;

public class FirstLastDigitSum {
    // write code here
    
    public static int sumFirstAndLastDigit (int number){
        if(number < 0) return -1;
        String str = "" + number;
        int len = str.length();
        return str.charAt(0) - '0' + str.charAt(len - 1) - '0';
    }
}