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

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.taquilla.mundo.Partido;
import uniandes.cupi2.taquilla.mundo.Persona;
import uniandes.cupi2.taquilla.mundo.Silla;
import uniandes.cupi2.taquilla.mundo.Taquilla;

/**
 * Pruebas para la clase Taquilla
 */
public class TaquillaTest extends TestCase {

	// -------------------------------------------------------------
	// Atributos
	// -------------------------------------------------------------

	/**
	 * La instancia de la clase a probar
	 */
	private Taquilla taquilla;

	/**
	 * El nombre del equipo dueño de la taquilla
	 */
	private String nombreEquipoTaquilla;

	// -------------------------------------------------------------
	// Métodos
	// -------------------------------------------------------------

	/**
	 * Configuración del escenario 1
	 */
	public void setupEscenario1() {
		nombreEquipoTaquilla = "Cupi2 FC";
		taquilla = new Taquilla(nombreEquipoTaquilla);
	}

	/**
	 * Configuración del escenario 2
	 */
	public void setupEscenario2() {
		setupEscenario1();

		try {
			// Agrega los socios
			taquilla.agregarSocio("Cupi2 Socio 1", "234366556");
			taquilla.agregarSocio("Cupi2 Socio 2", "657856723");
			taquilla.agregarSocio("Cupi2 Socio 3", "123097792");
			taquilla.agregarSocio("Cupi2 Socio 4", "343445656");

			// Agrega los partidos
			taquilla.agregarPartido("Cupi2 Nemesis", Partido.TORNEO_COPA, "29/03/2013");
			taquilla.agregarPartido("Cupi2 Nemesis", Partido.TORNEO_LIGA, "25/03/2013");
			taquilla.agregarPartido("Cupi2 Nemesis", Partido.TORNEO_SUPER_LIGA, "20/03/2013");

			taquilla.agregarPartido("Cupi2 Internacional", Partido.TORNEO_SUPER_LIGA, "17/03/2013");
			taquilla.agregarPartido("Cupi2 Nacional", Partido.TORNEO_COPA, "15/03/2013");
			taquilla.agregarPartido("Cupi2 Millonarios", Partido.TORNEO_COPA, "12/03/2013");
			taquilla.agregarPartido("Santos Cupi2", Partido.TORNEO_SUPER_LIGA, "10/03/2013");
		} catch (Exception e) {
			fail("No se ha podido completar el escenario");
			e.printStackTrace();
		}
	}

	/**
	 * Prueba del método constructor de Taquilla
	 */
	public void testTaquilla() {
		setupEscenario1();

		assertEquals("El nombre del equipo debe ser el mismo", nombreEquipoTaquilla, taquilla.darNombreEquipo());
		assertNotNull("El vector de socios debe estar inicializado", taquilla.darSocios());
		assertNotNull("El vector de partidos debe estar inicializado", taquilla.darPartidos());
	}

	/**
	 * Prueba del método buscarPartido<br>
	 * Métodos a probar: agregarPartido, buscarPartido<br>
	 * Caso 1. Cuando el partido existe<br>
	 * Caso 2. Cuando el partido no existe
	 */
	public void testBuscarPartido() {
		setupEscenario2();

		ArrayList partidos = taquilla.darPartidos();

		int index = (int) (Math.random() * partidos.size());
		Partido aBuscar = (Partido) partidos.get(index);

		// Caso 1.
		Partido p = taquilla.buscarPartido(aBuscar.darRival(), aBuscar.darTorneo(), aBuscar.darFechaPartido());
		assertNotNull("El resultado debe ser distinto de null", p);
		assertEquals("El rival del partido debe ser el mismo", p.darRival(), aBuscar.darRival());
		assertEquals("El torneo del partido debe ser el mismo", p.darTorneo(), aBuscar.darTorneo());
		assertEquals("El rival del partido debe ser el mismo", p.darFechaPartido(), aBuscar.darFechaPartido());

		// Caso 2.
		p = taquilla.buscarPartido("Rival no existe", "Torneo no existe", "Fecha no existe");
		assertNull("El resultado debería ser nulo", p);
	}

