package Mundo;

import java.sql.Date;
import java.util.Calendar;

/**
 * La clase Tarea maneja la informacion de un pendiente 
 * 
 * inv:
 * nombre!=null
 * !nombre.equals("")
 * descripcion!=null
 * fechaCreacion!=null
 * fechaRecordatorio!=null
 * La fecha de recordatorio no puede ser anterior a la actual y no puede ser letras.
 */
public class Tarea {
	
	//-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
	
	/**
     *nombre de la tarea
     */
	private String nombre;
	
	/**
     *descripcion de la tarea
     */
	private String descripcion;
	
	/**
     *fecha del recordatorio (opcional)
     */
	private Date fechaRecordatorio;
	
	/**
     *fecha de creacion de la tarea
     */
	private Date fechaCreacion;
	
	/**
     *realizada: indica si la tarea ha sido realizada
     */
	private boolean realizada;
	
	/**
     *Clasificacion: indica la clasificacion de una tarea
     */
	private String Clasificacion;
	
	
	//-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------
	
	/**
     * Constructor de tarea. <br>
     * Metodo que inicializa todos los atributos de la tarea y dejando fecha de creacion por el sistema y realizada por defecto false.
     * 
     * <b>post: </b> todos los atributos han sido inicializados.
     * 
     * @param: elNombre String con el nombre
     * @param: laDescripcion String con la descripcion de la tarea
     * @param: laFechaRecordatorio Date con la fecha de recordatorio, No puede ser inferior a la actual
     * @param: laClasificacion String etiqueta que informa en cual clasificacion se encuentra la tarea
     * 
     */
	public Tarea(String elNombre, String laDescripcion, Date laFechaRecordatorio, String laClasificacion)throws AssertionError{
		
		this.nombre = elNombre;
		
		this.descripcion = laDescripcion;
		
		//las tareas no pueden tener una fecha anterior a la actual
		this.fechaRecordatorio = laFechaRecordatorio;
		
		this.Clasificacion = laClasificacion;
		
		//Atributos rellenados por defecto:
		
		//Realizada comienda false 
		this.realizada = false;
		
		//La fechad de creacion se asigna automaticamente
		Calendar fecha = Calendar.getInstance();
		int anho = fecha.get(Calendar.YEAR);
		int mes = fecha.get(Calendar.MONTH)+1;
		int dia = fecha.get(Calendar.DATE);
		@SuppressWarnings("deprecation")
		Date fechaActualSistema = new Date(anho, mes, dia);
		
		this.fechaCreacion = fechaActualSistema;
		
		verificarInvariante();
	}
	
	//-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
	
	/**
	 * Metodo que devuelve el nombre
	 * @return String el nombre de la tarea
	 */
	public String darNombre() {
		return nombre;
	}

	/**
	 * Metodo que devuelve la descripcion
	 * @return String la descripcion de la tarea
	 */
	public String darDescripcion() {
		return descripcion;
	}

	/**
	 * Metodo que devuelve la fecha de recordatorio
	 * @return Date la fecha de recordatorio
	 */
	public Date darFechaRecordatorio() {
		return fechaRecordatorio;
	}

	/**
	 * Metodo que devuelve la fecha en que fue creada la tarea
	 * @return Date la fecha de creacion
	 */
	public Date darFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Metodo que devuelve la descripcion
	 * @return String la descripcion de la tarea
	 */
	public String darClasificacion() {
		return Clasificacion;
	}
	
	/**
	 * Metodo que devuelve si la tarea esta realizada = true y si no lo esta = false
	 * @return boolean si esta realizada 
	 */
	public boolean estaRealizada() {
		return realizada;
	}
	
   /**
	* Metodo que realiza una tarea
	*<br/><b>pos: </b> el atrubuto fue cambiado de valor al opuesto del que tenia
	*/
	public void realizar(){
		
		if(realizada==false){
		realizada = true;
		}else{
		realizada = false;
		}
		
		verificarInvariante();
	}

	/**
	 * Metodo que devuelve una cadena con nombre para el JList
	 * @return String el nombre de la tarea para mostrar en JList del recordador
	 */
	public String toString() {
		
		String msj = "No realizada";
		
		if(estaRealizada()){
			msj = "Realizada";
		}
		
		return nombre+" - "+Clasificacion+" - "+msj;
	}
	
	/**
	 * Metodo que devuelve una cadena con toda la informacion de la tarea para generar reporte
	 * @return String con toda la informacion de la tarea
	 */
	public String darReporte() {
		return "Tarea [nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fechaRecordatorio=" + fechaRecordatorio
				+ ", fechaCreacion=" + fechaCreacion + ", Clasificacion="
				+ Clasificacion + "]";
	}
	
	/**
	 * Metodo comprar la fecha de la tarea actual contra la pasada por el parametro 
	 * @param t Tarea la tarea a comparar por fecha
	 * @return int con 0 si la fecha de la tarea actual es igual a la parametro, -1 si la fecha antual es anterior a la parametro, 1 si la fecha actual es posterior a la parametro
	 */
	public int compararPorFechaCreacion(Tarea t){
		
		int retorno = 0;
		int comparacion = this.fechaCreacion.compareTo(t.darFechaCreacion());
		if( comparacion>0){
			retorno = 1;
		}else if( comparacion<0){
			retorno = -1;
		}
	  
		return retorno;
	}
	
	/**
	 * Metodo comprar la fecha de recordatorio de la tarea actual contra la pasada por el parametro 
	 * 
	 * @param t Tarea la tarea a comparar por fecha
	 * @return int con 0 si la fecha de la tarea actual es igual a la parametro, -1 si la fecha antual es
	 * anterior a la parametro, 1 si la fecha actual es posterior a la parametro, -2 si la fecha de la tarea no existe, 
	 * -3 si la fecha de la tarea parametro no existe
	 * 
	 */
	public int compararPorFechaRecordatorio(Tarea t){
		
		int retorno = 0;
		
		if(t.darFechaRecordatorio()!=null){
			
			int comparacion = this.fechaRecordatorio.compareTo(t.darFechaRecordatorio());
		
			if(comparacion>0){
				
			retorno = 1;
			
			}else if( comparacion<0){
				
			retorno = -1;
			
			}
		}else if(fechaRecordatorio==null){
			retorno = -2;
		}else if(t.darFechaRecordatorio()==null){
			retorno = -3;
		}
		return retorno;
	}
	
	
	
	//-----------------------------------------------------------------
    // Invariante
    //-----------------------------------------------------------------
	
	/**
	 * Metodo que verifica el cumplimiento del invariante de la clase
	 */
	private void verificarInvariante()throws AssertionError{
		
		assert nombre!=null: "el nombre no fue inicializado";
		assert !nombre.equals(""):"el nombre no puede estar vacio";
		assert descripcion!=null: "la descripcion no fue inicializada";
		assert fechaCreacion!=null :" la fecha de creacion no se inicializo";
		assert fechaRecordatorio!=null: " la fecha de recordatorio no se inicializo";
	}

	
}
