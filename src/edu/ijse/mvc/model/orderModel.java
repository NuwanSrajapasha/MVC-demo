/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.model;

import edu.ijse.mvc.db.DBconnection;
import edu.ijse.mvc.dto.OrderDetailDto;
import edu.ijse.mvc.dto.orderDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import edu.ijse.mvc.dto.IthemDto;


/**
 *
 * @author HP
 */
public class orderModel {
    
     private OrderDetailModel orderDetailModel = new OrderDetailModel();
    private ItemModel itemModel = new ItemModel();
    
    public String placeOrder(orderDto orderDto, ArrayList<OrderDetailDto> orderDetailDtos) throws Exception{
        Connection connection = DBconnection.getInstance().getConnection(); 
        try {
            connection.setAutoCommit(false);
            String orderSaveResp = saveOrder(orderDto);
            if(orderSaveResp.equalsIgnoreCase("Success")){
                boolean isOrderDetailSaved = true;
                for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                    String orderDetailRsp = orderDetailModel.saveOrderDetail(orderDetailDto);
                    if(!orderDetailRsp.equalsIgnoreCase("Success")){
                        isOrderDetailSaved = false;
                    }
                }
                if(isOrderDetailSaved){
                    boolean isItemUpdate = true;
                    for (OrderDetailDto orderDetailDto : orderDetailDtos) {
                        IthemDto itemDto = itemModel.searchItem(orderDetailDto.getItemId());
                        if(itemDto != null){
                            itemDto.setQoh(itemDto.getQoh() - orderDetailDto.getQty());
                            String resp = itemModel.updateItem(itemDto);
                            if(!resp.equalsIgnoreCase("Successfully Updated")){
                                isItemUpdate = false;
                            }
                        } else {
                            connection.rollback();
                            return "Item Not Found";
                        }
                    }
                    if(isItemUpdate){
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Item Update Error";
                    }
                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }
            } else {
                connection.rollback();
                return "Order Save Error";
            }
        } catch (Exception e) {
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }
    }
    
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