	/**
	 * Prueba del método existeSocio<br>
	 * Métodos a probar: agregarSocio, existeSocio<br>
	 * Caso 1. Cuando el socio existe<br>
	 * Caso 2. Cuando el socio no existe
	 */
	public void testExisteSocio() {
		setupEscenario2();

		ArrayList socios = taquilla.darSocios();

		int index = (int) (Math.random() * socios.size());
		Persona aBuscar = (Persona) socios.get(index);

		// Caso 1.
		boolean p = taquilla.existeSocio(aBuscar.darCedula());
		assertTrue("El resultado debe ser verdadero cuando existe el socio", p);

		// Caso 2.
		p = taquilla.existeSocio("Cédula que no existe");
		assertFalse("El resultado debería ser falso cuando no existe el socio", p);
	}

	/**
	 * Prueba del método agregarSocio<br>
	 * Caso 1. Cuando el socio con la cédula no existe
	 */
	public void testAgregarSocio1() {
		setupEscenario1();

		try {
			String nombre = "Juan Pérez";
			String cedula = "123456789";
			taquilla.agregarSocio(nombre, cedula);

			assertTrue("El socio debió ser agregado", taquilla.existeSocio(cedula));
		} catch (Exception e) {
			fail("No debería lanzar excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba del método agregarSocio<br>
	 * Caso 1. Cuando el socio con la cédula existe
	 */
	public void testAgregarSocio2() {
		setupEscenario2();

		ArrayList socios = taquilla.darSocios();

		int index = (int) (Math.random() * socios.size());
		Persona aBuscar = (Persona) socios.get(index);
		try {
			String nombre = aBuscar.darNombre();
			String cedula = aBuscar.darCedula();
			taquilla.agregarSocio(nombre, cedula);

			fail("El socio NO debió ser agregado");
		} catch (Exception e) {
			// Debió lanzar la excepción
		}
	}

	/**
	 * Prueba del método agregarPartido<br>
	 * Métodos a probar: agregarPartido, buscarPartido Caso 1. Cuando el partido
	 * no existe
	 */
	public void testAgregarPartido1() {
		setupEscenario1();

		try {
			String rival = "Rival 1";
			String torneo = Partido.TORNEO_COPA;
			String fecha = "13/03/2013";
			taquilla.agregarPartido(rival, torneo, fecha);

			assertNotNull("El socio debió ser agregado", taquilla.buscarPartido(rival, torneo, fecha));
		} catch (Exception e) {
			fail("No debería lanzar excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba del método agregarPartido<br>
	 * Caso 1. Cuando el partido existe
	 */
	public void testAgregarPartido2() {
		setupEscenario2();

		ArrayList partidos = taquilla.darPartidos();

		int index = (int) (Math.random() * partidos.size());
		Partido aBuscar = (Partido) partidos.get(index);
		try {
			String rival = aBuscar.darRival();
			String torneo = aBuscar.darTorneo();
			String fecha = aBuscar.darFechaPartido();
			taquilla.agregarPartido(rival, torneo, fecha);

			fail("El partido NO debió ser agregado");
		} catch (Exception e) {
			// Debió lanzar la excepción
		}
	}

	/**
	 * Prueba del método venderSilla<br>
	 * Métodos a probar: venderSilla, existeSocio, buscarPartido<br>
	 * Caso 1. Se vende la boleta a una persona NO socia<br>
	 * Caso 2. Se vende la boleta a una persona socia
	 */
	public void testVenderSilla1() {
		setupEscenario2();

		// Caso 1.
		ArrayList partidos = taquilla.darPartidos();
		int index = (int) (Math.random() * partidos.size());
		Partido aBuscar = (Partido) partidos.get(index);

		String localidad = Taquilla.LOCALIDAD_NORTE;
		int numeroSilla = (int) (Math.random() * Partido.SILLAS_LOCALIDAD_NORTE);

		double ingresos = aBuscar.darTotalIngresos();
		try {
			taquilla.venderSilla(numeroSilla, localidad, "Comprador 1", "Cédula 1", aBuscar.darRival(), aBuscar.darTorneo(), aBuscar.darFechaPartido());

			Silla silla = aBuscar.darSillaDeLocalidad(numeroSilla, localidad);
			double precio = aBuscar.darPrecio( silla );

			assertTrue("La silla debió ser asignada", silla.estaAsignada());
			assertEquals("Los ingresos del partido aumentaron", ingresos + precio, aBuscar.darTotalIngresos());
		} catch (Exception e) {
			fail("No debe lanzar Excepción: " + e.getMessage());
		}

		// Caso 2.
		ArrayList socios = taquilla.darSocios();
		index = (int) (Math.random() * socios.size());
		Persona socio = (Persona) socios.get(index);

		// Garantiza que no se venderá una silla asignada
		int numeroSilla2 = numeroSilla;
		while (numeroSilla2 == numeroSilla) {
			numeroSilla2 = (int) (Math.random() * Partido.SILLAS_LOCALIDAD_NORTE);
		}

		ingresos = aBuscar.darTotalIngresos();
		try {
			taquilla.venderSilla(numeroSilla2, localidad, socio.darNombre(), socio.darCedula(), aBuscar.darRival(), aBuscar.darTorneo(), aBuscar.darFechaPartido());

			Silla silla = aBuscar.darSillaDeLocalidad(numeroSilla2, localidad);
			double precio = aBuscar.darPrecio( silla ) * (1 - Taquilla.DESCUENTO_SOCIO);

			assertTrue("La silla debió ser asignada", silla.estaAsignada());
			assertEquals("Los ingresos del partido aumentaron", ingresos + precio, aBuscar.darTotalIngresos());
		} catch (Exception e) {
			fail("No debe lanzar Excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba de las excepciones del método venderSilla<br>
	 * Métodos a probar: venderSilla, existeSocio, buscarPartido<br>
	 * Caso 1. No exista el partido<br>
	 * Caso 2. No existe la silla en la localidad<br>
	 */
	public void testVenderSilla2() {
		setupEscenario2();

		ArrayList partidos = taquilla.darPartidos();
		int indexPartido = (int) (Math.random() * partidos.size());
		Partido partido = (Partido) partidos.get(indexPartido);

		ArrayList socios = taquilla.darSocios();
		int indexSocio = (int) (Math.random() * socios.size());
		Persona socio = (Persona) socios.get(indexSocio);

		String localidad = Taquilla.LOCALIDAD_NORTE;
		int numeroSilla = (int) (Math.random() * Partido.SILLAS_LOCALIDAD_NORTE);

		// Caso 1.
		try {
		    double precioPrueba = taquilla.venderSilla(numeroSilla, localidad, socio.darNombre(), socio.darCedula(), "Rival no existe", "Torneo no existe", "Fecha no existe");
	        assertEquals( "El precio debe ser 0", 0 , precioPrueba, 0.0001 );
			fail("Debería lanzar excepción por partido inexistente.");
		} catch (Exception e) {
			// Debe Lanzar la excepción
		}

		// Caso 2.
		try {
		    double precioPrueba = taquilla.venderSilla(numeroSilla + Partido.SILLAS_LOCALIDAD_NORTE, localidad, socio.darNombre(), socio.darCedula(), partido.darRival(), partido.darTorneo(), partido.darFechaPartido());
	        assertEquals( "El precio debe ser 0", 0 , precioPrueba, 0.0001 );
			fail("Debería lanzar excepción por silla inexistente.");
		} catch (Exception e) {
			// Debe Lanzar la excepción
		}

		// Caso 3.
		try {
			taquilla.venderSilla(numeroSilla, localidad, socio.darNombre(), socio.darCedula(), partido.darRival(), partido.darTorneo(), partido.darFechaPartido());
			assertTrue("La silla se debió asignar", partido.darSillaDeLocalidad(numeroSilla, localidad).estaAsignada());
		} catch (Exception e) {
			fail("No debe lanzar excepción: " + e.getMessage());
		}

		try {
		    double precioPrueba = taquilla.venderSilla(numeroSilla, localidad, socio.darNombre(), socio.darCedula(), partido.darRival(), partido.darTorneo(), partido.darFechaPartido());
	        assertEquals( "El precio debe ser 0", 0 , precioPrueba, 0.0001 );
			fail("Debe lanzar excepción porque la silla está asignada");
		} catch (Exception e) {
			// No debe lanzar excepción
		}
	}

	/**
	 * Prueba del método venderSillaAutomatica<br>
	 * Caso 1. El comprador no es socio<br>
	 * Caso 2. El comprador es socio
	 */
	public void testVenderSillaAutomatica1() {
		setupEscenario2();

		// Caso 1.
		ArrayList partidos = taquilla.darPartidos();
		int index = (int) (Math.random() * partidos.size());
		Partido aBuscar = (Partido) partidos.get(index);

		String localidad = Taquilla.LOCALIDAD_NORTE;

		Silla silla = aBuscar.buscarSillaLibre(localidad);
		double precio = aBuscar.darPrecio(silla);

		double ingresos = aBuscar.darTotalIngresos();
		try {
		    double precioPrueba = taquilla.venderSillaAutomatica(localidad, "Comprador 1", "Cédula 1", aBuscar.darRival(), aBuscar.darTorneo(), aBuscar.darFechaPartido());
			assertTrue("La silla debió ser asignada", silla.estaAsignada());
	        assertEquals( "El precio es incorrecto", precio , precioPrueba, 0.0001 );
			assertEquals("Los ingresos del partido aumentaron", ingresos + precio, aBuscar.darTotalIngresos());
		} catch (Exception e) {
			fail("No debe lanzar Excepción: " + e.getMessage());
		}

		// Caso 2.
		ArrayList socios = taquilla.darSocios();
		index = (int) (Math.random() * socios.size());
		Persona socio = (Persona) socios.get(index);

		silla = aBuscar.buscarSillaLibre(localidad);
		precio = aBuscar.darPrecio(silla) * (1 - Taquilla.DESCUENTO_SOCIO);

		ingresos = aBuscar.darTotalIngresos();
		try {
			double precioPrueba = taquilla.venderSillaAutomatica(localidad, socio.darNombre(), socio.darCedula(), aBuscar.darRival(), aBuscar.darTorneo(), aBuscar.darFechaPartido());

			assertTrue("La silla debió ser asignada", silla.estaAsignada());
	        assertEquals( "El precio es incorrecto", precio , precioPrueba, 0.0001 );
			assertEquals("Los ingresos del partido aumentaron", ingresos + precio, aBuscar.darTotalIngresos());
		} catch (Exception e) {
			fail("No debe lanzar Excepción: " + e.getMessage());
		}
	}

	/**
	 * Prueba de las excepciones del método venderSillaAutomatica<br>
	 * Caso 1. No existe el partido
	 */
	public void testVenderSillaAutomatica2() {
		setupEscenario2();

		ArrayList socios = taquilla.darSocios();
		int indexSocio = (int) (Math.random() * socios.size());
		Persona socio = (Persona) socios.get(indexSocio);

		String localidad = Taquilla.LOCALIDAD_NORTE;

		// Caso 1.
		try {
		    double precioPrueba = taquilla.venderSillaAutomatica(localidad, socio.darNombre(), socio.darCedula(), "Rival no existe", "Torneo no existe", "Fecha no existe");
	        assertEquals( "El precio debe ser 0", 0 , precioPrueba, 0.0001 );
			fail("Debería lanzar excepción por partido inexistente.");
		} catch (Exception e) {
			// Debe Lanzar la excepción
		}
	}

	/**
	 * Prueba del método darTotalIngresos<br>
	 * Métodos a probar: darTotalIngresos, venderSillaAutomatica
	 */
	public void testDarTotalIngresos() {
		setupEscenario2();

		ArrayList partidos = taquilla.darPartidos();
		ArrayList socios = taquilla.darSocios();

		int index = (int) (Math.random() * socios.size());
		Persona socio = (Persona) socios.get(index);

		double ventaNoSocios = 0;
		double ventaSocios = 0;
		for (int i = 0; i < partidos.size(); i++) {
			Partido partido = (Partido) partidos.get(i);

			// Agrega ventas de no socios
			try {
				String localidad = Taquilla.LOCALIDAD_NORTE;
				int cantidadNoSocios = (int) (Math.random() * Partido.SILLAS_LOCALIDAD_NORTE);
				for (int j = 0; j < cantidadNoSocios; j++) {
					taquilla.venderSillaAutomatica(localidad, "Comprador " + i, "Cédula " + i, partido.darRival(), partido.darTorneo(), partido.darFechaPartido());
					ventaNoSocios += Taquilla.PRECIO_NORTE;
					assertEquals("Los ingresos deben ser los mismos (Compradores no socios)", ventaNoSocios + ventaSocios, taquilla.darTotalIngresos());
				}
			} catch (Exception e) {
				fail("No debería tener problema vendiendo sillas automáticas");
			}

			// Agrega ventas de socios
			try {
				String localidad = Taquilla.LOCALIDAD_SUR;
				int cantidadNoSocios = (int) (Math.random() * Partido.SILLAS_LOCALIDAD_SUR);
				for (int j = 0; j < cantidadNoSocios; j++) {
					taquilla.venderSillaAutomatica(localidad, socio.darNombre(), socio.darCedula(), partido.darRival(), partido.darTorneo(), partido.darFechaPartido());
					ventaNoSocios += Taquilla.PRECIO_SUR * (1 - Taquilla.DESCUENTO_SOCIO);
					assertEquals("Los ingresos deben ser los mismos (Compradores socios y no socios)", ventaNoSocios + ventaSocios, taquilla.darTotalIngresos());
				}
			} catch (Exception e) {
				fail("No debería tener problema vendiendo sillas automáticas");
			}
		}
		assertEquals("Los ingresos deben ser los mismos", ventaNoSocios + ventaSocios, taquilla.darTotalIngresos());
	}

	/**
	 * Prueba del método eliminarPartido<br>
	 * Caso 1. El partido existe
	 */
	public void testEliminarPartido1() {
		setupEscenario2();

		// Caso 1.
		ArrayList partidos = taquilla.darPartidos();
		int tamanio = partidos.size();
		int index = (int) (Math.random() * tamanio);
		Partido partido = (Partido) partidos.get(index);
		
		try {
			taquilla.eliminarPartido(partido.darRival(), partido.darTorneo(), partido.darFechaPartido());
			assertEquals("La cantidad de partidos debe reducirse en 1", tamanio - 1, taquilla.darPartidos().size());
		} catch (Exception e) {
			fail("No debe lanzar excepción: " + e.getMessage());
		}
	}
	
	/**
	 * Prueba del método eliminarPartido<br>
	 * Caso 1. El partido existe tiene una boleta vendida
	 */
	public void testEliminarPartido2() {
		setupEscenario2();
		
		// Caso 1.
		ArrayList partidos = taquilla.darPartidos();
		int tamanio = partidos.size();
		int index = (int) (Math.random() * tamanio);
		Partido partido = (Partido) partidos.get(index);
		
		try {
			taquilla.venderSillaAutomatica( Taquilla.LOCALIDAD_NORTE, "Comprador 1", "Cedula 1", partido.darRival(), partido.darTorneo(), partido.darFechaPartido());
			taquilla.eliminarPartido(partido.darRival(), partido.darTorneo(), partido.darFechaPartido());
			fail("Debe lanzar una excepción");
		} catch (Exception e) {
			//No debe lanzar excepción
		}

		// Caso 2.
		try {
			taquilla.eliminarPartido("Rival no existe", "Torneo no existe", "Fecha no existe");
			fail("Debe lanzar una excepción");
		} catch (Exception e) {
			//No debe lanzar excepción
		}
	}
}