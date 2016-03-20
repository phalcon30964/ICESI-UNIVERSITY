package TadGrafo;

import TadLista.ListaDoble;

public interface IGrafo<T> {
	
	public void agregarVertice(T vertice)throws Exception;
	
	public void agregarArista(int peso, T vertice1, T vertice2)throws Exception;
	
	public boolean existeVertice(T vertice);
	
	public boolean existeArista(int peso, T vertice1, T vertice2);
	
	public int getNumVertices();
	
	public int getNumAristas();
	
	public boolean isDirigido();
	
	public ListaDoble<T> getVertices();
	
	public ListaDoble<Arista<T>> getAristas();
	
	public ListaDoble<T> getAdyacentes(T vertice);
	
	public ListaDoble<T> getCamino(T vertice1, T vertice2);
	
	public boolean isConexo();
	
	public boolean isUnilateralmenteConexo();
	
	public boolean isCompletamenteConexo();
	
	public boolean isAciclico();
	
	public ListaDoble<T> recorridoAmplitud(T vertice);
	
	public ListaDoble<T> recorridoProfundidad(T vertice);
	
}
