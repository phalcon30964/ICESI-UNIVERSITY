package Mundo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase Recuerdame, principal del organizador de tareas.
 * 
 * inv:
 * clasificaciones!=null
 * 
 * No puede haber dos clasificaciones con el mismo nombre.
 */
public class Recuerdame {
	
	//-----------------------------------------------------------------
	// Relaciones
	//-----------------------------------------------------------------
	
	private ArrayList <Clasificacion> clasificaciones;
	
	
	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------
	
	 /**
     * Constructor de la clase recuerdame.
     * 
     * Inicializa la realcion clasificaciones con un arraylist de <clasificacion>
     * Crea una clasificacion por defecto: Recordatorios
     * 
     *<br/><b>pos: </b> La relacion clasificaciones!=null
     *<br/><b>pos: </b> Se ha creado un nuevo objeto clasificaciones 
     */
	public Recuerdame(){
		
		clasificaciones = new ArrayList <Clasificacion>();
		clasificaciones.add(new Clasificacion("Recordatorios", "Pon aqui tus tareas sin clasificar"));
		
	}
	
	//-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------
	
	/**
	* Metodo que crear una nueva clasificacion para las tareas.
	* 
	*<br/><b>pos: </b> se ha creado una nueva clasificacion.
	*
	*@param nombreClas String con nombre de la clase nombreClas!= null && !nombreClas.equals("")
	*@param descripcionClas String con resumen de la clasificacion descripcionClas!=null
	*
	*@return boolean true si se agreg� o false si no se agreg�.
	*/
	public boolean crearClasificacion(String nombreClas, String descripcionClas){
		
		boolean retorno = false;
		
		if(buscarBinarioClasificacion(nombreClas)==null){

			clasificaciones.add(new Clasificacion(nombreClas, descripcionClas));
			
			ordenarClasificacionesPorSeleccion();
			verificarInvariante();
			
			retorno = true;
		}
		return retorno;
	}
	
	/**
	* Metodo que crea una tarea dentro de una clasificacion del organizador.
	*  
	*<br/><b>pos: </b> Se ha creado una nueva tarea en una clasificacion.
	*
	*@param: nombreTarea, String con nombre de la tarea nombreTarea!= null && !nombreTarea.equals("")
	*@param: descripcionTarea,  String del resumen de la tarea descripcionTarea!=null
	*@param: clasifica, String con el nombre de la clasificacion en donde se crear� la tarea, clasifica!= null
	*@param: fechaRecordatorio, String de la fecha para recordar la tarea (opcional)
	*
	*@return true si se agrego la tarea, false si no.
	*
	*/
	public boolean anadirTarea(String nombreTarea, String descripcionTarea, String fech, String clasifica){
		
		int anho = Integer.parseInt(fech.charAt(0)+fech.charAt(1)+fech.charAt(2)+fech.charAt(3)+"");
		int mes = Integer.parseInt(fech.charAt(4)+""+fech.charAt(5)+"");
		int dia = Integer.parseInt(fech.charAt(6)+""+fech.charAt(7)+"");
		
		Date fecha= new Date(anho , mes , dia );
		
		return buscarBinarioClasificacion(clasifica).crearTarea(nombreTarea, descripcionTarea, fecha);
		
	}
	
