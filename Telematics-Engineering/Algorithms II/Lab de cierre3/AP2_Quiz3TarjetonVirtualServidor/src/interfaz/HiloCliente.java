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
		
	}

	public void run() {
		
	
	}

}
