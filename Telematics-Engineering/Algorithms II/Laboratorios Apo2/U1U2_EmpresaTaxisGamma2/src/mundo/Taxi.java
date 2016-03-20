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
	
	/**
	 * El año en que el vehículo empezó a funcionar
	 */
	private int modelo;
	
	/**
	 * La cantidad de ingresos totales que se han generado
	 * hasta el momento gracias a las entregas de los taxistas
	 */
	private double ingresos;
	
	/**
	 * La cantidad de gastos generados por cuenta del mantenimiento
	 * que se le debe hacer al vehículo
	 */
	
	private double gastos;
	//TODO el atributo de los gastos generados hasta el momento para este vehículo
	
	/**
	 * El primer conductor que maneja el taxi
	 */
	private Conductor conductorUno;
	
	/**
	 * El segundo conductor que maneja el taxi
	 */
	private Conductor conductorDos;
	
	/**
	 * Construye un nuevo taxi con cero ingresos y cero gastos
	 * @param p es la placa del taxi
	 * @param m es el modelo del taxi
	 */
	public Taxi(String p, int m){
		placa         = p;
		modelo        = m;
		
		gastos        = 0;
		ingresos      = 0;
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
	 * Consulta los ingresos generados por el taxi
	 * @return double es la cantidad de dinero generado por el taxi
	 */	
	public double darIngresos(){
		return ingresos;
	}
	
	/**
	 * Consulta los gastos en mantenimiento generados por el taxi
	 * @return double son los gastos por mantenimiento del taxi
	 */	
	public double darGastos(){
		return gastos;
	}
	
	/**
	 * Modifica el valor del atributo ingresos con base en el parámetro
	 * @param ing es el parámetro con el nuevo valor del atributo
	 */
	public void cambiarIngresos(double ing){
		ingresos = ing;
	}
	
	/**
	 * Modifica el valor del atributo gastos con base en el parámetro
	 * @param gas es el parámetro con el nuevo valor del atributo
	 */
	public void cambiarGastos(double gas){
		gastos = gas;
	}
	
	/**
	 * Permite crear y agregar un nuevo conductor al taxi actual.<br>
	 * Si hay lugar disponible para el nuevo conductor, lo crea y agrega en el primer lugar disponible.<br/>
	 * Si no hay disponibilidad, entonces no lo agrega al taxi.
	 * @param nom es el nombre del nuevo conductor
	 * @param tur es el turno del nuevo conductor
	 * @return true si el conductor se pudo agregar, false en caso contrario.
	 */
	public boolean agregarConductor(String nom, String tur){
		boolean agrego = false;
		
		if(conductorUno==null){
			conductorUno = new Conductor(nom,tur);
			agrego = true;
		}else if(conductorDos==null){
			conductorDos = new Conductor(nom,tur);
			agrego = true;			
		}
		
		return agrego;
	}
	
	/**
	 * Suma los ingresos y gastos semanales a los ingresos y gastos totales del taxi, así
	 * como también lleva a que sus conductores realicen el ahorro semanal.  
	 */
	public void avanzarSemana(){
		ingresos += calcularIngresosSemanales();
		gastos   += calcularGastosSemanales();
		ahorrar();
	}
	
	/**
	 * Calcula el ingreso semanal que el taxi genera con los conductores actuales.
	 * @return double el dinero de las entregas de una (1) semana de los conductores que tiene el taxi.
	 */
	private double calcularIngresosSemanales(){
		double ingresosSemanales = 0;
		if(conductorUno!=null){
			ingresosSemanales += conductorUno.calcularEntregaDiaria();
		}
		if(conductorDos!=null){
			ingresosSemanales += conductorDos.calcularEntregaDiaria();
		}
		ingresosSemanales = ingresosSemanales * 6;
		return ingresosSemanales;
	}
	
	/**
	 * Calcula el gasto semanal que el taxi genera con los conductores actuales.
	 * @return double el dinero del gasto en mantenimiento de una (1) semana debido a los conductores que tiene el taxi.
	 */
	//TODO el método calcularGastosSemanales
	
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
	
	/**
	 * Calcula el ahorro total que hasta ahora tienen todos
	 * los conductores del taxi
	 * @return double es la cantidad de dinero ahorrado por todos los conductores
	 */
	public double calcularAhorroConductores(){
		double ahorro = 0;
		if(conductorUno!=null){
			ahorro += conductorUno.darAhorro();
		}
		if(conductorDos!=null){
			ahorro += conductorDos.darAhorro();
		}
		return ahorro;
	}
	
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
