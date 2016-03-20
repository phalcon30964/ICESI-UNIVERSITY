package interfaz;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.UrnaVotacion;

@SuppressWarnings("serial")
public class InterfazUrnaVotacion extends JFrame{
	
	private UrnaVotacion miUrnaVotacion;
	
	private PanelUltimaVotacion panelUltimaVotacion;
	private PanelVotacion panelVotacion;
	private CandidatoGanador candidato;
	
	//Atributos de la conexión con sockets
		public final static String SERVIDOR  = "127.0.0.1"; //puede ser un nombre de dominio o una IP
		public final static int PUERTO       = 3000;
		
		private Socket canal;
		private PrintWriter escrituraEnElCanal;
		private BufferedReader lecturaDelCanal;	
		
		
		//Constantes asociadas con el protocolo de comunicación entre cliente/servidor
		public final static String VOTAR               = "VOTAR";
		public final static String VOTO_EXITOSO        = "VOTO_EXITOSO";
		public final static String CANDIDATO_NO_EXISTE = "CANDIDATO_NO_EXISTE";
		public final static String FINALIZAR_CONEXION  = "FINALIZAR_CONEXION";
		public final static String CONSULTAR_GANADOR = "CONSULTAR_GANADOR";
		public final static String CONTRASENA_CORRECTA = "CONTRASENA_CORRECTA";
		public final static String CONTRASENA_INCORRECTA = "CONTRASENA_INCORRECTA";

		
		
	
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
		candidato = new CandidatoGanador(this);
		
		add(panelUltimaVotacion, BorderLayout.NORTH);		
		add(panelVotacion, BorderLayout.CENTER);
		add(candidato, BorderLayout.SOUTH);
		
		
		
		
		//Inicializar parámetros de comunicación
		
		
		
		try {
			canal = new Socket(SERVIDOR,PUERTO);
			escrituraEnElCanal = new PrintWriter(canal.getOutputStream(),true);
			lecturaDelCanal = new BufferedReader(new InputStreamReader(canal.getInputStream()));
		} catch (IOException e) {
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
				
				infoVotacion = VOTO_EXITOSO+" "+ nombre +" "+ partido;
				
			}else if(respuesta.equalsIgnoreCase(CANDIDATO_NO_EXISTE)){
				
				infoVotacion = "El candidato no existe";
				
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

	
	public String consultarGanador(String contrasena){
		
		escrituraEnElCanal.println(CONSULTAR_GANADOR);
		escrituraEnElCanal.println(contrasena);
		
		String retorno = "";
		
		String respuesta = "";
		
		try {
			respuesta = lecturaDelCanal.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(respuesta.equalsIgnoreCase(CONTRASENA_INCORRECTA)){
			retorno = CONTRASENA_INCORRECTA;
		}
		
		if(respuesta.equalsIgnoreCase(CONTRASENA_CORRECTA)){
			try {
				retorno = lecturaDelCanal.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return retorno;
		
	}
	
	public static void main(String[] args){
		new InterfazUrnaVotacion().setVisible(true);
	}
}
