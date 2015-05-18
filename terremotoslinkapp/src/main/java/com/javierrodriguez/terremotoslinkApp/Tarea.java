package com.javierrodriguez.terremotoslinkApp;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by androidm on 13/05/2015.
 */
public class Tarea implements Serializable {

    private String Nombre;
    private String Descripcion;
    private int Prioridad;
    private Date fecha;


    public Tarea() {
    }


    public Tarea(String nombre, String descripcion, int prioridad, Date fecha) {
        Descripcion = descripcion;
        this.fecha = fecha;
        Nombre = nombre;
        Prioridad = prioridad;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(int prioridad) {
        Prioridad = prioridad;
    }


}
