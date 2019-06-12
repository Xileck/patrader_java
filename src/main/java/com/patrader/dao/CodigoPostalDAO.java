package com.patrader.dao;

import com.patrader.ConexionMySQL;
import com.patrader.dto.CodigoPostal;

import java.sql.ResultSet;

public class CodigoPostalDAO {
    private static CodigoPostalDAO ourInstance = new CodigoPostalDAO();

    public static CodigoPostalDAO getInstance() {
        return ourInstance;
    }

    private CodigoPostalDAO() {
    }


    public CodigoPostal select(Integer id) {

        String qry = "SELECT s.id, s.cp, s.estado, s.ciudad,s.asentamiento,s.municipio " +
                " FROM sepomex s " +
                " WHERE s.cp = " + id + ";";

        ConexionMySQL conexion = ConexionMySQL.getInstance();
        CodigoPostal codigoPostal = null;

        ResultSet rs;
        try {
            conexion.setQry(qry);
            rs = conexion.getSelect();

            if (rs.next()) {
                codigoPostal = new CodigoPostal();
                codigoPostal.setId(rs.getInt("s.id"));
                codigoPostal.setCodigoPostal(rs.getInt("s.cp"));
                codigoPostal.setEstado(rs.getString("s.estado"));
                codigoPostal.setCiudad(rs.getString("s.ciudad"));
                codigoPostal.setMunicipio(rs.getString("s.municipio"));
                codigoPostal.setAsentamiento(rs.getString("s.asentamiento"));


            }
        } catch (Exception ex) {
            BitacoraErrorDAO.getInstance().insertBitacoraError("SQL", ex.getMessage(), qry);
            ex.printStackTrace();
        } finally {
            conexion.close();
        }
        return codigoPostal;
    }


}
