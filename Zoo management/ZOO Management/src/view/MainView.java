package view;

import controller.MainController;
import utils.constant.Const;
import model.Zoo;
import utils.validator.InputValidator;

/*
 *********************************************************************************************************
 *  @Java Class Name :   MainView
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This is the view class for MainController.
 *********************************************************************************************************
 */

public class MainView {

    public static void loginAndSignup(){
        int opt;
        while(true){
            MainView.printOptions();
            opt = chooseOptions(Const.MAIN_OPTIONS_LIST.length);
            if(opt == 1) {
                String[] loginDetails = loginExistingZoo();
                if(loginDetails[0] != null && loginDetails[1] != null){
                    int zooId = MainController.loginExistingZoo(loginDetails);
                    if (zooId > 0) {
                        System.out.println(Const.SUCCESS_LOGIN);
                        ZooView.zoo(zooId);
                    }
                    else if(zooId == -1){
                        System.out.println(Const.ERROR_USERNAME_NOT_FOUND);
                    }
                    else {
                        System.out.println(Const.ERROR_LOGIN_FAILED);
                    }
                }
            }
            else if(opt == 2) {
                Zoo zoo = createNewZoo();
                int zooId = MainController.createNewZoo(zoo);
                if(zooId == -1){
                    System.out.println(Const.ERROR_USERNAME_ALREADY_TAKEN);
                }
                else if (zooId > 0) {
                    System.out.println(Const.SUCCESS_ZOO_CREATED);
                    ZooView.zoo(zooId);
                }
            }
            else if(opt == 3) {
                return;
            }
        }

    }

    public static Zoo createNewZoo(){

        String name = "";
        String location = "";
        String zooOwnerName = "";
        String username = "";
        String password = "";
        int zoneCnt = 0;

        String input = "";

        boolean flag = false;
        System.out.print(Const.MAIN_MESSAGES[0]);
        while(!flag){
            name = Const.SCANNER.nextLine();
            flag = InputValidator.isValidName(name);
            if(flag){}
            else{
                System.out.print(Const.MAIN_MESSAGES[1]);
            }
        }

        flag = false;
        System.out.print(Const.MAIN_MESSAGES[2]);
        while(!flag){
            location = Const.SCANNER.nextLine();
            flag = InputValidator.isValidName(location);
            if(flag){}
            else{
                System.out.print(Const.MAIN_MESSAGES[3]);
            }
        }

        flag = false;
        System.out.print(Const.MAIN_MESSAGES[4]);
        while(!flag){
            zooOwnerName = Const.SCANNER.nextLine();
            flag = InputValidator.isValidName(zooOwnerName);
            if(flag){}
            else{
                System.out.print(Const.MAIN_MESSAGES[5]);
            }
        }

        flag = false;
        System.out.print(Const.MAIN_MESSAGES[6]);
        while(!flag){
            username = Const.SCANNER.nextLine();
            flag = InputValidator.isValidUsername(username);
            if(flag){}
            else{
                System.out.print(Const.MAIN_MESSAGES[7]);
            }
        }

        flag = false;
        System.out.print(Const.MAIN_MESSAGES[8]);
        while(!flag){
            password = Const.SCANNER.nextLine();
            flag = InputValidator.isValidPassword(password);
            if(flag){}
            else{
                System.out.print(Const.MAIN_MESSAGES[9]);
            }
        }

        flag = false;
        System.out.print(Const.MAIN_MESSAGES[10]);
        while(!flag){
            input = Const.SCANNER.nextLine();
            flag = InputValidator.isValidOptions(input);
            if(flag){
                zoneCnt = Integer.parseInt(input);
            }
            else{
                System.out.print(Const.MAIN_MESSAGES[11]);
            }
        }

        Zoo zoo = new Zoo(name, location, zooOwnerName, username, password, zoneCnt);

        return zoo;
    }

    public static String[] loginExistingZoo(){
        String username = "";
        String password = "";
        boolean flag = false;
        String[] loginDetails = new String[2];

        System.out.print(Const.MAIN_MESSAGES[6]);
        while(!flag){
            username = Const.SCANNER.nextLine();
            flag = InputValidator.isValidUsername(username);
            if(flag){}
            else{
                System.out.print(Const.MAIN_MESSAGES[7]);
            }
        }

        System.out.print(Const.MAIN_MESSAGES[8]);
        int limit = 3;
        while(limit > 0){
            password = Const.SCANNER.nextLine();
            if(InputValidator.isValidPassword(password)){
                loginDetails[0] = username;
                loginDetails[1] = password;
                break;
            }
            else{
                limit -= 1;
                if(limit != 0){
                    System.out.printf(Const.MAIN_MESSAGES[12], limit);
                    System.out.print(Const.MAIN_MESSAGES[9]);
                }
            }
        }

        return loginDetails;
    }

    public static void printOptions(){
        System.out.println(Const.TABLE_BORDER);
        System.out.println(Const.HEADER_NO_OPTION);
        System.out.println(Const.TABLE_BORDER);

        int i = 1;
        for(String str : Const.MAIN_OPTIONS_LIST){
            System.out.printf(Const.ROW_FORMAT, i, str);
            i++;
        }
        System.out.println(Const.TABLE_BORDER);
    }

    public static int chooseOptions(int optCnt){
        String opt="";
        boolean flag = false;
        System.out.print(Const.MAIN_MESSAGES[13]);
        while(!flag){
            opt = Const.SCANNER.nextLine();
            flag = (InputValidator.isValidOptions(opt) &&Integer.parseInt(opt) > 0 && Integer.parseInt(opt) <= optCnt);
            if(flag){}
            else{
                System.out.println(Const.MAIN_MESSAGES[14]);
                System.out.print(Const.MAIN_MESSAGES[15]);
            }
        }
        return Integer.parseInt(opt);
    }
}
