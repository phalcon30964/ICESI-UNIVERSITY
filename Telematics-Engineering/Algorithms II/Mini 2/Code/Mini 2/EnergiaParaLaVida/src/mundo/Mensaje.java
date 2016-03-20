package mundo;

import java.io.Serializable;
import java.util.ArrayList;

/**
*Clase mensaje que gestiona los mensajes de un dia 
*
*inv:
*
*msjMotivacion!=null && !msjMotivacion.equals("")
*autorMsj!=null && !autorMsj.equas("")
*
*/
public class Mensaje implements Serializable{
	
	/**
	 * seialversion del serializable
	 */
	private static final long serialVersionUID = 1L;
	
	//----------------------------------------
	//Atributos
	//----------------------------------------
	
	/**
	 * mensaje de motivacion a mostrar en la interfaz
	 */
	private String msjMotivacion;
	
	/**
	 * el autor del mensaje 
	 */
	private String autorMsj;
	
	//-----------------------------------------------------------------
	// Relaciones
	//-----------------------------------------------------------------
	
	/**
	 * mensaje siguiente en la secuencia
	 */
	private Mensaje siguienteMensaje;
	
	/**
	 * mensaje anterior en la secuencia
	 */
	private Mensaje anteriorMensaje;
	
  
	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------
	
	/**
	*Constructor de la clase mensaje, inicializa un mensaje con los atributos de la clase
	*/
	public Mensaje( String msjMotivacion,  String autorMsj){
		
	  this.msjMotivacion = msjMotivacion;
	  this.autorMsj = autorMsj;
	  
	  verificarInvariante();
	  
  }
	/**
	*Metodo encargado de avanzar en los mensajes
	*
	*@return el mensaje siguiente, null si no existe
	*/
	public Mensaje darSiguiente() {
		return siguienteMensaje;
	}
	
	/**
	*Metodo encargado de retroceder en los mensajes
	*
	*@return el mensaje anterior, null sino existe
	*/
	public Mensaje darAnterior() {
	return anteriorMensaje;
	}
	
	/**
	*cambia relacion al siguiente mensaje
	*/
	public void cambiarSiguiente(Mensaje siguiente) {
		this.siguienteMensaje = siguiente;
	}
	
	/**
	*Cambia relacion al anterior mensaje
	*/
	public void cambiarAnterior(Mensaje anterior) {
		this.anteriorMensaje = anterior;
	}
	
	/**
	*Metodo que da el mensaje de motivacion
	*
	*@return mensaje de motivacion
	*/
	public String darMsjMotivacion() {
		return msjMotivacion;
	}
	
	
	/**
	*Metodo retorna el autor del mensaje
	*
	*@return Autor
	*/
	public String darAutorMsj() {
		return autorMsj;
     }
	
	/**
	*Metodo retorna un mensaje con la informacion del objecto
	*
	*@return Informacion del objeto
	*/
	public String toString() {
		return "Mensaje ["+msjMotivacion+"]";
	}
	
	/**
	*Metodo encargado de eliminar las relaciones siguiente y anterior del
	*mensaje actual
	*
	*<br/><b>pos: </b> El mensaje se a autoEliminado de la secuencia
	*/
	public void autoDesconectarse() {
	  
		this.darSiguiente().cambiarSiguiente(this.anteriorMensaje);
		this.darAnterior().cambiarSiguiente(this.siguienteMensaje);
		this.cambiarAnterior(null);
		this.cambiarSiguiente(null);
	}
	
	
	
	//-----------------------------------------------------------------
	// Invariante
	//-----------------------------------------------------------------
	
	public void verificarInvariante(){
		assert msjMotivacion!=null && !msjMotivacion.equals("");
		assert autorMsj!=null && !autorMsj.equals("");
	
	}


}
