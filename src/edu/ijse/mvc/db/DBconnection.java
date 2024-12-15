/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.db;



import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;
/**
 *
 * @author HP
 */
public class DBconnection {
    private static DBconnection dbconnection;
    private Connection connection;
    
    private DBconnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "mysql1");
        System.out.println("Connected");

        
    }
    public static DBconnection getInstance() throws ClassNotFoundException, SQLException{
        if(dbconnection==null){
            dbconnection=new DBconnection();
        }
        return dbconnection;
    }
    public Connection getConnection(){
        return connection;
    }
   
}
