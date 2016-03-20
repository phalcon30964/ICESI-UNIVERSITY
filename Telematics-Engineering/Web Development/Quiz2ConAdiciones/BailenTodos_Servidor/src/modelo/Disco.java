package modelo;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Disco implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3618079648303031966L;
	private String nombre;
	private String genero;
	private ImageIcon imagen;
	private int disponibles;
	private int vendidos;
	private ArrayList<Cancion> canciones;
	
	/**
	 * Constructor de la clase disco
	 * @param nombre
	 * @param genero
	 * @param imagen
	 * @param disponibles
	 * @param vendidos
	 */
	public Disco(String nombre, String genero, ImageIcon imagen,
			int disponibles, int vendidos) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.imagen = imagen;
		this.disponibles = disponibles;
		this.vendidos = vendidos;
		this.canciones = new ArrayList<Cancion>();
	}

	public boolean agregarCancion(Cancion c){
		return canciones.add(c);
	}
	
	public boolean eliminarCancion(Cancion c){
		return canciones.remove(c);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}

	public int getVendidos() {
		return vendidos;
	}

	public void setVendidos(int vendidos) {
		this.vendidos = vendidos;
	}

	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}

	@Override
	public String toString() {
		return nombre;
	}

	
	
}
