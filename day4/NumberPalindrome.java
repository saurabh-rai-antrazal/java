
// Exercise 16
package day4;

public class NumberPalindrome {
    // write code here
    public static boolean isPalindrome (int number){
        String str = "" + Math.abs(number);
        int i = 0;
        int len = str.length();
        while(i <= len - i - 1){
            if(str.charAt(i) != str.charAt(len - i - 1)) return false;
            i += 1;
        }
        return true;
    }
}
