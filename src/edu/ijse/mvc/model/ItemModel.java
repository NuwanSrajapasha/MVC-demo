package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBconnection;  // Corrected import for DBConnection
import edu.ijse.mvc.dto.IthemDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemModel {
    
    public String saveItem(IthemDto itemDto) throws Exception {
        String sql = "INSERT INTO item VALUES (?,?,?,?,?)";
        Connection connection = DBconnection.getInstance().getConnection(); 
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
        Connection connection = DBconnection.getInstance().getConnection(); // Fixed the class name here
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, itemDto.getDescription());
        statement.setString(2, itemDto.getPacksize());
        statement.setDouble(3, itemDto.getUnitprice());
        statement.setInt(4, itemDto.getQoh());
        statement.setString(5, itemDto.getCode());
        
        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    // Method to delete an item
    public String deleteItem(String code) throws Exception {
        String sql = "DELETE FROM item WHERE ItemCode = ?";
        Connection connection = DBconnection.getInstance().getConnection(); // Fixed the class name here
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, code);
        
        return statement.executeUpdate() > 0 ? "Successfully Deleted" : "Fail";
    }

    // Method to search an item
    public IthemDto searchItem(String code) throws Exception {
        String sql = "SELECT * FROM item WHERE ItemCode = ?";
        Connection connection = DBconnection.getInstance().getConnection(); // Fixed the class name here
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, code);
        
        ResultSet rst = statement.executeQuery();
        if (rst.next()) {
            IthemDto dto = new IthemDto(
                    rst.getString("ItemCode"),
                    rst.getString("Description"),
                    rst.getString("PackSize"),
                    rst.getDouble("UnitPrice"),
                    rst.getInt("QtyOnHand"));
            return dto;
        }
        return null;
    }

    // Method to get all items
    public ArrayList<IthemDto> getAllItem() throws Exception {
        String sql = "SELECT * FROM item";
        Connection connection = DBconnection.getInstance().getConnection(); 
        PreparedStatement statement = connection.prepareStatement(sql);
        
        ResultSet rst = statement.executeQuery();
        ArrayList<IthemDto> itemDtos = new ArrayList<>();
        while (rst.next()) {
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
