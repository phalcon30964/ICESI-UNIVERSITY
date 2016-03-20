package modelo;

import java.io.Serializable;

public class Cancion implements Serializable{
	
	
	private static final long serialVersionUID = 2335072551367272810L;
	private String nombre;
	private int duracion;
	private Disco dico_album;
	
	/**
	 * Constructor de la clase cancion
	 * @param nombre
	 * @param duracion
	 * @param dico_album
	 */
	public Cancion(String nombre, int duracion, Disco dico_album) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.dico_album = dico_album;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public Disco getDico_album() {
		return dico_album;
	}


	public void setDico_album(Disco dico_album) {
		this.dico_album = dico_album;
	}


	@Override
	public String toString() {
		return "[nombre=" + nombre + ", duracion=" + duracion
				+ "min , dico_album=" + dico_album + "]";
	}
	
	
	
}
