package controller;

import java.util.List;
import java.util.Map;

import animals.Animal;
import service.AnimalService;
import service.ZoneService;
import service.ZooService;
import model.Zone;

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

    public static String addNewAnimal(Animal animal, int zooId){
        return AnimalService.addNewAnimal(animal, zooId);
    }

    public static String addNewZone(Zone zone, int zooId){
        return ZoneService.addNewZone(zone, zooId);
    }

    public static Map<Integer, String> getAnimalList(int zooId){
        return AnimalService.getAnimalList(zooId);
    }

    public static String removeDeadAnimal(int animalId, int zooId){
        return AnimalService.removeDeadAnimal(animalId, zooId);
    }

    public static Map<Integer, String> getZoneList(int zooId){
        return ZoneService.getZoneList(zooId);
    }

    public static List<String> getZoneDetails (int zoneId) {
        return ZoneService.getZoneDetails(zoneId);
    }

    public static List<String> getZooDetails(int zooId) {
        return ZooService.getZooDetails(zooId);
    }

    public static int getMaxZoneCnt(int zooId){
        return ZooService.getMaxZoneCnt(zooId);
    }
}
