public class MinutesToYearsDaysCalculator {
    // write code here
    public static void printYearsAndDays (long minutes){
        if(minutes < 0) System.out.print("Invalid Value");
        else{
            long copyMinutes = minutes;
            long yr = minutes / (1440 * 365);
            minutes %= (1440 * 365);
            long days = minutes / (1440);
            minutes %= 1440;
            // if(minutes > 0) days += 1;
            System.out.print(copyMinutes + " min = " + yr + " y and " + days + " d");
        }
    }
}