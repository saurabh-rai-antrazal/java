package controller;

import java.util.List;
import java.util.Map;

import utils.constant.Const;
import repo.ZoneRepo;
import service.Service;
import model.Zone;
import view.ZooView;

/*
 *********************************************************************************************************
 *  @Java Class Name :   ZooController
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class can hold all the operations which you can perform in a zoo.
 *********************************************************************************************************
 */

public class ZooController {

    public static void zooController(int zooId){
        int opt;
        while (true) {
            ZooView.zooOptions();
            opt = ZooView.chooseOption(Const.ZOO_OPTIONS_LIST.length);
            if (opt == 7) {
                System.out.println(Const.EXIT_SUCCESS_MESSAGE);
                return;
            } else if (opt == 1) {
                ZooView.addNewAnimal(zooId);
            } else if (opt == 2) {
                Zone zone = ZooView.createNewZone();
                ZoneRepo.addNewZone(zone, zooId);
            } else if (opt == 3) {
                Map<Integer, String> animalList = Service.getAnimalList(zooId);
                if (animalList.isEmpty()) {
                    ZooView.animalListIsEmpty();
                } else {
                    Service.removeDeadAnimal(ZooView.removeDeadAnimal(animalList), zooId);
                }
            } else if (opt == 4) {
                Map<Integer, String> animalList = Service.getAnimalList(zooId);
                if (animalList.isEmpty()) {
                    ZooView.animalListIsEmpty();
                } else {
                    ZooView.showAnimalList(animalList);
                }
            } else if (opt == 5) {
                Map<Integer, String> zoneList = Service.getZoneList(zooId);
                int maxZoneCnt = Service.getMaxZoneCnt(zooId);
                if (zoneList.isEmpty()) {
                    ZooView.zoneListIsEmpty();
                } else {
                    int zoneId = ZooView.viewZoneList(zoneList, maxZoneCnt);
                    List<String> zoneInfo = Service.getZoneDetails(zoneId);
                    ZooView.zoneDetails(zoneInfo);
                }
            } else if (opt == 6) {
                List<String> zooInfo = Service.getZooDetails(zooId);
                int zoneCnt = 0;
                zoneCnt = Service.getZoneList(zooId).size();
                int animalCnt = 0;
                animalCnt = Service.getAnimalList(zooId).size();
                zooInfo.add(String.valueOf(zoneCnt));
                zooInfo.add(String.valueOf(animalCnt));
                ZooView.zooDetails(zooInfo);
            }
        }
    }
}
