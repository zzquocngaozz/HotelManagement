package com.js1603.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBContext {
    protected Connection connection = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;
    private Properties properties = new Properties();

    public DBContext() {
        try {
            properties.load(DBContext.class.getResourceAsStream("/dbConfig.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String username = properties.getProperty("userName");
            String password = properties.getProperty("password");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Success");
            } else {
                System.out.println("Fail");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DBContext();
    }
}
