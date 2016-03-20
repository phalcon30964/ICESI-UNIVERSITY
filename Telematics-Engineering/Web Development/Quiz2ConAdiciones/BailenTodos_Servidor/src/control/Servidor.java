package control;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.AdministradorBD;
import modelo.DiscoTienda;

public class Servidor {
	
	private static DiscoTienda mundo;
	private static ServerSocket serverSocket;
	private static Socket socket;
	
	public static void main(String[] args) {
		
		mundo = new DiscoTienda();
		try {
			serverSocket = new ServerSocket(62000);
			System.out.println("Servidor levantado y a la espera de cientes...");
			atenderClientes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que se encarga de atender las conexiones entrantes al servidor
	 * 
	 * @throws IOException
	 */
	public static void atenderClientes() throws IOException{
		while(true){
			socket = serverSocket.accept();
			HiloServicio hilo = new HiloServicio(socket, mundo);
			hilo.start();
			}
	}
}
