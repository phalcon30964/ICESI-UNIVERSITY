/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author camilo
 */
public class MaratonAPO1 extends Maraton {
    
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
        String firstLine = leerLinea();
        imprimirLinea("No solution implemented for problem A");
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
