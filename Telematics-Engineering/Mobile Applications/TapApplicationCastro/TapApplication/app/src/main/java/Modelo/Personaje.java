package Modelo;

/**
 * Created by Juan Pablo on 06/02/2016.
 */
public class Personaje {
    private Float posX;
    private Float posY;
    private TipoPersonaje tipoPersononaje;

    public Personaje(Float posX, Float posY, TipoPersonaje tipo){
        this.posX=posX;
        this.posY=posY;
        this.tipoPersononaje=tipo;


    }

    public Float getPosX() {
        return posX;
    }

    public void setPosX(Float posX) {
        this.posX = posX;
    }

    public Float getPosY() {
        return posY;
    }

    public void setPosY(Float posY) {
        this.posY = posY;
    }

    public TipoPersonaje getTipoPersononaje() {
        return tipoPersononaje;
    }

    public void setTipoPersononaje(TipoPersonaje tipoPersononaje) {
        this.tipoPersononaje = tipoPersononaje;
    }
}
