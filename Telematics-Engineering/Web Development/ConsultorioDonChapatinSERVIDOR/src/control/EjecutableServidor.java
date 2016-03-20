package control;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.Consultorio;

public class EjecutableServidor {

	private static Consultorio consultorio;
	private static ServerSocket server;
	private static Socket socket;
	
	public static void main(String[] args) {
		
		consultorio = new Consultorio();
		try {
			server = new ServerSocket(61000);
			System.out.println("Servidor levantado");
			atenderClientes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void atenderClientes() throws IOException{
		while(true){
			socket = server.accept();
			HiloServicio hilo = new HiloServicio(socket, consultorio);
			System.out.println("Conexion entrante. Se atenderá por el socket "+socket.getPort());
			hilo.start();
			}
	}

}
