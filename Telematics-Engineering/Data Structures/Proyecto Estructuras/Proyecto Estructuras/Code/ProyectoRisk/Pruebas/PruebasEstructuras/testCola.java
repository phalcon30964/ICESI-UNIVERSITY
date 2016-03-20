package PruebasEstructuras;

import junit.framework.TestCase;
import TadCola.Cola;

public class testCola extends TestCase {

	private Cola<Integer> cola;
	
	public void setUpEscenario1(){
		cola = new Cola<Integer>();
	}
	
	public void setUpEscenario2(){
		cola = new Cola<Integer>();
		for (int i = 0; i < 10; i++) {
			cola.enQueue(i);
		}
	}
	
	public void testEnQueue() {
		setUpEscenario2();
		assertEquals("No se esta encolando correctamente ",new Integer(0), cola.getFront());
		assertEquals("No se esta encolando correctamente ",new Integer(9), cola.getBack());
	}

	
	public void testDeQueue(){
		setUpEscenario2();
		assertEquals("No se esta desencolando correctamente ",new Integer(0), cola.deQueue());
		assertEquals("No se esta desencolando correctamente ",new Integer(1), cola.getFront());
	}

	
	public void testIsEmpty() {
		setUpEscenario1();
		assertEquals("No se esta detectando bien cuan la cola esta vacia", true, cola.isEmpty());
	}

	
	public void testClear() {
		setUpEscenario2();
		cola.clear();
		assertEquals("No se esta limpiando bien la cola", true, cola.isEmpty());

		
	}

}
