/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.model;

/**
 *
 * @author Dell
 */
public class DamageReports {

    private String shopname;
    private String issuedate;
    private int returnqty;
    private double totalprice;

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(String issuedate) {
        this.issuedate = issuedate;
    }

    public int getReturnqty() {
        return returnqty;
    }

    public void setReturnqty(int returnqty) {
        this.returnqty = returnqty;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

}
