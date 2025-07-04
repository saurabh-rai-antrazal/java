package utils.validator;

import java.util.regex.Pattern;

/*
 *********************************************************************************************************
 *  @Java Class Name :   InputValidator
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class having all validators
 *********************************************************************************************************
 */

public class InputValidator {

    public static boolean isValidName(String name){
        return Pattern.matches("^[a-zA-Z]{5,30}$", name);
    }

    public static boolean isValidAge(String age){
        return Pattern.matches("^[1-9][0-9]{0,2}$", age);
    }

    public static boolean isValidWeight(String weight){
        weight = weight.trim();
        // Integer weight (1-9999)
        if (Pattern.matches("^[1-9][0-9]{0,3}$", weight)) return true;
        // Decimal weight (1.0-9999.999...)
        return Pattern.matches("^[1-9][0-9]{0,3}\\.[0-9]+$", weight);
    }

    public static boolean isValidOptions(String opt){
        return Pattern.matches("^[1-9][0-9]{0,5}$", opt);
    }

    public static boolean isZero(String opt){
        return Pattern.matches("^0$", opt);
    }

    public static boolean isValidPassword(String pass) {
        return Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$", pass);
    }

    public static boolean isValidUsername(String un){
        return Pattern.matches("^[A-Za-z]{1}[a-zA-Z0-9]{3,29}$", un);
    }

    public static boolean isValidBooleanCharacter(String ch){
        return Pattern.matches("^[YNyn]$", ch);
    }
}
