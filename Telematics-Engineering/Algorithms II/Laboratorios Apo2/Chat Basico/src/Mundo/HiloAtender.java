package Mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloAtender extends Thread {
	
	public final static String EMPEZAR="Empezar";
	public final static String CHAT="Chat";
	public final static String FINALIZAR="Finalizar";
	
	private Socket can;
	private BufferedReader lectura;
	private PrintWriter escritura;
	private BufferedReader consola;

	public HiloAtender(Socket canal){
		
		can = canal;
		try {
			lectura = new BufferedReader(new InputStreamReader(canal.getInputStream()));
			escritura = new PrintWriter(canal.getOutputStream(), true);
			consola = new BufferedReader(new InputStreamReader(System.in));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void run()
	{}

}
