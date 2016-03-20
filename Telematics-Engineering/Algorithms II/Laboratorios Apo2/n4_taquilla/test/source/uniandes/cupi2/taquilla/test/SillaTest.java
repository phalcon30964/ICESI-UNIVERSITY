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
package uniandes.cupi2.taquilla.test;

import junit.framework.TestCase;
import uniandes.cupi2.taquilla.mundo.Persona;
import uniandes.cupi2.taquilla.mundo.Silla;
import uniandes.cupi2.taquilla.mundo.Taquilla;

/**
 * Pruebas para la clase Silla
 */
public class SillaTest extends TestCase {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * La instancia de la clase a probar
	 */
	private Silla silla;

	/**
	 * El nombre de la persona
	 */
	private int numeroSilla;

	/**
	 * La cédula de la persona
	 */
	private String localidadSilla;

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	/**
	 * Configuración del escenario
	 */
	public void setupEscenario1() {
		numeroSilla = (int) (Math.random() * 100);
		localidadSilla = Taquilla.LOCALIDAD_OCCIDENTAL;
		silla = new Silla(numeroSilla, localidadSilla);
	}

	/**
	 * Prueba el constructor y los getters de la clase Persona
	 */
	public void testSilla() {
		setupEscenario1();

		assertEquals("El número de la silla debería ser el mismo", silla.darNumero(), numeroSilla);
		assertEquals("La localidad de la silla debería ser la mismo", silla.darLocalidad(), Taquilla.LOCALIDAD_OCCIDENTAL);
		assertNull("El comprador de la silla no debe estar asignado", silla.darComprador());
	}

	/**
	 * Prueba del método estaAsignada Métodos a probar: estaAsignada,
	 * asignarSilla Caso 1: En caso de que la silla no esté asignada Caso 2: En
	 * caso de que la silla haya sido asignada
	 */
	public void testEstaAsignada() {
		setupEscenario1();

		// Caso 1.
		assertFalse("La silla no debería estar asignada", silla.estaAsignada());

		// Caso 2.
		try {
			silla.asignarSilla("Juan Pérez", "123456789");
			assertTrue("La silla ha sido asignada", silla.estaAsignada());
		} catch (Exception e) {
			fail("No debería lanzar excepción");
		}
	}

	/**
	 * Prueba del método asignarSilla<br>
	 * Métodos a probar: asignarSilla, estaAsignada<br>
	 * Caso 1: En caso de que la silla no esté asignada
	 */
	public void testAsignarSilla1() {
		setupEscenario1();

		// Caso 1.
		try {
			silla.asignarSilla("Juan Pérez", "123456789");
			assertTrue("La silla ha sido asignada", silla.estaAsignada());
		} catch (Exception e) {
			fail("No debería lanzar excepción");
		}
	}

	/**
	 * Prueba del método asignarSilla<br>
	 * Métodos a probar: asignarSilla, estaAsignada<br>
	 * Caso 1: En caso de que la silla esté asignada, y lance la excepción
	 * correctamente
	 */
	public void testAsignarSilla2() {
		setupEscenario1();

		// Caso 1.
		try {
			silla.asignarSilla("Juan Pérez", "123456789");
			assertTrue("La silla ha sido asignada", silla.estaAsignada());

			silla.asignarSilla("Juanita Pérez", "234567890");
			fail("La silla no debió ser asignada");
		} catch (Exception e) {
			// Se debería lanzar esta excepción
		}
	}

	/**
	 * Prueba del método darComprador<br>
	 * Métodos a probar: darComprador, asignarSilla<br>
	 */
	public void testDarComprador() {
		setupEscenario1();
		
		// Caso 1.
		try {
			
			assertNull("La silla no debe tener un comprador", silla.darComprador());

			String nombre = "Juan Pérez";
			String cedula = "123456789";
			silla.asignarSilla(nombre, cedula);
			
			Persona comprador = silla.darComprador();
			assertNotNull("La silla debe tener un comprador", comprador);
			assertEquals("El comprador debe tener el mismo nombre", nombre, comprador.darNombre());
			assertEquals("El comprador debe tener la misma cédula", cedula, comprador.darCedula());
			
		} catch (Exception e) {
			fail("No debería lanzar excepción");
		}
	}
}