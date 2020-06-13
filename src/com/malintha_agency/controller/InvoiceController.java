/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.Invoice;
import com.malintha_agency.model.Invoice_Cheque;
import com.malintha_agency.model.Invoice_Product;
import com.malintha_agency.model.Products;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class InvoiceController {
   /*========================================
     Manage Invoices
     ==================================================================*/
    public String saveInvoice(Invoice invoice) throws SQLException, ClassNotFoundException {

        String searchsql = "Select * from Invoice Where InvoiceNo='" + invoice.getInvoiceno() + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        if (count == 0) {
            String insertsql = "Insert into Invoice values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(insertsql);

            stm.setObject(1, invoice.getInvoiceid());
            stm.setObject(2, invoice.getSupid());
            stm.setObject(3, invoice.getInvoiceno());
            stm.setObject(4, invoice.getLorryno());
            stm.setObject(5, invoice.getSubtotal());
            stm.setObject(6, invoice.getDiscount());
            stm.setObject(7, invoice.getNetamount());
            stm.setObject(8, invoice.getIssuedate());
            stm.setObject(9, invoice.getReceivedate());

            if (stm.executeUpdate() > 0) {
                return "ok";
            } else {
                return "f";
            }
        } else {
            String updatequery = "Update Invoice set SupID=?,LorryNo=?,SubTotal=?,Discount=?,NetAmount=?,IssueDate=?,ReceiveDate=? where InvoiceNo=?";
            PreparedStatement stm = con.prepareStatement(updatequery);
            stm.setObject(8, invoice.getInvoiceno());
            stm.setObject(1, invoice.getSupid());
            stm.setObject(2, invoice.getLorryno());
            stm.setObject(3, invoice.getSubtotal());
            stm.setObject(4, invoice.getDiscount());
            stm.setObject(5, invoice.getNetamount());
            stm.setObject(6, invoice.getIssuedate());
            stm.setObject(7, invoice.getReceivedate());
            if (stm.executeUpdate() > 0) {
                return "ok";
            } else {
                return "f";
            }
        }

    }

    public String modifyInvoice(Invoice invoice) throws SQLException, ClassNotFoundException {

        String searchsql = "select * from Invoice where InvoiceNo='" + invoice.getInvoiceno() + "'";
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
                id = rst.getInt("InvID");
            }
            System.out.println(id + " fuck the id");
            String updatesql = "Update Invoice set SupID=?,InvoiceNo=?,LorryNo=?,SubTotal=?,Discount=?,NetAmount=?,IssueDate=?,ReceiveDate=? where InvID=?";
            PreparedStatement stm = con.prepareStatement(updatesql);
            invoice.setInvoiceid(id);
            stm.setObject(9, invoice.getInvoiceid());
            stm.setObject(1, invoice.getSupid());
            stm.setObject(2, invoice.getInvoiceno());
            stm.setObject(3, invoice.getLorryno());
            stm.setObject(4, invoice.getSubtotal());
            stm.setObject(5, invoice.getDiscount());
            stm.setObject(6, invoice.getNetamount());
            stm.setObject(7, invoice.getIssuedate());
            stm.setObject(8, invoice.getReceivedate());
            if (stm.executeUpdate() > 0) {
                return "ok";
            }
            return "f";
        }
        return "ude";

    }


    public static boolean removeInvoice(String invoiceno) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getDBConnection().getConnection();
        String deleteinvoicequery = "Delete from Invoice where InvoiceNo='" + invoiceno + "'";
        PreparedStatement stm = con.prepareStatement(deleteinvoicequery);
        if (stm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public static Invoice findInvoiceByInvoiceNO(String invoiceno) throws SQLException, ClassNotFoundException {

        String searchsql = "select * from Invoice where InvoiceNo='" + invoiceno + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        Invoice foundinvoice = null;
        while (rst.next()) {
            count++;
        }

        if (count == 1) {
            rst.beforeFirst();
            while (rst.next()) {
                foundinvoice = new Invoice(rst.getInt("InvID"), rst.getInt("SupID"), rst.getString("InvoiceNo"), rst.getString("LorryNo"), rst.getDouble("SubTotal"), rst.getDouble("Discount"), rst.getDouble("NetAmount"), rst.getString("IssueDate"), rst.getString("ReceiveDate"));
            }
            System.out.println();
            return foundinvoice;
        }

        return null;

    }

    public static Invoice[] viewInvoices() throws SQLException, ClassNotFoundException {
        String allinvoicequery = "Select * from Invoice  ORDER BY InvID DESC";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(allinvoicequery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Invoice[] list = new Invoice[count];
        rst.beforeFirst();
        if (count > 0) {
            for (int i = 0; rst.next(); i++) {
                list[i] = new Invoice(rst.getInt("InvID"), rst.getInt("SupID"), rst.getString("InvoiceNo"), rst.getString("LorryNo"), rst.getDouble("SubTotal"), rst.getDouble("Discount"), rst.getDouble("NetAmount"), rst.getString("IssueDate"), rst.getString("ReceiveDate"));
            }
            return list;
        }
        return null;
    }

    //find invoice by receivedate or issue date
    public static Invoice[] findInvoiceByDate(String date, String option) throws SQLException, ClassNotFoundException {
        String findbydate = "";
        if (option.equals("RD")) {
            findbydate = "select * from Invoice where ReceiveDate='" + date + "'";
        } else {
            findbydate = "select * from Invoice where IssueDate='" + date + "'";
        }
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(findbydate);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Invoice[] list = new Invoice[count];
        rst.beforeFirst();
        if (count > 0) {
            for (int i = 0; rst.next(); i++) {
                list[i] = new Invoice(rst.getInt("InvID"), rst.getInt("SupID"), rst.getString("InvoiceNo"), rst.getString("LorryNo"), rst.getDouble("SubTotal"), rst.getDouble("Discount"), rst.getDouble("NetAmount"), rst.getString("IssueDate"), rst.getString("ReceiveDate"));
            }
            return list;
        }
        return null;

    }

    public static boolean removebyId(int id) throws SQLException, ClassNotFoundException {
        
        String deletequery = "delete from invoice where InvID='" + id + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(deletequery);
        if (stm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    //New Codes
    public static ArrayList<Invoice> getInvoicesNumbersViaSupplier(int id) throws SQLException, ClassNotFoundException {
        String allinvoicequery = "Select InvoiceNo from Invoice where SupID=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(allinvoicequery);
        stm.setObject(1, id);
        ResultSet rst = stm.executeQuery();
        ArrayList<Invoice> invoices = new ArrayList<>();
        while (rst.next()) {
            Invoice invoice = new Invoice();
            invoice.setInvoiceno(rst.getString(1));
            invoices.add(invoice);
        }
        return invoices;
    }

    public static ArrayList<Products> getProductsViaInvoicesNumber(int number) throws SQLException, ClassNotFoundException {
        String searchsql = "select ProductName from product p,invoice i where p.InvID=i.InvID && InvoiceNo=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(searchsql);
        stm.setObject(1, number);
        ResultSet rst = stm.executeQuery();
        ArrayList<Products> productses = new ArrayList<>();
        while (rst.next()) {
            Products products = new Products();
            products.setProductName(rst.getString(1));
            productses.add(products);
        }
        return productses;
    }
}
