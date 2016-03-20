package test;
import static org.junit.Assert.*;

import ColaPrioridad.*;

import org.junit.Test;

import ColaPrioridad.NodoPrioridad;


public class TestNodoPrioridad {

	@Test
	public void testNodoP() {
		NodoPrioridad<String> nuevo= new NodoPrioridad<String>(20, "prueba");
		assertEquals("Se inicializó el contenido del nodo incorrectamente", "prueba", nuevo.getContenido());
		assertEquals("Se inicializó la prioridad del nodo incorrectamente", 20, nuevo.getPrioridad());
		assertEquals("Se inicializó el siguiente del nodo incorrectamente", null, nuevo.getSiguiente());
		assertEquals("Se inicializó el anterior del nodo incorrectamente", null, nuevo.getAnterior());
		assertEquals("Se inicializó la cola del nodo incorrectamente", true, nuevo.getCola().isEmpty());
	}
	
	@Test
	public void testEncolar(){
		NodoPrioridad<String> nuevo= new NodoPrioridad<String>(20, "prueba");
		nuevo.encolar("a");
		nuevo.encolar("b");
		nuevo.encolar("c");
		assertEquals("el método encolar funciona incorrectamente", "a b c --", nuevo.getCola().print());
	}

}
