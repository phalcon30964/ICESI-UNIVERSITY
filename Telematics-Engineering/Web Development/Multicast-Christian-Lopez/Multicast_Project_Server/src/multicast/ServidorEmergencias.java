package multicast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ServidorEmergencias {
	
	
	public static void main(String[] args) {
		boolean continuar = true;
		String mensaje = null;
		Scanner scan = new Scanner(System.in);
		
		ServidorEmergencias servidor = new ServidorEmergencias();
		while(continuar){
			System.out.println("(1)Mensaje(2)Terminar");
			int opcion =  scan.nextInt();
			
			switch (opcion) {
			case 1:
				System.out.println("Digite mensaje");
				mensaje = scan.nextLine();
				mensaje = scan.nextLine();
				
				if(servidor.enviarMensaje(mensaje)){
					System.out.println("Mensaje Enviado");
				}else{
					System.out.println("Error enviando mensaje");
				}
				
				break;

			case 2:
				
				continuar = false;
				servidor.enviarMensaje("FIN");
				
				break;
				
			default:
				
				System.out.println("Seleccione una opcion valida");
				
				break;
			}
		}
		
	}
	
	public boolean enviarMensaje(String mensaje){
		
		boolean resultado = false;
		
		
		try {
			
			
			DatagramSocket dSock = new DatagramSocket();
			DatagramPacket dPacket = null;
			InetAddress direccionGrupo = InetAddress.getByName("239.1.2.2");
			
			if(mensaje == null){
				resultado = false;
			}else{
				byte[] buf = mensaje.getBytes();
				dPacket = new DatagramPacket(buf, buf.length,direccionGrupo,5000);
				dSock.send(dPacket);
				resultado= true;
			}
			dSock.close();
			
		} catch (Exception e) {
			System.out.println("Error "+e.getMessage());
		}
		
		return resultado;
		
	}
	
}
