package com.patrader.dao;

import com.patrader.dto.Persona;
import com.patrader.ConexionMySQL;

import javax.ws.rs.core.Response;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    private static PersonaDAO instance;

    public static PersonaDAO getInstance() {
        if (instance == null)
            instance = new PersonaDAO();
        return instance;
    }
    public List<Persona> seleccionarPersonas() {
        String qry = " SELECT id,nombre,ap_pat,ap_mat,fecha_creacion FROM personas";
        ConexionMySQL conexion = ConexionMySQL.getInstance();
        ResultSet rs;
        Persona pers;

        try {
            conexion.setQry(qry);
            rs = conexion.getSelect();
            List<Persona> lista = new ArrayList<Persona>();

            while (rs.next()) {
                pers = new Persona();
                pers.setId(rs.getInt("id"));
                pers.setNombre(rs.getString("nombre"));
                pers.setApellidoPaterno(rs.getString("ap_pat"));
                pers.setApellidoMaterno(rs.getString("ap_mat"));
                lista.add(pers);

            }
            return lista;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conexion.close();
        }
        return null;
    }




    public Response insert(Persona persona) {

        String qry = "INSERT INTO personas SET NOMBRE=?, AP_PAT=?, AP_MAT=?, FECHA_CREACION=NOW();";
        ConexionMySQL conexion = ConexionMySQL.getInstance();

        try {
            conexion.connect();
            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement(qry);
            preparedStmt.setString(1, persona.getNombre());
            preparedStmt.setString(2, persona.getApellidoPaterno());
            preparedStmt.setString(3, persona.getApellidoMaterno());

            int result = preparedStmt.executeUpdate();

            if (result > 0)
                return Response.status(201).entity(persona).build();

        } catch (Exception ex) {
            BitacoraErrorDAO.getInstance().insertBitacoraError("SQL", ex.getMessage(), qry);
            ex.printStackTrace();
        } finally {
            conexion.close();
        }
        return Response.status(400).entity("Syntaxis invalida").build();
    }
}
