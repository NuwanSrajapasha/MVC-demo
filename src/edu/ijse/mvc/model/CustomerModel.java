/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBconnection;
import java.sql.Connection;
import edu.ijse.mvc.dto.CustomerDto;
import java.util.ArrayList;
import java.SQLDataException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author HP
 */
public class CustomerModel {
    
     public ArrayList<CustomerDto> getAll() throws Exception{
         String sql="SELECT * FROM Customer";
         Connection connection=DBconnection.getInstance().getConnection();
         PreparedStatement statement=connection.prepareStatement(sql);
         
        ResultSet rst = statement.executeQuery();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();
        while (rst.next()) {            
            CustomerDto dto = new CustomerDto(
                    rst.getString("CustID"), rst.getString("CustTitle"),
                    rst.getString("CustName"), rst.getString("DOB"),
                    rst.getDouble("salary"), rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"), rst.getString("PostalCode"));
            customerDtos.add(dto);
        }
        return customerDtos;
     }

    public CustomerDto getCustomer(String custId) throws Exception {
        String sql = "SELECT * FROM Customer WHERE CustID = ?";
        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, custId);

        ResultSet rst = statement.executeQuery();

        if (rst.next()) {
            CustomerDto dto = new CustomerDto(
                    rst.getString("CustID"), rst.getString("CustTitle"),
                    rst.getString("CustName"), rst.getString("DOB"),
                    rst.getDouble("salary"), rst.getString("CustAddress"),
                    rst.getString("City"),
                    rst.getString("Province"), rst.getString("PostalCode"));
            return dto;
        }
        return null;
    }

    public String saveCustomer(CustomerDto dto) throws Exception {
        String sql = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, dto.getId());
        statement.setString(2, dto.getTitle());
        statement.setString(3, dto.getName());
        statement.setString(4, dto.getDob());
        statement.setDouble(5, dto.getSalary());
        statement.setString(6, dto.getAddress());
        statement.setString(7, dto.getCity());
        statement.setString(8, dto.getProvince());
        statement.setString(9, dto.getPostalCode());
        
        return statement.executeUpdate() > 0 ? "Success" : "Fail";
    }

    
}
