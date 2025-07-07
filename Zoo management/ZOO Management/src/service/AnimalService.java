package service;

import model.Animal;
import repo.AnimalRepo;
import utils.constant.Const;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;


/*
 *********************************************************************************************************
 *  @Java Class Name :   AnimalServices
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class handles all database operations for the Animal table
 *********************************************************************************************************
 */


public class AnimalService {
    public static String addNewAnimal(Animal animal, int zooId){
        return AnimalRepo.addNewAnimal(animal, zooId);
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

    public static String removeDeadAnimal (int animalId, int zooId){
        return AnimalRepo.removeDeadAnimal(animalId, zooId);
    }
}
