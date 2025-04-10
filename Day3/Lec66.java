public class Lec66 {
    public static boolean isEvenNumber(int num){
        return (num % 2) == 0;
    }

    public static void main(String[] args){
        int i = 5;
        while(i <= 20){

            if(isEvenNumber(i)) System.out.println(i);
            i += 1;
        }
    }
}