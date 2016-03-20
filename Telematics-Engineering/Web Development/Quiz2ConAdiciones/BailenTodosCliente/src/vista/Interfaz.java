package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.JComboBox;

import java.awt.Choice;
import java.awt.List;
import java.awt.Scrollbar;

public class Interfaz {

	public JFrame frame;
	private JTextField textFieldNombreCompleto_Artista;
	private JTextField textFieldNombreArtistico_Artista;
	private JTextField textFieldId_Artista;
	private JTextField textFieldDireccionResidencia_Artista;
	private JTextField textFieldCiudadResidencia_Artista;
	private JTextField textFieldDireccion_Correspondencia_Artista;
	private JTextField textFieldCiudadCorrespondencia_Artista;
	private JTextField textFieldTelfono_Artista;
	private JTextField textFieldNumContacto_Artista;
	private JTextField textFieldNombre_Disco;
	private JTextField textFieldGenero_Disco;
	private JTextField textFieldNombre_Cancion;
	private JLabel labelCaratula_Disco;
	private JButton btnSeleccionarCaratula_Disco;
	private JButton btnRegistrarDisco_Disco;
	private JButton btnSeleccionarFoto_Artista;
	private JButton btnRegistrarArtista_Artista;
	private JLabel labelFoto_Artista;
	private JTextField textFieldDuracion_Cancion;
	private JComboBox comboBoxDisco_Cancion;
	private JButton btnRegistroCancion_Cancion;
	private JTextField textFieldBuscarDisco_Ventas;
	private JLabel labelCaratula_Ventas;
	private JButton btnBuscarDisco_Ventas;
	private JComboBox<String> comboBoxBusquedaPor_Ventas;
	private List listaResultados_Ventas;
	private JButton btnVenderDisco_Ventas;
	private JTextField textFieldDisponibles_Disco;
	private List listaResultadosCancion_Ventas;
	private JComboBox<String> comboBoxTipoId_Artista;
	private List listResultados_Estadisticas;
	private ImageIcon fotoArtista;
	private ImageIcon caratulaDisco;
	private JLabel label_MiniaturaDisco_Cacion;
	private JLabel labelMinuaturaArtista_Cancion;
	private JComboBox comboBoxArtista_Cancion;
	private JComboBox comboBoxArtistaPrincipal_Disco;
	private JTextField textFieldNumDiscos_Ventas;
	private JTextField textFieldNumVendidos_Estadisticas;
	private JTextField textFieldNumDisponibles_Estadisticas;
	private JLabel lblHazDobleClick;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_artista = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane_artista, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Artista", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPane_artista.addTab("Registro Artistas", null, panel, null);
		
		btnSeleccionarFoto_Artista = new JButton("Seleccionar Foto");
		btnSeleccionarFoto_Artista.setBounds(452, 203, 111, 23);
		
		labelFoto_Artista = new JLabel(" ");
		labelFoto_Artista.setBounds(452, 37, 111, 148);
		
		JLabel lblNombreCompleto = new JLabel("Nombre Completo");
		lblNombreCompleto.setBounds(16, 50, 85, 14);
		
		JLabel lblNombreArtistico = new JLabel("Nombre Artistico");
		lblNombreArtistico.setBounds(16, 88, 79, 14);
		
		JLabel lblTipoId = new JLabel("Tipo Id");
		lblTipoId.setBounds(16, 123, 33, 14);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(16, 162, 10, 14);
		
		JLabel lblDireccionResidencia = new JLabel("Direccion Residencia");
		lblDireccionResidencia.setBounds(16, 205, 97, 14);
		
		JLabel lblDireccionCorrespondencia = new JLabel("Direccion Correspondencia");
		lblDireccionCorrespondencia.setBounds(16, 281, 127, 14);
		
		JLabel lblCiudadResidencia = new JLabel("Ciudad Residencia");
		lblCiudadResidencia.setBounds(16, 240, 87, 14);
		
		JLabel lblCiudadCorrespondencia = new JLabel("Ciudad Correspondencia");
		lblCiudadCorrespondencia.setBounds(16, 318, 117, 14);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(16, 355, 42, 14);
		
