import java.util.*;

public class ReverseArray {
    // write code here
   private static void reverse(int[] arr)
   {
       System.out.println("Array = " + Arrays.toString(arr));
       
       for(int i = 0; i<arr.length/2; i++)
       {
           int temp = arr[arr.length - i - 1];
           arr[arr.length - i - 1] = arr[i];
           arr[i] = temp;
       }
       
       System.out.println("Reversed array = " + Arrays.toString(arr));
       
       
   }
}