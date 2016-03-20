package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelCandidatos extends JPanel{

	private ArrayList<JLabel> butCandidatosCodigo;
	private ArrayList<JLabel> butCandidatosNombre;
	private ArrayList<JLabel> butCandidatosPartido;
	private ArrayList<JLabel> butCandidatosVotos;
	
	public PanelCandidatos(){
		setBorder(new TitledBorder("Candidatos"));
		setLayout(new GridLayout(0,3, 5, 5)); //con 0 consigo filas indeterminadas en el grid
		
		butCandidatosCodigo  = new ArrayList<JLabel>();
		butCandidatosNombre  = new ArrayList<JLabel>();
		butCandidatosPartido = new ArrayList<JLabel>();
		butCandidatosVotos   = new ArrayList<JLabel>();
	}
	
	public void agregarCandidato(String codigo, String nombre, String partido, int votos){
		JLabel labCodigo  = new JLabel(codigo);
		JLabel labNombre  = new JLabel(nombre);
		JLabel labPartido = new JLabel(partido);
		JLabel labVotos   = new JLabel(votos+" Votos");
		
		labCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		labNombre.setHorizontalAlignment(SwingConstants.CENTER);
		labPartido.setHorizontalAlignment(SwingConstants.CENTER);
		labVotos.setHorizontalAlignment(SwingConstants.CENTER);
		
		butCandidatosCodigo.add(labCodigo);
		butCandidatosNombre.add(labNombre);
		butCandidatosPartido.add(labPartido);
		butCandidatosVotos.add(labVotos);
		
		JPanel panelInterno = new JPanel();
		panelInterno.setLayout(new GridLayout(4,1));
		panelInterno.setBorder(new LineBorder(Color.GRAY));
		
		panelInterno.add(labCodigo);
		panelInterno.add(labNombre);
		panelInterno.add(labPartido);
		panelInterno.add(labVotos);
		
		add(panelInterno);
	}
	
	public void actualizarVotos(int pos, int votos){
		JLabel labVotosActualizar = butCandidatosVotos.get(pos);
		labVotosActualizar.setText(votos+" Votos");
	}
}
