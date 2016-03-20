package mundo;

/**
 * Entidad que modela el comportamiento semanal de una pequeña empresa de taxis
 * @author Juan Manuel Reyes G., Universidad Icesi, Cali-Colombia
 */
public class EmpresaTaxis {
	
	/**
	 * El número de la semana actual desde el inicio del programa.<br>
	 * La semana actual es cero (0) cuando el programa inicia. 
	 */
	private int semanaActual;
	
	/**
	 * El primer taxi de la empresa
	 */
	private Taxi taxiA;
	
	/**
	 * El segundo taxi de la empresa
	 */
	private Taxi taxiB;
	
	/**
	 * Construye una nueva empresa de taxis.
	 * Con base en el diagrama de objetos que usted elaboró en el punto 1,
	 * inicialice los atributos y las relaciones de manera que el programa
	 * se cargue inicialmente con esa información.
	 */
	public EmpresaTaxis(){
		semanaActual = 0;
		taxiA = new Taxi ("GPR-396", 2012);
		taxiB = new Taxi ("LSQ-713",2010);
		
		taxiA.agregarConductor("Skipper");
		
		taxiB.agregarConductor("Pinky");
		taxiB.agregarConductor("Cerebro");
		
		
		//TODO crear el escenario indicado en el enunciado
	}
	
	/**
	 * Consulta el primer taxi de la empresa
	 * @return Taxi es el primer taxi
	 */
	public Taxi darTaxiA(){
		return taxiA;
	}
	
	/**
	 * Consulta el segundo taxi de la empresa
	 * @return Taxi es el segundo taxi
	 */
	public Taxi darTaxiB(){
		return taxiB;
	}
	
	/**
	 * Calcula la suma de los ahorros de todos los conductores de la empresa 
	 * @return double la cantidad de dinero ahorro en total por todos los conductores
	 */
	
	public double calcularAhorrosTotales(){
		double ahorrosTotales = 0;
		
		ahorrosTotales = taxiA.calcularAhorroConductores() + taxiB.calcularAhorroConductores();
		
		return ahorrosTotales;
		
		//TODO el método calcularAhorrosTotales
	}
	
	/**
	 * Permite avanzar una semana en el programa. Toda la información debe ser actualizada para reflejar 
	 * el cambio a la nueva semana.<br>
	 * Recibe como parámetro los posibles retiros de los conductores sobre sus respectivos ahorros.
	 * @param retiroAUno es la cantidad retirada en esa semana por el primer conductor del primer taxi 
	 * @param retiroBUno es la cantidad retirada en esa semana por el primer conductor del segundo taxi
	 * @param retiroBDos es la cantidad retirada en esa semana por el segundo conductor del segundo taxi
	 */
	
	public void avanzarSemana(double retiroAUno, double retiroBUno, double retiroBDos){
	 semanaActual+= 1;
		taxiA.avanzarSemana();
	    taxiB.avanzarSemana();
	
	
	 taxiA.darConductorUno().ahorrar(Conductor.AHORRO_DIARIO);
	 taxiB.darConductorUno().ahorrar(Conductor.AHORRO_DIARIO);
	 taxiB.darConductorDos().ahorrar(Conductor.AHORRO_DIARIO);
	
	
	 if(taxiA.darConductorUno()!=null){
		 taxiA.darConductorUno().retirar(retiroAUno);
	 }
	 
	
	 if(taxiB.darConductorUno()!=null){
		 taxiB.darConductorUno().retirar(retiroBUno);
	 }
	 
	 if(taxiB.darConductorDos()!=null){
		 taxiB.darConductorDos().retirar(retiroBDos);
	 }
	 
	}
	
	//TODO el método avanzarSemana
	
	/**
	 * Consulta la semana actual
	 * @return int es la semana actual
	 */
	public int darSemanaActual(){
		return semanaActual;
	}
}
