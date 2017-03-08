package com.cyberha4.db;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 16.02.2017.
 */
@Deprecated
public class ConnectionToDB {
    private static final String url = "jdbc:mysql://localhost:3306/todoList";
    private static final String user = "root";
    private static final String password = "";

    private static Logger logger = Logger.getLogger(ConnectionToDB.class);

    private static Connection instance;

    private ConnectionToDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            instance = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("some problem with connection or driver", e);
        }
    }

    public static Connection getInstance(){
        if(instance == null){
            new ConnectionToDB();
        }
        return instance;
    }
}
