/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.controller;

import edu.ijse.mvc.model.ItemModel;
import edu.ijse.mvc.dto.IthemDto;


/**
 *
 * @author HP
 */
public class itemController {
    
    private ItemModel itemModel = new ItemModel();
    
    public String saveItem(IthemDto itemDto) throws Exception{
        return itemModel.saveItem(itemDto);
    }
    
}
