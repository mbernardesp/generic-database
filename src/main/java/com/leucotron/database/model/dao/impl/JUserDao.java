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
    public void create(JUser user) {

        String sql = "INSERT INTO tb_user(name) VALUES ('Marcelo')";
        executeUpdate(sql);
    }

    @Override
    public JUser read(JUser user) {

        return null;
    }

    @Override
    public List<JUser> readAll(JUser user) {
        
        String sql = "SELECT * FROM tb_user";
        return query(sql, JUser.class);

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
