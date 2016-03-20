package Mundo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {
	
	private ServerSocket servidor;
	private Socket canal;
	
	public final static int PUERTO    = 3051;
	
	
	public Servidor(){
		try {
			servidor = new ServerSocket(PUERTO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true){
			try {
				canal = servidor.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HiloAtender nuevo = new HiloAtender(canal);
			nuevo.start();
			
		}
	}
	
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
