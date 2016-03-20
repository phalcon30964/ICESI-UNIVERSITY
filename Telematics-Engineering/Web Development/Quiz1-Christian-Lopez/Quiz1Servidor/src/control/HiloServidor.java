package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import vista.PanelDibujador;
import modelo.Pecera;

public class HiloServidor extends Thread {
	
	private Pecera pecera;
	private BufferedReader lector;
	private PrintWriter escritor;
	private PanelDibujador interfaz;
	
	public final static String OK = "OK";
	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	public final static String CONSULTA = "CONSULTA";
	public final static String ACTUALIZAR = "ACTUALIZAR";

	
	public HiloServidor(Socket socket, Pecera servidor,PanelDibujador interfaz) {
		pecera = servidor;
		try {
			lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			escritor = new PrintWriter(socket.getOutputStream(),true);
			this.interfaz = interfaz;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		String comando = "";
		try {
			comando = lector.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		boolean temp = false;
		boolean cambio = false;
		
		if(!pecera.isOcupado()){
			temp = true;
			pecera.setOcupado(true);
			cambio = true;
		}
		
		while(!comando.equalsIgnoreCase(FINALIZAR_CONEXION)){
			
				switch (comando) {
				
				case OK:
					escritor.println(OK);
					break;
					
				case CONSULTA:
					escritor.println(pecera.getNumeroPecez()+"");
					escritor.println(pecera.getPosX());
					escritor.println(pecera.getPosY());
					escritor.println(pecera.getRed());
					escritor.println(pecera.getGreen());
					escritor.println(pecera.getBlue());
					
					if(temp){
					atualizarInterfaz();
					moverPeces();
					}
				
					break;
					
				case ACTUALIZAR:
					escritor.println(pecera.getPosX());
					escritor.println(pecera.getPosY());
					if(temp){
					atualizarInterfaz();
					moverPeces();
					}
					break;
				}
				
				//vuelvo a leer para siguiente ciclo
				try {
					comando = lector.readLine();
				} catch (IOException e) {
				}
			}
			
		//cierro los flujos antes de que el hilo muera
		try {
			pecera.setOcupado(false);
			lector.close();
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(cambio){
			pecera.setOcupado(false);
		}
	}
	
	public void atualizarInterfaz(){
		interfaz.setPosX(pecera.getX());
		interfaz.setPosY(pecera.getY());
		interfaz.getVentana().repaint();
	}
	
	public void moverPeces(){
			for (int i = 0; i < pecera.getNumeroPecez(); i++) {
				switch (pecera.getAccion()[i]) {
				
				case Pecera.SUBIR:
					if(pecera.getX()[i]<=0){
						pecera.getAccion()[i] = Pecera.BAJAR;
					}else{
						pecera.subirPez(i);
					}
					break;
				case Pecera.BAJAR:
					if(pecera.getX()[i]>=780){
						pecera.getAccion()[i] = Pecera.SUBIR;
					}else{
						pecera.bajarPez(i);
					}
					break;
					
				case Pecera.IZQUIERDA:
					if(pecera.getY()[i]<=0){
						pecera.getAccion()[i] = Pecera.DERECHA;
					}else{
						pecera.moverIzquierdaPez(i);
					}
					break;
					
				case Pecera.DERECHA:
					if(pecera.getY()[i]>=580){
						pecera.getAccion()[i] = Pecera.IZQUIERDA;
					}else{
						pecera.moverDerechaPez(i);
					}
					break;
				}
		}
	}
}
