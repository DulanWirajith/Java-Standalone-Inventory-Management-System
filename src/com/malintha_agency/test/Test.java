///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.malintha_agency.test;
//
//import com.malintha_agency.controller.InvoiceChequeController;
//import com.malintha_agency.controller.InvoiceController;
//import com.malintha_agency.controller.OrderController;
//import com.malintha_agency.controller.OrderDetailController;
//import com.malintha_agency.controller.OrderPaymentController;
//import com.malintha_agency.controller.ProductController;
//import com.malintha_agency.controller.RouteController;
//import com.malintha_agency.controller.ShopController;
//import com.malintha_agency.controller.SupplierController;
//import com.malintha_agency.encryption.Encryptor;
//import com.malintha_agency.model.Invoice;
//import com.malintha_agency.model.Invoice_Cheque;
//import com.malintha_agency.model.Invoice_Product;
//import com.malintha_agency.model.Order;
//import com.malintha_agency.model.Order_Detail;
//import com.malintha_agency.model.Payment;
//import com.malintha_agency.model.Route;
//import com.malintha_agency.model.Shop;
//import com.malintha_agency.model.Supplier;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Dell
// */
//public class Test {
//
//    public static void main(String[] args) {
//
//        /*Shop information Management Section*/
//        //saveShop();
//        //updateShop();
//        // removeShop();
//        //viewAllShops();
//        // findShopsbyroute();
//        //findShopByName();
//
//        /*Supplier Management Section*/
//        //saveSupplier();
//        //updateSupplier();
//        //removeSupplier();
//        //viewSuppliers();
//        //viewByName();
//
//        /*Invoice Management Section*/
//        //saveInvoice();
//        //updateInvoice();
//        //findInvoicebyinvoiceno();
//        //removeInvoice();
//        //viewAllInformationForInvoice();
//        //viewAllInvoiceOrderBy();
//        //viewAllInvoices();
//
//        /*Invoice Cheque Management Section*/
//        //saveInvoiceCheque(); error
//        //removeinvoiceCheque();
//        //updateinvoicecheque();
//        //findInfoAccordingToChequeNo();
//        //viewAllChequesOrderBy();
//
//        /*Invoice Product Management Section*/
//        //addInvoiceProducts();
//        // removeInvoiceProducts();
//        //getallInvoiceProducts();
//        /*Save Order and order details*/
//        // saveOrderForShop();
//        //removeOrder();
//        //viewOrders();
//        //saveOrderForShop();
//        //addPaymentforOrder();
//        //viewAllOrderInformation();
//        encryptionTesting();
//
////                try {
////                   Route route = new Route(2, "alpitiya rd", "Alpitiya");
////        /*1)*/           String msg=new RouteController().saveRoute(route);
////        //            Route[] routes = new RouteController().viewAllRoutes();
////        //            for (Route r : routes) {
////        //                System.out.println(r.getRoutename());
////        //            }
////        //            String msg = new RouteController().saveRoute(route);
////        //           System.out.println(msg);
////        //             String msg = new DiliveryController().modifyRoute(route);
////        //            String msg = new DiliveryController().removeRoute(1);
////        //            Route  msg = new DiliveryController().findRoute(2);
////        //            System.out.println(msg);
////        //            if(msg!=null){
////        //             System.out.println(msg.getRoutename());
////        //            }else{
////        //             System.out.println("route not found");
////        //            }
////                } catch (SQLException ex) {
////                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
////                } catch (ClassNotFoundException ex) {
////                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
////                }
//    }
//
//    private static void saveShop() {
//        try {
//            Route route = new RouteController().findRoute(2);
//            System.out.println(route.getRoutename());
//
//            Shop shop = new Shop(route.getRouteid(), "Sameera Shop", "Sameera", "sameera@gmail.com", 945674365);
//            String msg = new ShopController().saveShop(shop);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void updateShop() {
//        try {
//            Route route = new RouteController().findRoute(2);
//            System.out.println(route.getRouteid());
//            Shop shop = new Shop(7, route.getRouteid(), "Nipun Shop", "Nipun", "nipun@gmail.com", 912256120);
//            String msg = new ShopController().modifyShop(shop);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void removeShop() {
//        try {
//            String msg = new ShopController().removeShop(7);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void viewAllShops() {
//        try {
//            Shop[] shops = new ShopController().viewShops();
//            for (Shop s : shops) {
//                System.out.println(s.getShopname() + " ! " + s.getRoute().getRoutename());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void findShopsbyroute() {
//        try {
//            Shop[] shops = new ShopController().findShopByRoute(2);
//            for (Shop s : shops) {
//                System.out.println(s.getShopname());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void saveSupplier() {
//        try {
//            Supplier supplier = new Supplier("Chello", "Colombo", "Chello@gmail.com", 913933945);
//            String msg = new SupplierController().saveSupplier(supplier);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void updateSupplier() {
//        try {
//            Supplier supplier = new Supplier(2, "Chello", "Galle", "Chello@gmail.com", 913933945);
//            String msg = new SupplierController().modifySupplier(supplier);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void removeSupplier() {
//        try {
//            String msg = new SupplierController().removeSupplier(2);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void viewSuppliers() {
//        try {
//            Supplier[] suppliers = new SupplierController().viewSuppliers();
//            for (Supplier s : suppliers) {
//                System.out.println(s.getSuppliername());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void viewByName() {
//        try {
//            Supplier supplier = new SupplierController().searchSupplierBYName("Chello");
//            System.out.println(supplier.getAddress() + " ! " + supplier.getSupplierid());
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private static void saveInvoice() {
//        try {
//            Supplier supplier = new SupplierController().searchSupplierBYName("Chello");
//            Invoice invoice = new Invoice(supplier.getSupplierid(), "1024537", "GK-9201", 204476.80, 0, 204476.80, "2018-05-25", "2018-06-18");
//            String msg = new InvoiceController().saveInvoice(invoice);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void updateInvoice() {
//        try {
//            Supplier supplier = new SupplierController().searchSupplierBYName("Chello");
//            Invoice invoice = new Invoice(supplier.getSupplierid(), "1024537", "253-9768", 204476.80, 0, 204476.80, "2018-05-25", "2018-06-18");
//            String msg = new InvoiceController().modifyInvoice(invoice);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void findInvoicebyinvoiceno() {
//        try {
//            Invoice invoice = new InvoiceController().findInvoiceByInvoiceNO("1024537");
//            System.out.println(invoice.getLorryno() + " ! " + invoice.getSubtotal());
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private static void saveInvoiceCheque() {
//        try {
//            Invoice invoice = new InvoiceController().findInvoiceByInvoiceNO("1024537");
//            Invoice_Cheque invoicecheque = new Invoice_Cheque(invoice.getInvoiceid(), "265350", "2018-06-17", "2018-06-21", 513647.24);
//            String msg = new InvoiceChequeController().saveInvoiceCheque(invoicecheque);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void addInvoiceProducts() {
//        try {
//            Invoice invoice = new InvoiceController().findInvoiceByInvoiceNO("1024537");
//            Invoice_Product product = new Invoice_Product(invoice.getInvoiceid(), "Snacks", 100.0, 200.50, 50);
//            String msg = new ProductController().saveProduct(product);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void removeInvoiceProducts() {
//        try {
//            Invoice invoice = new InvoiceController().findInvoiceByInvoiceNO("1024537");
//            String o = new ProductController().removeProduct(invoice.getInvoiceid(), "Cream Crackers");
//
//            System.out.println(o);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void removeinvoiceCheque() {
//        try {
//            String msg = new InvoiceChequeController().removeInvoiceCheque("265352");
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void updateinvoicecheque() {
//        try {
//            Invoice invoice = new InvoiceController().findInvoiceByInvoiceNO("1024537");
//            Invoice_Cheque invoicecheque = new Invoice_Cheque(invoice.getInvoiceid(), "265352", "2018-06-19", "2018-06-23", 513647.24);
//            String msg = new InvoiceChequeController().modifyInvoiceCheque(invoicecheque);
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void removeInvoice() {
//        try {
//            Invoice invoice = new InvoiceController().findInvoiceByInvoiceNO("1024537");
//            String msg = new InvoiceController().removeInvoice(invoice.getInvoiceno());
//            System.out.println(msg);
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void findInfoAccordingToChequeNo() {
//        try {
//            Invoice_Cheque[] cheques = new InvoiceChequeController().findChequeInfoByChequeNo("265352");
//            if (cheques.length > 0) {
//                System.out.println(cheques[0].getInvoice().getInvoiceno());
//            } else {
//                System.out.println("No information found for that cheque no");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void viewAllInformationForInvoice() {
//        try {
//            Invoice[] list = new InvoiceController().viewAllInvoices();
//            for (Invoice i : list) {
//                for (Invoice_Cheque ic : i.getCheques()) {
//                    for (Invoice_Product ip : i.getProducts()) {
//                        System.out.println(i.getInvoiceno() + " | " + ic.getChequeno() + " | " + ip.getProductname());
//                    }
//                }
//                System.out.println("=================================================================");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private static void viewAllChequesOrderBy() {
//        try {
//            Invoice_Cheque[] cheques = new InvoiceChequeController().viewAllChequesOrderBy("recently");
//            for (Invoice_Cheque i : cheques) {
//                System.out.println(i.getInvoice_chequeid());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void viewAllInvoiceOrderBy() {
//        try {
//            Invoice[] list = new InvoiceController().viewAllInvoiceOrderBy("IssueDate");
//            for (Invoice i : list) {
//                for (Invoice_Cheque ic : i.getCheques()) {
//                    for (Invoice_Product ip : i.getProducts()) {
//                        System.out.println(i.getInvoiceno() + " | " + ic.getChequeno() + " | " + ip.getProductname());
//                    }
//                }
//                System.out.println("=================================================================");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void findShopByName() {
//        try {
//            Shop shop = new ShopController().findShopByName("Sameera Shop");
//            System.out.println(shop.getShopid());
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    //view All products according to invoice receive date
//    private static void getallInvoiceProducts() {
//        try {
//            Invoice_Product[] products = new ProductController().viewAllProduct("2018-06-18");
//            for (Invoice_Product i : products) {
//                System.out.println(i.getProductname() + " ! " + i.getQty() + " ! " + i.getSellingprice());
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private static void saveOrderForShop() {
//        try {
//            Shop shop = new ShopController().findShopByName("Sameera Shop");
//            Invoice_Product[] product = new ProductController().viewAllProduct("2018-06-18");
//            int proid = 0;
//            for (Invoice_Product p : product) {
//                if (p.getProductname().equals("Snacks")) {
//                    proid = p.getInvoice_productid();
//                }
//            }
//
//            Order order = new Order(shop.getShopid(), "2018-06-20", 0, 0, 0, 0, 0);
//            String msg = new OrderController().saveOrder(order);
//            if (!msg.equals("f")) {
//                int oid = Integer.parseInt(msg);
//                System.out.println(oid);
//                Order_Detail orderdetail = new Order_Detail(oid, proid, false, 10, 0, 150);
//                String msg1 = new OrderDetailController().saveOrderInformation(orderdetail);
//                System.out.println(msg1);
//            }
//
//            // Order_Detail orderdetail = new Order_Detail(order.getOrderid(), proid, false, 10, 0, 150);
//            // String ordersaved=new OrderController().saveOrder();
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void removeOrder() {
//        try {
//            Shop shop = new ShopController().findShopByName("Sameera Shop");
//            Order order = new Order(shop.getShopid(), "2018-06-20", 0, 0);
//            String msg = new OrderController().saveOrder(order);
//            if (!msg.equals("f")) {
//                int oid = Integer.parseInt(msg);
//                System.out.println(oid);
//                String out = new OrderController().removeOrder(oid);
//                System.err.println(out);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void viewOrders() {
//
//    }
//
//    private static void addPaymentforOrder() {
//        try {
//            Shop shop = new ShopController().findShopByName("Sameera Shop");
//            Order order = new Order(shop.getShopid(), "2018-06-20", 0, 0);
//            String msg = new OrderController().saveOrder(order);
//            if (!msg.equals("f")) {
//                int oid = Integer.parseInt(msg);
//                Payment payment = new Payment(oid, "2018-06-24", 100);
//                String msg1 = new OrderPaymentController().savePayment(payment);
//                System.out.println(msg1);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void viewAllInvoices() {
//        try {
//            Invoice[] invoices = new InvoiceController().viewAllInvoices();
//            for (Invoice i : invoices) {
//                System.out.println(i.getReceivedate());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    private static void encryptionTesting() {
//        String key = "Bar12345Bar12345"; // 128 bit key
//        String initVector = "RandomInitVector"; // 16 bytes IV
//
//        String encryptedpass = new Encryptor().encrypt(key, initVector, "Hello@123");
//        System.out.println("Encrypted Password " + encryptedpass);
//
//        String decryptpass = new Encryptor().decrypt(key, initVector, encryptedpass);
//        System.out.println("Decripted Password " + decryptpass);
//
//    }
//
//}
