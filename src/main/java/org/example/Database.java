package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database instance;
    private Connection connection;
    private static final String DB_URL = "jdbc:h2:file:D:\\2023-2024\\DB\\test";
    private static final String DB_USER = "maria";
    private static final String DB_PASSWORD = "1234";
    private Database() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    public static Database getInstance() throws SQLException {
        if (instance == null) {
            if (instance == null) {
                instance = new Database();
            }
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
}
