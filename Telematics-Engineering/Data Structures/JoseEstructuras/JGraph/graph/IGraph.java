package graph;

import java.util.ArrayList;

public interface IGraph<V,E> {

	public void agregarVertice(V vertice);

	public void agregarArista(E arista1, E arista2);

	public boolean estaArista(E arista1, E arista2);

	public boolean estaVertice(V vertice);

	public int cantidadVertices();

	public int cantidadAristas();

	public boolean esDirigido();

	public ArrayList<V> listaVertices();

	public ArrayList<E> listaAristas();

	public ArrayList<V> listadoVerticesAdyacentes(V vertice1);

	public boolean hayCamino(V vertice1, V vertice2);

	public boolean conexo();

	public boolean uniliteralmenteConexo();

	public boolean completamenteConexo();

	public boolean aciclico();

	public void recorrerAmplitud(V vertice);

	public void recorrerProfundidad(V vertice);

}
