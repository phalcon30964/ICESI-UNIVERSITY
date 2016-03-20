package PruebasEstructuras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import junit.framework.TestCase;
import TadGrafo.GrafoLista;

public class testGrafo extends TestCase{
	
	private GrafoLista<String> grafo;
	
	public void setUpEscenario1(){
		grafo = new GrafoLista<String>(true);
	}
	
	public void setUpEscenario2(){
		grafo = new GrafoLista<String>(true);
		for (int i = 0; i < 4; i++) {
			try {
				grafo.agregarVertice(i+"");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void setUpEscenario3(){
		grafo = new GrafoLista<String>(true);
		for (int i = 0; i < 4; i++) {
			try {
				grafo.agregarVertice(i+"");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			grafo.agregarArista(0, 0+"", 1+"");
			grafo.agregarArista(0, 1+"", 2+"");
			grafo.agregarArista(0, 2+"", 3+"");
			grafo.agregarArista(0, 1+"", 3+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testAgregarVertice(){
		setUpEscenario2();
		for (int j = 0; j < 4; j++) {
			assertEquals(" No se agregar vertices",j+"",grafo.getVertice(j));
		}
	}
		 
	public void testAgregarArista(){
		setUpEscenario1();
		try {
			grafo.agregarArista(0, 0+"", 1+"");
			grafo.agregarArista(0, 1+"", 2+"");
			grafo.agregarArista(0, 2+"", 3+"");
		} catch (Exception e) {
		}
	}
	
	public void testEliminarVertice(){
		setUpEscenario2();
		
		grafo.eliminarVertice(0+"");
		assertTrue("No se eliminan vertices",grafo.getVertice(0)!=(0+"")); 
	}
	
	public void testEliminarArista(){
		setUpEscenario3();
		grafo.eliminarArista(0, 0+"", 1+"");
		assertTrue("No se eliminando bien arista",grafo.getArista(0+"", 1+"")==null);
		

	}
}
