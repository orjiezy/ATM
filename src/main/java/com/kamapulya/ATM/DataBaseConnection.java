package com.kamapulya.ATM;

import java.sql.*;

class DataBaseConnection {
    private Connection connection;

    DataBaseConnection() {
        try{
            String HOST = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false";
            String USERNAME = "root";
            String PASSWORD = "root";
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    Connection getConnection() {
        return connection;
    }
}


