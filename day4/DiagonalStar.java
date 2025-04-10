// Exercise 27

package day4;

public class DiagonalStar {
    // write code here
    public static void printSquareStar (int n){
        if(n < 5) System.out.print("Invalid Value");
        else{
            int i = 0;
            while(i < n){
                if(i == 0 || i == n - 1){
                    int j = 0;
                    while(j++ < n) System.out.print("*");
                }
                else{
                    int j = 0;
                    while(j < n){
                        if(j == 0 || j == n - 1 || j == i || i == n - j - 1) System.out.print("*");
                        else System.out.print(" ");
                        j += 1;
                    }
                }
                System.out.println();
                i += 1;
            }
        }
    }
    
}
