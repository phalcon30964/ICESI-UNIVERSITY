package Modelo;

import java.io.Serializable;

/**
 * Created by felipeAvendanoBarbosa on 1/26/16.
 */
public class Usuario implements Serializable {

    private String nombre;

    private int puntaje;

    public Usuario(String nombre) {

        this.nombre = nombre;
        this.puntaje=puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
