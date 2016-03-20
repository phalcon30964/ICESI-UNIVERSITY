package Modelo;

import java.util.ArrayList;

public class Paciente {
	
	
	
	private String nombre;
	private String apellido;
	private String cedula;
	private String direccion;
	private String telefono;
	private String celular;
	private String fechaNacimiento;
	private ArrayList<Cita> citasPaciente;
	
	
	public Paciente(String nom,String ape,String ced,String dir,String tel, String cel, String fec){
		
		
		nombre = nom;
		apellido = ape;
		cedula = ced;
		direccion = dir;
		telefono = tel;
		celular = cel;
		fechaNacimiento = fec;
		citasPaciente = new ArrayList<Cita>();
		
	}
	
	
	
	public void agregarCitaALista(Cita ci){
		
		citasPaciente.add(ci);
		
	}
	
	public void eliminarCitaDeLista(Cita ci){
		
		citasPaciente.remove(ci);
		
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


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public ArrayList<Cita> getCitasPaciente() {
		return citasPaciente;
	}


	public void setCitasPaciente(ArrayList<Cita> citasPaciente) {
		this.citasPaciente = citasPaciente;
	}
	
	
	
	

}
