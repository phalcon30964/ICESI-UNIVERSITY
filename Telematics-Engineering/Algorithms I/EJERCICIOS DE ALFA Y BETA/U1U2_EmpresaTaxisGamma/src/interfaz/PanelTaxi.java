package interfaz;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelTaxi extends JPanel{
	
	private JLabel labImagen;
	private JLabel labPlaca;
	private JLabel labModelo;
	private JLabel labIngresos;
	private JLabel labGastos;
	
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtIngresos;
	private JTextField txtGastos;
	
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
		labIngresos   = new JLabel("Ingresos:");
		labGastos     = new JLabel("Gastos:");
		
		txtPlaca      = new JTextField("");
		txtModelo     = new JTextField("");
		txtIngresos   = new JTextField("");
		txtGastos     = new JTextField("");
		
		txtPlaca.setEditable(false);
		txtModelo.setEditable(false);
		txtIngresos.setEditable(false);
		txtGastos.setEditable(false);
				
		panInfo.add(labPlaca);
		panInfo.add(txtPlaca);
		panInfo.add(labModelo);
		panInfo.add(txtModelo);
		panInfo.add(labIngresos);
		panInfo.add(txtIngresos);
		panInfo.add(labGastos);
		panInfo.add(txtGastos);
		
		add(panInfo,BorderLayout.CENTER);
	}
	
	public void cambiarPlaca(String p){txtPlaca.setText(p);}
	public void cambiarModelo(int m){txtModelo.setText(""+m);}
	public void cambiarIngresos(double i){txtIngresos.setText("$"+i);}
	public void cambiarGastos(double g){txtGastos.setText("$"+g);}
}
