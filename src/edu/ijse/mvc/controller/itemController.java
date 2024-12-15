/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;

import edu.ijse.mvc.model.ItemModel;
import edu.ijse.mvc.dto.IthemDto;
import java.util.ArrayList;


/**
 *
 * @author HP
 */
public class itemController {
    
    
    private ItemModel itemModel = new ItemModel();
    
    
    public String saveItem(IthemDto itemDto) throws Exception{
        return itemModel.saveItem(itemDto);
    }
     public ArrayList<IthemDto> getAllItem() throws Exception{
        return itemModel.getAllItem();
    }
     
     public IthemDto searchItem(String itemCode) throws Exception{
        return itemModel.searchItem(itemCode);
    }
    public String updateItem(IthemDto itemDto) throws Exception{
        return itemModel.updateItem(itemDto);
    }
        public String deleteItem(String code) throws Exception{
        return itemModel.deleteItem(code);
    } 

    
    
}
