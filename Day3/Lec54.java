import java.util.*;

public class Lec54{
    public static String getDurationString(int second){

        if(second < 0) return "Invalid Data";

        int hr = second / 3600;
        second %= 3600;
        int minutes = second / 60;
        second %= 60;

        return "" + hr + "h " + minutes + "m " + second + "s";
    }

    public static String getDurationString(int minutes, int second){
        if(minutes < 0 || second < 0) return "Invalid Data";
        return getDurationString(second + minutes * 60);
    }

    public static void main(String[] args){
        System.out.println(getDurationString(3200));
        System.out.println(getDurationString(-320, 60));
        System.out.println(getDurationString(65, 145));
    }
}