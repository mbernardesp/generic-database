/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leucotron.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author marcelo
 */
public class JDatabaseConnector {

    private static JDatabaseConnector instance = null;
    private BasicDataSource ds = null;

    public static JDatabaseConnector getInstance() {
        if (instance == null) {
            instance = new JDatabaseConnector();
        }
        return instance;
    }

    public long open() {

        long result = -1;

        ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://127.0.0.1:5432/leucotron");
        ds.setUsername("postgres");
        ds.setPassword("master");

        Connection connection = getConnection();
        
        if (connection != null) {
            
            result = 1;
            
            try {
                connection.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(JDatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            result = -1;
        }

        return result;
    }

    public long close() {

        long result = -1;

        try {
            ds.close();
            result = 1;
        } catch (SQLException ex) {
            Logger.getLogger(JDatabaseConnector.class.getName()).error(ex.getMessage());
        }
        return result;
    }

    public Connection getConnection() {

        Connection connection = null;
        
        try {
            connection = ds.getConnection();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(JDatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }

}
