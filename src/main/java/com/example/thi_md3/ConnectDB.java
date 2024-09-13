package com.example.thi_md3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private Connection connection;
    private static final String URl = "jdbc:mysql://localhost:3303/thi";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";

    public ConnectDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(URl, USERNAME, PASSWORD);
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        return connection;
    }

}
