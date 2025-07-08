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
 *  @Java Class Name :   ZooRepo
 *  @Author          :   <Saurabh rai>(Saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   18-03-2024
 *  @Description     :   This class performs CRUD operations on the Zone table.
 *********************************************************************************************************
 */

public class ZooRepo {

    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    public static int addNewZoo (Zoo zoo) {
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
                return -1;
            }
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
            return zooId;
        } catch (SQLException e) {
            return 0;
        }
    }


    public static int loginExistingZoo(String username, String password) {
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.AUTHENTICATE_USER);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()){
                return getZooId(username);
            }
            return 0;
        } catch (SQLException e) {
            return 0;
        }
    }

    public static int getZooId(String username) {
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.FIND_ZOO_ID_BY_USERNAME);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("zoo_id");
            } else{
                return -1;
            }
        } catch (SQLException e) {
            return 0;
        }
    }

    public static ResultSet getZooDetails(int zooId) {
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.FIND_ZOO_DETAILS_WITH_OWNER);
            pstmt.setInt(1, zooId);
            rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            return null;
        }
    }

    public static ResultSet getMaxZoneCnt(int zooId) {
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.GET_MAX_ZONE_CNT);
            pstmt.setInt(1, zooId);
            rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e){
            return null;
        }
    }

}
