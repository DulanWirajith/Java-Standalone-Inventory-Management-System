/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.Invoice;
import com.malintha_agency.model.Invoice_Cheque;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class InvoiceChequeController {

    public static boolean saveInvoiceCheque(Invoice_Cheque invoicecheque) throws SQLException, ClassNotFoundException {

        String searchsql = "Select * from invoicecheque Where ChequeNo='" + invoicecheque.getChequeno() + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        if (count == 0) {
            String insertsql = "Insert into invoicecheque values(?,?,?,?,?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(insertsql);

            stm.setObject(1, invoicecheque.getInvoice_chequeid());
            stm.setObject(2, invoicecheque.getInvoiceid());
            stm.setObject(3, invoicecheque.getChequeno());
            stm.setObject(4, invoicecheque.getBranch());
            stm.setObject(5, invoicecheque.getAccountno());
            stm.setObject(6, invoicecheque.getReceivedate());
            stm.setObject(7, invoicecheque.getBankingdate());
            stm.setObject(8, invoicecheque.getPayment());

            if (stm.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            String updatesql = "Update  invoicecheque set InvID=?,BankName=?,AccountNo=?,ReceiveDate=?,BankingDate=?,Payment=? Where ChequeNo=?";
            PreparedStatement stm = con.prepareStatement(updatesql);

            stm.setObject(7, invoicecheque.getChequeno());
            stm.setObject(1, invoicecheque.getInvoiceid());
            stm.setObject(2, invoicecheque.getBranch());
            stm.setObject(3, invoicecheque.getAccountno());
            stm.setObject(4, invoicecheque.getReceivedate());
            stm.setObject(5, invoicecheque.getBankingdate());
            stm.setObject(6, invoicecheque.getPayment());
            if (stm.executeUpdate() > 0) {
                return true;

            }
            return false;

        }

    }

    public String modifyInvoiceCheque(Invoice_Cheque cheque) throws SQLException, ClassNotFoundException {

        String searchsql = "Select * from invoicecheque Where ChequeNo='" + cheque.getChequeno() + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        while (rst.next()) {
            count++;
        }

        if (count == 1) {
            rst.beforeFirst();
            int id = 0;
            while (rst.next()) {
                id = rst.getInt("ICID");
            }
            System.out.println(id + " fuck the id");
            String updatesql = "Update  invoicecheque set InvID=?,ReceiveDate=?,BankingDate=?,Payment=? Where ChequeNo=?";
            PreparedStatement stm = con.prepareStatement(updatesql);
            cheque.setInvoice_chequeid(id);
            stm.setObject(5, cheque.getChequeno());
            stm.setObject(1, cheque.getInvoiceid());
            stm.setObject(2, cheque.getReceivedate());
            stm.setObject(3, cheque.getBankingdate());
            stm.setObject(4, cheque.getPayment());
            if (stm.executeUpdate() > 0) {
                return "updated";

            }
            return "cheque doesnt exist";
        }

        return "cheque doesnt exist";
    }

    public String removeInvoiceCheque(String chequeno) throws SQLException, ClassNotFoundException {

        String searchsql = "Select * from invoicecheque Where ChequeNo='" + chequeno + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        if (count == 1) {
            String deletesql = "Delete from  invoicecheque Where ChequeNo='" + chequeno + "'";
            PreparedStatement stm = con.prepareStatement(deletesql);
            if (stm.executeUpdate() > 0) {
                return "deleted";
            }
        }
        return "doesnt exist";
    }

    public static Invoice_Cheque[] findChequeInfoByChequeNo(String chequeno) throws SQLException, ClassNotFoundException {

        String searchsql = "select * from Invoice JOIN InvoiceCheque ON Invoice.InvID=InvoiceCheque.InvID where InvoiceCheque.ChequeNo='" + chequeno + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(searchsql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Invoice_Cheque[] list = new Invoice_Cheque[count];
        rst.beforeFirst();
        Invoice_Cheque ic;
        for (int i = 0; rst.next(); i++) {
            ic = new Invoice_Cheque();
            ic.setInvoice_chequeid(rst.getInt("ICID"));
            ic.setInvoiceid(rst.getInt("InvID"));
            ic.setChequeno(rst.getString("ChequeNo"));
            ic.setBranch(rst.getString("BankName"));
            ic.setAccountno(rst.getInt("AccountNo"));
            ic.setReceivedate(rst.getString("ReceiveDate"));
            ic.setBankingdate(rst.getString("BankingDate"));
            ic.setPayment(rst.getDouble("Payment"));
            list[i] = ic;
        }
        return list;

    }

    //write a function for view all cheques order by  banking date or receive date
    public Invoice_Cheque[] viewAllChequesOrderBy(String orderby) throws SQLException, ClassNotFoundException {

        String orderbyquery = "";
        if (orderby.equalsIgnoreCase("BankingDate")) {
            orderbyquery = "select * from InvoiceCheque order by BankingDate ASC";
        } else if (orderby.equalsIgnoreCase("ReceiveDate")) {
            orderbyquery = "select * from InvoiceCheque order by ReceiveDate ASC";
        } else {
            orderbyquery = "select * from InvoiceCheque order by ICID DESC";
        }
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(orderbyquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Invoice_Cheque[] list = new Invoice_Cheque[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            list[i] = new Invoice_Cheque(rst.getInt("ICID"), rst.getInt("InvID"), rst.getString("ChequeNo"), rst.getString("ReceiveDate"), rst.getString("BankingDate"), rst.getDouble("Payment"));

        }
        return list;

    }

    public static Invoice_Cheque[] findInvoiceBy(int invid) throws SQLException, ClassNotFoundException {
        String selectinvoicecheque = "Select * from InvoiceCheque where InvID='" + invid + "'ORDER BY ICID DESC";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(selectinvoicecheque);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Invoice_Cheque[] list = new Invoice_Cheque[count];
        rst.beforeFirst();
        Invoice_Cheque ic;
        for (int i = 0; rst.next(); i++) {
            ic = new Invoice_Cheque();
            ic.setInvoice_chequeid(rst.getInt("ICID"));
            ic.setInvoiceid(rst.getInt("InvID"));
            ic.setChequeno(rst.getString("ChequeNo"));
            ic.setBranch(rst.getString("BankName"));
            ic.setAccountno(rst.getInt("AccountNo"));
            ic.setReceivedate(rst.getString("ReceiveDate"));
            ic.setBankingdate(rst.getString("BankingDate"));
            ic.setPayment(rst.getDouble("Payment"));
            list[i] = ic;
        }
        return list;
    }
///new code by bVd

    public static boolean removeById(int id) throws SQLException, ClassNotFoundException {

        String deletequery = "delete from invoicecheque where ICID='" + id + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(deletequery);
        if (stm.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    public static Invoice_Cheque[] loadInvoice() throws SQLException, ClassNotFoundException {
        String selectquery = "select * from InvoiceCheque order by ICID DESC";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(selectquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Invoice_Cheque[] list = new Invoice_Cheque[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            list[i] = new Invoice_Cheque(rst.getInt("ICID"), rst.getInt("InvID"), rst.getString("ChequeNo"), rst.getString("ReceiveDate"), rst.getString("BankingDate"), rst.getDouble("Payment"));

        }
        return list;
    }
}
