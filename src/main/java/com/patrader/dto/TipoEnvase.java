package com.patrader.dto;

public class TipoEnvase {

    private Integer id;
    private String identificacion;
    private TipoDesecho tipoDesecho;
    private Double volumen;
    private Double peso;

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

    public TipoDesecho getTipoDesecho() {
        return tipoDesecho;
    }

    public void setTipoDesecho(TipoDesecho tipoDesecho) {
        this.tipoDesecho = tipoDesecho;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
