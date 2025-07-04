package controller;

import utils.constant.Const;
import model.Zoo;
import service.Service;
import view.MainView;

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

    public static void mainController(){

        int opt;

        while(true){
            MainView.printOptions();
            opt = MainView.chooseOptions(Const.MAIN_OPTIONS_LIST.length);
            if(opt == 1) {
                String[] loginDetails = MainView.loginExistingZoo();
                if(loginDetails[0] != null && loginDetails[1] != null){
                    int zooId = Service.loginExistingZoo(loginDetails);
                    if (zooId != 0) {
                        ZooController.zooController(zooId);
                    }
                }
            }
            else if(opt == 2) {
                Zoo zoo = MainView.createNewZoo();
                int zooId = Service.createNewZoo(zoo);
                ZooController.zooController(zooId);
            }
            else if(opt == 3) {
                return;
            }
        }

    }

}