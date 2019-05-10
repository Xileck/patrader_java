package com.patrader.rest;

import com.patrader.dto.Radionuclido;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class TestRest {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public String hello() {
        Radionuclido r = new Radionuclido();

        return "Hello dude";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/sepomex")
    public Radionuclido  sepomex() {
        Radionuclido r = new Radionuclido();
        r.setId(1);
        r.setIdentificacion("identificacion");
        r.setVidaMedia(3.2);

        return r;
    }


}
