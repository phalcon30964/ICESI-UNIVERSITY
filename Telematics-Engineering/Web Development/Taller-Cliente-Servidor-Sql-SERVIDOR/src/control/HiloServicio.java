package control;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.AdministradorServidor;

public class HiloServicio extends Thread{
	
	private  AdministradorServidor mundo;
	private BufferedReader lector;
	private PrintWriter escritor;
	
	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	public static final String OK = "OK";
	public static final String ERROR = "EROOR";
	public static final String CONSULTAR_SIGUIENTE = "CONSULTAR_SIGUIENTE";
	public static final String CONSULTAR_ANTERIOR = "CONSULTAR_ANTERIOR";

	

	
	public HiloServicio(Socket s, AdministradorServidor m) {
		mundo = m;
		try {
			lector = new BufferedReader(new InputStreamReader(s.getInputStream()));
			escritor = new PrintWriter(s.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void run(){
		
		mundo.aumentarNumeroClientes();
		JOptionPane.showMessageDialog(null,"El numero de clientes conectados es : "+mundo.getNumeroClientes());
		
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
				
			case CONSULTAR_SIGUIENTE:
				
				try {
					escritor.println(mundo.getMesanjeSiguiente());
				} catch (SQLException e) {
					escritor.println(ERROR);
					escritor.println(e.getMessage());
				}

				break;
			
			case CONSULTAR_ANTERIOR:
				
				try {
					escritor.println(mundo.getMesanjeAnterior());
				} catch (Exception e) {
					escritor.println(ERROR);
					escritor.println(e.getMessage());
				}

				break;	
			}
			
			try {
				comando = lector.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		mundo.disminuirNumeroClientes();
		JOptionPane.showMessageDialog(null,"El numero de clientes conectados es : "+mundo.getNumeroClientes());
		
		try {
			lector.close();
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
	

