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

import junit.framework.*;
import uniandes.cupi2.taquilla.mundo.*;

/**
 * Pruebas para la clase Partido
 */
public class PartidoTest extends TestCase {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * La instancia de la clase a probar
	 */
	private Partido partido;

	/**
	 * El nombre del rival en el partido
	 */
	private String nombreRivalPartido;

	/**
	 * La nombre del torneo del partido
	 */
	private String torneoPartido;

	/**
	 * La fecha del partido
	 */
	private String fechaPartido;

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	/**
	 * Configuración del escenario
	 */
	public void setupEscenario1() {
		nombreRivalPartido = "CupiRival FC";
		torneoPartido = Partido.TORNEO_LIGA;
		fechaPartido = "23/10/2013";
		partido = new Partido(nombreRivalPartido, torneoPartido, fechaPartido);
	}

	/**
	 * Prueba el constructor y los getters de la clase Partido
	 */
	public void testPartido() {
		setupEscenario1();

		// Revisa que los parámetros hayan hecho las asignaciones correctas
		assertEquals("El nombre del rival debería ser el mismo", partido.darRival(), nombreRivalPartido);
		assertEquals("El torneo del partido debería ser la mismo", partido.darTorneo(), torneoPartido);
		assertEquals("La fecha del partido debería ser la mismo", partido.darFechaPartido(), fechaPartido);

		// Revisa que haya inicializado el total de ventas en cero
		assertEquals("El total de ventas debió iniciar en 0", partido.darTotalIngresos(), 0, 0.0001);

		// Revisa que los arreglos hayan sido creados
		assertNotNull("Las sillas de la localidad Norte han sido inicializados", partido.darLocalidadNorte());
		assertEquals("La cantidad de sillas de la localidad Norte debió haber sido creada con el valor de la constante", partido.darLocalidadNorte().length, Partido.SILLAS_LOCALIDAD_NORTE);

		assertNotNull("Las sillas de la localidad Sur han sido inicializados", partido.darLocalidadSur());
		assertEquals("La cantidad de sillas de la localidad Sur debió haber sido creada con el valor de la constante", partido.darLocalidadSur().length, Partido.SILLAS_LOCALIDAD_SUR);

		assertNotNull("Las sillas de la localidad Occidental han sido inicializados", partido.darLocalidadOccidental());
		assertEquals("La cantidad de sillas de la localidad Occidental debió haber sido creada con el valor de la constante", partido.darLocalidadOccidental().length, Partido.SILLAS_LOCALIDAD_OCCIDENTAL);

		assertNotNull("Las sillas de la localidad Oriental han sido inicializados", partido.darLocalidadOriental());
		assertEquals("La cantidad de sillas de la localidad Oriental debió haber sido creada con el valor de la constante", partido.darLocalidadOriental().length, Partido.SILLAS_LOCALIDAD_ORIENTAL);
	
		for(int i = 0; i < partido.darLocalidadNorte().length; i++)
		{
			assertNotNull("No se inicializó correctamtne la silla", partido.darLocalidadNorte()[i]);
			assertEquals("No se inicializó correctamtne el número de la silla", i, partido.darLocalidadNorte()[i].darNumero());
			assertEquals("No se inicializó correctamtne el número de la silla", Taquilla.LOCALIDAD_NORTE, partido.darLocalidadNorte()[i].darLocalidad());
		}
		
		for(int i = 0; i < partido.darLocalidadSur().length; i++)
		{
			assertNotNull("No se inicializó correctamtne la silla", partido.darLocalidadSur()[i]);
			assertEquals("No se inicializó correctamtne el número de la silla", i, partido.darLocalidadSur()[i].darNumero());
			assertEquals("No se inicializó correctamtne el número de la silla", Taquilla.LOCALIDAD_SUR, partido.darLocalidadSur()[i].darLocalidad());
		}
		
		for(int i = 0; i < partido.darLocalidadOccidental().length; i++)
		{
			assertNotNull("No se inicializó correctamtne la silla", partido.darLocalidadOccidental()[i]);
			assertEquals("No se inicializó correctamtne el número de la silla", i, partido.darLocalidadOccidental()[i].darNumero());
			assertEquals("No se inicializó correctamtne el número de la silla", Taquilla.LOCALIDAD_OCCIDENTAL, partido.darLocalidadOccidental()[i].darLocalidad());
		}
		
		for(int i = 0; i < partido.darLocalidadOriental().length; i++)
		{
			assertNotNull("No se inicializó correctamtne la silla", partido.darLocalidadOriental()[i]);
			assertEquals("No se inicializó correctamtne el número de la silla", i, partido.darLocalidadOriental()[i].darNumero());
			assertEquals("No se inicializó correctamtne el número de la silla", Taquilla.LOCALIDAD_ORIENTAL, partido.darLocalidadOriental()[i].darLocalidad());
		}
	
	}

