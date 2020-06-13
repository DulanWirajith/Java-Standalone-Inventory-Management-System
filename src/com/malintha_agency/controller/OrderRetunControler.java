/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.Order_Detail;
import com.malintha_agency.model.Order_ReturnDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Imalka Gunawardana
 */
public class OrderRetunControler {

    public static boolean addOrderReturn(Order_ReturnDTO order_ReturnDTO) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getDBConnection().getConnection();
        try {
            con.setAutoCommit(false);
            String sql = "insert into orders_return_product (OID,ProID,ReturnDate,Reason,Qty) values (?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setObject(1, order_ReturnDTO.getOrder_id());
            stm.setObject(2, order_ReturnDTO.getProid());
            stm.setObject(3, order_ReturnDTO.getDate());
            stm.setObject(4, order_ReturnDTO.getReason());
            stm.setObject(5, order_ReturnDTO.getQty());
            int executeUpdate = stm.executeUpdate();
            if (executeUpdate > 0) {
                String updateSql = "update orderdetail set Qty=Qty-? where OID=? && ProID=?";
                PreparedStatement preparedStatement = con.prepareStatement(updateSql);
                preparedStatement.setObject(1, order_ReturnDTO.getQty());
                preparedStatement.setObject(2, order_ReturnDTO.getOrder_id());
                preparedStatement.setObject(3, order_ReturnDTO.getProid());
                int executeUpdate1 = preparedStatement.executeUpdate();
                if (executeUpdate1 > 0) {
                    con.commit();
                    return true;
                }
            }
            con.rollback();
            return false;
        } finally {
            con.setAutoCommit(true);
        }
    }

    public static ArrayList<Order_ReturnDTO> getOrderReturnDetails(String oid) throws SQLException, ClassNotFoundException {
        String allinvoicequery = "Select ProductName,odr.Qty,Reason,ReturnDate,p.ProID from orders od,orders_return_product odr,product p where odr.ProID=p.ProID && odr.OID=od.OID && od.oid=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(allinvoicequery);
        stm.setObject(1, oid);
        ResultSet rst = stm.executeQuery();
        ArrayList<Order_ReturnDTO> order_Details = new ArrayList<>();
        while (rst.next()) {
            Order_ReturnDTO order_Detail = new Order_ReturnDTO();
            order_Detail.setProductName(rst.getString(1));
            order_Detail.setQty(rst.getInt(2));
            order_Detail.setReason(rst.getString(3));
            order_Detail.setDate(rst.getString(4));
            order_Detail.setProid(rst.getInt(5));
            order_Details.add(order_Detail);
        }
        return order_Details;
    }

    public static boolean removeOrderReturn(Order_ReturnDTO order_ReturnDTO) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getDBConnection().getConnection();
        try {
            con.setAutoCommit(false);
            String sql = "delete from orders_return_product where OID=? && ProID=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setObject(1, order_ReturnDTO.getOrder_id());
            stm.setObject(2, order_ReturnDTO.getProid());
            int executeUpdate = stm.executeUpdate();
            if (executeUpdate > 0) {
                String updateSql = "update orderdetail set Qty=Qty+? where OID=? && ProID=?";
                PreparedStatement preparedStatement = con.prepareStatement(updateSql);
                preparedStatement.setObject(1, order_ReturnDTO.getQty());
                preparedStatement.setObject(2, order_ReturnDTO.getOrder_id());
                preparedStatement.setObject(3, order_ReturnDTO.getProid());
                int executeUpdate1 = preparedStatement.executeUpdate();
                if (executeUpdate1 > 0) {
                    con.commit();
                    return true;
                }
            }
            con.rollback();
            return false;
        } finally {
            con.setAutoCommit(true);
        }
    }
}
