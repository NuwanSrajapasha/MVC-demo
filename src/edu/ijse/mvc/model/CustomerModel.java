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
     
    
}
