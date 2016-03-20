package mundo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class HiloC extends Thread{
	
	private Socket canal;
	private BufferedReader lector;
	private PrintWriter escritor;
	private Evento event;
	
	public static final String hola = "HOLA";
	public static final String consulta = "CONSULTA";
	public static final String registro = "REGISTRO";
	public static final String consulta1 = "CONSULTA1";
	public static final String consulta2 = "CONSULTA2";
	public static final String chao = "CHAO";




	
	public HiloC (Socket can, Evento e){
		
		canal = can;
		try {
			lector=new BufferedReader(new InputStreamReader(canal.getInputStream()));
			escritor=new PrintWriter(canal.getOutputStream(),true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
			
	}
	
	public void run(){
		
		String comando = "";
		
		
		while(!comando.equals(chao)){
			
		
			if(comando.equalsIgnoreCase(hola)){
				escritor.println(hola);
			}
			
			if(comando.equalsIgnoreCase(registro)){
				registro();
			}
			
			try {
				comando = lector.readLine();
				System.out.println(comando);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	public void registro(){
		
		String datos = "";
		
		try {
			datos = lector.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(datos);
		
		String[] data = datos.split(",");
		
		event.registrar(data[0], data[1], Integer.parseInt(data[2]));
		
		System.out.println(event.participantes.size()+"");
		
	}
	
}

