package modelo;

import java.util.ArrayList;
import java.util.Date;

public class CarroLujo extends Carro {
	
	private ArrayList<Double> impuestos;
	private ArrayList<String> accesorios;
	
	public CarroLujo(int numReferencia, int costo, int modelo,
			String tipoCombustion, String tipoTraccion, String tipoTrasmision, double impuestoIncial) {
		
		super(numReferencia, costo, modelo, tipoCombustion, tipoTraccion, tipoTrasmision);
		impuestos = new ArrayList<Double>();
		impuestos.add(impuestoIncial);
		accesorios = new ArrayList<String>();
		
	}
	
	@Override	
	public double costoTotal(){
		
		Date fecha = new Date();
		
		return costo*(1.10)+costo*(1-((fecha.getYear()-modelo)/100))+getImpuestos() ;
	}
	
	public double getImpuestos(){
		double taxes = 0;
		for (int i = 0; i < impuestos.size(); i++) {
			taxes += costo*impuestos.get(i);
		}
		return taxes;
	}

	public String getAccesorios() {
		
		String msj = "";
		
		for (int i = 0; i < accesorios.size(); i++) {
			msj += accesorios.get(i);
		}
		
		return msj;

	}

	public boolean addImpuesto(double porcentaje){
		return impuestos.add(porcentaje);
	}
	
	public boolean removeImpuesto(double porcentaje){
		return impuestos.remove(porcentaje);
	}
	
	public boolean addAccesorio(String acce){
		return accesorios.add(acce);
	}
	
	public boolean removeAccesorio(String acce){
		return accesorios.remove(acce);
	}



}
