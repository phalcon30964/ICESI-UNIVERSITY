package interfazEntreNubes;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import mundo.*;


public class panelClientes extends JPanel implements ActionListener{

	//
	private JLabel labCiudadOrigen;
	private JLabel labCiudadDestino;
	private JComboBox cbCiudadOrigen;
	private JComboBox cbCiudadDestino;
	
	//
	private JLabel labRuta;
	private JLabel labAeropuertoLlegada;
	private JLabel labTiempoVuelo;
	private JLabel labDistanciaRecorrida;
	private JTextField txtRuta;
	private JTextField txtAeropuertoLlegada;
	private JTextField txtTiempoVuelo;
	private JTextField txtDistanciaRecorrida;
	
	private JButton btnMostrarArbol;
	private JButton btnConsultar;

	
	public final static String CONSULTAR_RUTA = "Consultar ruta";
	
	
	private interfazEntreNube principal;
	
	public panelClientes(interfazEntreNube ventana){
		
		principal = ventana;
		setPreferredSize(new Dimension(400,310));
		setLayout(new BorderLayout()); 
		TitledBorder bordePanel = new TitledBorder("Clientes");
		TitledBorder bordeDatos = new TitledBorder("Datos");
		
		
       
        setBorder(bordePanel); 
        JPanel internoDatos = new JPanel();
        internoDatos.setLayout(new GridLayout(4,2));
        internoDatos.setBorder(bordeDatos);
        
        JPanel internoPanel = new JPanel();
        internoPanel.setLayout(new GridLayout(2,2));
        
        JPanel internoBotones = new JPanel();
        internoBotones.setLayout(new GridLayout(1,1));
        
        
        labCiudadOrigen = new JLabel("Ciudad Origen");
        labCiudadDestino = new JLabel("Ciudad Destino");
        cbCiudadDestino = new JComboBox();
        cbCiudadOrigen = new JComboBox();
        
        labRuta = new JLabel("Ruta");
        labAeropuertoLlegada = new JLabel("Aeropuerto de llegada");
        labTiempoVuelo = new JLabel("Tiempo de vuelo");
        labDistanciaRecorrida = new JLabel("Distancia Recorrida");
        txtRuta = new JTextField();
        txtRuta.setEditable(false);
        txtAeropuertoLlegada = new JTextField();
        txtAeropuertoLlegada.setEditable(false);
        txtTiempoVuelo = new JTextField();
        txtTiempoVuelo.setEditable(false);
        txtDistanciaRecorrida = new JTextField();
        txtDistanciaRecorrida.setEditable(false);
        btnMostrarArbol = new JButton();
       
        btnMostrarArbol.addActionListener(this);
        btnConsultar = new JButton();
        btnConsultar.setText(CONSULTAR_RUTA);
        btnConsultar.setActionCommand(CONSULTAR_RUTA);
        btnConsultar.addActionListener(this);
        	
        internoDatos.add(labRuta);
        internoDatos.add(txtRuta);
        internoDatos.add(labAeropuertoLlegada);
        internoDatos.add(txtAeropuertoLlegada);
        internoDatos.add(labTiempoVuelo);
        internoDatos.add(txtTiempoVuelo);
        internoDatos.add(labDistanciaRecorrida);
        internoDatos.add(txtDistanciaRecorrida);
		
        internoPanel.add(labCiudadOrigen);
        internoPanel.add(cbCiudadOrigen);
        internoPanel.add(labCiudadDestino);
        internoPanel.add(cbCiudadDestino);
        
        internoBotones.add(btnConsultar);
        
        
        add(internoPanel,BorderLayout.NORTH);
        add(internoDatos,BorderLayout.CENTER);
        add(internoBotones,BorderLayout.SOUTH);
        
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		
		if(comando.equals(CONSULTAR_RUTA)){
			principal.consultarRuta();
		}
		
		
	}

	public void refrescarCbCiudadDestino(ArrayList<String> list){
		
        cbCiudadDestino.removeAllItems();
        
		for (int i = 0; i < list.size(); i++) {
			 cbCiudadDestino.addItem(list.get(i));
		}
	}
	
	public void refrescarCbCiudadOrigen(ArrayList<String> list){
		
        cbCiudadOrigen.removeAllItems();
		
		for (int i = 0; i < list.size(); i++) {
			cbCiudadOrigen.addItem(list.get(i));
		}
	}

	public String  darCbCiudadOrigen() {
		return (String)cbCiudadOrigen.getSelectedItem();
	}


	public String darCbCiudadDestino() {
		return (String) cbCiudadDestino.getSelectedItem();
	}

	public void cambiarTxtRuta(String txtRuta) {
		this.txtRuta.setText(txtRuta);
	}


	public void cambiarTxtAeropuertoLlegada(String txtAeropuertoLlegada) {
		this.txtAeropuertoLlegada.setText(txtAeropuertoLlegada);
	}


	public void cambiarTxtTiempoVuelo(String txtTiempoVuelo) {
		this.txtTiempoVuelo.setText(txtTiempoVuelo);
	}


	public void cambiarTxtDistanciaRecorrida(String txtDistanciaRecorrida) {
		this.txtDistanciaRecorrida.setText(txtDistanciaRecorrida);
	}
}
