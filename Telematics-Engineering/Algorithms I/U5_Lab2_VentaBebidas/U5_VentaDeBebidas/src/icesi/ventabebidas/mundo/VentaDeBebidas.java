package icesi.ventabebidas.mundo;

import java.util.ArrayList;

public class VentaDeBebidas {
	private ArrayList <TransaccionBebida> ventas;
	
	public final static String NOMBRE_BEBIDA_UNO="Naranja-Limón";
	public final static String NOMBRE_BEBIDA_DOS="Menta-Limón";
	
	public final static double PRECIO_POR_DEFECTO_BEBIDA_UNO=1000;
	public final static double PRECIO_POR_DEFECTO_BEBIDA_DOS=1500;
	
	public VentaDeBebidas(){
		ventas = new  ArrayList <TransaccionBebida> ();
	}
	
	public void registrarVenta(String nomBeb, int numVasos, double costoVaso){
		double costoVenta = numVasos*costoVaso;
		TransaccionBebida nuevaVenta = new TransaccionBebida(nomBeb,numVasos,costoVenta);
		ventas.add(nuevaVenta);
	}
	
	public double calcularTotalVentasPorBebida(String nombreBebida){
		double totalVentas = 0;
		for(int i=0;i<ventas.size();i++){
			TransaccionBebida tb = (TransaccionBebida)ventas.get(i);
			if(tb.darNombreBebida().equals(nombreBebida)){
				totalVentas += tb.darCostoTransaccion();
			}
		}
		return totalVentas;
	}
	
	public String calcularBebidaMayoresVentas(){
		double ventasUno = calcularTotalVentasPorBebida(NOMBRE_BEBIDA_UNO);
		double ventasDos = calcularTotalVentasPorBebida(NOMBRE_BEBIDA_DOS);
		
		if(ventasUno>ventasDos){
			return NOMBRE_BEBIDA_UNO;
		}else if(ventasDos>ventasUno){
			return NOMBRE_BEBIDA_DOS;
		}else{
			return "Igual en las dos";
		}
	}
	
	private int mayorCantidadVasosEn1VentaPorBebida(String nombreBebida){
		int cantidadMayor = 0;
		for(int i=0;i<ventas.size();i++){
			TransaccionBebida tb = (TransaccionBebida)ventas.get(i);
			if(tb.darNombreBebida().equals(nombreBebida) && tb.darCantidadVasos()>cantidadMayor){
				cantidadMayor = tb.darCantidadVasos();
			}
		}
		return cantidadMayor;
	}
	
	public String calcularMayorCantidadVasosEn1Venta(){
		int cantidadVasosUno = mayorCantidadVasosEn1VentaPorBebida(NOMBRE_BEBIDA_UNO);
		int cantidadVasosDos = mayorCantidadVasosEn1VentaPorBebida(NOMBRE_BEBIDA_DOS);
		
		if(cantidadVasosUno>cantidadVasosDos){
			return cantidadVasosUno+" de "+NOMBRE_BEBIDA_UNO;
		}else if(cantidadVasosDos>cantidadVasosUno){
			return cantidadVasosDos+" de "+NOMBRE_BEBIDA_DOS;
		}else{
			return cantidadVasosUno+" en las dos";
		}
	}
	
	private int calcularCantidadTransaccionesPorBebida(String nombreBebida){
		int cantidad = 0;
		for(int i=0;i<ventas.size();i++){
			TransaccionBebida tb = (TransaccionBebida)ventas.get(i);
			if(tb.darNombreBebida().equals(nombreBebida)){
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public String calcularMayorCantidadTransacciones(){
		int cantidadTransaccionesUno = calcularCantidadTransaccionesPorBebida(NOMBRE_BEBIDA_UNO);
		int cantidadTransaccionesDos = calcularCantidadTransaccionesPorBebida(NOMBRE_BEBIDA_DOS);
		
		if(cantidadTransaccionesUno>cantidadTransaccionesDos){
			return cantidadTransaccionesUno+" de "+NOMBRE_BEBIDA_UNO;
		}else if(cantidadTransaccionesDos>cantidadTransaccionesUno){
			return cantidadTransaccionesDos+" de "+NOMBRE_BEBIDA_DOS;
		}else{
			return cantidadTransaccionesUno+" de las dos";
		}
	}
}
