package view;

import controller.ZooController;
import model.*;
import utils.animalEnum.AnimalCategory;
import utils.constant.Const;
import utils.validator.InputValidator;

import java.util.List;
import java.util.Map;

/*
 *********************************************************************************************************
 *  @Java Class Name :   ZooView
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This is the view class for ZooController.
 *********************************************************************************************************
 */

public class ZooView {

    public static void zoo(int zooId){
        int opt;
        while (true) {
            zooOptions();
            opt = chooseOption(Const.ZOO_OPTIONS_LIST.length);
            if (opt == 7) {
                System.out.println(Const.EXIT_SUCCESS_MESSAGE);
                return;
            } else if (opt == 1) {
                Animal animal = AnimalView.addNewAnimal(zooId);
                System.out.println(ZooController.addNewAnimal(animal, zooId));
            } else if (opt == 2) {
                Zone zone = ZoneView.createNewZone();
                System.out.println(ZooController.addNewZone(zone, zooId));
            } else if (opt == 3) {
                Map<Integer, String> animalList = ZooController.getAnimalList(zooId);
                if (animalList.isEmpty()) {
                    AnimalView.animalListIsEmpty();
                } else {
                    System.out.println(ZooController.removeDeadAnimal(AnimalView.removeDeadAnimal(animalList), zooId));
                }
            } else if (opt == 4) {
                Map<Integer, String> animalList = ZooController.getAnimalList(zooId);
                if (animalList.isEmpty()) {
                    AnimalView.animalListIsEmpty();
                } else {
                    AnimalView.showAnimalList(animalList);
                }
            } else if (opt == 5) {
                Map<Integer, String> zoneList = ZooController.getZoneList(zooId);
                int maxZoneCnt = ZooController.getMaxZoneCnt(zooId);
                if (zoneList.isEmpty()) {
                    ZoneView.zoneListIsEmpty();
                } else {
                    int zoneId = ZoneView.viewZoneList(zoneList, maxZoneCnt);
                    List<String> zoneInfo = ZooController.getZoneDetails(zoneId);
                    ZoneView.zoneDetails(zoneInfo);
                }
            } else if (opt == 6) {
                List<String> zooInfo = ZooController.getZooDetails(zooId);
                int zoneCnt = 0;
                zoneCnt = ZooController.getZoneList(zooId).size();
                int animalCnt = 0;
                animalCnt = ZooController.getAnimalList(zooId).size();
                zooInfo.add(String.valueOf(zoneCnt));
                zooInfo.add(String.valueOf(animalCnt));
                zooDetails(zooInfo);
            }
        }
    }


    public static void zooOptions(){
        System.out.println(Const.TABLE_BORDER);
        System.out.println(Const.HEADER_NO_OPTION);
        System.out.println(Const.TABLE_BORDER);
        int i = 1;
        for(String str : Const.ZOO_OPTIONS_LIST){
            System.out.printf(Const.ROW_FORMAT, i, str);
            i += 1;
        }
        System.out.println(Const.TABLE_BORDER);
    }

    public static int chooseOption(int optCnt){
        String opt = "";
        boolean flag = false;
        System.out.print(Const.MAIN_MESSAGES[13]);
        while(!flag){
            opt = Const.SCANNER.nextLine();
            flag = InputValidator.isValidOptions(opt) && Integer.parseInt(opt) > 0 && Integer.parseInt(opt) <= optCnt;
            if(flag){
                break;
            }
            else{
                System.out.println(Const.MAIN_MESSAGES[14]);
                System.out.print(Const.MAIN_MESSAGES[15]);
            }
        }
        return Integer.parseInt(opt);
    }


    public static void zooDetails(List<String> zooInfo){
        System.out.println(Const.ZOO_INFO_BORDER);
        System.out.printf(Const.ZOO_ID_ROW, Integer.parseInt(zooInfo.get(0)));
        System.out.printf(Const.ZOO_NAME_ROW, zooInfo.get(1));
        System.out.printf(Const.ZOO_LOCATION_ROW, zooInfo.get(2));
        System.out.printf(Const.ZOO_OWNER_ROW, zooInfo.get(3));
        System.out.printf(Const.ZOO_ZONE_CNT, zooInfo.get(4));
        System.out.printf(Const.ZOO_ANIMALS_CNT, zooInfo.get(5));
        System.out.println(Const.ZOO_INFO_BORDER);
    }

}