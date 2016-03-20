package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import modelo.Servidor;

public class HiloServicio extends Thread{
	
	private Servidor mundo;
	private BufferedReader lector;
	private PrintWriter escritor;
	
	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	public static final String OK = "OK";
	public static final String ERROR = "EROOR";
	public static final String CONSULTAR = "CONSULTAR";
	
	public HiloServicio(Socket s, Servidor m) {
		mundo = m;
		try {
			lector = new BufferedReader(new InputStreamReader(s.getInputStream()));
			escritor = new PrintWriter(s.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run(){
		
		
		String comando = "";
		try {
			comando = lector.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		while(!comando.equalsIgnoreCase(FINALIZAR_CONEXION)){
			switch (comando) {
			
			case OK:
				escritor.println(OK);
				break;
				
			case CONSULTAR:
				
			}
			
			try {
				comando = lector.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			lector.close();
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
	

