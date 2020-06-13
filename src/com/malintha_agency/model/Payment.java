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
public class Payment implements Serializable {

    private int paymentid;
    private int oid;
    private String date1;
    private double payment;
    private boolean ischeck;
    private Payment_Chque paymentcheques;
    private ArrayList<Payment_Chque> cheques;

    public Payment(int oid, String date1, double payment) {
        this.oid = oid;
        this.date1 = date1;
        this.payment = payment;
    }

    public Payment(int oid, String date1, double payment, boolean ischeck) {
        this.oid = oid;
        this.date1 = date1;
        this.payment = payment;
        this.ischeck = ischeck;
    }

    public Payment(int paymentid, int oid, String date1, double payment, ArrayList<Payment_Chque> cheques) {
        this.paymentid = paymentid;
        this.oid = oid;
        this.date1 = date1;
        this.payment = payment;

        this.cheques = cheques;
    }

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public boolean isIscheck() {
        return ischeck;
    }

    public void setIscheck(boolean ischeck) {
        this.ischeck = ischeck;
    }

    public Payment_Chque getPaymentcheques() {
        return paymentcheques;
    }

    public void setPaymentcheques(Payment_Chque paymentcheques) {
        this.paymentcheques = paymentcheques;
    }

}
