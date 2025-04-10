public class IntEqualityPrinter {
    // write code here
    public static void printEqual(int a, int b, int c){
        if(a < 0 || b < 0 || c < 0){
            System.out.print("Invalid Value");
            return;
        }
        if(a == b && b == c) System.out.print("All numbers are equal");
        else if(a != b && b != c && c != a) System.out.print("All numbers are different");
        else System.out.print("Neither all are equal or different");
    }
}