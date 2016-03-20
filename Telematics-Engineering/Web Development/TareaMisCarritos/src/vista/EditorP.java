package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EditorP extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreEd;
	private JTextField textFieldApellidoEd;
	private JTextField textFieldCedulaEd;
	private JTextField textFieldNumContactoEd;
	private JTextField textFieldDireccionEd;
	private JButton aceptarButton;
	private JButton cancelButton;

	public JTextField getTextFieldNombreEd() {
		return textFieldNombreEd;
	}

	public void setTextFieldNombreEd(JTextField textFieldNombreEd) {
		this.textFieldNombreEd = textFieldNombreEd;
	}

	public JTextField getTextFieldApellidoEd() {
		return textFieldApellidoEd;
	}

	public void setTextFieldApellidoEd(JTextField textFieldApellidoEd) {
		this.textFieldApellidoEd = textFieldApellidoEd;
	}

	public JTextField getTextFieldCedulaEd() {
		return textFieldCedulaEd;
	}

	public void setTextFieldCedulaEd(JTextField textFieldCedulaEd) {
		this.textFieldCedulaEd = textFieldCedulaEd;
	}

	public JTextField getTextFieldNumContactoEd() {
		return textFieldNumContactoEd;
	}

	public void setTextFieldNumContactoEd(JTextField textFieldNumContactoEd) {
		this.textFieldNumContactoEd = textFieldNumContactoEd;
	}

	public JTextField getTextFieldDireccionEd() {
		return textFieldDireccionEd;
	}

	public void setTextFieldDireccionEd(JTextField textFieldDireccionEd) {
		this.textFieldDireccionEd = textFieldDireccionEd;
	}

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			Editor dialog = new Editor();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public EditorP(String nombre, String apellido, String cedula, String numContacto, String direccion) {

		setTitle("Editor de datos");
		setBounds(100, 100, 326, 307);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		JLabel lblCedula = new JLabel("Cedula");
		
		JLabel lblNumeroDeContacto = new JLabel("Numero de Contacto");
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		textFieldNombreEd = new JTextField();
		textFieldNombreEd.setColumns(10);
		
		textFieldApellidoEd = new JTextField();
		textFieldApellidoEd.setColumns(10);
		
		textFieldCedulaEd = new JTextField();
		textFieldCedulaEd.setColumns(10);
		
		textFieldNumContactoEd = new JTextField();
		textFieldNumContactoEd.setColumns(10);
		
		textFieldDireccionEd = new JTextField();
		textFieldDireccionEd.setText("");
		textFieldDireccionEd.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addComponent(lblApellido)
						.addComponent(lblNumeroDeContacto)
						.addComponent(lblDireccion)
						.addComponent(lblCedula))
					.addGap(70)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldApellidoEd, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addComponent(textFieldNombreEd, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addComponent(textFieldNumContactoEd, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addComponent(textFieldDireccionEd, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
						.addComponent(textFieldCedulaEd, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblNombre)
							.addGap(18)
							.addComponent(lblApellido))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(textFieldNombreEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(textFieldApellidoEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCedula)
								.addComponent(textFieldCedulaEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroDeContacto)
						.addComponent(textFieldNumContactoEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDireccion)
						.addComponent(textFieldDireccionEd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				aceptarButton = new JButton("Aceptar");
				buttonPane.add(aceptarButton);
				getRootPane().setDefaultButton(aceptarButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	
		textFieldNombreEd.setText(nombre);
		textFieldApellidoEd.setText(apellido);
		textFieldCedulaEd.setText(cedula);
		textFieldNumContactoEd.setText(numContacto);
		textFieldDireccionEd.setText(direccion);
	
	}

	public JButton getAceptarButton() {
		return aceptarButton;
	}

	public void setAceptarButton(JButton aceptarButton) {
		this.aceptarButton = aceptarButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}
	
}
