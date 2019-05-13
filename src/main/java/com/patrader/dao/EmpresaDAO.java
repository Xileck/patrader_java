package com.patrader.dao;

import com.patrader.ConexionMySQL;
import com.patrader.dto.CodigoPostal;
import com.patrader.dto.Empresa;
import com.patrader.dto.Persona;

import javax.ws.rs.core.Response;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAO {
    private static EmpresaDAO ourInstance = new EmpresaDAO();

    public static EmpresaDAO getInstance() {
        return ourInstance;
    }

    private EmpresaDAO() {
    }

    public List<Empresa> select() {
        String qry = "SELECT e.ID, e.NOMBRE, e.TELEFONO, e.CALLE, e.NUM_CALLE, e.FECHA_CREACION, " +
                "s.id, s.cp, s.estado, s.ciudad, " +
                "p.ID, p.NOMBRE, p.AP_PAT, p.AP_MAT " +
                "FROM empresas e " +
                "LEFT JOIN personas p ON e.ID_REPRESENTANTE = p.id " +
                "LEFT JOIN sepomex s ON e.ID_SEPOMEX = s.id ";

        ConexionMySQL conexion = ConexionMySQL.getInstance();
        List<Empresa> empresas = null;

        ResultSet rs;
        try {
            conexion.setQry(qry);
            rs = conexion.getSelect();
            empresas = new ArrayList<Empresa>();
            while (rs.next()) {
                Empresa empresa = new Empresa();
                empresa.setId(rs.getInt("e.id"));
                empresa.setNombre(rs.getString("e.NOMBRE"));
                empresa.setTelefono(rs.getString("e.TELEFONO"));
                empresa.setCalle(rs.getString("e.CALLE"));
                empresa.setNumCalle(rs.getString("e.NUM_CALLE"));
                empresa.setFechaCreacion(rs.getObject("e.FECHA_CREACION", LocalDate.class));

                CodigoPostal cp = new CodigoPostal();
                cp.setId(rs.getInt("s.id"));
                cp.setCodigoPostal(rs.getInt("s.cp"));
                cp.setEstado(rs.getString("s.estado"));
                cp.setCiudad(rs.getString("s.ciudad"));
                empresa.setCodigoPostal(cp);


                Persona p = new Persona();
                p.setId(rs.getInt("p.ID"));
                p.setNombre(rs.getString("p.NOMBRE"));
                p.setApellidoPaterno(rs.getString("p.AP_PAT"));
                p.setApellidoMaterno(rs.getString("p.AP_MAT"));


                empresa.setRepresentante(p);

                empresas.add(empresa);
            }

            if (empresas.size() == 0)
                empresas = null;
        } catch (Exception ex) {
            empresas = null;
            BitacoraErrorDAO.getInstance().insertBitacoraError("SQL", ex.getMessage(), qry);
            ex.printStackTrace();
        } finally {
            conexion.close();
        }
        return empresas;
    }

    public Empresa select(Integer id) {

        String qry = "SELECT e.ID, e.NOMBRE, e.TELEFONO, e.CALLE, e.NUM_CALLE, e.FECHA_CREACION, " +
                "s.id, s.cp, s.estado, s.ciudad, " +
                "p.ID, p.NOMBRE, p.AP_PAT, p.AP_MAT " +
                "FROM empresas e " +
                "LEFT JOIN personas p ON e.ID_REPRESENTANTE = p.id " +
                "LEFT JOIN sepomex s ON e.ID_SEPOMEX = s.id " +
                "WHERE e.id = " + id;

        ConexionMySQL conexion = ConexionMySQL.getInstance();
        Empresa empresa = null;

        ResultSet rs;
        try {
            conexion.setQry(qry);
            rs = conexion.getSelect();

            if (rs.next()) {
                empresa = new Empresa();
                empresa.setId(rs.getInt("e.id"));
                empresa.setNombre(rs.getString("e.NOMBRE"));
                empresa.setTelefono(rs.getString("e.TELEFONO"));
                empresa.setCalle(rs.getString("e.CALLE"));
                empresa.setNumCalle(rs.getString("e.NUM_CALLE"));
                empresa.setFechaCreacion(rs.getObject("e.FECHA_CREACION", LocalDate.class));

                CodigoPostal cp = new CodigoPostal();
                cp.setId(rs.getInt("s.id"));
                cp.setCodigoPostal(rs.getInt("s.cp"));
                cp.setEstado(rs.getString("s.estado"));
                cp.setCiudad(rs.getString("s.ciudad"));
                empresa.setCodigoPostal(cp);


                Persona p = new Persona();
                p.setId(rs.getInt("p.ID"));
                p.setNombre(rs.getString("p.NOMBRE"));
                p.setApellidoPaterno(rs.getString("p.AP_PAT"));
                p.setApellidoMaterno(rs.getString("p.AP_MAT"));


                empresa.setRepresentante(p);

            }
        } catch (Exception ex) {
            BitacoraErrorDAO.getInstance().insertBitacoraError("SQL", ex.getMessage(), qry);
            ex.printStackTrace();
        } finally {
            conexion.close();
        }
        return empresa;
    }

    public Response delete(Integer id) {

        String qry = "DELETE FROM empresas WHERE ID = " + id + ";";
        ConexionMySQL conexion = ConexionMySQL.getInstance();

        try {
            conexion.connect();

            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement(qry);

            preparedStmt.execute();
            int result = conexion.ejecutarUpdate(qry);

            if (result == 1)
                return Response.status(200).entity("Empresa eliminada con exito!").build();

        } catch (Exception ex) {
            BitacoraErrorDAO.getInstance().insertBitacoraError("SQL", ex.getMessage(), qry);
            ex.printStackTrace();
        } finally {
            conexion.close();
        }
        return Response.status(400).entity("400 Bad Request").build();
    }

    public Response update(Empresa empresa) {

        String qry = "UPDATE empresas SET NOMBRE = ?, TELEFONO = ?, CALLE = ?, NUM_CALLE = ?, ID_SEPOMEX = ? , ID_REPRESENTANTE = ?, FECHA_CREACION = ?" +
                "     WHERE ID = " + empresa.getId() + ";";
        ConexionMySQL conexion = ConexionMySQL.getInstance();

        try {
            conexion.connect();

            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement(qry);
            preparedStmt.setString(1, empresa.getNombre());
            preparedStmt.setString(2, empresa.getTelefono());
            preparedStmt.setString(3, empresa.getCalle());
            preparedStmt.setString(4, empresa.getNumCalle());
            preparedStmt.setInt(5, empresa.getCodigoPostal().getId());
            preparedStmt.setInt(6, empresa.getRepresentante().getId());
            preparedStmt.setDate(7, Date.valueOf(empresa.getFechaCreacion()));

            preparedStmt.execute();
            int result = conexion.ejecutarUpdate(qry);

            if (result == 1)
                return Response.ok().entity(empresa).build();

        } catch (Exception ex) {
            BitacoraErrorDAO.getInstance().insertBitacoraError("SQL", ex.getMessage(), qry);
            ex.printStackTrace();
        } finally {
            conexion.close();
        }
        return Response.status(400).entity("400 Bad Request").build();
    }

    public Response insert(Empresa empresa) {

        String qry = "INSERT INTO empresas SET NOMBRE = ?, TELEFONO = ?, CALLE = ?, NUM_CALLE = ?, ID_SEPOMEX = ?," +
                " ID_REPRESENTANTE = ?, FECHA_CREACION = NOW();";

        ConexionMySQL conexion = ConexionMySQL.getInstance();

        try {
            conexion.connect();

            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement(qry);
            preparedStmt.setString(1, empresa.getNombre());
            preparedStmt.setString(2, empresa.getTelefono());
            preparedStmt.setString(3, empresa.getCalle());
            preparedStmt.setString(4, empresa.getNumCalle());
            preparedStmt.setInt(5, empresa.getCodigoPostal().getId());
            preparedStmt.setInt(6, empresa.getRepresentante().getId());


            int result = preparedStmt.executeUpdate();

            if (result > 0)
                return Response.status(201).entity(empresa).build();

        } catch (Exception ex) {
            BitacoraErrorDAO.getInstance().insertBitacoraError("SQL", ex.getMessage(), qry);
            ex.printStackTrace();
        } finally {
            conexion.close();
        }
        return Response.status(400).entity("Syntaxis invalida").build();
    }


}
