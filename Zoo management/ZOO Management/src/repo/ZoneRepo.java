package repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.constant.Const;
import model.Zone;
import utils.db.DB;
import java.sql.SQLException;

/*
 *********************************************************************************************************
 *  @Java Class Name :   ZoneRepo
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class performs CRUD operations on the Zone table.
 *********************************************************************************************************
 */

public class ZoneRepo {
    public static boolean addNewZone(Zone zone, int zooId){
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = DB.connect();
            
            // Check zoo has space to create a new zone
            pstmt = connection.prepareStatement(Const.FIND_MAX_ZONES_BY_ZOO_ID);
            pstmt.setInt(1, zooId);
            rs = pstmt.executeQuery();
            int maxZones = 0;
            if (rs.next()) {
                maxZones = rs.getInt("max_zones");
            }
            rs.close(); 
            pstmt.close();
           
            pstmt = connection.prepareStatement(Const.COUNT_ZONES_BY_ZOO_ID);
            pstmt.setInt(1, zooId);
            rs = pstmt.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt("zone_count");
            }
            
            if (count >= maxZones) {
                System.out.println(Const.ERROR_INSUFFICIENT_SPACE_FOR_ZONE);
                return false;
            }

            pstmt = connection.prepareStatement(Const.INSERT_NEW_ZONE);
            pstmt.setInt(1, zooId);
            pstmt.setString(2, zone.getZoneCategory());
            pstmt.setBoolean(3, zone.isHasPark());
            pstmt.setBoolean(4, zone.isHasCanteen());
            pstmt.executeUpdate();
            
            System.out.println(Const.SUCCESS_ZONE_CREATED);
            return true;
            
        } catch (SQLException e) {
            System.out.println(Const.ERR + e.getMessage());
            return false;
        }
    }

    public static ResultSet getZoneList(int zoo_id){
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DB.connect();

            pstmt = conn.prepareStatement(Const.FIND_ALL_ZONES_BY_ZOO_ID);
            pstmt.setInt(1, zoo_id);
            rs = pstmt.executeQuery();

            return rs;

        } catch (SQLException e){
            System.out.println(Const.ERR + e.getMessage());
            return null;
        }
    }


    public static ResultSet getZoneDetails(int zoneId){
        ResultSet rs = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.GET_CURRENT_CAGE_COUNT);
            pstmt.setInt(1, zoneId);
            rs = pstmt.executeQuery();

            int cageCount = 0;
            if(rs.next()){
                cageCount = rs.getInt("current_cage_count");
            }

            if(cageCount == 0) {
                pstmt = conn.prepareStatement( Const.GET_ZONE_DETAILS_WITH_EMPTY_ANIMAL_COUNT);
                pstmt.setInt(1, zoneId);
                rs = pstmt.executeQuery();
                return rs;
            }

            pstmt = conn.prepareStatement(Const.SELECT_ZONE_DETAILS_WITH_ANIMAL_COUNT);
            pstmt.setInt(1, zoneId);
            rs = pstmt.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println(Const.ERR + e.getMessage());
            return rs;
        }
    }


}
