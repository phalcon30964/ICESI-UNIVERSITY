package uniandes.cupi2.tienda.mundo.interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

public class PanelProductos extends JPanel{
	
	private JLabel productos;
	private JLabel cantidad;
	private JLabel Iva;
	private JLabel Precio;
	private JLabel Pedido;
	private JTextField[] tabla;
	
	public final static int TABLA_TAM = 20;
	
	public PanelProductos(){
		TitledBorder borde = new TitledBorder("Productos");
		setBorder(borde);
		
		productos = new JLabel("Producto");
		//productos.setForeground(Color.WHITE);
		
		cantidad = new JLabel("Cantidad");
		//cantidad.setForeground(Color.WHITE);
		
		Iva = new JLabel("Iva");
		//Iva.setForeground(Color.WHITE);
		
		Precio = new JLabel("Precio");
		//Precio.setForeground(Color.WHITE);
		
		Pedido = new JLabel("Pedido");
		//Pedido.setForeground(Color.WHITE);
		
		tabla = new JTextField[TABLA_TAM];
	
		
		setLayout(new GridLayout(5,5));
		
		add(productos);
		add(cantidad);
		add(Iva);
		add(Precio);
		add(Pedido);
		
		for (int i = 0; i < TABLA_TAM; i++) {
			tabla[i]= new JTextField();
			tabla[i].setForeground(Color.WHITE);
			tabla[i].setBackground(Color.BLACK);
			
			add(tabla[i]);
		}
	}

}
