package mundo;

public class Cliente {

	private String cedula;
	private String nombres;
	private String apellidos;
	private int edad;
	
	public Cliente(String ced, String nom, String ape, int ed){
		cedula = ced;
		nombres = nom;
		apellidos = ape;
		edad = ed;
	}

	public String darCedula() {
		return cedula;
	}

	public void cambiarCedula(String ced) {
		cedula = ced;
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

	public int darEdad() {
		return edad;
	}

	public void cambiarEdad(int ed) {
		edad = ed;
	}
	
	public String toString(){
		return cedula + ": " + nombres + " " + apellidos;
	}
}
