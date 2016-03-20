package datagramas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.*;
import java.util.Scanner;

public class PasaArchCliente {
	
	
	
	public static void main(String[] args) {
		
		InetAddress servidor = null;
		File archivo = null;
		Scanner scan = new Scanner(System.in);
		
		//Averigua la ip del servidor 	
			try {
				String nomServidor = "";
				System.out.println("A continuacion digite la identicacion (nombre) del servidor al cual desea enviar los datos:");
				nomServidor = scan.nextLine();
				servidor = InetAddress.getByName(nomServidor);
			} catch (UnknownHostException e) {
				System.out.println("El servidor digitado no existe, reinicie el programa");
				System.exit(0);
			}
		//Crea nuevo datagrama socket para transmitir	
			try {
				DatagramSocket socket = new DatagramSocket();
		//inicializa los contadores de archivos transmitidos	
				int opc = 0;
				int contador = 0;
		//Hace bucle infinito
				do {
					System.out.println("Digite el nombre del archivo Tx en la carpeta temp");
					String nomArchivo = scan.nextLine();
					
					archivo = new File(nomArchivo);
					
					boolean continuar = true;
		//verifica que el archivo exista
					if(archivo.exists()){
						System.out.println("El archivo especificado no existe!");
						continuar = false;
					}
		//Si el archivo existe
					if (continuar) {
						byte[] datos  = null;
						datos = nomArchivo.getBytes();
		//Crea un archivo datagrama con el nombre que es lo que primero se debe enviar
						DatagramPacket packet = new DatagramPacket(datos, datos.length, servidor, 6000);
		//Envia el nombre del archivo				
						socket.send(packet);
		//Crea flujo que lee el archivo				
						BufferedReader br = new BufferedReader(new FileReader(archivo));
						String lectura = null;
		//Lee y mientras lo leido sea diferente de null				
						while ((lectura = br.readLine()) != null) {
		//Envia archivo
							datos = lectura.getBytes();
							packet = new DatagramPacket(datos, datos.length,servidor, 6000);
							socket.send(packet);
							lectura = null;
						}
		//Envia la ultima parte del codigo un FIN para indicar el final del archivo
						lectura = "fin";				
						datos = lectura.getBytes();
						packet = new DatagramPacket(datos, datos.length, servidor, 6000);
						socket.send(packet);
		//Aumenta los archivos leido y cierra flujo de envio				
						contador++;
						br.close();
					}
		//Pregunta si desea volver a transmitir 
					do {
						System.out.println("Desea transmitir otro archivo (1=si 2=no):");
						
						opc = Integer.parseInt(scan.nextLine());
						if(opc!=1 && opc!=2){
							System.out.println("Por favor digite una opcion valida");
						}
						
					} while (opc!=1 && opc!=2);
					
				} while (opc!=2);
				
				System.out.println("Se han transmitido "+contador+" archivos");
				
			} catch (Exception e) {
				System.out.println("Error: "+e.getMessage());
				e.printStackTrace();

			}
	}

}
