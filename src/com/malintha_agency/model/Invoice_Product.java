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
public class Invoice_Product implements Serializable {

    private int invoice_productid;
    private int invid;
    private String productname;
    private double buyingprice;
    private double sellingprice;
    private int qty;
    private String date;

    public Invoice_Product(int invid, String productname, double buyingprice, double sellingprice, int qty, String date) {
        this.invid = invid;
        this.productname = productname;
        this.buyingprice = buyingprice;
        this.sellingprice = sellingprice;
        this.qty = qty;
        this.date = date;
    }

    public Invoice_Product(int invoice_productid, int invid, String productname, double buyingprice, double sellingprice, int qty) {
        this.invoice_productid = invoice_productid;
        this.invid = invid;
        this.productname = productname;
        this.buyingprice = buyingprice;
        this.sellingprice = sellingprice;
        this.qty = qty;
    }

    public Invoice_Product(String productname, double sellingprice, int qty) {
        this.productname = productname;
        this.sellingprice = sellingprice;
        this.qty = qty;
    }

    public Invoice_Product() {
    }

    public Invoice_Product(int invoice_productid, String productname, double sellingprice, int qty) {
        this.invoice_productid = invoice_productid;
        this.productname = productname;
        this.sellingprice = sellingprice;
        this.qty = qty;
    }

    public int getInvoice_productid() {
        return invoice_productid;
    }

    public void setInvoice_productid(int invoice_productid) {
        this.invoice_productid = invoice_productid;
    }

    public int getInvid() {
        return invid;
    }

    public void setInvid(int invid) {
        this.invid = invid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getBuyingprice() {
        return buyingprice;
    }

    public void setBuyingprice(double buyingprice) {
        this.buyingprice = buyingprice;
    }

    public double getSellingprice() {
        return sellingprice;
    }

    public void setSellingprice(double sellingprice) {
        this.sellingprice = sellingprice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
