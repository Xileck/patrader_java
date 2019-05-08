package com.patrader.dto;

import java.util.Date;
import java.util.List;

public class Bulto {

    private Integer id;
    private String identificacion;
    private Integer consecutivo;
    private Integer anio;
    private TipoDesecho tipoDesecho;
    private Date fechaEnvase;
    private Date fechaMedicion;
    private Double dosisContacto;
    private Double dosis1m;
    private String clasificacion;
    private Double actividadInicial;
    private Double actividadActual;
    private Double actividadEspecifica;
    private Double concentracion;
    private Double masa;
    private String observaciones;
    private Persona preparoBulto;
    private Date fechaPreparo;
    private Persona revisoBulto;
    private Date fechaReviso;
    private Double valorD;
    private Double valorA_D;
    private Integer categoria;
    private String vidaMedia;
    private TipoGestion tipoGestion;
    private boolean cumpleNom035;
    private Campania campania;
    private String tratamiento;
    private Almacen almacen;

    private List<Desecho> desechos;
    private List<Pozo> pozos;

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

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public TipoDesecho getTipoDesecho() {
        return tipoDesecho;
    }

    public void setTipoDesecho(TipoDesecho tipoDesecho) {
        this.tipoDesecho = tipoDesecho;
    }

    public Date getFechaEnvase() {
        return fechaEnvase;
    }

    public void setFechaEnvase(Date fechaEnvase) {
        this.fechaEnvase = fechaEnvase;
    }

    public Date getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(Date fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
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

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public Double getActividadInicial() {
        return actividadInicial;
    }

    public void setActividadInicial(Double actividadInicial) {
        this.actividadInicial = actividadInicial;
    }

    public Double getActividadActual() {
        return actividadActual;
    }

    public void setActividadActual(Double actividadActual) {
        this.actividadActual = actividadActual;
    }

    public Double getActividadEspecifica() {
        return actividadEspecifica;
    }

    public void setActividadEspecifica(Double actividadEspecifica) {
        this.actividadEspecifica = actividadEspecifica;
    }

    public Double getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(Double concentracion) {
        this.concentracion = concentracion;
    }

    public Double getMasa() {
        return masa;
    }

    public void setMasa(Double masa) {
        this.masa = masa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Persona getPreparoBulto() {
        return preparoBulto;
    }

    public void setPreparoBulto(Persona preparoBulto) {
        this.preparoBulto = preparoBulto;
    }

    public Date getFechaPreparo() {
        return fechaPreparo;
    }

    public void setFechaPreparo(Date fechaPreparo) {
        this.fechaPreparo = fechaPreparo;
    }

    public Persona getRevisoBulto() {
        return revisoBulto;
    }

    public void setRevisoBulto(Persona revisoBulto) {
        this.revisoBulto = revisoBulto;
    }

    public Date getFechaReviso() {
        return fechaReviso;
    }

    public void setFechaReviso(Date fechaReviso) {
        this.fechaReviso = fechaReviso;
    }

    public Double getValorD() {
        return valorD;
    }

    public void setValorD(Double valorD) {
        this.valorD = valorD;
    }

    public Double getValorA_D() {
        return valorA_D;
    }

    public void setValorA_D(Double valorA_D) {
        this.valorA_D = valorA_D;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public String getVidaMedia() {
        return vidaMedia;
    }

    public void setVidaMedia(String vidaMedia) {
        this.vidaMedia = vidaMedia;
    }

    public TipoGestion getTipoGestion() {
        return tipoGestion;
    }

    public void setTipoGestion(TipoGestion tipoGestion) {
        this.tipoGestion = tipoGestion;
    }

    public boolean isCumpleNom035() {
        return cumpleNom035;
    }

    public void setCumpleNom035(boolean cumpleNom035) {
        this.cumpleNom035 = cumpleNom035;
    }

    public Campania getCampania() {
        return campania;
    }

    public void setCampania(Campania campania) {
        this.campania = campania;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public List<Desecho> getDesechos() {
        return desechos;
    }

    public void setDesechos(List<Desecho> desechos) {
        this.desechos = desechos;
    }

    public List<Pozo> getPozos() {
        return pozos;
    }

    public void setPozos(List<Pozo> pozos) {
        this.pozos = pozos;
    }
}
