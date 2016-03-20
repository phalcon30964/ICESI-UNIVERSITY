package test;

import junit.framework.TestCase;

import org.junit.Test;

import mundo.Mensaje;



public class testMensaje extends TestCase{
	
	private Mensaje miMensaje;
	
	
	
	
	
	public void setUp1(){
		
		
		
		miMensaje = new Mensaje("Sigue asi", "Leonardo");
		
	}
	
	public void setUp2(){
		
		miMensaje = new Mensaje ("","");
		
		
	}
	
	
	public void setUp3(){
		
		miMensaje = new Mensaje ("Los dias estan contados, preocupate por lo que no has hecho", "Crithian");
	}
	
	
	@Test
	public void testDarMsjMotivacion(){
		setUp1();
		assertEquals("El mensaje de motivacion no está siendo asignado correctamente","Sigue asi",miMensaje.darMsjMotivacion());
		
		setUp2();
		assertEquals("El mensaje de motivacion no está siendo asignado correctamente", "",miMensaje.darMsjMotivacion());
		
		setUp3();
		assertEquals("El mensaje de motivacion no está siendo asignado correctamente","Los dias estan contados, preocupate por lo que no has hecho",miMensaje.darMsjMotivacion());
	}
	@Test
	public void testDarAutor(){
		setUp1();
		assertEquals("El autor no está siendo asignado correctamente","Leonardo",miMensaje.darAutorMsj());
		
		setUp2();
		assertEquals("El autor no está siendo asignado correctamente", "",miMensaje.darAutorMsj());
		
		setUp3();
		assertEquals("El autor no está siendo asignado correctamente","Crithian",miMensaje.darAutorMsj());
	}
	
	
	
}
