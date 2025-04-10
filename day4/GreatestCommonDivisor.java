// exercise 22
package day4;

public class GreatestCommonDivisor {
    // write code here
    public static int getGreatestCommonDivisor (int a, int b){
        if(a < 10 || b < 10) return -1;
        int temp = Math.min(a, b);
        while(temp > 0){
            if(a % temp == 0 && b % temp == 0) return temp;
            temp -= 1;
        }
        return 1;
    }
     
} 

