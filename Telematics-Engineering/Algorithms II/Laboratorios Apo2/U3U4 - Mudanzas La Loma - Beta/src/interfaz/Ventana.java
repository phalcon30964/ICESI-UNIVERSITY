package interfaz;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import mundo.*;

public class Ventana extends JFrame {

	private JPanel panelPrincipal;

	private PanelCliente panelCliente;

	private PanelMudanza panelMudanza;

	private MudanzasLaLoma mudanzaLaLoma;
	private PanelOpciones panelInferior;

	private int consecutivoMudanzaActual;

	public Ventana() {
		this.mudanzaLaLoma = new MudanzasLaLoma();

		this.setBounds(100, 100, 900, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.panelPrincipal = new JPanel();
		this.panelPrincipal.setLayout(new BorderLayout());

		this.panelCliente = new PanelCliente(this);
		this.panelMudanza = new PanelMudanza(this);

		// Panel superior
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.WHITE);
		panelSuperior.setLayout(new BorderLayout(0, 0));

		JLabel lblIcesi = new JLabel("");
		lblIcesi.setIcon(new ImageIcon("./data/icesi.png"));
		panelSuperior.add(lblIcesi, BorderLayout.WEST);

		JLabel lblCupiDos = new JLabel("");
		lblCupiDos.setIcon(new ImageIcon("./data/cupidos.png"));
		panelSuperior.add(lblCupiDos, BorderLayout.EAST);

		JLabel lblElCupiViajero = new JLabel("MUDANZAS LA LOMA S.A.S.");
		lblElCupiViajero.setHorizontalAlignment(SwingConstants.CENTER);
		lblElCupiViajero.setFont(new Font("Lithos Pro", Font.PLAIN, 26));
		panelSuperior.add(lblElCupiViajero, BorderLayout.CENTER);

		this.panelPrincipal.add(panelSuperior, BorderLayout.NORTH);
		// Fin Panel superior

		// Panel central
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(1, 2, 10, 10));
		panelCentral.add(this.panelCliente);
		panelCentral.add(this.panelMudanza);

		this.panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		// Fin Panel central

		// Panel inferior
		JPanel panelInferior = new PanelOpciones(this);
		

		this.panelPrincipal.add(panelInferior, BorderLayout.SOUTH);
		// Fin panel inferior

