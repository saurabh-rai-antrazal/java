package view;

import model.Zone;
import utils.animalEnum.AnimalCategory;
import utils.constant.Const;
import utils.validator.InputValidator;

import java.util.List;
import java.util.Map;

/*
 *********************************************************************************************************
 *  @Java Class Name :   ZoneView
 *  @Author          :   <Saurabh rai>(Saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This is the view class for zone.
 *********************************************************************************************************
 */

public class ZoneView {

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
        AnimalView.showAnimalCategory();
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

    public static void zoneListIsEmpty(){
        System.out.println(Const.NO_ZONES_MESSAGE);
    }
}
