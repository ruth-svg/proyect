/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gf.app.covid.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ruth
 */
public class ConexionBD {
    
    private static Connection conn;
    private static final String MYSQL_DB_URL="jdbc:mysql://localhost:3306/covid";
    private static final String MYSQL_USER="root";
    private static final String MYSQL_PASSWORD="";
    
    public static Connection getConnection() throws SQLException{
        
        conn=DriverManager.getConnection(MYSQL_DB_URL, MYSQL_USER, MYSQL_PASSWORD);
        return conn; 
    }
    
    
}
