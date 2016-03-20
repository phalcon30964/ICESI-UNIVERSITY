package PruebasRisk;

import java.awt.Color;

import TadGrafo.GrafoLista;
import TadLista.ListaDoble;
import TadLista.ListaOrdenada;
import TadLista.ListaSimple;
import TadPila.Pila;
import junit.framework.TestCase;
import mundoRisk.CartaMision;
import mundoRisk.Jugador;
import mundoRisk.TablaRisk;
import mundoRisk.Territorio;

public class TablaRiskTest extends TestCase {

	private TablaRisk tabla;
	private GrafoLista<Territorio> territorios;

	private void setUpEscenario1() {
		tabla = new TablaRisk(3);
	}

	private void setUpEscenario3() {
		tabla = new TablaRisk(4);
	}

	private void setUpEscenario5() {
		tabla = new TablaRisk(3);
		try {
			tabla.agregarJugador("Emmanuel", TablaRisk.AMARILLO);  
			tabla.buscarJugador("Emmanuel").setNumTropasDisponiblesAUbicar(28);
			tabla.agregarJugador("David", TablaRisk.AZUL);
			tabla.buscarJugador("David").setNumTropasDisponiblesAUbicar(28);
			tabla.agregarJugador("Christian", TablaRisk.ROJO);
			tabla.buscarJugador("Christian").setNumTropasDisponiblesAUbicar(28);

			for (int i = 0; i < 14; i++) {
				tabla.agregarTerritorioAJugador("Christian",
						tabla.nombreTerritorios[i]);
				tabla.agregarTropaATerritorio("Christian",
						tabla.nombreTerritorios[i], 10);
				tabla.buscarTerritorio(tabla.nombreTerritorios[i]).setPropietario(tabla.buscarJugador("Christian"));
			}

			for (int i = 14; i < 28; i++) {
				tabla.agregarTerritorioAJugador("Emmanuel",
						tabla.nombreTerritorios[i]);
				tabla.agregarTropaATerritorio("Emmanuel",
						tabla.nombreTerritorios[i], 10);
				tabla.buscarTerritorio(tabla.nombreTerritorios[i]).setPropietario(tabla.buscarJugador("Emmanuel"));
			}

			for (int i = 28; i < 42; i++) {
				tabla.agregarTerritorioAJugador("David",
						tabla.nombreTerritorios[i]);
				tabla.agregarTropaATerritorio("David",
						tabla.nombreTerritorios[i], 10);
				tabla.buscarTerritorio(tabla.nombreTerritorios[i]).setPropietario(tabla.buscarJugador("David"));

			}
		} catch (Exception e) {
		}

	}

	private void setUpEscenario4() {
		tabla = new TablaRisk(3);
		try {
			tabla.agregarJugador("Emmanuel", TablaRisk.AMARILLO);
			tabla.buscarJugador("Emmanuel").setNumTropasDisponiblesAUbicar(70);
			tabla.agregarJugador("David", TablaRisk.AZUL);
			tabla.buscarJugador("David").setNumTropasDisponiblesAUbicar(70);
			tabla.agregarJugador("Christian", TablaRisk.ROJO);
			tabla.buscarJugador("Christian").setNumTropasDisponiblesAUbicar(70);


			for (int i = 0; i < 14; i++) {
				tabla.agregarTerritorioAJugador("Christian",
						TablaRisk.nombreTerritorios[i]);
				tabla.agregarTropaATerritorio("Christian",
						TablaRisk.nombreTerritorios[i], 5);
				tabla.buscarTerritorio(TablaRisk.nombreTerritorios[i]).setPropietario(tabla.buscarJugador("Christian"));
			}

			for (int i = 14; i < 28; i++) {
				tabla.agregarTerritorioAJugador("Emmanuel",
						TablaRisk.nombreTerritorios[i]);
				tabla.agregarTropaATerritorio("Emmanuel",
						TablaRisk.nombreTerritorios[i], 5);
				tabla.buscarTerritorio(TablaRisk.nombreTerritorios[i]).setPropietario(tabla.buscarJugador("Emmanuel"));
			}

			for (int i = 28; i < 42; i++) {
				tabla.agregarTerritorioAJugador("David",
						TablaRisk.nombreTerritorios[i]);
				tabla.agregarTropaATerritorio("David",
						TablaRisk.nombreTerritorios[i], 5);
				tabla.buscarTerritorio(TablaRisk.nombreTerritorios[i]).setPropietario(tabla.buscarJugador("David"));

			}
			tabla.setEtapaJuego(3);
			tabla.setJugadorActual(0);
		} catch (Exception e) {
		}
	}

