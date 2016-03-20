package interfaz;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PanelCliente extends JPanel implements ActionListener {
	public final static String REGISTRAR_CLIENTE = "Registrar Cliente";
	public final static String LIMPIAR = "Limpiar";
	public final static String CONSULTAR = "Consultar";

	private Ventana ventana;

	private JTextField txtCedula, txtNombres, txtApellidos, txtEdad,
			txtCedulaConsulta;

	public PanelCliente(Ventana ventana) {
		this.ventana = ventana;

		this.setBorder(BorderFactory.createTitledBorder("Clientes"));

		this.setLayout(new BorderLayout());

		// Panel superior
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(BorderFactory
				.createTitledBorder("*** Consulta ***"));
		panelSuperior.setLayout(new GridLayout(1, 3, 15, 15));

		this.txtCedulaConsulta = new JTextField(5);
		this.txtCedulaConsulta.addActionListener(this);

		JButton btnConsultar = new JButton(CONSULTAR);
		btnConsultar.setActionCommand(CONSULTAR);
		btnConsultar.addActionListener(this);

		panelSuperior.add(new JLabel("Cedula: "));
		panelSuperior.add(this.txtCedulaConsulta);
		panelSuperior.add(btnConsultar);


		this.add(panelSuperior, BorderLayout.NORTH);
		// Fin Panel superior

		// Panel Central
		JPanel panelCentral = new JPanel();
		panelCentral.setBorder(BorderFactory
				.createTitledBorder("*** Registro ***"));
		panelCentral.setLayout(new GridLayout(7, 2, 15, 15));

		this.txtCedula = new JTextField(10);
		this.txtNombres = new JTextField(10);
		this.txtApellidos = new JTextField(10);
		this.txtEdad = new JTextField(10);

		JButton btnRegistrar = new JButton(REGISTRAR_CLIENTE);
		btnRegistrar.setActionCommand(REGISTRAR_CLIENTE);
		btnRegistrar.addActionListener(this);

		JButton btnLimpiar = new JButton(LIMPIAR);
		btnLimpiar.setActionCommand(LIMPIAR);
		btnLimpiar.addActionListener(this);

		for (int i = 0; i < 2; i++) {
			panelCentral.add(new JLabel(""));
		}

		panelCentral.add(new JLabel("Cedula: "));
		panelCentral.add(this.txtCedula);
		panelCentral.add(new JLabel("Nombres: "));
		panelCentral.add(this.txtNombres);
		panelCentral.add(new JLabel("Apellidos: "));
		panelCentral.add(this.txtApellidos);
		panelCentral.add(new JLabel("Edad: "));
		panelCentral.add(this.txtEdad);
		panelCentral.add(btnLimpiar);
		panelCentral.add(btnRegistrar);

		for (int i = 0; i < 2; i++) {
			panelCentral.add(new JLabel(""));
		}

		this.add(panelCentral, BorderLayout.CENTER);
		// Fin Panel central
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(LIMPIAR)) {
			this.txtCedula.setText("");
			this.txtNombres.setText("");
			this.txtApellidos.setText("");
			this.txtEdad.setText("");
		} else if (event.getActionCommand().equals(REGISTRAR_CLIENTE)) {
			String cedula = this.txtCedula.getText();
			String nombres = this.txtNombres.getText();
			String apellidos = this.txtApellidos.getText();
			String edad = this.txtEdad.getText();

			boolean registrado = this.ventana.registrarCliente(cedula, nombres,
					apellidos, edad);
		} else if (event.getActionCommand().equals(CONSULTAR)) {
			String cedula = this.txtCedulaConsulta.getText().trim();
			JOptionPane
					.showMessageDialog(this.ventana,
							this.ventana.consultarCliente(cedula),
							"Resultado de la busqueda",
							JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
