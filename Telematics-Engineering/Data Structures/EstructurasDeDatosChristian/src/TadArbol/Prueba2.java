package TadArbol;

import java.util.ArrayList;
import java.util.Collections;

public class Prueba2 {
	
	public static void main(String[] args) {
		
		ArbolABB<Integer, Integer> arbol = new ArbolAVL<Integer, Integer>();
		
		int n = 100;
		
		try {
			
			ArrayList<String> numeros = new  ArrayList<String>();
		    
		    for (int i = 0; i < n; i++) {
		    	numeros.add(i+"");
			}
		    
		    Collections.shuffle(numeros);
		    
		    for (int i = 0; i < numeros.size(); i++) {
				arbol.agregar(new Integer(numeros.get(i)) , new Integer(new Integer(numeros.get(i))));
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(arbol.cadenaInorden());
		
		System.out.println("Se imprime por niveles");
		for (int i = 0; i < arbol.getAltura(); i++) {
		System.out.println(arbol.cadenaRecorridoPorNivel(i));
		}
		
	}

}
