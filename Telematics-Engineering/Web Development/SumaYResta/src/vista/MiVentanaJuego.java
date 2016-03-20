package vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;

public class MiVentanaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JLabel etiqOperación = null;
	private JLabel numUno = null;
	private JLabel numDos = null;
	private JTextField campoTextoResultado = null;
	private JLabel jLabel = null;
	private JButton botonVerificarYNuevaOpera = null;

	/**
	 * This is the default constructor
	 */
	public MiVentanaJuego() {
		super();
		initialize();
		
		
	}

	/**
	 * This method initializes this
	 * 
	 */
	

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
        this.setSize(new Dimension(265, 191));
        this.setContentPane(getJContentPane());
        this.setLocationRelativeTo(null);
        this.setTitle("Suma Y Resta");
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane(){
		//jContentPane.add(getJPanel(), null);

			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
		
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(30, 21, 84, 16));
			jLabel.setText("Operaciones");
			numDos = new JLabel();
			numDos.setBounds(new Rectangle(112, 59, 19, 16));
			numDos.setText("0");
			numUno = new JLabel();
			numUno.setBounds(new Rectangle(62, 58, 15, 16));
			numUno.setText("0");
			etiqOperación = new JLabel();
			etiqOperación.setBounds(new Rectangle(86, 59, 15, 16));
			etiqOperación.setText("+");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(12, 11, 222, 140));
			jPanel.add(etiqOperación, null);
			jPanel.add(numUno, null);
			jPanel.add(numDos, null);
			jPanel.add(initCampoTextoResultado(), null);
			jPanel.add(jLabel, null);
			jPanel.add(initBotonVerificarYNuevaOpera(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes campoTextoResultado	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField initCampoTextoResultado() {
		if (campoTextoResultado == null) {
			campoTextoResultado = new JTextField();
			campoTextoResultado.setBounds(new Rectangle(140, 60, 59, 17));
		}
		return campoTextoResultado;
	}

	/**
	 * This method initializes botonVerificarYNuevaOpera	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton initBotonVerificarYNuevaOpera() {
		if (botonVerificarYNuevaOpera == null) {
			botonVerificarYNuevaOpera = new JButton();
			botonVerificarYNuevaOpera.setBounds(new Rectangle(91, 108, 86, 24));
			botonVerificarYNuevaOpera.setText("Verificar");
		}
		return botonVerificarYNuevaOpera;
	}

	public JLabel getEtiqOperación() {
		return etiqOperación;
	}

	public void setEtiqOperación(JLabel etiqOperación) {
		this.etiqOperación = etiqOperación;
	}

	public JLabel getNumUno() {
		return numUno;
	}

	public void setNumUno(JLabel numUno) {
		this.numUno = numUno;
	}

	public JLabel getNumDos() {
		return numDos;
	}

	public void setNumDos(JLabel numDos) {
		this.numDos = numDos;
	}

	public JTextField getCampoTextoResultado() {
		return campoTextoResultado;
	}

	public void setCampoTextoResultado(JTextField campoTextoResultado) {
		this.campoTextoResultado = campoTextoResultado;
	}

	public JButton getBotonVerificarYNuevaOpera() {
		return botonVerificarYNuevaOpera;
	}

	public void setBotonVerificarYNuevaOpera(JButton botonVerificarYNuevaOpera) {
		this.botonVerificarYNuevaOpera = botonVerificarYNuevaOpera;
	}

}  //  @jve:decl-index=0:visual-constraint="29,31"
