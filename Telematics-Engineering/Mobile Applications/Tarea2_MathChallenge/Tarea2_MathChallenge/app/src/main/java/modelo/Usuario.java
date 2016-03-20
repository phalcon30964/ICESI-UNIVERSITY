package modelo;

import java.io.Serializable;

/**
 * Created by pregrado on 04/02/2016.
 */
public class Usuario implements Serializable{

    private String nombre;
    private int aciertos;
    private int errores;

    public Usuario(String nombre) {
        this.nombre = nombre;
        aciertos = 0;
        errores = 0;
    }

    public void aumentarAciertos(){
        aciertos++;
    }

    public void aumentarErrores(){
        errores++;
    }

    public void reiniciarPuntaje(){
        aciertos = 0;
        errores = 0;
    }

    public int getNumJugadas(){
        return aciertos+errores;
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

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public boolean gano(){
        return aciertos>errores;
    }

}
