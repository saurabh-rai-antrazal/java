import org.omg.CORBA.PUBLIC_MEMBER;

public class Lec67 {

    public static void digitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        System.out.println(sum);
    }

    public static void main(String[] args){
        digitSum(4567);
    }
}
