package Interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelResultados extends JPanel{
	
	private JLabel labFahrenheit;
	private JLabel labKelvin;
	private JTextField txtFahrenheit;
	private JTextField txtKelvin;

	public PanelResultados(){
		
		setBorder(new TitledBorder("Resultados" ));
		
		labFahrenheit = new JLabel("      Frahrenheit:      ");
		labKelvin = new JLabel("      Kelvin:      ");
		txtFahrenheit = new JTextField ();
		txtFahrenheit.setEditable(false);
		txtKelvin = new JTextField();
		txtKelvin.setEditable(false);
		
		setLayout(new GridLayout( 2 , 2));
		
		add(labFahrenheit);
		add(txtFahrenheit);
		add(labKelvin);
		add(txtKelvin);
	}
	
	public void refrescarKelvin(double o){
		txtFahrenheit.setText(o+"");
	}

	public void refrescarFahrenheit(double o){
		txtKelvin.setText(o+"");
	}
	
	
	
	
	
	
	


}
