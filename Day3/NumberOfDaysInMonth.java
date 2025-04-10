public class NumberOfDaysInMonth {
    // write code here
    public static boolean isLeapYear (int year){
        if(year > 0 && year <10000){
            if(year % 400 == 0) return true;
            if(year % 100 == 0) return false;
            if(year % 4 == 0) return true;
            return false;
        } 
        return false;
    }
    
    public static int getDaysInMonth (int month, int year){
        if(month < 1 || month > 12) return -1;
        if(year < 1 || year > 9999) return -1;
        int days;
        switch(month){
            case 1, 3, 5, 7, 8, 10, 12 -> days = 31;
            case 2 -> {
                if(isLeapYear(year) == true) days = 29;
                else days = 28;
            }
            default -> days = 30;
        }
        return days;
    }
}