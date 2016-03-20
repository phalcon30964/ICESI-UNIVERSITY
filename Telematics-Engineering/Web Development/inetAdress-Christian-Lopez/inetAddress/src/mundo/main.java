package mundo;

import java.io.ByteArrayInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
	
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Bienvenido... seleccione una opción");
		System.out.println("1 para saber la dirección IP y el nombre del equipo donde se encuentra actualmente");
		System.out.println("2 para mostrar la diferencia entre el método getAddress() y getHostAddress()");
		System.out.println("3 recibir dos nombres de hosts e indicar si los nombres corresponden a una misma dirección o a direcciones diferentes.");
		System.out.println("4 para salir del programa");
		
		String ln = scn.nextLine();
		
		switch (ln) {
		case "1":
			
			try {
				System.out.println("La dir ip del equipo es: "+InetAddress.getLocalHost().getHostAddress());
				System.out.println("El nombre del equipo es: "+InetAddress.getLocalHost().getHostName());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		
		case "2":
			
			System.out.print("Pintando metodo getAddress() ");
			
			byte[] temp = null;
			
			try {
				temp = InetAddress.getLocalHost().getAddress();
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			
			System.out.println(temp.length);
			
			for (int i = 0; temp!=null && i < temp.length; i++) {
				System.out.print(Byte.toUnsignedInt(temp[i]));
			}
			
			try {
				System.out.println("\nPintando metodo getHostAddress() " + InetAddress.getLocalHost().getHostAddress());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		case "3":
			
			InetAddress a = null;
			InetAddress b = null;
			try {
				System.out.println("Ingrese primer nombre y oprima enter");
				a = InetAddress.getByName(scn.nextLine());
				System.out.println("Ingrese segundo nombre y oprima enter");
				b = InetAddress.getByName(scn.nextLine());
				
				if(a.equals(b)){
					System.out.println("Las direcciones son iguales. Primera: "+a.getHostAddress()+" Segunda: "+b.getHostAddress());
				}else{
					System.out.println("Las direcciones son diferentes. Primera: "+a.getHostAddress()+" Segunda: "+b.getHostAddress());
				}

			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			
			break;

		default:
			
			System.exit(0);
			
			break;
		}
		
	}

}
