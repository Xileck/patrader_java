package com.patrader.dto.Desecho;

import com.patrader.dto.TipoEnvase;

public class DesechoSolido extends Desecho {

    private Double peso;
    private TipoEnvase tipoEnvase;

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public TipoEnvase getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(TipoEnvase tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }
}
