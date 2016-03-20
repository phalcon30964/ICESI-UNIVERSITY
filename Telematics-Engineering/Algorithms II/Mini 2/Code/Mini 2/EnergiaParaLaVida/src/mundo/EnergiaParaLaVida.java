package mundo;

import java.io.File;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
*Clase principal del mundo que se encarga de gestionar todas los mensajes y dias del programa
*
*inv:
*
*no puede haber dos dias con la misma fecha
*
*/
public class EnergiaParaLaVida implements Serializable{
	
	//-----------------------------------------------------------------
	// Atributos y constantes
	//-----------------------------------------------------------------
	
	/**
	 * numero de dias de la lista de dias
	 */
	private int numDias;
	
	//CONSTANTE
	/**
	 * Constante de serializacion
	 */
	private static final long serialVersionUID = 3L;
	
	//-----------------------------------------------------------------
	// Relaciones
	//-----------------------------------------------------------------
	
	/**
	 * El primer dia de la secuencia de dias
	 */
	private Dia primerDia;
	
	
	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------
	
	/**
     * Constructor de la clase Energia Para La Vida, principal del mundo
     * 
     *<br/><b>pos: </b> Se ha creado el mundo del programa
     */
  	public EnergiaParaLaVida() {
  		numDias = 0;
  		verificarInvariante();
	}
	
	//-----------------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------------
	
	/**
	*Metodo encargado de crear un dia y adicionarlo por defecto a la ultima posicion a la 
	*coleccion de dias
	*
	*<br/><b>pos:se ha agregado un nuevo dia a la coleccion de dias
	*
	*@param fecha String con la fecha del dia a crear
	*@param colorR String con el color recomendado para cada dia 
	*@throws DiaException si ocurrio algun problema al crear el nuevo dia
	*@throws ParseException si el String de la fecha no tiene el formato especificado
	*/
  	
 	public void agregarDia( String fecha, String colorR) throws DiaException {
 		
 		 //comprobacion de si existe
 		if(localizarDiaPorFecha(fecha)!=null){
 			throw new DiaException("El dia ya existe", fecha);
 		}
 		
 		//si no estaba en la lista lo agrego
 		Dia nuevo = new Dia(fecha, colorR);
 		
 		if(primerDia==null){
 			primerDia = nuevo;
 			numDias++;
 			
 		}else if(primerDia.compararDia(nuevo)>0){
 			
 			nuevo.cambiarSiguiente(primerDia);
 			primerDia = nuevo;
 			numDias++;
 			
 		}else{
 			
 			Dia actual = primerDia;
 			
 			
 			//me paro sobre la posicion en la cual el siguiente dia ya no es mayor que el actual
 			while(actual!=null && actual.darSiguiente()!= null && actual.darSiguiente().compararDia(nuevo)>0 && actual.darSiguiente().compararDia(nuevo)!=0){
 				actual = actual.darSiguiente();
 			}
 			
 			//si habia un dia mayor al actual lo agrego despues de el
 			if(actual!=null){
 			nuevo.cambiarSiguiente(actual.darSiguiente());
			actual.cambiarSiguiente(nuevo);
			numDias++;
			
 			}else{
 			//si por casualidades de la vida no habia un dia mayor y el actual era el mayor que todos busco el ultimo y lo agrego despues de el
 	 			localizarUltimoDia().cambiarSiguiente(nuevo);
 	 			numDias++;	
 			}

 		}
 		
 		verificarInvariante();
	}
	
	/**
	*Metodo encargado de buscar un dia por la fecha 
	*
	*@param fech String fech con la fecha del dia a buscar
	*
	*@return el dia que se busco , null si no existe
	*/
	public Dia localizarDiaPorFecha(String fecha) {
		
		Dia actual = primerDia;
		
		while (actual!=null && !actual.darFecha().equals(fecha)) {
			actual = actual.darSiguiente();
		}
		
		return actual;
	}
	
