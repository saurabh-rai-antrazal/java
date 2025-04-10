public class Lec66_2 {
    public static boolean isEvenNumber(int num){
        return (num % 2) == 0;
    }

    public static void main(String[] args){
        int oddCnt = 0, evenCnt = 0;
        int i = 5;
        while(i < 20 && evenCnt < 5){
            if(isEvenNumber(i)) evenCnt += 1;
            else oddCnt += 1;
            i += 1;
        }
        System.out.println("Even count : " + evenCnt + " , Odd count : " + oddCnt + ".");
    }
}
