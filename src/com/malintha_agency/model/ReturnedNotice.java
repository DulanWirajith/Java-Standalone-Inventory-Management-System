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
public class ReturnedNotice implements Serializable {

    private int ORPID;
    private int OID;
    private int ProID;
    private String returndate;
    private String Reason;
    private int Qty;
    private int oldProID;
    private int oldQty;

    public int getORPID() {
        return ORPID;
    }

    public void setORPID(int ORPID) {
        this.ORPID = ORPID;
    }

    public int getOID() {
        return OID;
    }

    public void setOID(int OID) {
        this.OID = OID;
    }

    public int getProID() {
        return ProID;
    }

    public void setProID(int ProID) {
        this.ProID = ProID;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public int getOldProID() {
        return oldProID;
    }

    public void setOldProID(int oldProID) {
        this.oldProID = oldProID;
    }

    public int getOldQty() {
        return oldQty;
    }

    public void setOldQty(int oldQty) {
        this.oldQty = oldQty;
    }

}
