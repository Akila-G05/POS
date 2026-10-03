/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Akila_Ya
 */
public class MySQL {
    
    private static Connection connection;
    
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop_db", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static ResultSet execute(String query) throws Exception{
        
        Statement statement = connection.createStatement();

        if(query.startsWith("SELECT")){
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        }else{
            int result = statement.executeUpdate(query);
            return null;
        }
        
    }
    
}
