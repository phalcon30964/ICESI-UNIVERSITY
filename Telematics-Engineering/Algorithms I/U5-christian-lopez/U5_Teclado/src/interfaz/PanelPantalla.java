package interfaz;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelPantalla extends JPanel{
	
	private JTextField txtPantalla;
	private JButton butLimpiar;
	
	public final static String LIMPIAR="LIMPIAR";
	
	public PanelPantalla(){
		TitledBorder borde = new TitledBorder("Pantalla");
		setBorder(borde);
		
		setLayout(new BorderLayout());
		
		txtPantalla = new JTextField();
		butLimpiar  = new JButton("Limpiar");
		
		add(txtPantalla, BorderLayout.CENTER);
		add(butLimpiar, BorderLayout.EAST);
	}
}
