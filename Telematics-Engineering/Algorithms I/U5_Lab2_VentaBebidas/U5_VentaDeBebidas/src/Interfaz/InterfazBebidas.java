package Interfaz;

import javax.swing.*;
import java.awt.*;

import icesi.ventabebidas.mundo.*;

public class InterfazBebidas extends JFrame {
	
	//Atributos
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelVentaBebidaUno panelVentaBebidaUno;
	private PanelVentaBebidaDos panelVentaBebidaDos;
	private PanelEncabezado panelEncabezado;
	private PanelReportes panelReportes;
	
	//Relacion al mundo
	
	private VentaDeBebidas mundo;

	//Constructor
	
	public InterfazBebidas(){
		
		//Inicializo el mundo
		
		mundo = new VentaDeBebidas();
		
		//Configuracion de la ventana
		
		setTitle("Venta de Refrescos : Desarrollado Christian Lopez");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//Incialiacion de atributos
		
		panelVentaBebidaUno = new PanelVentaBebidaUno(this);
		panelVentaBebidaDos = new PanelVentaBebidaDos(this);
		panelEncabezado = new PanelEncabezado();
		panelReportes = new PanelReportes();

		//Agregar atributos
		add(panelVentaBebidaUno, BorderLayout.WEST);
		add(panelVentaBebidaDos, BorderLayout.EAST);
		add(panelEncabezado, BorderLayout.NORTH);
		add(panelReportes, BorderLayout.CENTER);
		
		//Tamaño
		pack();
	}
	
	public void gestionarVenta1VasoBebidaUno(){
			
		try{
		
		//Obtengo valor del panel
		String c = panelVentaBebidaUno.darCostoVaso();
		c.trim();
		//Convierto el valor 
		double costo = Double.parseDouble(c);
		//Modifico el mundo
		mundo.registrarVenta(mundo.NOMBRE_BEBIDA_UNO, 1, mundo.PRECIO_POR_DEFECTO_BEBIDA_UNO);
		//Refresco los paneles
				panelReportes.refrescarVentasBebidaUno(mundo.calcularTotalVentasPorBebida(mundo.NOMBRE_BEBIDA_UNO));
				panelReportes.refrescarBebidaConMasVentas(mundo.calcularBebidaMayoresVentas());
				panelReportes.refrescarMayorVasoEn1Venta(mundo.calcularMayorCantidadVasosEn1Venta());
				panelReportes.refrescarMasTransacciones(mundo.calcularMayorCantidadTransacciones());
		
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(this, "El costo del vaso debe ser un valor numerico", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void gestionarVentaVariosVasosBebidaUno(){
		
		try{
		//Obtengo informacion de los paneles
			
		String cant = panelVentaBebidaUno.darCantidadVasos();
		cant.trim();
		String cost = panelVentaBebidaUno.darCostoVaso();
		cost.trim();
		
		//Convierto informacion
		
		int cantidad = Integer.parseInt(cant);
		double costo = Double.parseDouble(cost);
		
		//Modifico el mundo
		
		mundo.registrarVenta(mundo.NOMBRE_BEBIDA_UNO, cantidad, costo);
		
		//Refresco paneles
		panelReportes.refrescarVentasBebidaUno(mundo.calcularTotalVentasPorBebida(mundo.NOMBRE_BEBIDA_UNO));
		panelReportes.refrescarBebidaConMasVentas(mundo.calcularBebidaMayoresVentas());
		panelReportes.refrescarMayorVasoEn1Venta(mundo.calcularMayorCantidadVasosEn1Venta());
		panelReportes.refrescarMasTransacciones(mundo.calcularMayorCantidadTransacciones());
		
		}catch(Exception e){
			
			JOptionPane.showMessageDialog(this, "La cantidad de vasos y el valor de costo deben ser valores numericos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void gestionarVenta1VasoBebidaDos(){
		
		try{
			
		String costo = panelVentaBebidaDos.darCostoVaso();
		costo.trim();
		double cost = Double.parseDouble(costo);
		
		mundo.registrarVenta(mundo.NOMBRE_BEBIDA_DOS, 1, cost);
		
		panelReportes.refrescarVentasBebidaDos(mundo.calcularTotalVentasPorBebida(mundo.NOMBRE_BEBIDA_DOS));
		panelReportes.refrescarBebidaConMasVentas(mundo.calcularBebidaMayoresVentas());
		panelReportes.refrescarMayorVasoEn1Venta(mundo.calcularMayorCantidadVasosEn1Venta());
		panelReportes.refrescarMasTransacciones(mundo.calcularMayorCantidadTransacciones());
		
		}catch(Exception error){
			JOptionPane.showMessageDialog(this, "El costo del vaso debe ser un valor numerico", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
	
	public void gestionarVentaVariosVasosBebidaDos(){
		
		
		try{
			
			String costo = panelVentaBebidaDos.darCostoVaso();
			costo.trim();
			
			String cantidad = panelVentaBebidaDos.darCantidadVasos();
			cantidad.trim();
			
			double cost = Double.parseDouble(costo);
			int cant = Integer.parseInt(cantidad);
			
			mundo.registrarVenta(mundo.NOMBRE_BEBIDA_DOS, cant, cost);
		
			panelReportes.refrescarVentasBebidaDos(mundo.calcularTotalVentasPorBebida(mundo.NOMBRE_BEBIDA_DOS));
			panelReportes.refrescarBebidaConMasVentas(mundo.calcularBebidaMayoresVentas());
			panelReportes.refrescarMayorVasoEn1Venta(mundo.calcularMayorCantidadVasosEn1Venta());
			panelReportes.refrescarMasTransacciones(mundo.calcularMayorCantidadTransacciones());
			
		}catch(Exception error){
			JOptionPane.showMessageDialog(this, "El costo del vaso debe ser un valor numerico", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

		}
		
	}
	
	public static void main (String[] args){
		
		InterfazBebidas ventana = new InterfazBebidas();
		ventana.setVisible(true);
		
	}
	
	
}
