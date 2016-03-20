package test;

import junit.framework.TestCase;

import org.junit.Test;

import mundo.Dia;
import mundo.Mensaje;

public class testDia extends TestCase{

	private Dia miDia;
	private Mensaje miMensaje;
	
	
	
	
	
	public void setUp1() throws Exception{
		
		miDia = new Dia("2014/12/21", "Azul");
		miDia.agregarMensaje("Hijoo", "Leo");
		miDia.agregarMensaje("Fornicaras", "Leo");
		miDia.agregarMensaje("Seguridad mato a confianza", "David");
		
		
	}
	public void setUp2(){
		
		miDia = new Dia("2011/08/01", "Naranja");
		miDia = new Dia("2012/08/01", "Rosa");
		miDia = new Dia("2013/08/01", "Violeta");
		miDia = new Dia("2014/08/01", "Agua Marina");
		miDia = new Dia("2012/08/01", "Blanco");
	}
	public void setUp3(){
		
		miDia = new Dia("2000/5/21", "Rosa");
	}
	
	@Test
	public void testDarFecha() throws Exception{
		setUp1();
		assertEquals("La fecha del dia ha sido asignado correctamente","2014/12/21",miDia.darFecha());
	
		setUp3();
		assertEquals("La fecha del dia ha sido asignado correctamente","2000/5/21",miDia.darFecha());
		
	}
	@Test
	public void testAgregarMensaje() throws Exception{
		setUp1();
		assertEquals("NO Agrego el mensaje","Hijoo",miDia.localizarMensaje("Hijoo").darMsjMotivacion());
		assertEquals("NO Agrego el mensaje","Fornicaras",miDia.localizarMensaje("Fornicaras").darMsjMotivacion());
		assertEquals("NO Agrego el mensaje","Seguridad mato a confianza",miDia.localizarMensaje("Seguridad mato a confianza").darMsjMotivacion());
	}
	@Test
	public void testLocalizarUltimoMensaje() throws Exception{
		
		setUp1();
		assertEquals("NO es el ultimo dia","Seguridad mato a confianza",miDia.localizarMensaje("Seguridad mato a confianza").darMsjMotivacion());
	}
	@Test
	public void testEliminarMensaje() throws Exception{
		setUp1();
		miDia.eliminarMensaje("Fornicaras");
		miDia.eliminarMensaje("Seguridad mato a confianza");
		assertNull("NO borro el mensaje",miDia.localizarMensaje("Fornicaras") );
		assertNull("NO borro el mensaje",miDia.localizarMensaje("Seguridad mato a confianza"));
	}
	@Test 
	public void testLocalizarMensaje() throws Exception{
		setUp1();
		assertEquals("No es el mensaje buscado","Fornicaras",miDia.localizarMensaje("Fornicaras").darMsjMotivacion());
		assertEquals("No es el mensaje buscado","Seguridad mato a confianza",miDia.localizarMensaje("Seguridad mato a confianza").darMsjMotivacion());

	}
}
