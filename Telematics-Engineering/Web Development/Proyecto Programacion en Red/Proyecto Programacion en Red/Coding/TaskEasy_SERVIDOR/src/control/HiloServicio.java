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
	//el usuario lo guarda el hilo para mayor simplicidad
	private String usuario;
	
	
	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	public static final String OK = "OK";
	public static final String ERROR = "EROOR";
	public static final String INICIAR_SESION = "INICIAR_SESION";
	public static final String RESTABLECER_CONTRASENA = "RESTABLECER_CONTRASENA";
	public static final String REGISTRAR_USUARIO = "REGISTRAR_USUARIO";
	public static final String CONSULTAR_TAREAS_POR_SEMANA_ACTUAL = "CONSULTAR_TAREAS_POR_SEMANA_ACTUAL";
	public static final String CONSULTAR_TAREAS_POR_PRIORIDAD = "CONSULTAR_TAREAS_POR_PRIORIDAD";
	public static final String CONSULTAR_TAREAS_POR_FECHA_LIMITE = "CONSULTAR_TAREAS_POR_FECHA_LIMITE";
	public static final String CONSULTAR_TAREAS_POR_NOMBRE = "CONSULTAR_TAREAS_POR_NOMBRE";
	public static final String CONSULTAR_TAREAS_POR_CATEGORIA = "CONSULTAR_TAREAS_POR_CATEGORIA";
	public static final String GENERAR_PDF = "GENERAR_PDF"; 
	public static final String AGREGAR_TAREA = "AGREGAR_TAREA";
	public static final String ELIMINAR_TAREA = "ELIMINAR_TAREA";
	public static final String MODIFICAR_TAREA = "MODIFICAR_TAREA";
	public static final String AGREGAR_CATEGORIA = "AGREGAR_CATEGORIA";
	public static final String MODIFICAR_CATEGORIA = "MODIFICAR_CATEGORIA";
	
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
	

	

