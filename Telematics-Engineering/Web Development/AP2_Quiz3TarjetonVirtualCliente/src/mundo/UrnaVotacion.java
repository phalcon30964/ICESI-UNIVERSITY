package mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import sun.security.x509.IPAddressName;

public class UrnaVotacion {
	
	//Atributos del Mundo del Cliente
	private String codigoUltimoVoto;
	private String nombreUltimoVoto;
	private String partidoUltimoVoto;
	
	private boolean ultimoVotoExitoso;
	
	
	public UrnaVotacion() throws IOException{
		codigoUltimoVoto  = "";
		nombreUltimoVoto  = "";
		partidoUltimoVoto = "";
		ultimoVotoExitoso = false;
		
	}
	
	public String darUltimaVotacion(){
		String ultimaVotacion;
		
		if(ultimoVotoExitoso){
			ultimaVotacion = "Código: "+codigoUltimoVoto+", Nombre: "+nombreUltimoVoto+", Partido: "+partidoUltimoVoto;
		}else{
			ultimaVotacion = "El último intento de voto no fue exitoso. Quizá el código del candidato no existía.";
		}
		
		return ultimaVotacion;
	}
	
	public void votar(String codigoCandidato) throws IOException{
		

		
		
		
	}
	
	
}
