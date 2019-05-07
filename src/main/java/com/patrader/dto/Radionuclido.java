package com.patrader.dto;



public class Radionuclido {

   private Integer id;
   private String identificacion;
   private Double vidaMedia;
   private TipoEmisor emisor;

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

    public Double getVidaMedia() {
        return vidaMedia;
    }

    public void setVidaMedia(Double vidaMedia) {
        this.vidaMedia = vidaMedia;
    }

    public TipoEmisor getEmisor() {
        return emisor;
    }

    public void setEmisor(TipoEmisor emisor) {
        this.emisor = emisor;
    }
}
