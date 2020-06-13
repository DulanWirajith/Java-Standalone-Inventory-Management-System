/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.connection;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class DbConnection {

    private static DbConnection dbconnection;
    private Connection con;

    private DbConnection() throws SQLException, ClassNotFoundException {
        try {
            Properties properties = new Properties();
            File file = new File("settings/ConnectionProp.properties");
            FileReader inputStream = new FileReader(file.getAbsolutePath());
            properties.load(inputStream);
            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost/malinthadb", "root", "mysql");
            con = DriverManager.getConnection("jdbc:mysql://" + properties.getProperty("url") + "/" + properties.getProperty("db") + "", "" + properties.getProperty("username") + "", "" + properties.getProperty("password") + "");
        } catch (IOException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DbConnection getDBConnection() throws SQLException, ClassNotFoundException {
        if (dbconnection == null) {
            dbconnection = new DbConnection();
        }
        return dbconnection;
    }

    public Connection getConnection() {
        return con;
    }
}
