/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.model;

import java.io.Serializable;

/**
 *
 * @author User PC
 */
public class Order_Detail implements Serializable {

    private String order_detailid;
    private int SID;
    private String date;
    private String oid;
    private int prodid;
    private String productName;
    private boolean credit;
    private int qty;
    private double discount;
    private double payment;
    private double price;

    public Order_Detail() {
    }

    public Order_Detail(String order_detailid, String oid, int prodid, String productName, boolean credit, int qty, double discount, double payment) {
        this.order_detailid = order_detailid;
        this.oid = oid;
        this.prodid = prodid;
        this.productName = productName;
        this.credit = credit;
        this.qty = qty;
        this.discount = discount;
        this.payment = payment;
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
     * @return the oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return the prodid
     */
    public int getProdid() {
        return prodid;
    }

    /**
     * @param prodid the prodid to set
     */
    public void setProdid(int prodid) {
        this.prodid = prodid;
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
     * @return the credit
     */
    public boolean isCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(boolean credit) {
        this.credit = credit;
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
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the payment
     */
    public double getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(double payment) {
        this.payment = payment;
    }

    /**
     * @return the SID
     */
    public int getSID() {
        return SID;
    }

    /**
     * @param SID the SID to set
     */
    public void setSID(int SID) {
        this.SID = SID;
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
