package control;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import vista.PanelDibujador;
import modelo.Pecera;

public class EjecutableServidor {
	
	private static Pecera pecera;
	private static ServerSocket serverSocket;
	private static Socket socket;
	

	public static void main(String[] args) {
		
		pecera = new Pecera();
		PanelDibujador interfaz = new PanelDibujador(pecera.getNumeroPecez(), pecera.getX(), pecera.getY(), pecera.getR(), pecera.getG(), pecera.getB());
		interfaz.getVentana().getContentPane().add(interfaz);
		interfaz.getVentana().setVisible(true);
		try {
			serverSocket = new ServerSocket(62000);
			System.out.println("Servidor levantado");
			atenderClientes(interfaz);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void atenderClientes(PanelDibujador interfaz) throws IOException{
		while(true){
			socket = serverSocket.accept();
			HiloServidor hilo = new HiloServidor(socket, pecera,interfaz);
			hilo.start();
			}
	}

}
