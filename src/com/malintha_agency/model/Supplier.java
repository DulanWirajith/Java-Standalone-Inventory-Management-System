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
public class Supplier implements Serializable {

    private int supplierid;
    private String suppliername;
    private String address;
    private String email;
    private String contactno;

    public Supplier() {
    }

    public Supplier(String suppliername, String address, String email, String contactno) {
        this.suppliername = suppliername;
        this.address = address;
        this.email = email;
        this.contactno = contactno;
    }

    public Supplier(int supplierid, String suppliername, String address, String email, String contactno) {
        this.supplierid = supplierid;
        this.suppliername = suppliername;
        this.address = address;
        this.email = email;
        this.contactno = contactno;
    }
    
    public int getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(int supplierid) {
        this.supplierid = supplierid;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

}
