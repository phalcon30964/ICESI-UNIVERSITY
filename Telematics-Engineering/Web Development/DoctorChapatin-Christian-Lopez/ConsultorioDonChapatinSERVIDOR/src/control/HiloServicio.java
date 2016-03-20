package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import modelo.Consultorio;
import modelo.Fecha;
import modelo.Paciente;
import modelo.Usuarios;

public class HiloServicio extends Thread {
	
	private Socket socket;
	private Consultorio mundo;

	private BufferedReader lector;
	private PrintWriter escritor;
	
	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	
	public static final String OK = "OK";
	public static final String ERROR = "EROOR";
	public static final String REGISTRAR = "1";
	public static final String CONSULTAR_PERSONA = "2";
	public static final String CONSULTAR_FECHA = "3";
	public static final String ENCONTRADO = "ENTONTRADO";
	public static final String NO_ENCONTRADO = "NO_ENTONTRADO";
	public static final String AGREGAR_CITA = "4";
	public static final String ELIMINAR_CITA = "5";
	public static final String ACTUALIZAR = "_ACTUALIZAR_";


	
	public HiloServicio(Socket s, Consultorio m) {
		
		socket = s;
		mundo = m;
		
		try {
			lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			escritor = new PrintWriter(socket.getOutputStream(),true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		String comando = "";
		try {
			comando = lector.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(!comando.equalsIgnoreCase(FINALIZAR_CONEXION)){
			
			switch (comando) {
//////////////////////////////////////////////////////////////////////////////////
			case OK:
				
				escritor.println(OK);
				
				try {
					String[] dato = lector.readLine().split("/");
					mundo.getUsuarios().add(new Usuarios(dato[0], dato[1], dato[2]));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				break;
//////////////////////////////////////////////////////////////////////////////////				
			case REGISTRAR :
				
				try {
					String[] datos = lector.readLine().split("-");
					
					String fechaNacimiento = datos[6]+"/"+datos[7]+"/"+datos[8];
					
					boolean bol = mundo.addPaciente(datos[0], datos[1], datos[2], 
							Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), 
							Integer.parseInt(datos[5]), fechaNacimiento);
					if(bol){
						escritor.println(OK);
					}else{
						escritor.println(ERROR);
					}	
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				mostrarPacientesRegistrados();
				
				break;
//////////////////////////////////////////////////////////////////////////////////
			case CONSULTAR_PERSONA:
				
				try {
					
					int id = Integer.parseInt(lector.readLine());
					
					Paciente buscado = mundo.searchPaciente(id);
					
					if(buscado!=null){
						escritor.println(ENCONTRADO);
						escritor.println(buscado.getNombre()+"-"+buscado.getApellido()+buscado.getStringCitasPendientes());
					}else{
						escritor.println(NO_ENCONTRADO);
					}

				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				break;
//////////////////////////////////////////////////////////////////////////////////
			case CONSULTAR_FECHA:
				
				try {
					String dat = lector.readLine();
					String[] date = dat.split("-");
					
					Fecha fecha = mundo.searchFecha(date[0],date[1],date[2]);
					
					if(fecha!=null){
						
						escritor.println(fecha.getCitasNoOcupadas());
						
					}else{
						mundo.addFecha(date[0],date[1],date[2]);
						
						Fecha aux = mundo.searchFecha(date[0],date[1],date[2]);
						
						escritor.println(aux.getCitasNoOcupadas());
					}					
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				break;
//////////////////////////////////////////////////////////////////////////////////
			case AGREGAR_CITA:
				
				try {
					String data = lector.readLine();
					String[] datos = data.split("-");
					
					
					boolean bol = mundo.addCita(Integer.parseInt(datos[0]), datos[1],datos[2],
							datos[3], datos[4]);
						
					if(bol){
						escritor.println(OK);
					}else{
						escritor.println(ERROR);
					}
	
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				break;
//////////////////////////////////////////////////////////////////////////////////		
			case ELIMINAR_CITA:
				try {
					String[] datos = lector.readLine().split("-");
					
					mundo.removeCita(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4]);
					
					escritor.println(OK);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				break;
//////////////////////////////////////////////////////////////////////////////////
			case ACTUALIZAR:
				String nombres = "";
				String ips = "";
				String puertos = "";
				
				for (int i = 0; i < mundo.getUsuarios().size(); i++) {
					nombres += mundo.getUsuarios().get(i).getNombre()+"/";
					ips += mundo.getUsuarios().get(i).getIp()+"/";
					puertos += mundo.getUsuarios().get(i).getPuerto()+"/";
				}
				
				nombres = (nombres.equals(""))? nombres:nombres.substring(0,nombres.length());
				ips = (ips.equals(""))? ips:ips.substring(0,ips.length());
				puertos = (puertos.equals(""))? puertos:puertos.substring(0,puertos.length());

				escritor.println(mundo.getUsuarios().size()+"");
				escritor.println(nombres);
				escritor.println(ips);
				escritor.println(puertos);
				
				break;
			}			
//////////////////////////////////////////////////////////////////////////////////
			try {
				
				comando = lector.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(comando.equalsIgnoreCase(FINALIZAR_CONEXION)){
				try {
					String nombre = lector.readLine();
					
					for (int i = 0; i < mundo.getUsuarios().size(); i++) {
						if(mundo.getUsuarios().get(i).getNombre().equals(nombre)){
							mundo.getUsuarios().remove(i);
						}
					}
				} catch (IOException e) {
				}
			}
		}
		
		try {
			lector.close();
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mostrarPacientesRegistrados(){
		ArrayList<Paciente> lista = mundo.getPacientes();
		String msj = "Los pacientes registrados son: ";
		for (int i = 0; i < lista.size(); i++) {
			msj += lista.get(i).toString()+"\n";
		}
		System.out.println(msj.substring(0, msj.length()-1));
	}
	

}
