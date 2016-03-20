package test;

import java.sql.Date;
import java.util.ArrayList;

import junit.framework.TestCase;

import Mundo.Recuerdame;
import Mundo.Clasificacion;
import Mundo.Tarea;

public class RecuerdameTest extends TestCase {

	private Recuerdame recuerdame;
	private ArrayList <Clasificacion> clasificaciones;
	
	
	String fecha= "20140401";
	String fecha1= "20150401";
	String fecha2= "20180401";

	/**
	 * Crea al Recuerdame con 3 clasificaciones
	 */
	private void setupEscenario1(){

		recuerdame=new Recuerdame();

		//fecha de recordatorio	



		recuerdame.crearClasificacion("Universidad", "trabajos de la universidad");
		recuerdame.crearClasificacion("familia","deberes de la casa");
		recuerdame.crearClasificacion("trabajo","");

		// se crean las tareas 3 por cada clasificacion

		//tareas universidad
		recuerdame.anadirTarea("pagar", "pagar la cuenta de impresion", fecha, "universidad");
		recuerdame.anadirTarea("imprimir", "lectura de fundamentos", fecha1, "universidad");
		recuerdame.anadirTarea("taller calculo", "ecuaciones lineales", fecha2, "universidad");

		//tareas trabajo
		recuerdame.anadirTarea("llamar al jefe", "citar a pablo a reunion", fecha, "trabajo");
		recuerdame.anadirTarea("terminar propuesta", "terminar el proyecto de telmex", fecha1, "trabajo");
		recuerdame.anadirTarea("enviar un mail", "", fecha2, "trabajo");

		//tareas familia
		recuerdame.anadirTarea("pagar recibos luz", "pagar los recibos de la luz y el gas", fecha, "familia");
		recuerdame.anadirTarea("comprar juguetes david", "comprar los juguetes de navidad para david", fecha1, "familia");
		recuerdame.anadirTarea("mercar", "comprar el mercado del mes", fecha2, "familia");

//		//realizar tareas universida
//		recuerdame.realizarTarea("universidad", "pagar");
//		recuerdame.realizarTarea("universidad", "imprimir");
//		recuerdame.realizarTarea("universidad", "taller calculo");
//
//		//realizar trabajo
//		recuerdame.realizarTarea("trabajo", "llamar al jefe");
//		recuerdame.realizarTarea("trabajo", "terminar propuesta");
//		recuerdame.realizarTarea("trabajo", "enviar un mail");
//
//		//realizar familia
//		recuerdame.realizarTarea("familia", "pagar recibos luz");
//		recuerdame.realizarTarea("familia", "comprar juguetes david");
//		recuerdame.realizarTarea("familia", "mercar");

	}
	
	/**
	 * crea al recuerdame vacio
	 */
	private void setupEscenario2(){
		recuerdame= new Recuerdame();
	}
	/**
	 * Crea al recuerdame con 3 clasificaciones y
	 */
	private void setupEscenario3(){

		recuerdame =new Recuerdame();

		//se crean 3 clasificaciones
		recuerdame.crearClasificacion("junio", "las tareas del mes de junio");
		recuerdame.crearClasificacion("julio", "las tareas dek mes de julio");
		recuerdame.crearClasificacion("enero", "las tareas del mes de enero");


		//se crean las clasificaciones con cadena vacia



	}
	
	/**
	 * escenario 4
	 */
	private void setupEscenario4(){
		recuerdame= new Recuerdame();
		
		//crea 3 clasificaciones
		recuerdame.crearClasificacion("colombia", "proyectos en Colombia");
		recuerdame.crearClasificacion("venezuela", "proyectos en Venezuela");
		recuerdame.crearClasificacion("peru", "proyectos en Peru");
		//crea 2 tareas por clasificacion
		//colombia
		recuerdame.anadirTarea("Cali", "obras de cali", fecha, "colombia");
		recuerdame.anadirTarea("bogota", "obras de bogota", fecha1, "colombia");
		//venezuela
		recuerdame.anadirTarea("caracas", "obras de caracas", fecha, "venezuela");
		recuerdame.anadirTarea("maracaibo", "obras de maracaibo", fecha1, "venezuela");
		//peru
		recuerdame.anadirTarea("lima", "obras de lima", fecha, "peru");
		recuerdame.anadirTarea("chimbote", "obras de chimbote", fecha1, "peru");
		
		//realizar tareas universida
				recuerdame.realizarTarea("venezuela", "caracas");
				recuerdame.realizarTarea("venezuela", "maracaibo");
				//recuerdame.realizarTarea("colombia", "taller calculo");

				//realizar trabajo
				recuerdame.realizarTarea("colombia", "Cali");
				recuerdame.realizarTarea("colombia", "bogota");
				//recuerdame.realizarTarea("trabajo", "enviar un mail");

				//realizar familia
				recuerdame.realizarTarea("peru", "lima");
				recuerdame.realizarTarea("peru", "chimbote");
				//recuerdame.realizarTarea("familia", "mercar");


	}
	
	
	
