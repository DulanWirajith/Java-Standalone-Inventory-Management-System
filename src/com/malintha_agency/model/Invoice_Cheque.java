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
public class Invoice_Cheque implements Serializable {

    private int invoice_chequeid;
    private int invoiceid;
    private String chequeno;
    private String branch;
    private int accountno;
    private String receivedate;
    private String bankingdate;
    private double payment;
    private Invoice invoice;

    public Invoice_Cheque(int invoiceid, String chequeno, String receivedate, String bankingdate, double payment) {
        this.invoiceid = invoiceid;
        this.chequeno = chequeno;
        this.receivedate = receivedate;
        this.bankingdate = bankingdate;
        this.payment = payment;
    }

    public Invoice_Cheque(int invoice_chequeid, int invoiceid, String chequeno, String receivedate, String bankingdate, double payment) {
        this.invoice_chequeid = invoice_chequeid;
        this.invoiceid = invoiceid;
        this.chequeno = chequeno;
        this.receivedate = receivedate;
        this.bankingdate = bankingdate;
        this.payment = payment;
    }

    public Invoice_Cheque(int invoice_chequeid, int invoiceid, String chequeno, String receivedate, String bankingdate, double payment, Invoice invoice) {
        this.invoice_chequeid = invoice_chequeid;
        this.invoiceid = invoiceid;
        this.chequeno = chequeno;
        this.receivedate = receivedate;
        this.bankingdate = bankingdate;
        this.payment = payment;
        this.invoice = invoice;
    }

    public Invoice_Cheque(int invoiceid, String chequeno, String branch, int accountno, String receivedate, String bankingdate, double payment) {
        this.invoiceid = invoiceid;
        this.chequeno = chequeno;
        this.branch = branch;
        this.accountno = accountno;
        this.receivedate = receivedate;
        this.bankingdate = bankingdate;
        this.payment = payment;
    }

    public Invoice_Cheque() {
    }

    public int getInvoice_chequeid() {
        return invoice_chequeid;
    }

    public void setInvoice_chequeid(int invoice_chequeid) {
        this.invoice_chequeid = invoice_chequeid;
    }

    public String getChequeno() {
        return chequeno;
    }

    public void setChequeno(String chequeno) {
        this.chequeno = chequeno;
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

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getAccountno() {
        return accountno;
    }

    public void setAccountno(int accountno) {
        this.accountno = accountno;
    }

}
