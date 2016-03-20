/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author camilo
 */
public class Maraton {

    private String[] input;
    private String output;
    private int line_counter;
    
    public Maraton() {
        super();
    }

    public void startSolving(String text) {
        output = null;
        input = text.split("\n");
        line_counter = 0;
    }
    
    public String leerLinea() {
        if(line_counter < input.length) {
            line_counter ++;
            return input[line_counter-1];
        } else
            return null;
    }
    
    public void imprimirLinea(String line) {
        if(output == null) {
            output = line;
        } else {
            output += "\n" + line;
        }
    }

    public String getOutput() {
        return output;
    }
}
