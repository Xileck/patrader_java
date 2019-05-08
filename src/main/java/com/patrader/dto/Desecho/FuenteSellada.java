package com.patrader.dto.Desecho;

import com.patrader.dto.Marca;
import java.util.Date;

public class FuenteSellada extends Desecho {

    private Double peso;
    private Date fechaFabricacion;
    private Marca marcaContenedor;
    private Marca marcaFuente;
    private Integer numeroSerieCont;
    private Integer numeroSerieFuente;


    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public Marca getMarcaContenedor() {
        return marcaContenedor;
    }

    public void setMarcaContenedor(Marca marcaContenedor) {
        this.marcaContenedor = marcaContenedor;
    }

    public Marca getMarcaFuente() {
        return marcaFuente;
    }

    public void setMarcaFuente(Marca marcaFuente) {
        this.marcaFuente = marcaFuente;
    }

    public Integer getNumeroSerieCont() {
        return numeroSerieCont;
    }

    public void setNumeroSerieCont(Integer numeroSerieCont) {
        this.numeroSerieCont = numeroSerieCont;
    }

    public Integer getNumeroSerieFuente() {
        return numeroSerieFuente;
    }

    public void setNumeroSerieFuente(Integer numeroSerieFuente) {
        this.numeroSerieFuente = numeroSerieFuente;
    }
}
