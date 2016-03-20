package modelo;

import java.io.Serializable;

/**
 * Created by pregrado on 08/02/2016.
 */
public class Burbuja implements Serializable{

    private float idPosX;
    private float idPosY;
    private int nota;
    private int color;

    public Burbuja(float idPosX, float idPosY, int nota, int color) {
        this.idPosX = idPosX;
        this.idPosY = idPosY;
        this.nota = nota;
        this.color = color;
    }

    public float getIdPosX() {
        return idPosX;
    }

    public void setIdPosX(float idPosX) {
        this.idPosX = idPosX;
    }

    public float getIdPosY() {
        return idPosY;
    }

    public void setIdPosY(float idPosY) {
        this.idPosY = idPosY;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    //metodo que dice que imagen debe cargarse, devuelve el nombre del id del icono de la burbuja
    public String getRutaIcono() {
        String mensaje = "";
        switch (nota){
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
        switch (color){
            case 0:
                mensaje+="amarillo";
                break;
            case 1:
                mensaje+="azul";
                break;
            case 2:
                mensaje+="morado";
                break;
        }
        return mensaje;
    }
}
