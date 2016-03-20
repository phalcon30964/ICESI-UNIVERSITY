package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class Interfaz {

	public JFrame frame;
	private JTextField textField;
	private JButton btnEjecutarConsulta;
	private JTextField textResultado;
	private JButton btnEjecutarComando;


	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblComando = new JLabel("Comando");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnEjecutarComando = new JButton("Ejecutar Comando");
		
		btnEjecutarConsulta = new JButton("Ejecutar Consulta");
		
		textResultado = new JTextField();
		textResultado.setEditable(false);
		textResultado.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textResultado, Alignment.LEADING)
						.addComponent(btnEjecutarConsulta, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnEjecutarComando, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblComando)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblComando)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEjecutarComando)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEjecutarConsulta)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textResultado, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JButton getBtnEjecutarConsulta() {
		return btnEjecutarConsulta;
	}

	public void setBtnEjecutarConsulta(JButton btnEjecutarConsulta) {
		this.btnEjecutarConsulta = btnEjecutarConsulta;
	}

	public JTextField getTextResultado() {
		return textResultado;
	}

	public void setTextResultado(JTextField textResultado) {
		this.textResultado = textResultado;
	}

	public JButton getBtnEjecutarComando() {
		return btnEjecutarComando;
	}

	public void setBtnEjecutarComando(JButton btnEjecutarComando) {
		this.btnEjecutarComando = btnEjecutarComando;
	}	
	

}
