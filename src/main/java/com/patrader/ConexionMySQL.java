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
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection connect() {
        try {
            if (connection == null || connection.isClosed())
                connection = DriverManager.getConnection(url + dbName, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setQry(String qry) {
        this.qry = qry;
    }

    public ResultSet getSelect() throws SQLException {
        Statement stmt = null;
        connection = DriverManager.getConnection(url + dbName, userName, password);
        stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(qry);
        return result;

    }

    public Integer ejecutarUpdate(String qry) throws SQLException {
        Statement stmt;

        connection = DriverManager.getConnection(url + dbName, userName, password);
        stmt = connection.createStatement();

        int result = stmt.executeUpdate(qry);
        return stmt.executeUpdate(qry);
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
