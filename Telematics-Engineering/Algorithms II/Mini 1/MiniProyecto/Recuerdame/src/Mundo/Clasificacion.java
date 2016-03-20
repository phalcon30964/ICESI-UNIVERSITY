package Mundo;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Clase Clasificacion, agrupa las tareas en clasificaciones
 * 
 * inv:
 * nombre!=null && !nombre.equalsIgnoreCase("")
 * descripcion!=null 
 * tareas!=null;
 * 
 * En el arraylist tareas no puede haber 2 tareas con el mismo nombre
 * La descricion es opcional, descripcion.equals("")
 */
public class Clasificacion {
	
	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	
	/**
     * nombre de la tarea
     */
	private String nombre;
	
	/**
     * descripcion de la tarea
     */
	private String descripcion;
	
	/**
     * Arraylist donde se guardaran las tareas
     */
	private ArrayList<Tarea> tareas;

	
	//-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------
	
	
	/**
	 * Constructor de clasificacion.<br>
	 * 
	 * Metodo que inicializa todos los atributos y el arraylist tareas
	 * 
	 * <b>post: </b> Se inicializaron todos los atributos y relaciones
	 * 
	 * @param: elNombre nombre de la clasificacion 
	 * @param: laDescripcion  Descripcion de la clasificacion (opcional)
	 * 
	 */
	public Clasificacion(String elNombre, String laDescripcion){
		
		this.nombre=elNombre;
		this.descripcion=laDescripcion;
		
		tareas= new ArrayList <Tarea>();
		
		verificarInvariante();
	}
	
	/**
	 * Crea una nueva tarea y la agrega al arraylist tareas, el metodo aparte de los parametro imprime una etiqueta que identica que la
	 * pertenece a la clasificacion actual
	 * 
	 *  <b>post: </b> Se creó una nueva tarea en el arraylist tareas
	 *  
	 * @param String nom  nombre de la tarea,   nom != null y !nom.equals("")
	 * @param String desc descripcion de la tarea,  laDescripcion!= null
	 * @param Date fechaRecor, fecha del recordatorio 
	 */
	public boolean crearTarea(String nom, String desc, Date fechaRecor){
		
		boolean retorno = false;
		//Se asigna la etiqueta del nombre de la clasificacion
		Tarea tar = new Tarea(nom, desc, fechaRecor, nombre);
	
		if(buscarTarea(nom)==null){
			
			tareas.add(tar);
			
			retorno = true;
			
			ordenarPorFechaConBurBuja();
			verificarInvariante();
		}
			
		return retorno;
		
	}
	
