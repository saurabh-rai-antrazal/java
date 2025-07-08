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

    private DB() {}

    public static Connection connect() throws SQLException {
        if(db == null){
            db = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        }
        return db;
    }
}
