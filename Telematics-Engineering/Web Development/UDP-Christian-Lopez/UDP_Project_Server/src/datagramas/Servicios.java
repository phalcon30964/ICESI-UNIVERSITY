package datagramas;

import java.util.Scanner;

public class Servicios extends Thread {

	
	private boolean parar;

	public Servicios() {
		super();
		this.parar = false;
	}
	
	@Override
	public void run() {
		
		
		Scanner lector= new Scanner(System.in);
		int opc = 0;
		
		while (opc!=3 && !parar) {
			System.out.println("***MENU***");
			System.out.println("1. Lista archivo / Propietario");
			System.out.println("2. Archivos por propietario");
			System.out.println("3. Salir de este menú");
			
			do {
				System.out.println("Digite opcion deseada");
				opc = lector.nextInt();
				if(opc<1 || opc>3){
					System.out.println("Opcion incorreta");
				}
			} while (opc<1 || opc>3);
			
			switch (opc) {
			case 1:
				
				System.out.println("ARCHIVO/PROPIETARIO");
				int tamano = PasaArchivoServidor.registro.size();
				
				Archivo elemento;
				
				for (int i = 0; i <tamano; i++) {
					elemento = PasaArchivoServidor.registro.get(i);
					System.out.println(elemento.getNombre()+"\n");
				}
				
				break;
			case 2:
				
				System.out.println("ARCHIVO/PROPIETARIO");
				int tam = PasaArchivoServidor.registro.size();
				
				Archivo element;
				
				for (int i = 0; i <tam; i++) {
					element = PasaArchivoServidor.registro.get(i);
					System.out.println(element.getNombre()+"\n");
				}
				
				break;
			case 3:
		
				parar = true;
				
				break;
			}
			
		}
		
		
	}

}
