/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: taquilla
 * Autores: Kelvin Guerrero, Carlos Vega, Luis Ricardo Ruiz y Rafael Muñoz Lattion - 11-mar-2013
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.taquilla.mundo;

/**
 * Representa una persona
 */
public class Persona {

	//-------------------------------------------------------------
	// Atributos
	//-------------------------------------------------------------
			
	/**
	 * Nombre de la persona
	 */
	private String nombre;
	
	/**
	 * Cédula de la persona
	 */
	private String cedula;
	
	//-------------------------------------------------------------
	// Constructor
	//-------------------------------------------------------------
	/**
	 * Crea una persona con los valores que recibe por parámetro
	 * @param pNombre Nombre de la persona - pNombre != null && pNombre != ""
	 * @param pCedula Cédula de la persona - pCedula != null && pCedula != ""
	 */
	public Persona(String pNombre, String pCedula) {
		nombre = pNombre;
		cedula = pCedula;
	}
	//-------------------------------------------------------------
	// Métodos
	//-------------------------------------------------------------
		
	/**
	 * Método encargado de dar el nombre de una persona
	 * @return nombre de una persona
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/**
	 * Método encargado de dar la cédula de una persona
	 * @return cédula de una persona
	 */
	public String darCedula()
	{
		return cedula;
	}
}
