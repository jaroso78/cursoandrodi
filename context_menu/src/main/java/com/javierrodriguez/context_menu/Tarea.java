package com.javierrodriguez.context_menu;

/**
 * Created by androidm on 13/05/2015.
 */
public class Tarea {

    private String Nombre;
    private String Descripcion;

    public Tarea(String nombre, String descripcion) {
        Nombre = nombre;
        Descripcion = descripcion;
    }

    public Tarea() {
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
}