		JLabel lblNumeroDeContacto = new JLabel("Numero de Contacto");
		lblNumeroDeContacto.setBounds(16, 391, 99, 14);
		
		textFieldNombreCompleto_Artista = new JTextField();
		textFieldNombreCompleto_Artista.setBounds(161, 47, 260, 20);
		textFieldNombreCompleto_Artista.setColumns(10);
		
		textFieldNombreArtistico_Artista = new JTextField();
		textFieldNombreArtistico_Artista.setBounds(161, 85, 260, 20);
		textFieldNombreArtistico_Artista.setColumns(10);
		
		textFieldId_Artista = new JTextField();
		textFieldId_Artista.setBounds(161, 159, 260, 20);
		textFieldId_Artista.setColumns(10);
		
		textFieldDireccionResidencia_Artista = new JTextField();
		textFieldDireccionResidencia_Artista.setBounds(161, 202, 260, 20);
		textFieldDireccionResidencia_Artista.setColumns(10);
		
		textFieldCiudadResidencia_Artista = new JTextField();
		textFieldCiudadResidencia_Artista.setBounds(161, 237, 260, 20);
		textFieldCiudadResidencia_Artista.setColumns(10);
		panel.setLayout(null);
		panel.add(lblNombreCompleto);
		panel.add(lblNombreArtistico);
		panel.add(lblTipoId);
		panel.add(lblId);
		panel.add(lblDireccionResidencia);
		panel.add(lblDireccionCorrespondencia);
		panel.add(lblCiudadResidencia);
		panel.add(lblCiudadCorrespondencia);
		panel.add(lblTelefono);
		panel.add(lblNumeroDeContacto);
		panel.add(textFieldNombreCompleto_Artista);
		panel.add(textFieldNombreArtistico_Artista);
		panel.add(textFieldId_Artista);
		panel.add(textFieldDireccionResidencia_Artista);
		panel.add(textFieldCiudadResidencia_Artista);
		panel.add(labelFoto_Artista);
		panel.add(btnSeleccionarFoto_Artista);
		
		textFieldDireccion_Correspondencia_Artista = new JTextField();
		textFieldDireccion_Correspondencia_Artista.setBounds(161, 272, 260, 20);
		panel.add(textFieldDireccion_Correspondencia_Artista);
		textFieldDireccion_Correspondencia_Artista.setColumns(10);
		
		textFieldCiudadCorrespondencia_Artista = new JTextField();
		textFieldCiudadCorrespondencia_Artista.setBounds(161, 315, 260, 20);
		panel.add(textFieldCiudadCorrespondencia_Artista);
		textFieldCiudadCorrespondencia_Artista.setColumns(10);
		
		textFieldTelfono_Artista = new JTextField();
		textFieldTelfono_Artista.setBounds(161, 352, 260, 20);
		panel.add(textFieldTelfono_Artista);
		textFieldTelfono_Artista.setColumns(10);
		
		textFieldNumContacto_Artista = new JTextField();
		textFieldNumContacto_Artista.setBounds(161, 388, 260, 20);
		panel.add(textFieldNumContacto_Artista);
		textFieldNumContacto_Artista.setColumns(10);
		
		btnRegistrarArtista_Artista = new JButton("REGISTRAR");
		btnRegistrarArtista_Artista.setBounds(452, 351, 111, 54);
		panel.add(btnRegistrarArtista_Artista);
		
