package interfaz;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PanelMudanza extends JPanel implements ActionListener {
	public final static String REGISTRAR_MUDANZA = "Registrar Mudanza";
	public final static String CARGAR_ARTICULO = "Cargar Articulo";
	public final static String LIMPIAR = "Limpiar";
	public final static String CONSULTAR = "Consultar";

	private Ventana ventana;

	private JComboBox cmbConsecutivos, cmbClientes;

	private DefaultComboBoxModel cmbModelMudanzas, cmbModelClientes;

	private JTextField txtDireccionSalida, txtDireccionLlegada, txtPeso,
			txtDescripcion;

	private JCheckBox chkRealizado, chkEsFragil;

	private JButton btnRegistrar, btnCargar, btnConsultar, btnRealizar, btnLimpiar ;

	public PanelMudanza(Ventana ventana) {
		this.ventana = ventana;

		this.setBorder(BorderFactory.createTitledBorder("Mudanzas"));

		// Panel superior
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBorder(BorderFactory
				.createTitledBorder("*** Consulta ***"));
		panelSuperior.setLayout(new GridLayout(1, 3, 15, 15));

		this.cmbModelMudanzas = new DefaultComboBoxModel();
		this.cmbConsecutivos = new JComboBox(this.cmbModelMudanzas);

		this.btnConsultar = new JButton(CONSULTAR);
		this.btnConsultar.setActionCommand(CONSULTAR);
		this.btnConsultar.addActionListener(this);
		this.btnConsultar.setEnabled(false);

		panelSuperior.add(new JLabel("Consecutivo: "));
		panelSuperior.add(this.cmbConsecutivos);
		panelSuperior.add(btnConsultar);

		this.add(panelSuperior, BorderLayout.NORTH);
		// Fin Panel superior

		// Panel Central
		JPanel panelCentral = new JPanel();
		panelCentral.setBorder(BorderFactory
				.createTitledBorder("*** Registro ***"));
		panelCentral.setLayout(new GridLayout(6, 2, 2, 2));

		this.cmbModelClientes = new DefaultComboBoxModel();
		this.cmbClientes = new JComboBox(this.cmbModelClientes);
		this.txtDireccionSalida = new JTextField(10);
		this.txtDireccionLlegada = new JTextField(10);
		this.chkRealizado = new JCheckBox("Realizado");
		this.chkRealizado.setEnabled(false);

		this.btnRegistrar = new JButton(REGISTRAR_MUDANZA);
		this.btnRegistrar.setActionCommand(REGISTRAR_MUDANZA);
		this.btnRegistrar.addActionListener(this);
		this.btnRegistrar.setEnabled(false);

		btnLimpiar = new JButton(LIMPIAR);
		btnLimpiar.setActionCommand(LIMPIAR);
		btnLimpiar.addActionListener(this);
		btnLimpiar.setEnabled(false);
		
		btnRealizar = new JButton("Cambiar a realizado");
		btnRealizar.setActionCommand("finalizar");
		btnRealizar.addActionListener(this);
		btnRealizar.setEnabled(false);

		panelCentral.add(new JLabel("Cliente: "));
		panelCentral.add(this.cmbClientes);
		panelCentral.add(new JLabel("Dir. Salida: "));
		panelCentral.add(this.txtDireccionSalida);
		panelCentral.add(new JLabel("Dir. Llegada: "));
		panelCentral.add(this.txtDireccionLlegada);
		panelCentral.add(new JLabel(""));
		panelCentral.add(this.chkRealizado);
		panelCentral.add(btnLimpiar);
		panelCentral.add(this.btnRegistrar);
		panelCentral.add(new JLabel(""));
		panelCentral.add(this.btnRealizar);
		

		this.add(panelCentral, BorderLayout.CENTER);
		// Fin Panel central

		// Panel inferior
		JPanel panelInferior = new JPanel();
		// panelInferior.setSize(200, 100);
		panelInferior.setBorder(BorderFactory
				.createTitledBorder("*** Carga de articulos a la mudanza ***"));
		panelInferior.setLayout(new GridLayout(3, 3));

		this.chkEsFragil = new JCheckBox("Fragil");
		this.chkEsFragil.setEnabled(false);
		this.txtDescripcion = new JTextField(2);
		this.txtDescripcion.setEnabled(false);
		this.txtPeso = new JTextField(2);
		this.txtPeso.setEnabled(false);

		this.btnCargar = new JButton(CARGAR_ARTICULO);
		this.btnCargar.setActionCommand(CARGAR_ARTICULO);
		this.btnCargar.addActionListener(this);
		this.btnCargar.setEnabled(false);

		/*
		panelInferior.add(new JLabel("Categoria"));
		panelInferior.add(new JLabel("Descripcion"));
		panelInferior.add(new JLabel("Peso"));
		panelInferior.add(this.chkEsFragil);
		panelInferior.add(this.txtDescripcion);
		panelInferior.add(this.txtPeso);
		panelInferior.add(new JLabel(""));
		panelInferior.add(new JLabel(""));
		panelInferior.add(this.btnCargar);
*/
		this.add(panelInferior, BorderLayout.SOUTH);
		// Fin Panel inferior
	}

	public void limpiar(){
		//this.ventana.actualizarMudanza();
		this.txtDireccionSalida.setText("");
		this.txtDireccionSalida.setEditable(true);
		this.txtDireccionLlegada.setText("");
		this.txtDireccionLlegada.setEditable(true);
		this.txtPeso.setText("");
		this.txtPeso.setEnabled(false);
		this.txtDescripcion.setText("");
		this.txtDescripcion.setEnabled(false);
		this.chkRealizado.setEnabled(false);
		this.chkRealizado.setSelected(false);		
		this.getBtnRegistrar().setEnabled(true);
		this.btnRealizar.setEnabled(false);
		getBtnCargar().setEnabled(false);
		getChkEsFragil().setEnabled(false);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(LIMPIAR)) {
			limpiar();
		} else if (event.getActionCommand().equals(CONSULTAR)) {
			
			this.ventana.consultarMudanza((String) this.cmbConsecutivos.getSelectedItem());
//			JOptionPane
//					.showMessageDialog(
//							this.ventana,
//							"Para r este cambio debe dar clic en Cambiar.",
//							"Informacion", JOptionPane.INFORMATION_MESSAGE);
		} else if (event.getActionCommand().equals(REGISTRAR_MUDANZA)) {
			String cedulaCliente = (String) this.cmbClientes.getSelectedItem();
			String direccionSalida = this.txtDireccionSalida.getText();
			String direccionLlegada = this.txtDireccionLlegada.getText();

			String respuesta = this.ventana.registrarMudanza(cedulaCliente,
					direccionSalida, direccionLlegada);

			JOptionPane.showMessageDialog(this.ventana, respuesta, "Resultado",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (event.getActionCommand().equals(CARGAR_ARTICULO)) {
			String descripcion = this.txtDescripcion.getText();
			String peso = this.txtPeso.getText();
			String respuesta = this.ventana.cargarArticulo(descripcion, peso,
					this.chkEsFragil.isSelected());
			JOptionPane.showMessageDialog(this.ventana, respuesta, "Resultado",
					JOptionPane.INFORMATION_MESSAGE);
		}
		else if(event.getActionCommand().equals("finalizar")){
			this.ventana.actualizarMudanza();
			//System.out.print("finalizado");
			
		}
	}

	public DefaultComboBoxModel getCmbModelClientes() {
		return this.cmbModelClientes;
	}

	public DefaultComboBoxModel getCmbModelMudanzas() {
		return this.cmbModelMudanzas;
	}

	public JButton getBtnRegistrar() {
		return this.btnRegistrar;
	}

	public JButton getBtnCargar() {
		return this.btnCargar;
	}

	public JButton getBtnLimpiar() {
		return this.btnLimpiar;
	}

	public JButton getBtnConsultar() {
		return this.btnConsultar;
	}

	public JTextField getTxtDireccionSalida() {
		return txtDireccionSalida;
	}

	public JTextField getTxtDireccionLlegada() {
		return txtDireccionLlegada;
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public JTextField getTxtPeso() {
		return txtPeso;
	}

	public JCheckBox getChkRealizado() {
		return this.chkRealizado;
	}

	public JCheckBox getChkEsFragil() {
		return this.chkEsFragil;
	}
	
	public void botonActualizar(boolean e){
		btnRealizar.setEnabled(e);
	}
	public void chekActualizar(boolean e){
		chkRealizado.setEnabled(e);
	}

}
