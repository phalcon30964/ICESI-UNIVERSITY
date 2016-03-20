package mundo;
import java.util.Date;

/**
*Clase encargada de gestionar las excepciones generadas por los errores con dias del programa.
*
*inv: 
*fecha!=null
*
*/
public class DiaException extends Exception {
	
	
	//-----------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------
	
	/**
     *fecha la fecha del dia e identificador unico de cada dia
     */
	private String fecha;

	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------
	
	/**
	*Constructor de la clase DiaException 
	*
	*@param causa String con un mensaje indicando la causa de la excepcion
	*@param fecha String con la fecha del dia para mostrar en mensaje
	*/
	public DiaException( String causa,  String fecha){
	  
	  super(causa+"\nError en dia:"+fecha);
	  this.fecha = fecha;
	  
	  verificarInvariate();
	  
  }
	
	//-----------------------------------------------------------------
	// Metodos
	//-----------------------------------------------------------------

  	/**
	*Metodo encargado se dar la fecha del dia
	*
	*@return la fecha del dia
	*/
	public String darFecha() {
		return fecha;
  }
	
	//-----------------------------------------------------------------
	// Invariante
	//-----------------------------------------------------------------
	
	public void verificarInvariate(){
		
		assert fecha!=null;
		
	}

}
