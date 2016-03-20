package mundo;

import java.io.Serializable;

//Clase que extiende de Exception
public class CafeIncompletoException extends Exception implements Serializable {

	//Constante de identificacion
	private static final long serialVersionUID = 1L;
	//Atributo
	private String recursoAgotado;
	
	//Constructor de la exception
	public CafeIncompletoException (String causa,String recAg){
		
		//Llamo constructor de la clase exception y le paso el parametro causa
		super(causa);
		
		//Inicializo los atributos
		recursoAgotado = recAg;
	} 
	
	//Metodo para regresar el nombre del recurso agotado
	public String darRecursoAgotado(){
		
		return recursoAgotado;
		
	}
	
	

}
