package vista;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

import modelo.Usuarios;

public class Interfaz {

	public JFrame frame;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido;
	private JTextField textField_Direccion;
	private JTextField textField_Telefono;
	private JTextField textField_Celular;
	private JTextField textField_Id;
	private JTextField textField_Ano;
	private JTextField textField_Mes;
	private JTextField textField_Dia;
	private JLabel lblAo;
	private JLabel lblMes;
	private JTextField textField_IdCita;
	private JTextField textField_NombreCita;
	private JTextField textField_ApellidoCita;
	private JTextField textField_DiaCita;
	private JTextField textField_MesCita;
	private JTextField textField_AnoCita;
	private JTextField textField_ApellidoConsultar;
	private JTextField textField_NombreConsultar;
	private JTextField textField_IdConsultar;
	private JButton btnBuscar;
	private JButton btnConsultarDisponibilidad;
	private JComboBox<String> comboBox_HorariosDisponibles;
	private JButton btnAgregarCitaEn;
	private JButton button_buscarConsultar;
	private JComboBox<String> comboBox_CitasPendientes;
	private JButton btnEliminarCita;
	private JTextPane textPanex_CitasPendientes;
	private JButton btnAgregarPaciente;
	private JTextField textField_Mensaje;
	private JComboBox<Usuarios> comboBoxUSUARIOS;
	private JButton btnDifundirMensaje;
	private JButton btnEnviarMensajePrivado;
	private JTextArea textArea_Visualizador;

	/**
	 * Launch the application.
	 */

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
		frame.setBounds(100, 100, 405, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
		);
		
		JPanel panel_AgregarPaciente = new JPanel();
		panel_AgregarPaciente.setBorder(new TitledBorder(null, "Datos Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.addTab("Agregar Paciente", null, panel_AgregarPaciente, null);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		
		JLabel lblApellido = new JLabel("Apellido:");
		
		JLabel lblDireccion = new JLabel("Direccion:");
		
		JLabel lblTelefono = new JLabel("Telefono:");
		
		JLabel lblCelular = new JLabel("Celular:");
		
		JLabel lblId = new JLabel("id:");
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		
		textField_Apellido = new JTextField();
		textField_Apellido.setColumns(10);
		
		textField_Direccion = new JTextField();
		textField_Direccion.setColumns(10);
		
		textField_Telefono = new JTextField();
		textField_Telefono.setColumns(10);
		
		textField_Celular = new JTextField();
		textField_Celular.setColumns(10);
		
		textField_Id = new JTextField();
		textField_Id.setColumns(10);
		
		textField_Ano = new JTextField();
		textField_Ano.setColumns(10);
		
		textField_Mes = new JTextField();
		textField_Mes.setColumns(10);
		
		textField_Dia = new JTextField();
		textField_Dia.setColumns(10);
		
		JLabel lblDia = new JLabel("Dia");
		
		lblAo = new JLabel("A\u00F1o");
		
		lblMes = new JLabel("Mes");
		
		btnAgregarPaciente = new JButton("Agregar Paciente");
		GroupLayout gl_panel_AgregarPaciente = new GroupLayout(panel_AgregarPaciente);
		gl_panel_AgregarPaciente.setHorizontalGroup(
			gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblApellido)
								.addComponent(lblDireccion)
								.addComponent(lblTelefono)
								.addComponent(lblCelular)
								.addComponent(lblId))
							.addGap(112)
							.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_Id, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Celular, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Telefono, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Direccion, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Apellido, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_panel_AgregarPaciente.createSequentialGroup()
								.addGap(35)
								.addComponent(btnAgregarPaciente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_panel_AgregarPaciente.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblFechaDeNacimiento)
								.addGap(40)
								.addComponent(lblDia)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_Dia, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblMes)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(textField_Mes, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(lblAo)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_Ano, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		gl_panel_AgregarPaciente.setVerticalGroup(
			gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addComponent(textField_Nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGap(12)
							.addComponent(lblApellido))
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGap(11)
							.addComponent(textField_Apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGap(13)
							.addComponent(lblDireccion))
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGap(11)
							.addComponent(textField_Direccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGap(14)
							.addComponent(lblTelefono))
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGap(11)
							.addComponent(textField_Telefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGap(15)
							.addComponent(lblCelular))
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGap(11)
							.addComponent(textField_Celular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGap(16)
							.addComponent(lblId))
						.addGroup(gl_panel_AgregarPaciente.createSequentialGroup()
							.addGap(11)
							.addComponent(textField_Id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel_AgregarPaciente.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFechaDeNacimiento)
						.addComponent(lblDia)
						.addComponent(textField_Dia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAo)
						.addComponent(textField_Ano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMes)
						.addComponent(textField_Mes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addComponent(btnAgregarPaciente)
					.addContainerGap(85, Short.MAX_VALUE))
		);
		panel_AgregarPaciente.setLayout(gl_panel_AgregarPaciente);
		
		JPanel panel_AgregarCita = new JPanel();
		tabbedPane.addTab("Agregar Cita", null, panel_AgregarCita, null);
		
		JLabel lblId_1 = new JLabel("Id:");
		
		textField_IdCita = new JTextField();
		textField_IdCita.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		
		JLabel lblApellido_1 = new JLabel("Apellido:");
		
		textField_NombreCita = new JTextField();
		textField_NombreCita.setColumns(10);
		
		textField_ApellidoCita = new JTextField();
		textField_ApellidoCita.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Cita", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_AgregarCita = new GroupLayout(panel_AgregarCita);
		gl_panel_AgregarCita.setHorizontalGroup(
			gl_panel_AgregarCita.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_AgregarCita.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_panel_AgregarCita.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre_1)
						.addComponent(lblId_1)
						.addComponent(lblApellido_1))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGroup(gl_panel_AgregarCita.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_ApellidoCita)
						.addComponent(textField_NombreCita)
						.addComponent(textField_IdCita, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnBuscar)
					.addGap(45))
				.addGroup(gl_panel_AgregarCita.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_AgregarCita.setVerticalGroup(
			gl_panel_AgregarCita.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_AgregarCita.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_AgregarCita.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBuscar)
						.addComponent(textField_IdCita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_AgregarCita.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_NombreCita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_AgregarCita.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_ApellidoCita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblApellido_1))
					.addGap(29)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblFechaDeseadaPara = new JLabel("Fecha deseada para cita:");
		
