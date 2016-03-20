package PruebasRisk;

import javax.swing.text.TabableView;

import TadLista.ListaDoble;

import mundoRisk.CartaMision;
import mundoRisk.CartaTerritorio;
import mundoRisk.Jugador;
import mundoRisk.TablaRisk;
import mundoRisk.Territorio;

import junit.framework.TestCase;

public class JugadorTest  extends TestCase{

	private Jugador jugador;
	private TablaRisk mundo;
	
	private void setupEscenario1(){
		 mundo = new TablaRisk(3);
		try {
			mundo.agregarJugador("Christian", TablaRisk.AMARILLO);
			mundo.buscarJugador("Christian").setNumTropasDisponiblesAUbicar(28);
			jugador = mundo.buscarJugador("Christian");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setupEscenario2(){
		 mundo = new TablaRisk(3);
		try {
			mundo.agregarJugador("Christian", TablaRisk.AMARILLO);
			mundo.buscarJugador("Christian").setNumTropasDisponiblesAUbicar(28);

			jugador = mundo.buscarJugador("Christian");
			for (int i = 0; i < 14; i++) {
				jugador.agregarTerritiorio(mundo.buscarTerritorio(mundo.nombreTerritorios[i]));
				mundo.buscarTerritorio(mundo.nombreTerritorios[i]).setPropietario(mundo.buscarJugador("Christian"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testAgregarTerritorio(){
		setupEscenario1();
		
		try {
			//Se agrega territorios a la lista de territorios del jugador
			for (int i = 0; i < 14; i++) {
				jugador.agregarTerritiorio(mundo.buscarTerritorio(mundo.nombreTerritorios[i]));
			}
			//Se verifica que existan ciertos territorios
			assertNotNull("El territorio no se agrego a la lista del jugador",jugador.buscarTerritorioDelJugador("Alaska"));
			assertNotNull("El territorio no se agrego a la lista del jugador",jugador.buscarTerritorioDelJugador("Groenlandia"));
			assertNotNull("El territorio no se agrego a la lista del jugador",jugador.buscarTerritorioDelJugador("Quebec"));
			assertNotNull("El territorio no se agrego a la lista del jugador",jugador.buscarTerritorioDelJugador("Alberta"));
			// Se verifica que Indonesia, territorio inexistente en la lista edl jugador, se encuentre
			assertNull("El territorio no se debio agregar a la lista del jugador",jugador.buscarTerritorioDelJugador("Indonesia"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void testEliminarTerritorio(){
		setupEscenario2();
		jugador.eliminarTerritiorio(mundo.buscarTerritorio("Alaska"));
		jugador.eliminarTerritiorio(mundo.buscarTerritorio("Groenlandia"));
		jugador.eliminarTerritiorio(mundo.buscarTerritorio("Quebec"));
		jugador.eliminarTerritiorio(mundo.buscarTerritorio("Alberta"));
		//se verifica que los territorio se hallan eliminado.
		assertNull("El territorio no se elimino correctamente de la lista del jugador", jugador.buscarTerritorioDelJugador("Alaska"));
		assertNull("El territorio no se elimino correctamente de la lista del jugador", jugador.buscarTerritorioDelJugador("Groenlandia"));
		assertNull("El territorio no se elimino correctamente de la lista del jugador", jugador.buscarTerritorioDelJugador("Quebec"));
		assertNull("El territorio no se elimino correctamente de la lista del jugador", jugador.buscarTerritorioDelJugador("Alberta"));
		// se verifica que no se hallan eliminado territorios incorrectamente.
		assertNotNull("El territorio no se debio eliminar de la lista del jugador", jugador.buscarTerritorioDelJugador("México"));
		assertNotNull("El territorio no se debio eliminar de la lista del jugador", jugador.buscarTerritorioDelJugador("Ontario"));
		assertNotNull("El territorio no se debio eliminar de la lista del jugador", jugador.buscarTerritorioDelJugador("Territorios del Noroeste"));
		assertNotNull("El territorio no se debio eliminar de la lista del jugador", jugador.buscarTerritorioDelJugador("Estados Unidos del Oeste"));
	}
	
	public void testAgregarTropa(){
		setupEscenario2();
		
		jugador.agregarTropa("Alaska", 10);
		jugador.agregarTropa("Alberta", 10);
		//Se verifica que las tropas se aumentaron en dichos territorios
		assertEquals(10, jugador.buscarTerritorioDelJugador("Alaska").getNumTropasOcupandoTerritorio());
		assertEquals(10, jugador.buscarTerritorioDelJugador("Alberta").getNumTropasOcupandoTerritorio());
		
	}
	
	
	public void testHayTerritoriosParaRevancha(){
		setupEscenario2();
		try {
			/// se crea un nuevo jugador y se le asigna solo un territorio
			mundo.agregarJugador("David", TablaRisk.AMARILLO);
			mundo.buscarJugador("David").setNumTropasDisponiblesAUbicar(28);

			jugador.eliminarTerritiorio(mundo.buscarTerritorio("Estados Unidos del Este"));
			mundo.buscarTerritorio("Estados Unidos del Este").setPropietario(mundo.buscarJugador("David"));
			mundo.buscarTerritorio("Islandia").setPropietario(mundo.buscarJugador("Christian"));
			
			
			//se verifica que el jugador tiene territorios alrededor al cual va  atacar
			assertTrue("Dicho jugador tiene suficientes territorios de apoyo al atacar",jugador.hayTerritoriosParaRevancha(mundo.buscarTerritorio("Estados Unidos del Este")));
		} catch (Exception e) {e.printStackTrace();}
	}
	
	public void testreforzarTropasEnTerritorio(){
		setupEscenario2();
		jugador.agregarTropa("Alaska", 12);
		jugador.reforzarTropasEnTerritorio("Alaska", "Alberta", 10);
		assertEquals("La cantidad de tropas no es la correcta en dicho territorio",10, mundo.buscarTerritorio("Alberta").getNumTropasOcupandoTerritorio());
		assertEquals("La cantidad de tropas no es la correcta en dicho territorio",2, mundo.buscarTerritorio("Alaska").getNumTropasOcupandoTerritorio());
		jugador.reforzarTropasEnTerritorio("Alberta", "Alaska", 8);
		assertEquals("La cantidad de tropas no es la correcta en dicho territorio",10, mundo.buscarTerritorio("Alaska").getNumTropasOcupandoTerritorio());
		assertEquals("La cantidad de tropas no es la correcta en dicho territorio",2, mundo.buscarTerritorio("Alberta").getNumTropasOcupandoTerritorio());
	}
	
	public void testbuscarTerritorioDelJugador(){
		setupEscenario2();
		//SE verifica que los territorio del jugador se encuentren en su lista de territorios
		assertNotNull("El territorio se debio de encontar en la lista del jugador", jugador.buscarTerritorioDelJugador("Alaska"));
		assertNotNull("El territorio se debio de encontar en la lista del jugador", jugador.buscarTerritorioDelJugador("Estados Unidos del Oeste"));
		assertNotNull("El territorio se debio de encontar en la lista del jugador", jugador.buscarTerritorioDelJugador("Brasil"));
		//Se verifica que territorios no agregados no esten su lista
		assertNull("El territorio  no se debio de encontar en la lista del jugador", jugador.buscarTerritorioDelJugador("Sudáfrica"));
		assertNull("El territorio  no se debio de encontar en la lista del jugador", jugador.buscarTerritorioDelJugador("Madagascar"));
		assertNull("El territorio  no se debio de encontar en la lista del jugador", jugador.buscarTerritorioDelJugador("Egipto"));
		
	}

	public void testmisionCumplida(){
		setupEscenario1();
		//Se verifica que exactamente el jugador no ha cumplido su mision 
		try {
			jugador.misionCumplida();
			fail("no se debio de haber realizado cierto metodo");
		} catch (Exception e) {}
		
		
		
		//--------------Se recrea un mundo en el cual la mision se debe de cumplir------------
		
				//se crea una nueva carta mision para asignaserla al jugador ademas a los territorios de la cartaMision se les cambia su propietario
				ListaDoble<Territorio> terri = mundo.getTerritorios();
				ListaDoble<Integer> lista1=new ListaDoble<Integer>();
				for (int i = 0; i < 9; i++) {
					lista1.agregar(i);
					mundo.buscarTerritorio(mundo.nombreTerritorios[i]).setPropietario(mundo.buscarJugador("Christian"));
				}
				CartaMision carta =new CartaMision(TablaRisk.CARTA_MISION, "Se debe conquistar"+"América del Norte",lista1 );
				jugador.setCartaMision(carta);
				assertTrue("La mision se debio de haber cumplido",jugador.misionCumplida());
				
				
		//se le asigna a un territorio de el un nuevo propietario, dejando asi su mision fallida
				try {
					mundo.agregarJugador("David", TablaRisk.AMARILLO);
					mundo.buscarJugador("David").setNumTropasDisponiblesAUbicar(28);
				} catch (Exception e) {
				}
				mundo.buscarTerritorio("Alaska").setPropietario(mundo.buscarJugador("David"));
				
				assertFalse("La mision no se debio de haber cumplido",jugador.misionCumplida());
	}
	
}
