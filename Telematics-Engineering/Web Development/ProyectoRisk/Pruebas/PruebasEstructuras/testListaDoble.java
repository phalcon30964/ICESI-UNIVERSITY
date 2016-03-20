package PruebasEstructuras;

import TadLista.ListaDoble;
import junit.framework.TestCase;

public class testListaDoble extends TestCase{
	
	private ListaDoble<String> listaDoble;
	
	public void setUpEscenario1(){
		listaDoble = new ListaDoble<String>();
	}
	
	public void setUpEscenario2(){
		listaDoble = new ListaDoble<String>();
		for (int i = 0; i < 100; i++) {
			listaDoble.agregar(i+"");
		}
	}
		
	public void testAgregar() {
	
		//caso 1 agregar en lista vacia
		setUpEscenario1();
		listaDoble.agregar("0");
		assertEquals("No se esta agregando bien al principio", 1, listaDoble.darLongitud());
		assertEquals("No se esta agregando bien al principio", "0", listaDoble.darElemento(0));
		
		//Caso2 agregar en lista llena
		setUpEscenario2();
		listaDoble.agregar("100");
		assertEquals("No se esta agregando bien al principio", 101, listaDoble.darLongitud());
		assertEquals("No se esta agregando bien al principio", "100", listaDoble.darElemento(listaDoble.darLongitud()-1));
		
		
	}

	public void testAgregar2() {

		//caso 1 agregar en lista vacia
		
		setUpEscenario1();
		try {
			listaDoble.agregar(0,"0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("No se esta agregando bien al principio", 1, listaDoble.darLongitud());
		assertEquals("No se esta agregando bien al principio", "0", listaDoble.darElemento(0));
		
		//Caso2 agregar en lista llena
		setUpEscenario2();
		try {
			listaDoble.agregar(100,"100");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("No se esta agregando bien al principio", 101, listaDoble.darLongitud());
		assertEquals("No se esta agregando bien al principio", "100", listaDoble.darElemento(listaDoble.darLongitud()-1));
		
		//Caso3 agregar en lista en la mitad
		setUpEscenario2();
		try {
			listaDoble.agregar(50,"100");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("No se esta agregando bien al principio", 101, listaDoble.darLongitud());
		assertEquals("No se esta agregando bien al principio", "100", listaDoble.darElemento(50));
		
		//Caso4 agregar en posicion imposible 
		setUpEscenario2();
		try {
			listaDoble.agregar(-1,"100");
			fail();
		} catch (Exception e) {
		    assertTrue(true);
		}
	}
	

	public void testEliminar(){
	
		//Caso1 eliminar al principio
		setUpEscenario2();
		try {
			listaDoble.eliminar(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("No se esta eliminando bien al principio", 99, listaDoble.darLongitud());
		assertEquals("No se esta eliminando bien al principio", "1", listaDoble.darElemento(0));
		
		//Caso2 eliminar en lista en la mitad
		setUpEscenario2();
		try {
			listaDoble.eliminar(50);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("No se esta eliminando bien al medio", 99, listaDoble.darLongitud());
		assertEquals("No se esta eliminando bien al medio", "51", listaDoble.darElemento(50));
		
		//Caso2 eliminar en lista al final
			setUpEscenario2();
			try {
				listaDoble.eliminar(99);
			} catch (Exception e) {
				e.printStackTrace();
			}
			assertEquals("No se eliminando bien al final", 99, listaDoble.darLongitud());
			assertEquals("No se eliminando bien al final", "98", listaDoble.darElemento(listaDoble.darLongitud()));
		
		//Caso4 agregar en posicion imposible 
		setUpEscenario2();
		try {
			listaDoble.agregar(-1,"100");
			fail();
		} catch (Exception e) {
		    assertTrue(true);
		}
		
	}
}
