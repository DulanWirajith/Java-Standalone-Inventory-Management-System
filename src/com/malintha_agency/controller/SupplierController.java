/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.Invoice_Cheque;
import com.malintha_agency.model.Supplier;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class SupplierController {

    /*========================================
     Manage Suppliers
     ==================================================================*/
    public boolean saveSupplier(Supplier supplier) throws SQLException, ClassNotFoundException {

        String searchquery = "";
        String updatequery = "";
        if (supplier.getSupplierid() != 0) {
            searchquery = "Select * from Supplier Where SupID='" + supplier.getSupplierid() + "'";
            updatequery = "Update Supplier set Name=?,Address=?,Email=?,Contact=? where SupID=?";
        } else {
            searchquery = "Select * from Supplier Where Name='" + supplier.getSuppliername() + "'";
            updatequery = "Update Supplier set Address=?,Email=?,Contact=? where Name=?";
        }

        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        if (count == 0) {
            String insertsql = "Insert into Supplier values(?,?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(insertsql);

            stm.setObject(1, supplier.getSupplierid());
            stm.setObject(2, supplier.getSuppliername());
            stm.setObject(3, supplier.getAddress());
            stm.setObject(4, supplier.getEmail());
            stm.setObject(5, supplier.getContactno());
            if (stm.executeUpdate() > 0) {
                System.out.println("save");
                return true;
            } else {
                return false;
            }
        } else {

            PreparedStatement stm = con.prepareStatement(updatequery);
            if (supplier.getSupplierid() != 0) {
                stm.setObject(5, supplier.getSupplierid());
                stm.setObject(1, supplier.getSuppliername());
                stm.setObject(2, supplier.getAddress());
                stm.setObject(3, supplier.getEmail());
                stm.setObject(4, supplier.getContactno());

            } else {
                stm.setObject(4, supplier.getSuppliername());
                stm.setObject(1, supplier.getAddress());
                stm.setObject(2, supplier.getEmail());
                stm.setObject(3, supplier.getContactno());

            }
            if (stm.executeUpdate() > 0) {
                System.out.println("updated");
                return true;

            }
            return false;

        }

    }

    public String modifySupplier(Supplier supplier) throws SQLException, ClassNotFoundException {

        String searchsql = "select * from Supplier where SupID='" + supplier.getSupplierid() + "'";
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
                id = rst.getInt("SupID");
            }
            System.out.println(id + " fuck the id");
            String updatesql = "Update Supplier set Name=?,Address=?,Email=?,Contact=? where SupID=?";
            PreparedStatement stm = con.prepareStatement(updatesql);
            supplier.setSupplierid(id);
            stm.setObject(5, supplier.getSupplierid());
            stm.setObject(1, supplier.getSuppliername());
            stm.setObject(2, supplier.getAddress());
            stm.setObject(3, supplier.getEmail());
            stm.setObject(4, supplier.getContactno());
            if (stm.executeUpdate() > 0) {
                return "ok";

            }
            return "f";
        }
        return "ude";
    }


    public static boolean removeSupplier(int id) throws SQLException, ClassNotFoundException {

        String searchsql = "select * from Supplier where SupID='" + id + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        while (rst.next()) {
            count++;
        }

        if (count == 1) {
            String deletesql = "Delete from Supplier where SupID='" + id + "'";
            PreparedStatement stm = con.prepareStatement(deletesql);
            if (stm.executeUpdate() > 0) {
                return true;
            }
            return false;
        }
        return false;

    }

    public static Supplier[] viewSuppliers() throws SQLException, ClassNotFoundException {

        String query = "Select * from Supplier ORDER BY SupID DESC";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(query);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Supplier[] list = new Supplier[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            list[i] = new Supplier(rst.getInt("SupID"), rst.getString("Name"), rst.getString("Address"), rst.getString("Email"), rst.getString("Contact"));

        }
        return list;
    }

    public static Supplier[] searchSupplierBYName(String name) throws SQLException, ClassNotFoundException {

        String searchsql = "select * from Supplier where Name='" + name + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        if (count == 1) {
            Supplier[] list = new Supplier[count];
            rst.beforeFirst();
            for (int i = 0; rst.next(); i++) {
                list[i] = new Supplier(rst.getInt("SupID"), rst.getString("Name"), rst.getString("Address"), rst.getString("Email"), rst.getString("Contact"));

            }

            return list;
        }

        return null;

    }

    public static Supplier searchSupplierBYId(int supid) throws SQLException, ClassNotFoundException {

        String searchsql = "select * from Supplier where SupID='" + supid + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        Supplier foundsupplier = null;
        while (rst.next()) {
            count++;
        }
        if (count == 1) {
            rst.beforeFirst();
            while (rst.next()) {
                foundsupplier = new Supplier(rst.getInt("SupID"), rst.getString("Name"), rst.getString("Address"), rst.getString("Email"), rst.getString("Contact"));
            }
            System.out.println();
            return foundsupplier;
        }

        return null;

    }

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

    public static Supplier getSupplierIdViaName(String name) throws SQLException, ClassNotFoundException {
        String searchsql = "select SupID from supplier where Name=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(searchsql);
        stm.setObject(1, name);
        ResultSet rst = stm.executeQuery();
        Supplier supplier = new Supplier();
        if (rst.next()) {
            supplier.setSupplierid(rst.getInt(1));
        }
        return supplier;
    }
}
