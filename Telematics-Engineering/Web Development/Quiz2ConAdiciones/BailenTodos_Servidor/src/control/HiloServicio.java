package control;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import modelo.DiscoTienda;


public class HiloServicio extends Thread{
	
	private DiscoTienda mundo;
	private BufferedReader lector;
	private PrintWriter escritor;
	private ObjectOutputStream escritorObjetos;
	private ObjectInputStream lectorObjetos;
	private Socket socket;
	

	public final static String FINALIZAR_CONEXION = "FINALIZAR_CONEXION";
	public static final String OK = "OK";
	public static final String ERROR = "EROOR";
	public static final String REGISTRAR_ARTISTA = "REGISTRAR_ARTISTA";
	public static final String REGISTRAR_CANCION = "REGISTRAR_CANCION";
	public static final String REGISTRAR_DISCO = "REGISTRAR_DISCO";
	public static final String CONSULTAR_DISCOS = "CONSULTAR_DISCOS";
	public static final String CONSULTAR_DISCOS_NOMBRE = "NOMBRE";
	public static final String CONSULTAR_DISCOS_CANCION = "CANCION";
	public static final String CONSULTAR_DISCOS_ARTISTA = "ARTISTA";
	public static final String CONSULTAR_DISCOS_GENERO = "GENERO";
	public static final String CONSULTAR_ARTISTAS = "CONSULTAR_ARTISTAS";
	public static final String VENDER = "VENDER";
	public static final String ESTADISTICA = "ESTADISTICA";
	public static final String ESTADISTICA_IND = "ESTADISTICA_IND";
	public static final String FOTO = "FOTO";
	public static final String CARATULA = "CARATULA";

	/**
	 * Metodo constructor de la clase hiloservicio
	 * @param s socket que representa la conexion
	 * @param m instancia del mundo 
	 */
	public HiloServicio(Socket s, DiscoTienda m) {
		mundo = m;
		try {
			socket = s;
			escritor = new PrintWriter(s.getOutputStream(),true);
		    escritorObjetos = new ObjectOutputStream( s.getOutputStream()); 
			lector = new BufferedReader(new InputStreamReader(s.getInputStream()));
			lectorObjetos = new ObjectInputStream( s.getInputStream()); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo principal dela clase, contiene las intrucciones para responder a las peticiones de los clientes
	 */
	public void run(){
	
		try {			
			
		String comando = lector.readLine();
		
		while(!comando.equalsIgnoreCase(FINALIZAR_CONEXION)){
			
			switch (comando) {
			
			case OK:
				escritor.println(OK);
				break;	
				
			case REGISTRAR_ARTISTA:
				
				comando = lector.readLine();
				String[] datos =comando.split(",");
				
				try {
					ImageIcon foto = (ImageIcon)deserialize((byte[])lectorObjetos.readObject());
					
					if(mundo.registrarArtista(datos[0], datos[1], datos[2], datos[3], foto, datos[4], datos[5], datos[6], datos[7], datos[8], datos[9])){
						escritor.println(OK);
					}else{
						escritor.println(ERROR);
					}
				} catch (Exception e) {
					escritor.println(ERROR);
					e.printStackTrace();
				}
				
				break;
				
			case REGISTRAR_DISCO:
				
				comando = lector.readLine();
				String[] datos1 = comando.split(",");
				
				try {
					ImageIcon caratula = (ImageIcon)deserialize((byte[])lectorObjetos.readObject());
					
					if(mundo.registraDiscos(datos1[0], datos1[1], caratula, datos1[2]) && mundo.agregarArtistaADisco(datos1[0], datos1[3])){
						escritor.println(OK);
					}else{
						escritor.println(ERROR);
					}
				} catch (Exception e) {
					escritor.println(ERROR);
					e.printStackTrace();
				}
				
				break;
				
			case REGISTRAR_CANCION:
				
				comando = lector.readLine();
				String[] datos2 = comando.split(",");
				
				if(mundo.registrarCancion(datos2[0], datos2[1], datos2[2]) && mundo.agregarArtistaACancion(datos2[0], datos2[3])){
					escritor.println(OK);
				}else{
					escritor.println(ERROR);
				}
				
				break;
				
			case CONSULTAR_ARTISTAS:
				
				escritorObjetos.writeObject(mundo.consultarArtistas());
				
				break;	
				
			case CONSULTAR_DISCOS:
				
				escritorObjetos.writeObject(mundo.consultarDiscos());
				
				break;
				
			case CONSULTAR_DISCOS_NOMBRE:

				comando = lector.readLine();
				
				escritorObjetos.writeObject(mundo.consultarDiscoPorNombre(comando));
				
				break;
				
			case CONSULTAR_DISCOS_CANCION:

				comando = lector.readLine();
				
				escritorObjetos.writeObject(mundo.consultarDiscoPorCancion(comando));
				
				break;
				
			case CONSULTAR_DISCOS_ARTISTA:

				comando = lector.readLine();
				
				escritorObjetos.writeObject(mundo.consultarDiscoPorArtista(comando));
				
				break;
				
			case CONSULTAR_DISCOS_GENERO:

				comando = lector.readLine();
				
				escritorObjetos.writeObject(mundo.consultarDiscoPorGenero(comando));
				
				break;
				
			case VENDER:
				
				comando = lector.readLine();
				
				String[] datos3 = comando.split(",");
				
				if(mundo.venderDisco(datos3[0], datos3[1])){
					escritor.println(OK);
				}else{
					escritor.println(ERROR);
				}
				
				break;	
				
			case ESTADISTICA:
				
				escritor.println(mundo.numeroDeDiscosVendidos()+","+mundo.numeroDeDiscosDisponibles());
				
				break;
				
			case ESTADISTICA_IND:
				
				escritorObjetos.writeObject(mundo.estadisticaPorDisco());
				
				break;
				
			case FOTO:
				
				String temp = lector.readLine();
				
				escritorObjetos.writeObject(mundo.consultarFoto(temp));
				
				break;
			
			case CARATULA:
				
				String temp2 = lector.readLine();
				
				escritorObjetos.writeObject(mundo.consultarCaratula(temp2));
				
				break;
				
			}
			
			comando = lector.readLine();
			
		}
		
			lector.close();
			escritor.close();
			lectorObjetos.close();
			escritorObjetos.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	 public static byte[] serialize(Object obj) throws IOException {
	        ByteArrayOutputStream b = new ByteArrayOutputStream();
	        ObjectOutputStream o = new ObjectOutputStream(b);
	        o.writeObject(obj);
	        return b.toByteArray();
	    }
	 
	 public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
	        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
	        ObjectInputStream o = new ObjectInputStream(b);
	        return o.readObject();
	    }
	
	
	
	
 }
	

	

