package com.patrader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionMySQL {

    static private ConexionMySQL instance;
    private String qry;
    private String url = "jdbc:mysql://10.33.90.66:3307/";
    private String dbName = "patrader";
    private String userName = "patrader";
    private String password = "clvinin";
    private Connection connection = null;

    public static ConexionMySQL getInstance() {
        if (instance == null)
            instance = new ConexionMySQL();
        return instance;
    }

    private ConexionMySQL() {

    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url + dbName, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setQry(String qry) {
        this.qry = qry;
    }

    public ResultSet getSelect() throws Exception {
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url + dbName, userName, password);
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(qry);
            return result;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void ejecutarUpdate(String qry) throws Exception {
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url + dbName, userName, password);
            stmt = connection.createStatement();
            stmt.executeUpdate(qry);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
