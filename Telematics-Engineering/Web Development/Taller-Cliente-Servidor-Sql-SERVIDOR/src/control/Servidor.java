package control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import modelo.AdministradorServidor;

public class Servidor {
	
	private static AdministradorServidor mundo;
	private static ServerSocket serverSocket;
	private static Socket socket;
	

	public static void main(String[] args) {
		
		mundo = new AdministradorServidor();

		try {
			serverSocket = new ServerSocket(62000);
			JOptionPane.showMessageDialog(null, "Servidor levantado");
			atenderClientes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void atenderClientes() throws IOException{
		while(true){
			socket = serverSocket.accept();
			HiloServicio hilo = new HiloServicio(socket, mundo);
			hilo.start();
			}
	}

}
