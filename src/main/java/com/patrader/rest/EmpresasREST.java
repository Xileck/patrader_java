package com.patrader.rest;

import com.patrader.dao.EmpresaDAO;
import com.patrader.dto.Empresa;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("empresas")
public class EmpresasREST {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> get() {
        return EmpresaDAO.getInstance().select();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Empresa get(@PathParam("id") Integer id) {
        return EmpresaDAO.getInstance().select(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Empresa empresa) {
        return EmpresaDAO.getInstance().update(empresa);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Empresa empresa) {
        return EmpresaDAO.getInstance().insert(empresa);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        return EmpresaDAO.getInstance().delete(id);
    }

}