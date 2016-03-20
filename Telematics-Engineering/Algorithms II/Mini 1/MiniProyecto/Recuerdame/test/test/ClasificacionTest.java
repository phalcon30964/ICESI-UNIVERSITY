package test;

import java.sql.Date;
import java.util.ArrayList;

import junit.framework.TestCase;

import Mundo.Recuerdame;
import Mundo.Clasificacion;
import Mundo.Tarea;

public class ClasificacionTest extends TestCase {

	private Clasificacion clasificacion;
	private ArrayList <Clasificacion> clasificaciones;
	
	Date fecha= new Date(2014,04,01);
	Date fecha1= new Date(2015,04,01);
	Date fecha2= new Date(2014,07,03);
	

	/**
	 * Crea al Recuerdame con 3 clasificaciones
	 */
	private void setupEscenario1(){

		clasificacion=new Clasificacion("cumpleanos amigos", "los cumpleanos de mis amigos");
		clasificacion.crearTarea("cumple mauro", "", fecha);
	}
	/**
	 * Crea al Recuerdame con 1 clasificacion
	 */
	private void setupEscenario2(){
		clasificacion=new Clasificacion("cumpleanos familia", "los cumpleanos de mi familia");
				
	}
	/**
	 * Crea al Recuerdame con ninguna clasificaciones
	 */
	private void setupEscenario3(){
		clasificacion=new Clasificacion("","");
	}
	/**
	 * Prueba que las tareas se creen <br>
	 * <b> M���todos a probar: </b> buscarTarea, buscarBinarioClasificacion,estaRealizada <br>
	 * <b> Objetivo: </b> Probar que el m���todo marca como realizada o no realizadas las tareas <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al ejecutar el metodo, el atributo realizada de la clase tarea se modifica dependiendo del valor falos o verdadero<br>
	 * 
	 */
	public void testCrearTarea(){
		setupEscenario3();
		
		assertTrue("el metodo crear tarea no esta agregando bien la tarea", clasificacion.crearTarea("organizar", "organizar el cuarto", fecha1));
		assertFalse("��l metodo esta agregadno dos veces la misma tarea en una misma clasificacion",clasificacion.crearTarea("organizar", "organizar el cuarto", fecha1));
		assertEquals("no se agrego bein la tarea","organizar", clasificacion.buscarTarea("organizar").darNombre());
	}
	public void testEliminarTarea(){
		setupEscenario1();
		
		assertTrue("no se esta eliminan la tarea", clasificacion.eliminarTarea(clasificacion.buscarTarea("cumple mauro")));
		
		
	}
	public void testMarcarRealizada(){
		setupEscenario1();
		
		clasificacion.marcarRealizada("cumple mauro");
		assertTrue("no se esta marcando como realizada la tarea", clasificacion.buscarTarea("cumple mauro").estaRealizada());
	}
	
	
}
		


