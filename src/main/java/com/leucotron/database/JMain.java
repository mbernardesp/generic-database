/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leucotron.database;

import com.leucotron.database.model.dao.entity.JUser;
import com.leucotron.database.model.dao.impl.JUserDao;

/**
 *
 * @author marcelo
 */
public class JMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        long result = JDatabaseConnector.getInstance().open();
        
        JUserDao userDao = new JUserDao();
        
        for (int i = 0; i < 100000; i++) {
            userDao.create(new JUser());            
        }
        
        
        
    }
    
}
