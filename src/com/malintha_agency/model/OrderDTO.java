/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author User PC
 */
public class OrderDTO implements Serializable {

    private String orderid;
    private int SID;
    private double payment;
    private String date;
    private Order_Detail order_Detail;
    private ArrayList<Order_Detail> order_Details;

    public OrderDTO(String orderid, int SID, double payment, String date) {
        this.orderid = orderid;
        this.SID = SID;
        this.payment = payment;
        this.date = date;
    }

    

    public OrderDTO() {
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
     * @return the orderid
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * @param orderid the orderid to set
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    /**
     * @return the order_Detail
     */
    public Order_Detail getOrder_Detail() {
        return order_Detail;
    }

    /**
     * @param order_Detail the order_Detail to set
     */
    public void setOrder_Detail(Order_Detail order_Detail) {
        this.order_Detail = order_Detail;
    }

    /**
     * @return the order_Details
     */
    public ArrayList<Order_Detail> getOrder_Details() {
        return order_Details;
    }

    /**
     * @param order_Details the order_Details to set
     */
    public void setOrder_Details(ArrayList<Order_Detail> order_Details) {
        this.order_Details = order_Details;
    }

   
}