	/**
	 * Prueba el método darSillasPorLocalidad
	 * Métodos a probar: darSillasPorLocalidad
	 */
	public void testDarSillasPorLocalidad() {
		setupEscenario1();


		assertNotNull("La respuesta no debe ser vacía", partido.darSillasPorLocalidad(Taquilla.LOCALIDAD_NORTE));
		assertEquals("No retorna la localidad correcta", partido.darLocalidadNorte(), partido.darSillasPorLocalidad(Taquilla.LOCALIDAD_NORTE));
		
		assertNotNull("La respuesta no debe ser vacía", partido.darSillasPorLocalidad(Taquilla.LOCALIDAD_SUR));
		assertEquals("No retorna la localidad correcta", partido.darLocalidadSur(), partido.darSillasPorLocalidad(Taquilla.LOCALIDAD_SUR));
		
		assertNotNull("La respuesta no debe ser vacía", partido.darSillasPorLocalidad(Taquilla.LOCALIDAD_OCCIDENTAL));
		assertEquals("No retorna la localidad correcta", partido.darLocalidadOccidental(), partido.darSillasPorLocalidad(Taquilla.LOCALIDAD_OCCIDENTAL));
		
		assertNotNull("La respuesta no debe ser vacía", partido.darSillasPorLocalidad(Taquilla.LOCALIDAD_ORIENTAL));
		assertEquals("No retorna la localidad correcta", partido.darLocalidadOriental(), partido.darSillasPorLocalidad(Taquilla.LOCALIDAD_ORIENTAL));
	}

