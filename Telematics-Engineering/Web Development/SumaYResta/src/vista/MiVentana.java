package vista;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MiVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JTextField campoTextoNombre = null;
	private JButton botonJugar = null;

	/**
	 * This is the default constructor
	 */
	public MiVentana() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("Suma Y Resta");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(45, 36, 63, 24));
			jLabel.setText("Nombre:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(initCampoTextoNombre(), null);
			jContentPane.add(initBotonJugar(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes campoTextoNombre	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField initCampoTextoNombre() {
		if (campoTextoNombre == null) {
			campoTextoNombre = new JTextField();
			campoTextoNombre.setBounds(new Rectangle(118, 36, 121, 25));
		}
		return campoTextoNombre;
	}

	/**
	 * This method initializes botonJugar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton initBotonJugar() {
		if (botonJugar == null) {
			botonJugar = new JButton();
			botonJugar.setBounds(new Rectangle(105, 99, 86, 26));
			botonJugar.setText("Jugar");
		}
		return botonJugar;
	}

	public JTextField getCampoTextoNombre() {
		return campoTextoNombre;
	}

	public void setCampoTextoNombre(JTextField campoTextoNombre) {
		this.campoTextoNombre = campoTextoNombre;
	}

	public JButton getBotonJugar() {
		return botonJugar;
	}

	public void setBotonJugar(JButton botonJugar) {
		this.botonJugar = botonJugar;
	}

}
