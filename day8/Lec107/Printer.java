package day8.smartKitchen.Lec107;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel){
        this(tonerLevel, false);
    }

    public Printer(int tonerLevel, boolean duplex){
        this.pagesPrinted = 0;
        this.addToner(tonerLevel);
        this.duplex = duplex;
    }

    public int getPagesPrinted(){
        return pagesPrinted;
    }

    public int getTonerLevel(){
        return tonerLevel;
    }

    public boolean isDuplexPrinter(){
        return duplex;
    }

    public void setDuplex(boolean duplex){
        this.duplex = duplex;
    }


    public int addToner(int tonerLevel){
        if(tonerLevel < 0 && tonerLevel > 100){
            return -1;
        }
        this.tonerLevel = tonerLevel;
        return this.tonerLevel;
    }

    public int printPages(int pages){
        if(duplex){
            System.out.println("It's a duplex printer.");
        }
        int printed = (pages / 2) + (pages % 2);
        this.pagesPrinted += printed;
        System.out.println((printed) + " Pages printed");
        return printed;
    }
}
