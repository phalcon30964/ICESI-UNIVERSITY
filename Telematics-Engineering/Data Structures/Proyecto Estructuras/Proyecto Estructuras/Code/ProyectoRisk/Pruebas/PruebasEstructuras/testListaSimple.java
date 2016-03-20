package PruebasEstructuras;

import TadLista.ListaSimple;
import junit.framework.TestCase;

public class testListaSimple extends TestCase{
	
	private ListaSimple<String> listaSimple;
	
	
	public void setUpEscenario1(){
		listaSimple = new ListaSimple<String>();
	}
	
	public void setUpEscenario2(){
		listaSimple = new ListaSimple<String>();
		for (int i = 0; i < 100; i++) {
			listaSimple.agregar(i+"");
		}
	}
		
	public void testAgregar() {
	
		//caso 1 agregar en lista vacia
		setUpEscenario1();
		listaSimple.agregar("0");
		assertEquals("No se esta agregando bien al principio", 1, listaSimple.darLongitud());
		assertEquals("No se esta agregando bien al principio", "0", listaSimple.darElemento(0));
		
		//Caso2 agregar en lista llena
		setUpEscenario2();
		listaSimple.agregar("100");
		assertEquals("No se esta agregando bien al principio", 101, listaSimple.darLongitud());
		assertEquals("No se esta agregando bien al principio", "100", listaSimple.darElemento(listaSimple.darLongitud()-1));
		
		
	}

	public void testAgregar2() {

		//caso 1 agregar en lista vacia
		
		setUpEscenario1();
		try {
			listaSimple.agregar(0,"0");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("No se esta agregando bien al principio", 1, listaSimple.darLongitud());
		assertEquals("No se esta agregando bien al principio", "0", listaSimple.darElemento(0));
		
		//Caso2 agregar en lista llena
		setUpEscenario2();
		try {
			listaSimple.agregar(100,"100");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("No se esta agregando bien al principio", 101, listaSimple.darLongitud());
		assertEquals("No se esta agregando bien al principio", "100", listaSimple.darElemento(listaSimple.darLongitud()-1));
		
		//Caso3 agregar en lista en la mitad
		setUpEscenario2();
		try {
			listaSimple.agregar(50,"100");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("No se esta agregando bien al principio", 101, listaSimple.darLongitud());
		assertEquals("No se esta agregando bien al principio", "100", listaSimple.darElemento(50));
		
		//Caso4 agregar en posicion imposible 
		setUpEscenario2();
		try {
			listaSimple.agregar(-1,"100");
			fail();
		} catch (Exception e) {
		    assertTrue(true);
		}
	}
	

	public void testEliminar(){
	
		//Caso1 eliminar al principio
		setUpEscenario2();
		try {
			listaSimple.eliminar(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("No se esta eliminando bien al principio", 99, listaSimple.darLongitud());
		assertEquals("No se esta eliminando bien al principio", "1", listaSimple.darElemento(0));
		
		//Caso2 eliminar en lista en la mitad
		setUpEscenario2();
		try {
			listaSimple.eliminar(50);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("No se esta eliminando bien al medio", 99, listaSimple.darLongitud());
		assertEquals("No se esta eliminando bien al medio", "51", listaSimple.darElemento(50));
	}
}
