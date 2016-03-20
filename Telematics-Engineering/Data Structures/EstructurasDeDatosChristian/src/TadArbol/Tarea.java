package TadArbol;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

import javax.swing.JFrame;




import TadArbol.ArbolABB;

public class Tarea {

	public static void main(String[] args) throws Exception {
		
		ArbolABB<String, String> arbol =new ArbolABB<>();
		
	    int pos;
	    int numeroDatos = 10;
//	    Stack < Integer > numeros = new Stack < Integer > ();
//	    
//	    for (int i = 0; i < numeroDatos ; i++) {
//	      pos = (int) Math.floor(Math.random() * numeroDatos);
//	      while (numeros.contains(pos)) {
//	        pos = (int) Math.floor(Math.random() * numeroDatos );
//	      }
//	      numeros.push(pos);
//	      
//	     
//	      
//	    }
	    
	    
	    
	    ArrayList<String> numeros = new  ArrayList<String>();
	    
	    for (int i = 0; i < numeroDatos; i++) {
	    	numeros.add(i+"");
	    	
	    	
		}
	    
	    Collections.shuffle(numeros);
	    
	
	    
	  
	    long tiempoInicialAgregar = System.nanoTime();
	    
	    for(int i=0;i<numeros.size();i++){ 
	    	arbol.agregar(numeros.get(i)+"", numeros.get(i)+"");
	    	}
	     
	    long tiempoFinAgregar = System.nanoTime();
	    long resAgregar = tiempoFinAgregar - tiempoInicialAgregar;
	    
	    System.out.println("Agregar "+resAgregar);
	   
	    
	    
	    
	    long tiempoInicialRecorrer = System.nanoTime();
	    String msj = arbol.cadenaInorden();
	    long tiempoFinRecorrer = System.nanoTime();
//	    System.out.println("El arbol quedo asi "+msj);
	    long  resRecorrer=tiempoFinRecorrer-tiempoInicialRecorrer;
	    System.out.println("Recorrer "+resRecorrer);
	   

	    
	    
	    
	    long tiempoInicialBuscar = System.nanoTime();
	    for(int i=0;i<numeros.size();i++){ 
	    	arbol.buscar(numeros.get(i)+"");
	    	}
	    long tiempoFinBuscar = System.nanoTime();
	    long  resBuscar=tiempoFinBuscar-tiempoInicialBuscar;
	    System.out.println("Buscar "+resBuscar);
	
	    
	    long tiempoInicialEliminar = System.nanoTime();
	    for(int i=numeros.size()-1;i>=0;i--){ 
	    	arbol.eliminar(numeros.get(i)+"");
		    System.out.println("la altura es "+ arbol.getPeso());

	    	}
	    
	    long tiempoFinEliminar = System.nanoTime();
	    long  resEliminar=tiempoFinEliminar-tiempoInicialEliminar;
	    System.out.println("Eliminar "+resEliminar);

	   
	    
	  }	
	}
