/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.*;

public class MaratonAPO1 extends Maraton {
	
	private ArrayList <String> listaCumpleanos; 
    
    public MaratonAPO1() {
        super();
    }
    
    public void resolverEjemplo() throws Exception {
        
        String firstLine = leerLinea();
        int numberOfCases = Integer.valueOf(firstLine);
        
        for (int i = 0; i < numberOfCases; i++) {
            String caseString = leerLinea();
            String numbersInText[] = caseString.split(" ");
            int start = Integer.valueOf(numbersInText[0]);
            int end = Integer.valueOf(numbersInText[1]);
            imprimirLinea("case "+(i+1)+":");
            for (int j = start; j <= end; j++) {
                imprimirLinea(""+j);
            }
        }
        
    }
    
    public void resolverProblemaA() throws Exception {
        listaCumpleanos = new ArrayList <String> ();
        int numListas = Integer.parseInt(leerLinea());
        
        for(int i = 0; i < numListas; i++ ){
        	int numLineas = Integer.parseInt(leerLinea());
    	  
    	    	for(int k = 0; k < numLineas ; k++){
    	    		listaCumpleanos.add(leerLinea());
    	    	}
      	}
      
      	for(int p=0; p<listaCumpleanos.size(); p++){
    	  
    	  	for(int f = p+1; f<listaCumpleanos.size(); f++){
    	  		if(listaCumpleanos.get(p).equals(listaCumpleanos.get(f))){
    			  listaCumpleanos.remove(f);
    	    	}
    	  	}
      	}
    
      	for(int t=0; t<listaCumpleanos.size(); t++){
    	  imprimirLinea(listaCumpleanos.get(t));
      	}
    }

    
    public void resolverProblemaB() throws Exception {
        String firstLine = leerLinea();
        
        
        imprimirLinea("No solution implemented for problem B");
    }
    
    public void resolverProblemaC() throws Exception {
        String firstLine = leerLinea();
        imprimirLinea("No solution implemented for problem C");
    }
    
    public void resolverProblemaD() throws Exception {
        String firstLine = leerLinea();
        imprimirLinea("No solution implemented for problem D");
    }
    
    public void resolverProblemaE() throws Exception {
        String firstLine = leerLinea();
        imprimirLinea("No solution implemented for problem E");
    }

}
