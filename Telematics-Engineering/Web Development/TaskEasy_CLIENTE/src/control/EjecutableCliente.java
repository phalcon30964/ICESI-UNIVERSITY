package control;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import modelo.Cliente;

public class EjecutableCliente {

	private static Socket socket;	
	private static BufferedReader lector;
	private static PrintWriter escritor;
	public static final String DIRECCIONIP = "127.0.0.1";
	public static final int PUERTO = 62000;
	public static Cliente principal;

	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	public static final String OK = "OK";
	public static final String ERROR = "EROOR";

	public static void main(String[] args) {
		
		establecerConexion(DIRECCIONIP, PUERTO);

	}

	public static void establecerConexion(String ip, int port){
		try {
			//creo un canal por donde escribir y escuchar
			socket = new Socket(ip,port);
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

	/**
	 *Envia al menu de ingreso de datos para entrar 
	 */
	public static void escucharEntrar(){
		
	}

	/**
	 *Estamos en la ventana de Entrar, llenamos datos del fornmulario User: /Pass
	 *Envia datos al servidor para cotejarlos.
	 *Si la respuesta es positiva , guarda usuaro y contrasena, pide al servidor darResumen de tareas por semana actual (por defecto)
	 *y con esa informacion construye la ventana de darResumen
	 *Sino, muestra mensaje de usuario o contrasena erroneos.
	 */
	public static void escucharIniciarSeccion(String user, String pass){
		principal=new Cliente(user, pass);
	}

	/**
	 *Estamos en la ventana Restablecer, llenamos E-mail
	 *Envia datos al servidor para reestablecer contraseña
	 */
	public static void escucharReestablecerPass(){

	}

	/**
	 *LLeva a ventana de Registro	
	 */
	public static void escucharRegistrar(){

	}

	/**
	 *Estamos en ventana registro, llenamos el formulario
	 *Envia datos del formulario al servidor
	 *Regresa a la ventana de entrada User/Pass
	 *
	 */
	public static void escucharRegistrarse(){

	}
	
	/**
	 * Estamos en la ventana de resumen
	 * Se Cargan los datos
	 * 
	 */
	public static void escucharDarResumen(){

	}
	
	/**
	 * Estamos en la ventana de resumen
	 * Permite generar Reporte .pdf con los datos cargados.
	 * Recibe el archivo .pdf desde el servidor.
	 */
	public static void escucharGenerarReporte(){

	}
	
	/**
	 * Estamos en la ventana resumen
	 * Envia a la ventana nueva tarea
	 */
	public static void escucharPestanaNuevaTarea(){

	}
	
	/**
	 * Estamos en la ventana Nueva Tarea
	 * Envia los datos al servidor del formulario
	 * Espera confirmaciòn del servidor(ventana emergente)
	 */
	public static void escucharAgregarTarea(){

	}
	
	/**
	 * Estamos en la ventana Resumen
	 * Nos cambia a la ventana tarea
	 * Pide al servidor las tareas ordenas por fecha(por defecto) y con esa informacion construye la ventana tarea 
	 */
	public static void escucharPestanaTarea(){

	}
	
	/**
	 * Estamos en la ventana tareas
	 * Abre la ventana nueva categoria
	 * Permite agregar una nueva categoria
	 */
	public static void escucharNuevaCategoria(){

	}
	/**
	 * Estamos en la ventana Nueva Categoria
	 * Permite agregar una nueva categoria
	 * Envia el nombre de la nueva categoria al servidor.
	 * Visualiza la confirmaciòn del servidor.
	 */
	public static void escucharBotonNuevaCategoria(){

	}
	
	/**
	 * Estamos en la ventana modificar Categoria
	 * Permite modificar una categoria
	 * Envia el nuevo nombre de la categoria al servidor
	 */
	public static void escucharModificarCategoria(){

	}
	
	/**
	 * Estamos en la ventana tarea
	 * Nos envia a la ventana Editar Tarea
	 * Envia el nombre de la tarea a editar al servidor, el servidor le devuelve los detalles de la tarea
	 * y con esa informacion se construye la ventana 
	 */
	public static void escucharEditarTarea(){

	}
	
	/**
	 * Estamos en la ventana Editar Tarea
	 * Envia al servidor los datos editados de la tarea y el servidor da resultado de la operacion
	 */
	public static void escucharModificartarea(){

	}
	
	/**
	 * Estamos en la ventana de inicio
	 * Envia a la ventana Resumen deshabilitada
	 */
	public static void escucharBotonMasTarde(){

	}
	
}
