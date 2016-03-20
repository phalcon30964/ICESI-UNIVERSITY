package Modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by estudiante32 on 6/02/16.
 */
public class Juego {

    int tapX;
    int tapY;

    private Personaje personaje;
    private ArrayList<TipoPersonaje> tiposPersonaje;
    private Usuario usuario;
    private int vidas;

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<TipoPersonaje> getTiposPersonaje() {
        return tiposPersonaje;
    }

    public void setTiposPersonaje(ArrayList<TipoPersonaje> tiposPersonaje) {
        this.tiposPersonaje = tiposPersonaje;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Juego(String nombreUsuario) {
        this.personaje = null;

        this.usuario = new Usuario(nombreUsuario);
        this.vidas=4;

        tiposPersonaje = new ArrayList<>();

        crearTipos("monja","drawable/monja.png",-10);
        crearTipos("Ku Klux Klan","drawable/kus.png",10);
        crearTipos("Humano","drawable/humano.png",-5);
    }

    public void crearTipos(String nombreTipo, String imagen, int monto){
        TipoPersonaje tipoPersonaje= new TipoPersonaje(nombreTipo, imagen,monto);
        tiposPersonaje.add(tipoPersonaje);
    }
    public Personaje crearPersonaje( ){
        Random ran= new Random();
        Float posX= ran.nextFloat()*400;
        Float posY= ran.nextFloat()*700;
        int posicionTipo= ran.nextInt(tiposPersonaje.size()-1);
        TipoPersonaje tipoPersonaje= tiposPersonaje.get(posicionTipo);
        personaje= new Personaje(posX,posY,tipoPersonaje);

        return personaje;
    }
    public void cambiarPuntaje(Float posX, Float posY){
        float limiteX=personaje.getPosX()+256;
        float originalX= personaje.getPosX();

        float limiteY=personaje.getPosY()+256;
        float originalY= personaje.getPosY();

        if(posX<=limiteX && posX>=originalX ){
            if(posY<=limiteY && posY>=originalY){
                usuario.setPuntaje(usuario.getPuntaje()+personaje.getTipoPersononaje().getMonto());
                if(usuario.getPuntaje()<=-10){
                    if(vidas>0){
                        vidas-=1;
                    }
                    else{

                    }
                }
            }

        }
    }

    public int getTapX() {
        return tapX;
    }

    public void setTapX(int tapX) {
        this.tapX = tapX;
    }

    public int getTapY() {
        return tapY;
    }

    public void setTapY(int tapY) {
        this.tapY = tapY;
    }
}
