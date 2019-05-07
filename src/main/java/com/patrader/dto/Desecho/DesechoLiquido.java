package com.patrader.dto.Desecho;

import com.patrader.dto.TipoEnvase;

public class DesechoLiquido extends Desecho {

    private Double volumen;
    private TipoEnvase tipoEnvase;

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public TipoEnvase getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(TipoEnvase tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }
}
