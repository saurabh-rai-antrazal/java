package controller;

import service.ZooService;
import model.Zoo;

/*
 *********************************************************************************************************
 *  @Java Class Name :   MainController
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This is the Main Controller Class which has options to log into an existing zoo and create a new zoo.
 *********************************************************************************************************
 */

public class MainController {
    public static int loginExistingZoo(String[] loginDetails){
        return ZooService.loginExistingZoo(loginDetails);
    }

    public static int createNewZoo(Zoo zoo){
        return ZooService.addNewZoo(zoo);
    }
}