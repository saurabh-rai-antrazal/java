package service;

import model.Zone;
import repo.ZoneRepo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 *********************************************************************************************************
 *  @Java Class Name :   ZoneService
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class handles all database operations for the Zone table
 *********************************************************************************************************
 */

public class ZoneService {
    public static String addNewZone(Zone zone, int  zooId){
        return ZoneRepo.addNewZone(zone, zooId);
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
            return zoneList;
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
            return zoneInfo;
        }
    }

}
