package modelo;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;


public class Paciente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6414664134093878698L;
	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono;
	private int celular;
	private int id;
	private String fechaNacimiento;
	private TreeSet<Cita> citasPendientes;

	public Paciente(String nombre, String apellido, String direccion,
			int telefono, int celular, int id, String fechaNacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.celular = celular;
		this.id = id;
		this.fechaNacimiento = fechaNacimiento;
		this.citasPendientes = new TreeSet<Cita>();
	}
	
	
	public boolean addCitaPendiente(Cita cita){
		return citasPendientes.add(cita);
	}
	
	public boolean removeCitaPendiente(Cita cita){
		return citasPendientes.remove(cita);
	}
	
	public String getStringCitasPendientes(){
		
		String msj = "";
		try {
			
			Iterator<Cita> it = citasPendientes.iterator();
			Cita actual = it.next();
			
			while(actual!=null){
				msj += "-"+actual.toString();
				actual = it.next();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return msj.substring(0, msj.length());
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public int getCelular() {
		return celular;
	}


	public void setCelular(int celular) {
		this.celular = celular;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public TreeSet<Cita> getCitasPendientes() {
		return citasPendientes;
	}

	public void setCitasPendientes(TreeSet<Cita> citasPendientes) {
		this.citasPendientes = citasPendientes;
	}


	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", apellido=" + apellido
				+ ", direccion=" + direccion + ", telefono=" + telefono
				+ ", celular=" + celular + ", id=" + id + ", fechaNacimiento="
				+ fechaNacimiento + ", citasPendientes=" + citasPendientes
				+ "]";
	}


	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Paciente && this.id==((Paciente)obj).getId()){
			return true;
		}
		return false;
	} 
	
	
	

}
