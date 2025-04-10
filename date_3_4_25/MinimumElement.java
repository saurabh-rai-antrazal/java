
import java.util.*;

public class MinimumElement {
    // write code here
    private static Scanner sc = new Scanner(System.in);

    private static int readInteger() {
        int len = sc.nextInt();
        return len;
    }

    private static int[] readElements(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private static int findMin(int[] arr) {
        int mn = Integer.MAX_VALUE;
        for (int it : arr) {
            mn = Math.min(mn, it);
        }
        return mn;
    }
    
    
}