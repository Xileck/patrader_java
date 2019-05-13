package com.patrader.rest;

import com.patrader.dto.Persona;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;

@Path("personas")
public class PersonasREST {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Persona> select(){
        List<Persona> lista = new ArrayList<Persona>();
        Persona p = new Persona();
        p.setId(1);
        p.setNombre("ALEJANDRO");
        p.setApellidoPaterno("CARMONA");
        p.setApellidoMaterno("MENDOZA");

        lista.add(p);
        return lista;
    }
}
