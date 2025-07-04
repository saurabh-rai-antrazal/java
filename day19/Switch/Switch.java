package day19.Switch;

public class Switch {
    public static void main(String[] args) {
        int val = 3;
        String temp = switch (val) {

            // old switch case
            case 2, 3, 4, 5, 6 : "weekday";
            break;
            default : "weekend"


            // case 2, 3, 4, 5, 6 -> "Weekday";
            // default -> "weekend";
            // here we dont need to write yeild keyword

            // case 2, 3, 4, 5, 6 -> {
            //     yield "weekday";
            // }
            // default -> {
            //     yield "weekend";
            // }
        };

    }
}
