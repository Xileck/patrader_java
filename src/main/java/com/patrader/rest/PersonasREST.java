package com.patrader.rest;

import com.patrader.dao.PersonaDAO;
import com.patrader.dto.Persona;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("personas")
public class PersonasREST {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> get() {
        return PersonaDAO.getInstance().seleccionarPersonas();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(Persona persona) {
        return PersonaDAO.getInstance().insert(persona);
    }

    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response delete(@PathParam("id") Integer id) {
        return PersonaDAO.getInstance().delete(id);
    }



}
