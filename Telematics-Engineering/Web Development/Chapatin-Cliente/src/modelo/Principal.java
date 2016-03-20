package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Principal {
	
	
	private Socket canal;
	private BufferedReader lector;
	private PrintWriter escritor;

	private ArrayList<String> datosPaciente;
	
	public Principal(){
		
		datosPaciente = new ArrayList<String>();
		
	}
	
	
}
