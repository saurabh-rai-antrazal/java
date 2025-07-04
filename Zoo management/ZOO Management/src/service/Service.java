package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import model.Zoo;
import repo.AnimalRepo;
import repo.ZoneRepo;
import repo.ZooRepo;
import utils.constant.Const;


/*
 *********************************************************************************************************
 *  @Java Class Name :   Service
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class is a mediator between the Repo and models.
 ********************************************************************************************************
 */

public class Service {


    public static int loginExistingZoo(String[] loginDetails){
        ZooRepo.loginExistingZoo(loginDetails[0], loginDetails[1]);
        return ZooRepo.getZooId(loginDetails[0]);
    }

    public static int createNewZoo(Zoo zoo){
        ZooRepo.addNewZoo(zoo);
        return ZooRepo.getZooId(zoo.getUsername());
    }


    public static Map<Integer, String> getAnimalList (int zooId) {
        Map<Integer, String> animalList = new LinkedHashMap<>();
        try {
            ResultSet rs = AnimalRepo.getAnimal(zooId);
            while(true){
                assert rs != null;
                if (!rs.next()) break;
                animalList.put(rs.getInt("animal_id"), rs.getString("animal_name"));
            }
        } catch (SQLException e) {
            System.out.println(Const.ERR + e.getMessage());
        }
        return animalList;
    }

    public static void removeDeadAnimal (int animalId, int zooId){
        AnimalRepo.removeDeadAnimal(animalId, zooId);
    }


    public static Map<Integer, String> getZoneList (int zooId){
        Map<Integer, String> zoneList = new LinkedHashMap<>();
        ResultSet rs = null;
        try {
            rs = ZoneRepo.getZoneList(zooId);
            while(true){
                assert rs != null;
                if(!rs.next()) break;
                zoneList.put(rs.getInt("zone_id"), rs.getString("animal_category"));
            }

            return zoneList;
        } catch (SQLException e) {
            System.out.println(Const.ERR + e.getMessage());
            return zoneList;
        }
    }


    public static List<String> getZooDetails(int zooId){
        List<String> zooInfo = new ArrayList<>();
        try {
            ResultSet rs = ZooRepo.getZooDetails(zooId);
            while(true){
                assert rs != null;
                if(!rs.next()) break;
                zooInfo.add(rs.getString("zoo_id"));
                zooInfo.add(rs.getString("zoo_name"));
                zooInfo.add(rs.getString("zoo_location"));
                zooInfo.add(rs.getString("owner_name"));
            }
            return zooInfo;

        } catch (SQLException e){
            System.out.println(Const.ERR + e.getMessage());
            return zooInfo;
        }
    }


    public static List<String> getZoneDetails(int zoneId){
        List<String> zoneInfo = new ArrayList<>();
        try {
            ResultSet rs = ZoneRepo.getZoneDetails(zoneId);
            while(true) {
                assert rs != null;
                if(!rs.next()) break;
                zoneInfo.add(rs.getString("zone_id"));
                zoneInfo.add(rs.getString("animal_category"));
                zoneInfo.add(rs.getString("current_cage_count"));
                zoneInfo.add(rs.getString("animal_count"));
                zoneInfo.add(rs.getString("has_park"));
                zoneInfo.add(rs.getString("has_canteen"));
            }
            return zoneInfo;
        } catch (SQLException e) {
            System.out.println(Const.ERR + e.getMessage());
            return zoneInfo;
        }
    }

    public static int getMaxZoneCnt(int zooId){
        ResultSet rs = ZooRepo.getMaxZoneCnt(zooId);
        int maxZoneCnt = 0;
        try {
            assert rs != null;
            if(rs.next()){
                maxZoneCnt = rs.getInt("max_zones");
            }
            return maxZoneCnt;
        } catch (SQLException e) {
            System.out.println(Const.ERR + e.getMessage());
            return 0;
        }
    }

}
