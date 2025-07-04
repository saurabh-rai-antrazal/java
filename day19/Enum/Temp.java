package day19.Enum;

enum Weekday {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);
    // enum is used to create a list of constants
    private int val;
    
    private Weekday(int val){
        System.out.println("constructor called");
        this.val = val;
    }

    public void getVal(){
        System.out.println(val);
    }
}



public class Temp {
    public static void main(String[] args) {
        System.out.println(Weekday.FRIDAY);
        Weekday.MONDAY.getVal();

        for(Weekday wd: Weekday.values()){
            System.out.print(wd + " : ");
            wd.getVal();
        }
    }
}
