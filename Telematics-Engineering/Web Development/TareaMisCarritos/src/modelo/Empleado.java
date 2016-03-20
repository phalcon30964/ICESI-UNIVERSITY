package modelo;

import java.util.Date;

public class Empleado extends Persona {
	
	private double comision;
	private Date ultimaCompra;
	private int totalVentas;
	
	public Empleado(String nombre, String apellido, String cedula, String numContacto,
			String direccion, double comision, Date fechaV) {
		
		super(nombre, apellido, cedula, numContacto, direccion);
		this.comision = comision;
		ultimaCompra = fechaV;
		totalVentas = 0;
		
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public Date getUltimaCompra() {
		return ultimaCompra;
	}

	public void setUltimaCompra(Date ultimaCompra) {
		this.ultimaCompra = ultimaCompra;
	}

	public int getTotalVentas() {
		return totalVentas;
	}

	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}
	
	
	

}
