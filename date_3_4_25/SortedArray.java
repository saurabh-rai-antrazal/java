import java.util.*;

public class SortedArray {
    private static Scanner sc = new Scanner(System.in);

    public static int[] getIntegers(int len) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element " + i + " contents " + arr[i]);
        }
    }
    
    public static int[] sortIntegers(int[] arr){
        int[] sortedArr = new int[arr.length];
        Arrays.sort(arr);
        int i = arr.length - 1;
        int j = 0;
        while(i >= 0){
            sortedArr[j] = arr[i]; 
            i -= 1;
            j += 1;
        }
        return sortedArr;
    }
    
}
