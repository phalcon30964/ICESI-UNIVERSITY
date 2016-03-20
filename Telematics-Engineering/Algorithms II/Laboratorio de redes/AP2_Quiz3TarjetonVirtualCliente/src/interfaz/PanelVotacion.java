package interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelVotacion extends JPanel implements ActionListener{
	private JLabel labCodigo;
	private JTextField txtCodigo;
	private JButton butVotar;
	
	public final static String VOTAR="VOTAR";
	
	private InterfazUrnaVotacion principal;
	
	public PanelVotacion(InterfazUrnaVotacion ventana){
		principal = ventana;
		
		setBorder(new TitledBorder("Votación"));
		setLayout(new BorderLayout());
		
		labCodigo = new JLabel("Código: ");
		txtCodigo = new JTextField();
		butVotar  = new JButton("Votar!");
		
		add(labCodigo, BorderLayout.WEST);
		add(txtCodigo, BorderLayout.CENTER);
		add(butVotar, BorderLayout.EAST);
		
		butVotar.addActionListener(this);
		butVotar.setActionCommand(VOTAR);
	}
	
	public String darCodigoCandidatoElegido(){
		return txtCodigo.getText();
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		
		if(comando.equals(VOTAR)){
			principal.votar();
		}
	}
}
