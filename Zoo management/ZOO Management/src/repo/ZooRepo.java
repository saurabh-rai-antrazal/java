package repo;

import utils.constant.Const;
import utils.db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Zoo;

/*
 *********************************************************************************************************
 *  @Java Class Name :   Crocodile
 *  @Author          :   <Yuvraj Singh Gour>(yuvraj.singh@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This Crocodile class contains all the overrided methods of Animal Class.
 *********************************************************************************************************
 */

public class ZooRepo {

    public static void addNewZoo (Zoo zoo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.FIND_ZOO_BY_USERNAME);
            pstmt.setString(1, zoo.getUsername());
            rs = pstmt.executeQuery();
            
            int cnt = 0;
            while(rs.next()) {
                cnt += 1;
            }

            if(cnt > 0){
                System.out.println(Const.ERROR_USERNAME_ALREADY_TAKEN);
                return;
            }

            // statement for adding new zoo
            pstmt = conn.prepareStatement(Const.INSERT_NEW_ZOO);

            pstmt.setString(1, zoo.getName());
            pstmt.setString(2, zoo.getLocation());
            pstmt.setString(3, zoo.getUsername());
            pstmt.setString(4, zoo.getPassword());
            pstmt.setInt(5, zoo.getZoneCnt());

            pstmt.executeUpdate();

            int zooId = getZooId(zoo.getUsername());

            pstmt = conn.prepareStatement(Const.INSERT_OWNER);
            pstmt.setInt(1, zooId);
            pstmt.setString(2, zoo.getOwnerName());
            pstmt.executeUpdate();

            System.out.println(Const.SUCCESS_ZOO_CREATED);

        } catch (SQLException e) {
            System.out.println(Const.ERR + e.getMessage());
        }
    }

    public static void addOwnerDetails(int zooId, String ownerName){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.INSERT_ZOO_OWNER);
            pstmt.setInt(1, zooId);
            pstmt.setString(2, ownerName);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(Const.ERR + e.getMessage());
        }
    }


    public static void loginExistingZoo(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.AUTHENTICATE_USER);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                System.out.println(Const.SUCCESS_LOGIN);
                return;
            }
        
            System.out.println(Const.ERROR_LOGIN_FAILED);
        } catch (SQLException e) {
            System.out.println(Const.ERR + e.getMessage());
        }
    }

    public static int getZooId(String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.FIND_ZOO_ID_BY_USERNAME);
            pstmt.setString(1, username);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return rs.getInt("zoo_id");
            } else {
                System.out.println(Const.ERROR_USERNAME_NOT_FOUND + username);
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(Const.ERR + e.getMessage());
            return 0;
        }
    }

    public static ResultSet getZooDetails(int zooId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.FIND_ZOO_DETAILS_WITH_OWNER);
            pstmt.setInt(1, zooId);
            rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.err.println(Const.ERR + e.getMessage());
            return null;
        }
    }

    public static ResultSet getMaxZoneCnt(int zooId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.GET_MAX_ZONE_CNT);
            pstmt.setInt(1, zooId);
            rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e){
            System.out.println(Const.ERR + e.getMessage());
            return null;
        }
    }

}
