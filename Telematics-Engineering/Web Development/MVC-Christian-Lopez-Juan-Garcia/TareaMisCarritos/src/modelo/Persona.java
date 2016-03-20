package modelo;

public class Persona {
	
	protected String nombre;
	protected String apellido;
	protected String cedula;
	protected String numContacto;
	protected String direccion;
	
	public Persona(String nombre, String apellido, String cedula, String numContacto,
			String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.numContacto = numContacto;
		this.direccion = direccion;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNumContacto() {
		return numContacto;
	}
	public void setNumContacto(String numContacto) {
		this.numContacto = numContacto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
}
