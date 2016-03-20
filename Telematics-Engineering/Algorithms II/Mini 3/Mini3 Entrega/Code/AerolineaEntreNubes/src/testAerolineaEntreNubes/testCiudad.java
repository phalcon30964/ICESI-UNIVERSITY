package testAerolineaEntreNubes;


import junit.framework.TestCase;
import org.junit.Test;

import mundo.Ciudad;
import mundo.EntreNubes;
import mundo.rutaException;


public class testCiudad extends TestCase{
	
	
	private EntreNubes miNube;
	private Ciudad miCiudad;
	
	
	public void setUp1() {
		miCiudad = new Ciudad(null, "Florencia", "Gustavo Artunduaga", 500, 120);
	}
	public void setUp2(){
		miCiudad = new Ciudad(null, "Bucaramanga", "Palonegro", 480, 110);
		
		
	}
	
	
	@Test
	public void testBuscarCiudadYAgregarCiudad(){
	

		setUp1();
		//Verifico si agrega bien y que si esta repetido tira excepcion
		try {
			miCiudad.agregarCiudadHija("Popayan", "Guillermo León Valencia", 50	, 10);
			miCiudad.agregarCiudadHija("Mitu", "Alberto León Bentley", 800, 200);
			miCiudad.agregarCiudadHija("Popayan", "Guillermo León Valencia", 50	, 10);
			assertTrue("No debio haber agregado una ciudad repetida",false);
		} catch (rutaException e) {
			assertTrue(true);
			
		}
		
		assertEquals("No es la ciudad buscada ","Popayan",miCiudad.buscarCiudad("Popayan").darNombre() );
		assertEquals("No es la ciudad buscada", "Mitu",miCiudad.buscarCiudad("Mitu").darNombre());
		
		setUp2();
		assertEquals("No es la ciudad buscada",null,miCiudad.buscarCiudad("Popayan") );
	
	}
	
	
	@Test
	public void testEliminarCiudad(){
		
		setUp1();
		try {
			miCiudad.eliminarCiudadHija("Popayan");
			miCiudad.eliminarCiudadHija("Mitu");
		} catch (Exception e) {
			assertTrue("No debe llegar hasta aca",false);
		}
		
		assertEquals("No se elimino la ciudad",null ,miCiudad.buscarCiudad("Popayan"));
		assertEquals("No se elimino la ciudad",null, miCiudad.buscarCiudad("Mitu"));
		
		
		setUp2();
		try {
			miCiudad.eliminarCiudadHija("Villavicencio");
		} catch (rutaException e) {
			assertTrue(true);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
