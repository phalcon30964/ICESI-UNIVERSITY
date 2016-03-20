package mundo;

/**
 * Entidad que modela un conductor de taxi
 * @author Juan Manuel Reyes G., Universidad Icesi, Cali-Colombia
 */
public class Conductor {
	/**
	 * El nombre del conductor
	 */
	private String nombre;
	
	/**
	 * El turno que tiene asignado el conductor en el día 
	 */
	private String turno;
	
	/**
	 * El dinero que lleva ahorrado el conductor
	 */
	private double ahorro;
	
	/**
	 * La cuota obligatoria que todo conductor entrega
	 * al dueño del taxi por cada día trabajado
	 */
	public final static double AHORRO_DIARIO = 5000;
	
	/**
	 * Indica un turno corto de trabajo
	 */
	public final static String TURNO_CORTO = "CORTO";
	
	/**
	 * Indica un turno medio de trabajo
	 */
	public final static String TURNO_MEDIO = "MEDIO";
	
	/**
	 * Indica un turno largo de trabajo
	 */
	public final static String TURNO_LARGO = "LARGO";
	
	/**
	 * Cantidad de dinero que un conductor de turno corto
	 * entrega en un (1) día trabajado al dueño del taxi
	 */
	public final static double ENTREGA_TURNO_CORTO = 40000;
	
	/**
	 * Cantidad de dinero que un conductor de turno medio
	 * entrega en un (1) día trabajado al dueño del taxi
	 */
	public final static double ENTREGA_TURNO_MEDIO = 55000;
	
	/**
	 * Cantidad de dinero que un conductor de turno largo
	 * entrega en un (1) día trabajado al dueño del taxi
	 */
	public final static double ENTREGA_TURNO_LARGO = 75000;
	
	/**
	 * Dinero que el dueño del taxi invierte por gastos de
	 * mantenimiento en un taxi con turno corto en una (1) semana 
	 */
	
	public final static double GASTO_FIJO_TURNO_CORTO = 100000;
	//TODO la constante del gasto fijo a la semana por turno corto
	
	/**
	 * Crea un nuevo conductor con ahorro cero (0)
	 * @param n es el nombre del conductor
	 * @param t es el turno asignado
	 */
	public Conductor(String n, String t){
		nombre = n;
		turno  = t;
		ahorro = 0;
	}
	
	/**
	 * Consulta el nombre del conductor
	 * @return String es el nombre del conductor actual
	 */
	public String darNombre(){
		return nombre;
	}
	
	/**
	 * Consulta el turno del conductor
	 * @return String es el turno asignado al conductor actual
	 */
	public String darTurno(){
		return turno;
	}
	
	/**
	 * Consulta el ahorro del conductor
	 * @return double es la cantidad de dinero ahorrado por el conductor hasta el momento
	 */
	public double darAhorro(){
		return ahorro;
	}
	
	/**
	 * Modifica el valor de los ahorros del conductor
	 * @param nAhorro es el nuevo valor de los ahorros del conductor
	 */
	public void cambiarAhorro(double nAhorro){
		ahorro = nAhorro;
	}
	
	/**
	 * Permite aumentar la cantidad de dinero ahorrada en la cantidad ingresada por parámetro
	 * @param masAhorro es la cantidad de dinero en que aumentará el ahorro
	 */
	public void ahorrar(double masAhorro){
		ahorro += masAhorro;
	}
	
	/**
	 * Permite disminuir el ahorro del conductor en la cantidad ingresada por parámetro
	 * @param retiro es la cantidad de dinero a retirar
	 */
	public void retirar(double retiro){
		ahorro -= retiro;
	}
	
	/**
	 * Calcula el valor del dinero entregado en un día trabajado por el conductor.<br>
	 * Este calculo depende del turno que tiene asignado el conductor actual.
	 * @return double que es la entrega en un (1) día trabajado del conductor al dueño del taxi 
	 */
	public double calcularEntregaDiaria(){
		if(turno.equals(TURNO_CORTO)){
			return ENTREGA_TURNO_CORTO;
		}else if(turno.equals(TURNO_MEDIO)){
			return ENTREGA_TURNO_MEDIO;
		}else if(turno.equals(TURNO_LARGO)){
			return ENTREGA_TURNO_LARGO;
		}else{
			return 0;
		}
	}
	
	/**
	 * Calcula cuanto se debe invertir en el taxi semanalmente por gastos de mantenimiento por el conductor actual.<br>
	 * Se debe tener en cuenta que la inversión en mantenimiento depende del turno asignado (pues entre mas largo el turno
	 * hay mas desgaste del vehículo).<br>
	 * De tal manera que si el turno es corto, entonces se invierte $100000 (ver constante), si el turno es medio se invierte
	 * el doble de esa cantidad y si es largo se invierte el triple de la cantidad inicial.
	 * @return double es la cantidad de dinero a invertir en mantenimiento a la semana
	 */
	//TODO el método calcularGastoSemanal
}
