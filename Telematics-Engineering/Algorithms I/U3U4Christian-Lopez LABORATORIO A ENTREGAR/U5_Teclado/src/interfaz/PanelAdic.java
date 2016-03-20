package interfaz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelAdic extends JPanel{
	private JButton butBorrar;
	private JButton butEspacio;
	private JButton butCero;
	
	public final static String BORRAR="BORRAR";
	public final static String ESPACIO="ESPACIO";
	public final static String CERO="CERO";
	
	public PanelAdic(){
		setBorder(new TitledBorder("Adic."));
		setLayout(new GridLayout(3,1));
		
		butBorrar  = new JButton("<=");
		butEspacio = new JButton("=>");
		butCero    = new JButton("0");
		
		add(butBorrar);
		add(butEspacio);
		add(butCero);
	}
}
