package mundo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 * Clase Dia, clase que se encarga de modelar los dias y de administrar los mensajes que en esta se encuentran
 * 
 * inv:
 * fecha!=null && colorRecomendado!=null
 * 
 * Todo dia debe tener inicializado su fecha y su colorRecomendado debe ser un color.
 * 
 */

public class Dia {
	
	//-----------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------
	
	/**
     *fecha la fecha del dia e identificador unico de cada dia
     */
	private Date fecha;
	
	/**
     *colorRecomendado el color perfecto para el dia a recordar
     */
	private String colorRecomendado;
	
	//-----------------------------------------------------------------
	// Relaciones
	//-----------------------------------------------------------------
	
	/**
     *siguiente es el dia siguiente en la secuencia
     */
	private Dia siguiente;
	
	/**
     *primerMensaje es el primer mensaje de la cadena de mensajes que tiene cada dia
     */
	private Mensaje primerMensaje;
	
  
	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------
	
	/**
    * Constructor de la clase dia.
    * 
    * Inicializa los atributos fecha y colorRecomendado.
    * 
    *<br/><b>pre: </b> La fecha debe tener el formato "dd.MM.yyyy".
    *<br/><b>pos: </b> Los atributos fecha!=null && colorRecomendado!=null fueron inicializados.
    *
    *@param fecha String que contiene una fecha para el establecer el dia actual o 
    *a futuro de la visualizacion de los mensajes. 
    *@param colorR es el color recomendado para el dia a crear colorRecomendado!=null
	*@throws ParseException cuando la fecha introducida no es valida
    *
    */
    public Dia( String fech,  String colorR) throws ParseException {
    	
	 //creo la fecha
	  SimpleDateFormat formato = new SimpleDateFormat("dd.MM.yy");
	  Date fecha = formato.parse(fech);
	  
	  //inicializo color
	  colorRecomendado = colorR;
	  
	  verificarInvariante();
	
  }
    
  //-----------------------------------------------------------------
  // Metodos
  //-----------------------------------------------------------------
	
  
    /**
	* Metodo que agrega un nuevo mensaje a la lista enlazada de mensajes de un dia 
	* 
	*<br/><b>pos: </b> Se ha agregado un mensaje mas a la lista de mensajes
	*
	*@param fech fecha del dia 
	*@param descripcionClas String con resumen de la clasificacion descripcionClas!=null
	* 
	*/
    
  public void agregarMensaje( String motivacion,  String autorMsj) {
	  
	  Mensaje ultimo = localizarUltimoMensaje();
	  
	  Mensaje msj = new Mensaje(motivacion, autorMsj, ultimo.darId()+1);
	  
	  ultimo.cambiarSiguiente(msj);
	  msj.cambiarAnterior(ultimo);
	  msj.cambiarSiguiente(primerMensaje);
	  primerMensaje.cambiarAnterior(msj);
	  
  }

  public Mensaje localizarUltimoMensaje() {
	  
	  Mensaje ultimo = null;
	  
	  Mensaje actual = primerMensaje;
	  
	 


	  return ultimo;
  }

  public void eliminarMensaje( int idM) {
  }

  public Mensaje localizarMensaje( int idM ) {
	  Mensaje quien = null;
	  Mensaje actual = primerMensaje;
	  
	  while(actual!=null){
		  int id = actual.darId();
		  if(id==actual.darId()){
			  quien = actual;
			  actual.darSiguiente();
		  }
	  }
  return quien;
  }

  public Dia darSiguiente() {
  return siguiente;
  }

  public void cambiarSiguiente(Dia nuevo) {
	  this.siguiente = nuevo;
  }

  public Date darFecha() {
  return fecha;
  }

  public String darColorRecomendado() {
  return colorRecomendado;
  }
  
  public void verificarInvariante(){
	  
	  assert fecha!=null && colorRecomendado!=null;
	  
  }

}
