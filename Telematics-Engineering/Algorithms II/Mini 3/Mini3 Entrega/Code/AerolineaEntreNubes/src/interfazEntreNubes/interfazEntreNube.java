package interfazEntreNubes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import mundo.*;

public class interfazEntreNube extends JFrame {

	private panelAdministracion admin;
	private panelClientes clientes;
	private EntreNubes mundo;
	private panelGrafico panelG;
	private JScrollPane scroll;
	private String rutaPersistencia ;

	public interfazEntreNube() {
		
		rutaPersistencia = "./data/archivo";
		desSerilizar();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Aerolinea Entre Nubes ::: Christian y Leo");
		setLayout(new BorderLayout());
		
		//setPreferredSize(new Dimension(1000,600));
		setResizable(true);
//		mundo = principal;
		
		//JPanel internoGrafico = new JPanel();
		
		panelG = new panelGrafico(mundo);
		getContentPane().add(panelG);
		scroll = new JScrollPane(panelG);
		scroll.getViewport().add(panelG);
		//panelG.add(scroll,BorderLayout.CENTER);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroll);
		//internoGrafico.add(panelG);
		
		
		
		add(panelG, BorderLayout.NORTH);
		
		admin = new panelAdministracion(this);
		add(admin, BorderLayout.WEST);

		clientes = new panelClientes(this);
		add(clientes, BorderLayout.CENTER);
		
		
		
		panelG.actualizarImagen();
		refrescarPanelAdministracon();
		resfrecarPanelClientes();

		pack();

	}
	
	public void serializar(){
		
		File archivo = new File(rutaPersistencia);
		
		ObjectOutputStream oos;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(mundo);
			oos.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	
	public void desSerilizar(){
		
		File archivo = new File(rutaPersistencia);
		
		if(archivo.exists()){
				ObjectInputStream ois;
				
				try {
					ois = new ObjectInputStream(new FileInputStream(archivo));
					mundo = (EntreNubes)ois.readObject();
					ois.close();
				} catch (Exception e) {
				 JOptionPane.showMessageDialog(this, e.getMessage());
				}
				
			
		}else{
			mundo = new EntreNubes();
		}
		
	}

	


	public static void main(String[] args) {
		
//		EntreNubes nube = new EntreNubes();
		interfazEntreNube ventana = new interfazEntreNube();
		ventana.setVisible(true);
	}
	
	public void refrescarPanelAdministracon() {
		admin.refrescarCbCiudadOrigen(mundo.darListaDeCiudades());
		admin.refrescarCbNombreCiudades(mundo.darListaDeCiudades());
	}
	
	public void resfrecarPanelClientes(){
		
		clientes.refrescarCbCiudadOrigen(mundo.darListaDeCiudades());
		clientes.refrescarCbCiudadDestino(mundo.darListaDeCiudades());
	}

	public void agregarCiudad(){
		
		String ciudadPadre = admin.darCbCiudadOrigen();
		String nombre = admin.darTxtNombreCiudad();
		String aeropuertoLlegada = admin.darTxtAeropuertoLlegada();
	
		if(ciudadPadre.equals("")){
			JOptionPane.showMessageDialog(this, "Debe introducir el nombre de la ciudad de la cual depende la ciudad que desea agregar");
			return;
		}
		
		if(nombre.equals("")){
			JOptionPane.showMessageDialog(this, "Debe introducir el nombre da la ciudad que desea agregar");
			return;
		}
		
		if(aeropuertoLlegada.equals("")){
			JOptionPane.showMessageDialog(this, "Debe introducir el nombre del aeropuerto de la ciudad que desea agregar");
			return;
		}
		
		if(admin.darTxtDistanciaCiudades().equals("")){
			JOptionPane.showMessageDialog(this, "Debe introducir una distancia valida");
			return;
		}
		
		if(admin.darTxtTiempoVuelo().equals("")){
			JOptionPane.showMessageDialog(this, "Debe introducir una duracion valida");
			return;
		}
		
		
		int distanciaVuelo = Integer.parseInt(admin.darTxtDistanciaCiudades());
		int tiempoVuelo = Integer.parseInt(admin.darTxtTiempoVuelo());
		
		try {
			mundo.agregarCiudad(ciudadPadre, nombre, aeropuertoLlegada, distanciaVuelo, tiempoVuelo);
		} catch (rutaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
		JOptionPane.showMessageDialog(this, "La ciudad se agrego exitosamente");
		pack();
		panelG.actualizarImagen();
		refrescarPanelAdministracon();
		resfrecarPanelClientes();
		serializar();

		
	}
	
	public void eliminarCiudad() {
		
		try {
			mundo.eliminarCiudad(admin.darCbNombreCiudadE());
		} catch (rutaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
		pack();
		panelG.actualizarImagen();
		refrescarPanelAdministracon();
		resfrecarPanelClientes();
		serializar();

	}

	public void consultarRuta() {
		
		ArrayList<Ciudad> ruta = null;
		
		try {
			ruta = mundo.calcularRuta(clientes.darCbCiudadOrigen(), clientes.darCbCiudadDestino());
		} catch (rutaException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
		String rutaTxt = "";
		
		for (int i = 0; i < ruta.size(); i++) {
			rutaTxt+= ruta.get(i).darNombre()+" - ";
		}
		
		rutaTxt = rutaTxt.substring(0, rutaTxt.length()-2);
		
		clientes.cambiarTxtRuta(rutaTxt);
		
		clientes.cambiarTxtAeropuertoLlegada(mundo.darAeropuertoLlegadaRuta(ruta));
		
		clientes.cambiarTxtDistanciaRecorrida(mundo.calcularDistancia(ruta));
		
		clientes.cambiarTxtTiempoVuelo(mundo.calcularTiempo(ruta));

	}

	public void mostrarArbol() {

	}

}
