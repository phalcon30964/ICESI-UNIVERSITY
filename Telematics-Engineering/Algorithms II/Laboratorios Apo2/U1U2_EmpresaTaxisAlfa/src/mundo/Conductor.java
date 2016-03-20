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
	//TODO el atributo que guarda el nombre del conductor
	
	/**
	 * El dinero que lleva ahorrado el conductor
	 */
	private double ahorro;
	//TODO el atributo que almacena el ahorro total del conductor
	
	/**
	 * La cuota obligatoria que todo conductor entrega
	 * al dueño del taxi por cada día trabajado
	 */
	
	public final static double AHORRO_DIARIO = 5000;
	//TODO la constante de la cuota obligatoria diaria de ahorro
	
	/**
	 * Crea un nuevo conductor con ahorro cero (0)
	 * @param n es el nombre del conductor
	 */
	public Conductor(String n){
		nombre = n;
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
}
