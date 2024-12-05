/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBconnection;
import edu.ijse.mvc.dto.IthemDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ItemModel {
    
     public String saveItem(IthemDto itemDto) throws Exception{
        String sql = "INSERT INTO item VALUES (?,?,?,?,?)";
        Connection connection = DBconnection.getInstatnce().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemDto.getCode());
        statement.setString(2, itemDto.getDescription());
        statement.setString(3, itemDto.getPacksize());
        statement.setDouble(4, itemDto.getUnitprice());
        statement.setInt(5, itemDto.getQoh());
        
        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }

   

    // Method to update an item
    public String updateItem(IthemDto itemDto) throws Exception {
        String sql = "UPDATE item SET Description = ?, PackSize = ?, UnitPrice = ?, QtyOnHand = ? WHERE ItemCode = ?";
        Connection connection = DBconnection.getInstatnce().getConnection(); // Corrected method call
        PreparedStatement statement = connection.prepareStatement(sql);
        
        // Setting parameters in the prepared statement
        statement.setString(1, itemDto.getDescription());
        statement.setString(2, itemDto.getPacksize());
        statement.setDouble(3, itemDto.getUnitprice());
        statement.setInt(4, itemDto.getQoh());
        statement.setString(5, itemDto.getCode());
        
        // Executing the statement and returning the result
        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    // Method to delete an item
    public String deleteItem(String code) throws Exception {
        String sql = "DELETE FROM item WHERE ItemCode = ?";
        Connection connection = DBconnection.getInstatnce().getConnection(); // Corrected method call
        PreparedStatement statement = connection.prepareStatement(sql);
        
        // Setting parameter in the prepared statement
        statement.setString(1, code);
        
        // Executing the statement and returning the result
        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }
    public IthemDto searchItem(String code) throws Exception {
        String sql = "SELECT*FROM item WHERE ItemCode = ?";
        Connection connection = DBconnection.getInstatnce().getConnection(); // Corrected method call
        PreparedStatement statement = connection.prepareStatement(sql);
        
        // Setting parameter in the prepared statement
        statement.setString(1, code);
        
        // Executing the statement and returning the result
        ResultSet rst=statement.executeQuery();
        if(rst.next()){
            IthemDto dto=new IthemDto(
                    rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QytOnHand"));
            return dto;
        }
        return null;
    }
     public ArrayList<IthemDto> getAllItem() throws Exception{
        String sql = "SELECT * from item";
        Connection connection = DBconnection.getInstatnce().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        ArrayList<IthemDto> itemDtos = new ArrayList<>();
        while(rst.next()){
            IthemDto dto = new IthemDto(rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"), 
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand"));
            itemDtos.add(dto);
        }
        return itemDtos;
    }
}
