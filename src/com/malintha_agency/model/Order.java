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
public class Order implements Serializable {

    private int orderid;
    private int SID;
    private String date;
    private double orderpayment;
    private int fullqty;
    private double discount;
    private double todopayment;
    private double payment;
    private double finalpayment;
    
    private Order_Detail orderdetail;
    private ArrayList<Order_Detail> orderdetaillist;
    private ArrayList<Payment> paymentlist;

    public Order() {
    }

    
    public Order(String date, double orderpayment) {
        this.date = date;
        this.orderpayment = orderpayment;
    }

    public Order(int orderid, int SID, String date, double orderpayment, int fullqty, double todopayment, Order_Detail orderdetail, ArrayList<Order_Detail> orderdetaillist, ArrayList<Payment> paymentlist) {
        this.orderid = orderid;
        this.SID = SID;
        this.date = date;
        this.orderpayment = orderpayment;
        this.fullqty = fullqty;
        this.todopayment = todopayment;
        this.orderdetail = orderdetail;
        this.orderdetaillist = orderdetaillist;
        this.paymentlist = paymentlist;
    }

    public Order(int SID, String date, double orderpayment, Order_Detail orderdetail) {
        this.SID = SID;
        this.date = date;
        this.orderpayment = orderpayment;
        this.orderdetail = orderdetail;
    }

    public Order(int SID, String date, int fullqty, double orderpayment) {
        this.SID = SID;
        this.date = date;
        this.fullqty = fullqty;
        this.orderpayment = orderpayment;
    }

    public Order(int SID, String date, double orderpayment, int fullqty, Order_Detail orderdetail) {
        this.SID = SID;
        this.date = date;
        this.orderpayment = orderpayment;
        this.fullqty = fullqty;
        this.orderdetail = orderdetail;
    }

//    public Order(int orderid, int SID, String date, double orderpayment, int fullqty, ArrayList<Order_Detail> orderdetaillist) {
//        this.orderid = orderid;
//        this.SID = SID;
//        this.date = date;
//        this.orderpayment = orderpayment;
//        this.fullqty = fullqty;
//        this.orderdetaillist = orderdetaillist;
//    }

    public Order(int orderid, int SID, String date, int fullqty, double discount, double todopayment, double payment, double finalpayment, ArrayList<Order_Detail> orderdetaillist) {
        this.orderid = orderid;
        this.SID = SID;
        this.date = date;
        this.fullqty = fullqty;
        this.discount = discount;
        this.todopayment = todopayment;
        this.payment = payment;
        this.finalpayment = finalpayment;
        this.orderdetaillist = orderdetaillist;
    }

    
    public Order(int SID, String date, double orderpayment, int fullqty, double todopayment) {
        this.SID = SID;
        this.date = date;
        this.orderpayment = orderpayment;
        this.fullqty = fullqty;
        this.todopayment = todopayment;
    }

    public Order(int SID, String date, int fullqty, double discount, double todopayment, double payment, double finalpayment) {
        this.SID = SID;
        this.date = date;
        this.fullqty = fullqty;
        this.discount = discount;
        this.todopayment = todopayment;
        this.payment = payment;
        this.finalpayment = finalpayment;
    }

    
    
    
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOrderpayment() {
        return orderpayment;
    }

    public void setOrderpayment(double orderpayment) {
        this.orderpayment = orderpayment;
    }

    public Order_Detail getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(Order_Detail orderdetail) {
        this.orderdetail = orderdetail;
    }

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public int getFullqty() {
        return fullqty;
    }

    public void setFullqty(int fullqty) {
        this.fullqty = fullqty;
    }

    public ArrayList<Order_Detail> getOrderdetaillist() {
        return orderdetaillist;
    }

    public void setOrderdetaillist(ArrayList<Order_Detail> orderdetaillist) {
        this.orderdetaillist = orderdetaillist;
    }

    public double getDonepayment() {
        return todopayment;
    }

    public void setDonepayment(double todopayment) {
        this.todopayment = todopayment;
    }

    public ArrayList<Payment> getPaymentlist() {
        return paymentlist;
    }

    public void setPaymentlist(ArrayList<Payment> paymentlist) {
        this.paymentlist = paymentlist;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTodopayment() {
        return todopayment;
    }

    public void setTodopayment(double todopayment) {
        this.todopayment = todopayment;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getFinalpayment() {
        return finalpayment;
    }

    public void setFinalpayment(double finalpayment) {
        this.finalpayment = finalpayment;
    }

}
