package interfazEntreNubes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import mundo.*;

public class panelAdministracion extends JPanel implements ActionListener {

	// Agregar Ciudad
	private JLabel labCiudadOrigen;
	private JLabel labNombreCiudad;
	private JLabel labAeropuertoLlegada;
	private JLabel labDistanciaCiudades;
	private JLabel labTiempoVuelo;
	private JComboBox cbCiudadOrigen;
	private JTextField txtNombreCiudad;
	private JTextField txtAeropuertoLlegada;
	private JTextField txtDistanciaCiudades;
	private JTextField txtTiempoVuelo;
	private JButton btnAgregarCiudad;
	public final static String AGREGAR_CIUDAD = "Agregar ciudad";

	// Eliminar
	private JLabel labNombreCiudadE;
	private JComboBox cbNombreCiudadE;
	private JButton btnEliminar;

	public final static String ELIMINAR_CIUDAD = "Eliminar Ciudad";

	// Relacion con la principal
	private interfazEntreNube principal;

	public panelAdministracion(interfazEntreNube ventana) {

		principal = ventana;
		setLayout(new BorderLayout());
		TitledBorder bordePanel = new TitledBorder("Administracion");
		TitledBorder bordeEliminar = new TitledBorder("Eliminar Ciudad");
		TitledBorder bordeAgregar = new TitledBorder("Agregar Ciudad");
		setPreferredSize(new Dimension(400, 310));
		setBorder(bordePanel);

		// Panel de Agregar Ciudad
		JPanel interno = new JPanel();
		interno.setLayout(new BorderLayout());
		interno.setBorder(bordeAgregar);
		// Panel de Eliminar Ciudad
		JPanel interno2 = new JPanel();
		interno2.setLayout(new BorderLayout());
		interno2.setBorder(bordeEliminar);

		// Paneles
		JPanel internoAgregar = new JPanel();
		internoAgregar.setLayout(new GridLayout(5, 2));

		JPanel internoEliminar = new JPanel();
		internoEliminar.setLayout(new GridLayout(1, 2));

		// Crear Ciudad
		labCiudadOrigen = new JLabel("Ciudad Origen");
		labNombreCiudad = new JLabel("Nombre Ciudad");
		labAeropuertoLlegada = new JLabel("Aeropuerto Llegada");
		labDistanciaCiudades = new JLabel("Distancia entre ciudades (Km)");
		labTiempoVuelo = new JLabel("Tiempo de vuelo");

		txtNombreCiudad = new JTextField();
		txtNombreCiudad.setEditable(true);

		txtAeropuertoLlegada = new JTextField();
		txtAeropuertoLlegada.setEditable(true);

		txtDistanciaCiudades = new JTextField();
		txtDistanciaCiudades.setEditable(true);

		txtTiempoVuelo = new JTextField();
		txtTiempoVuelo.setEditable(true);

		cbCiudadOrigen = new JComboBox<>();

		btnAgregarCiudad = new JButton();
		btnAgregarCiudad.setText(AGREGAR_CIUDAD);
		btnAgregarCiudad.setActionCommand(AGREGAR_CIUDAD);
		btnAgregarCiudad.addActionListener(this);

		// Eliminar Ciudad
		labNombreCiudadE = new JLabel("Nombre Ciudad");
		cbNombreCiudadE = new JComboBox();
		
		btnEliminar = new JButton();
		btnEliminar.setText(ELIMINAR_CIUDAD);
		btnEliminar.setActionCommand(ELIMINAR_CIUDAD);
		btnEliminar.addActionListener(this);

		internoAgregar.add(labCiudadOrigen);
		internoAgregar.add(cbCiudadOrigen);
		internoAgregar.add(labNombreCiudad);
		internoAgregar.add(txtNombreCiudad);
		internoAgregar.add(labAeropuertoLlegada);
		internoAgregar.add(txtAeropuertoLlegada);
		internoAgregar.add(labDistanciaCiudades);
		internoAgregar.add(txtDistanciaCiudades);
		internoAgregar.add(labTiempoVuelo);
		internoAgregar.add(txtTiempoVuelo);
		internoAgregar.add(btnAgregarCiudad);
		interno.add(internoAgregar, BorderLayout.NORTH);
		interno.add(btnAgregarCiudad, BorderLayout.CENTER);

		internoEliminar.add(labNombreCiudadE);
		internoEliminar.add(cbNombreCiudadE);
		internoEliminar.add(btnEliminar);
		interno2.add(internoEliminar, BorderLayout.NORTH);
		interno2.add(new JLabel(), BorderLayout.SOUTH);
		interno2.add(btnEliminar, BorderLayout.SOUTH);;

		add(interno, BorderLayout.NORTH);
		add(interno2, BorderLayout.CENTER);
	}

	public void refrescarCbNombreCiudades(ArrayList<String> list) {

		cbNombreCiudadE.removeAllItems();

		for (int i = 0; i < list.size(); i++) {
			cbNombreCiudadE.addItem(list.get(i));
		}
	}

	public void refrescarCbCiudadOrigen(ArrayList<String> list) {

		cbCiudadOrigen.removeAllItems();

		for (int i = 0; i < list.size(); i++) {
			cbCiudadOrigen.addItem(list.get(i));
		}
	}

	public void actionPerformed(ActionEvent evento) {

		String comando = evento.getActionCommand();

		if (comando.equalsIgnoreCase(AGREGAR_CIUDAD)) {
			
			principal.agregarCiudad();

		} else if (comando.equalsIgnoreCase(ELIMINAR_CIUDAD)) {
			
			principal.eliminarCiudad();

		}

	}

	public String darCbCiudadOrigen() {
		return (String)cbCiudadOrigen.getSelectedItem();
	}

	public String darCbNombreCiudadE() {
		return (String)cbNombreCiudadE.getSelectedItem();
	}

	public String darTxtNombreCiudad() {
		return txtNombreCiudad.getText();
	}

	public String darTxtAeropuertoLlegada() {
		return txtAeropuertoLlegada.getText();
	}

	public String darTxtDistanciaCiudades() {
		return txtDistanciaCiudades.getText();
	}

	public String darTxtTiempoVuelo() {
		return txtTiempoVuelo.getText();
	}


}
