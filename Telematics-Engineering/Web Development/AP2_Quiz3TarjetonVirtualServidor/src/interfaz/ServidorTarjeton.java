package interfaz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTarjeton {
	private ServerSocket servidor;
	private Socket canal;

	private InterfazTarjetonVirtual principal;

	public final static int PUERTO = 3000;

	public ServidorTarjeton(InterfazTarjetonVirtual ventana) throws IOException {
		principal = ventana;
	}

	/**
	 * Se encarga de inicializar el ServerSocket y el ciclo de esperar clientes, con cada
	 * cliente que se conecte, se debe crear un nuevo HiloCliente
	 * */
	public void atenderCliente() throws IOException {
		
		servidor = new ServerSocket(PUERTO);
		
		while(true){
		
		canal = servidor.accept();	
		
		HiloCliente hilo = new HiloCliente(canal, principal);
		
		hilo.start();
		
		}
	}
}
