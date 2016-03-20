package modelo;

import java.sql.SQLException;
import TadLista.ListaDoble;
import TadLista.NodoDoble;

public class AdministradorServidor {
	
	
	private ListaDoble<Mensaje> mensajes;
	private AdministradorBD adminBD;
	private int numeroClientes;
	private NodoDoble<Mensaje> mensajeActual;

	public AdministradorServidor() {
		mensajes = new ListaDoble<Mensaje>();
		adminBD = new AdministradorBD();
	}
	
	public void getNuevoMensaje() throws SQLException{
		mensajes.agregar(adminBD.consultarNuevoMensaje());
	}
	
	public String getMesanjeSiguiente() throws SQLException{
		
		getNuevoMensaje();
		
		if(mensajeActual == null){
			mensajeActual = mensajes.getIterador().getSiguiente();
		}else{
			mensajeActual = mensajeActual.getSiguiente();
		}
		
		return mensajeActual.getContenido().getMensaje();
	}
	
	public String getMesanjeAnterior() throws Exception{
		
		getNuevoMensaje();
		
		if(mensajeActual == null){
			mensajeActual = mensajes.getIterador().getSiguiente();
		}else{
			
			mensajeActual = mensajeActual.getAnterior();
		}
		
		if(mensajeActual.getContenido()==null){
			throw new Exception("No hay mensajes");
		}
		
		return mensajeActual.getContenido().getMensaje();
	}

	public ListaDoble<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(ListaDoble<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public AdministradorBD getAdminBD() {
		return adminBD;
	}

	public void setAdminBD(AdministradorBD adminBD) {
		this.adminBD = adminBD;
	}

	public int getNumeroClientes() {
		return numeroClientes;
	}

	public void setNumeroClientes(int numeroClientes) {
		this.numeroClientes = numeroClientes;
	}
	
	public void aumentarNumeroClientes() {
		this.numeroClientes += 1;
	}
	
	public void disminuirNumeroClientes() {
		this.numeroClientes -= 1;
	}
	
	
}
