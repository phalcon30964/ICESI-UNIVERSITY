package TadColaEquipo;

import TadCola.*;

public class NodoIntegrante implements Prioridad {
	
	private int prioridad;
	
	private String nombre;
	
	public NodoIntegrante(int pri, String nom){
		
		this.prioridad = pri;
		this.nombre = nom;
		
	}

	@Override
	public int getPrioridad() {
		// TODO Auto-generated method stub
		return this.prioridad;
	}

	@Override
	public void setPrioridad(int pri) {
		
		this.prioridad = pri;
		
	}

	@Override
	public String toString() {
		return nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
