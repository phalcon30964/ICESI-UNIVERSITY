package mundo;

import java.io.Serializable;

public class Egresado implements Serializable {
	private String nombres;
	private String apellidos;
	private String cedula;
	private String telefono;
	private String correoElectronico;
	private int numeroPuesto;
	
	public Egresado(String nom, String ape, String ced, String tel, String correoE) {
		nombres = nom;
		apellidos = ape;
		cedula = ced;
		telefono = tel;
		correoElectronico = correoE;
		numeroPuesto = 0;
	}

	public String darNombres() {
		return nombres;
	}
	
	public void cambiarNombres(String nom) {
		nombres = nom;
	}
	
	public String darApellidos() {
		return apellidos;
	}
	
	public void cambiarApellidos(String ape) {
		apellidos = ape;
	}
	
	public String darCedula() {
		return cedula;
	}
	
	public void cambiarCedula(String ced) {
		cedula = ced;
	}
	
	public String darTelefono() {
		return telefono;
	}
	
	public void cambiarTelefono(String tel) {
		telefono = tel;
	}
	
	public String darCorreoElectronico() {
		return correoElectronico;
	}
	
	public void cambiarCorreoElectronico(String correoE) {
		correoElectronico = correoE;
	}
	
	public int darNumeroPuesto() {
		return numeroPuesto;
	}
	
	public void cambiarNumeroPuesto(int numeroP) {
		numeroPuesto = numeroP;
	}
	
	@Override
	public String toString() {
		return numeroPuesto + " - "+ nombres  + ", " + apellidos + ", " + cedula + ", " + 
	           telefono + ", " + correoElectronico;
	}
}
