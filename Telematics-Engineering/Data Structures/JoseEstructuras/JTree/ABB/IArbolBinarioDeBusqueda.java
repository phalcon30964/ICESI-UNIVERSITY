package ABB;

import JList.JSimpleList;

public interface IArbolBinarioDeBusqueda<K extends Comparable<? super K>> {

	/**
	 * Se encarga de crear un Arbol Binario de Busqueda vacio
	 */
	public void crear();

//	/**
//	 * Se encarga de crear un Arbol Binario de Busqueda con un elemnto.
//	 * 
//	 * @param element
//	 *            Es el elmento de tipo T que se va agregar al arbol.
//	 */
//	public void create(K key, T element);

	// create

	/**
	 * Se encarga de saber si el nodo es una hoja
	 * 
	 * @return true si lo es, en caso contrario retorna false
	 */
	public boolean esHoja();

	/**
	 * Elimina un nodo del Arbol Binario de Busqueda
	 * 
	 * @param element
	 *            Elemento que se quiere eliminar
	 */
	public void eliminar(K key) throws Exception;

	/**
	 * Inserta un elemento al Arbol Binario de Busqueda
	 * 
	 * @param element
	 *            Elemento que se quiere aderir al arbol.
	 */
	public void agregar(K key);
	
	/**
	 * Busca un elemnto dado el key
	 * @param key clave del elmento
	 * @return el elemento buscado
	 */
	public T buscar(K key);

	/**
	 * Verifica si el arbol esta vacio.
	 * 
	 * @return true si esta vacio en caso contrario false.
	 */
	public boolean esVacio();

	/**
	 * Es la cantidad de nodos del arbol
	 * 
	 * @return int con la catidad de nodos del arbol
	 */
	public int darLongitud();

	/**
	 * Es la altua del arbol binario.
	 * 
	 * @return int con la altura del arbol.
	 */
	public int darAltura();

	/**
	 * Es el nodo mas pequeño del arbol
	 * @return el nodo mas pequeño del arbol
	 */
	public NodoArbolBinario<K> darMinimo();

	/**
	 * Es el nodo mas grande del arbol
	 * @return el nodo mas grande del arbol
	 */
	public NodoArbolBinario<K> darMaximo();

	/**
	 * 
	 * @return
	 */
	public ListaSimple<K> inorden();

	public ListaSimple<K> postorden();

	public ListaSimple<K> preorden();

}
