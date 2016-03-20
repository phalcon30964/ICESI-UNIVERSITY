package interfaz;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.UrnaVotacion;

@SuppressWarnings("serial")
public class InterfazUrnaVotacion extends JFrame{
	
	private UrnaVotacion miUrnaVotacion;
	
	private PanelUltimaVotacion panelUltimaVotacion;
	private PanelVotacion panelVotacion;
	
	//Atributos de la conexión con sockets
		public final static String SERVIDOR  = "127.0.0.1"; //puede ser un nombre de dominio o una IP
		public final static int PUERTO       = 3050;
		
		private Socket canal;
		private PrintWriter escrituraEnElCanal;
		private BufferedReader lecturaDelCanal;	
		
		//Constantes asociadas con el protocolo de comunicación entre cliente/servidor
		public final static String VOTAR               = "VOTAR";
		public final static String VOTO_EXITOSO        = "VOTO_EXITOSO";
		public final static String CANDIDATO_NO_EXISTE = "CANDIDATO_NO_EXISTE";
		public final static String FINALIZAR_CONEXION  = "FINALIZAR_CONEXION";
		
	
	public InterfazUrnaVotacion(){
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Cliente :: Urna de Votación");
		setLayout(new BorderLayout());
		
		try{
			miUrnaVotacion = new UrnaVotacion();
		}catch(IOException excep){
			JOptionPane.showMessageDialog(this, "El cliente no puede iniciar.\n\nPosible Causa:\n"+excep.getMessage());
		}
		
		panelUltimaVotacion = new PanelUltimaVotacion();
		panelVotacion = new PanelVotacion(this);
		
		add(panelUltimaVotacion, BorderLayout.NORTH);		
		add(panelVotacion, BorderLayout.CENTER);	
		
		
		//Inicializar parámetros de comunicación
		
		try {
			canal = new Socket(SERVIDOR, PUERTO);
			lecturaDelCanal = new BufferedReader( new InputStreamReader(canal.getInputStream()));
			escrituraEnElCanal = new PrintWriter(canal.getOutputStream(), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//__________________________________________________________________________
		
		pack();
	}
	
	public void votar(){
		String codigoCandidatoElegido = panelVotacion.darCodigoCandidatoElegido();

		String infoVotacion = "";
		
		try{
		//Implementar el protocolo de comunicación para la votación
			
			escrituraEnElCanal.println(VOTAR);
			escrituraEnElCanal.println(codigoCandidatoElegido);
			
			String respuesta = lecturaDelCanal.readLine();
			
			if(respuesta.equalsIgnoreCase(VOTO_EXITOSO)){
				String nombre = lecturaDelCanal.readLine();
				String partido = lecturaDelCanal.readLine();
				
				infoVotacion = VOTO_EXITOSO +" para candidato: " + nombre + " del partido " + partido;
			}else if (respuesta.equalsIgnoreCase(CANDIDATO_NO_EXISTE)){
				infoVotacion = CANDIDATO_NO_EXISTE;
			}
			
			panelUltimaVotacion.refrescarInfoVotacion(infoVotacion);
		
		}catch(Exception ex){
			
			infoVotacion = "Se produjo un error en la transmisión del voto virtual.";
			panelUltimaVotacion.refrescarInfoVotacion(infoVotacion);
			
		}
		
		pack();
	}
public void cerrarConexion(){
		
		escrituraEnElCanal.println(FINALIZAR_CONEXION);

	}	
	public void dispose(){
		cerrarConexion();
		
		JOptionPane.showMessageDialog(this, "Se ha cerrado toda posible conexión con un servidor.\n\nEl programa terminará.");
		System.exit(0);
	}

	public static void main(String[] args){
		new InterfazUrnaVotacion().setVisible(true);
	}
}
