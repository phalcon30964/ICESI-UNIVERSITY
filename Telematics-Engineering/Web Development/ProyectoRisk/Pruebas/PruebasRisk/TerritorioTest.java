package PruebasRisk;


import junit.framework.TestCase;
import mundoRisk.TablaRisk;
import mundoRisk.Territorio;

public class TerritorioTest extends TestCase {

	private Territorio territorio;
	
	// Escenario sin tropas 
	private void setUpEscenario1(){ 
		territorio = new Territorio("Alaska", "América del Norte");
	}
	//Escenario con 105 Tropas .. Arreglo de tropas = 5,6,7
	private void setUpEscenario3(){ 
		territorio = new Territorio("Alaska", "América del Norte");
		territorio.agregarTropas(105);
	}
	
	private void setUpEscenario4(){ 
		new TablaRisk(3);
	}
	public void testAgregarTropas(){
		setUpEscenario1();
		// se agrega una tropa al territorio vaccio
		territorio.agregarTropas(1);
		assertEquals("No se ha agregado la tropas correctamente",1, territorio.getTropas()[0]);
		
		//se le agregan 5 para tener un numero de tropas igual a 6 .... Arreglo de tropas =1,1,0
		territorio.agregarTropas(5);
		assertEquals("No se ha agregado la tropas correctamente",2, territorio.getTropas()[1]+territorio.getTropas()[0]);
		
		//se le agregan 34 para tener un numero de tropas igual a 40 .... Arreglo de tropas =5,5,1
		territorio.agregarTropas(34);
		assertEquals("No se ha agregado la tropas correctamente",11, territorio.getTropas()[2]+territorio.getTropas()[1]+territorio.getTropas()[0]);
		
		//se le agregan 65 para tener un numero de tropas igual a 105 .... Arreglo de tropas =5,5,7
		territorio.agregarTropas(60);
		
		assertEquals("No se ha agregado la tropas correctamente",17, territorio.getTropas()[2]+territorio.getTropas()[1]+territorio.getTropas()[0]);
		
	}
	
	public void testEliminarTropas()  {
		setUpEscenario3();
		
		try {
		//  se eliminan 70 tropas para asi tener un numero tropas igual a 35 ... Arreglo de tropas = 5,4,1
			territorio.eliminarTropas(70);
			assertEquals("No se ha eliminado las tropas correctamente",10, territorio.getTropas()[2]+territorio.getTropas()[1]+territorio.getTropas()[0]);			
		//  se eliminan 20 tropas para asi tener un numero tropas igual a 15 ... Arreglo de tropas = 5,2,0
			territorio.eliminarTropas(20);
			assertEquals("No se ha eliminado las tropas correctamente",7, territorio.getTropas()[2]+territorio.getTropas()[1]+territorio.getTropas()[0]);
		//  se eliminan 15 tropas para asi tener un numero tropas igual a 0 ... Arreglo de tropas = 0,0,0
			territorio.eliminarTropas(15);
			assertEquals("No se ha eliminado las tropas correctamente",0, territorio.getTropas()[2]+territorio.getTropas()[1]+territorio.getTropas()[0]);		
		//  se eliminan 6 tropas sabiendo que el numero de tropas es cero, tendria que lanzar una excepcion
			try {
				territorio.eliminarTropas(6);
				fail("No se puede eliminar tropas de donde no las hay");
			} catch (Exception e){}
			
		} catch (Exception e) {e.printStackTrace();}
	}
	
	public void testEsAdyacente(){
		// Se crea un mundo exactamente con el mapa manejado durante todo eñ proceso del proyecto.
		TablaRisk mundo = new TablaRisk(3);
		
		//---------------se toma como ejemplo a alaska para probar este metodo tomando unas de sus adyacencias y unas que no --------------

		//Caso 1
				//se busca a alaska y a la vez Territorios del Noroeste, sabiendo de ante mano que es un adyacente de él.
				assertTrue("El territorio adyacente no fue encontrado",mundo.buscarTerritorio("Alaska").esAdyacente(mundo.buscarTerritorio("Territorios del Noroeste")));
				//se busca a alaska y a la vez Kamchatka, sabiendo de ante mano que es un adyacente de él.
				assertTrue("El territorio adyacente no fue encontrado",mundo.buscarTerritorio("Alaska").esAdyacente(mundo.buscarTerritorio("Kamchatka")));
				//se busca a alaska y a la vez Alberta, sabiendo de ante mano que es un ayacente de él.
				assertTrue("El territorio adyacente no fue encontrado",mundo.buscarTerritorio("Alaska").esAdyacente(mundo.buscarTerritorio("Alberta")));
				//se busca a alaska y a la vez china, sabiendo de ante mano que no es un adyacente de él.
				
				//Caso 2
				
				assertFalse("El territorio adyacente no fue encontrado",mundo.buscarTerritorio("Alaska").esAdyacente(mundo.buscarTerritorio("China")));
				//se busca a alaska y a la vez Quebec, sabiendo de ante mano que no es un adyacente de él.
				assertFalse("El territorio adyacente no fue encontrado",mundo.buscarTerritorio("Alaska").esAdyacente(mundo.buscarTerritorio("Quebec")));
	}
	
}
