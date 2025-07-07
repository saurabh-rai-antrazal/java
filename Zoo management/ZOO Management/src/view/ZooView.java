package view;

import controller.ZooController;
import model.*;
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
                Animal animal = addNewAnimal(zooId);
                System.out.println(ZooController.addNewAnimal(animal, zooId));
            } else if (opt == 2) {
                Zone zone = createNewZone();
                System.out.println(ZooController.addNewZone(zone, zooId));
            } else if (opt == 3) {
                Map<Integer, String> animalList = ZooController.getAnimalList(zooId);
                if (animalList.isEmpty()) {
                    animalListIsEmpty();
                } else {
                    System.out.println(ZooController.removeDeadAnimal(removeDeadAnimal(animalList), zooId));
                }
            } else if (opt == 4) {
                Map<Integer, String> animalList = ZooController.getAnimalList(zooId);
                if (animalList.isEmpty()) {
                    ZooView.animalListIsEmpty();
                } else {
                    showAnimalList(animalList);
                }
            } else if (opt == 5) {
                Map<Integer, String> zoneList = ZooController.getZoneList(zooId);
                int maxZoneCnt = ZooController.getMaxZoneCnt(zooId);
                if (zoneList.isEmpty()) {
                    zoneListIsEmpty();
                } else {
                    int zoneId = viewZoneList(zoneList, maxZoneCnt);
                    List<String> zoneInfo = ZooController.getZoneDetails(zoneId);
                    zoneDetails(zoneInfo);
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
    

    public static void printAnimalsName(){
        System.out.println(Const.TABLE_BORDER);
        System.out.println(Const.HEADER_NO_NAME);
        System.out.println(Const.TABLE_BORDER);
        for (int i = 1; i <= Const.ANIMALS_LIST.length; i++) {
            System.out.printf(Const.ROW_FORMAT,i, Const.ANIMALS_LIST[i-1][0]);
        }
        System.out.println(Const.TABLE_BORDER);
    }


    public static Animal addNewAnimal(int zooId){
        Animal animal = null;
        int opt;
        System.out.println(Const.ZOO_MESSAGES[0]);
        printAnimalsName();
        opt = chooseOption(Const.ANIMALS_LIST.length + 1);
        String name = Const.ANIMALS_LIST[opt - 1][0];
        String category = Const.ANIMALS_LIST[opt - 1][1];
        String sound = Const.ANIMALS_LIST[opt - 1][2];
        int perCageCapacity = Integer.parseInt(Const.ANIMALS_LIST[opt - 1][3]);
        boolean flag = false;
        int age;
        String ip = "";
        System.out.print(Const.ZOO_MESSAGES[1]);
        while(!flag){
            ip = Const.SCANNER.nextLine();
            flag = (InputValidator.isValidAge(ip) && Integer.parseInt(ip) <= 100);
            if (!flag) {
                System.out.print(Const.ZOO_MESSAGES[2]);
            }
        }
        age = Integer.parseInt(ip);
        flag = false;
        double weight;
        ip = "";
        System.out.print(Const.ZOO_MESSAGES[3]);
        while(!flag){
            ip = Const.SCANNER.nextLine();
            flag = (InputValidator.isValidWeight(ip) && Double.parseDouble(ip) <= 1001);
            if (!flag) {
                System.out.print(Const.ZOO_MESSAGES[4]);
            }
        }
        weight = Math.round(Double.parseDouble(ip) * 100.0) / 100.0;
        if(category.equalsIgnoreCase(AnimalCategory.MAMMAL.toString())) {
            animal = new Mammal(category, name, age, weight, sound, perCageCapacity);
        }
        if(category.equalsIgnoreCase(AnimalCategory.BIRD.toString())) {
            animal = new Bird(category, name, age, weight, sound, perCageCapacity);
        }
        if(category.equalsIgnoreCase(AnimalCategory.REPTILE.toString())) {
            animal = new Reptile(category, name, age, weight, sound, perCageCapacity);
        }
        if(category.equalsIgnoreCase(AnimalCategory.FISH.toString())) {
            animal = new Fish(category, name, age, weight, sound, perCageCapacity);
        }
        return animal;
    }

    public static Zone createNewZone(){
        String ip = "";
        boolean flag = false;
        boolean hasPark = false;
        boolean hasCanteen = false;
        String zoneCategory;
        Zone zone = null;
        System.out.print(Const.ZOO_MESSAGES[5]);
        while(!flag){
            ip = Const.SCANNER.nextLine();
            flag = (InputValidator.isValidBooleanCharacter(ip));
            if (!flag) {
                System.out.print(Const.ZOO_MESSAGES[6]);
            }
        }
        hasPark = ("y".equals(ip) || "Y".equals(ip));
        flag = false;
        System.out.print(Const.ZOO_MESSAGES[7]);
        while(!flag){
            ip = Const.SCANNER.nextLine();
            flag = (InputValidator.isValidBooleanCharacter(ip));
            if (!flag) {
                System.out.print(Const.ZOO_MESSAGES[6]);
            }
        }
        hasCanteen = ("y".equals(ip) || "Y".equals(ip));
        flag = false;
        showAnimalCategory();
        System.out.println(Const.ZOO_MESSAGES[10]);
        while(!flag){
            ip = Const.SCANNER.nextLine();
            flag = (InputValidator.isValidOptions(ip) && Integer.parseInt(ip) <= 4 && Integer.parseInt(ip) >= 1);
            if (!flag) {
                System.out.println(Const.ZOO_MESSAGES[11]);
            }
        }
        zoneCategory = AnimalCategory.values()[Integer.parseInt(ip) - 1].name();
        zone = new Zone(zoneCategory, hasPark, hasCanteen);
        return zone;
    }


    public static int removeDeadAnimal(Map<Integer, String> animalList){
        showAnimalList(animalList);
        String animalId = "";
        boolean flag = false;
        System.out.print(Const.ZOO_MESSAGES[8]);
        while (!flag) {
            animalId = Const.SCANNER.nextLine();
            flag = (InputValidator.isValidOptions(animalId) && animalList.get(Integer.parseInt(animalId)) != null);
            if (!flag) {
                System.out.print(Const.ZOO_MESSAGES[9]);
            }
        }
        return Integer.parseInt(animalId);
    }

    public static void showAnimalList(Map<Integer, String> animalList) {
            System.out.println(Const.TABLE_BORDER);
            System.out.println(Const.HEADER_ID_ANIMAL);
            System.out.println(Const.TABLE_BORDER);
            int i = 1;
            animalList.forEach((K, V) -> System.out.printf(Const.ROW_FORMAT, K, V));
            System.out.println(Const.TABLE_BORDER);
    }


    public static void showAnimalCategory(){
        System.out.println(Const.TABLE_BORDER);
        System.out.println(Const.HEADER_NO_OPTION);
        System.out.println(Const.TABLE_BORDER);
        int i = 1;
        for(AnimalCategory animalCategory : AnimalCategory.values()){
            System.out.printf(Const.ROW_FORMAT,i , animalCategory.name());
            i += 1;
        }
        System.out.println(Const.TABLE_BORDER);
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

    public static int viewZoneList(Map<Integer, String> zoneList, int maxZoneCnt ) {
        System.out.println(Const.TABLE_BORDER);
        System.out.println(Const.HEADER_ID_ZONE);
        System.out.println(Const.TABLE_BORDER);
        zoneList.forEach((K, V) -> System.out.printf(Const.ROW_FORMAT, K, V));
        System.out.println(Const.TABLE_BORDER);
        System.out.printf(Const.REMAINING_ZONES_ROW_FORMAT, maxZoneCnt - zoneList.size());
        System.out.println(Const.TABLE_BORDER);
        boolean flag = false;
        String ip = "";
        System.out.print(Const.PROMPT_ENTER_ZONE_ID);
        while (!flag) {
            ip = Const.SCANNER.nextLine();
            flag = InputValidator.isValidOptions(ip) && zoneList.get(Integer.parseInt(ip)) != null;
            if (!flag) {
                System.out.print(Const.ERROR_INVALID_ZONE_ID);
            }
        }
        return Integer.parseInt(ip);
    }

    public static void zoneDetails(List<String> zoneInfo){
        System.out.println(Const.ZONE_INFO_BORDER);
        System.out.printf(Const.ZONE_ID_ROW, zoneInfo.get(0));
        System.out.printf(Const.ANIMAL_CATEGORY_ROW, zoneInfo.get(1));
        System.out.printf(Const.TOTAL_CAGES_ROW, zoneInfo.get(2) == null ? "0" : zoneInfo.get(2));
        System.out.printf(Const.TOTAL_ANIMALS_ROW, zoneInfo.get(3) == null ? "0" : zoneInfo.get(3));
        System.out.printf(Const.HAS_PARK_ROW, zoneInfo.get(4).equalsIgnoreCase("y") ? Const.Y : Const.N);
        System.out.printf(Const.HAS_CANTEEN_ROW, zoneInfo.get(5).equalsIgnoreCase("y") ? Const.Y : Const.N);
        System.out.println(Const.ZONE_INFO_BORDER);
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

    public static void animalListIsEmpty(){
        System.out.println(Const.NO_ANIMALS_MESSAGE);
    }

    public static void zoneListIsEmpty(){
        System.out.println(Const.NO_ZONES_MESSAGE);
    }

}