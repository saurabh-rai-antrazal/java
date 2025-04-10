package day8.smartKitchen.Lec107;

public class TestPrinter {
    public static void main(String[] args){
        Printer printer = new Printer(30, false);

        System.out.println(printer.getTonerLevel() + " " + printer.getPagesPrinted() + " " + printer.isDuplexPrinter());

        printer.printPages(9);
        System.out.println(printer.getPagesPrinted());
    }
}
