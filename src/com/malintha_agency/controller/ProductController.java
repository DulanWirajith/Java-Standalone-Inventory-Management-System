/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.Invoice_Product;
import com.malintha_agency.model.ProductInfo;
import com.malintha_agency.model.Products;
import java.sql.*;

/**
 *
 * @author Dell
 */
public class ProductController {

    public static boolean saveProduct(Invoice_Product product) throws SQLException, ClassNotFoundException {

        String searchquery = "select * from Product where InvID='" + product.getInvid() + "' AND ProductName='" + product.getProductname() + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(searchquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        if (count == 0) {
            String insertsql = "Insert into Product values(?,?,?,?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(insertsql);

            stm.setObject(1, product.getInvoice_productid());
            stm.setObject(2, product.getInvid());
            stm.setObject(3, product.getProductname());
            stm.setObject(4, product.getBuyingprice());
            stm.setObject(5, product.getSellingprice());
            stm.setObject(6, product.getQty());
            stm.setObject(7, product.getDate());
            if (stm.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            String updatesql = "Update Product set ProductName=?,Buying=?,Selling=?,Qty=?,byingDate=? where InvID=? AND ProID=?";
            rst.beforeFirst();
            int id = 0;
            while (rst.next()) {
                id = rst.getInt("ProID");
            }

            PreparedStatement stm = con.prepareStatement(updatesql);
            product.setInvoice_productid(id);
            stm.setObject(7, product.getInvoice_productid());
            stm.setObject(6, product.getInvid());
            stm.setObject(1, product.getProductname());
            stm.setObject(2, product.getBuyingprice());
            stm.setObject(3, product.getSellingprice());
            stm.setObject(4, product.getQty());
            stm.setObject(5, product.getDate());
            if (stm.executeUpdate() > 0) {
                return true;

            }
            return false;
        }

    }

    public static boolean removeProduct(int proid) throws SQLException, ClassNotFoundException {

        String deletequery = "delete from Product where ProID='" + proid + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(deletequery);
        if (stm.executeUpdate() > 0) {
            return true;
        }

        return false;
    }

    public Invoice_Product[] viewAllProduct(String receivedate) throws SQLException, ClassNotFoundException {

        String searchquery = "select Product.ProID,Product.ProductName,Product.Qty,Product.Selling,Product.Buying from Invoice JOIN Product ON Invoice.InvID=Product.InvID Where Invoice.ReceiveDate='" + receivedate + "' AND Product.Qty>0";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(searchquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Invoice_Product[] list = new Invoice_Product[count];
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            list[i] = new Invoice_Product(rst.getInt("InvID"), rst.getInt("ProID"), rst.getString("ProductName"), rst.getDouble("Buying"), rst.getDouble("Selling"), rst.getInt("Qty"));

        }
        return list;
    }

    public static Invoice_Product[] findProductByInvoiceID(int invid) throws SQLException, ClassNotFoundException {
        String selectproduct = "select * from Product where InvID='" + invid + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(selectproduct);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Invoice_Product[] list = new Invoice_Product[count];
        Invoice_Product pro=null;
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            pro = new Invoice_Product();
            pro.setInvoice_productid(rst.getInt("ProID"));
            pro.setProductname(rst.getString("ProductName"));
            pro.setBuyingprice(rst.getDouble("Buying"));
            pro.setSellingprice(rst.getDouble("Selling"));
            pro.setQty(rst.getInt("Qty"));
            list[i]=pro;
        }
        return list;
    }

    //-----------------------------------product information part-----------------------------------------------//
    public static boolean saveProductInfo(ProductInfo productinfo) throws SQLException, ClassNotFoundException {

        String selectquery = "";
        String updatequery = "";
        if (productinfo.getPiid() == -1) {
            selectquery = "select * from ProductInfo where PName='" + productinfo.getProductname() + "'";
            updatequery = "update Productinfo set Buying=?,Selling=? where PName=?";
        } else {
            selectquery = "select * from ProductInfo where PinfoID='" + productinfo.getPiid() + "'";
            updatequery = "update Productinfo set PName=?,Buying=?,Selling=? where PinfoID=?";
        }

        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(selectquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        if (count == 0) {
            String insertquery = "insert into ProductInfo values(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(insertquery);

            stm.setObject(1, productinfo.getPiid());
            stm.setObject(2, productinfo.getProductname());
            stm.setObject(3, productinfo.getBuyingprice());
            stm.setObject(4, productinfo.getSellingprice());

            if (stm.executeUpdate() > 0) {
                return true;
            }
        } else {

            PreparedStatement stm = con.prepareStatement(updatequery);
            if (productinfo.getPiid() == -1) {
                stm.setObject(3, productinfo.getProductname());
                stm.setObject(1, productinfo.getBuyingprice());
                stm.setObject(2, productinfo.getSellingprice());
            } else {
                stm.setObject(4, productinfo.getPiid());
                stm.setObject(1, productinfo.getProductname());
                stm.setObject(2, productinfo.getBuyingprice());
                stm.setObject(3, productinfo.getSellingprice());
            }

            if (stm.executeUpdate() > 0) {
                System.out.println("updated");
                return true;
            }
        }
        return false;
    }

    public static ProductInfo[] viewProducts() throws SQLException, ClassNotFoundException {

        String selectquery = "select * from productinfo order by PinfoID DESC";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(selectquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        ProductInfo[] list = new ProductInfo[count];
        ProductInfo pi = null;
        rst.beforeFirst();
        for (int i = 0; rst.next(); i++) {
            pi = new ProductInfo();
            pi.setPiid(rst.getInt("PinfoID"));
            pi.setProductname(rst.getString("PName"));
            pi.setBuyingprice(rst.getDouble("Buying"));
            pi.setSellingprice(rst.getDouble("Selling"));
            list[i] = pi;
        }
        return list;

    }

    public static boolean deleteProductInfo(int id) throws SQLException, ClassNotFoundException {
        String deletequery = "delete from Productinfo where PinfoID='" + id + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(deletequery);
        if (stm.executeUpdate() > 0) {
            return true;
        }
        return false;
    }

    //New Codes
    public static Products getProductDetailsByName(String name) throws SQLException, ClassNotFoundException {
        String searchsql = "select ProID,Buying,Selling,Qty from product where ProductName=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(searchsql);
        stm.setObject(1, name);
        ResultSet rst = stm.executeQuery();
        Products products = new Products();
        if (rst.next()) {
            products.setPid(rst.getInt(1));
            products.setBuying(rst.getDouble(2));
            products.setSelling(rst.getDouble(3));
            products.setQty(rst.getInt(4));
        }
        return products;
    }

    public static Products getProductIdViaOrderDetailId(String id) throws SQLException, ClassNotFoundException {
        String searchsql = "select p.ProID from product p,orderdetail od where od.ProID=p.ProID && OrdID=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(searchsql);
        stm.setObject(1, id);
        ResultSet rst = stm.executeQuery();
        Products products = new Products();
        if (rst.next()) {
            products.setPid(rst.getInt(1));
        }
        return products;
    }
}
