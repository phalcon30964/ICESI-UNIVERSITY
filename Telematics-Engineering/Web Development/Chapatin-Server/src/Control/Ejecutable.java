package Control;

import java.io.IOException;
import java.net.*;

import javax.swing.JOptionPane;


import Modelo.Consultorio;

public class Ejecutable {

	public static Consultorio modeloconsultorio;
	private static ServerSocket receptor;
	private static Socket canal;
	private final static int PUERTO=4444;
	private static DatagramSocket dSocket;
	private static DatagramPacket dPacket;
	private static InetAddress direccionGrupo;


	public static void main(String[] args) {

		modeloconsultorio = new Consultorio();
		inicializarCanal();
		inicializarCanalMulticast();

	}

	public static void inicializarCanal(){

		try {
			receptor = new ServerSocket(PUERTO);
			System.out.println("Escucha");
			while (true) {
				canal = receptor.accept();
				new HiloServer(canal, modeloconsultorio).start();
				System.out.println("En Linea Cliente");
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer el canal");
			e.printStackTrace();
		}

	}


	public static void inicializarCanalMulticast(){
		try {
			dSocket = new DatagramSocket();

			dPacket = null;

			direccionGrupo = InetAddress.getByName("224.0.0.0");

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean enviarMensaje(String mensajes){
		boolean resultado = false;
		try {


			DatagramSocket dSocket = new DatagramSocket();

			DatagramPacket dPacket = null;

			direccionGrupo = InetAddress.getByName("224.0.0.0");

			if (mensajes == null ){
				resultado = false;
			}
			else{
				byte[] buf = mensajes.getBytes();

				dPacket = new DatagramPacket(buf, buf.length, direccionGrupo, 6500);
				System.out.println(dPacket.toString());

				dSocket.send(dPacket);


				resultado = true;

			}
			dSocket.close();
		}


		catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return resultado;
	}

}


