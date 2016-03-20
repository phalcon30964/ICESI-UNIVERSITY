package uniandes.cupi2.tienda.mundo.interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class PanelCalculos extends JPanel {
	
	private JLabel ingresos;
	private JLabel productoMasVendido;
	private JLabel productoMenosVendito;
	private JLabel promedio;
	
	private JTextField txtIngresos;
	private JTextField txtProductoMasVendido;
	private JTextField txtProductoMenosVendido;
	private JTextField txtPromedio;
	
	public PanelCalculos(){
		
		TitledBorder bordesito = new TitledBorder("Cálculos");
		bordesito.setTitleColor(Color.WHITE);
		setBorder(bordesito);
		
		setLayout(new GridLayout(4,2));
		
		ingresos = new JLabel("Ingresos");
		ingresos.setForeground(Color.WHITE);
		
		productoMasVendido = new JLabel("Producto más vendido");
		productoMasVendido.setForeground(Color.WHITE);
		
		productoMenosVendito = new JLabel("Producto menos vendido");
		productoMenosVendito.setForeground(Color.WHITE);
		
		promedio = new JLabel("Promedio");
		promedio.setForeground(Color.WHITE);
		
		txtIngresos = new JTextField();
		txtIngresos.setBackground(Color.BLACK);
		txtIngresos.setForeground(Color.WHITE);
		
	    txtProductoMasVendido = new JTextField();
	    txtProductoMasVendido.setBackground(Color.BLACK);
	    txtProductoMasVendido.setForeground(Color.WHITE);
	    
		txtProductoMenosVendido = new JTextField();
		txtProductoMenosVendido.setBackground(Color.BLACK);
		txtProductoMenosVendido.setForeground(Color.WHITE);
		
		txtPromedio = new JTextField();
		txtPromedio.setBackground(Color.BLACK);
		txtPromedio.setForeground(Color.WHITE);
		
		add(ingresos);
		add(txtIngresos);
		
		add(productoMasVendido);
		add(txtProductoMasVendido);
		
		add(productoMenosVendito);
		add(txtProductoMenosVendido);
		
	}
	

	
}
