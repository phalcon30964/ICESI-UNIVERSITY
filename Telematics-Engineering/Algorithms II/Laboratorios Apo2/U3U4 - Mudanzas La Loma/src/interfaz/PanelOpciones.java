package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener{
	
	private Ventana ventana;
	private JButton btnOpcionUno;
	private JButton btnOpcionDos;
	private JButton btnOpcionTres;
	
	public PanelOpciones(Ventana vent){
		ventana=vent;
		setBorder(BorderFactory.createTitledBorder("Opciones"));
		setLayout(new GridLayout(1, 5));

		btnOpcionUno = new JButton("Opcion 1");
		btnOpcionUno.setActionCommand("opcion1");
		btnOpcionUno.addActionListener(this);
		
		btnOpcionDos = new JButton("Opcion 2");
		btnOpcionDos.setActionCommand("opcion2");
		btnOpcionDos.addActionListener(this);
		
		btnOpcionTres = new JButton("Opcion 3");
		btnOpcionTres.setActionCommand("opcion3");
		btnOpcionTres.addActionListener(this);

		add(new JLabel(""));
		add(btnOpcionUno);
		add(btnOpcionDos);
		add(btnOpcionTres);
		add(new JLabel(""));
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("opcion1")) {
			ventana.opcion1();

		}
		if (event.getActionCommand().equals("opcion2")) {
			ventana.opcion2();

		} 
		if (event.getActionCommand().equals("opcion3")) {
			ventana.opcion3();
			
		}
	}

}
