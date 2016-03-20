package datagramas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

public class PasaArchivoServidor {
	
	public static ArrayList<Archivo> registro = new ArrayList<Archivo>();
	
	public static void main(String[] args) {
		
		// Se inicia un hilo que muestra el menu
		Servicios hilo = new Servicios();
		hilo.start();
		
		try {
			DatagramSocket socket = new DatagramSocket(6000);
			DatagramPacket packet = null;
			
			InetAddress dirCliente = null;
			String clienteActual ="";
			PrintWriter pw =null;
			String nomArchivo;
			File archivo;
			
			
			while (true) {
				byte[] buffer = new byte[64];
				packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
//Aqui se recibe la direccion de donde llega el paqute
				dirCliente = packet.getAddress();
				
				if(clienteActual.compareTo("")==0){
//Aqui se pide el puerto de la ip desde donde se envio
					clienteActual = dirCliente.getHostAddress();
				}
				
				if(clienteActual.equals(dirCliente.getHostAddress())){
//Asi se convierte un paquete a un string 
					String linea = new String(packet.getData(),0,packet.getLength());
					
					if(linea.startsWith("c:/")){
						
						dirCliente = packet.getAddress();
						nomArchivo = "c:/temp/tx/"+linea.substring(8,linea.length());
						archivo = new File(nomArchivo);
						
						try {
							registro.add(new Archivo(nomArchivo, dirCliente));
						} catch (Exception e) {
						    System.exit(1);
						    
						}
						
						pw = new PrintWriter(new FileWriter(nomArchivo),true);
						
					}else{
						if (!linea.equals("fin")) {
							pw.println(linea);
						} else {
							clienteActual = "";
							pw.close();
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println("El servido no existe");
			System.exit(0);
		}
	}
}
