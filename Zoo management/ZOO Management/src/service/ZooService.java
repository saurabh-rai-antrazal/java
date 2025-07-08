package service;

import model.Zoo;
import repo.ZooRepo;
import utils.constant.Const;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 *********************************************************************************************************
 *  @Java Class Name :   ZooService
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class handles all database operations for the Zoo table
 *********************************************************************************************************
 */

public class ZooService {
    public static int addNewZoo(Zoo zoo){
        return ZooRepo.addNewZoo(zoo);
    }

    public static int loginExistingZoo(String[] loginDetails){
        return ZooRepo.loginExistingZoo(loginDetails[0], loginDetails[1]);
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
            return zooInfo;
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
            return 0;
        }
    }
}
