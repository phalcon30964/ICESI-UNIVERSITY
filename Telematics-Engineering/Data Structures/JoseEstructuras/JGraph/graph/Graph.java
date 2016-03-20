package graph;

import java.util.ArrayList;

public class Graph<V,E> implements IGraph<V, E>{
	
	//-------------------------------------------------------
	// CONSTANTES 
	//-------------------------------------------------------
	
	public final static int MAX_VERTICES = 200;
	
	public final static boolean DIRIGIDO = true;
	
	public final static boolean NO_DIRIGIDO = false;
	
	//--------------------------------------------------------
	// Atributos
	//-------------------------------------------------------
	
	private int numeroVertices;
	
	private int numeroAristas;
	
	private boolean dirigido;
	
	private Arista[][] matriz;
	
	//-------------------------------------------------------
	// Constructores
	//-------------------------------------------------------
	
	public Graph(){
		matriz = new Arista[MAX_VERTICES][MAX_VERTICES];
	}
	
	//---------------------------------------------------------
	// Metodos
	//---------------------------------------------------------
	
	@Override
	public void agregarVertice(V vertice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarArista(E arista1, E arista2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaArista(E arista1, E arista2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estaVertice(V vertice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int cantidadVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cantidadAristas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean esDirigido() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<V> listaVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<E> listaAristas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<V> listadoVerticesAdyacentes(V vertice1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hayCamino(V vertice1, V vertice2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean conexo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean uniliteralmenteConexo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean completamenteConexo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean aciclico() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recorrerAmplitud(V vertice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recorrerProfundidad(V vertice) {
		// TODO Auto-generated method stub
		
	}

}
