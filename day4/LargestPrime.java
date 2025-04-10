// Exercise 26

package day4;

public class LargestPrime {
    // write code here
    public static int getLargestPrime (int num){
        int i = num;
        while(i >= 2){
            if(num % i == 0){
                int j = i - 1;
                boolean isPrime = true;
                while(j >= 2 && isPrime){
                    if(i % j == 0) isPrime = false;
                    j -= 1;
                }
                if(isPrime) return i;
            }
            i -= 1;
        }
        return -1;
    }
}
