// exercise 19

package day4;

public class SharedDigit {
    // write code here
    public static boolean hasSharedDigit (int a, int b){
        if(a > 99 || a < 10 || b > 99 || b < 10) return false;
        while(a > 0){
            int temp = a % 10;
            int copyOfB = b;
            while(copyOfB > 0){
                if(temp == copyOfB % 10) return true;
                copyOfB /= 10;
            }
            a /= 10;
        }
        return false;
    }
}
