package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelContacto;
	private JTextField txtUltimacompra;
	private JTextField textFieldCiudad;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private JTextField textFieldCedula;
	private JTextField textFieldApellido;
	private JTextField textFieldNombre;
	private JTextField textFieldComision;
	private JTextField textFieldUltimaVenta;
	private JPanel panelAuto;
	private JCheckBox chckbxLujo;
	private JTextField textFieldImpuesto;
	private JTextField textFieldAccesorios;
	private JTextField textFieldCosto;
	private JTextField textFieldModelo;
	private JTextField textFieldIdCarro;
	private JButton btnRegistrarAuto;
	private JPanel panelConsulta;
	private JButton btnLimpiarAuto;
	private JTextField textFieldConsultarPersona;
	private JTextPane textPaneResultadoConsulta;
	private JButton btnAgregarPersona;
	private JButton btnLimpiarPersona;
	private JButton btnEditarInfoPersona;
	private JTextField textFieldConsultarAuto;
	private JButton buttonEditarInfoAuto;
	private JButton btnBuscarPersona;
	private JButton btnBuscarAuto;
	private JButton btnCalcularPrecio;
	private JCheckBox chckbxEmpleado;
	private JComboBox comboBoxCombustible;
	private JComboBox comboBoxTraccion;
	private JComboBox comboBoxTransmision;
	private JTextPane textPaneResultadoCarro;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Vista() {
		
		setTitle("Concesionario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 386, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
		);
		
		panelContacto = new JPanel();
		panelContacto.setForeground(SystemColor.textHighlight);
		tabbedPane.addTab("Contacto", null, panelContacto, null);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(SystemColor.textHighlight);
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setForeground(SystemColor.textHighlight);
		
		JLabel lblCedula = new JLabel("Cedula :");
		lblCedula.setForeground(SystemColor.textHighlight);
		
		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setForeground(SystemColor.textHighlight);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n :");
		lblDireccin.setForeground(SystemColor.textHighlight);
		
		JLabel lblCiudad = new JLabel("Ciudad :");
		lblCiudad.setForeground(SystemColor.textHighlight);
		
		JLabel lblUltimaCompra = new JLabel("Ultima Compra (DD-MM-AAAA) :");
		lblUltimaCompra.setForeground(SystemColor.textHighlight);
		
		chckbxEmpleado = new JCheckBox("Empleado");
		chckbxEmpleado.setForeground(SystemColor.textHighlight);
		
		JLabel lblComisicin = new JLabel("% Comisici\u00F3n :");
		lblComisicin.setForeground(SystemColor.textHighlight);
		
		JLabel lblUltimaVenta = new JLabel("Ultima Venta (DD-MM-AAAA):");
		lblUltimaVenta.setForeground(SystemColor.textHighlight);
		
		txtUltimacompra = new JTextField();
		txtUltimacompra.setColumns(10);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		
		textFieldComision = new JTextField();
		textFieldComision.setColumns(10);
		
		textFieldUltimaVenta = new JTextField();
		textFieldUltimaVenta.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		
					
		
		btnLimpiarPersona = new JButton("Limpiar");
		GroupLayout gl_panelContacto = new GroupLayout(panelContacto);
		gl_panelContacto.setHorizontalGroup(
			gl_panelContacto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContacto.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelContacto.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelContacto.createSequentialGroup()
							.addGroup(gl_panelContacto.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblApellido)
								.addComponent(lblUltimaCompra)
								.addComponent(lblCiudad)
								.addComponent(lblTelefono)
								.addComponent(lblDireccin)
								.addComponent(lblCedula)
								.addComponent(chckbxEmpleado)
								.addComponent(lblComisicin)
								.addComponent(lblUltimaVenta))
							.addGap(18)
							.addGroup(gl_panelContacto.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldUltimaVenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtUltimacompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldComision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelContacto.createSequentialGroup()
							.addComponent(btnAgregarPersona)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLimpiarPersona)))
					.addContainerGap(140, Short.MAX_VALUE))
		);
		gl_panelContacto.setVerticalGroup(
			gl_panelContacto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContacto.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panelContacto.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelContacto.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNombre)
							.addGap(11)
							.addComponent(lblApellido)
							.addGap(16)
							.addComponent(lblCedula)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTelefono)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblDireccin)
							.addGap(13)
							.addGroup(gl_panelContacto.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCiudad)
								.addComponent(textFieldCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelContacto.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtUltimacompra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUltimaCompra)))
						.addGroup(gl_panelContacto.createSequentialGroup()
							.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldCedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(2)
					.addComponent(chckbxEmpleado)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelContacto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblComisicin)
						.addComponent(textFieldComision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelContacto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUltimaVenta)
						.addComponent(textFieldUltimaVenta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelContacto.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregarPersona)
						.addComponent(btnLimpiarPersona))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		panelContacto.setLayout(gl_panelContacto);
		
		panelAuto = new JPanel();
		tabbedPane.addTab("Auto", null, panelAuto, null);
		
		JLabel lblIdCarro = new JLabel("ID Carro :");
		
		JLabel lblModelo = new JLabel("Modelo :");
		
		JLabel lblCosto = new JLabel("Costo :");
		
		JLabel lblCombustible = new JLabel("Combustible :");
		
		JLabel lblTraccin = new JLabel("Tracci\u00F3n :");
		
		JLabel lblTransmicin = new JLabel("Transmisi\u00F3n :");
		
		chckbxLujo = new JCheckBox("Lujo");
		
		JLabel lblImpuesto = new JLabel("Impuesto (0.##):");
		
		JLabel lblAccesorios = new JLabel("Accesorios :");
		
		textFieldImpuesto = new JTextField();
		textFieldImpuesto.setColumns(10);
		
		textFieldAccesorios = new JTextField();
		textFieldAccesorios.setColumns(10);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setColumns(10);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setColumns(10);
		
		textFieldIdCarro = new JTextField();
		textFieldIdCarro.setColumns(10);
		
		comboBoxCombustible = new JComboBox();
		
		comboBoxTraccion = new JComboBox();
		
		comboBoxTransmision = new JComboBox();
		
		btnRegistrarAuto = new JButton("Registrar");
		
		btnLimpiarAuto = new JButton("Limpiar");
		GroupLayout gl_panelAuto = new GroupLayout(panelAuto);
		gl_panelAuto.setHorizontalGroup(
			gl_panelAuto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAuto.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAuto.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAuto.createSequentialGroup()
							.addGroup(gl_panelAuto.createParallelGroup(Alignment.LEADING)
								.addComponent(chckbxLujo)
								.addComponent(lblCombustible)
								.addGroup(gl_panelAuto.createSequentialGroup()
									.addGroup(gl_panelAuto.createParallelGroup(Alignment.LEADING)
										.addComponent(lblModelo)
										.addComponent(lblCosto)
										.addComponent(lblIdCarro)
										.addComponent(lblTraccin)
										.addComponent(lblTransmicin))
									.addGap(23)
									.addGroup(gl_panelAuto.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBoxTraccion, 0, 122, Short.MAX_VALUE)
										.addComponent(comboBoxCombustible, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panelAuto.createParallelGroup(Alignment.LEADING, false)
											.addComponent(textFieldCosto, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
											.addComponent(textFieldModelo)
											.addComponent(textFieldIdCarro))
										.addComponent(comboBoxTransmision, Alignment.TRAILING, 0, 122, Short.MAX_VALUE))))
							.addGap(367))
						.addGroup(gl_panelAuto.createSequentialGroup()
							.addComponent(btnRegistrarAuto)
							.addGap(18)
							.addComponent(btnLimpiarAuto)
							.addContainerGap())
						.addGroup(gl_panelAuto.createSequentialGroup()
							.addGroup(gl_panelAuto.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panelAuto.createSequentialGroup()
									.addComponent(lblAccesorios)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textFieldAccesorios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_panelAuto.createSequentialGroup()
									.addComponent(lblImpuesto)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldImpuesto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(397, Short.MAX_VALUE))))
		);
		gl_panelAuto.setVerticalGroup(
			gl_panelAuto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAuto.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panelAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdCarro)
						.addComponent(textFieldIdCarro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo)
						.addComponent(textFieldModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCosto)
						.addComponent(textFieldCosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCombustible)
						.addComponent(comboBoxCombustible, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTraccin)
						.addComponent(comboBoxTraccion, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTransmicin)
						.addComponent(comboBoxTransmision, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chckbxLujo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblImpuesto)
						.addComponent(textFieldImpuesto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccesorios)
						.addComponent(textFieldAccesorios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(gl_panelAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegistrarAuto)
						.addComponent(btnLimpiarAuto))
					.addContainerGap())
		);
		panelAuto.setLayout(gl_panelAuto);
		
		panelConsulta = new JPanel();
		tabbedPane.addTab("Consultas", null, panelConsulta, null);
		
		JLabel lblConsultarPersonaPor = new JLabel("Consultar Persona por Id : ");
		
		textFieldConsultarPersona = new JTextField();
		textFieldConsultarPersona.setColumns(10);
		
		textPaneResultadoConsulta = new JTextPane();
		textPaneResultadoConsulta.setEditable(false);
		
		btnEditarInfoPersona = new JButton("Editar Informaci\u00F3n");
		btnEditarInfoPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblConsultarAutoPor = new JLabel("Consultar Auto por Id :");
		
		textFieldConsultarAuto = new JTextField();
		textFieldConsultarAuto.setColumns(10);
		
		textPaneResultadoCarro = new JTextPane();
		textPaneResultadoCarro.setEditable(false);
		
		buttonEditarInfoAuto = new JButton("Editar Informaci\u00F3n");
		
		btnBuscarPersona = new JButton("Buscar");
		
		btnBuscarAuto = new JButton("Buscar");
		
		btnCalcularPrecio = new JButton("Calcular Precio");
		btnCalcularPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panelConsulta = new GroupLayout(panelConsulta);
		gl_panelConsulta.setHorizontalGroup(
			gl_panelConsulta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsulta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelConsulta.createSequentialGroup()
							.addComponent(lblConsultarAutoPor)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldConsultarAuto, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
						.addGroup(gl_panelConsulta.createSequentialGroup()
							.addComponent(lblConsultarPersonaPor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldConsultarPersona))
						.addGroup(Alignment.LEADING, gl_panelConsulta.createSequentialGroup()
							.addGap(10)
							.addComponent(textPaneResultadoCarro, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
						.addComponent(textPaneResultadoConsulta, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelConsulta.createParallelGroup(Alignment.LEADING, false)
							.addComponent(buttonEditarInfoAuto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBuscarPersona, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnEditarInfoPersona, GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)
							.addComponent(btnBuscarAuto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(btnCalcularPrecio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelConsulta.setVerticalGroup(
			gl_panelConsulta.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConsulta.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsultarPersonaPor)
						.addComponent(textFieldConsultarPersona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscarPersona))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelConsulta.createSequentialGroup()
							.addComponent(btnEditarInfoPersona)
							.addGap(121))
						.addGroup(gl_panelConsulta.createSequentialGroup()
							.addComponent(textPaneResultadoConsulta, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblConsultarAutoPor)
						.addComponent(textFieldConsultarAuto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscarAuto))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelConsulta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelConsulta.createSequentialGroup()
							.addComponent(buttonEditarInfoAuto)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCalcularPrecio))
						.addComponent(textPaneResultadoCarro, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
					.addContainerGap())
		);
		panelConsulta.setLayout(gl_panelConsulta);
		contentPane.setLayout(gl_contentPane);
	}

	public JTextField getTxtUltimacompra() {
		return txtUltimacompra;
	}

	public JTextField getTextFieldCiudad() {
		return textFieldCiudad;
	}

	public JTextField getTextFieldDireccion() {
		return textFieldDireccion;
	}

	public JTextField getTextFieldTelefono() {
		return textFieldTelefono;
	}

	public JTextField getTextFieldCedula() {
		return textFieldCedula;
	}

	public JTextField getTextFieldApellido() {
		return textFieldApellido;
	}

	public JTextField getTextFieldNombre() {
		return textFieldNombre;
	}

	public JTextField getTextFieldComision() {
		return textFieldComision;
	}

	public JTextField getTextFieldUltimaVenta() {
		return textFieldUltimaVenta;
	}

	public JCheckBox getChckbxLujo() {
		return chckbxLujo;
	}

	public JTextField getTextFieldImpuesto() {
		return textFieldImpuesto;
	}

	public JTextField getTextFieldAccesorios() {
		return textFieldAccesorios;
	}

	public JTextField getTextFieldCosto() {
		return textFieldCosto;
	}

	public JTextField getTextFieldModelo() {
		return textFieldModelo;
	}

	public JTextField getTextFieldIdCarro() {
		return textFieldIdCarro;
	}


	public JButton getBtnRegistrarAuto() {
		return btnRegistrarAuto;
	}

	public JButton getBtnLimpiarAuto() {
		return btnLimpiarAuto;
	}

	public JTextField getTextFieldConsultarPersona() {
		return textFieldConsultarPersona;
	}

	public JTextPane getTextPaneResultadoConsulta() {
		return textPaneResultadoConsulta;
	}

	public JButton getBtnAgregarPersona() {
		return btnAgregarPersona;
	}

	public JButton getBtnLimpiarPersona() {
		return btnLimpiarPersona;
	}

	public JButton getBtnEditarInfoPersona() {
		return btnEditarInfoPersona;
	}

	public JTextField getTextFieldConsultarAuto() {
		return textFieldConsultarAuto;
	}

	public JButton getButtonEditarInfoAuto() {
		return buttonEditarInfoAuto;
	}

	
	public JButton getBtnBuscarPersona() {
		return btnBuscarPersona;
	}

	public JButton getBtnBuscarAuto() {
		return btnBuscarAuto;
	}

	public JButton getBtnCalcularPrecio() {
		return btnCalcularPrecio;
	}

	public JCheckBox getChckbxEmpleado() {
		return chckbxEmpleado;
	}

	public JComboBox getComboBoxCombustible() {
		return comboBoxCombustible;
	}

	public JComboBox getComboBoxTraccion() {
		return comboBoxTraccion;
	}

	public JComboBox getComboBoxTransmision() {
		return comboBoxTransmision;
	}

	public JTextPane getTextPaneResultadoCarro() {
		return textPaneResultadoCarro;
	}

	
	
	
}
