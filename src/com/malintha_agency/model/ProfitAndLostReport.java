/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.model;

import java.io.Serializable;

/**
 *
 * @author Imalka Gunawardana
 */
public class ProfitAndLostReport implements Serializable {

    private double totalsupplierpayment;
    private double totaldiliverypayment;
    private double totaldamagepayment;
    private double totaldiscountpayment;

    public double getTotalsupplierpayment() {
        return totalsupplierpayment;
    }

    public void setTotalsupplierpayment(double totalsupplierpayment) {
        this.totalsupplierpayment = totalsupplierpayment;
    }

    public double getTotaldiliverypayment() {
        return totaldiliverypayment;
    }

    public void setTotaldiliverypayment(double totaldiliverypayment) {
        this.totaldiliverypayment = totaldiliverypayment;
    }

    public double getTotaldamagepayment() {
        return totaldamagepayment;
    }

    public void setTotaldamagepayment(double totaldamagepayment) {
        this.totaldamagepayment = totaldamagepayment;
    }

    public double getTotaldiscountpayment() {
        return totaldiscountpayment;
    }

    public void setTotaldiscountpayment(double totaldiscountpayment) {
        this.totaldiscountpayment = totaldiscountpayment;
    }

}
