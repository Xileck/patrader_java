package com.patrader.dto;

import com.patrader.dto.Desecho.Desecho;

import java.util.Date;
import java.util.List;

public class Folio {
    //todo:
    private Integer id;
    private String identificacion;
    private List<Desecho> desechos;
    private Empresa empresa;
    private String numeroLicencia;//CNSNS
    private Persona persEsr;
    private boolean reutilizarAutorizado;
    private Almacen recepcion;
    private Date fechaRecepcion;
    private Persona persEntrego;
    private Persona persRecibio;
    private Persona persReviso;
    private Date fechaReviso;
    private TipoDesecho tipoDesecho;
    private TipoEmisor emisor; // solo puede tener radionuclidos de un solo tipo de emisor alfa gamma o beta
    private List<String> listaObservaciones;

    public List<Desecho> getDesechos() {
        return desechos;
    }

    public void setDesechos(List<Desecho> desechos) {
        this.desechos = desechos;
    }

    public List<String> getListaObservaciones() {
        return listaObservaciones;
    }

    public void setListaObservaciones(List<String> listaObservaciones) {
        this.listaObservaciones = listaObservaciones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Persona getPersEsr() {
        return persEsr;
    }

    public void setPersEsr(Persona persEsr) {
        this.persEsr = persEsr;
    }

    public boolean isReutilizarAutorizado() {
        return reutilizarAutorizado;
    }

    public void setReutilizarAutorizado(boolean reutilizarAutorizado) {
        this.reutilizarAutorizado = reutilizarAutorizado;
    }

    public Almacen getRecepcion() {
        return recepcion;
    }

    public void setRecepcion(Almacen recepcion) {
        this.recepcion = recepcion;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public Persona getPersEntrego() {
        return persEntrego;
    }

    public void setPersEntrego(Persona persEntrego) {
        this.persEntrego = persEntrego;
    }

    public Persona getPersRecibio() {
        return persRecibio;
    }

    public void setPersRecibio(Persona persRecibio) {
        this.persRecibio = persRecibio;
    }

    public Persona getPersReviso() {
        return persReviso;
    }

    public void setPersReviso(Persona persReviso) {
        this.persReviso = persReviso;
    }

    public Date getFechaReviso() {
        return fechaReviso;
    }

    public void setFechaReviso(Date fechaReviso) {
        this.fechaReviso = fechaReviso;
    }

    public TipoDesecho getTipoDesecho() {
        return tipoDesecho;
    }

    public void setTipoDesecho(TipoDesecho tipoDesecho) {
        this.tipoDesecho = tipoDesecho;
    }

    public TipoEmisor getEmisor() {
        return emisor;
    }

    public void setEmisor(TipoEmisor emisor) {
        this.emisor = emisor;
    }
}