		comboBoxTipoId_Artista = new JComboBox<String>();
		comboBoxTipoId_Artista.setBounds(161, 120, 260, 20);
		panel.add(comboBoxTipoId_Artista);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_artista.addTab("Registro Discos y Canciones", null, panel_1, null);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Discos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 32, 46, 14);
		panel_3.add(lblTitulo);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(10, 57, 46, 14);
		panel_3.add(lblGenero);
		
		textFieldNombre_Disco = new JTextField();
		textFieldNombre_Disco.setBounds(115, 29, 264, 20);
		panel_3.add(textFieldNombre_Disco);
		textFieldNombre_Disco.setColumns(10);
		
		textFieldGenero_Disco = new JTextField();
		textFieldGenero_Disco.setBounds(114, 54, 265, 20);
		panel_3.add(textFieldGenero_Disco);
		textFieldGenero_Disco.setColumns(10);
		
		labelCaratula_Disco = new JLabel(" ");
		labelCaratula_Disco.setBounds(389, 32, 190, 140);
		panel_3.add(labelCaratula_Disco);
		
		btnSeleccionarCaratula_Disco = new JButton("Seleccionar Caratula");
		btnSeleccionarCaratula_Disco.setBounds(10, 145, 331, 23);
		panel_3.add(btnSeleccionarCaratula_Disco);
		
		btnRegistrarDisco_Disco = new JButton("REGISTRAR DISCO");
		btnRegistrarDisco_Disco.setBounds(10, 179, 569, 23);
		panel_3.add(btnRegistrarDisco_Disco);
		
		JLabel lblUnidadesDisponibles = new JLabel("Unidades Disponibles");
		lblUnidadesDisponibles.setBounds(10, 120, 100, 14);
		panel_3.add(lblUnidadesDisponibles);
		
		textFieldDisponibles_Disco = new JTextField();
		textFieldDisponibles_Disco.setBounds(115, 114, 264, 20);
		panel_3.add(textFieldDisponibles_Disco);
		textFieldDisponibles_Disco.setColumns(10);
		
		JLabel lblArtistaPrincipal = new JLabel("Artista Principal");
		lblArtistaPrincipal.setBounds(10, 82, 81, 27);
		panel_3.add(lblArtistaPrincipal);
		
		comboBoxArtistaPrincipal_Disco = new JComboBox();
		comboBoxArtistaPrincipal_Disco.setBounds(115, 85, 264, 20);
		panel_3.add(comboBoxArtistaPrincipal_Disco);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Canciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		textFieldNombre_Cancion = new JTextField();
		textFieldNombre_Cancion.setText("");
		textFieldNombre_Cancion.setBounds(79, 26, 262, 20);
		panel_2.add(textFieldNombre_Cancion);
		textFieldNombre_Cancion.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 29, 46, 14);
		panel_2.add(lblNombre);
		
		JLabel lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(10, 60, 46, 14);
		panel_2.add(lblDuracion);
		
		JLabel lblAlbumDisco = new JLabel("Album-Disco");
		lblAlbumDisco.setBounds(10, 148, 68, 14);
		panel_2.add(lblAlbumDisco);
		
		textFieldDuracion_Cancion = new JTextField();
		textFieldDuracion_Cancion.setBounds(79, 57, 262, 20);
		panel_2.add(textFieldDuracion_Cancion);
		textFieldDuracion_Cancion.setColumns(10);
		
		btnRegistroCancion_Cancion = new JButton("REGISTRO CANCION");
		btnRegistroCancion_Cancion.setBounds(10, 176, 569, 23);
		panel_2.add(btnRegistroCancion_Cancion);
		
		comboBoxDisco_Cancion = new JComboBox();
		comboBoxDisco_Cancion.setBounds(79, 145, 262, 20);
		panel_2.add(comboBoxDisco_Cancion);
		
		JLabel lblArtista_Cancion = new JLabel("Artista");
		lblArtista_Cancion.setBounds(10, 106, 46, 14);
		panel_2.add(lblArtista_Cancion);
		
		comboBoxArtista_Cancion = new JComboBox();
		comboBoxArtista_Cancion.setBounds(79, 103, 262, 20);
		panel_2.add(comboBoxArtista_Cancion);
		
		labelMinuaturaArtista_Cancion = new JLabel(" ");
		labelMinuaturaArtista_Cancion.setBounds(394, 11, 112, 75);
		panel_2.add(labelMinuaturaArtista_Cancion);
		
		label_MiniaturaDisco_Cacion = new JLabel(" ");
		label_MiniaturaDisco_Cacion.setBounds(394, 87, 112, 75);
		panel_2.add(label_MiniaturaDisco_Cacion);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ventas ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPane_artista.addTab("Ventas", null, panel_4, null);
		panel_4.setLayout(null);
		
		textFieldBuscarDisco_Ventas = new JTextField();
		textFieldBuscarDisco_Ventas.setBounds(10, 47, 373, 20);
		panel_4.add(textFieldBuscarDisco_Ventas);
		textFieldBuscarDisco_Ventas.setColumns(10);
		
		btnBuscarDisco_Ventas = new JButton("BUSCAR");
		btnBuscarDisco_Ventas.setBounds(490, 46, 89, 23);
		panel_4.add(btnBuscarDisco_Ventas);
		
		comboBoxBusquedaPor_Ventas = new JComboBox<String>();
		comboBoxBusquedaPor_Ventas.setBounds(393, 47, 87, 20);
		panel_4.add(comboBoxBusquedaPor_Ventas);
		
		
		listaResultados_Ventas = new List();
		listaResultados_Ventas.setBounds(10, 73, 373, 155);
		panel_4.add(listaResultados_Ventas);
		
		labelCaratula_Ventas = new JLabel(" ");
		labelCaratula_Ventas.setBounds(393, 80, 186, 145);
		panel_4.add(labelCaratula_Ventas);
		
		btnVenderDisco_Ventas = new JButton("VENDER DISCO");
		btnVenderDisco_Ventas.setBounds(386, 395, 193, 23);
		panel_4.add(btnVenderDisco_Ventas);
		
		listaResultadosCancion_Ventas = new List();
		listaResultadosCancion_Ventas.setBounds(10, 234, 373, 155);
		panel_4.add(listaResultadosCancion_Ventas);
		
		JLabel lblNumeroDeDiscos_2 = new JLabel("Numero de Discos:");
		lblNumeroDeDiscos_2.setBounds(10, 399, 99, 14);
		panel_4.add(lblNumeroDeDiscos_2);
		
		textFieldNumDiscos_Ventas = new JTextField();
		textFieldNumDiscos_Ventas.setBounds(153, 396, 86, 20);
		panel_4.add(textFieldNumDiscos_Ventas);
		textFieldNumDiscos_Ventas.setColumns(10);
		
		lblHazDobleClick = new JLabel("Haz doble click sobre el disco buscado para ver mas informacion");
		lblHazDobleClick.setBounds(10, 25, 569, 14);
		panel_4.add(lblHazDobleClick);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Estadisticas de ventas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane_artista.addTab("Estadisticas", null, panel_5, null);
		panel_5.setLayout(null);
		
		JLabel lblNumeroDeDiscos = new JLabel("Numero de discos vendidos");
		lblNumeroDeDiscos.setBounds(10, 44, 139, 14);
		panel_5.add(lblNumeroDeDiscos);
		
		JLabel lblNumeroDeDiscos_1 = new JLabel("Numero de discos disponibles");
		lblNumeroDeDiscos_1.setBounds(10, 81, 146, 14);
		panel_5.add(lblNumeroDeDiscos_1);
		
		listResultados_Estadisticas = new List();
		listResultados_Estadisticas.setBounds(20, 122, 559, 311);
		panel_5.add(listResultados_Estadisticas);
		
		textFieldNumVendidos_Estadisticas = new JTextField();
		textFieldNumVendidos_Estadisticas.setEditable(false);
		textFieldNumVendidos_Estadisticas.setBounds(169, 41, 86, 20);
		panel_5.add(textFieldNumVendidos_Estadisticas);
		textFieldNumVendidos_Estadisticas.setColumns(10);
		
		textFieldNumDisponibles_Estadisticas = new JTextField();
		textFieldNumDisponibles_Estadisticas.setEditable(false);
		textFieldNumDisponibles_Estadisticas.setBounds(169, 75, 86, 20);
		panel_5.add(textFieldNumDisponibles_Estadisticas);
		textFieldNumDisponibles_Estadisticas.setColumns(10);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextFieldNombreCompleto_Artista() {
		return textFieldNombreCompleto_Artista;
	}

	public void setTextFieldNombreCompleto_Artista(
			JTextField textFieldNombreCompleto_Artista) {
		this.textFieldNombreCompleto_Artista = textFieldNombreCompleto_Artista;
	}

	public JTextField getTextFieldNombreArtistico_Artista() {
		return textFieldNombreArtistico_Artista;
	}

	public void setTextFieldNombreArtistico_Artista(
			JTextField textFieldNombreArtistico_Artista) {
		this.textFieldNombreArtistico_Artista = textFieldNombreArtistico_Artista;
	}

	public JTextField getTextFieldId_Artista() {
		return textFieldId_Artista;
	}

	public void setTextFieldId_Artista(JTextField textFieldId_Artista) {
		this.textFieldId_Artista = textFieldId_Artista;
	}

	public JTextField getTextFieldDireccionResidencia_Artista() {
		return textFieldDireccionResidencia_Artista;
	}

	public void setTextFieldDireccionResidencia_Artista(
			JTextField textFieldDireccionResidencia_Artista) {
		this.textFieldDireccionResidencia_Artista = textFieldDireccionResidencia_Artista;
	}

	public JTextField getTextFieldCiudadResidencia_Artista() {
		return textFieldCiudadResidencia_Artista;
	}

	public void setTextFieldCiudadResidencia_Artista(
			JTextField textFieldCiudadResidencia_Artista) {
		this.textFieldCiudadResidencia_Artista = textFieldCiudadResidencia_Artista;
	}

	public JTextField getTextFieldDireccion_Correspondencia_Artista() {
		return textFieldDireccion_Correspondencia_Artista;
	}

	public void setTextFieldDireccion_Correspondencia_Artista(
			JTextField textFieldDireccion_Correspondencia_Artista) {
		this.textFieldDireccion_Correspondencia_Artista = textFieldDireccion_Correspondencia_Artista;
	}

	public JTextField getTextFieldCiudadCorrespondencia_Artista() {
		return textFieldCiudadCorrespondencia_Artista;
	}

	public void setTextFieldCiudadCorrespondencia_Artista(
			JTextField textFieldCiudadCorrespondencia_Artista) {
		this.textFieldCiudadCorrespondencia_Artista = textFieldCiudadCorrespondencia_Artista;
	}

	public JTextField getTextFieldTelfono_Artista() {
		return textFieldTelfono_Artista;
	}

	public void setTextFieldTelfono_Artista(JTextField textFieldTelfono_Artista) {
		this.textFieldTelfono_Artista = textFieldTelfono_Artista;
	}

	public JTextField getTextFieldNumContacto_Artista() {
		return textFieldNumContacto_Artista;
	}

	public void setTextFieldNumContacto_Artista(
			JTextField textFieldNumContacto_Artista) {
		this.textFieldNumContacto_Artista = textFieldNumContacto_Artista;
	}

	public JTextField getTextFieldNombre_Disco() {
		return textFieldNombre_Disco;
	}

	public void setTextFieldNombre_Disco(JTextField textFieldNombre_Disco) {
		this.textFieldNombre_Disco = textFieldNombre_Disco;
	}

	public JTextField getTextFieldGenero_Disco() {
		return textFieldGenero_Disco;
	}

	public void setTextFieldGenero_Disco(JTextField textFieldGenero_Disco) {
		this.textFieldGenero_Disco = textFieldGenero_Disco;
	}

	public JTextField getTextFieldNombre_Cancion() {
		return textFieldNombre_Cancion;
	}

	public void setTextFieldNombre_Cancion(JTextField textFieldNombre_Cancion) {
		this.textFieldNombre_Cancion = textFieldNombre_Cancion;
	}

	public JLabel getLabelCaratula_Disco() {
		return labelCaratula_Disco;
	}

	public void setLabelCaratula_Disco(JLabel labelCaratula_Disco) {
		this.labelCaratula_Disco = labelCaratula_Disco;
	}

	public JButton getBtnSeleccionarCaratula_Disco() {
		return btnSeleccionarCaratula_Disco;
	}

	public void setBtnSeleccionarCaratula_Disco(JButton btnSeleccionarCaratula_Disco) {
		this.btnSeleccionarCaratula_Disco = btnSeleccionarCaratula_Disco;
	}

	public JButton getBtnRegistrarDisco_Disco() {
		return btnRegistrarDisco_Disco;
	}

	public void setBtnRegistrarDisco_Disco(JButton btnRegistrarDisco_Disco) {
		this.btnRegistrarDisco_Disco = btnRegistrarDisco_Disco;
	}

	public JButton getBtnSeleccionarFoto_Artista() {
		return btnSeleccionarFoto_Artista;
	}

	public void setBtnSeleccionarFoto_Artista(JButton btnSeleccionarFoto_Artista) {
		this.btnSeleccionarFoto_Artista = btnSeleccionarFoto_Artista;
	}

	public JButton getBtnRegistrarArtista_Artista() {
		return btnRegistrarArtista_Artista;
	}

	public void setBtnRegistrarArtista_Artista(JButton btnRegistrarArtista_Artista) {
		this.btnRegistrarArtista_Artista = btnRegistrarArtista_Artista;
	}

	public JLabel getLabelFoto_Artista() {
		return labelFoto_Artista;
	}

	public void setLabelFoto_Artista(JLabel labelFoto_Artista) {
		this.labelFoto_Artista = labelFoto_Artista;
	}

	public JTextField getTextFieldDuracion_Cancion() {
		return textFieldDuracion_Cancion;
	}

	public void setTextFieldDuracion_Cancion(JTextField textFieldDuracion_Cancion) {
		this.textFieldDuracion_Cancion = textFieldDuracion_Cancion;
	}

	public JComboBox getComboBoxDisco_Cancion() {
		return comboBoxDisco_Cancion;
	}

	public void setComboBoxDisco_Cancion(JComboBox comboBoxDisco_Cancion) {
		this.comboBoxDisco_Cancion = comboBoxDisco_Cancion;
	}

	public JButton getBtnRegistroCancion_Cancion() {
		return btnRegistroCancion_Cancion;
	}

	public void setBtnRegistroCancion_Cancion(JButton btnRegistroCancion_Cancion) {
		this.btnRegistroCancion_Cancion = btnRegistroCancion_Cancion;
	}

	public JTextField getTextFieldBuscarDisco_Ventas() {
		return textFieldBuscarDisco_Ventas;
	}

	public void setTextFieldBuscarDisco_Ventas(
			JTextField textFieldBuscarDisco_Ventas) {
		this.textFieldBuscarDisco_Ventas = textFieldBuscarDisco_Ventas;
	}

	public JLabel getLabelCaratula_Ventas() {
		return labelCaratula_Ventas;
	}

	public void setLabelCaratula_Ventas(JLabel labelCaratula_Ventas) {
		this.labelCaratula_Ventas = labelCaratula_Ventas;
	}

	public JButton getBtnBuscarDisco_Ventas() {
		return btnBuscarDisco_Ventas;
	}

	public void setBtnBuscarDisco_Ventas(JButton btnBuscarDisco_Ventas) {
		this.btnBuscarDisco_Ventas = btnBuscarDisco_Ventas;
	}

	public JComboBox<String> getComboBoxBusquedaPor_Ventas() {
		return comboBoxBusquedaPor_Ventas;
	}

	public void setComboBoxBusquedaPor_Ventas(JComboBox<String> comboBoxBusquedaPor_Ventas) {
		this.comboBoxBusquedaPor_Ventas = comboBoxBusquedaPor_Ventas;
	}

	public List getListaResultados_Ventas() {
		return listaResultados_Ventas;
	}

	public void setListaResultados_Ventas(List listaResultados_Ventas) {
		this.listaResultados_Ventas = listaResultados_Ventas;
	}

	public JButton getBtnVenderDisco_Ventas() {
		return btnVenderDisco_Ventas;
	}

	public void setBtnVenderDisco_Ventas(JButton btnVenderDisco_Ventas) {
		this.btnVenderDisco_Ventas = btnVenderDisco_Ventas;
	}

	public JTextField getTextFieldNumVendidos_Estadisticas() {
		return textFieldNumVendidos_Estadisticas;
	}

	public void setTextFieldNumVendidos_Estadisticas(
			JTextField textFieldNumVendidos_Estadisticas) {
		this.textFieldNumVendidos_Estadisticas = textFieldNumVendidos_Estadisticas;
	}

	public JTextField getTextFieldNumDisponibles_Estadisticas() {
		return textFieldNumDisponibles_Estadisticas;
	}

	public void setTextFieldNumDisponibles_Estadisticas(
			JTextField textFieldNumDisponibles_Estadisticas) {
		this.textFieldNumDisponibles_Estadisticas = textFieldNumDisponibles_Estadisticas;
	}

	public JTextField getTextFieldDisponibles_Disco() {
		return textFieldDisponibles_Disco;
	}

	public void setTextFieldDisponibles_Disco(JTextField textFieldDisponibles_Disco) {
		this.textFieldDisponibles_Disco = textFieldDisponibles_Disco;
	}

	public List getListaResultadosCancion_Ventas() {
		return listaResultadosCancion_Ventas;
	}

	public void setListaResultadosCancion_Ventas(List listaResultadosCancion_Ventas) {
		this.listaResultadosCancion_Ventas = listaResultadosCancion_Ventas;
	}

	public JComboBox<String> getComboBoxTipoId_Artista() {
		return comboBoxTipoId_Artista;
	}

	public void setComboBoxTipoId_Artista(JComboBox<String> comboBoxTipoId_Artista) {
		this.comboBoxTipoId_Artista = comboBoxTipoId_Artista;
	}

	public List getListREsultados_Estadisticas() {
		return listResultados_Estadisticas;
	}

	public void setListREsultados_Estadisticas(List listREsultados_Estadisticas) {
		this.listResultados_Estadisticas = listREsultados_Estadisticas;
	}

	public ImageIcon getFotoArtista() {
		return fotoArtista;
	}

	public void setFotoArtista(ImageIcon fotoArtista) {
		this.fotoArtista = fotoArtista;
	}

	public ImageIcon getCaratulaDisco() {
		return caratulaDisco;
	}

	public void setCaratulaDisco(ImageIcon caratulaDisco) {
		this.caratulaDisco = caratulaDisco;
	}

	public JLabel getLabel_MiniaturaDisco_Cacion() {
		return label_MiniaturaDisco_Cacion;
	}

	public void setLabel_MiniaturaDisco_Cacion(JLabel label_MiniaturaDisco_Cacion) {
		this.label_MiniaturaDisco_Cacion = label_MiniaturaDisco_Cacion;
	}

	public JLabel getLabelMinuaturaArtista_Cancion() {
		return labelMinuaturaArtista_Cancion;
	}

	public void setLabelMinuaturaArtista_Cancion(
			JLabel labelMinuaturaArtista_Cancion) {
		this.labelMinuaturaArtista_Cancion = labelMinuaturaArtista_Cancion;
	}

	public JComboBox getComboBoxArtista_Cancion() {
		return comboBoxArtista_Cancion;
	}

	public void setComboBoxArtista_Cancion(JComboBox comboBoxArtista_Cancion) {
		this.comboBoxArtista_Cancion = comboBoxArtista_Cancion;
	}

	public JComboBox getComboBoxArtistaPrincipal_Disco() {
		return comboBoxArtistaPrincipal_Disco;
	}

	public void setComboBoxArtistaPrincipal_Disco(
			JComboBox comboBoxArtistaPrincipal_Disco) {
		this.comboBoxArtistaPrincipal_Disco = comboBoxArtistaPrincipal_Disco;
	}

	public JTextField getTextFieldNumDiscos_Ventas() {
		return textFieldNumDiscos_Ventas;
	}

	public void setTextFieldNumDiscos_Ventas(JTextField textFieldNumDiscos_Ventas) {
		this.textFieldNumDiscos_Ventas = textFieldNumDiscos_Ventas;
	}

	public List getListResultados_Estadisticas() {
		return listResultados_Estadisticas;
	}

	public void setListResultados_Estadisticas(List listResultados_Estadisticas) {
		this.listResultados_Estadisticas = listResultados_Estadisticas;
	}
}
