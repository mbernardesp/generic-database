/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leucotron.database.model.dao.impl;

import com.leucotron.database.model.dao.IGenericDao;
import com.leucotron.database.model.dao.entity.JUser;
import java.util.List;

/**
 *
 * @author marcelo
 */
public class JUserDao extends AGenericDao<JUser> implements IGenericDao<JUser> {

    @Override
    public void create(JUser object) {

        String sql = "INSERT INTO tb_user(name) VALUES ('Marcelo')";
        executeUpdate(sql);
    }

    @Override
    public JUser read(JUser object) {

        String sql = "SELECT * FROM tb_user WHERE id = 64862";
        List<JUser> listUser = query(sql, JUser.class);


        for (JUser jUser : listUser) {
            
            System.out.println(jUser.getId());
            System.out.println(jUser.getName());
            
        }
        
 


        
        return null;
    }

    @Override
    public List<JUser> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JUser update(JUser object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(JUser object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
