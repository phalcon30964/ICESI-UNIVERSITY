package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by pregrado on 08/02/2016.
 */
public class Juego implements Serializable {

    //Listas de datos
    private ArrayList<Burbuja> burbujas;
    private ArrayList<Usuario> usuarios;
    //Configuracion de juego
    private int numBurbujas;
    private int numNotas;
    private int numColores;
    private float altoPantalla;
    private float anchoPantalla;
    private float altoImagen;
    private float anchoImagen;
    private boolean tiempoActivo;
    //Variables auxiliares a usar frecuentemente en metodos
    private Random r;
    private ArrayList<Integer> auxColores;
    private ArrayList<Integer> auxNotas;
    //Variable que indica que nota ha sido elegida como la ganadora de la ronda
    private int notaGanadora;


    public Juego(int anchoPant,int altoPant,int anchoImag,int altoImag) {
        //Numero de burbujas que se desea crear
        numBurbujas = 3;
        numNotas = 3;
        numColores = 3;
        altoPantalla = altoPant;
        anchoPantalla = anchoPant;
        altoImagen = altoImag;
        anchoImagen = anchoImag;
        tiempoActivo = true;

        //Inicializacion de arreglos de datos
        burbujas = new ArrayList<Burbuja>();
        usuarios = new ArrayList<Usuario>();

        //Creacion del usuario actual
        usuarios.add(new Usuario("Predeterminado"));

        //Recursos Auxiliares
        r = new Random();
        auxColores = new ArrayList<Integer>();
        auxNotas = new ArrayList<Integer>();
        //definir que nota sera la del juego
        notaGanadora = generarNotaGanadora();

        jugar();
    }

    public boolean isTiempoActivo() {
        return tiempoActivo;
    }

    public void setTiempoActivo(boolean tiempoActivo) {
        this.tiempoActivo = tiempoActivo;
    }

    public int generarNotaGanadora() {

        return r.nextInt(numNotas);
    }

    public void jugarDos() {

        //Limpio arreglos auxiliares a utilizar en metodo
        burbujas.clear();
        auxColores.clear();
        auxNotas.clear();

        for (int i = 0; i < numBurbujas; i++) {

            float posX = generarPosX();
            float posY = generarPosY();
            int nota = generarNota();
            int color = generarColor();

            Burbuja temp = new Burbuja(posX, posY, nota, color);
            burbujas.add(temp);
        }
    }

    //metodo que comprueba si el x generado se sobrepone al x de una imagen
    public boolean noSirveX(float x) {
        boolean sirve = false;
        for (int i = 0; i < burbujas.size() && !sirve; i++) {
            if (burbujas.get(i).getIdPosX() >= x && (burbujas.get(i).getIdPosX() + anchoImagen) <= x) {
                sirve = true;
            }
        }
        return sirve;
    }

    //metodo que comprueba si el x generado se sobrepone al y de una imagen
    public boolean noSirveY(float y) {
        boolean sirve = false;
        for (int i = 0; i < burbujas.size() && !sirve; i++) {
            if (burbujas.get(i).getIdPosY() >= y && (burbujas.get(i).getIdPosY() + altoImagen) <= y) {
                sirve = true;
            }
        }
        return sirve;
    }

    public float generarPosX() {

        float numero = r.nextFloat()*anchoPantalla;
        //genero un numero aleartorio desde 0 hasta el parametro de nextInt
        if (burbujas.isEmpty()) {
            if ((numero + anchoImagen) < anchoPantalla) {
                return numero;
            } else {
                return generarPosX();
            }
        } else {
            //si no esta vacia
            if ((numero + anchoImagen) > anchoPantalla || noSirveX(numero) || noSirveX(numero + anchoImagen)) {
                //Si el numero que generé esta contenido en la lista
                return generarPosX();//recursivamente lo mando a generar otra vez
            } else {
                return numero;
            }
        }
    }

    public float generarPosY() {

        float numero = r.nextFloat()*altoPantalla;
        //genero un numero aleartorio desde 0 hasta el parametro de nextInt
        if (burbujas.isEmpty()) {
            if ((numero + altoImagen) < altoPantalla) {
                return numero;
            } else {
                return generarPosY();
            }
        } else {
            //si no esta vacia
            if ((numero + altoImagen) > altoPantalla || noSirveY(numero) || noSirveY(numero + altoImagen)) {
                //Si el numero que generé esta contenido en la lista
                return generarPosY();//recursivamente lo mando a generar otra vez
            } else {
                return numero;
            }
        }
    }

