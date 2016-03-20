package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelConductor extends JPanel{
	
	private JLabel labImagen;
	private JLabel labNombre;
	private JLabel labAhorro;
	private JLabel labRetiro;
	
	private JTextField txtNombre;
	private JTextField txtAhorro;
	private JTextField txtRetiro;
	
	public PanelConductor(String nombre){
		setBorder(new TitledBorder(nombre));
		setLayout(new BorderLayout());
		
		JPanel panImagen = new JPanel();
		panImagen.setLayout(new BorderLayout());
		labImagen = new JLabel(new ImageIcon("data/img/conductor.jpg"));
		panImagen.add(labImagen,BorderLayout.CENTER);
		add(panImagen,BorderLayout.WEST);
		
		JPanel panInfo = new JPanel();
		panInfo.setLayout(new GridLayout(0,2));
		labNombre = new JLabel("Nombre:");
		labAhorro = new JLabel("Ahorro:");
		labRetiro = new JLabel("Retiro: $");
		
		txtNombre = new JTextField("");
		txtAhorro = new JTextField("");
		txtRetiro = new JTextField("");
		
		txtNombre.setEditable(false);
		txtAhorro.setEditable(false);
				
		panInfo.add(labNombre);
		panInfo.add(txtNombre);
		panInfo.add(labAhorro);
		panInfo.add(txtAhorro);
		panInfo.add(labRetiro);
		panInfo.add(txtRetiro);
		
		add(panInfo,BorderLayout.CENTER);
	}
	
	public void cambiarNombre(String n){txtNombre.setText(n);}
	public void cambiarAhorro(double a){txtAhorro.setText("$"+a);}
	public void limpiarRetiro(){txtRetiro.setText("");}
	
	public String darRetiro(){
		return txtRetiro.getText();
	}
}
