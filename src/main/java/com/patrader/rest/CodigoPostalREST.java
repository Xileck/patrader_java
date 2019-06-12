package com.patrader.rest;

import com.patrader.dao.CodigoPostalDAO;
import com.patrader.dto.CodigoPostal;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("codigo_postal")
public class CodigoPostalREST {



    @GET()
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CodigoPostal get(@PathParam("id") Integer id) {
        return CodigoPostalDAO.getInstance().select(id);
    }


}