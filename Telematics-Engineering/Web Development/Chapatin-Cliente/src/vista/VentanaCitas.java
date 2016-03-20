package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class VentanaCitas extends JFrame{

	
	private JButton btCFecha,btregistrarCita;
	private JLabel lbFecha;
	private JList citasFecha;
	private JTextField txFecha;
	
	
	public VentanaCitas() {
		super();
		initialize();
	}
	
	public void initialize(){
		
		setSize(600, 600);
		setTitle("Citas Por Fecha");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,3));
		panel1.setBorder(new TitledBorder("Escoja la Fecha"));
		add(panel1,BorderLayout.NORTH);
		
		lbFecha = new JLabel("Fecha");
		panel1.add(lbFecha);
		
		txFecha = new JTextField("Formato DD-MM-AAAA");
		panel1.add(txFecha);
		
		btCFecha = new JButton("Consultar");
		panel1.add(btCFecha);
		
		
		citasFecha = new JList();
		add(citasFecha,BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		panel2.setBorder(new TitledBorder("Desea registrar cita?"));
		add(panel2,BorderLayout.SOUTH);
		
		btregistrarCita = new JButton("Agregar Esta Cita");
		panel2.add(btregistrarCita);
		
		
	}
	
	public JButton getBtCFecha() {
		return btCFecha;
	}
	public JButton getBtregistrarCita() {
		return btregistrarCita;
	}
	public JList getCitasFecha() {
		return citasFecha;
	}
	public JTextField getTxFecha() {
		return txFecha;
	}
	
	
}
