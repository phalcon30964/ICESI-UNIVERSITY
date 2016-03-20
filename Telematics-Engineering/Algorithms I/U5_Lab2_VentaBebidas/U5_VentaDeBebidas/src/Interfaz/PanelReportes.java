package Interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class PanelReportes extends JPanel {
	
	//Atributos
	
	private JLabel labVentasUno;
	private JLabel labVentasDos;
	private JLabel labMayoresVentas;
	private JLabel labMasVasos1Venta;
	private JLabel labMasTransacciones;
	 
	private JTextField txtVentasUno;
	private JTextField txtVentasDos;
	private JTextField txtMayoresVentas;
	private JTextField txtMasVasos1Venta;
	private JTextField txtMasTransacciones;
	
	//Constructor
	
	public PanelReportes(){
		
		//Configuracion del panel
		
		TitledBorder titulo = new TitledBorder("Reportes");
		setBorder(titulo);
		setLayout(new GridLayout(5,2));
		
		//Inicializacion de los atributos
		
		labVentasUno = new JLabel("Naranja-Limón:");
		labVentasDos = new JLabel("Menta-Limón:");
		labMayoresVentas = new JLabel("Mayores Ventas:");
		labMasVasos1Venta = new JLabel("+Vasos en 1 Venta:");
		labMasTransacciones = new JLabel("+Transacciones:");
		 
		txtVentasUno = new JTextField("$ 0");
		txtVentasUno.setEditable(false);
		
		txtVentasDos = new JTextField("$ 0");
		txtVentasDos.setEditable(false);
		
		txtMayoresVentas = new JTextField();
		txtMayoresVentas.setEditable(false);
		
		txtMasVasos1Venta = new JTextField();
		txtMasVasos1Venta.setEditable(false);
		
		txtMasTransacciones = new JTextField();
		txtMasTransacciones.setEditable(false);
		
		//Agrego los atributos
		
		add(labVentasUno);
		add(txtVentasUno);
		add(labVentasDos);
		add(txtVentasDos);
		add(labMayoresVentas);
		add(txtMayoresVentas);
		add(labMasVasos1Venta);
		add(txtMasVasos1Venta);
		add(labMasTransacciones);
		add(txtMasTransacciones);
	}
	
	public void refrescarVentasBebidaUno(double d){
		
		txtVentasUno.setText("$ "+d);
		
	}
	
	public void refrescarVentasBebidaDos(double d){
		
		txtVentasDos.setText("$ "+d);
	}
	
	public void refrescarBebidaConMasVentas(String s){
		
		txtMayoresVentas.setText(s);
	}
	
	public void refrescarMayorVasoEn1Venta(String s){
		
		txtMasVasos1Venta.setText(s);		
	}
	
	public void refrescarMasTransacciones(String s){
		
		txtMasTransacciones.setText(s);
	}
}
