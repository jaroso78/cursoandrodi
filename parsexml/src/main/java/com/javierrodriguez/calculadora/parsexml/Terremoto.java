package com.javierrodriguez.calculadora.parsexml;

import java.util.Date;

/**
 * Created by androidm on 20/05/2015.
 */
public class Terremoto {

    private String id;
    private String titulo;
    private Date fecha;
    private String link;
    private double latitud;
    private double longitud;
    private float magnitud;



    public Terremoto() {

    }

    public Terremoto(double latitud, Date fecha, String id, String link, double longitud, float magnitud, String titulo) {
        this.latitud = latitud;
        this.fecha = fecha;
        this.id = id;
        this.link = link;
        this.longitud = longitud;
        this.magnitud = magnitud;
        this.titulo = titulo;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public float getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(float magnitud) {
        this.magnitud = magnitud;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Terremoto terremoto = (Terremoto) o;

        return !(id != null ? !id.equals(terremoto.id) : terremoto.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Terremoto{" +
                "titulo='" + titulo + '\'' +
                ", magnitud=" + magnitud +
                ", fecha=" + fecha +
                '}';
    }

}
