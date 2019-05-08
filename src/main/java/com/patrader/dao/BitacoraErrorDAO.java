package com.patrader.dao;

import com.patrader.ConexionMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BitacoraErrorDAO {

    private static BitacoraErrorDAO ourInstance = new BitacoraErrorDAO();

    public static BitacoraErrorDAO getInstance() {
        return ourInstance;
    }

    private BitacoraErrorDAO() {
    }

    public void insertBitacoraError(String tipo, String mensaje, String query) {

        PreparedStatement preparedStmt = null;
        Connection conexion = ConexionMySQL.getInstance().connect();
        String qry = " INSERT INTO bitacora_error (tipo, mensaje, query, fecha) VALUES( ?, ?, ?, NOW());";

        try {
            ConexionMySQL.getInstance().connect();
            // Insertar en tabla
            preparedStmt = conexion.prepareStatement(qry);
            preparedStmt.setString(1, tipo);
            preparedStmt.setString(2, mensaje);
            preparedStmt.setString(3, query);

            // execute the preparedstatement
            preparedStmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionMySQL.getInstance().close();
        }
    }


}
