package interfaz;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelUltimaVotacion extends JPanel{
	private JLabel labInfoVotacion;
	
	public PanelUltimaVotacion(){
		setBorder(new TitledBorder("Ultima Votación"));
		setLayout(new BorderLayout());
		
		labInfoVotacion = new JLabel("No se ha realizado ningúna votación aún.");
		
		add(labInfoVotacion);
	}
	
	public void refrescarInfoVotacion(String infoVotacion){
		labInfoVotacion.setText(infoVotacion);
	}
}
