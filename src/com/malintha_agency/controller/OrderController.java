/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.Order;
import com.malintha_agency.model.OrderDTO;
import com.malintha_agency.model.Order_Detail;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class OrderController {

    public String saveOrder(Order order) throws SQLException, ClassNotFoundException {
        /*check wether is there order exist for that shop for that day if exist update order details
        order doesnt exist first create order and update order details
         */
        String searchquery = "select * from Orders where SID='" + order.getSID() + "' AND IssueDate='" + order.getDate() + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchquery);
        int count = 0;
        int t = 0;
        while (rst.next()) {
            t = rst.getInt("OID");
            count++;
        }
        rst.beforeFirst();
        if (count <= 0) {
            //Order doesnt exist and create new Order and update Order details
            String insertorderquery = "insert into Orders values(?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(insertorderquery);

            stm.setObject(1, order.getOrderid());
            stm.setObject(2, order.getSID());
            stm.setObject(3, order.getDate());
            stm.setObject(4, order.getFullqty());
            stm.setObject(5, order.getDiscount());
            stm.setObject(6, order.getDonepayment());
            stm.setObject(7, order.getOrderpayment());
            stm.setObject(8, order.getFinalpayment());

            if (stm.executeUpdate() > 0) {
                searchquery = "select * from Orders where SID='" + order.getSID() + "' AND IssueDate='" + order.getDate() + "'";
                Statement stm2 = con.createStatement();
                ResultSet rst1 = stm.executeQuery(searchquery);
                int count1 = 0;
                while (rst1.next()) {
                    t = rst1.getInt("OID");
                    count1++;
                }
                rst1.beforeFirst();
                return t + "";
            } else {

                return "f";
            }
        } else {
            return t + "";
        }
    }

    public String removeOrder(int id) throws SQLException, ClassNotFoundException {
        //check  payments or order details exist for that perticular order
        String deletequery = "Delete from Orders where OID='" + id + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(deletequery);
        if (stm.executeUpdate() > 0) {
            return "ok";
        }
        return "f";

    }

    public static Order[] findOrderByDate(String date) throws SQLException, ClassNotFoundException {

        String searchquery = "select * from Orders where IssueDate='" + date + "' Order By ASC";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(searchquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Order[] orders = new Order[count];
        Order order = null;
        if (count != 0) {
            for (int i = 0; rst.next(); i++) {
                order = new Order();
                order.setOrderid(rst.getInt("OID"));
                order.setSID(rst.getInt("SID"));
                order.setDate(rst.getString("IssueDate"));
                order.setFullqty(rst.getInt("Qty"));
                order.setDiscount(rst.getDouble("Discount"));
                order.setTodopayment(rst.getDouble("ToDoPayment"));
                order.setPayment(rst.getDouble("Payment"));
                order.setFinalpayment(rst.getDouble("FinalPayment"));

                orders[i] = order;
            }
            return orders;
        }
        return null;
    }

    public static boolean modifyOrder(Order order) throws SQLException, ClassNotFoundException {
        String updatequery = "update orders set SID=?,IssueDate=?,Qty=?,Discount=?,ToDoPayment=?,Payment=?,FinalPayment=? where OID=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(updatequery);
        stm.setObject(8, order.getOrderid());
        stm.setObject(1, order.getSID());
        stm.setObject(2, order.getDate());
        stm.setObject(3, order.getFullqty());
        stm.setObject(4, order.getDiscount());
        stm.setObject(5, order.getDonepayment());
        stm.setObject(6, order.getOrderpayment());
        stm.setObject(7, order.getFinalpayment());

        if (stm.executeUpdate() > 0) {
            return true;
        }
        return false;
    }
    
    //New Codes
    public static boolean removeOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getDBConnection().getConnection();
        try {
            con.setAutoCommit(false);
            String deletequery = "Delete from Orders where OID=?";
            PreparedStatement stm = con.prepareStatement(deletequery);
            stm.setObject(1, orderDTO.getOrderid());
            if (stm.executeUpdate() > 0) {
                ArrayList<Order_Detail> order_Details = orderDTO.getOrder_Details();
                int count = 0;
                for (Order_Detail order_Detail : order_Details) {
                    String updateSql = "update product set Qty=Qty+? where ProID=?";
                    PreparedStatement preparedStatement3 = con.prepareStatement(updateSql);
                    preparedStatement3.setObject(1, order_Detail.getQty());
                    preparedStatement3.setObject(2, order_Detail.getProdid());
                    if (preparedStatement3.executeUpdate() > 0) {
                        count++;
                    }
                }
                if (order_Details.size() == count) {
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

    public ArrayList<OrderDTO> viewOrderInformations() throws SQLException, ClassNotFoundException {
        String selectorderquery = "select * from orders";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(selectorderquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        OrderDTO[] orderlist = new OrderDTO[count];

        return null;
    }
}
