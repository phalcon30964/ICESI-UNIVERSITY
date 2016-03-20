package uniandes.cupi2.tienda.mundo.interfaz;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOperaciones extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton venderProducto;
	private JButton opcion1;
	private JButton pedirProducto;
	private JButton opcion2;
	
	public final static String VENDER_PRODUCTO = "VENDER PRODUCTO";
	public final static String OPCION1 = "OPCION 1";
	public final static String PEDIR_PRODUCTO = "PEDIR PRDOCUTO";
	public final static String OPCION2 = "OPCION 2";
	

	public PanelOperaciones(){
		
		TitledBorder bordesito = new TitledBorder("Operaciones");
		bordesito.setTitleColor(Color.YELLOW);
		setBorder(bordesito);
		
		venderProducto = new JButton("Vender Producto");
		//venderProducto.setForeground(Color.YELLOW);
		venderProducto.addActionListener(this);
		venderProducto.setActionCommand(VENDER_PRODUCTO);
		
		opcion1 = new JButton("Opción 1");
		//opcion1.setForeground(Color.YELLOW);
		opcion1.addActionListener(this);
		opcion1.setActionCommand(OPCION1);
		
		pedirProducto = new JButton("Pedir Producto");
		//pedirProducto.setForeground(Color.YELLOW);
		pedirProducto.addActionListener(this);
		pedirProducto.setActionCommand(PEDIR_PRODUCTO);
		
		opcion2 = new JButton("Opción 2");
		//opcion2.setForeground(Color.YELLOW);
		opcion2.addActionListener(this);
		opcion2.setActionCommand(OPCION2);
		
		setLayout(new GridLayout(2,2));
	
		add(venderProducto);
		add(opcion1);
		add(pedirProducto);
		add(opcion2);

		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();
		
		if(cmd.equals(VENDER_PRODUCTO)){
			JOptionPane.showMessageDialog(this, VENDER_PRODUCTO);
		}
		
		if(cmd.equals(OPCION1)){
			JOptionPane.showMessageDialog(this, OPCION1);
		}
		
		if(cmd.equals(PEDIR_PRODUCTO)){
			JOptionPane.showMessageDialog(this, PEDIR_PRODUCTO);
		}
		
		if(cmd.equals(OPCION2)){
			JOptionPane.showMessageDialog(this, OPCION2);
		}
		
	}
	


}
