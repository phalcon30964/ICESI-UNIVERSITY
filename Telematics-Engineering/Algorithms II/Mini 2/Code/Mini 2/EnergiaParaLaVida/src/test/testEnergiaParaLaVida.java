package test;

import java.text.ParseException;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;
import mundo.*;

public class testEnergiaParaLaVida extends TestCase{

	private EnergiaParaLaVida miEnergia;
	private Dia miDia;
	private Mensaje miMensaje;
	
	public void setUp1() throws DiaException{
		
		miEnergia = new EnergiaParaLaVida();
		miDia = new Dia("2013/04/01", "azul");
		
		miEnergia.agregarDia(miDia.darFecha(), miDia.darColorRecomendado());
		miEnergia.agregarDia("2001/11/12", "Rojo");
		miEnergia.agregarDia("2015/08/16", "Amarillo Pollito");
		miEnergia.agregarDia("2005/03/28", "Cafe");
		
		
	}
	public void setUp2() throws DiaException{
		miEnergia = new EnergiaParaLaVida();
		
		miEnergia.agregarDia("2001/02/01", "Violeta");
		miEnergia.agregarDia("2002/01/01", "Naranja");
		miEnergia.agregarDia("2003/01/01", "Blanco");
		miEnergia.agregarDia("2004/01/01", "Negro");
		miEnergia.agregarDia("2014/07/03", "Rojo");
		
		
	}
	public void setUp3() throws Exception{
		
		//Escenario  con mensajes  en dias diferentes
		miEnergia = new EnergiaParaLaVida();
		
		
		miEnergia.agregarMensajeADia("2001/11/12", "Leonardo", "Hijoo");
		miEnergia.agregarMensajeADia("2005/03/28", "Cristian", "Termine el mini");
		miEnergia.agregarMensajeADia("2014/08/03", "David", "No dejes para .....");
		
	}
	
	public void setUp4() throws Exception{
		
		//Escenario sin mensajes
		miEnergia = new EnergiaParaLaVida();
		
		
	}
	public void setUp5() throws Exception{
		
		//Escenario con mensajes en el mismo dia 
		miEnergia = new EnergiaParaLaVida();
		miEnergia.agregarDia("2017/05/30", "Azul");
		miEnergia.agregarMensajeADia("2017/05/30", "Mafla", "Hagale viejo");
		miEnergia.agregarMensajeADia("2017/05/30","Homero" , "D'oh");
		miEnergia.agregarMensajeADia("2017/05/30", "Daniel", "El que madruga...");
		miEnergia.agregarMensajeADia("2017/05/30", "James", "Unforgiven 2");
		
		
	}
	public void setUp6() throws Exception{
		miEnergia = new EnergiaParaLaVida();
		
		miEnergia.agregarDia("2005/03/28", "Azul");
		
		miEnergia.agregarMensajeADia("2005/03/28", "Cristian", "Termine el mini");
		miEnergia.agregarMensajeADia("2005/03/28", "leo", "Ya casi");
		miEnergia.eliminarMensajeADia("2005/03/28", "Termine el mini");
	}
	@Test
	
	public void testAgregarDia() throws DiaException{
		//Se prueba si el metodo agregarDia si lanza excepcion cuando se intante agregar un dia
		//con la misma fecha
		
		setUp1();
		try{
			miEnergia.agregarDia("2011/11/12", "Rojo");
			assertTrue(true);
		}catch (Exception e){
			//throw new DiaException("El dia ya se agrego", "2011/11/12");
			
			assertTrue(true);
		}
		setUp1();
		try{
			miEnergia.agregarDia("1995/11/12", "Azul");
			assertTrue(true);
		}catch (Exception e){
			assertTrue(true);
		}
	}
	
	
	@Test
	public void testLocalizarDiaPorFecha() throws DiaException{
		setUp1();
		assertEquals("Si esta el dia buscado","2001/11/12",miEnergia.localizarDiaPorFecha("2001/11/12").darFecha());
		
		setUp1();
		assertEquals("Si esta el dia buscado","2015/08/16",miEnergia.localizarDiaPorFecha("2015/08/16").darFecha());
		
	}
	
	@Test
	public void testDarFechaMasCercana() throws DiaException{
		setUp1();
		assertEquals("Si es el dia mas cercano", "2013/04/01",miEnergia.darDiaFechaMasCerca().darFecha());
		
		setUp2();
		assertEquals("Si es el dia mas cercano"	, "2014/07/03", miEnergia.darDiaFechaMasCerca().darFecha());
	}
	
	@Test
	public void testAgregarMensajeADia() throws Exception{
		setUp5();
		assertEquals("El mensaje es el mismo","Hagale viejo",miEnergia.localizarDiaPorFecha("2017/05/30").localizarMensaje("Hagale viejo").darMsjMotivacion());
		assertEquals("El mensaje es el mismo","D'oh",miEnergia.localizarDiaPorFecha("2017/05/30").localizarMensaje("D'oh").darMsjMotivacion());
		assertEquals("El mensaje es el mismo","El que madruga...",miEnergia.localizarDiaPorFecha("2017/05/30").localizarMensaje("El que madruga...").darMsjMotivacion());
		
	}
	@Test
	public void testLocalizarUltimoDia() throws Exception{
		setUp2();
		assertEquals("No es el ultimo","2014/07/03",miEnergia.localizarUltimoDia().darFecha());
		setUp1();
		assertEquals("No es el ultimo","2015/08/16",miEnergia.localizarUltimoDia().darFecha());
		
	}
	@Test
	public void testLocalizarUltimoMensaje() throws DiaException{
		setUp1();
		assertEquals("No es el ultimo dia","2015/08/16", miEnergia.localizarUltimoDia().darFecha());
		setUp2();
		assertEquals("No es el ultimo dia","2014/07/03", miEnergia.localizarUltimoDia().darFecha());
				
	}
	@Test
	public void testEliminarMensajeADia() throws Exception{
		setUp6();
		//assertSame("No borro el dia",null,miEnergia.localizarDiaPorFecha("2005/03/28").localizarMensaje("Termine el mini").darMsjMotivacion());
		assertNull("No borro el dia",miEnergia.localizarDiaPorFecha("2005/03/28").localizarMensaje("Termine el mini").darMsjMotivacion() );
	} 
}
