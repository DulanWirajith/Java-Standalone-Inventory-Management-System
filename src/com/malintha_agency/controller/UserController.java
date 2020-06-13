/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malintha_agency.controller;

import com.malintha_agency.connection.DbConnection;
import com.malintha_agency.encryption.Encryptor;
import com.malintha_agency.model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class UserController {
    
    private static String key = "Bar12345Bar12345"; // 128 bit key
    private static String initVector = "RandomInitVector"; // 16 bytes IV

    public static boolean saveNewUser(Users user) throws SQLException, ClassNotFoundException {
        
        String encryptedpass = new Encryptor().encrypt(key, initVector, user.getPassword());
        Users[] users = loginUser(user.getUsername(), user.getPassword());
        if (users == null) {
            String insertquery = "insert into Users values(?,?,?,?)";
            Connection con = DbConnection.getDBConnection().getConnection();
            PreparedStatement stm = con.prepareStatement(insertquery);
            stm.setObject(1, user.getUid());
            stm.setObject(2, user.getUsername());
            stm.setObject(3, encryptedpass);
            stm.setObject(4, user.getRole());
            
            if (stm.executeUpdate() > 0) {
                System.out.println("User Saved");
                return true;
            }
        }
        return false;
    }
//INSERT INTO table_name
//VALUES (value1, value2, value3, ...);

    public static boolean modifyUser(Users user) throws SQLException, ClassNotFoundException {
        
        String encryptedpass = new Encryptor().encrypt(key, initVector, user.getPassword());
        
        String updatequery = "update Users set Uname=?,UPassword=?,URole=? where UID=?";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(updatequery);
        stm.setObject(4, user.getUid());
        stm.setObject(1, user.getUsername());
        stm.setObject(2, encryptedpass);
        stm.setObject(3, user.getRole());
        if (stm.executeUpdate() > 0) {
            return true;
            
        }
        return false;
    }
    
    public static Users[] loginUser(String un, String pass) throws SQLException, ClassNotFoundException {
        
        String encryptedpass = new Encryptor().encrypt(key, initVector, pass);
        
        String selectquery = "Select * from Users where Uname='" + un + "' AND UPassword='" + encryptedpass + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(selectquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Users[] users = new Users[count];
        Users user;
        rst.beforeFirst();
        if (count > 0) {
            for (int i = 0; rst.next(); i++) {
                user = new Users();
                user.setUid(rst.getInt("UID"));
                user.setUsername(rst.getString("UName"));
                user.setPassword(rst.getString("UPassword"));
                user.setRole(rst.getString("URole"));
                users[i] = user;
            }
            return users;
        }
        
        return null;
    }
    
    public static Users[] getAllUsers() throws SQLException, ClassNotFoundException {
        
        String selectquery = "select * from Users order by UID DESC";
        Connection con = DbConnection.getDBConnection().getConnection();
        Statement pstm = con.createStatement();
        ResultSet rst = pstm.executeQuery(selectquery);
        int count = 0;
        while (rst.next()) {
            count++;
        }
        Users[] users = new Users[count];
        Users user;
        rst.beforeFirst();
        if (count > 0) {
            for (int i = 0; rst.next(); i++) {
                user = new Users();
                user.setUid(rst.getInt("UID"));
                user.setUsername(rst.getString("UName"));
                user.setPassword(new Encryptor().decrypt(key, initVector, rst.getString("UPassword")));
                user.setRole(rst.getString("URole"));
                users[i] = user;
            }
            return users;
        }
        
        return null;
    }
    
    public static boolean removeUser(int uid) throws SQLException, ClassNotFoundException {
        
        String deletequery = "Delete from Users where UID='" + uid + "'";
        Connection con = DbConnection.getDBConnection().getConnection();
        PreparedStatement stm = con.prepareStatement(deletequery);
        if (stm.executeUpdate() > 0) {
            return true;
        }
        return false;
    }
    
}
