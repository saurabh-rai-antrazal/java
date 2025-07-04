package utils.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 *********************************************************************************************************
 *  @Java Class Name :   DB
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This is a singleton class which returns a single connection.
 *********************************************************************************************************
 */

public class DB {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/zoo_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "123456789";

    private static Connection db;

    public static Connection connect() {
        if(db == null){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                db = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                /* System.out.println("Connected to utils.database"); */
            } catch (ClassNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error : " + e.getMessage());
            }
        }
        return db;
    }

}
