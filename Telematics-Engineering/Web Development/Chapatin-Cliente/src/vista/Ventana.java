package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

import javax.swing.JList;
import javax.swing.JTextArea;

import java.awt.GridBagLayout;

import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JComboBox;

import control.Ejecutable;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private JTextField txtCelular;
	private JTextField txtTelefono;
	private JTextField txtCedula;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtFecha;
	private JButton btnRegistrar;
	private JButton btnVerificar;
	private JButton btnDifusion;
	private JTextArea textArea;
	private Ejecutable princi;

	/**
	 * @wbp.nonvisual location=-14,249
	 */
	private final JList list = new JList();
	private JTextField txtEnviar;
	private JTextField txtVerificar;


	/**
	 * Create the frame.
	 */
	public Ventana() {
		
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel tabPacientes = new JPanel();
		tabbedPane.addTab("Registrar Paciente", null, tabPacientes, null);
		tabPacientes.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel pnlRegistro = new JPanel();
		pnlRegistro.setBorder(new TitledBorder("Datos Paciente"));
		tabPacientes.add(pnlRegistro);
		pnlRegistro.setLayout(new GridLayout(8, 2, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		pnlRegistro.add(lblNewLabel_4);
		
		txtNombre = new JTextField();
		pnlRegistro.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido");
		pnlRegistro.add(lblNewLabel_3);
		
		txtApellido = new JTextField();
		pnlRegistro.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cedula");
		pnlRegistro.add(lblNewLabel_2);
		
		txtCedula = new JTextField();
		pnlRegistro.add(txtCedula);
		txtCedula.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		pnlRegistro.add(lblDireccion);
		
		txtDireccion = new JTextField();
		pnlRegistro.add(txtDireccion);
		txtDireccion.setColumns(10);
		 
		JLabel lblNewLabel_1 = new JLabel("Telefono");
		pnlRegistro.add(lblNewLabel_1);
		
		txtTelefono = new JTextField();
		pnlRegistro.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Celular");
		pnlRegistro.add(lblNewLabel);
		
		txtCelular = new JTextField();
		pnlRegistro.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblNew = new JLabel("Fecha de nacimiento");
		pnlRegistro.add(lblNew);
		
		txtFecha = new JTextField();
		pnlRegistro.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lbVacior = new JLabel();
		pnlRegistro.add(lbVacior);
		
		btnRegistrar = new JButton("Registrar");	
		btnRegistrar.setActionCommand("Registrar");
		pnlRegistro.add(btnRegistrar);	
		
		
		JPanel tabCitas = new JPanel();
		tabbedPane.addTab("Consulta Paciente", null, tabCitas, null);
		tabCitas.setLayout(new BorderLayout());
		
		JPanel panel_6 = new JPanel();
		tabCitas.add(panel_6,BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(1,3));
		
		JLabel lblVerificarPaciente = new JLabel("Verificar paciente");
		panel_6.add(lblVerificarPaciente);
		
		
		txtVerificar = new JTextField();
		panel_6.add(txtVerificar);		
		
		btnVerificar = new JButton("Verificar");		
		panel_6.add(btnVerificar);	
		
		
		JLabel lbImagen = new JLabel();
		tabCitas.add(lbImagen,BorderLayout.CENTER);	
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Chat", null, panel, null);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 5, 5));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(8, 8));
		
		JLabel lblContactos = new JLabel("Contactos");
		lblContactos.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblContactos, BorderLayout.NORTH);
		
		JList list_1 = new JList();
		panel_4.add(list_1, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout( 5, 5));
		
				
		txtEnviar = new JTextField();
		panel_3.add(txtEnviar,BorderLayout.CENTER);
		txtEnviar.setColumns(10);
		
		txtEnviar.setPreferredSize(new Dimension(550,30));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(1,2));
		panel_3.add(panelBotones, BorderLayout.SOUTH);
		
		
		JButton btnNewButton = new JButton("Enviar");
		panelBotones.add(btnNewButton);
		
		btnDifusion = new JButton("Difusión");
		panelBotones.add(btnDifusion);
		
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		textArea = new JTextArea();
		panel_2.add(textArea);
		
		
	pack();	
		
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JTextField getTxtCelular() {
		return txtCelular;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}	

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public JTextField getTxtFecha() {
		return txtFecha;
	}

	public JTextField getTxtEnviar() {
		return txtEnviar;
	}

	public JTextField getTxtVerificar() {
		return txtVerificar;
	}
	
	public JButton getBtnVerificar() {
		return btnVerificar;
	}

	public JButton getBtnDifusion() {
		return btnDifusion;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	
	

}
