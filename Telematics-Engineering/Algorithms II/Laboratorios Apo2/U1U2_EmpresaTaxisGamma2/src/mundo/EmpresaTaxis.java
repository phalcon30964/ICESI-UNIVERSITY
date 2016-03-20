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
	 * Calcula los ingresos totales que la empresa tiene acumulado
	 * hasta el momento por concepto de entregas de todos los conductores
	 * a sus taxis
	 * @return double la cantidad de dinero en ingresos
	 */
	public double calcularIngresosTotales(){
		double suma;
		
		suma = taxiA.darIngresos() + taxiB.darIngresos();

		return suma;
	}
	
	/**
	 * Calcula los gastos totales en mantenimiento que la empresa ha realizado
	 * hasta el momento debido al deterioro realizado por los conductores
	 * de acuerdo con sus turnos
	 * @return double la cantidad de dinero en gastos
	 */
	//TODO el método calcularGastosTotales
	
	/**
	 * Calcula el balance general de la empresa teniendo en cuenta ingresos y 
	 * gastos totales. No tiene en cuenta ahorros, pues ese dinero es de los
	 * conductores.
	 * @return double la cantidad de dinero que tiene realmente la empresa
	 */
	//TODO el método calcularBalanceTotal
	
	/**
	 * Calcula la suma de los ahorros de todos los conductores de la empresa 
	 * @return double la cantidad de dinero ahorro en total por todos los conductores
	 */
	public double calcularAhorrosTotales(){
		double ahorro;
		
		ahorro = taxiA.calcularAhorroConductores() + taxiB.calcularAhorroConductores();

		return ahorro;
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
		semanaActual++;
		taxiA.avanzarSemana();
		taxiB.avanzarSemana();
		
		taxiA.darConductorUno().retirar(retiroAUno);
		taxiB.darConductorUno().retirar(retiroBUno);
		taxiB.darConductorDos().retirar(retiroBDos);
	}
	
	/**
	 * Consulta la semana actual
	 * @return int es la semana actual
	 */
	public int darSemanaActual(){
		return semanaActual;
	}
}
