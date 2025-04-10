public class Lec61 {

    public static void calculateIntrest(double ammount){
        for(double intrest = 7.5; intrest <= 10; intrest += 0.25){
            System.out.println(ammount * (intrest / 100D));
        }
    }

    public static void main(String[] args) {
        calculateIntrest(100);
    }
}
