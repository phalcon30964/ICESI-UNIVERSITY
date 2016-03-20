package PruebasEstructuras;

import junit.framework.TestCase;
import TadPila.Pila;

public class testPila extends TestCase{

	private Pila<Integer> pila;
	
	public void setUpEscenario1(){
		//pila vacia
		pila = new Pila<Integer>();
	}
	
	public void setUpEscenario2(){
		//pila llena
		pila = new Pila<Integer>();
		for (int i = 0; i < 100; i++) {
			pila.push(i);
		}
	}
	
	public void setUpEscenario3(){
		//pila llena
		pila = new Pila<Integer>();
		for (int i = 1; i < 4; i++) {
			pila.push(i);
		}
		
	}
	
	public void testPush() {
		setUpEscenario2();
		//caso 1 agrega bien
		try {
			assertEquals("No se esta agregando correctamente los elementos" , new Integer(99), pila.pop());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void  testPop(){
		//caso 1 tira excepcion cuando la pila esta vacia
		setUpEscenario1();
		try {
			pila.pop();
			fail("No se esta tirando excepcion cuando la pila esta vacia y se intenta hacer pop");
		} catch (Exception e) {
			assertTrue(true);
		}
		
		//caso 2 debe revolver correctamente los elementos
		setUpEscenario2();
		try {
			pila.pop();
			assertEquals("No esta eliminando bien los elementos" , new Integer(98), pila.peek());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void testIsEmpty() {
		
		setUpEscenario1();
		assertEquals("No se comprueba bien si la pila esta vacia", true, pila.isEmpty());
		
	}

	public void testClear() {
		
		setUpEscenario2();
		pila.clear();
		assertEquals("No se limpia bien la pila",true, pila.isEmpty());
	}
	
	public void testPopFirst(){
		
		setUpEscenario3();
		
		pila.popFirst();
		try {
			pila.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(new Integer(2), pila.peek());
		
		try {
			pila.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals("Elimina bien el primero",true, pila.isEmpty());
	
	}

}
