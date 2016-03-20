package interfaz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelAbecedario extends JPanel{
	private JButton[] letras;
	
	public final static String ABECEDARIO = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	
	public PanelAbecedario(){
		setBorder(new TitledBorder("Abecedario"));
		setLayout(new GridLayout(3,ABECEDARIO.length()/3));
		
		letras = new JButton[ABECEDARIO.length()];
		
		for(int i=0;i<letras.length;i++){
			letras[i] = new JButton(ABECEDARIO.charAt(i)+"");
			add(letras[i]);
		}
	}
}
