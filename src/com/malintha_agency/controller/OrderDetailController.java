/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.OrderDTO;
import com.malintha_agency.model.Order_Detail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class OrderDetailController {

    //check if is credited or not perticular product
    public String saveOrderInformation(Order_Detail orderinformation) throws SQLException, ClassNotFoundException {
        int no = 0;
        boolean temp = false;
        if (orderinformation.isCredit()) {
            no = 1;
        }

        String orderinfoexist = "select * from OrderDetail where ProID='" + orderinformation.getProdid() + "' AND OID='" + orderinformation.getOid() + "' AND Credit='" + no + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(orderinfoexist);
        int count = 0;
        int ordid = 0;
        while (rst.next()) {
            ordid = rst.getInt("OID");
            count++;
        }
        System.err.println(count);
        rst.beforeFirst();
        if (count == 0) {
            // return "order details doesnt exist";
            //no orderdetail exist create order detail and update Order informations
            String insertorderinfosql = "Insert into OrderDetail values(?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(insertorderinfosql);
            stm.setObject(1, orderinformation.getOrder_detailid());
            stm.setObject(2, orderinformation.getOid());
            stm.setObject(3, orderinformation.getProdid());
            stm.setObject(4, orderinformation.isCredit());
            stm.setObject(5, orderinformation.getQty());
            stm.setObject(6, orderinformation.getDiscount());
            stm.setObject(7, orderinformation.getPrice());
            if (stm.executeUpdate() > 0) {
                if (no != 1) {
                    String updateOrder = "Update Orders set Qty=Qty+'" + orderinformation.getQty() + "',Payment=Payment+'" + orderinformation.getPrice() + "' Where OID='" + orderinformation.getOid() + "'";
                    stm = con.prepareStatement(updateOrder);
                    if (stm.executeUpdate(updateOrder) > 0) {
                        return "ok";
                    }
                    return "ok";
                }

            } else {
                return "f";
            }
        } else {
            //return "order  exist";
            //orderdetail exist update orderdetails and update Order informations
            System.out.println("order details exist");
            String updateorderdetailquery = "Update Orderdetail set Qty=Qty+'" + orderinformation.getQty() + "',Discount=Discount+'" + orderinformation.getDiscount() + "',Payment=Payment+'" + orderinformation.getPrice() + "' where ProID='" + orderinformation.getProdid() + "' AND OID='" + ordid + "' AND Credit='" + no + "'";
            PreparedStatement stm = con.prepareStatement(updateorderdetailquery);
            if (stm.executeUpdate(updateorderdetailquery) > 0) {
                if (no != 1) {
                    String updateOrder = "Update Orders set Qty=Qty+'" + orderinformation.getQty() + "',Payment=Payment+'" + orderinformation.getPrice() + "' Where OID='" + orderinformation.getOid() + "'";
                    stm = con.prepareStatement(updateOrder);
                    if (stm.executeUpdate(updateOrder) > 0) {
                        return "orderdetail and order  updated";
                    }
                    return "failed to update orderdetail and order update";

                }

                // return "orderdetails updated";
            }

        }
        return "failed";
    }

    //New Codes
    public static boolean addOrderDetailWithOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getDBConnection().getConnection();
        try {
            connection.setAutoCommit(false);
            String sqlOrder = "insert into orders values (?,?,?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sqlOrder);
            preparedStatement1.setObject(1, orderDTO.getOrderid());
            preparedStatement1.setObject(2, orderDTO.getSID());
            preparedStatement1.setObject(3, orderDTO.getDate());
            if (preparedStatement1.executeUpdate() > 0) {
                Order_Detail order_Detail = orderDTO.getOrder_Detail();
                String sqlOrderDetail = "insert into orderdetail values (?,?,?,?,?,?)";
                PreparedStatement preparedStatement2 = connection.prepareStatement(sqlOrderDetail);
                preparedStatement2.setObject(1, order_Detail.getOrder_detailid());
                preparedStatement2.setObject(2, order_Detail.getOid());
                preparedStatement2.setObject(3, order_Detail.getProdid());
                preparedStatement2.setObject(4, order_Detail.getDiscount());
                preparedStatement2.setObject(5, order_Detail.getQty());
                preparedStatement2.setObject(6, order_Detail.getPayment());
                if (preparedStatement2.executeUpdate() > 0) {
                    String updateSql = "update product set Qty=Qty-? where ProID=?";
                    PreparedStatement preparedStatement3 = connection.prepareStatement(updateSql);
                    preparedStatement3.setObject(1, order_Detail.getQty());
                    preparedStatement3.setObject(2, order_Detail.getProdid());
                    if (preparedStatement3.executeUpdate() > 0) {
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static boolean addOrderDetail(Order_Detail order_Detail) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getDBConnection().getConnection();
        try {
            connection.setAutoCommit(false);
            String sqlOrderDetail = "insert into orderdetail values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlOrderDetail);
            preparedStatement.setObject(1, order_Detail.getOrder_detailid());
            preparedStatement.setObject(2, order_Detail.getOid());
            preparedStatement.setObject(3, order_Detail.getProdid());
            preparedStatement.setObject(4, order_Detail.getDiscount());
            preparedStatement.setObject(5, order_Detail.getQty());
            preparedStatement.setObject(6, order_Detail.getPayment());
            if (preparedStatement.executeUpdate() > 0) {
                String updateSql = "update product set Qty=Qty-? where ProID=?";
                PreparedStatement preparedStatement3 = connection.prepareStatement(updateSql);
                preparedStatement3.setObject(1, order_Detail.getQty());
                preparedStatement3.setObject(2, order_Detail.getProdid());
                if (preparedStatement3.executeUpdate() > 0) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static boolean updateOrderDetail(Order_Detail order_Detail) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getDBConnection().getConnection();
        String sql = "update orderdetail set Discount=?,Qty=?,Payment=? where OrdID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1, order_Detail.getDiscount());
        preparedStatement.setObject(2, order_Detail.getQty());
        preparedStatement.setObject(3, order_Detail.getPayment());
        preparedStatement.setObject(4, order_Detail.getOrder_detailid());
        return preparedStatement.executeUpdate() > 0;
    }

    public static boolean deleteOrderDetail(Order_Detail order_Detail) throws SQLException, ClassNotFoundException {
        Connection connection = DbConnection.getDBConnection().getConnection();
        try {
            connection.setAutoCommit(false);
            String sql = "delete from orderdetail where OrdID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setObject(1, order_Detail.getOrder_detailid());
            if (preparedStatement.executeUpdate() > 0) {
                String updateSql = "update product set Qty=Qty+? where ProID=?";
                PreparedStatement preparedStatement3 = connection.prepareStatement(updateSql);
                preparedStatement3.setObject(1, order_Detail.getQty());
                preparedStatement3.setObject(2, order_Detail.getProdid());
                if (preparedStatement3.executeUpdate() > 0) {
                    connection.commit();
                    return true;
                }
            }
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public static ArrayList<Order_Detail> getOrderDetails(String oid) throws SQLException, ClassNotFoundException {
        String allinvoicequery = "Select ProductName,Selling,Discount,od.Qty,OrdID from orderdetail od,product p where od.ProID=p.ProID && od.oid=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(allinvoicequery);
        stm.setObject(1, oid);
        ResultSet rst = stm.executeQuery();
        ArrayList<Order_Detail> order_Details = new ArrayList<>();
        while (rst.next()) {
            Order_Detail order_Detail = new Order_Detail();
            order_Detail.setProductName(rst.getString(1));
            order_Detail.setPayment(rst.getDouble(2));
            order_Detail.setDiscount(rst.getDouble(3));
            order_Detail.setQty(rst.getInt(4));
            order_Detail.setOrder_detailid(rst.getString(5));
            order_Details.add(order_Detail);
        }
        return order_Details;
    }
}
