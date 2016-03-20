package mundo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class InterfazEvento {
	
	private static ServerSocket receptor;
	private BufferedReader lector;
	private PrintWriter escritor;
	private static Evento event;
	
	public static final int puerto = 3000;
	
	public InterfazEvento() {
		
		event = new Evento();
	
		
	try{
		
		receptor = new ServerSocket(puerto);
		
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	public static void main(String[] args) {
		
		InterfazEvento interfaz = new InterfazEvento();
		
		
		while(true){
			
			Socket canal = null;
			try {
				canal = receptor.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HiloC hilo = new HiloC (canal, event);
			hilo.start();
		}
		
	}
	

}
