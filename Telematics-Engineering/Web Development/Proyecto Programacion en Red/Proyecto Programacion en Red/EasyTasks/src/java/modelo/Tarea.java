/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author CL
 */
public class Tarea {
    
    private String nombre;
    private String descripcion;
    private Timestamp fechaLimite;
    private int prioridad;
    private double ubiLongitud;
    private double ubiLatitud;
    private ArrayList<String> tags;
    private String categoria;

    public Tarea(String nombre, String descripcion, Timestamp fechaLimite, int prioridad, double ubiLongitud, double ubiLatitud, ArrayList<String> tags, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.prioridad = prioridad;
        this.ubiLongitud = ubiLongitud;
        this.ubiLatitud = ubiLatitud;
        this.tags = tags;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Timestamp fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public double getUbiLongitud() {
        return ubiLongitud;
    }

    public void setUbiLongitud(double ubiLongitud) {
        this.ubiLongitud = ubiLongitud;
    }

    public double getUbiLatitud() {
        return ubiLatitud;
    }

    public void setUbiLatitud(double ubiLatitud) {
        this.ubiLatitud = ubiLatitud;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public String toStringSimple(){
        return "Nombre: "+getNombre()+"   Fecha Limite: "+getFechaLimite().toString()+"   Prioridad: "+getPrioridad();
    }
    
}
