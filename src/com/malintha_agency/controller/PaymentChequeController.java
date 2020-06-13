/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.Payment_Chque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class PaymentChequeController {
    //public static String 

    public static boolean savePaymentCheque(Payment_Chque cheque) throws SQLException, ClassNotFoundException {
        String insertquery = "insert into Orders_Payment_Cheques values(?,?,?,?,?)";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(insertquery);

        stm.setObject(1, cheque.getChequeno());
        stm.setObject(2, cheque.getPaymentid());
        stm.setObject(3, cheque.getReceivedate());
        stm.setObject(4, cheque.getBankingdate());
        stm.setObject(5, cheque.getPayment());

        if (stm.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    public static boolean modifyPaymentCheque(Payment_Chque cheque) throws SQLException, ClassNotFoundException {
        String updatequery = "update Orders_Payment_Cheques set ReceiveDate=? BankingDate=? Payment=? where ChequeNo=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(updatequery);
        stm.setObject(4, cheque.getChequeno());
        stm.setObject(1, cheque.getReceivedate());
        stm.setObject(2, cheque.getBankingdate());
        stm.setObject(3, cheque.getPayment());
        if (stm.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    public static Payment_Chque findBychequeNo(String chequeno) throws SQLException, ClassNotFoundException {
        String searchquery = "select * from Orders_Payment_Cheques where chequeno='" + chequeno + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        if (count != 0) {
            Payment_Chque cheque = null;
            rst.beforeFirst();
            for (int i = 0; rst.next(); i++) {
                cheque=new Payment_Chque();
                cheque.setPaymentid(rst.getInt("PayID"));
                cheque.setReceivedate(rst.getString("ReceiveDate"));
                cheque.setBankingdate(rst.getString("BankingDate"));
                cheque.setPayment(rst.getDouble("Payment"));
            }
            return cheque;

        }

        return null;
    }

    public static boolean removePaymentCheque(String chequeno) throws SQLException, ClassNotFoundException {
        String removequery = "delete from Orders_Payment_Cheques where ChequeNo='" + chequeno + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(removequery);
        if (stm.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

}