		JLabel lblDia_1 = new JLabel("Dia:");
		
		JLabel lblMes_1 = new JLabel("Mes:");
		
		JLabel lblAo_1 = new JLabel("A\u00F1o:");
		
		textField_DiaCita = new JTextField();
		textField_DiaCita.setColumns(10);
		
		textField_MesCita = new JTextField();
		textField_MesCita.setColumns(10);
		
		textField_AnoCita = new JTextField();
		textField_AnoCita.setColumns(10);
		
		btnConsultarDisponibilidad = new JButton("Consultar disponibilidad");
		
		comboBox_HorariosDisponibles = new JComboBox<String>();
		
		JLabel lblHorariosDisponibles = new JLabel("Horarios disponibles:");
		
		btnAgregarCitaEn = new JButton("Agregar cita en horario escogido");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
								.addComponent(btnConsultarDisponibilidad, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addGap(66))
							.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
										.addComponent(lblHorariosDisponibles)
										.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
										.addComponent(comboBox_HorariosDisponibles, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_1.createSequentialGroup()
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblFechaDeseadaPara)
											.addGroup(gl_panel_1.createSequentialGroup()
												.addComponent(lblDia_1)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_DiaCita, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblMes_1)))
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(textField_MesCita, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
										.addGap(28)
										.addComponent(lblAo_1)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField_AnoCita, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
								.addGap(43)))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnAgregarCitaEn, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
							.addGap(67))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(27)
					.addComponent(lblFechaDeseadaPara)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDia_1)
						.addComponent(lblAo_1)
						.addComponent(textField_DiaCita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_MesCita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_AnoCita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMes_1))
					.addGap(18)
					.addComponent(btnConsultarDisponibilidad)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox_HorariosDisponibles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHorariosDisponibles))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(btnAgregarCitaEn)
					.addGap(34))
		);
		panel_1.setLayout(gl_panel_1);
		panel_AgregarCita.setLayout(gl_panel_AgregarCita);
		
		JPanel panel_Consultar = new JPanel();
		tabbedPane.addTab("Consultar Cita", null, panel_Consultar, null);
		
		JLabel label = new JLabel("Id:");
		
		JLabel label_1 = new JLabel("Nombre:");
		
		JLabel label_2 = new JLabel("Apellido:");
		
		textField_ApellidoConsultar = new JTextField();
		textField_ApellidoConsultar.setColumns(10);
		
		textField_NombreConsultar = new JTextField();
		textField_NombreConsultar.setColumns(10);
		
		textField_IdConsultar = new JTextField();
		textField_IdConsultar.setColumns(10);
		
		button_buscarConsultar = new JButton("Buscar");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Citas Pendientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panel_Consultar = new GroupLayout(panel_Consultar);
		gl_panel_Consultar.setHorizontalGroup(
			gl_panel_Consultar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Consultar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_Consultar.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_Consultar.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_panel_Consultar.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(label, GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
								.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_Consultar.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_Consultar.createSequentialGroup()
									.addComponent(textField_IdConsultar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button_buscarConsultar))
								.addComponent(textField_NombreConsultar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_ApellidoConsultar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
							.addGap(27))
						.addGroup(gl_panel_Consultar.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel_Consultar.setVerticalGroup(
			gl_panel_Consultar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Consultar.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel_Consultar.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_Consultar.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel_Consultar.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_IdConsultar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addGap(13)
							.addGroup(gl_panel_Consultar.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_NombreConsultar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1))
							.addGap(11)
							.addGroup(gl_panel_Consultar.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_ApellidoConsultar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2)))
						.addGroup(gl_panel_Consultar.createSequentialGroup()
							.addComponent(button_buscarConsultar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(62)))
					.addGap(28)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblCitasProgramadas = new JLabel("Citas Programadas");
		
		comboBox_CitasPendientes = new JComboBox<String>();
		
		btnEliminarCita = new JButton("Eliminar cita ");
		
		textPanex_CitasPendientes = new JTextPane();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblCitasProgramadas)
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addComponent(comboBox_CitasPendientes, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnEliminarCita, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE))
					.addGap(36))
				.addGroup(Alignment.LEADING, gl_panel_3.createSequentialGroup()
					.addGap(29)
					.addComponent(textPanex_CitasPendientes, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPanex_CitasPendientes, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCitasProgramadas)
						.addComponent(comboBox_CitasPendientes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminarCita)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		panel_Consultar.setLayout(gl_panel_Consultar);
		
		JPanel panel_Chat = new JPanel();
		tabbedPane.addTab("CHAT", null, panel_Chat, null);
		
		comboBoxUSUARIOS = new JComboBox<Usuarios>();
		
		JLabel lblMesajePrivadoA = new JLabel("Mesaje Privado A:");
		
		textField_Mensaje = new JTextField();
		textField_Mensaje.setColumns(10);
		
		btnDifundirMensaje = new JButton("Difundir Mensaje");
		
		btnEnviarMensajePrivado = new JButton("Enviar mensaje privado");
		
		textArea_Visualizador = new JTextArea();
		textArea_Visualizador.setEditable(false);
		GroupLayout gl_panel_Chat = new GroupLayout(panel_Chat);
		gl_panel_Chat.setHorizontalGroup(
			gl_panel_Chat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Chat.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel_Chat.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textArea_Visualizador, Alignment.LEADING)
						.addGroup(gl_panel_Chat.createSequentialGroup()
							.addComponent(lblMesajePrivadoA)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBoxUSUARIOS, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_Chat.createSequentialGroup()
							.addGroup(gl_panel_Chat.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_Chat.createSequentialGroup()
									.addComponent(btnDifundirMensaje)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnEnviarMensajePrivado))
								.addComponent(textField_Mensaje, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE))
							.addGap(11)))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_panel_Chat.setVerticalGroup(
			gl_panel_Chat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_Chat.createSequentialGroup()
					.addGap(24)
					.addComponent(textArea_Visualizador, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_Chat.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxUSUARIOS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMesajePrivadoA))
					.addGap(34)
					.addComponent(textField_Mensaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_Chat.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDifundirMensaje)
						.addComponent(btnEnviarMensajePrivado))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		panel_Chat.setLayout(gl_panel_Chat);
		frame.getContentPane().setLayout(groupLayout);
	}

	public JTextField getTextField_Nombre() {
		return textField_Nombre;
	}

	public void setTextField_Nombre(JTextField textField_Nombre) {
		this.textField_Nombre = textField_Nombre;
	}

	public JTextField getTextField_Apellido() {
		return textField_Apellido;
	}

	public void setTextField_Apellido(JTextField textField_Apellido) {
		this.textField_Apellido = textField_Apellido;
	}

	public JTextField getTextField_Direccion() {
		return textField_Direccion;
	}

	public void setTextField_Direccion(JTextField textField_Direccion) {
		this.textField_Direccion = textField_Direccion;
	}

	public JTextField getTextField_Telefono() {
		return textField_Telefono;
	}

	public void setTextField_Telefono(JTextField textField_Telefono) {
		this.textField_Telefono = textField_Telefono;
	}

	public JTextField getTextField_Celular() {
		return textField_Celular;
	}

	public void setTextField_Celular(JTextField textField_Celular) {
		this.textField_Celular = textField_Celular;
	}

	public JTextField getTextField_Id() {
		return textField_Id;
	}

	public void setTextField_Id(JTextField textField_Id) {
		this.textField_Id = textField_Id;
	}

	public JTextField getTextField_Ano() {
		return textField_Ano;
	}

	public void setTextField_Ano(JTextField textField_Ano) {
		this.textField_Ano = textField_Ano;
	}

	public JTextField getTextField_Mes() {
		return textField_Mes;
	}

	public void setTextField_Mes(JTextField textField_Mes) {
		this.textField_Mes = textField_Mes;
	}

	public JTextField getTextField_Dia() {
		return textField_Dia;
	}

	public void setTextField_Dia(JTextField textField_Dia) {
		this.textField_Dia = textField_Dia;
	}

	public JLabel getLblAo() {
		return lblAo;
	}

	public void setLblAo(JLabel lblAo) {
		this.lblAo = lblAo;
	}

	public JLabel getLblMes() {
		return lblMes;
	}

	public void setLblMes(JLabel lblMes) {
		this.lblMes = lblMes;
	}

	public JTextField getTextField_IdCita() {
		return textField_IdCita;
	}

	public void setTextField_IdCita(JTextField textField_IdCita) {
		this.textField_IdCita = textField_IdCita;
	}

	public JTextField getTextField_NombreCita() {
		return textField_NombreCita;
	}

	public void setTextField_NombreCita(JTextField textField_NombreCita) {
		this.textField_NombreCita = textField_NombreCita;
	}

	public JTextField getTextField_ApellidoCita() {
		return textField_ApellidoCita;
	}

	public void setTextField_ApellidoCita(JTextField textField_ApellidoCita) {
		this.textField_ApellidoCita = textField_ApellidoCita;
	}

	public JTextField getTextField_DiaCita() {
		return textField_DiaCita;
	}

	public void setTextField_DiaCita(JTextField textField_DiaCita) {
		this.textField_DiaCita = textField_DiaCita;
	}

	public JTextField getTextField_MesCita() {
		return textField_MesCita;
	}

	public void setTextField_MesCita(JTextField textField_MesCita) {
		this.textField_MesCita = textField_MesCita;
	}

	public JTextField getTextField_AnoCita() {
		return textField_AnoCita;
	}

	public void setTextField_AnoCita(JTextField textField_AnoCita) {
		this.textField_AnoCita = textField_AnoCita;
	}

	public JTextField getTextField_ApellidoConsultar() {
		return textField_ApellidoConsultar;
	}

	public void setTextField_ApellidoConsultar(
			JTextField textField_ApellidoConsultar) {
		this.textField_ApellidoConsultar = textField_ApellidoConsultar;
	}

	public JTextField getTextField_NombreConsultar() {
		return textField_NombreConsultar;
	}

	public void setTextField_NombreConsultar(JTextField textField_NombreConsultar) {
		this.textField_NombreConsultar = textField_NombreConsultar;
	}

	public JTextField getTextField_IdConsultar() {
		return textField_IdConsultar;
	}

	public void setTextField_IdConsultar(JTextField textField_IdConsultar) {
		this.textField_IdConsultar = textField_IdConsultar;
	}

	

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnConsultarDisponibilidad() {
		return btnConsultarDisponibilidad;
	}

	public void setBtnConsultarDisponibilidad(JButton btnConsultarDisponibilidad) {
		this.btnConsultarDisponibilidad = btnConsultarDisponibilidad;
	}

	public JComboBox<String> getComboBox_HorariosDisponibles() {
		return comboBox_HorariosDisponibles;
	}

	public void setComboBox_HorariosDisponibles(
			JComboBox<String> comboBox_HorariosDisponibles) {
		this.comboBox_HorariosDisponibles = comboBox_HorariosDisponibles;
	}

	public JButton getBtnAgregarCitaEn() {
		return btnAgregarCitaEn;
	}

	public void setBtnAgregarCitaEn(JButton btnAgregarCitaEn) {
		this.btnAgregarCitaEn = btnAgregarCitaEn;
	}

	public JButton getButton_buscarConsultar() {
		return button_buscarConsultar;
	}

	public void setButton_buscarConsultar(JButton button_buscarConsultar) {
		this.button_buscarConsultar = button_buscarConsultar;
	}

	public JComboBox<String> getComboBox_CitasPendientes() {
		return comboBox_CitasPendientes;
	}

	public void setComboBox_CitasPendientes(JComboBox<String> comboBox_CitasPendientes) {
		this.comboBox_CitasPendientes = comboBox_CitasPendientes;
	}

	public JButton getBtnEliminarCita() {
		return btnEliminarCita;
	}

	public void setBtnEliminarCita(JButton btnEliminarCita) {
		this.btnEliminarCita = btnEliminarCita;
	}

	public JTextPane getTextPanex_CitasPendientes() {
		return textPanex_CitasPendientes;
	}

	public void setTextPanex_CitasPendientes(JTextPane textPanex_CitasPendientes) {
		this.textPanex_CitasPendientes = textPanex_CitasPendientes;
	}

	public JButton getBtnAgregarPaciente() {
		return btnAgregarPaciente;
	}

	public void setBtnAgregarPaciente(JButton btnAgregarPaciente) {
		this.btnAgregarPaciente = btnAgregarPaciente;
	}
	
	public JTextField getTextField_Mensaje() {
		return textField_Mensaje;
	}

	public void setTextField_Mensaje(JTextField textField_Mensaje) {
		this.textField_Mensaje = textField_Mensaje;
	}

	public JComboBox<Usuarios> getComboBoxUSUARIOS() {
		return comboBoxUSUARIOS;
	}

	public void setComboBoxUSUARIOS(JComboBox<Usuarios> comboBoxUSUARIOS) {
		this.comboBoxUSUARIOS = comboBoxUSUARIOS;
	}

	public JButton getBtnDifundirMensaje() {
		return btnDifundirMensaje;
	}

	public void setBtnDifundirMensaje(JButton btnDifundirMensaje) {
		this.btnDifundirMensaje = btnDifundirMensaje;
	}

	public JButton getBtnEnviarMensajePrivado() {
		return btnEnviarMensajePrivado;
	}

	public void setBtnEnviarMensajePrivado(JButton btnEnviarMensajePrivado) {
		this.btnEnviarMensajePrivado = btnEnviarMensajePrivado;
	}

	public JTextArea getTextArea_Visualizador() {
		return textArea_Visualizador;
	}

	public void setTextArea_Visualizador(JTextArea textArea_Visualizador) {
		this.textArea_Visualizador = textArea_Visualizador;
	}
	
	
}
