package control;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import vista.InterfazServidor;
import modelo.Servidor;

public class EjecutableServidor {
	
	private static Servidor mundo;
	private static InterfazServidor interfaz;
	private static ServerSocket serverSocket;
	private static Socket socket;
	

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						interfaz = new InterfazServidor();
						interfaz.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
				}
			}
		});
	
		
		mundo = new Servidor();

		try {
			serverSocket = new ServerSocket(62000);
			System.out.println("Servidor levantado y a la espera de cientes...");
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
