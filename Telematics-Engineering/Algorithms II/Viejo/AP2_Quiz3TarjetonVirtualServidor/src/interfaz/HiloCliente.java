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

	public HiloCliente(Socket elCanal, InterfazTarjetonVirtual ventana)
			throws IOException {
		
		canal = elCanal;
		principal = ventana;
		
		escrituraEnElCanal = new PrintWriter(elCanal.getOutputStream(), true);
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
				
				try {
					comando = lecturaDelCanal.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Candidato cand = principal.realizarVotacion(comando);
				
				if(cand==null){
					escrituraEnElCanal.println(CANDIDATO_NO_EXISTE);
				}else{
					escrituraEnElCanal.println(VOTO_EXITOSO);
					escrituraEnElCanal.println(cand.darNombre());
					escrituraEnElCanal.println(cand.darPartido());
				}
				
				
			}
			
			//avance
			
			try {
				comando = lecturaDelCanal.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		escrituraEnElCanal.close();
		try {
			lecturaDelCanal.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
