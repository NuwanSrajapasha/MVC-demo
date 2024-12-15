/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.mvc.dto;

/**
 *
 * @author HP
 */
public class IthemDto {
    private String code;
    private String description;
    private String packsize;
    private Double unitprice;
    private Integer qoh;

    public IthemDto() {
    }

    public IthemDto(String code, String description, String packsize, double unitprice, Integer qoh) {
        this.code = code;
        this.description = description;
        this.packsize = packsize;
        this.unitprice = unitprice;
        this.qoh = qoh;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the packsize
     */
    public String getPacksize() {
        return packsize;
    }

    /**
     * @param packsize the packsize to set
     */
    public void setPacksize(String packsize) {
        this.packsize = packsize;
    }

    /**
     * @return the unitprice
     */
    public double getUnitprice() {
        return unitprice;
    }

    /**
     * @param unitprice the unitprice to set
     */
    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    /**
     * @return the qoh
     */
    public Integer getQoh() {
        return qoh;
    }

    /**
     * @param qoh the qoh to set
     */
    public void setQoh(Integer qoh) {
        this.qoh = qoh;
    }

    @Override
    public String toString() {
        return "IthemDto{" + "code=" + code + ", description=" + description + ", packsize=" + packsize + ", unitprice=" + unitprice + ", qoh=" + qoh + '}';
    }
    
    
    
    
    
}
