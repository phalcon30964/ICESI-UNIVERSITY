package interfaz;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelVenta extends JPanel implements ActionListener{
	private JLabel labImagenCafetera; 
	
	private JButton butVenta;
	private JButton butDinero;
	private JButton butVendidos;
	
	private InterfazCafetera principal;
	
	public final static String VENDER_CAFE    = "VENDER_CAFE";
	public final static String DINERO_VENTAS  = "DINERO_VENTAS";
	public final static String CAFES_VENDIDOS = "CAFES_VENDIDOS";
	
	public PanelVenta(InterfazCafetera ventana){
		principal = ventana;
		
		setLayout(new BorderLayout());
		setBorder(new TitledBorder("Venta"));
		
		JPanel panArriba = new JPanel();
		panArriba.setLayout(new GridLayout(0,1));
		panArriba.add(new JLabel("Dr. Café S.A. le ofrece"));
		panArriba.add(new JLabel("a través de Vending Inc."));
		panArriba.add(new JLabel("de Colombia una de las"));
		panArriba.add(new JLabel("máquinas dispensadoras"));
		panArriba.add(new JLabel("de café mas modernas"));
		panArriba.add(new JLabel("del mercado."));
		add(panArriba,BorderLayout.NORTH);
		
		labImagenCafetera = new JLabel(new ImageIcon("data/img/cafetera.jpg"));
		add(labImagenCafetera,BorderLayout.CENTER);
		
		JPanel panBotones = new JPanel();
		panBotones.setLayout(new GridLayout(0,1));
		butVenta    = new JButton("Vender Café");
		butDinero   = new JButton("Total Ventas");
		butVendidos = new JButton("# Vendidos");
		
		panBotones.add(butVenta);
		panBotones.add(butDinero);
		panBotones.add(butVendidos);
		
		butVenta.addActionListener(this);
		butDinero.addActionListener(this);
		butVendidos.addActionListener(this);
		
		butVenta.setActionCommand(VENDER_CAFE);
		butDinero.setActionCommand(DINERO_VENTAS);
		butVendidos.setActionCommand(CAFES_VENDIDOS);

		add(panBotones,BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent evento){
		String comando = evento.getActionCommand();
		if(comando.equals(VENDER_CAFE)){
			principal.venderCafe();
		}else if(comando.equals(DINERO_VENTAS)){
			principal.reporteDineroVentas();			
		}else if(comando.equals(CAFES_VENDIDOS)){
			principal.reporteCafesVendidos();			
		} 
	}
}
