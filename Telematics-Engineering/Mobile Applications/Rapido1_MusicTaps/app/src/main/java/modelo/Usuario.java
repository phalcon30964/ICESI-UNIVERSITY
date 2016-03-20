package modelo;

import java.io.Serializable;

/**
 * Created by pregrado on 08/02/2016.
 */
public class Usuario implements Serializable{

    private String nombre;
    private int aciertos;
    private int fallos;
    private String tiempo;


    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String t) {
        this.tiempo = t;
    }
}
