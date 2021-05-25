package config;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection instance = null;

    private DatabaseConnection(){}

    public static Connection getInstance(){
        if(instance == null){
            String url = "jdbc:mysql://localhost:3306/PAOOOOOOOO";
            String username = "root";
            String password = "";
            try {
                instance = DriverManager.getConnection(url,username,password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return instance;
    }

}
