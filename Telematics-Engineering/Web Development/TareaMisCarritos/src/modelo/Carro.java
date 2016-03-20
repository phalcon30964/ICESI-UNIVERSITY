package modelo;

import java.util.Date;

public class Carro {

	protected int numReferencia;
	protected int costo;
	protected int modelo;
	protected String tipoCombustion;
	protected String tipoTraccion;
	protected String tipoTransmision;
	
	

	public Carro(int numReferencia, int costo, int modelo,
			String tipoCombustion, String tipoTraccion, String tipoTransmision) {

		this.numReferencia = numReferencia;
		this.costo = costo;
		this.modelo = modelo;
		this.tipoCombustion = tipoCombustion;
		this.tipoTraccion = tipoTraccion;
		this.tipoTransmision = tipoTransmision;
	}
	

	public double costoTotal(){
		Date fecha = new Date();
		return (costo + costo*(1-((fecha.getYear()-modelo)/100)));
	}


	public int getNumReferencia() {
		return numReferencia;
	}


	public void setNumReferencia(int numReferencia) {
		this.numReferencia = numReferencia;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}


	public int getModelo() {
		return modelo;
	}


	public void setModelo(int modelo) {
		this.modelo = modelo;
	}


	public String getTipoCombustion() {
		return tipoCombustion;
	}


	public void setTipoCombustion(String tipoCombustion) {
		this.tipoCombustion = tipoCombustion;
	}


	public String getTipoTraccion() {
		return tipoTraccion;
	}


	public void setTipoTraccion(String tipoTraccion) {
		this.tipoTraccion = tipoTraccion;
	}


	public String getTipoTransmision() {
		return tipoTransmision;
	}


	public void setTipoTransmision(String tipoTransmision) {
		this.tipoTransmision = tipoTransmision;
	}

	
	
	
	
}
