/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leucotron.database.model.dao.impl;

import com.leucotron.database.model.dao.IGenericDao;
import com.leucotron.database.model.dao.entity.JUser;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcelo
 */
public class JUserDao extends AGenericDao implements IGenericDao<JUser>{

    @Override
    public void create(JUser object) {
        
        String sql = "INSERT INTO tb_user(name) VALUES ('Marcelo')";
        
        try {
            getStatement().execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(JUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public JUser read(JUser object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