	/**
	* Metodo que busca una clasificacion en el arraylist ordenado de clasificaciones , segun un nombre pasado por 
	* parametro con algoritmo de busqueda binaria
	* 
	*@param: nombreClas, nombre de la clasificacion a buscar nombreClas!= null && !nombreClas.equals("")
	*
	*@return Clasificacion, la clasificacacion encontrada con el nombre pasado por parametro
	*
	*/
	public Clasificacion buscarBinarioClasificacion(String clas){
		
		ordenarClasificacionesPorSeleccion();
		
		Clasificacion buscada = null;
		boolean seEncontro = false;
		
//		int inicio = 0;
//		int fin = clasificaciones.size()-1;
//		
//			while(inicio<=fin && !seEncontro){
//			
//				int medio = (inicio+fin)/2;
//				if(clasificaciones.get(medio).compararPorNombre(clas)==0){
//					
//					buscada = clasificaciones.get(medio);
//					seEncontro = true;
//				}else if(clasificaciones.get(medio).compararPorNombre(clas)==1){
//					fin = medio-1;
//				}else if(clasificaciones.get(medio).compararPorNombre(clas)==-1){
//					inicio = medio+1;
//				}
//			}
		
		for (int i = 0; i < clasificaciones.size() && !seEncontro; i++) {
			
			if(clasificaciones.get(i).darNombre().equals(clas)==true){
			
				buscada = clasificaciones.get(i);
				seEncontro = true;
				
			}	
		}
			
		return buscada;
	}
	
	
	/**
	* Metodo que elimina la tarea con el nombre de la clasificacion
	* pasado por parametro.
	* 
	*<br/><b>pos: </b> Se eliminado una tarea.
	*
	*@param: nombreClas, String con nombre de la clasificacion a buscar, nombreClas!= null && !nombreClas.equals("")
	*@param: nombreTarea, String con nombre de la tarea a eliminar, nombreTarea!= null && !nombreTarea.equals("")
	*@return boolean true si se elimino, false si ocurrio algun problema o no se encontro la tarea en la clasificacion.
	*
	*/
	public boolean eliminarTarea(String nombreClas, Tarea tar){
		
		boolean retorno = buscarBinarioClasificacion(nombreClas).eliminarTarea(tar);
		verificarInvariante();
		
		return retorno;
		
	}
	
	/**
	* Metodo que da un arraylist de tareas, con todas las tareas de todas las clasificaciones ordenadas por fecha de creacion
	* 
	*@return ArrayLis de todas las tareas ordenadas por fecha
	*
	*/
	public ArrayList <Tarea> darTareasOrdenadasPorFechaConInsercion(){
		
		ArrayList <Tarea> listado = darTodasLasTareas();
		
		for (int i = 0; i < listado.size(); i++) {
			
			for (int j = i; j>0 ; j--) {
				
				if(listado.get(j-1).compararPorFechaCreacion(listado.get(j))==1){
					
					Tarea temp = listado.get(j);
					listado.set(j, listado.get(j-1));
					listado.set(j-1, temp);
				}
			}
		}
		return listado;
	}
	
	/**
	* Metodo crea y devuelve un arraylist de tareas ordenadas segun su categoria, a su vez ya 
	* las tareas por defecto habian sido organizadas por fecha de creacion
	* 
	*@return Arraylist de tareas ordenadas por su clasificacion
	*
	*/
	public ArrayList <Tarea> darTareasOrdenadasPorClasificacionConBurbuja(){
		
		ordenarClasificacionesPorSeleccion();
		return darTodasLasTareas();
	}
	
	/**
	* Metodo que exporta tareas pendientes por hacer a un archivo.txt
	* 
	*@return boolean true si se elimino, false si ocurrio algun problema o no se encontro la tarea en la clasificacion.
	*
	*/
	public void exportarTareasPendientes(){
		
		
//		public void generarReporte(String ruta) {
//			// TO-DO: Desarrollar el m�todo que genera el reporte.
//			File archivo = new File(ruta);
//			
//			try {
//				
//				PrintWriter escritor=new PrintWriter(archivo);
//				String datos="";
//				for(int i=0; i<inmuebles.size(); i++){
//					datos= inmuebles.get(i).getIdentificador()+ "; " + inmuebles.get(i).getTipoOferta()+";"+
//				inmuebles.get(i).getTipoInmueble()+";"+ inmuebles.get(i).getCiudad()+";" + inmuebles.get(i).getBarrio();
//					escritor.println(datos);
//					
//				}
//				escritor.close();
//			} catch (FileNotFoundException e) {
//			      
//				e.printStackTrace();
//			}
//			
//		}
		File archivo = new File("/Users/elkinvelez/Dropbox/CHRIS Y VALE/MiniProyecto/Recuerdame/Data/archivo.txt");

		try {

			PrintWriter escritor=new PrintWriter(archivo);
			String datos="";
			ArrayList<Tarea> pendientes=null;
			for(int i=0; i<clasificaciones.size(); i++){

				pendientes=clasificaciones.get(i).darTareasPendientes();
			}
			for(int j=0; j<pendientes.size();j++ ){

				datos= pendientes.get(j).darReporte();
				escritor.println(datos);

			}
			
			escritor.close();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		
				
	}
	
	/**
	* Metodo crea y retorna un arraylist de tareas con recordatorio para el dia de hoy
	*
	*@return ArrayList de tareas con recordatorio para hoy.
	*
	*/
	public ArrayList<Tarea> pendientesParaHoy(){
		
		ArrayList <Tarea> listado = darTodasLasTareas();
		
		ArrayList <Tarea> listaRetorno = new ArrayList <Tarea>();
		
		Calendar fecha = Calendar.getInstance();
		int anho = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH)+1;
		int dia = fecha.get(Calendar.DATE);
		@SuppressWarnings("deprecation")
		Date fechaActualSistema = new Date(anho, mes, dia);
		
		for (int i = 0; i < listado.size(); i++) {
			
			if(listado.get(i).darFechaRecordatorio()!=null && listado.get(i).darFechaRecordatorio().compareTo(fechaActualSistema)==0){
				
				listaRetorno.add(listado.get(i));
			}
		}
		
		return listaRetorno;
	}
		
