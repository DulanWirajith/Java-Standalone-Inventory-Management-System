/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import java.sql.SQLException;
import java.sql.*;
import com.malintha_agency.model.Route;

/**
 *
 * @author Dell
 */
public class RouteController {

    /*==========================================
         Manage Route 
    ==========================================================*/
    public String saveRoute(Route route) throws SQLException, ClassNotFoundException {
        String searchsql = "Select RouteNo from Route Where RouteNo='" + route.getRouteno() + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        if (count == 0) {
            String insertsql = "Insert into Route values(?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(insertsql);

            stm.setObject(1, route.getRouteid());
            stm.setObject(2, route.getRouteno());
            stm.setObject(3, route.getRoutename());
            stm.setObject(4, route.getExtrainfo());
            if (stm.executeUpdate() > 0) {
                return "ok";
            } else {
                return "f";
            }
        } else {
            return "ae";
        }

    }

    public String modifyRoute(Route route) throws SQLException, ClassNotFoundException {
        String searchsql = "select * from Route where RouteNo='" + route.getRouteno() + "'";
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
                id = rst.getInt("RID");
            }
            System.out.println(id + " fuck the id");
            String updatesql = "Update Route set RouteNo=?,RouteName=?,Extrainfo=? where RID=?";
            PreparedStatement stm = con.prepareStatement(updatesql);
            route.setRouteid(id);
            stm.setObject(4, route.getRouteid());
            stm.setObject(1, route.getRouteno());
            stm.setObject(2, route.getRoutename());
            stm.setObject(3, route.getExtrainfo());
            if (stm.executeUpdate() > 0) {
                return "ok";

            }
            return "f";
        }
        return "ude";

    }

    public String removeRoute(int id) throws SQLException, ClassNotFoundException {

        String deletesql = "Delete from Route where RID='" + id + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(deletesql);
        if (stm.executeUpdate() > 0) {
            return "ok";
        }
        return "f";

    }

    public Route findRoute(int id) throws SQLException, ClassNotFoundException {
        String searchsql = "select * from Route where RouteNo='" + id + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        Route foundroute = null;
        while (rst.next()) {
            count++;
        }

        if (count == 1) {
            rst.beforeFirst();
            while (rst.next()) {
                foundroute = new Route(rst.getInt("RID"), rst.getInt("RouteNo"), rst.getString("RouteName"), rst.getString("Extrainfo"));
            }
            System.out.println(foundroute.getRouteid());
            return foundroute;
        }

        return null;
    }
    
    
      public static Route findRoutebyID(int id) throws SQLException, ClassNotFoundException {
        String searchsql = "select * from Route where RID='" + id + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        Route foundroute = null;
        while (rst.next()) {
            count++;
        }

        if (count == 1) {
            rst.beforeFirst();
            while (rst.next()) {
                foundroute = new Route(rst.getInt("RID"), rst.getInt("RouteNo"), rst.getString("RouteName"), rst.getString("Extrainfo"));
            }
            System.out.println(foundroute.getRouteid());
            return foundroute;
        }

        return null;
    }
    
    

    public Route[] viewAllRoutes() throws SQLException, ClassNotFoundException {
        String query = "Select * from Route";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(query);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Route[] list = new Route[count];
        Route route = null;
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            route = new Route(rst.getInt("RouteNo"), rst.getString("RouteName"), rst.getString("Extrainfo"));
            route.setRouteid(rst.getInt("RID"));
            list[i] = route;
        }
        return list;

    }
}
