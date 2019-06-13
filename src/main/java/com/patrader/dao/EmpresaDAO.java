package com.patrader.dao;

import com.patrader.ConexionMySQL;
import com.patrader.dto.CodigoPostal;
import com.patrader.dto.Empresa;
import com.patrader.dto.Persona;
import com.patrader.dto.Usuario;

import javax.ws.rs.core.Response;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
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
        String qry = "SELECT e.ID, e.NOMBRE, e.TELEFONO, e.CODIGO_POSTAL,e.ESTADO, e.CIUDAD, e.CALLE, e.NUM_CALLE, e.FECHA_CREACION, e.ID_CREACION, " +
                "p.ID, p.NOMBRE, p.AP_PAT, p.AP_MAT " +
                "FROM empresas e " +
                "LEFT JOIN personas p ON e.ID_REPRESENTANTE = p.id ;";

        ConexionMySQL conexion = ConexionMySQL.getInstance();
        List<Empresa> empresas;

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
                empresa.setCodigoPostal(rs.getInt("e.CODIGO_POSTAL"));
                empresa.setEstado(rs.getString("e.ESTADO"));
                empresa.setCiudad(rs.getString("e.CIUDAD"));
                empresa.setCalle(rs.getString("e.CALLE"));
                empresa.setNumCalle(rs.getString("e.NUM_CALLE"));
                empresa.setFechaCreacion(rs.getObject("e.FECHA_CREACION", LocalDate.class));

                Integer idCreacion = rs.getInt("e.ID_CREACION");
                if (idCreacion != null) {
                    empresa.setUsuarioCreador(new Usuario());
                    empresa.getUsuarioCreador().setId(idCreacion);

                    //TODO: Llenar campos restantes de usuario
                }

                Integer idRepresentante = rs.getInt("p.ID");

                if (idRepresentante != null) {
                    Persona p = new Persona();
                    p.setId(rs.getInt("p.ID"));
                    p.setNombre(rs.getString("p.NOMBRE"));
                    p.setApellidoPaterno(rs.getString("p.AP_PAT"));
                    p.setApellidoMaterno(rs.getString("p.AP_MAT"));
                    empresa.setRepresentante(p);
                }

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

        String qry = "SELECT e.ID, e.NOMBRE, e.TELEFONO, e.CODIGO_POSTAL ,e.ESTADO, e.CIUDAD, e.CALLE, e.NUM_CALLE, e.FECHA_CREACION, e.ID_CREACION " +
                " p.ID, p.NOMBRE, p.AP_PAT, p.AP_MAT " +
                " FROM empresas e " +
                " LEFT JOIN personas p ON e.ID_REPRESENTANTE = p.id " +
                " WHERE e.id = " + id;

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
                empresa.setCodigoPostal(rs.getInt("e.CODIGO_POSTAL"));
                empresa.setEstado(rs.getString("e.ESTADO"));
                empresa.setCiudad(rs.getString("e.CIUDAD"));
                empresa.setCalle(rs.getString("e.CALLE"));
                empresa.setNumCalle(rs.getString("e.NUM_CALLE"));
                empresa.setFechaCreacion(rs.getObject("e.FECHA_CREACION", LocalDate.class));

                Integer idCreacion = rs.getInt("e.ID_CREACION");
                if (idCreacion != null) {
                    empresa.setUsuarioCreador(new Usuario());
                    empresa.getUsuarioCreador().setId(idCreacion);

                    //TODO: Llenar campos restantes de usuario
                }


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

            int result = conexion.ejecutarUpdate(qry);

            if (result > 0)
                return Response.ok().build();
            else
                return Response.status(410).entity("El id de la empresa no existe.").build();

        } catch (Exception ex) {
            BitacoraErrorDAO.getInstance().insertBitacoraError("SQL", ex.getMessage(), qry);
            ex.printStackTrace();
            return Response.status(400).entity("400 Bad Request").build();
        } finally {
            conexion.close();
        }

    }

    public Response update(Empresa empresa) {

        String qry = "UPDATE empresas SET NOMBRE = ?, TELEFONO = ?,CODIGO_POSTAL=?, ESTADO = ?, CIUDAD = ?, CALLE = ?, NUM_CALLE = ?,  ID_REPRESENTANTE = ?, FECHA_CREACION =  NOW() " +
                " WHERE ID = ?;";
        ConexionMySQL conexion = ConexionMySQL.getInstance();
        PreparedStatement preparedStmt = null;
        try {
            conexion.connect();

            preparedStmt = conexion.getConnection().prepareStatement(qry);
            preparedStmt.setString(1, empresa.getNombre());
            preparedStmt.setString(2, empresa.getTelefono());
            preparedStmt.setInt(3, empresa.getCodigoPostal());
            preparedStmt.setString(4, empresa.getEstado());
            preparedStmt.setString(5, empresa.getCiudad());
            preparedStmt.setString(6, empresa.getCalle());
            preparedStmt.setString(7, empresa.getNumCalle());
            preparedStmt.setInt(8, empresa.getRepresentante().getId());
            preparedStmt.setInt(9, empresa.getId());

            boolean result = preparedStmt.execute();

            if (!result)
                return Response.ok().entity(empresa).build();

        } catch (Exception ex) {
            BitacoraErrorDAO.getInstance().insertBitacoraError("SQL", ex.getMessage(), preparedStmt != null ? preparedStmt.toString() : qry);
            ex.printStackTrace();
        } finally {
            conexion.close();
        }
        return Response.status(400).entity("400 Bad Request").build();
    }

    public Response insert(Empresa empresa) {

        String qry = "INSERT INTO empresas SET NOMBRE = ?, TELEFONO = ?, CODIGO_POSTAL = ?, ESTADO = ?, CIUDAD = ?, CALLE = ?, NUM_CALLE = ?, " +
                " ID_REPRESENTANTE = ?, ID_CREACION = ?, FECHA_CREACION = NOW();";

        ConexionMySQL conexion = ConexionMySQL.getInstance();

        try {
            conexion.connect();

            PreparedStatement preparedStmt = conexion.getConnection().prepareStatement(qry);
            preparedStmt.setString(1, empresa.getNombre());
            preparedStmt.setString(2, empresa.getTelefono());
            preparedStmt.setInt(3, empresa.getCodigoPostal());
            preparedStmt.setString(4, empresa.getEstado());
            preparedStmt.setString(5, empresa.getCiudad());
            preparedStmt.setString(6, empresa.getCalle());
            preparedStmt.setString(7, empresa.getNumCalle());
            preparedStmt.setInt(8, empresa.getRepresentante().getId());

            if (empresa.getUsuarioCreador() != null) {
                preparedStmt.setInt(9, empresa.getUsuarioCreador().getId());
            } else {
                preparedStmt.setNull(9, Types.INTEGER);
            }


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
