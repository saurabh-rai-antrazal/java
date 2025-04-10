
// Exercise 18
package day4;

public class EvenDigitSum {
    public static int getEvenDigitSum (int number){
        if(number < 0) return -1;
        int evenSum = 0, rem;
        while(number > 0){
            rem = number % 10;
            evenSum += (rem % 2 == 0) ? rem : 0 ;
            number /= 10;
        }
        return evenSum;
    }
}
