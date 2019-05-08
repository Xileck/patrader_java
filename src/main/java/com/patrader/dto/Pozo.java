package com.patrader.dto;

import java.util.List;

public class Pozo {

    Integer id;
    Integer consecutivo;
    List<Desecho> desechos;
    Radionuclido radionuclido;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public List<Desecho> getDesechos() {
        return desechos;
    }

    public void setDesechos(List<Desecho> desechos) {
        this.desechos = desechos;
    }

    public Radionuclido getRadionuclido() {
        return radionuclido;
    }

    public void setRadionuclido(Radionuclido radionuclido) {
        this.radionuclido = radionuclido;
    }
}
