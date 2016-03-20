package modelo;

import java.util.Date;


public class Cliente extends Persona {
	
	private Date ultimaCompra;
	private String ciudadDespacho;

	public Cliente(String nombre, String apellido, String cedula, String numContacto,
			String direccion,String ciudadDespacho, Date fechaUC) {
		super(nombre, apellido, cedula, numContacto, direccion);
		this.ultimaCompra = fechaUC;
		this.ciudadDespacho = ciudadDespacho;
	}

	public Date getUltimaCompra() {
		return ultimaCompra;
	}

	public void setUltimaCompra(Date ultimaCompra) {
		this.ultimaCompra = ultimaCompra;
	}

	public String getCiudadDespacho() {
		return ciudadDespacho;
	}

	public void setCiudadDespacho(String ciudadDespacho) {
		this.ciudadDespacho = ciudadDespacho;
	}
	

	

}