	/**
	 * Prueba la adicion correcta de clasificaciones <br>
	 * <b> M���todos a probar: </b> crearClasificacion, darNombre<br>
	 * crearClasificacion, buscarBinarioClasificaci��n. <br>
	 * <b> Objetivo: </b> Probar que el m���todo crearClasificacion es capaz de crear clasificaciones  <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al crear las clasificaciones el metodo retorna true<br>
	 * 2. Al buscar una clasificacion previamente agregada ���sta debe ser encontrada.
	 * 3. Al intentar crear una clasificacion existente no la debe crear <br>
	 * 
	 */
	public void testCrearClasificacion(){
		setupEscenario2();
		//verificacimos que el el metodo que crea la clasificacion retorne siempre true
		assertTrue("No se cre�� correctamente la clasificacion", recuerdame.crearClasificacion("fabrica","tareas de la fabrica"));
		assertTrue("No se cre�� correctamente la clasificacion",recuerdame.crearClasificacion("maestria","tareas de la maestria"));
		assertTrue("No se cre�� correctamente la clasificacion",recuerdame.crearClasificacion("casa",""));


		// Realiza la b��squeda de clasificaciones
		assertEquals("no busca correctamente las clasificaciones","fabrica" ,(recuerdame.buscarBinarioClasificacion("fabrica")).darNombre());
		assertEquals("no busca correctamente las clasificaciones","maestria" ,(recuerdame.buscarBinarioClasificacion("maestria")).darNombre());
		assertEquals("no busca correctamente las clasificaciones","casa" ,(recuerdame.buscarBinarioClasificacion("casa")).darNombre());


		//Intenta crear una clasificacion que ya existe
		assertFalse("Se est��n creando m��s de una clasificacion con el mismo nombre", recuerdame.crearClasificacion("fabrica","trabajos de la fabrica"));
		assertFalse("Se est��n creando m��s de una clasificacion con el mismo nombre", recuerdame.crearClasificacion("maestria","trabajos de la universidad"));
		assertFalse("Se est��n creando m��s de una clasificacion con el mismo nombre", recuerdame.crearClasificacion("casa",""));



	}
	/**
	 * Prueba la adicion correcta de las tareas <br>
	 * <b> M���todos a probar: </b> buscarBinarioClasificacion, anadirTarea, buscarTarea, darNombre<br>
	 * anadirtarea, buscarBinarioClasificaci��n. <br>
	 * <b> Objetivo: </b> Probar que el m���todo anadirTarea es capaz de anadir tareas <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al crear una tarea  el metodo retorna true<br>
	 * 2. Al buscar una tarea previamente agregada ���sta debe ser encontrada.
	 * 3. Al intentar crear una tarea existente no la debe crear <br>
	 * 
	 */

