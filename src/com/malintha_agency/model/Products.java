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
public class Products {
    private int pid;
    private int invId;
    private String productName;
    private double buying;
    private double selling;
    private int qty;

    public Products() {
    }

    public Products(int pid, int invId, String productName, double buying, double selling, int qty) {
        this.pid = pid;
        this.invId = invId;
        this.productName = productName;
        this.buying = buying;
        this.selling = selling;
        this.qty = qty;
    }

    /**
     * @return the pid
     */
    public int getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    /**
     * @return the invId
     */
    public int getInvId() {
        return invId;
    }

    /**
     * @param invId the invId to set
     */
    public void setInvId(int invId) {
        this.invId = invId;
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
     * @return the buying
     */
    public double getBuying() {
        return buying;
    }

    /**
     * @param buying the buying to set
     */
    public void setBuying(double buying) {
        this.buying = buying;
    }

    /**
     * @return the selling
     */
    public double getSelling() {
        return selling;
    }

    /**
     * @param selling the selling to set
     */
    public void setSelling(double selling) {
        this.selling = selling;
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
    
}
