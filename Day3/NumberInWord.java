public class NumberInWord {
    // write code here
    public static void printNumberInWord(int num){
        switch (num) {
            case 0 -> System.out.print("ZERO");
            case 1 -> System.out.print("ONE");
            case 2 -> System.out.print("TWO");
            case 3 -> System.out.print("THREE");
            case 4 -> System.out.print("FOUR");
            case 5 -> System.out.print("FIVE");
            case 6 -> System.out.print("SIX");
            case 7 -> System.out.print("SEVEN");
            case 8 -> System.out.print("EIGHT");
            case 9 -> System.out.print("NINE");
            default -> System.out.print("OTHER");
        }
    }
}