	/**
	* Metodo que da como realizada una tarea cuando el usuario ya cumplio su pendiente
	*  
	*<br/><b>pos: </b> El atributo realizada de la tarea seleccionada cambia a true
	*
	*@param: nombreClas, String con nombre de la clasificacion a buscar, nombreClas!= null && !nombreClas.equals("")
	*@param: nombreTarea, String con nombre de la tarea a realizar, nombreTarea!= null && !nombreTarea.equals("")
	*
	*/
	public void realizarTarea(String nombreClas, String nombreTarea){
		
		buscarBinarioClasificacion(nombreClas).buscarTarea(nombreTarea).realizar();
		
	}
	
	
	/**
	* Metodo que agrupa todas las tareas en un arraylist
	* 
	*@return ArrayList con todas las tareas del programa
	*/
	public ArrayList <Tarea> darTodasLasTareas(){
		
		ArrayList <Tarea> listado = new ArrayList <Tarea>();
		
		for (int i = 0; i < clasificaciones.size(); i++) {
			
			for (int j = 0; j < clasificaciones.get(i).darTareas().size() ; j++) {
				
				listado.add(clasificaciones.get(i).darTareas().get(j));
				
			}
		}
		
		return listado;
	}
	
	/**
	* Metodo mantiene ordenadas las clasificaciones segun su nombre mediante el algortimo de ordenamiento por seleccion
	* este metodo garantisa a busquedaBinariaClasificaciones que el arraylist a buscar esta ordenado
	*/
	public void ordenarClasificacionesPorSeleccion(){
		
		for (int i = 0; i < clasificaciones.size()-1 ; i++) {
			
			Clasificacion menor = clasificaciones.get(i);
			int posicion = i;
			
			for (int j = i+1 ; j < clasificaciones.size(); j++) {
				
				if(clasificaciones.get(j).compararPorNombre(menor.darNombre())==-1){
					menor = clasificaciones.get(j);
					posicion = j; 
				}	
			}
			Clasificacion temp= clasificaciones.get(i);
			clasificaciones.set(i, menor);
			clasificaciones.set(posicion, temp);
		}
	}
	
	/**
	* Metodo que retorna el arraylist clasificaciones
	* 
	* @return Arraylist de clasificaciones
	*/
	public ArrayList<Clasificacion> darClasificaciones(){
		
		return clasificaciones;
		
	}
	
	//-----------------------------------------------------------------
    // Invariante
    //-----------------------------------------------------------------
	
	private boolean hayClasificacionesRepetidas(){
		
		boolean hayRepetidas = false;
		for (int i = 0; i < clasificaciones.size() && !hayRepetidas ; i++) 
		{
			for (int j = 0; j < clasificaciones.size() && !hayRepetidas ; j++) {
				
				if(clasificaciones.get(i).darNombre().equals(clasificaciones.get(j))){
					hayRepetidas = true;
				}
			}
			
		}
		return hayRepetidas;
	}
	
	/**
	* inv:
    * clasificaciones!=null
    * 
	* No puede haber dos clasificaciones con el mismo nombre.
	*/
	public void verificarInvariante(){
		
		assert clasificaciones!=null: "Las clasificaciones deben estar inicializadas";
		assert hayClasificacionesRepetidas()==false:"No pueden haber dos clasificaciones con el mismo nombre";
	}
	
}


