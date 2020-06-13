/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.model.CreditReport;
import com.malintha_agency.model.DamageReports;
import com.malintha_agency.model.SaleReport;
import com.malintha_agency.model.SupplierReport;
import com.malintha_agency.model.ProfitAndLostReport;
import com.malintha_agency.views.SalesReport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class ReportController {

    public static double totalsuppayment = 0;
    public static double diliverypayment = 0;
    public static double totaldamageamount = 0;
    public static double totaldiscountamount = 0;

    public static void totalPaymentForSupplier(String fdate, String sdate) throws SQLException, ClassNotFoundException {
        String selectquery = "select sum(NetAmount) AS Total from invoice where ReceiveDate BETWEEN '" + fdate + "' AND '" + sdate + "' ";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(selectquery);
        rst.beforeFirst();
        int count = 0;
        while (rst.next()) {
            count++;
        }
        //Invoice[] list = new Invoice[count];
        rst.beforeFirst();
        if (count > 0) {
            for (int i = 0; rst.next(); i++) {
                totalsuppayment = rst.getDouble("Total");
                System.out.println(totalsuppayment);
            }

        }
    }

    public static SupplierReport[] getSupplierReport(String supplier, String from, String to) throws SQLException, ClassNotFoundException {

        String selectquery = "Select Invoice.InvoiceNo AS InvoiceNo, Invoice.SubTotal AS SubTotal, Invoice.Discount AS Discount ,Invoice.NetAmount AS NetAmount From Supplier JOIN Invoice ON Invoice.SupID=Supplier.SupID where  Supplier.Name='" + supplier + "'AND Invoice.ReceiveDate Between '" + from + "' AND '" + to + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(selectquery);
        rst.beforeFirst();
        int count = 0;
        while (rst.next()) {
            count++;
        }

        SupplierReport[] supplierreports = new SupplierReport[count];
        SupplierReport supplierreport;
        rst.beforeFirst();
        if (count > 0) {
            for (int i = 0; rst.next(); i++) {
                supplierreport = new SupplierReport();
                supplierreport.setInvoiceno(rst.getString("InvoiceNo"));
                supplierreport.setSubtotal(rst.getDouble("SubTotal"));
                supplierreport.setNetamount(rst.getDouble("Discount"));
                supplierreport.setNetamount(rst.getDouble("NetAmount"));
                supplierreports[i] = supplierreport;
            }
            return supplierreports;

        }
        return null;
    }

    public static SaleReport[] getSalesReport(String supplier, String from, String to) throws SQLException, ClassNotFoundException {
        String selectquery = "select s.shopName AS ShopName,o.IssueDate AS IssueDate,sum(od.payment) AS TotalAmount From shop s JOIN Orders o ON s.SID=o.SID JOIN orderdetail od ON o.OID=od.OID JOIN product p ON od.ProID=p.ProID JOIN Invoice i ON p.InvID=i.InvID JOIN Supplier sp ON i.SupID=sp.SupID WHERE sp.Name='" + supplier + "' AND o.IssueDate BETWEEN '" + from + "' AND '" + to + "'group by s.shopName";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(selectquery);
        rst.beforeFirst();
        int count = 0;
        while (rst.next()) {
            count++;
        }

        SaleReport[] salereports = new SaleReport[count];
        SaleReport salereport;
        rst.beforeFirst();
        if (count > 0) {
            for (int i = 0; rst.next(); i++) {
                salereport = new SaleReport();
                salereport.setShopname(rst.getString("ShopName"));
                salereport.setIssuedate(rst.getString("IssueDate"));
                salereport.setTotalamount(rst.getDouble("TotalAmount"));
                salereports[i] = salereport;
            }
            return salereports;

        }
        return null;
    }

    public static DamageReports[] getDamageReport(String supplier, String from, String to) throws SQLException, ClassNotFoundException {
        String selectquery = "select s.shopName AS ShopName, o.IssueDate AS IssueDate,sum(orp.Qty) AS ReturnQTY,sum(orp.Qty*p.selling) AS TotalPrice From shop s join orders o on s.SID=o.SID join orderdetail od on o.OID=od.OID join Orders_Return_Product orp on o.OID=orp.OID join Product p on od.ProID=p.ProID join invoice i on p.InvID=i.InvID join supplier sp on i.SupID=sp.SupID where sp.Name='" + supplier + "' AND o.IssueDate between '" + from + "' AND '" + to + "'group by s.shopName";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(selectquery);
        rst.beforeFirst();
        int count = 0;
        while (rst.next()) {
            count++;
        }

        DamageReports[] damagereports = new DamageReports[count];
        DamageReports damagereport;
        rst.beforeFirst();
        if (count > 0) {
            for (int i = 0; rst.next(); i++) {
                damagereport = new DamageReports();
                damagereport.setShopname(rst.getString("ShopName"));
                damagereport.setIssuedate(rst.getString("IssueDate"));
                damagereport.setReturnqty(rst.getInt("ReturnQTY"));
                damagereport.setTotalprice(rst.getDouble("TotalPrice"));
                damagereports[i] = damagereport;
            }
            return damagereports;

        }
        return null;
    }

    public static ProfitAndLostReport getProfitAndLostReport(String supplier, String from, String to) throws SQLException, ClassNotFoundException {

        totalsuppayment = 0;
        diliverypayment = 0;
        totaldamageamount = 0;
        totaldiscountamount = 0;

        SupplierReport[] sr = getSupplierReport(supplier, from, to);
        if (sr != null) {
            for (SupplierReport s : sr) {
                totalsuppayment += s.getNetamount();
            }
        }
        SaleReport[] salereport = getSalesReport(supplier, from, to);
        if (salereport != null) {
            for (SaleReport sale : salereport) {
                diliverypayment += sale.getTotalamount();
            }
        }
        DamageReports[] dr = getDamageReport(supplier, from, to);
        if (dr != null) {
            for (DamageReports dmgr : dr) {
                totaldamageamount += dmgr.getTotalprice();
            }
        }
        CreditReport[] cr = getCreditReport(supplier, from, to);
        if (cr != null) {
            for (CreditReport c : cr) {
                totaldiscountamount += c.getDiscount();
            }
        }
        ProfitAndLostReport par = new ProfitAndLostReport();
        par.setTotalsupplierpayment(totalsuppayment);
        par.setTotaldiliverypayment(diliverypayment);
        par.setTotaldamagepayment(totaldamageamount);
        par.setTotaldiscountpayment(totaldiscountamount);

        return par;

    }

    public static CreditReport[] getCreditReport(String supplier, String from, String to) throws SQLException, ClassNotFoundException {

        String selectquery = "select s.shopName AS ShopName, o.IssueDate AS IssueDate,sum(od.Discount) AS TotalDiscount,sum(od.Payment) AS TotalPayment From shop s join orders o on s.SID=o.SID join orderdetail od on o.OID=od.OID join Orders_Return_Product orp on o.OID=orp.OID join Product p on od.ProID=p.ProID join invoice i on p.InvID=i.InvID join supplier sp on i.SupID=sp.SupID where sp.Name='" + supplier + "' AND o.IssueDate between '" + from + "' AND '" + to + "' group by s.shopName";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(selectquery);
        rst.beforeFirst();
        int count = 0;
        while (rst.next()) {
            count++;
        }

        CreditReport[] creditreports = new CreditReport[count];
        CreditReport creditreport;
        rst.beforeFirst();
        if (count > 0) {
            for (int i = 0; rst.next(); i++) {
                creditreport = new CreditReport();
                creditreport.setShopname(rst.getString("ShopName"));
                creditreport.setIssuedate(rst.getString("IssueDate"));
                creditreport.setDiscount(rst.getDouble("TotalDiscount"));
                creditreport.setTotalpayment(rst.getDouble("TotalPayment"));
                creditreports[i] = creditreport;
            }
            return creditreports;

        }
        return null;

    }
}
