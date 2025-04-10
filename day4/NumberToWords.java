// Exercise 24
package day4;

public class NumberToWords {
    // write code here
    public static void numberToWords (int number){
        if(number < 0) System.out.print("Invalid Value");
        if(number == 0){
            System.out.print("Zero");
            return;
        }
        
        int cntZeroAtEnd = 0;
        int copyOfNumber = number;
        while(copyOfNumber % 10 == 0){
            cntZeroAtEnd += 1;
            copyOfNumber /= 10;
        }
        
        int reverseNum = reverse(number);
        String str = "";
        while(reverseNum > 0){
            if(str.length() > 0) str += " ";
            int temp = reverseNum % 10;
            switch(temp){
                case 0 -> str += "Zero";
                case 1 -> str += "One";
                case 2 -> str += "Two";
                case 3 -> str += "Three";
                case 4 -> str += "Four";
                case 5 -> str += "Five";
                case 6 -> str += "Six";
                case 7 -> str += "Seven";
                case 8 -> str += "Eight";
                case 9 -> str += "Nine";
            }
            reverseNum /= 10;
        }
        
        while(cntZeroAtEnd > 0){
            str += " Zero";
            cntZeroAtEnd -= 1;
        }
        
        System.out.print(str);
    }
    
    public static int reverse (int num){
        boolean isNeg = false;
        if(num < 0) isNeg = true;
        int val = 0;
        num = Math.abs(num);
        while(num > 0){
            val *= 10;
            val += num % 10;
            num /= 10;
        }
        return isNeg ? val * -1 : val;
    }
    
    public static int getDigitCount (int number){
        if(number < 0) return -1;
        if(number == 0) return 1;
        int digitCnt = 0;
        while(number > 0){
            digitCnt += 1;
            number /= 10;
        }
        return digitCnt;
    }
}