	public void testAnadirTarea(){
		setupEscenario3();



		// verifica que se el metodo que anade tareas correctamente

		//tareas julio

		assertTrue("El metodo anadirTare no esta anadiendo bien las tareas",recuerdame.anadirTarea("pagar", "pagar la matricula de la universidad ",fecha, "julio"));
		assertTrue("El metodo anadirTare no esta anadiendo bien las tareas",recuerdame.anadirTarea("estudiar", "parcial de calculo ", fecha1, "julio"));
		assertTrue("El metodo anadirTare no esta anadiendo bien las tareas",recuerdame.anadirTarea("devolver libro", "devolver libro de algoritmos a la biblioteca ", fecha2, "julio"));

		//tareas junio
		assertTrue("El metodo anadirTare no esta anadiendo bien las tareas",recuerdame.anadirTarea("llamar a pablo", "citar a pablo a reunion", fecha, "junio"));
		assertTrue("El metodo anadirTare no esta anadiendo bien las tareas",recuerdame.anadirTarea("terminar proyecto", "terminar el proyecto de telmex" , fecha1, "junio"));
		assertTrue("El metodo anadirTare no esta anadiendo bien las tareas",recuerdame.anadirTarea("enviar documentos", "", fecha2, "junio"));

		//tareas enero
		assertTrue("El metodo anadirTare no esta anadiendo bien las tareas",recuerdame.anadirTarea("pagar recibos", "pagar los recibos de la luz y el gas", fecha, "enero"));
		assertTrue("El metodo anadirTare no esta anadiendo bien las tareas",recuerdame.anadirTarea("comprar juguetes", "comprar los juguetes de navidad ", fecha1, "enero"));
		assertTrue("El metodo anadirTare no esta anadiendo bien las tareas",recuerdame.anadirTarea("comida toby", "comprar la comida del perro", fecha2, "enero"));





		//Verifica que no haya mas de una tarea con el mismo nombre 
		//tareas julio
		assertFalse("se esta creando una tarea que ya existe", recuerdame.anadirTarea("pagar", "pagar la matricula de la universidad ", fecha, "julio"));
		assertFalse("se esta creando una tarea que ya existe",recuerdame.anadirTarea("estudiar", "parcial de calculo ", fecha1, "julio"));
		assertFalse("se esta creando una tarea que ya existe",recuerdame.anadirTarea("devolver libro", "devolver libro de algoritmos a la biblioteca ", fecha2, "julio"));

		//tareas junio
		assertFalse("esta anadiendo mas de una tarea",recuerdame.anadirTarea("llamar a pablo", "citar a pablo a reunion", fecha, "junio"));
		assertFalse("esta anadiendo mas de una tarea",recuerdame.anadirTarea("terminar proyecto", "terminar el proyecto de telmex" , fecha1, "junio"));
		assertFalse("esta anadiendo mas de una tarea",recuerdame.anadirTarea("enviar documentos", "", fecha2, "junio"));

		//tareas enero
		assertFalse("esta anadiendo mas de una tarea",recuerdame.anadirTarea("pagar recibos", "pagar los recibos de la luz y el gas", fecha, "enero"));
		assertFalse("esta anadiendo mas de una tarea",recuerdame.anadirTarea("comprar juguetes", "comprar los juguetes de navidad ", fecha1, "enero"));
		assertFalse("esta anadiendo mas de una tarea",recuerdame.anadirTarea("comida toby", "comprar la comida del perro", fecha2, "enero"));


		//busca la tarea 
		//tareas julio
		assertEquals("no busca la tarea correctamente","pagar", recuerdame.buscarBinarioClasificacion("julio").buscarTarea("pagar").darNombre());
		assertEquals("no busca la tarea correctamente","estudiar", recuerdame.buscarBinarioClasificacion("julio").buscarTarea("estudiar").darNombre());
		assertEquals("no busca la tarea correctamente","devolver libro", recuerdame.buscarBinarioClasificacion("julio").buscarTarea("devolver libro").darNombre());

		assertEquals("no busca la tarea correctamente","llamar a pablo", recuerdame.buscarBinarioClasificacion("junio").buscarTarea("llamar a pablo").darNombre());
		assertEquals("no busca la tarea correctamente","terminar proyecto", recuerdame.buscarBinarioClasificacion("junio").buscarTarea("terminar proyecto").darNombre());
		assertEquals("no busca la tarea correctamente","enviar documentos", recuerdame.buscarBinarioClasificacion("junio").buscarTarea("enviar documentos").darNombre());

		assertEquals("no busca la tarea correctamente","pagar recibos", recuerdame.buscarBinarioClasificacion("enero").buscarTarea("pagar recibos").darNombre());
		assertEquals("no busca la tarea correctamente","comprar juguetes", recuerdame.buscarBinarioClasificacion("enero").buscarTarea("comprar juguetes").darNombre());
		assertEquals("no busca la tarea correctamente","comida toby", recuerdame.buscarBinarioClasificacion("enero").buscarTarea("comida toby").darNombre());



	}
	
	/**
	 * Prueba que las tareas se marquen como realizadas o no realizadas <br>
	 * <b> M���todos a probar: </b> buscarTarea, buscarBinarioClasificacion,estaRealizada <br>
	 * <b> Objetivo: </b> Probar que el m���todo marca como realizada o no realizadas las tareas <br>
	 * <b> Resultados esperados: </b> <br>
	 * 1. Al ejecutar el metodo, el atributo realizada de la clase tarea se modifica dependiendo del valor falos o verdadero<br>
	 * 
	 */

	public void testRealizarTarea(){
		
		setupEscenario4();



		
		//tareas colombia
				assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("colombia").buscarTarea("Cali").estaRealizada());
				assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("colombia").buscarTarea("bogota").estaRealizada());
				

				//tareas venezuela
				assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("venezuela").buscarTarea("caracas").estaRealizada());
				assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("venezuela").buscarTarea("maracaibo").estaRealizada());
				

				//tareas peru
				assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("peru").buscarTarea("lima").estaRealizada());
				assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("peru").buscarTarea("chimbote").estaRealizada());
				


