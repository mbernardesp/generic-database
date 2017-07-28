package com.leucotron.database.model.dao.impl;

import com.leucotron.database.JDatabaseConnector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

public abstract class AGenericDao<T> {

    public AGenericDao() {

    }

    protected long executeUpdate(String sql) {

        long result = -1;

        Connection connection = null;
        Statement statement = null;

        try {
            connection = JDatabaseConnector.getInstance().getConnection();
            statement = connection.createStatement();

            if (statement != null) {
                result = statement.executeUpdate(sql);
            }
        } catch (SQLException ex) {
            org.apache.log4j.Logger.getLogger(AGenericDao.class.getName()).error(ex.getMessage());
            result = -1;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    org.apache.log4j.Logger.getLogger(AGenericDao.class.getName()).error(ex.getMessage());
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    org.apache.log4j.Logger.getLogger(AGenericDao.class.getName()).error(ex.getMessage());
                }
            }
        }

        return result;
    }

    protected List<T> query(String sql, Class resultClass) {

        List<T> outputList = null;

        ResultSet resultSet = null;

        Connection connection = null;
        Statement statement = null;

        try {
            connection = JDatabaseConnector.getInstance().getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);

            if (resultSet != null) {

                if (resultClass.isAnnotationPresent(Entity.class)) {

                    ResultSetMetaData rsmd = resultSet.getMetaData();

                    Field[] fields = resultClass.getDeclaredFields();

                    System.out.println(Arrays.toString(fields));

                    try {

                        while (resultSet.next()) {
                            
                            T bean = (T) resultClass.newInstance();

                            for (int _iterator = 0; _iterator < rsmd.getColumnCount(); _iterator++) {

                                String columnName = rsmd.getColumnName(_iterator + 1);

                                Object columnValue = resultSet.getObject(_iterator + 1);

                                for (Field field : fields) {

                                    if (field.isAnnotationPresent(Column.class)) {

                                        Column column = field.getAnnotation(Column.class);

                                        if (column.name().equalsIgnoreCase(columnName) && columnValue != null) {
                                            
                                            
                                            
                                            BeanUtils.setProperty(bean, field.getName(), columnValue);
                                            break;
                                        }
                                    }
                                }
                            }

                            if (outputList == null) {
                                outputList = new ArrayList<T>();
                            }
                            
                            outputList.add(bean);

                            
                        }

                    } catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
                        Logger.getLogger(JDatabaseConnector.class.getName()).error(ex.getMessage());
                    }

                }

//                try {
//                    resultSet.first();
//                    System.out.println(resultSet.getString("name"));
//                    resultSet.close();                      
//
//                } catch (SQLException ex) {
//                    Logger.getLogger(JDatabaseConnector.class.getName()).error(ex.getMessage());
//                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(AGenericDao.class.getName()).error(ex.getMessage());
            resultSet = null;
        } finally {

            //@marcelo
            //Fechar o resultset aqui
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AGenericDao.class.getName()).error(ex.getMessage());
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AGenericDao.class.getName()).error(ex.getMessage());
                }
            }

        }

        return outputList;
    }
}
