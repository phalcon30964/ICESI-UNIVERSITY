package modelo;

import java.io.Serializable;

/**
 * Created by pregrado on 04/02/2016.
 */
public class Juego implements Serializable {

    private Usuario user;
    private Calculadora calculadora;

    public Juego(String nombre) {
        user = new Usuario(nombre);
        calculadora = new Calculadora();

    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Calculadora getCalculadora() {
        return calculadora;
    }

    public void setCalculadora(Calculadora calculadora) {
        this.calculadora = calculadora;
    }
}
