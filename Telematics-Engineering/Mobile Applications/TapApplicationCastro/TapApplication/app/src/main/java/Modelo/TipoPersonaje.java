package Modelo;

/**
 * Created by Juan Pablo on 06/02/2016.
 */
public class TipoPersonaje {
    private String nombreTipo;
    private String imagen;
    private int monto;

    public TipoPersonaje(String nombreTipo, String imagen, int monto){
        this.nombreTipo= nombreTipo;
        this.imagen=imagen;
        this.monto=monto;

    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }
}