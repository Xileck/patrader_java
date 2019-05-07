package com.patrader.dto.Desecho;

import com.patrader.dto.MetodoMedicion;
import com.patrader.dto.Radionuclido;
import com.patrader.dto.TipoDesecho;

import java.util.Date;

public class Desecho {

    private Integer id;
    private String identificacion;
    private Integer consecutivo;
    private TipoDesecho tipoDesecho;
    private Radionuclido radionuclido;
    private Double actividadInicial;
    private Double actividadFinal;
    private Double actividadRotulada;
    private Double densidad;
    private Double dosisContacto;
    private Double dosis1m;
    private MetodoMedicion metodoMedicion;
    private String numeroAutorizacionCNSNS;
    private Date fechaCalibracion;
    private Date fechaEntrada;
    private Date fechaSalida;

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

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public TipoDesecho getTipoDesecho() {
        return tipoDesecho;
    }

    public void setTipoDesecho(TipoDesecho tipoDesecho) {
        this.tipoDesecho = tipoDesecho;
    }

    public Radionuclido getRadionuclido() {
        return radionuclido;
    }

    public void setRadionuclido(Radionuclido radionuclido) {
        this.radionuclido = radionuclido;
    }

    public Double getActividadInicial() {
        return actividadInicial;
    }

    public void setActividadInicial(Double actividadInicial) {
        this.actividadInicial = actividadInicial;
    }

    public Double getActividadFinal() {
        return actividadFinal;
    }

    public void setActividadFinal(Double actividadFinal) {
        this.actividadFinal = actividadFinal;
    }

    public Double getActividadRotulada() {
        return actividadRotulada;
    }

    public void setActividadRotulada(Double actividadRotulada) {
        this.actividadRotulada = actividadRotulada;
    }

    public Double getDensidad() {
        return densidad;
    }

    public void setDensidad(Double densidad) {
        this.densidad = densidad;
    }

    public Double getDosisContacto() {
        return dosisContacto;
    }

    public void setDosisContacto(Double dosisContacto) {
        this.dosisContacto = dosisContacto;
    }

    public Double getDosis1m() {
        return dosis1m;
    }

    public void setDosis1m(Double dosis1m) {
        this.dosis1m = dosis1m;
    }

    public MetodoMedicion getMetodoMedicion() {
        return metodoMedicion;
    }

    public void setMetodoMedicion(MetodoMedicion metodoMedicion) {
        this.metodoMedicion = metodoMedicion;
    }

    public String getNumeroAutorizacionCNSNS() {
        return numeroAutorizacionCNSNS;
    }

    public void setNumeroAutorizacionCNSNS(String numeroAutorizacionCNSNS) {
        this.numeroAutorizacionCNSNS = numeroAutorizacionCNSNS;
    }

    public Date getFechaCalibracion() {
        return fechaCalibracion;
    }

    public void setFechaCalibracion(Date fechaCalibracion) {
        this.fechaCalibracion = fechaCalibracion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}


