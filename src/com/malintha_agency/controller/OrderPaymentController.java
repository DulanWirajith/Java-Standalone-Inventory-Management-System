/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.OrderDTO;
import com.malintha_agency.model.Payment;
import com.malintha_agency.model.PaymentDTO;
import com.malintha_agency.model.Payment_Chque;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class OrderPaymentController {

    public String savePayment(Payment payment) throws SQLException, ClassNotFoundException {

        String orderupdatequery = "Update Orders set ToDoPayment=Payment-'" + payment.getPayment() + "'Where OID='" + payment.getOid() + "' AND FinalPayment>'" + payment.getPayment() + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(orderupdatequery);
        if (stm.executeUpdate(orderupdatequery) > 0) {
            String insertpaymentquery = "insert into Orders_Payment values(?,?,?,?)";
            stm = con.prepareStatement(insertpaymentquery);
            stm.setObject(1, payment.getPaymentid());
            stm.setObject(2, payment.getOid());
            stm.setObject(3, payment.getDate1());
            stm.setObject(4, payment.getPayment());
            if (stm.executeUpdate() > 0) {
                return "ok";
            }
            return "failed to update order payment";
        } else {
            return "fail";
        }
    }

    public static String addPayment(Payment payment) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getDBConnection().getConnection();
        if (payment.isIscheck()) {
            String insertcheque = "insert into  Orders_payment_Cheques values(?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(insertcheque);
            stm.setObject(1, payment.getPaymentcheques().getChequeno());
            stm.setObject(2, payment.getPaymentcheques().getPaymentid());
            stm.setObject(3, payment.getPaymentcheques().getReceivedate());
            stm.setObject(4, payment.getPaymentcheques().getBankingdate());
            stm.setObject(5, payment.getPaymentcheques().getPayment());
            if (stm.executeUpdate() > 0) {

                String insertcredit = "insert into Orders_Payment values(?,?,?,?)";
                PreparedStatement stm1 = con.prepareStatement(insertcredit);
                stm.setObject(1, payment.getPaymentid());
                stm.setObject(2, payment.getOid());
                stm.setObject(3, payment.getDate1());
                stm.setObject(4, payment.getPayment());
                if (stm1.executeUpdate() > 0) {
                    String orderupdatequery = "Update Orders set ToDoPayment=Payment-'" + payment.getPayment() + "'Where OID='" + payment.getOid() + "' AND payment>'" + payment.getPayment() + "'";
                    PreparedStatement stm2 = con.prepareStatement(orderupdatequery);
                    if (stm2.executeUpdate(orderupdatequery) > 0) {
                        return "cheque payment saved";
                    }
                }
                return "fail";
            }
        } else {
            String insertcredit = "insert into Orders_Payment values(?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(insertcredit);

            stm.setObject(1, payment.getPaymentid());
            stm.setObject(2, payment.getOid());
            stm.setObject(3, payment.getDate1());
            stm.setObject(4, payment.getPayment());
            if (stm.executeUpdate() > 0) {
                String orderupdatequery = "Update Orders set ToDoPayment=Payment-'" + payment.getPayment() + "'Where OID='" + payment.getOid() + "' AND payment>'" + payment.getPayment() + "'";
                PreparedStatement stm1 = con.prepareStatement(orderupdatequery);
                if (stm.executeUpdate(orderupdatequery) > 0) {
                    return "credit payment saved";
                }
            }
            return "fail";
        }
        return "f";
    }

    public static Payment[] viewPaymentByOrder(int oid) throws SQLException, ClassNotFoundException {
        String selectOrderpaymentquery = "select * from Orders_Payment where OID='" + oid + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(selectOrderpaymentquery);
        int count = 0;
        ArrayList<Payment_Chque> cheques;
        while (rst.next()) {
            count++;
        }
        rst.beforeFirst();
        Payment[] payments = new Payment[count];
        if (count > 0) {
            for (int i = 0; rst.next(); i++) {
                String viewcheques = "select * from  Orders_Payment_Cheques where PayID='" + rst.getInt("PayID") + "'";
                Statement stm = con.createStatement();
                ResultSet rst1 = stm.executeQuery(viewcheques);
                int count2 = 0;
                while (rst1.next()) {
                    count2++;
                }
                cheques = new ArrayList<>();
                rst1.beforeFirst();
                if (count2 > 0) {
                    while (rst1.next()) {
                        Payment_Chque cheque = new Payment_Chque(rst1.getString("ChequeNo"), rst1.getString("ReceiveDate"), rst1.getString("BankingDate"), rst1.getDouble("Payment"));
                        cheques.add(cheque);
                    }
                    payments[i] = new Payment(rst.getInt("PayID"), rst.getInt("OID"), rst.getString("PDate"), rst.getDouble("Payment"), cheques);

                }
                payments[i] = new Payment(rst.getInt("PayID"), rst.getInt("OID"), rst.getString("PDate"), rst.getDouble("Payment"), null);
            }
            return payments;
        }//if no payment exists return null
        return null;
    }

    public static String removePayment(int payid, boolean isokay) throws SQLException, ClassNotFoundException {
        String findchequesexistquery = "select * from Orders_Payment_Cheques where PayID='" + payid + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst1 = stm.executeQuery(findchequesexistquery);
        int count = 0;
        while (rst1.next()) {
            count++;
        }
        if (count > 0 & !isokay) {
            return "you have cheques for this payment.Are you sure you need to proceed";
        } else if (count > 0 & isokay) {
            String deletepaymentquery = "delete from Orders_Payment where PayID='" + payid + "'";
            PreparedStatement stm1 = con.prepareStatement(deletepaymentquery);
            if (stm1.executeUpdate() > 0) {
                return "ok";
            }
        }
        return "";
    }
    
    //New Codes
    public static boolean addPayment(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException {
        String insertsql = "Insert into orders_payment (OID,PDate,Payment) values(?,?,?)";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(insertsql);
        stm.setObject(1, paymentDTO.getOid());
        stm.setObject(2, paymentDTO.getDate1());
        stm.setObject(3, paymentDTO.getPayment());
        return stm.executeUpdate() > 0;
    }

    public static boolean deletePayment(int id) throws SQLException, ClassNotFoundException {
        String insertsql = "delete from orders_payment where PayID=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(insertsql);
        stm.setObject(1, id);
        return stm.executeUpdate() > 0;
    }

    public static PaymentDTO getOrderPaidAmount(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        String searchsql = "select sum(Payment) from orders_payment where OID=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(searchsql);
        stm.setObject(1, orderDTO.getOrderid());
        ResultSet rst = stm.executeQuery();
        PaymentDTO payment = new PaymentDTO();
        if (rst.next()) {
            payment.setPayment(rst.getDouble(1));
        }
        return payment;
    }

    public static ArrayList<PaymentDTO> getAll(String id) throws SQLException, ClassNotFoundException {
        String searchsql = "select PDate,Payment,PayID from orders_payment where OID=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(searchsql);
        stm.setObject(1, id);
        ResultSet rst = stm.executeQuery();
        ArrayList<PaymentDTO> paymentDTOs = new ArrayList<>();
        while (rst.next()) {
            PaymentDTO payment = new PaymentDTO();
            payment.setDate1(rst.getString(1));
            payment.setPayment(rst.getDouble(2));
            payment.setPaymentid(rst.getInt(3));
            paymentDTOs.add(payment);
        }
        return paymentDTOs;
    }
    
    
    //removepaymentchequeby chequeno
}
