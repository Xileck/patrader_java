package com.patrader.rest;

import com.patrader.dto.Radionuclido;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class TestRest {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        Radionuclido r = new Radionuclido();
        return "Hello dude";
    }
}
