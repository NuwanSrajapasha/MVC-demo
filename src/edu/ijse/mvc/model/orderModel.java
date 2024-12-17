/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBconnection;
import edu.ijse.mvc.dto.orderDto;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author HP
 */
public class orderModel {
    public String saveOrder(orderDto OrderDto) throws Exception{
        String sql = "INSERT INTO Orders VALUES (?,?,?)";
        Connection connection = DBconnection.getInstance().getConnection(); 
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, OrderDto.getOrderId());
        statement.setString(2, OrderDto.getDate());
        statement.setString(3, OrderDto.getCustId());
        
        return statement.executeUpdate() > 0 ? "Success" : "Fail";
    }
}
