package com.leucotron.database.model.dao.impl;

import com.leucotron.database.JDatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AGenericDao {

    private Connection connection = null;

    public AGenericDao() {

        connection = JDatabaseConnector.getInstance().getConnection();
    }

    protected Statement getStatement() {

        Statement statement = null;

        try {
            //        return connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AGenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return statement;
    }

}
