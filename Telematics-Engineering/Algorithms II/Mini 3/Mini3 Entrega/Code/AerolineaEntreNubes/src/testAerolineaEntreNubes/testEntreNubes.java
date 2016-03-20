package testAerolineaEntreNubes;

import junit.framework.TestCase;
import org.junit.Test;

import mundo.Ciudad;
import mundo.EntreNubes;
import mundo.rutaException;


public class testEntreNubes extends TestCase{
	
	
	private EntreNubes miNube;
	private Ciudad miCiudad;
	
	
	public void setUp1(){
		miNube = new EntreNubes();
		
		try {
			miNube.agregarCiudad("Cali", "Bucaramanga", "la otra casa", 200, 3);
			miNube.agregarCiudad("Bucaramanga", "Valledupar", "la casa del vecino", 230, 3);
			miNube.agregarCiudad("Valledupar", "Riohacha", "la casa de al lado", 250, 4);
			miNube.agregarCiudad("Bucaramanga", "Pasto", "La casa del paisano", 200, 4);
			miNube.agregarCiudad("Pasto", "Leticia", "mi casa", 300, 7);
		} catch (rutaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public void setUp2(){
		miNube = new EntreNubes();
		try {
			miNube.agregarCiudad("Cali", "Neiva", "Mi casa", 120, 1);
			
		} catch (rutaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testBuscarCiudad(){
		setUp1();
		assertEquals("No es la ciudad esperada", "Bucaramanga",miNube.buscarCiudad("Bucaramanga").darNombre());
		assertEquals("No es la ciudad esperada", "Leticia",miNube.buscarCiudad("Leticia").darNombre());
		assertEquals("No es la ciudad esperada", "Riohacha",miNube.buscarCiudad("Riohacha").darNombre());
		assertEquals("No es la ciudad esperada", "Valledupar",miNube.buscarCiudad("Valledupar").darNombre());
		setUp2();
		assertEquals("No es la ciudad esperada", "Neiva",miNube.buscarCiudad("Neiva").darNombre());
	}
	@Test
	public void testCosultarRuta(){
		setUp1();
		try {
			for(int i = 0;i<miNube.calcularRuta("Cali", "Riohacha").size();i++){
				Ciudad ciudadRuta = miNube.calcularRuta("Cali", "Riohacha").get(i);
				if(i==0){
					assertEquals("No es la ciudad esperada", "Cali",ciudadRuta.darNombre());
				}else if(i==1){
					assertEquals("No es la ciudad esperada","Bucaramanga",ciudadRuta.darNombre());
				}else if (i==2){
					assertEquals("No es la ciudad esperada", "Valledupar",ciudadRuta.darNombre());
				}else if (i==3){
					assertEquals("No es la ciudad esperada", "Riohacha",ciudadRuta.darNombre());
				}
				
		
			}
			
			
		} catch (rutaException e) {
			assertTrue(false);
			e.printStackTrace();
		}
		setUp2();
		
		try {
			for (int i = 0; i < miNube.calcularRuta("Cali", "Neiva").size(); i++) {
				Ciudad ciudadRuta = miNube.calcularRuta("Cali", "Neiva").get(i);
				if(i==0){
					assertEquals("No es la ciudad esperada", "Cali",ciudadRuta.darNombre());
				}else{
					assertEquals("No es la ciudad esperada","Neiva",ciudadRuta.darNombre());
				}
			}
			for (int i = 0; i < miNube.calcularRuta("Cali", "Mitu").size(); i++) {
				Ciudad ciudadRuta = miNube.calcularRuta("Cali", "Neiva").get(i);
				if(i==0){
					assertEquals("No es la ciudad esperada", "Cali",ciudadRuta.darNombre());
				}else{
					assertEquals("No es la ciudad esperada","Mitu",ciudadRuta.darNombre());
				}
			}
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	public void testCalcularDistancia(){
		setUp1();
		try {
			assertEquals("No es la distancia correcta", "1380km",miNube.calcularDistancia(miNube.calcularRuta("Riohacha", "Leticia")));
			assertEquals("No es la distancia correcta", "830km",miNube.calcularDistancia(miNube.calcularRuta("Valledupar", "Pasto")));
			assertEquals("No es la distancia correcta", "700km",miNube.calcularDistancia(miNube.calcularRuta("Bucaramanga", "Leticia")));

		} catch (rutaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setUp2();
		try {
			assertEquals("No es la distancia correcta", "120km",miNube.calcularDistancia(miNube.calcularRuta("Cali", "Neiva")));
			
		} catch (rutaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void testCalcularTiempo(){
		setUp1();
		try {
			assertEquals("No es la duracion correcta", "324min",miNube.calcularTiempo(miNube.calcularRuta("Riohacha", "Leticia")));
			assertEquals("No es la duracion correcta", "193min",miNube.calcularTiempo(miNube.calcularRuta("Valledupar", "Pasto")));
			assertEquals("No es la duracion correcta", "74min",miNube.calcularTiempo(miNube.calcularRuta("Bucaramanga", "Leticia")));

		} catch (rutaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setUp2();
		try {
			assertEquals("No es la duracion correcta", "1min",miNube.calcularTiempo(miNube.calcularRuta("Cali", "Neiva")));
			
		} catch (rutaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}