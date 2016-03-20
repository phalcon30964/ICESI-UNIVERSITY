package mundo;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Clase Dia, clase que se encarga de modelar los dias y de administrar los mensajes que en esta se encuentran
 * 
 * inv:
 * fecha!=null && colorRecomendado!=null
 * 
 * Todo dia debe tener inicializado su fecha y su colorRecomendado debe ser un color.
 * 
 * No puede haber dos mensajes con un mismo id
 * 
 */

public class Dia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	//-----------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------

	/**
     *fecha la fecha del dia e identificador unico de cada dia
     */
	private String fecha;
	
	/**
     *colorRecomendado el color perfecto para el dia a recordar
     */
	private String colorRecomendado;
	
	/**
     *numero de mensajes en la lista de mensajes
     */
	private int numMensajes;
	
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
    *
    */
    public Dia( String fech,  String colorR) {
    	
	 fecha = fech;
	 colorRecomendado = colorR;
	 numMensajes = 0;
	  
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
     * @throws Exception 
	* 
	*/
  public void agregarMensaje( String motivacion,  String autorMsj) throws Exception {
	  
	  if(localizarMensaje(motivacion)!=null){
		  throw new Exception("El mensaje ya existe en el dia seleccionado");
	  }
	  
	  Mensaje msj = new Mensaje(motivacion, autorMsj) ;
	  
	  if(primerMensaje==null){
		  primerMensaje = msj;
		  numMensajes++;
	  }else{
		  
		  Mensaje ultimo = localizarUltimoMensaje();
		  msj.cambiarSiguiente(primerMensaje);
		  msj.cambiarAnterior(ultimo);
		  ultimo.cambiarSiguiente(msj);
		  primerMensaje.cambiarAnterior(msj);
		  
		  numMensajes++;
	  }  
	  
	  verificarInvariante();
  }
  
  
  /**
 	* Metodo que localiza el ultimo dia de la lista enlazada de mensajes
 	* 
 	* @return Mensaje mensaje ultimo de la lista, null si no hay mensajes
 	*/
  public Mensaje localizarUltimoMensaje() {
	  
	  Mensaje actual = primerMensaje;
	  
	  if(actual!=null){
			while(actual.darSiguiente()!=null && actual.darSiguiente()!=primerMensaje){
				actual = actual.darSiguiente();
			}
	  }
	  
	  return actual;
  }
  
  
  /**
	* Metodo que elimina mensajes de un dia.
	* 
	*<br/><b>pos: </b> Se eliminado el mensaje que tiene el id pasado por parametro
	*
	*@param idM id del mensaje a borrar
	*@throws Exception cuando el id pasado por parametro no coincide con ningun mensaje.
	* 
	*/
  public void eliminarMensaje(String motivacion) throws Exception {
	  
	  if(primerMensaje==null || localizarMensaje(motivacion)==null){
		  
		  throw new Exception("No se encontro el mensaje que desea eliminar");
		  
	  }else if(primerMensaje!=null && primerMensaje.darSiguiente()==null){
		  
		  primerMensaje = null;
		  numMensajes--;
		  
	  }else if(motivacion.equals(primerMensaje.darMsjMotivacion())){

		 Mensaje inicio = primerMensaje;
		 
		 primerMensaje = primerMensaje.darSiguiente();
		 primerMensaje.cambiarAnterior(localizarUltimoMensaje());
		 localizarUltimoMensaje().cambiarSiguiente(primerMensaje);
		 
		 inicio.cambiarAnterior(null);
		 inicio.cambiarSiguiente(null);
		 inicio = null;
		 
		 numMensajes--;
		 
	  }else{

		localizarMensaje(motivacion).autoDesconectarse();
		numMensajes--;
		 
	  }
		  
  }
  
  
  /**
	* Metodo que devuelve un el mensaje con el id pasado por parametro.
	*
	*@param  motivacion String id del mensaje 
	*@return Mensaje mensaje buscado que tiene el idM parametro, null si no se encuentra el mensaje
	* 
	*/
  public Mensaje localizarMensaje( String motivacion ) {
	  
	  Mensaje actual = primerMensaje;

		  while(actual!=null && actual.darSiguiente()!=primerMensaje && !actual.darMsjMotivacion().equals(motivacion) ){
		  actual = actual.darSiguiente();
		  }
	
		  if(actual!= null && !actual.darMsjMotivacion().equals(motivacion)){
			  actual = null;
		  }
		  
	  return actual;
  }
  
  /**
	* Metodo que compara dos dias, el actual y uno pasado por parametro.
	*
	*@param d Dia a comparar con el actual
	*@return numero>0 Si el dia actual es mayor que el parametro, 0 si los dos dias son iguales,  numero<0 si 
	*el dia actual es menor que el parametro.
	* 
	*/
  public int compararDia(Dia d){
	  return this.fecha.compareTo(d.darFecha());
  }
  
  
  /**
	* Metodo que devuelve el dia siguiente en la secuencia de dias
	* 
	*@return Dia dia siguiente
	*/
  public Dia darSiguiente() {
  return this.siguiente;
  }
  
  
  /**
	* Metodo cambia el atributo la referencia al siguiente dia en la secuencia
	*/
  public void cambiarSiguiente(Dia nuevo) {
	  this.siguiente = nuevo;
  }

  /**
	* Metodo que devuelve la fecha del dia 
	* 
	*@return String con la fecha del dia
	*/
  public String darFecha() {
  return this.fecha;
  }

  /**
	* Metodo devuelve el color recomendado para el dia actual
	* 
	*@return String con color recomendado
	*/
  public String darColorRecomendado() {
  return this.colorRecomendado;
  }
  
  /**
 	* Metodo devuelve el primer mensaje de la lista enlazada de mensajes
 	* 
 	*@return Mensaje el primer mensaje
 	*/
  public Mensaje darPrimerMensaje(){
	 return this.primerMensaje;
  }
  
  /**
	* Metodo devuelve los mensajes para mostrarlos en la interfaz
	* 
	*@return ArrayList<Mensaje> 
	*/
  public ArrayList <Mensaje> darListaMensajes(){
		
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		
		Mensaje actual = primerMensaje;
		
		for (int i = 0; i < numMensajes; i++) {
			mensajes.add(actual);
			actual = actual.darSiguiente();
		}
		
		return mensajes;
	}
  
  @Override
  public String toString() {
  	return fecha;
  }
  
  //-----------------------------------------------------------------
  // Invariante
  //-----------------------------------------------------------------
  /** 
   * inv:
   * Todo dia debe tener inicializado su fecha y su colorRecomendado debe ser un color.
   * 
   */
  public void verificarInvariante(){
	  assert fecha!=null && colorRecomendado!=null;  
  }



}
