package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ColaPrioridad.ColaPrioridad;

public class TestColaPrioridad {

	@Test
	public void testConstructor() {
		//prueba que el contructor, cree una cola vacía
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		assertEquals("La cola de prioridad no está vacía", "---", colap.print());
	}
	@Test
	public void testClear() {
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.clear();
		assertEquals("La cola de prioridad no está vacía", "---", colap.print());
	}
	
	@Test
	public void enQueue1() {
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.enQueue( 1, "a");
		assertEquals("el método falla cuando la cola estña vacía", "a ---", colap.print());
	}
	@Test
	public void enQueue2() {
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.enQueue(10, "a");
		colap.enQueue(15, "b");
		colap.enQueue(1, "c");
		
		assertEquals("el método falla cuando la cola no está vacía y el valor a ingresar tiene la menor prioridad", 
				"c a b ---", colap.print());
	}
	@Test
	public void enQueue3() {
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.enQueue(10, "a");
		colap.enQueue(15, "b");
		colap.enQueue(20, "c");
		
		assertEquals("el método falla cuando la cola no está vacía y el valor a ingresar tiene la mayor prioridad", 
				"a b c ---", colap.print());
	}
	@Test
	public void enQueue4() {
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.enQueue(10, "a");
		colap.enQueue(15, "b");
		colap.enQueue(20, "c");
		colap.enQueue(13, "d");
		colap.enQueue(17, "e");
		
		assertEquals("el método falla cuando la cola no está vacía y la prioridad no es lamayor ni la menor", 
				"a d b e c ---", colap.print());
	}
	@Test
	public void deQueue1() {
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.enQueue(10, "a");
		colap.enQueue(15, "b");
		colap.enQueue(20, "c");
		colap.enQueue(13, "d");
		colap.enQueue(17, "e");
		
		assertEquals("el método falla cuando la cola no está vacía y la prioridad no es lamayor ni la menor", 
				"a d b e c ---", colap.print());
	}
	@Test
	public void enQueue5(){
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.enQueue(10, "a");
		colap.enQueue(15, "b");
		colap.enQueue(20, "c");
		colap.enQueue(25, "d");
		colap.enQueue(30, "e");
		
		colap.enQueue(10, "a.1");
		colap.enQueue(10, "a.2");
		colap.enQueue(10, "a.3");
		
		assertEquals("el método enQueue falla cuando se insertan elementos\n"
				+ "con igual prioridad en la primera posicion de la cola ", "a a.1 a.2 a.3 --b c d e ---", colap.print());
		assertEquals("el método enQueue falla cuando se insertan elementos\n"
				+ "con igual prioridad en la primera posicion de la cola ", "e d c b a.3 a.2 a.1 --a ---", colap.printback());

		
		
	}
	@Test
	public void enQueue6(){
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.enQueue(10, "a");
		colap.enQueue(15, "b");
		colap.enQueue(20, "c");
		colap.enQueue(25, "d");
		colap.enQueue(30, "e");
		
		colap.enQueue(30, "e.1");
		colap.enQueue(30, "e.2");
		colap.enQueue(30, "e.3");
		
		assertEquals("el método enQueue falla cuando se insertan elementos\n"
				+ "con igual prioridad al final de la cola ", "a b c d e e.1 e.2 e.3 -----", colap.print());
		assertEquals("el método enQueue falla cuando se insertan elementos\n"
				+ "con igual prioridad al final de la cola", "e.3 e.2 e.1 --e d c b a ---", colap.printback());

		
	}
	@Test
	public void enQueue7(){
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.enQueue(10, "a");
		colap.enQueue(15, "b");
		colap.enQueue(20, "c");
		colap.enQueue(25, "d");
		colap.enQueue(30, "e");
		
		colap.enQueue(20, "c.1");
		colap.enQueue(20, "c.2");
		colap.enQueue(20, "c.3");
		
		assertEquals("el método enQueue falla cuando se insertan elementos\n"
				+ "con igual prioridad ", "a b c c.1 c.2 c.3 --d e ---", colap.print());
		assertEquals("el método enQueue falla cuando se insertan elementos\n"
				+ "con igual prioridad  ", "e d c.3 c.2 c.1 --c b a ---", colap.printback());
		
	}
	@Test
	public void deQueue2(){
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.enQueue(10, "a");
		colap.enQueue(15, "b");
		colap.enQueue(20, "c");
		colap.enQueue(25, "d");
		colap.enQueue(30, "e");
		
		colap.enQueue(10, "a.1");
		colap.enQueue(10, "a.2");
		colap.enQueue(10, "a.3");
		
		colap.deQueue();
		
		assertEquals("el método deQueue falla cuando hay nodos con igual prioridad",
				"a.1 a.2 a.3 --b c d e ---", colap.print());
		assertEquals("el método deQueue falla cuando hay nodos con igual prioridad",
				"e d c b a.3 a.2 --a.1 ---", colap.printback());
		colap.deQueue();
		colap.deQueue();
		colap.deQueue();
		assertEquals("el método deQueue falla cuando hay nodos con igual prioridad",
				"b c d e ---", colap.print());
		assertEquals("el método deQueue falla cuando hay nodos con igual prioridad",
				"e d c b ---", colap.printback());
		
		
	}
	@Test
	public void metodos(){
		ColaPrioridad<String> colap= new ColaPrioridad<String>();
		colap.enQueue(10, "a");
		colap.enQueue(15, "b");
		colap.enQueue(20, "c");
		colap.enQueue(25, "d");
		colap.enQueue(30, "e");
		
		
		assertEquals("el método getFront falla", "a", colap.getFront());
		assertEquals("el método getFront back", "e", colap.getBack());
		assertEquals("el método print falla", "a b c d e ---", colap.print());
		assertEquals("el método printback falla", "e d c b a ---", colap.printback());

	}

}
