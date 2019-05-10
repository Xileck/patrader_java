package com.patrader.dao;

import com.patrader.dto.Persona;
import com.patrader.ConexionMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonaDAO {


    public String getNombreHic(int idBulto) {
        StringBuilder qry = new StringBuilder();
        qry.append(" SELECT identificador from sgdbulto ");
        qry.append(" WHERE id = " + idBulto + ";  ");
        ConexionMySQL conexion = ConexionMySQL.getInstance();
        ResultSet rs;
        try {
            conexion.setQry(qry.toString());
            rs = conexion.getSelect();

            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conexion.close();
        }
        return null;
    }


    public boolean insertarHic(Persona persona) {
        String qry = " INSERT INTO sgdBulto (idDesecho, revprocedimiento, anio, unidad, consecutivo, porcentaje, identificador, pendienteClas, observacionClasificacion, fechaCreacion, revisoClas, realizoClas) ";
        qry += "       VALUES (?, ?, ?, ?, ?, ?, TRIM(?), ?, ?, NOW(), ?, ? ); ";
        ConexionMySQL conexion = ConexionMySQL.getInstance();
        PreparedStatement preparedStmt = null;
        try {
            conexion.connect();
            // Insertar en tabla sgdbultoLote
             preparedStmt = conexion.getConnection().prepareStatement(qry);
            //preparedStmt.setInt(1, hic.getDesecho().getClave());


            // execute the preparedstatement
           return preparedStmt.execute();

        } catch (Exception e) {
            BitacoraErrorDAO.getInstance().insertBitacoraError("SQL",e.getMessage(),preparedStmt.toString());
            e.printStackTrace();
        } finally {
            ConexionMySQL.getInstance().close();
        }
        return false;
    }
}
