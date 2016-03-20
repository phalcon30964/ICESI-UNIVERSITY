	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	
	
public class ComplejidadTemporal {
	
		public static void main(String args[]){
			
			
			CopyOfClasePrueba2 prueba = new CopyOfClasePrueba2();
			
			
			
			int[] n = prueba.darN();
			
			//Prueba del algoritmo 1
			
			for (int i = 0; i < n.length ; i++) {
				
				System.out.println("Ejecutando prueba del algoritmo 1 para n: "+n[i]);

				int resultado = prueba.algoritmo1(n[i]);
				
				String mensaje = "Algoritmo 1 - "+n[i]+" - " + resultado;
				
				System.out.println("El resultado fue "+mensaje+". Imprimiendo resultado...");
				
				prueba.imprimir(mensaje+"\n");
				
			}
			
			//Prueba del algoritmo 2
			
			for (int i = 0; i < n.length ; i++) {
				
				System.out.println("Ejecutando prueba del algoritmo 2 para n: "+n[i]);

				int resultado = prueba.algoritmo2(n[i]);
				
				String mensaje = "Algoritmo 2 - "+n[i]+" - " + resultado;
				
				System.out.println("El resultado fue "+mensaje+". Imprimiendo resultado...");
				
				prueba.imprimir(mensaje+"\n");
				
			}
			
			//Prueba del algoritmo 3
			
			for (int i = 0; i < n.length ; i++) {
				
				System.out.println("Ejecutando prueba del algoritmo 3 para n: "+n[i]);

				int resultado = prueba.algoritmo3(n[i]);
				
				String mensaje = "Algoritmo 3 - "+n[i]+" - " + resultado;
				
				System.out.println("El resultado fue "+mensaje+". Imprimiendo resultado...");
				
				prueba.imprimir(mensaje+"\n");
				
			}
			
			//Prueba del algoritmo 4
			
			for (int i = 0; i < n.length ; i++) {
				
				System.out.println("Ejecutando prueba del algoritmo 4 para n: "+n[i]);

				int resultado = prueba.algoritmo4(n[i]);
				
				String mensaje = "Algoritmo 4 - "+n[i]+" - " + resultado;
				
				System.out.println("El resultado fue "+mensaje+". Imprimiendo resultado...");
				
				prueba.imprimir(mensaje+"\n");
				
			}
			
			//Prueba del algoritmo 5
			
			for (int i = 0; i < n.length ; i++) {
				
				System.out.println("Ejecutando prueba del algoritmo 5 para n: "+n[i]);

				int resultado = prueba.algoritmo5(n[i]);
				
				String mensaje = "Algoritmo 5 - "+n[i]+" - " + resultado;
				
				System.out.println("El resultado fue "+mensaje+". Imprimiendo resultado...");
				
				prueba.imprimir(mensaje+"\n");
				
			}
			
			//Prueba del algoritmo 6
			
			for (int i = 0; i < n.length ; i++) {
				
				System.out.println("Ejecutando prueba del algoritmo 6 para n: "+n[i]);

				int resultado = prueba.algoritmo6(n[i]);
				
				String mensaje = "Algoritmo 6 - "+n[i]+" - " + resultado;
				
				System.out.println("El resultado fue "+mensaje+". Imprimiendo resultado...");
				
				prueba.imprimir(mensaje+"\n");
				
			}
			
		}

}
