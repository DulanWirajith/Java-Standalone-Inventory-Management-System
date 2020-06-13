/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.ReturnedNotice;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class ReturnItemController {

    public static boolean addReturnNotice(ReturnedNotice returnnotice) throws SQLException, ClassNotFoundException {
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm;
        if (returnnotice.getReason().equals("damage")) {
            String insertquery = "insert into Orders_Return_Product values(?,?,?,?,?,?)";

            stm = con.prepareStatement(insertquery);
            stm.setObject(1, returnnotice.getORPID());
            stm.setObject(2, returnnotice.getOID());
            stm.setObject(3, returnnotice.getProID());
            stm.setObject(4, returnnotice.getReturndate());
            stm.setObject(5, returnnotice.getReason());
            stm.setObject(6, returnnotice.getQty());

            if (stm.executeUpdate() > 0) {
                return true;
            }
        } else {
            String updatequery = "update Product set Qty=Qty+'" + returnnotice.getQty() + "' where ProID='" + returnnotice.getProID() + "'";
            stm = con.prepareStatement(updatequery);
            if (stm.executeUpdate(updatequery) > 0) {
                String insertquery = "insert into Orders_Return_Product values(?,?,?,?,?,?)";

                stm = con.prepareStatement(insertquery);
                stm.setObject(1, returnnotice.getORPID());
                stm.setObject(2, returnnotice.getOID());
                stm.setObject(3, returnnotice.getProID());
                stm.setObject(4, returnnotice.getReturndate());
                stm.setObject(5, returnnotice.getReason());
                stm.setObject(6, returnnotice.getQty());

                if (stm.executeUpdate() > 0) {
                    return true;
                }
                //insert return items to Order_return_product table failed 
                return false;
            }
            //product table update failed
            return false;
        }
        return false;
    }

    public static boolean modifyReturnNotice(ReturnedNotice returnnotice) throws SQLException, ClassNotFoundException {

        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm;
        if (returnnotice.getReason().equals("damage")) {
            String updatequery = "update Orders_Return_Product set OID=?,ProID=?,ReturnDate=?,Reason=?,Qty=? where ORPID=?";
            stm = con.prepareStatement(updatequery);
            stm.setObject(6, returnnotice.getORPID());
            stm.setObject(1, returnnotice.getOID());
            stm.setObject(2, returnnotice.getProID());
            stm.setObject(3, returnnotice.getReturndate());
            stm.setObject(4, returnnotice.getReason());
            stm.setObject(5, returnnotice.getQty());
            if (stm.executeUpdate() > 0) {
                return true;
            }
            return false;//damage returnNotice update failed
        } else {
            /*update old product qty (-)*/
            String updatequery = "update Product set Qty=Qty-'" + returnnotice.getOldQty() + "' where ProID='" + returnnotice.getOldProID() + "'";
            stm = con.prepareStatement(updatequery);

            if (stm.executeUpdate(updatequery) > 0) {
                /*update new product qty (+)*/
                String updatequery2 = "update Product set Qty=Qty+'" + returnnotice.getQty() + "' where ProID='" + returnnotice.getProID() + "'";
                stm = con.prepareStatement(updatequery2);

                if (stm.executeUpdate(updatequery2) > 0) {

                    /*update return notice*/
                    String updatequery3 = "update Orders_Return_Product set OID=?,ProID=?,ReturnDate=?,Reason=?,Qty=? where ORPID=?";
                    stm = con.prepareStatement(updatequery3);
                    stm.setObject(6, returnnotice.getORPID());
                    stm.setObject(1, returnnotice.getOID());
                    stm.setObject(2, returnnotice.getProID());
                    stm.setObject(3, returnnotice.getReturndate());
                    stm.setObject(4, returnnotice.getReason());
                    stm.setObject(5, returnnotice.getQty());
                    if (stm.executeUpdate() > 0) {
                        return true;
                    }
                    return false;//damage returnNotice update failed
                }
                return false;//update return product failed
            }
            return false;//update return old product failed
        }

    }

    public static boolean removeReturnNotice(int ORPID) throws SQLException, ClassNotFoundException {
        
        return false;
    }
}