//		//tareas universidad
//		assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("Universidad").buscarTarea("pagar").estaRealizada());
//		assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("Universidad").buscarTarea("imprimir").estaRealizada());
//		assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("Universidad").buscarTarea("taller calculo").estaRealizada());
//
//		//tareas trabajo
//		assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("trabajo").buscarTarea("llamar al jefe").estaRealizada());
//		assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("trabajo").buscarTarea("terminar propuesta").estaRealizada());
//		assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("trabajo").buscarTarea("enviar un mail").estaRealizada());
//
//		//tareas familia
//		assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("familia").buscarTarea("pagar recibos luz").estaRealizada());
//		assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("familia").buscarTarea("comprar juguetes david").estaRealizada());
//		assertTrue("no se ejecuta correctamente el metodo de realizar tarea",recuerdame.buscarBinarioClasificacion("familia").buscarTarea("mercar").estaRealizada());


	}


	public void testEliminarTarea(){
		
		
		setupEscenario4();
//		recuerdame.crearClasificacion("Universidad", "trabajos de la universidad");
//		recuerdame.crearClasificacion("familia","deberes de la casa");
//		recuerdame.crearClasificacion("trabajo","");

//		// se crean las tareas 3 por cada clasificacion
//
//		//tareas universidad
//		recuerdame.anadirTarea("pagar", "pagar la cuenta de impresion", fecha, "universidad");
//		recuerdame.anadirTarea("imprimir", "lectura de fundamentos", fecha1, "universidad");
//		recuerdame.anadirTarea("taller calculo", "ecuaciones lineales", fecha2, "universidad");
//
//		//tareas trabajo
//		recuerdame.anadirTarea("llamar al jefe", "citar a pablo a reunion", fecha, "trabajo");
//		recuerdame.anadirTarea("terminar propuesta", "terminar el proyecto de telmex", fecha1, "trabajo");
//		recuerdame.anadirTarea("enviar un mail", "", fecha2, "trabajo");
//
//		//tareas familia
//		recuerdame.anadirTarea("pagar recibos luz", "pagar los recibos de la luz y el gas", fecha, "familia");
//		recuerdame.anadirTarea("comprar juguetes david", "comprar los juguetes de navidad para david", fecha1, "familia");
//		recuerdame.anadirTarea("mercar", "comprar el mercado del mes", fecha2, "familia");
//
//		//realizar tareas universida
//		recuerdame.realizarTarea("universidad", "pagar");
//		recuerdame.realizarTarea("universidad", "imprimir");
//		recuerdame.realizarTarea("universidad", "taller calculo");
//
//		//realizar trabajo
//		recuerdame.realizarTarea("trabajo", "llamar al jefe");
//		recuerdame.realizarTarea("trabajo", "terminar propuesta");
//		recuerdame.realizarTarea("trabajo", "enviar un mail");
//
//		//realizar familia
//		recuerdame.realizarTarea("familia", "pagar recibos luz");
//		recuerdame.realizarTarea("familia", "comprar juguetes david");
//		recuerdame.realizarTarea("familia", "mercar");
//


		//Verifica que el metodo que Elimina las tareas funcione correctamente

		//tareas universidad
		assertTrue("no se elimino corectamente la tarea",recuerdame.eliminarTarea("Colombia",recuerdame.buscarBinarioClasificacion("colombia").buscarTarea("cali")));
		
//		//tareas trabajo
//		assertTrue("no se elimino corectamente la tarea",recuerdame.eliminarTarea("trabajo",recuerdame.buscarBinarioClasificacion("trabajo").buscarTarea("llamar al jefe")));
//		assertTrue("no se elimino corectamente la tarea",recuerdame.eliminarTarea("trabajo",recuerdame.buscarBinarioClasificacion("trabajo").buscarTarea("terminar propuesta")));
//		assertTrue("no se elimino corectamente la tarea",recuerdame.eliminarTarea("trabajo",recuerdame.buscarBinarioClasificacion("trabajo").buscarTarea("enviar un mail")));
//
//		//tareas familia
//		assertTrue("no se elimino corectamente la tarea",recuerdame.eliminarTarea("familia",recuerdame.buscarBinarioClasificacion("familia").buscarTarea("pagar recibos luz")));
//		assertTrue("no se elimino corectamente la tarea",recuerdame.eliminarTarea("familia",recuerdame.buscarBinarioClasificacion("familia").buscarTarea("comprar juguetes david")));
//		assertTrue("no se elimino corectamente la tarea",recuerdame.eliminarTarea("familia",recuerdame.buscarBinarioClasificacion("familia").buscarTarea("mercar")));

		//Verifica que se hayan elimado todas las tareas
		//assertTrue("no se borraron correctamente las tareas",recuerdame.darTodasLasTareas().size()==0);
	}



}