	private void setUpEscenario6(){ 
		tabla=new TablaRisk(6);
		try {
			tabla.agregarJugador("a", TablaRisk.AMARILLO);
			tabla.agregarJugador("b", TablaRisk.AZUL);
			tabla.agregarJugador("c", TablaRisk.NARANJA);
			tabla.agregarJugador("d", TablaRisk.NEGRO);
			tabla.agregarJugador("e", TablaRisk.ROSADO);
			tabla.agregarJugador("f", TablaRisk.ROJO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setUpEscenario7(){ 
		tabla=new TablaRisk(3);
		try {
			tabla.agregarJugador("Emmanuel", tabla.AMARILLO);
			tabla.buscarJugador("Emmanuel").setNumTropasDisponiblesAUbicar(35);

			tabla.agregarJugador("David", tabla.AZUL);
			tabla.buscarJugador("David").setNumTropasDisponiblesAUbicar(35);

			tabla.agregarJugador("Christian", tabla.ROJO);
			tabla.buscarJugador("Christian").setNumTropasDisponiblesAUbicar(35);

			territorios.agregarVertice(new Territorio("Argentina", "SurAmerica"));
			territorios.agregarVertice(new Territorio("Brasil", "SurAmerica"));
			territorios.agregarVertice(new Territorio("Venezuela", "SurAmerica"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	// 
	/**Este método realiza las pruebas de: agregarJugador y buscarJugador.
	 * 
	 */
	public void testAgregarJugador() {
		setUpEscenario1();
		try {
			tabla.agregarJugador("Emmanuel", tabla.AMARILLO);
			tabla.buscarJugador("Emmanuel").setNumTropasDisponiblesAUbicar(35);

			tabla.agregarJugador("David", tabla.AZUL);
			tabla.buscarJugador("David").setNumTropasDisponiblesAUbicar(35);

			tabla.agregarJugador("Christian", tabla.ROJO);
			tabla.buscarJugador("Christian").setNumTropasDisponiblesAUbicar(35);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Jugador jugador = tabla.buscarJugador("Emmanuel");

		//Método buscarJugador
		//Caso 1 busca un jugador que hace parte de la lista de jugadores
		assertEquals("No se esta encontrando el jugador", "Emmanuel",
				jugador.getNombre());

		//Caso 2 busca un jugador que no pertenece a la lista de jugadores
		assertTrue("no se deberia encontrar este jugador porque no existe",
				tabla.buscarJugador("Timo") == null);


		//Método agregarJugador
		// Caso 1  Revisa si los 3 jugadores agregados se encuentran en la lista de jugadores.

		assertEquals("No se esta agregando correctamente", "Emmanuel", tabla
				.getJugadores().darElemento(0).getNombre());
		assertEquals("No se esta agregando correctamente", "David", tabla
				.getJugadores().darElemento(1).getNombre());
		assertEquals("No se esta agregando correctamente", "Christian", tabla
				.getJugadores().darElemento(2).getNombre());


		//Caso 2 Revisa que no se encuentre un jugador que no debería estar en la lista de jugadores.
		assertFalse("Se esta agregando un jugador que no debería de estar en la lista", "Pechene".equalsIgnoreCase(tabla.getJugadores().darElemento(0).getNombre()));

		//Caso 3 Revisa que el método agregarJugador tire excepción cuando se quiere agregar mas de 6 jugadores
		setUpEscenario6();
		try {
			tabla.agregarJugador("Ismael", TablaRisk.AMARILLO);
			fail();
		} catch (Exception e) {

		}
	}

	/**Este método realizar las pruebas de: buscarTerritorio,agregarTerritorioAJugador y agregarTropasATerritorio
	 * 
	 */
	public void agregarTerritorioAJugador() {
		setUpEscenario7();
		try {
			//Método buscarTerritorio
			//Caso 1 Busca un territorio que hace parte de la lista de territorios
			Territorio terri = tabla.buscarTerritorio("Argentina");
			assertEquals("Argentina", terri.getNombre());

			//Caso2 Revisa que devuelva null en caso de no existir el territorio
			assertNull("Debería ser null", tabla.buscarTerritorio("Perú"));


			tabla.agregarTerritorioAJugador("Emmanuel", "Argentina");
			tabla.agregarTerritorioAJugador("David", "Brasil");

			//Método agregarTerritorioAJugador
			//Caso 1 Comprueba que el territorio agregado hace parte de la lista de territorios ocupados por el jugador
			assertEquals("Argentina", tabla.buscarJugador("Emmanuel").buscarTerritorioDelJugador("Argentina").getNombre());
			try {

				//Caso 2 Agrega un territorio que ya se encuentra en la lista de territorios ocupados por otro jugador
				tabla.agregarTerritorioAJugador("David", "Argentina");
				fail();

			} catch (Exception e) {

			}

			// Método agregarTropasATerritorio  
			tabla.agregarTropaATerritorio("Emmanuel", "Argentina", 3);
			tabla.agregarTropaATerritorio("Emmanuel", "Argentina", 20);

			//Caso 1 Revisa que se agreguen tropas a un territorio
			assertEquals(23, tabla.buscarJugador("Emmanuel").getNumTropasUbicadas());


		} catch (Exception e) {

		}

	}
	/**Este método realiza la prueba de el método aumentarNumTropasDisponibles
	 * 
	 */
	public void testAumentarNumTropasDisponibles() {



		setUpEscenario5();
		//Caso 1
		//Bonificación 
		//Número de territorios=14/3=4
		//Continentes =(America del norte +America del sur)=2+5
		//Defecto =3
		tabla.aumentarNumTropasDisponibles(tabla.buscarJugador("Christian"));
		assertEquals(14, tabla.buscarJugador("Christian").getNumTropasDisponiblesAUbicar());
		//Caso 2
		//Bonificación
		//Número de territorios=14/3=4
		//Continentes=(África)=3
		//Defecto=3
		tabla.aumentarNumTropasDisponibles(tabla.buscarJugador("Emmanuel"));
		assertEquals(10, tabla.buscarJugador("Emmanuel").getNumTropasDisponiblesAUbicar());
		//Caso 3
		//Bonificación
		//Número de territorios=14/3=4
		//Continentes=(Oceanía)=2
		//Defecto=3
		tabla.aumentarNumTropasDisponibles(tabla.buscarJugador("David"));
		assertEquals(9, tabla.buscarJugador("David").getNumTropasDisponiblesAUbicar());

	}

	public void testReforzarTropas() {
		setUpEscenario5();
		//SE cambian los valores de la tropas de cada territorio para conocer exactamente su valor
		for (int i = 14; i < 28; i++) {
			tabla.buscarTerritorio(tabla.nombreTerritorios[i]).setNumTropasOcupandoTerritorio(0);
			tabla.buscarTerritorio(tabla.nombreTerritorios[i]).setNumTropasOcupandoTerritorio(10);
		}
		//Se refuerzan tropas a cada par de tropas del jugador
		for (int i = 14; i < 27; i++) {
			tabla.reforzarTropas(tabla.nombreTerritorios[i], tabla.nombreTerritorios[i+1], 5);
			i++;
		}
		// se verifica que las tropas se hayan cambiado correctamente
		for (int i = 14; i < 27; i++) {
			assertEquals(5, tabla.buscarTerritorio(tabla.nombreTerritorios[i]).getNumTropasOcupandoTerritorio());
			assertEquals(15, tabla.buscarTerritorio(tabla.nombreTerritorios[i+1]).getNumTropasOcupandoTerritorio());
			i++;
		}
	}

	public void testGetMejorTerritorioAatacar() {
		setUpEscenario4();
		
		// se verifica que al llamar el metodo en dicho territorio lanzara un territorio a atacar
		ListaDoble<Territorio> list = tabla.getMejorTerritorioAatacar(tabla.getJugadorActual().getNombre(), "Egipto");
		assertEquals("Oriente Medio", list.darElemento(0).getNombre());
		
		// se verifica que al llamar el metodo en dicho territorio lanzara un territorio a atacar
		ListaDoble<Territorio> list1 = tabla.getMejorTerritorioAatacar(tabla.getJugadorActual().getNombre(), "Congo");
		assertEquals(0, list1.darLongitud());
		
		// se verifica que al llamar el metodo en dicho territorio lanzara un territorio a atacar
		ListaDoble<Territorio> list2 = tabla.getMejorTerritorioAatacar(tabla.getJugadorActual().getNombre(), "Escandinavia");
		assertEquals("Gran Bretaña", list2.darElemento(0).getNombre());
				
		// se verifica que al llamar el metodo en dicho territorio lanzara un territorio a atacar
		ListaDoble<Territorio> list3 = tabla.getMejorTerritorioAatacar(tabla.getJugadorActual().getNombre(), "Islandia");
		assertEquals("Groenlandia", list3.darElemento(0).getNombre());
					
		// se verifica que al llamar el metodo en dicho territorio lanzara un territorio a atacar
		ListaDoble<Territorio> list4 = tabla.getMejorTerritorioAatacar(tabla.getJugadorActual().getNombre(), "Afganistán");
		assertEquals("India", list4.darElemento(0).getNombre());
					
		// se verifica que al llamar el metodo en dicho territorio lanzara un territorio a atacar
		ListaDoble<Territorio> list5 = tabla.getMejorTerritorioAatacar(tabla.getJugadorActual().getNombre(), "Europa del Norte");
		assertEquals("Gran Bretaña", list5.darElemento(0).getNombre());
		
		
	}

	public void testVerificarTropaPorTerritorio() {

		setUpEscenario1();
		//Se confirma que al tener un escenario vacio el metodo retornara false
		assertFalse(tabla.verificarTropaPorTerritorio());


		setUpEscenario5();
		//Se carga un escenario distinto.
		//Se cambian los valores de la tropas de cada territorio por una tropas unicamente
		for (int i = 0; i < 42; i++) {
			tabla.buscarTerritorio(tabla.nombreTerritorios[i]).setNumTropasOcupandoTerritorio(0);
			tabla.buscarTerritorio(tabla.nombreTerritorios[i]).setNumTropasOcupandoTerritorio(1);
		}
		assertTrue(tabla.verificarTropaPorTerritorio());

		//Cambiando el estado del juego,las tropas de los territorios del segundo jugador 
		for (int i = 28; i < 42; i++) {
			tabla.buscarTerritorio(tabla.nombreTerritorios[i]).setNumTropasOcupandoTerritorio(0);
			tabla.buscarTerritorio(tabla.nombreTerritorios[i]).setNumTropasOcupandoTerritorio(3);
		}
		assertFalse(tabla.verificarTropaPorTerritorio());
	}

	public void testVerificarTodosJugadoresTienenTropasUbicadas() {
		setUpEscenario1();
		//Se confirma que al tener un escenario vacio el metodo retornara false
		try {
			tabla.verificarTodosJugadoresTienenTropasUbicadas();
			fail("No se debio de realizar cierta accion al tener estancias nulas");
		} catch (Exception e) {}

		setUpEscenario5();
		assertFalse("Los jugadores no han terminado de asignar sus tropas",tabla.verificarTodosJugadoresTienenTropasUbicadas());

		//Se carga un escenario distinto.
		//Se cambian los valores de la tropas a ubicar de cada jugador por cero
		for (int i = 0; i < tabla.getJugadores().darLongitud(); i++) {
			tabla.getJugadores().darElemento(i).setNumTropasDisponiblesAUbicar(0);
		}
		assertTrue("Los jugadores han terminado de asignar sus tropas", tabla.verificarTodosJugadoresTienenTropasUbicadas());

	}



	public void testPasarTurno() {
		setUpEscenario5();

		//Se verifica que al iniciar juego el turno sea del primer jugador registrado.
		assertEquals("El jugador actual es el incorrecto","Emmanuel", tabla.getJugadorActual().getNombre());

		//Se pasan Turnos para verificar si lo hace correctamente
		try {
			tabla.pasarTurno();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("El jugador actual es el incorrecto","David", tabla.getJugadorActual().getNombre());
		try {
			tabla.pasarTurno();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("El jugador actual es el incorrecto","Christian", tabla.getJugadorActual().getNombre());
		try {
			tabla.pasarTurno();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("El jugador actual es el incorrecto","Emmanuel", tabla.getJugadorActual().getNombre());
		try {
			tabla.pasarTurno();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("El jugador actual es el incorrecto","David", tabla.getJugadorActual().getNombre());
		try {
			tabla.pasarTurno();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("El jugador actual es el incorrecto","Christian", tabla.getJugadorActual().getNombre());
	}

	public void testDarDuenoTerritorio() {
		setUpEscenario5();

		// Se prueba que los propietarios sean con los que se inicializaron
		for (int i = 0; i < 14; i++) {
			assertEquals("Christian",tabla.buscarTerritorio(tabla.nombreTerritorios[i]).getPropietario().getNombre());
		}
		for (int i = 14; i < 28; i++) {
			assertEquals("Emmanuel",tabla.buscarTerritorio(tabla.nombreTerritorios[i]).getPropietario().getNombre());
		}
		for (int i = 28; i < 42; i++) {
			assertEquals("David",tabla.buscarTerritorio(tabla.nombreTerritorios[i]).getPropietario().getNombre());
		}
		//Se Virifica que el propietario no sea halla alterado
		for (int i = 14; i < 28; i++) {
			assertNotSame("David",tabla.buscarTerritorio(tabla.nombreTerritorios[i]).getPropietario().getNombre());
		}
		for (int i = 28; i < 42; i++) {
			assertNotSame("Emmanuel",tabla.buscarTerritorio(tabla.nombreTerritorios[i]).getPropietario().getNombre());
		}


	}

	public void testNumDadosConLosQueSePuedeAtacar() {
		setUpEscenario5();
		// se mira si al tener un territorio con mas de 3 tropas sus dados sean 3
		assertEquals(3, tabla.numDadosConLosQueSePuedeAtacar("Alaska"));

		//Se modifica el estado de un terrritorio para obtener como resultado 2 dados
		tabla.buscarTerritorio("Alaska").setNumTropasOcupandoTerritorio(3);
		//Se rectifica que los numero de dados a atacar sean los correctos
		assertEquals(2, tabla.numDadosConLosQueSePuedeAtacar("Alaska"));


		//Se modifica el estado de un terrritorio para obtener como resultado 1 dados
		tabla.buscarTerritorio("Alaska").setNumTropasOcupandoTerritorio(2);
		//Se rectifica que los numero de dados a atacar sean los correctos
		assertEquals(1, tabla.numDadosConLosQueSePuedeAtacar("Alaska"));

		//Se modifica el estado de un terrritorio para obtener como resultado 0 dados(Sabiendo que tal resultado signifia que no se puede atacar)
		tabla.buscarTerritorio("Alaska").setNumTropasOcupandoTerritorio(1);
		//Se rectifica que los numero de dados a atacar sean los correctos
		assertEquals(0, tabla.numDadosConLosQueSePuedeAtacar("Alaska"));

	}

	public void testNumDadosConLosQueSePuedeDefender() {
		setUpEscenario5();

		//Se verifica que el numero de dados a defender sean dos aunque haya un numero mayor que 2
		assertEquals(2, tabla.numDadosConLosQueSePuedeDefender("Alaska"));

		//Se modifica el estado de un terrritorio para obtener como resultado 1 dados
		tabla.buscarTerritorio("Alaska").setNumTropasOcupandoTerritorio(1);
		//Se rectifica que los numero de dados a defender sean los correctos
		assertEquals(1, tabla.numDadosConLosQueSePuedeDefender("Alaska"));

	}

	public void testTirarDados() {
		setUpEscenario5();
		// Se obtiene los numero de dados al  atacar y defender 
		int uno= tabla.numDadosConLosQueSePuedeAtacar("Alaska");
		int dos = tabla.numDadosConLosQueSePuedeDefender("Ucrania");
		// Se ve rifica que la lista a devolver del metodo se a de tamaño dos , una lista del atacante y otra del defensor
		//ademas que cada lista tenga una longitud igual al numero de dados que le toco lanzar
		try {
			ListaDoble<ListaOrdenada<Integer>> lista = tabla.tirarDados("Alaska", "Ucrania", uno, dos);
			assertEquals(2, lista.darLongitud());
			assertEquals(uno, lista.darElemento(0).darLongitud());
			assertEquals(dos, lista.darElemento(1).darLongitud());
		} catch (Exception e) {e.printStackTrace();}

		// Se obtiene los numero de dados al  atacar y defender habiendo modificado el estado de los terriotorios
		tabla.buscarTerritorio("Alaska").setNumTropasOcupandoTerritorio(3);
		tabla.buscarTerritorio("Ucrania").setNumTropasOcupandoTerritorio(1);
		int un= tabla.numDadosConLosQueSePuedeAtacar("Alaska");
		int d = tabla.numDadosConLosQueSePuedeDefender("Ucrania");
		// Se ve rifica que la lista a devolver del metodo se a de tamaño dos , una lista del atacante y otra del defensor
		//ademas que cada lista tenga una longitud igual al numero de dados que le toco lanzar
		try {
			ListaDoble<ListaOrdenada<Integer>> lista = tabla.tirarDados("Alaska", "Ucrania", un, d);
			assertEquals(2, lista.darLongitud());
			assertEquals(un, lista.darElemento(0).darLongitud());
			assertEquals(d, lista.darElemento(1).darLongitud());
		} catch (Exception e) {e.printStackTrace();}


	}

	public void testAtacar() {
		setUpEscenario4();
		
		String cadena ="Se debe conquistar  ";
		ListaDoble<Integer> lista12=new ListaDoble<Integer>();
		for (int i = 0; i < 42; i++) {
			lista12.agregar(i);
		}
		CartaMision carta3=new CartaMision(TablaRisk.CARTA_MISION, cadena+ "El mundo" , lista12);
		
		tabla.buscarJugador("Emmanuel").setCartaMision(carta3);
		tabla.buscarJugador("David").setCartaMision(carta3);
		tabla.buscarJugador("Christian").setCartaMision(carta3);
		
		// se crean las listas de dados de cada jugador
		ListaOrdenada<Integer> listAtacante = new ListaOrdenada<>(false);
		listAtacante.agregar(new Integer(6));
		listAtacante.agregar(new Integer(3));
		listAtacante.agregar(new Integer(2));
		ListaOrdenada<Integer> listDefensor = new ListaOrdenada<>(false);
		listDefensor.agregar(new Integer(5));
		listDefensor.agregar(new Integer(3));
		try {
			// se obtiene la repuesta al llamar el metodo atacar
			int[] res = tabla.atacar("Islandia", "Groenlandia", listAtacante, listDefensor);

			// se verifica primero que todo que la repuesta sea correcta ,
			//numero mayor que 0 si el atacante gano la contienda, 0 o menor que 0 si el defensor gano la contienda
			assertEquals("El valor es incorrecto", 1, res[0]);
			assertEquals("El valor es incorrecto", 0, res[1]);

			///
			//se verifica que se halla cambiado las instancias en el mundo al ejecutar el metodo
			assertEquals("No se actuilizan bien las instancias del mundo",4, tabla.buscarTerritorio("Groenlandia").getTropas()[0]);
			assertEquals("No se actuilizan bien las instancias del mundo",4, tabla.buscarTerritorio("Islandia").getTropas()[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// se verifica que al atacar un terrritorio no adyacente lanzaria una excepcion
		try {
			tabla.atacar("Islandia", "China", listAtacante, listDefensor);
			fail("no se debio ejecutar dicha accion");
		} catch (Exception e) {
		}

		tabla.buscarTerritorio("Groenlandia").setNumTropasOcupandoTerritorio(1);
		try {
			tabla.atacar("Islandia","Groenlandia", listAtacante, listDefensor);
			fail("no se debio ejecutar dicha accion");
		} catch (Exception e) {
		}


	}



}
