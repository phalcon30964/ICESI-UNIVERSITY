package control;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

import vista.PanelDibujador;

public class EjecutableCliente {
	
	private static PanelDibujador pecera;
	
	private static Socket socket;	
	private static BufferedReader lector;
	private static PrintWriter escritor;
	
	public final static String OK = "OK";
	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	public final static String CONSULTA = "CONSULTA";
	public final static String ACTUALIZAR = "ACTUALIZAR";

	public static void main(String[] args) {
		
		establecerConexion("127.0.0.1", "62000");
	
		try {
			pecera = inicializarPecera();
			pecera.getVentana().getContentPane().add(pecera);
			pecera.getVentana().setVisible(true);
			while(true){
				actualizarPecera();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error");
			e.printStackTrace();
		} 
	}
	
	public static void establecerConexion(String ip, String port){
		int puerto = Integer.parseInt(port);
		try {
			//creo un canal por donde escribir y escuchar
			socket = new Socket(ip,puerto);
			//inicializo los flujos del canal
			lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			escritor = new PrintWriter(socket.getOutputStream(),true);	
			//inicializo protocolo handshake
			escritor.println(OK);
			String comando = lector.readLine();
			if(comando.equals(OK)){
				JOptionPane.showMessageDialog(null, "Conexion establecida exitosamente");
			}
			
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra la ip");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static PanelDibujador inicializarPecera() throws NumberFormatException, IOException{
		
		escritor.println(CONSULTA);
		
		int n = Integer.parseInt(lector.readLine());
		int[] x = convertirArreglo(lector.readLine().split("/"));
		int[] y = convertirArreglo(lector.readLine().split("/"));
		int[] r = convertirArreglo(lector.readLine().split("/"));
		int[] g = convertirArreglo(lector.readLine().split("/"));
		int[] b = convertirArreglo(lector.readLine().split("/"));
		
		return new PanelDibujador(n, x, y, r, g, b);
		
	}
	
	public static void actualizarPecera(){
		
		escritor.println(ACTUALIZAR);
		
		try {
			String cordenadasX = lector.readLine();
			System.out.println(cordenadasX);
			String cordenadasY = lector.readLine();
			System.out.println(cordenadasY);
			
			int[] x = convertirArreglo(cordenadasX.split("/"));
			int[] y = convertirArreglo(cordenadasY.split("/"));
			
			pecera.setPosX(x);
			pecera.setPosY(y);
		System.out.println("actualizo y peticion de repaint");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int[] convertirArreglo(String[] a){
		int[] n = new int[a.length];
		
		for (int i = 0; i < a.length; i++) {
			n[i] = Integer.parseInt(a[i]);
		}
		
		return n;
	}
	
	public static void escucharBotonSalir(){
		
		pecera.getVentana().addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("finalizo conexion");
				escritor.println(FINALIZAR_CONEXION);
				
				try {
					lector.close();
					escritor.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				System.exit(0);
			}
		});
		
	}
}
