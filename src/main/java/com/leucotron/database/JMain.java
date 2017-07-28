/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leucotron.database;

import com.leucotron.database.model.dao.entity.JUser;
import com.leucotron.database.model.dao.impl.JUserDao;
import java.util.List;

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

        JUser user = new JUser();
        user.setId(64798l);

        List<JUser> listUser = userDao.readAll(new JUser());

        for (JUser jUser : listUser) {

            System.out.println(jUser.getId());
            System.out.println(jUser.getName());

        }

//        for (int i = 0; i < 100000; i++) {
//            userDao.create(new JUser());
//            
//            
//            
//        }
    }

}
