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
public class Shop implements Serializable {

    private int shopid;
    private int routeno;
    private String shopname;
    private String shopowner;
    private String shopemail;
    private String contactno;
    private Route route;

    public Shop() {
    }

//    public Shop(int routeid, String shopname, String shopowner, String shopemail, int contactno) {
//        this.routeid = routeid;
//        this.shopname = shopname;
//        this.shopowner = shopowner;
//        this.shopemail = shopemail;
//        this.contactno = contactno;
//    }
//
//    public Shop(int shopid, int routeid, String shopname, String shopowner, String shopemail, int contactno) {
//        this.shopid = shopid;
//        this.routeid = routeid;
//        this.shopname = shopname;
//        this.shopowner = shopowner;
//        this.shopemail = shopemail;
//        this.contactno = contactno;
//    }
//
//    public Shop(int shopid, int routeid, String shopname, String shopowner, String shopemail, int contactno, Route route) {
//        this.shopid = shopid;
//        this.routeid = routeid;
//        this.shopname = shopname;
//        this.shopowner = shopowner;
//        this.shopemail = shopemail;
//        this.contactno = contactno;
//        this.route = route;
//    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShopowner() {
        return shopowner;
    }

    public void setShopowner(String shopowner) {
        this.shopowner = shopowner;
    }

    public String getShopemail() {
        return shopemail;
    }

    public void setShopemail(String shopemail) {
        this.shopemail = shopemail;
    }

   
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public int getRouteno() {
        return routeno;
    }

    public void setRouteno(int routeno) {
        this.routeno = routeno;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

}
