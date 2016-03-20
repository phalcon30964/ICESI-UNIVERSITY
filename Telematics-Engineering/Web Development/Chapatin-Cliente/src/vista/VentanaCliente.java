package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class VentanaCliente extends JFrame{

	private JLabel lbCliente;
	
	private JLabel lbNyA;
	
	private JLabel lbCedula;
	
	private JLabel lbCedulaCli;
	
	private JList lsCitas;
	
	private JButton btNCita;
	
	private JButton btEcita;
	
	public VentanaCliente(){
		super();
		initialize();
	}
	
	public void initialize(){
		
		setTitle("Cliente");
		setSize(600,200);
		getContentPane().setLayout(new GridLayout(1,2));
		setResizable(false);
		
		JPanel panel1 = new JPanel();
		panel1.setBorder(new TitledBorder("Info Cliente"));
		panel1.setLayout(new GridLayout(3,2));
		getContentPane().add(panel1);
		
		lbCliente = new JLabel("Cliente:");
		panel1.add(lbCliente);
		
		lbNyA = new JLabel(" ");
		lbNyA.setBackground(Color.GREEN);
		panel1.add(lbNyA);
		
		lbCedula = new JLabel("Cedula No:");
		panel1.add(lbCedula);
		
		lbCedulaCli = new JLabel("");
		lbCedulaCli.setBackground(Color.RED);
		panel1.add(lbCedulaCli);
		
		btNCita = new JButton("Nueva Cita");
		panel1.add(btNCita);
		
		btEcita = new JButton("Cancelar Cita");
		panel1.add(btEcita);
		
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder("Citas"));
		panel2.setLayout(new BorderLayout());
		getContentPane().add(panel2);
		
		lsCitas = new JList();
		panel2.add(lsCitas,BorderLayout.CENTER);
		pack();
		
	}

	public JLabel getLbNyA() {
		return lbNyA;
	}

	public JLabel getLbCedulaCli() {
		return lbCedulaCli;
	}

	public JButton getBtNCita() {
		return btNCita;
	}

	public JButton getBtEcita() {
		return btEcita;
	}

	public JList getLsCitas() {
		return lsCitas;
	}
	
	
	
}