	/**
	 * Metodo que busca una tarea y en caso de NO encontrarla retorna null.
	 * 
	 * @param nombreTarea strin con el nombre de la tarea que se desea buscar.
	 * @return: la tarea encontrada o en su defecto null.
	 */
	public Tarea buscarTarea(String nombreTarea){
		
		boolean encontrada = false;
		Tarea buscada = null;
		
		for(int i=0; i<tareas.size() && !encontrada; i++){
			
			if(tareas.get(i).darNombre().equals(nombreTarea)){
				
				buscada=tareas.get(i);
				
				encontrada=true;
			}
		}
			return buscada;
	}

	
	/**
	 * Metodo que retorna un vector con las tareas
	 * @return vector con tareas de la clasificacion
	 */
	public ArrayList<Tarea> darTareas(){
		
		return tareas;
		
	}
	
	
	/**
	 * Metodo que retorna un arraylist con las tareas que aun no se han realizado
	 * 
	 * @return ArrayList con tareas no realizada hasta el momento
	 */
	public ArrayList<Tarea> darTareasPendientes(){
		
		ArrayList <Tarea> pendientes = new ArrayList<Tarea>();
		//busco en un recorrido total cuales tareas no estan realizadas
		for(int i = 0; i<tareas.size(); i++){
			
			if(tareas.get(i).estaRealizada()==false){
				pendientes.add(tareas.get(i));
			}
		}
		return pendientes;
	}
	
	
	/**
	 * Metodo que elimina la tarea pasada como parámetro
	 * 
	 * <b>post: </b> Se eliminó una tarea seleccionada
	 * 
	 * @param Tarea a eliminar
	 */
	public boolean eliminarTarea(Tarea tar){
		
		boolean retorno = false;
		int indexTar = tareas.indexOf(tar);
		
		if(indexTar!=-1){
		tareas.remove(indexTar);
		retorno = true;
		}
		
		verificarInvariante();
		
		return retorno;
	}
	
	
	/**
	 * Metodo que se encarga de mantener las tareas usando un algoritmo BURBUJA<br>
	 * 
	 *<b>post:</b> Se organizo el arraylist tareas por orden de fecha
	 */
	public void ordenarPorFechaConBurBuja(){
		
		for (int i = tareas.size() ; i>0 ; i--){
			
			for (int j = 0; j < i-1 ; j++) {
				
				if(tareas.get(j).compararPorFechaCreacion(tareas.get(j+1))==1){
					
					Tarea temp = tareas.get(j);
					tareas.set(j, tareas.get(j+1));
					tareas.set(j+1, temp);
				}
			}
		}
	}
	
	/**
	 * Metodo que marca como realizada la tarea del arraylist tareas pasada por parametro
	 * <b>post: </b> Se marco la tarea como realizada, realizada=true
	 * @param tar un String con el nombre de la tarea que se desea marcar como realizada
	 */
	public void marcarRealizada(String tar){
		
		buscarTarea(tar).realizar();
		
	}
	
	/**
	 * Metodo compara el nombre de la clasificacion actual con otro pasado por parametro
	 *
	 * @param clas Clasificacion contra la que se quiere comparar
	 * @return int 1 si la actual es mayor que el parametro, -1 si la actual es menor que el parametro, 0 si la actual es igual al parametro
	 */
	public int compararPorNombre(String clas){
		
		int retorno = nombre.compareTo(clas);
		
		if(retorno<0){
			retorno = 1;
		}else if(retorno < 0){
			retorno = -1;
		}
		
		return retorno;
		
	}

	/**
	 * Metodo que retorna el nombre de la clasificacion
	 * @return el nombre de la clasificacion
	 */
	public String darNombre(){
		return this.nombre;
		
		
	}
	/**
	 * Metodo que retorna el nombre de la clasificacion
	 * @return el nombre de la clasificacion
	 */
	public String darDescrpcion(){
		return this.descripcion;
		
	}
	
	@Override
	public String toString() {
		return nombre;
	}
	
	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	
	private boolean hayTareasRepetidas(){
		
		boolean hayRepetidas = false;
		for (int i = 0; i < tareas.size() && !hayRepetidas ; i++) 
		{
			for (int j = 0; j < tareas.size() && !hayRepetidas ; j++) {
				
				if(tareas.get(i).darNombre().equals(tareas.get(j))){
					hayRepetidas = true;
				}
			}
			
		}
		return hayRepetidas;
	}
	
	
	
	/**
	 * Metodo que verifica que el invariante de la clase se cumpla
	 * 
	 * nombre!=null && !nombre.equalsIgnoreCase("")
	 * descripcion!=null 
	 * tareas!=null
	 * 
	 * En el arraylist tareas no puede haber 2 tareas con el mismo nombre
	 * La descricion es opcional, descripcion.equals("")
	 */
	public void verificarInvariante(){
		assert nombre!=null && !nombre.equalsIgnoreCase(""): "nombre no valido";
		assert descripcion!=null: "Descripcion no valida";
		assert tareas!=null: "No se ha inicializado tareas";
		assert hayTareasRepetidas()==false: "Hay tareas repetidas con el mismo nombre";
		
	}

	
}
