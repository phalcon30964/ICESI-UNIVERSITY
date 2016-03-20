package control;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import vista.Interfaz;

public class ejecutable {
	
	public static Interfaz frame;
	private static Socket socket;	
	private static BufferedReader lector;
	private static PrintWriter escritor;
	
	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	public static final String OK = "OK";
	public static final String ERROR = "EROOR";
	public static final String CONSULTAR_SIGUIENTE = "CONSULTAR_SIGUIENTE";
	public static final String CONSULTAR_ANTERIOR = "CONSULTAR_ANTERIOR";

	
	public static void main(String[] args) {
		
		establecerConexion("127.0.0.1", "62000");

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Interfaz();
					frame.setVisible(true);
					escucharAvanzar();
					escucharAtrazar();
					escucharSalir();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	
	}
	
	public static void escucharAvanzar(){
		frame.getButton_1().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				escritor.println(CONSULTAR_SIGUIENTE);
				
				String respuesta = "";
				try {
					respuesta = lector.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				if(!respuesta.equals(ERROR)){
					frame.getTextField().setText(respuesta);
				}else{
					
					try {
						respuesta = lector.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.getTextField().setText(respuesta);
				}
				
				
			}
		});;
	}
	
	public static void escucharAtrazar(){
		frame.getButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				escritor.println(CONSULTAR_ANTERIOR);
				
				String respuesta = "";
				try {
					respuesta = lector.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(!respuesta.equals(ERROR)){
					frame.getTextField().setText(respuesta);
				}else{
					
					try {
						respuesta = lector.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					frame.getTextField().setText(respuesta);
				}
				
				
			}
		});;
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
//				JOptionPane.showMessageDialog(null, "Conexion establecida exitosamente");
			}
			
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra la ip");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void escucharSalir(){
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				escritor.println(FINALIZAR_CONEXION);
				
				try {
					lector.close();
					escritor.close();
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
			
		});
		
	}

}
