package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Concesionario {
	
	public final static String COMB_GASOLINA = "Gasolina";
	public final static String COMB_DIESEL = "Diesel";
	
	public final static String TRAC_4X4 = "4X4";
	public final static String TRAC_2X4 = "2X4";
	
	public final static String AUTOMATICO = "Automatico";
	public final static String MANUAL = "Manual";
	
	private ArrayList<Persona> listaPersonas;
	private ArrayList<Carro> listaCarros;
	
	public Concesionario() {
		this.listaPersonas = new ArrayList<Persona>();
		this.listaCarros = new ArrayList<Carro>();
	}
	

	public ArrayList<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(ArrayList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public ArrayList<Carro> getListaCarros() {
		return listaCarros;
	}

	public void setListaCarros(ArrayList<Carro> listaCarros) {
		this.listaCarros = listaCarros;
	}

	public boolean addCliente(String nombre, String apellido, String cedula, String numContacto, 
			String direccion, String ciudadDespacho, Date fechaUC){		
		return listaPersonas.add(new Cliente(nombre, apellido, cedula, numContacto, direccion, ciudadDespacho, fechaUC));
	}
	
	public boolean addEmpleado(String nombre, String apellido, String cedula, String numContacto, 
			String direccion, double comision, Date fechaV){
		return listaPersonas.add(new Empleado(nombre, apellido, cedula, numContacto, direccion, comision, fechaV));
	}
	
	public boolean addCarro(int numReferencia, int costo, int modelo,
			String tipoCombustion, String tipoTraccion, String tipoTransmision){
		return listaCarros.add(new Carro(numReferencia, costo, modelo, tipoCombustion, tipoTraccion, tipoTransmision));
	}
	
	public boolean addCarroLujo(int numReferencia, int costo, int modelo,
			String tipoCombustion, String tipoTraccion, String tipoTrasmision, double impuestoIncial){
		return listaCarros.add(new CarroLujo(numReferencia, costo, modelo, tipoCombustion, tipoTraccion, tipoTrasmision, impuestoIncial));
	}
	
	public boolean removePersona(String nombre){
		for (int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getNombre().equalsIgnoreCase(nombre)){
				listaPersonas.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Persona searchPersona(String nombre){
		for (int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i).getCedula().equalsIgnoreCase(nombre)){		
				return listaPersonas.get(i);
			}
		}	
		return null;
	}
	
	public boolean removeCarro(int numReferencia){	
		for (int i = 0; i < listaCarros.size(); i++) {
			if(listaCarros.get(i).getNumReferencia()==numReferencia){
				listaCarros.remove(i);
				return true;
			}
		}
		return false;	
	}
	
	public Carro searchCarro(int numReferencia){	
		for (int i = 0; i < listaCarros.size(); i++) {
			if(listaCarros.get(i).getNumReferencia()==numReferencia){
				return listaCarros.get(i);
			}
		}
		return null;
	}
	
}
