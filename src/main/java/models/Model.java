package models;

import db.ConnectionToDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by admin on 19.02.2017.
 */
public class Model {
    public static Connection getConnection(){
        Connection query =  ConnectionToDB.getInstance();
        return query;
    }
    public static ResultSet getResultSet(String sql) throws SQLException {
        return getConnection().createStatement().executeQuery(sql);
    }

    public static Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }
}
