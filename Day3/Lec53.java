import java.util.*;

public class Lec53{
    public static double convertToCentimeters(int inches){
        return inches * 2.54D;
    }

    public static double convertToCentimeters(int heightInFeet, int remainingHeightInINches){
        return convertToCentimeters(heightInFeet * 12) + convertToCentimeters(remainingHeightInINches);
    }
    public static void main(String[] args){
        System.out.println(convertToCentimeters(45) + " cm");
        System.out.println(convertToCentimeters(6,0) + " cm");
    }
}