
// Exercise 25
package day4;

public class FlourPacker {
    // write code here
    public static boolean canPack (int bigCount, int smallCount, int goal){
        if(bigCount < 0 || smallCount < 0 || goal < 0) return false;
        int i = 0, temp;
        while(i <= bigCount){
            temp = goal - (i * 5);
            if(temp < 0) return false;
            if(temp <= smallCount) return true;
            
            i += 1;
        }
        return false;
    }
}
