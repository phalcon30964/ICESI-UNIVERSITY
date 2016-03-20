package interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelTaxi extends JPanel{
	
	private JLabel labImagen;
	private JLabel labPlaca;
	private JLabel labModelo;
	
	private JTextField txtPlaca;
	private JTextField txtModelo;
	
	public PanelTaxi(String nombre){
		setBorder(new TitledBorder(nombre));
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(270,120));
		
		JPanel panImagen = new JPanel();
		panImagen.setLayout(new BorderLayout());
		labImagen = new JLabel(new ImageIcon("data/img/taxi.png"));
		panImagen.add(labImagen,BorderLayout.CENTER);
		add(panImagen,BorderLayout.WEST);
		
		JPanel panInfo = new JPanel();
		panInfo.setLayout(new GridLayout(0,2));
		labPlaca      = new JLabel("Placa:");
		labModelo     = new JLabel("Modelo:");
		
		txtPlaca      = new JTextField("");
		txtModelo     = new JTextField("");
		
		txtPlaca.setEditable(false);
		txtModelo.setEditable(false);
				
		panInfo.add(labPlaca);
		panInfo.add(txtPlaca);
		panInfo.add(labModelo);
		panInfo.add(txtModelo);
		
		add(panInfo,BorderLayout.CENTER);
	}
	
	public void cambiarPlaca(String p){txtPlaca.setText(p);}
	public void cambiarModelo(int m){txtModelo.setText(""+m);}
}
