package com.kamapulya.ATM;

import java.sql.*;

public class DataBaseConnection {
    private final String HOST = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public DataBaseConnection() {
        try{
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}


