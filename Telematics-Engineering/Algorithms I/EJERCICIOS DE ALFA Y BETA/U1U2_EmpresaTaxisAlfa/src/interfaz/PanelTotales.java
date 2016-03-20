package interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelTotales extends JPanel{
	private JLabel labSemana;
	private JLabel labAhorros;
	
	private JLabel labSemanaNm;
	private JTextField txtAhorros;
	
	public PanelTotales(){		
		setBorder(new TitledBorder("Totales"));
		setLayout(new GridLayout(0,2));
		setPreferredSize(new Dimension(150,120));
		
		labSemana = new JLabel("Semana:");
		labAhorros  = new JLabel("Ahorros:");
		
		labSemanaNm = new JLabel("");
		txtAhorros  = new JTextField("");
		
		labSemanaNm.setFont(new Font("Serif", Font.BOLD, 24));
		labSemanaNm.setForeground(Color.GREEN);
		txtAhorros.setEditable(false);

		add(labSemana);
		add(labSemanaNm);
		add(labAhorros);
		add(txtAhorros);		
	}
	
	public void cambiarSemana(int semana){labSemanaNm.setText(""+semana);}
	public void cambiarAhorros(double aho){txtAhorros.setText("$"+aho);}
}