	/**
	*Metodo encargado de buscar en la coleccion de dias el ultimo dia
	*
	*@return el ultimo dia de la coleccion de dias, null sino hay ningun dia 
	*/
	public Dia localizarUltimoDia(){
		
		Dia actual = primerDia;
		
		if(actual!=null){
			while(actual.darSiguiente()!=null){
				actual = actual.darSiguiente();
			}
		}
		
		return actual;
	}
	
	
	/**
	*Metodo encargado de crear un nuevo mensaje en la lista de mensajes de dia
	*
	*<br/><b>pos:se ha agregado un nuevo mensaje a la coleccion de mensajes
	*
	*@param msjM String con el mensaje de motivacion
	*@param autor con el autor del mensaje de motivacion
	*@return true si el mensaje se agrego correctamente o false si no
	*@throws Exception si el dia al que se intenta agregar el mensaje no existe
	*/
	
	public void agregarMensajeADia( String fecha, String autor, String msjM) throws Exception{
		
		Dia diaBuscado = localizarDiaPorFecha(fecha);
		
		if(diaBuscado==null){
			throw new Exception("No existe el dia al que va a agregar el mensaje");
		}else{
			diaBuscado.agregarMensaje(msjM, autor);
		}
 	}
	
	/**
	*Metodo encargado de eliminar los mensajes de la coleccion de mensajes que maneja
	*la clase dia
	*
	*<br/><b>pos:se ha eliminado el mensaje de la coleccion de mensajes
	*
	*@param fecha del dia en que se encuentra el mensaje
	*@throws Exception Si no se encuenta el mensaje a eliminar
	*@throws DiaException cuando no se encuentre el dia que se contiene el mensaje
	*
	*/
	public void eliminarMensajeADia( String fech,  String motivacion) throws Exception {
		
		Dia diaBuscado = localizarDiaPorFecha(fech);
		
		if(diaBuscado==null){
			throw new DiaException("El dia donde se encuentra el mensaje no existe", fech);
		}else{
			localizarDiaPorFecha(fech).eliminarMensaje(motivacion);
		}
		
		
		
	}

	/**
	*Metodo encargado de dar la fecha mas cercana con respecto a la fecha de hoy
	*
	*@return el dia mas cercano, bien sea el mismo dia actual o un dia pasado
	*/
	public Dia darDiaFechaMasCerca() {

		Calendar fecha = Calendar.getInstance();
		int anho = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH)+1;
		int dia = fecha.get(Calendar.DATE);
		String fechaAhoraMismo = anho+"/"+mes+"/"+dia;
			
		Dia actual = primerDia;
		
		//mientras que el siguiente dia no sea mayor que el de hoy
		while(actual!=null && actual.darSiguiente()!=null && !(actual.darSiguiente().darFecha().compareTo(fechaAhoraMismo)>0)){
			actual = actual.darSiguiente();
		}
		
		return actual;
	}
	
	/**
	 * Metodo que da un arraylist de dias, con todos los dias ordenadas por fecha
	 * 
	 *@return ArrayLis de todos los dias ordenado por fecha para ser visualizados en la interfaz
	 *
	 */
	public ArrayList <Dia> darListaDias(){
		
		ArrayList<Dia> dias = new ArrayList<Dia>();
		
		Dia actual = primerDia;
		
		for (int i = 0; i < numDias; i++) {
			
			dias.add(actual);
			actual = actual.darSiguiente();
			
		}
		
		return dias;
	}
	
	/**
	 * Devuelve el numero de dias en el programa
	 * 
	 *@return ArrayLis de todos los dias ordenado por fecha para ser visualizados en la interfaz
	 *
	 */
	public int darNumDias(){
		return this.numDias;
	}
	

	//-----------------------------------------------------------------
	// Invariante
	//-----------------------------------------------------------------
	
	public void verificarInvariante(){
		assert numDias>0;
	}




}