    public int generarColor() {

        int numero = r.nextInt(numColores);
        //genero un numero aleartorio desde 0 hasta el parametro de nextInt
        if (auxColores.isEmpty()) {
            //si la lista esta vacia
            auxColores.add(numero);
            return numero;
        } else {
            //si no esta vacia
            if (auxColores.contains(numero)) {
                //Si el numero que generé esta contenido en la lista
                return generarColor();//recursivamente lo mando a generar otra vez
            } else {
                //Si no esta contenido en la lista
                auxColores.add(numero);
                return numero;
            }
        }
    }

    public int generarNota() {

        int numero = r.nextInt(numNotas);
        //genero un numero aleartorio desde 0 hasta el parametro de nextInt
        if (auxNotas.isEmpty()) {
            //si la lista esta vacia
            auxNotas.add(numero);
            return numero;
        } else {
            //si no esta vacia
            if (auxNotas.contains(numero)) {
                //Si el numero que generé esta contenido en la lista
                return generarNota();//recursivamente lo mando a generar otra vez
            } else {
                //Si no esta contenido en la lista
                auxNotas.add(numero);
                return numero;
            }
        }
    }

    public Burbuja acertoEnBurbuja(float posX, float posY) {
        Burbuja b = null;
        for (int i = 0; i < burbujas.size() && b == null; i++) {
            if (burbujas.get(i).getIdPosX() <= posX && (burbujas.get(i).getIdPosX()+anchoImagen) >= posX ) {
                if (burbujas.get(i).getIdPosY() <= posY && (burbujas.get(i).getIdPosY()+altoImagen) >= posY) {
                    b = burbujas.get(i);
                }
            }
        }
        return b;
    }

    public  boolean acertoEnBurbujaGanadora(float posX, float posY){
        Burbuja b = acertoEnBurbuja(posX, posY);
        if(b!=null){
            return b.getNota()==notaGanadora;
        }
        return false;
    }

    public String toStringNotaGanadora(){

        String mensaje = "";

        switch (notaGanadora){
            case 0:
                mensaje+="sol";
                break;
            case 1:
                mensaje+="corchea";
                break;
            case 2:
                mensaje+="union";
                break;
        }

        return mensaje;
    }
//////////nuevos
    public boolean posicionValida(float x, float y, float x2, float y2){
        boolean es= false;
        if((x+anchoImagen<x2||x>x2+anchoImagen)||(y>y2+altoImagen||y+altoImagen<y2)){
            es= true;
        }

        return es;
    }

    public float[] generarPuntos() {
        float[] puntos = new float[2];
        float numerox = r.nextFloat() * anchoPantalla;
        float numeroy = r.nextFloat() * altoPantalla;
        puntos[0] = numerox;
        puntos[1] = numeroy;

        boolean bo = false;
        if (((numerox + anchoImagen) < anchoPantalla) && ((numeroy + altoImagen) < altoPantalla)) {
            boolean pudo = true;
            for (int i = 0; i < burbujas.size()&&pudo; i++) {
                Burbuja b = burbujas.get(i);
                float x = numerox;
                float y = numeroy;
                pudo = posicionValida(x, y, b.getIdPosX(), b.getIdPosY());
                System.out.println(pudo);
            }
            bo = pudo;
        }
        if(bo){
            return puntos;
        }else{
            return generarPuntos();
        }
    }


    public void jugar() {

        //Limpio arreglos auxiliares a utilizar en metodo
        burbujas.clear();
        auxColores.clear();
        auxNotas.clear();

        for (int i = 0; i < numBurbujas; i++) {
            float[] puntos= generarPuntos();


            float posX = puntos[0];
            float posY = puntos[1];
            int nota = generarNota();
            int color = generarColor();

            Burbuja temp = new Burbuja(posX, posY, nota, color);
            burbujas.add(temp);
        }
    }


    public int getNumColores() {
        return numColores;
    }

    public void setNumColores(int numColores) {
        this.numColores = numColores;
    }

    public int getNumNotas() {
        return numNotas;
    }

    public void setNumNotas(int numNotas) {
        this.numNotas = numNotas;
    }

    public int getNumBurbujas() {
        return numBurbujas;
    }

    public void setNumBurbujas(int numBurbujas) {
        this.numBurbujas = numBurbujas;
    }

    public int getNotaGanadora() {
        return notaGanadora;
    }

    public void setNotaGanadora(int notaGanadora) {
        this.notaGanadora = notaGanadora;
    }

    public ArrayList<Burbuja> getBurbujas() {
        return burbujas;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

}
