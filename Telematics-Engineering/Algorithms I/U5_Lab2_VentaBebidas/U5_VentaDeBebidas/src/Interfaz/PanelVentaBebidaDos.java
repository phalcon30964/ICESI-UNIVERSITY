package Interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelVentaBebidaDos extends JPanel implements ActionListener{
	
	//Relacion a la ventana
	
		private InterfazBebidas interfaz;
		
		//Constantes
		
		public final static String VENDER_1_VASO = "vender 1 vaso";
		public final static String VENDER_VARIOS = "vender varios";
		
		//Atributos
		
		private JLabel labImagenProducto;
		private JLabel labPrecioUnidad;
		
		private JButton butVender1Vaso;
		private JButton butVenderVarios;
		
		private JTextField txtVenderVarios;
		private JTextField txtPrecioUnidad;
		
		//Constructor
		
		public PanelVentaBebidaDos (InterfazBebidas b){
			
			//Inicializacion de la relacion a la ventana
			
			interfaz = b;
			
			//Ajustes del panel
			
			TitledBorder titulo = new TitledBorder("Venta Menta-Limón");
			setBorder(titulo);
			setLayout(new BorderLayout());
			
			//Inicializacion de los atributos
			
			ImageIcon imagen = new ImageIcon("img/bebidaDos.jpg");
			labImagenProducto = new JLabel(imagen);
			labPrecioUnidad = new JLabel("Costo:");
			
			butVender1Vaso = new JButton("1 Vaso");
			butVender1Vaso.setActionCommand(VENDER_1_VASO);
			butVender1Vaso.addActionListener(this);
			
			butVenderVarios = new JButton("+Vasos");
			butVenderVarios.setActionCommand(VENDER_VARIOS);
			butVenderVarios.addActionListener(this);
			
			//Para los textos puse como inicial el valor por defecto y el 
			//numero de vasos 2 porque ya hay boton para uno solo
			
			txtVenderVarios = new JTextField();
			txtPrecioUnidad = new JTextField("1500");
			
			//Creo un panel interno para aplicar un gridlayout
			
			JPanel interno = new JPanel();
			interno.setLayout(new GridLayout(2,2));
			interno.add(butVenderVarios);
			interno.add(txtVenderVarios);
			interno.add(labPrecioUnidad);
			interno.add(txtPrecioUnidad);
			
			//Anado elementos al panel
			
			add(labImagenProducto, BorderLayout.NORTH);
			add(butVender1Vaso, BorderLayout.CENTER);
			add(interno, BorderLayout.SOUTH);		
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			
			String evento = event.getActionCommand();
			
			if(evento.equals(VENDER_1_VASO)){
				
				interfaz.gestionarVenta1VasoBebidaDos();
				
			}else if(evento.equals(VENDER_VARIOS)){
			
				interfaz.gestionarVentaVariosVasosBebidaDos();
				
			}
			
		}
		
		public String darCostoVaso(){
			
			return txtPrecioUnidad.getText();
			
		}
		
		public String darCantidadVasos(){
			
			return txtVenderVarios.getText();
		}

}
