package com.enigma.rmsederhanaapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    public static Connection connect() {
        try {
            String port = System.getenv("DB_PORT");
            String dbName = System.getenv("DB_NAME");
            String user = System.getenv("DB_USERNAME");
            String password = System.getenv("DB_PASSWORD");
            String url = String.format("jdbc:postgresql://localhost:%s/%s", port, dbName);
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("error while connecting database: " + e);
        }
    }
}
