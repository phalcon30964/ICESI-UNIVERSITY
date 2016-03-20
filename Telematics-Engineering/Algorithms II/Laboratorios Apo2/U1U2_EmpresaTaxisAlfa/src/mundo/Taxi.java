package mundo;

/**
 * Entidad que modela un taxi
 * @author Juan Manuel Reyes G., Universidad Icesi, Cali-Colombia
 */
public class Taxi {
	
	/**
	 * La placa del vehículo
	 */
	
	private String placa;
	//TODO el atributo que guarda la placa
	
	/**
	 * El año en que el vehículo empezó a funcionar
	 */
	private int modelo;
	//TODO el atributo del año de fabricación del carro
	
	/**
	 * El primer conductor que maneja el taxi
	 */
	private Conductor conductorUno;
	//TODO la relación del primer conductor del taxi
	
	/**
	 * El segundo conductor que maneja el taxi
	 */
	private Conductor conductorDos;
	//TODO la relación del segundo conductor del taxi
	
	/**
	 * Construye un nuevo taxi
	 * @param p es la placa del taxi
	 * @param m es el modelo del taxi
	 */
	public Taxi(String p, int m){
		placa         = p;
		modelo        = m;
		
		conductorUno = null;
		conductorDos = null;
	}
	
	/**
	 * Consulta la placa del taxi
	 * @return String es la placa del taxi
	 */	
	public String darPlaca(){
		return placa;
	}
	
	/**
	 * Consulta el año de primra compra del taxi
	 * @return int es el modelo del taxi
	 */	
	public int darModelo(){
		return modelo;
	}
	
	/**
	 * Permite crear y agregar un nuevo conductor al taxi actual.<br>
	 * Si hay lugar disponible para el nuevo conductor, lo crea y agrega en el primer lugar disponible.<br/>
	 * Si no hay disponibilidad, entonces no lo agrega al taxi.
	 * @param nom es el nombre del nuevo conductor
	 * @return true si el conductor se pudo agregar, false en caso contrario.
	 */
	public boolean agregarConductor(String nom){
		boolean agrego = false;
		
		if(conductorUno==null){
			conductorUno = new Conductor(nom);
			agrego = true;
		}else if(conductorDos==null){
			conductorDos = new Conductor(nom);
			agrego = true;			
		}
		
		return agrego;
	}
	
	/**
	 * Hace el avance de la semana llevando a que sus conductores invocando 
	 * el método ahorrar para que los conductores ahorren.
	 */
	public void avanzarSemana(){
		ahorrar();
	}
	
	/**
	 * Hace que todos los conductores del taxi realicen su ahorro semanal
	 */
	
	private void ahorrar(){
	
		if(conductorUno!=null){
			conductorUno.ahorrar(Conductor.AHORRO_DIARIO*6);
		}
		
		if(conductorDos!=null){
			conductorDos.ahorrar(Conductor.AHORRO_DIARIO*6);
		}
			
	}
	//TODO el método ahorrar
		
	/**
	 * Calcula el ahorro total que hasta ahora tienen todos
	 * los conductores del taxi
	 * @return double es la cantidad de dinero ahorrado por todos los conductores
	 */
	
	public double calcularAhorroConductores(){
		double ahorroConductores = 0;
		
		if(conductorUno!=null){
			ahorroConductores+= conductorUno.darAhorro();
		}
		
		if(conductorDos!=null){
			ahorroConductores+= conductorDos.darAhorro();
		}
		
		return ahorroConductores;
	}
	//TODO el método calcularAhorroConductores
	
	/**
	 * Consulta el primer conductor del taxi
	 * @return Conductor es el primer conductor del taxi
	 */
	public Conductor darConductorUno(){
		return conductorUno;
	}
	
	/**
	 * Consulta el segundo conductor del taxi
	 * @return Conductor es el segundo conductor del taxi
	 */
	public Conductor darConductorDos(){
		return conductorDos;
	}
}
