/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.model;

/**
 *
 * @author Imalka Gunawardana
 */
public class Order_ReturnDTO {
    private String order_detailid;
    private String order_id;
    private int proid;
    private String productName;
    private String date;
    private String reason;
    private int qty;
private double price;
    
    public Order_ReturnDTO() {
    }

    public Order_ReturnDTO(String order_detailid, String date, String reason, int qty) {
        this.order_detailid = order_detailid;
        this.date = date;
        this.reason = reason;
        this.qty = qty;
    }

    /**
     * @return the order_detailid
     */
    public String getOrder_detailid() {
        return order_detailid;
    }

    /**
     * @param order_detailid the order_detailid to set
     */
    public void setOrder_detailid(String order_detailid) {
        this.order_detailid = order_detailid;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the order_id
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    /**
     * @return the proid
     */
    public int getProid() {
        return proid;
    }

    /**
     * @param proid the proid to set
     */
    public void setProid(int proid) {
        this.proid = proid;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
   
}
