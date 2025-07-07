package repo;

import animals.Animal;
import utils.constant.Const;
import utils.db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 *********************************************************************************************************
 *  @Java Class Name :   AnimalRepo
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class performs CRUD operations on the Animal table.
 *********************************************************************************************************
 */

public class AnimalRepo {

    private static Connection conn = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    public static String addNewAnimal(Animal animal, int zooId) {
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.FIND_ZONE_BY_ZOO_AND_CATEGORY);
            pstmt.setInt(1, zooId);
            pstmt.setString(2, animal.getCategory());
            rs = pstmt.executeQuery();
            List<Integer> zoneIdList = new ArrayList<>();
            int zoneId = 0;
            while (rs.next()) {
                zoneId = rs.getInt("zone_id");
                zoneIdList.add(zoneId);
            }
            for(Integer zone : zoneIdList) {
                pstmt = conn.prepareStatement(Const.FIND_AVAILABLE_CAGE_FOR_ANIMAL);
                pstmt.setInt(1, zone);
                pstmt.setString(2, animal.getName());
                rs = pstmt.executeQuery();
                int cageId = 0;
                if(rs.next()){
                    cageId = rs.getInt("cage_id");
                    pstmt = conn.prepareStatement(Const.INSERT_ANIMAL_IN_CAGE);
                    pstmt.setInt(1, cageId);
                    pstmt.setString(2, animal.getName());
                    pstmt.setInt(3, animal.getAge());
                    pstmt.setDouble(4, animal.getWeight());
                    pstmt.executeUpdate();
                    String animalType = rs.getString("animal_type");
                    if(animalType == null || animalType.equals("null")){
                        pstmt = conn.prepareStatement(Const.UPDATE_CAGE_ANIMAL_TYPE_AND_CAPACITY);
                        pstmt.setString(1, animal.getName());
                        pstmt.setInt(2, animal.getPerCageCapacity());
                        pstmt.setInt(3, cageId);
                        pstmt.executeUpdate();
                    }
                    pstmt = conn.prepareStatement(Const.UPDATE_CAGE_ANIMAL_COUNT);
                    pstmt.setInt(1, cageId);
                    pstmt.executeUpdate();
                    return Const.SUCCESS_ANIMAL_ADDED;
                }
            }
            pstmt = conn.prepareStatement(Const.FIND_ZONE_WITH_AVAILABLE_CAGE_SLOTS);
            pstmt.setInt(1, zooId); 
            pstmt.setString(2, animal.getCategory());
            rs = pstmt.executeQuery();
            zoneId = 0;
            if(rs.next()){
                zoneId = rs.getInt("zone_id");
                pstmt = conn.prepareStatement(Const.INSERT_NEW_CAGE);
                pstmt.setInt(1, zoneId);
                pstmt.setString(2, animal.getName());
                pstmt.setInt(3, animal.getPerCageCapacity());
                pstmt.executeUpdate();
                pstmt = conn.prepareStatement(Const.FIND_NEWLY_CREATED_CAGE);
                pstmt.setInt(1, zoneId);
                pstmt.setString(2, animal.getName());
                rs = pstmt.executeQuery();
                pstmt = conn.prepareStatement(Const.INCREMENT_CAGE_COUNT_IN_ZONE);
                pstmt.setInt(1, zoneId);
                pstmt.executeUpdate();
                int cageId = 0;
                if(rs.next()){
                    cageId = rs.getInt("cage_id");
                    pstmt = conn.prepareStatement(Const.INSERT_ANIMAL_IN_CAGE);
                    pstmt.setInt(1, cageId);
                    pstmt.setString(2, animal.getName());
                    pstmt.setInt(3, animal.getAge());
                    pstmt.setDouble(4, animal.getWeight());
                    pstmt.executeUpdate();
                    pstmt = conn.prepareStatement(Const.INCREMENT_ANIMAL_COUNT_IN_CAGE);
                    pstmt.setInt(1, cageId);
                    pstmt.executeUpdate();
                    return Const.SUCCESS_ANIMAL_ADDED;
                }
            }
            return Const.ERROR_NO_ZONE_AVAILABLE;
        } catch (SQLException e){
            return Const.ERR + e.getMessage();
        }
    }

    public static ResultSet getAnimal(int zooId) {
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.FIND_ALL_ALIVE_ANIMALS_BY_ZOO);
            pstmt.setInt(1, zooId);
            rs = pstmt.executeQuery();
            return rs;
        } catch (Exception e) {
            return null;
        }
    }

    public static String removeDeadAnimal(int animalId, int zooId){
        try {
            conn = DB.connect();
            pstmt = conn.prepareStatement(Const.MARK_ANIMAL_AS_DEAD);
            pstmt.setInt(1, animalId);
            pstmt.executeUpdate();
            pstmt = conn.prepareStatement(Const.FIND_CAGE_BY_ANIMAL_ID);
            pstmt.setInt(1, animalId);
            rs =  pstmt.executeQuery();
            rs.next();
            int cage_id = rs.getInt("cage_id");
            pstmt = conn.prepareStatement(Const.DECREMENT_ANIMAL_COUNT_IN_CAGE);
            pstmt.setInt(1, cage_id);
            pstmt.executeUpdate();
            pstmt = conn.prepareStatement(Const.RESET_EMPTY_CAGE_TYPE_AND_CAPACITY);
            pstmt.setInt(1, cage_id);
            pstmt.executeUpdate();
            return Const.SUCCESS_ANIMAL_REMOVED;
        } catch (Exception e) {
            return Const.ERR + e.getMessage();
        }
    }

}
