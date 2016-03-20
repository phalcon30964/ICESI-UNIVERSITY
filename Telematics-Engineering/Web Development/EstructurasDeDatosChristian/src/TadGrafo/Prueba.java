package TadGrafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import TadGrafo.GrafoLista;

public class Prueba {
	
	public static void main(String[] args) {
		
		
		
		  File archivo = null;
	      FileReader fr = null;
	      BufferedReader br = null;
	 
	      try {
	        
	         archivo = new File ("./docs/configuracion.txt");
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	 
	         String linea = br.readLine();;
	         
	         while(!linea.equalsIgnoreCase("0 0") && !linea.equals("") && linea!=null && !linea.isEmpty()){
			     
	        	 GrafoLista<Integer> grafo = new GrafoLista<Integer>(false);

	        	 String[] conf = linea.split(" ");
	        	 
	        	 for (int i = 0; i < Integer.parseInt(conf[0]); i++) {
						grafo.agregarVertice(i);
			     }
	         
		         for (int i = 0; i < Integer.parseInt(conf[1]); i++) {
		        	 
			         linea = br.readLine();
		        	 String[] arista = linea.split(" ");
	
		        	 int inicio = Integer.parseInt(arista[0]);
		        	 int fin = Integer.parseInt(arista[1]);
		        	 int peso = Integer.parseInt(arista[2]);
		        	 
		        	 grafo.agregarArista(peso, inicio, fin);
		         }
			         
			 		GrafoLista<Integer> MST = grafo.prim(grafo.getVertices().darElemento(0));

			 		System.out.println("El peso del MST es: "+ MST.getPeso());
			 		System.out.println("El peso del grafo original es: "+ grafo.getPeso());

			 		System.out.println(grafo.getPeso()-MST.getPeso());
			 		
			        linea = br.readLine();
			 
	         }
	      }
	      catch(Exception e){ e.printStackTrace(); }finally{
	         try{
	            if( fr != null  )  
	               fr.close();     
	         }catch (Exception e2){ e2.printStackTrace();}
	      }
	   }
}
