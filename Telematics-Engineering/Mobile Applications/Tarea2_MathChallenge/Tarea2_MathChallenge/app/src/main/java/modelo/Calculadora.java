package modelo;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by pregrado on 04/02/2016.
 */
public class Calculadora implements Serializable {

    private Random r;
    private int operando1;
    private int operando2;
    private int operacion;
    private int resultado;

    public Calculadora() {
        r = new Random();
    }

    public String generarOperacion(){
        operando1 = generarNum();
        operando2 = generarNum();
        operacion = generarOperando();
        resultado = generarResultado();
        return generarMensaje();
    }

    public int generarNum(){
        return r.nextInt(100);
    }

    public int generarOperando(){
        return r.nextInt(3);
    }


    public int generarResultado(){
        int respuesta = -1;

        switch (operacion){
            case 0:
                respuesta = operando1+operando2;
            break;
            case 1:
                respuesta = operando1-operando2;
            break;
            case 2:
                respuesta = operando1*operando2;
            break;
        }

        return respuesta;
    }

    public String generarMensaje(){

        String m = "";

        switch (operacion){
            case 0:
                m = " + ";
                break;
            case 1:
                m = " - ";
                break;
            case 2:
                m = " * ";
                break;
        }

        return "¿ "+operando1+m+operando2+" ?";
    }

    public boolean comprobarRespuesta(int re){
        return resultado==re;
    }

    public int getOperando1() {
        return operando1;
    }

    public void setOperando1(int operando1) {
        this.operando1 = operando1;
    }

    public int getOperando2() {
        return operando2;
    }

    public void setOperando2(int operando2) {
        this.operando2 = operando2;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