		this.setContentPane(this.panelPrincipal);
	}

	public boolean registrarCliente(String cedula, String nombres,
			String apellidos, String edad) {
		try {
			int iEdad = Integer.parseInt(edad);

			this.mudanzaLaLoma.registrarCliente(cedula.trim(), nombres.trim(),
					apellidos.trim(), iEdad);

			this.panelMudanza.getCmbModelClientes().addElement(cedula);
			this.panelMudanza.getBtnLimpiar().setEnabled(true);
			this.panelMudanza.getBtnRegistrar().setEnabled(true);

			this.panelCliente.limpiar();
			JOptionPane.showMessageDialog(null,"El cliente ha sido registrado satisfactoriamente");
			return true;
		} catch (NumberFormatException error) {
			JOptionPane.showMessageDialog(this,
					"Debe digitar un valor entero para la edad", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception error) {
			JOptionPane.showMessageDialog(this, error.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}

	public String consultarCliente(String cedula) {
		return this.mudanzaLaLoma.consultarCliente(cedula);
	}

	public String registrarMudanza(String cedulaCliente,
			String direccionSalida, String direccionLlegada) {
		Mudanza mudanza = null;
		try {
			mudanza = this.mudanzaLaLoma.registrarMudanza(cedulaCliente,direccionSalida, direccionLlegada);
				this.panelMudanza.getCmbModelMudanzas().addElement(
						"" + mudanza.darNumero());
				this.consecutivoMudanzaActual = mudanza.darNumero();
				this.panelMudanza.getBtnConsultar().setEnabled(true);
				this.panelMudanza.getTxtDescripcion().setEnabled(true);
				this.panelMudanza.getTxtPeso().setEnabled(true);
				//this.panelMudanza.getBtnCargar().setEnabled(true);
				//this.panelMudanza.getChkEsFragil().setEnabled(true);
				this.panelMudanza.limpiar();
				return "La mudanza fue registrada correctamente.\nYa puede cargar articulos.\nPara cambiar el estado a realizado, debe consultar la mudanza.";

		} catch (Exception error) {
			return error.getMessage();
		}
	}

	public boolean consultarMudanza(String numeroConsecutivo) {
		int numero = Integer.parseInt(numeroConsecutivo);
		this.consecutivoMudanzaActual = 0;
		try {
			Mudanza mudanza = this.mudanzaLaLoma.buscarMudanza(numero);
			if (mudanza != null) {
				if (mudanza.darRealizado()){
					panelMudanza.chekActualizar(false);
					panelMudanza.botonActualizar(false);
					this.panelMudanza.getChkRealizado().setSelected(true);
					this.panelMudanza.getTxtDireccionSalida().setText(
							mudanza.darDireccionSalida());
					this.panelMudanza.getTxtDireccionLlegada().setText(
							mudanza.darDireccionLlegada());
					this.panelMudanza.getTxtDireccionSalida().setEditable(false);
					this.panelMudanza.getTxtDireccionLlegada().setEditable(false);
					this.panelMudanza.getTxtDescripcion().setEnabled(true);
					this.panelMudanza.getTxtPeso().setEnabled(true);
					this.panelMudanza.getChkEsFragil().setEnabled(true);
					this.panelMudanza.getBtnCargar().setEnabled(true);
					this.panelMudanza.getBtnRegistrar().setEnabled(false);
					this.consecutivoMudanzaActual = mudanza.darNumero();

					this.panelMudanza.getCmbModelClientes().setSelectedItem(
							mudanza.darCliente().darCedula());
					return true;
					
				}else{
					panelMudanza.chekActualizar(true);
					panelMudanza.botonActualizar(true);
					this.panelMudanza.getChkRealizado().setSelected(false);
				this.panelMudanza.getTxtDireccionSalida().setText(
						mudanza.darDireccionSalida());
				this.panelMudanza.getTxtDireccionLlegada().setText(
						mudanza.darDireccionLlegada());
				this.panelMudanza.getTxtDireccionSalida().setEditable(false);
				this.panelMudanza.getTxtDireccionLlegada().setEditable(false);
				this.panelMudanza.getTxtDescripcion().setEnabled(true);
				this.panelMudanza.getTxtPeso().setEnabled(true);
				this.panelMudanza.getChkEsFragil().setEnabled(true);
				this.panelMudanza.getBtnCargar().setEnabled(true);
				this.panelMudanza.getBtnRegistrar().setEnabled(false);
				this.consecutivoMudanzaActual = mudanza.darNumero();

				this.panelMudanza.getCmbModelClientes().setSelectedItem(
						mudanza.darCliente().darCedula());
				return true;
			}
			}
		} catch (Exception error) {
			JOptionPane.showMessageDialog(this, error.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return false;
	}

	public String cargarArticulo(String descripcion, String peso,
			boolean esFragil) {
		String respuesta = "No se pudo cargar el articulo";
		try {
			double pesoKilogramos = Double.parseDouble(peso);
			//respuesta = this.mudanzaLaLoma.cargarArticulo(
			//		this.consecutivoMudanzaActual, descripcion, pesoKilogramos,
			//		esFragil);
		} catch (Exception error) {
			JOptionPane.showMessageDialog(this,
					"Debe digitar un valor real para el peso", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return respuesta;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Ventana().setVisible(true);
	}

	public void actualizarMudanza() {
		try {
			Mudanza mudanza = this.mudanzaLaLoma
					.buscarMudanza(this.consecutivoMudanzaActual);
			if (mudanza != null) {
				
					mudanza.cambiarRealizado(this.panelMudanza.getChkRealizado()
							.isSelected());
				
				  if(panelMudanza.getChkRealizado()
							.isSelected()){
					  this.panelMudanza.limpiar();
					  JOptionPane.showMessageDialog(null, "Se ha registrado satisfactoriamente la TERMINACIÓN de la mudanza seleccionada!");
					  this.consecutivoMudanzaActual = 0;
				  }else{
					  JOptionPane.showMessageDialog(null, "Para cambiar a realizado la mudanza actual debe seleccionar la caja de texto correspondiente.");					  
				  }
			}
		} catch (Exception error) {

		}
	}
	public void opcion1(){
		
		JOptionPane.showMessageDialog(this,"Reporte # 1 \n" + mudanzaLaLoma.metodo1());
		
	}
	public void opcion2(){
		JOptionPane.showMessageDialog(this, "Reporte # 2 \n" +mudanzaLaLoma.metodo2(
				Integer.parseInt(JOptionPane.showInputDialog("Por favor digite la cantidad de años:"))				
				));
	}
	public void opcion3(){
		JOptionPane.showMessageDialog(this, "Reporte # 2 \n" +mudanzaLaLoma.metodo3());
		
		
	}
	
}
