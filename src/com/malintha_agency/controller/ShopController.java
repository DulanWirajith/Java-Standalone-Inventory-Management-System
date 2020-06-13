/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.Route;
import com.malintha_agency.model.Shop;
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
public class ShopController {

    /*===============================================
    Manage Shop informations 
    =========================================================*/
    public String saveShop(Shop shop) throws SQLException, ClassNotFoundException {
        String searchsql = "Select * from Shop Where ShopName='" + shop.getShopname() + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        if (count == 0) {
            String insertsql = "Insert into Shop values(?,?,?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(insertsql);

            stm.setObject(1, shop.getShopid());
            stm.setObject(2, shop.getRouteno());
            stm.setObject(3, shop.getShopname());
            stm.setObject(4, shop.getShopowner());
            stm.setObject(5, shop.getShopemail());
            stm.setObject(6, shop.getContactno());
            if (stm.executeUpdate() > 0) {
                return "ok";
            } else {
                return "f";
            }
        } else {
            return "ae";
        }

    }

    public String modifyShop(Shop shop) throws SQLException, ClassNotFoundException {

        String searchsql = "Select * from Shop Where SID='" + shop.getShopid() + "'";
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
                id = rst.getInt("SID");
            }
            System.out.println(id + " fuck the id");
            String updatesql = "Update Shop set RID=?,ShopName=?,ShopOwner=?,ShopEmail=?,Contact=? where SID=?";
            PreparedStatement stm = con.prepareStatement(updatesql);
            shop.setShopid(id);
            stm.setObject(6, shop.getShopid());
            stm.setObject(1, shop.getRouteno());
            stm.setObject(2, shop.getShopname());
            stm.setObject(3, shop.getShopowner());
            stm.setObject(4, shop.getShopemail());
            stm.setObject(5, shop.getContactno());
            if (stm.executeUpdate() > 0) {
                return "ok";

            }
            return "f";
        }
        return "ude";

    }

    public String removeShop(int id) throws SQLException, ClassNotFoundException {
        String searchsql = "Select * from Shop Where SID='" + id + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        while (rst.next()) {
            count++;
        }

        if (count == 1) {
            String deletesql = "Delete from Shop where SID='" + id + "'";
            PreparedStatement stm = con.prepareStatement(deletesql);
            if (stm.executeUpdate() > 0) {
                return "ok";
            }
            return "f";
        }
        return "ude";
    }

    public Shop[] viewShops() throws SQLException, ClassNotFoundException {
        String query = "Select * from  Shop ";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(query);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Shop[] list = new Shop[count];
        Shop shop = null;
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            shop = new Shop();
            shop.setShopid(rst.getInt("SID"));
            shop.setRouteno(rst.getInt("RID"));
            shop.setShopowner(rst.getString("ShopOwner"));
            shop.setShopname(rst.getString("ShopName"));
            shop.setShopemail(rst.getString("ShopEmail"));
            shop.setContactno(rst.getString("Contact"));

            list[i] = shop;

        }
        return list;

    }

    public Shop[] findShopByRoute(int routeno) throws SQLException, ClassNotFoundException {
        String query = "Select * from  Shop  Where RID='" + routeno + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(query);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Shop[] list = new Shop[count];
        Shop shop = null;
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            shop = new Shop();
           shop.setShopid(rst.getInt("SID"));
            shop.setRouteno(rst.getInt("RID"));
            shop.setShopowner(rst.getString("ShopOwner"));
            shop.setShopname(rst.getString("ShopName"));
            shop.setShopemail(rst.getString("ShopEmail"));
            shop.setContactno(rst.getString("Contact"));

            list[i] = shop;

        }
        return list;

    }

    public Shop findShopByName(String shopname) throws SQLException, ClassNotFoundException {
        String searchsql = "select * from Shop where ShopName='" + shopname + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        int count = 0;
        Shop foundshop = null;
        while (rst.next()) {
            count++;
        }

        if (count == 1) {
            rst.beforeFirst();
            Shop shop = null;
            while (rst.next()) {
                shop = new Shop();
                shop.setShopid(rst.getInt("SID"));
                shop.setRouteno(rst.getInt("RID"));
                shop.setShopname(rst.getString("ShopName"));
                shop.setShopemail(rst.getString("ShopEmail"));
                shop.setContactno(rst.getString("Contact"));

                foundshop = shop;
            }
            System.out.println();
            return foundshop;
        }
        return null;
    }

    //New Codes
    public static ArrayList<Shop> getShopNames() throws SQLException, ClassNotFoundException {
        String searchsql = "select ShopName from Shop";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchsql);
        ArrayList<Shop> shops = new ArrayList<>();
        while (rst.next()) {
            Shop shop = new Shop();
            shop.setShopname(rst.getString(1));
            shops.add(shop);
        }
        return shops;
    }

    public static Shop getShopIdByName(String name) throws SQLException, ClassNotFoundException {
        String searchsql = "select SID from Shop where ShopName=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(searchsql);
        stm.setObject(1, name);
        ResultSet rst = stm.executeQuery();
        Shop shop = new Shop();
        if (rst.next()) {
            shop.setShopid(rst.getInt(1));
        }
        return shop;
    }
}
