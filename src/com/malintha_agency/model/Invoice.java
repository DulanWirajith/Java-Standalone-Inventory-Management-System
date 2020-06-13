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
public class Invoice implements Serializable {

    private int invoiceid;
    private int supid;
    private String invoiceno;
    private String lorryno;
    private double subtotal;
    private double discount;
    private double netamount;
    private String issuedate;
    private String receivedate;
    private ArrayList<Invoice_Product> products;
    private ArrayList<Invoice_Cheque> cheques;

    public Invoice() {
    }

    public Invoice(int invoiceid, int supid, String invoiceno, String lorryno, double subtotal, double discount, double netamount, String issuedate, String receivedate, ArrayList<Invoice_Product> products, ArrayList<Invoice_Cheque> cheques) {
        this.invoiceid = invoiceid;
        this.supid = supid;
        this.invoiceno = invoiceno;
        this.lorryno = lorryno;
        this.subtotal = subtotal;
        this.discount = discount;
        this.netamount = netamount;
        this.issuedate = issuedate;
        this.receivedate = receivedate;
        this.products = products;
        this.cheques = cheques;
    }

    public Invoice(int supid, String invoiceno, String lorryno, double subtotal, double discount, double netamount, String issuedate, String receivedate) {
        this.supid = supid;
        this.invoiceno = invoiceno;
        this.lorryno = lorryno;
        this.subtotal = subtotal;
        this.discount = discount;
        this.netamount = netamount;
        this.issuedate = issuedate;
        this.receivedate = receivedate;
    }

    public Invoice(int invoiceid, int supid, String invoiceno, String lorryno, double subtotal, double discount, double netamount, String issuedate, String receivedate) {
        this.invoiceid = invoiceid;
        this.supid = supid;
        this.invoiceno = invoiceno;
        this.lorryno = lorryno;
        this.subtotal = subtotal;
        this.discount = discount;
        this.netamount = netamount;
        this.issuedate = issuedate;
        this.receivedate = receivedate;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getInvoiceno() {
        return invoiceno;
    }

    public void setInvoiceno(String invoiceno) {
        this.invoiceno = invoiceno;
    }

    public String getLorryno() {
        return lorryno;
    }

    public void setLorryno(String lorryno) {
        this.lorryno = lorryno;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public String getReceivedate() {
        return receivedate;
    }

    public void setReceivedate(String receivedate) {
        this.receivedate = receivedate;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getNetamount() {
        return netamount;
    }

    public void setNetamount(double netamount) {
        this.netamount = netamount;
    }

    public int getSupid() {
        return supid;
    }

    public void setSupid(int supid) {
        this.supid = supid;
    }

    public ArrayList<Invoice_Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Invoice_Product> products) {
        this.products = products;
    }

    public ArrayList<Invoice_Cheque> getCheques() {
        return cheques;
    }

    public void setCheques(ArrayList<Invoice_Cheque> cheques) {
        this.cheques = cheques;
    }

}
