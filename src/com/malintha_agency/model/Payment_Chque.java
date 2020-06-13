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
public class Payment_Chque implements Serializable {

    private String chequeno;
    private int paymentid;
    private String receivedate;
    private String bankingdate;
    private double payment;

    public Payment_Chque() {
    }

    
    public Payment_Chque(int paymentid, String chequeno, String receivedate, String bankingdate, double payment) {
        this.paymentid = paymentid;
        this.chequeno = chequeno;
        this.receivedate = receivedate;
        this.bankingdate = bankingdate;
        this.payment = payment;
    }

    public Payment_Chque(String chequeno, String receivedate, String bankingdate, double payment) {
        this.chequeno = chequeno;
        this.receivedate = receivedate;
        this.bankingdate = bankingdate;
        this.payment = payment;
    }

  

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public String getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(String receivedate) {
        this.receivedate = receivedate;
    }

    public String getBankingdate() {
        return bankingdate;
    }

    public void setBankingdate(String bankingdate) {
        this.bankingdate = bankingdate;
    }

    public String getChequeno() {
        return chequeno;
    }

    public void setChequeno(String chequeno) {
        this.chequeno = chequeno;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    

}
