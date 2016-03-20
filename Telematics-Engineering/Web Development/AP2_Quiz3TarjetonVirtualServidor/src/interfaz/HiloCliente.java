package interfaz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import mundo.Candidato;
import mundo.Tarjeton;

public class HiloCliente extends Thread {
	private Socket canal;
	private PrintWriter escrituraEnElCanal;
	private BufferedReader lecturaDelCanal;

	private InterfazTarjetonVirtual principal;

	//Definición de los comandos del protocolo
	public final static String VOTAR = "VOTAR";
	public final static String VOTO_EXITOSO = "VOTO_EXITOSO";
	public final static String CANDIDATO_NO_EXISTE = "CANDIDATO_NO_EXISTE";
	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	public final static String CONSULTAR_GANADOR = "CONSULTAR_GANADOR";
	public final static String CONTRASENA_CORRECTA = "CONTRASENA_CORRECTA";
	public final static String CONTRASENA_INCORRECTA = "CONTRASENA_INCORRECTA";

	public HiloCliente(Socket elCanal, InterfazTarjetonVirtual ventana)
			throws IOException {
		
		//Inicializo la instancia del programa
		principal = ventana;
		
		//Inicializo los flujos del canal
		escrituraEnElCanal = new PrintWriter(elCanal.getOutputStream(),true);
		lecturaDelCanal = new BufferedReader(new InputStreamReader(elCanal.getInputStream()));
		
	}

	public void run() {
		
		String comando = "";
		try {
			comando = lecturaDelCanal.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(!comando.equalsIgnoreCase(FINALIZAR_CONEXION)){
			
			if(comando.equalsIgnoreCase(VOTAR)){
				
				String codigoCandidato = "";				
				try {
					
					codigoCandidato = lecturaDelCanal.readLine();
					
					Candidato candidato = principal.realizarVotacion(codigoCandidato);
					
					if(candidato!=null){
					
					escrituraEnElCanal.println(VOTO_EXITOSO);
					escrituraEnElCanal.println(candidato.darNombre());
					escrituraEnElCanal.println(candidato.darPartido());
					
					}else{
					
					escrituraEnElCanal.println(CANDIDATO_NO_EXISTE);
					
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}else if(comando.equalsIgnoreCase(CONSULTAR_GANADOR)){
				
				String contrasena = "";
				
				try {
					contrasena = lecturaDelCanal.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				AdminBD a = new AdminBD();
				a.abrirConexion();
				
				String resp = a.consultarContrasena(contrasena);
				
				if(resp.equalsIgnoreCase("")){
					escrituraEnElCanal.println(CONTRASENA_CORRECTA);
					escrituraEnElCanal.println(resp);
					
				}else{
					escrituraEnElCanal.println(CONTRASENA_CORRECTA);
					escrituraEnElCanal.println(resp);
				}
				
				
				
				
				
				
			}
			
			try {
				comando = lecturaDelCanal.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		try {
			escrituraEnElCanal.close();
			lecturaDelCanal.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
		
	
}