	/**
	 * Prueba del método venderSilla<br>
	 * Métodos a probar: venderSilla, darSillaLocalidad<br>
	 * Caso 1. Ha asignado una silla y aumenta las ganancias
	 */
	public void testVenderSilla1() {
		setupEscenario1();

		String localidad = darLocalidadAleatoria();
		try {
			Silla[] sillas = partido.darSillasPorLocalidad(localidad);
			int numeroSilla = (int) (Math.random() * sillas.length);
			
			Silla silla = partido.darSillaDeLocalidad(numeroSilla, localidad);
			
			String nombreComprador = "Juan Pérez";
			String cedula = "123456789";
			double descuento = Math.random();
			double precioUno = partido.darPrecio( silla );
			double precioSilla = precioUno * (1 - descuento);
			double ingresos = partido.darTotalIngresos();
			double precioPrueba = partido.venderSilla(numeroSilla, localidad, nombreComprador, cedula, descuento);

			assertTrue("La silla debió ser asignada", silla.estaAsignada());
			assertEquals("Los ingresos debieron aumentar según el costo de la boleta", partido.darTotalIngresos(), ingresos + precioSilla, 0.0001);
	        assertEquals( "El precio es incorrecto", precioSilla , precioPrueba, 0.0001 );

		} catch (Exception e) {
			fail("El método no debe lanzar Excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba del método venderSilla<br>
	 * Caso 1. Intenta vender una silla asignada
	 */
	public void testVenderSilla2() {
		setupEscenario1();

		String localidad = darLocalidadAleatoria();

		Silla[] sillas = partido.darSillasPorLocalidad(localidad);
		int numeroSilla = (int) (Math.random() * sillas.length);

		String nombreComprador = "Juan Pérez";
		String cedula = "123456789";
		double descuento = Math.random();

		// Asigna inicialmente
		try {
			partido.venderSilla(numeroSilla, localidad, nombreComprador, cedula, descuento);
		} catch (Exception e) {
			fail("El método no debe lanzar Excepción: " + e.getMessage());
		}

		// Intenta vender ya asignada
		try {
			partido.venderSilla(numeroSilla, localidad, nombreComprador, cedula, descuento);
			fail("El método debe lanzar Excepción al intentar vender una silla asignada");
		} catch (Exception e) {
			// No debe lanzar excepción
		}
	}
	
	/**
	 * Prueba del método darSillaDeLocalidad<br>
	 * Métodos a probar: darSillasPorLocalidad, darSillaDeLocalidad<br>
	 * Caso 1. El número de la silla sea válido<br>
	 */
	public void testDarSillaDeLocalidad1(){
		setupEscenario1();
		
		String localidad = darLocalidadAleatoria();
		Silla[] sillas = partido.darSillasPorLocalidad(localidad);
				
		try {
			int valida = (int) (Math.random()*sillas.length);
			Silla silla = partido.darSillaDeLocalidad(valida, localidad);
			assertNotNull("La silla debe ser válida", silla);
		} catch (Exception e) {
			fail("No debe lanzar excepción: " + e.getMessage());
		}
	}
	
	/**
	 * Prueba del método darSillaDeLocalidad<br>
	 * Métodos a probar: darSillasPorLocalidad, darSillaDeLocalidad<br>
	 * Caso 1. El número de la silla no esté en la localidad<br>
	 */
	public void testDarSillaDeLocalidad2(){
		setupEscenario1();
		
		String localidad = darLocalidadAleatoria();
		Silla[] sillas = partido.darSillasPorLocalidad(localidad);
		
		try {
			int invalida = sillas.length + (int) (Math.random()*sillas.length);
			partido.darSillaDeLocalidad(invalida, localidad);
			fail("La silla NO debe ser válida");
		} catch (Exception e) {
			//Debe lanzar excepción
		}
	}

	/**
	 * Prueba del método buscarSillaLibre<br>
	 * Métodos a probar: buscarSillaLibre, venderSilla<br>
	 * Caso 1. Hay sillas libres en la localidad Caso<br>
	 * 2. NO hay sillas libres en la localidad
	 */
	public void testBuscarSillaLibre() {
		setupEscenario1();

		String localidad = darLocalidadAleatoria();

		int vacia = -1;

		// Caso 1.
		try {
			vacia = llenarSillasLocalidad(localidad);

			Silla silla = partido.buscarSillaLibre(localidad);
			assertNotNull("La silla que se está buscando no debe ser nula", silla);
			assertFalse("La silla no debe estar asignada", silla.estaAsignada());
			assertEquals("La silla debe pertenecer a la misma localidad en la que se busca", silla.darLocalidad(), localidad);
			assertEquals("La silla debe tener el mismo número de la primera vacia en la que se busca", silla.darNumero(), vacia);
		} catch (Exception e) {
			fail("No debe lanzar excepción: " + e.getMessage());
		}

		// Caso 2.
		try {
			while (vacia > -1) {
				vacia = llenarSillasLocalidad(localidad);
			}

			Silla silla = partido.buscarSillaLibre(localidad);
			assertNull("No debe haber sillas libres", silla);
		} catch (Exception e) {
			// Debe lanzar excepción
		}
	}

	/**
	 * Prueba del método venderPrimeraSillaLibre<br>
	 * Métodos a probar: venderPrimeraSillaLibre, darSillasPorLocalidad,
	 * venderSilla<br>
	 * Caso 1. Agrega a la primera silla libre un comprador
	 */
	public void testVenderPrimeraSillaLibre1() {
		setupEscenario1();

		String localidad = darLocalidadAleatoria();

		try {
			int vacia = llenarSillasLocalidad(localidad);

			Silla silla = partido.darSillaDeLocalidad(vacia, localidad);

			double descuento = Math.random();
			double precioSilla = partido.darPrecio( silla ) * (1 - descuento);
			double ingresos = partido.darTotalIngresos();

			assertFalse("La silla no debe estar asignada", silla.estaAsignada());

			double precioPrueba = partido.venderPrimeraSillaLibre(localidad, "Juan Pérez", "123456789", descuento);
			assertTrue("La silla debe estar asignada", silla.estaAsignada());
			assertEquals("Los ingresos debieron aumentar según el costo de la boleta", partido.darTotalIngresos(), ingresos + precioSilla, 0.0001);
			assertEquals( "El precio es incorrecto", precioSilla , precioPrueba, 0.0001 );

		} catch (Exception e) {
			fail("No debe lanzar excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba del método venderPrimeraSillaLibre<br>
	 * Métodos a probar: venderPrimeraSillaLibre, darSillasPorLocalidad, darSillaDeLocalidad,
	 * venderSilla<br>
	 * Caso 1. No encuentra una silla disponibles
	 */
	public void testVenderPrimeraSillaLibre2() {
		setupEscenario1();

		String localidad = darLocalidadAleatoria();
		try {
			int vacia = llenarSillasLocalidad(localidad);
			while (vacia > -1) {
				vacia = llenarSillasLocalidad(localidad);
			}
			Silla silla = partido.darSillaDeLocalidad(0, localidad);

			double descuento = Math.random();

			assertTrue("La silla no debe estar asignada", silla.estaAsignada());

			double precioPrueba = partido.venderPrimeraSillaLibre(localidad, "Juan Pérez", "123456789", descuento);
	        assertEquals( "El precio debe ser 0", 0 , precioPrueba, 0.0001 );
			fail("Debe lanzar excepción al no encontrar una silla libre");
		} catch (Exception e) {
			// No debe lanzar excepción
		}
	}

	/**
	 * Prueba del método darPorcentajeAsistencia<br>
	 * Métodos a probar: darPorcentajeAsistencia, venderSilla<br>
	 * Caso 1. No encuentra una silla disponibles
	 */
	public void testDarPorcentajeAsistencia() {
		setupEscenario1();

		// Caso 1.
		try {
			int cantidadNorte = (int) (Math.random() * Partido.SILLAS_LOCALIDAD_NORTE);
			int cantidadSur = (int) (Math.random() * Partido.SILLAS_LOCALIDAD_SUR);
			int cantidadOccidental = (int) (Math.random() * Partido.SILLAS_LOCALIDAD_OCCIDENTAL);
			int cantidadOriental = (int) (Math.random() * Partido.SILLAS_LOCALIDAD_ORIENTAL);

			double ocupacion = cantidadNorte + cantidadSur + cantidadOccidental + cantidadOriental;
			double total = Partido.SILLAS_LOCALIDAD_NORTE + Partido.SILLAS_LOCALIDAD_SUR + Partido.SILLAS_LOCALIDAD_OCCIDENTAL + Partido.SILLAS_LOCALIDAD_ORIENTAL;

			llenarLocalidadIncremental( Taquilla.LOCALIDAD_NORTE, cantidadNorte);
			llenarLocalidadIncremental( Taquilla.LOCALIDAD_SUR, cantidadSur);
			llenarLocalidadIncremental( Taquilla.LOCALIDAD_OCCIDENTAL, cantidadOccidental);
			llenarLocalidadIncremental( Taquilla.LOCALIDAD_ORIENTAL, cantidadOriental);

			assertEquals("El porcentaje de asistencia debe ser el mismo", ocupacion/total * 100, partido.darPorcentajeDeAsistencia(), 0.0001);

		} catch (Exception e) {
			fail("No debe lanzar excepción: " + e.getMessage());
		}
	}

	/**
	 * Devuelve una localidad aleatoria
	 * @return El nombre de la localidad
	 */
	private String darLocalidadAleatoria() {
		int numLocalidad = (int) (Math.random() * 4);
		String localidad = null;
		switch (numLocalidad) {
		case 0:
			localidad = Taquilla.LOCALIDAD_NORTE;
			break;
		case 1:
			localidad = Taquilla.LOCALIDAD_SUR;
			break;
		case 2:
			localidad = Taquilla.LOCALIDAD_OCCIDENTAL;
			break;
		case 3:
			localidad = Taquilla.LOCALIDAD_ORIENTAL;
			break;

		default:
			localidad = Taquilla.LOCALIDAD_NORTE;
			break;
		}
		return localidad;
	}

	/**
	 * Llena las sillas de una localidad y devuelve la primera casilla
	 * desocupada
	 * @param localidad
	 *            El nombre de la localidad a asignar. localidad != null
	 * @return La posición de la primera silla no asignada, -1 en caso de no
	 *         tener
	 * @throws Exception
	 *             En caso de asignar un comprador a una silla ocupada
	 */
	private int llenarSillasLocalidad(String localidad) throws Exception {
		int primero = -1;
		double descuento = Math.random();

		Silla[] sillas = partido.darSillasPorLocalidad(localidad);

		for (int i = 0; i < sillas.length; i++) {
			if (!sillas[i].estaAsignada()) {
				int llenar = (int) (Math.random() * 2);
				if (llenar % 2 == 0) {
					if (primero < 0) {
						primero = i;
					}
				} else {
					// Revisa si al final ha llegado
					if (primero == -1 && i == sillas.length - 1) {
						primero = i;
					} else {
						partido.venderSilla(i, localidad, "comprador" + i, "cedula" + i, descuento);
					}
				}
			}
		}
		return primero;
	}

	/**
	 * Llena la localidad incrementalmente hasta la cantidad dada por parámetro
	 * @param localidad
	 *            La localidad a llenar. localidad != null
	 * @param cantidad
	 *            La cantidad de personas a llenar. cantidad > 0
	 * @throws Exception
	 *             En caso de asignar un comprador a una silla ya asignada
	 */
	private void llenarLocalidadIncremental(String localidad, int cantidad) throws Exception {
		Silla[] sillas = partido.darSillasPorLocalidad(localidad);
		double descuento = Math.random();

		for (int i = 0; i < sillas.length && cantidad > 0; i++) {
			if (!sillas[i].estaAsignada()) {
				partido.venderSilla(i, localidad, "comprador" + i, "cedula" + i, descuento);
			}
			cantidad--;
		}
	}
}