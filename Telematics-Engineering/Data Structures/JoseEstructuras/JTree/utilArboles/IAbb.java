package utilArboles;

public interface IAbb<T, K extends Comparable<K>> {
	
	
	 /**
     * Inserta un nuevo elemento en el árbol.
     * 
     * @param T contenido:contenido a insertar, K key: la llave de busqueda 
     * @throws ElementoExisteException Si el elemento a insertar ya se encuentra en el árbol
     */
	public void add(T contenido, K key) throws Exception;
	
	
	 /**
     * Eliminar un elemento del árbol.
     * 
     * @param key: llave del elemento  a eliminar del árbol.
     * @throws ElementoNoExisteException Si el elemento a eliminar no es encontrado en el árbol.
     */
	public void remove(K key) throws Exception;
	

	/**
	 * Busca el elemento cuyo key viene dado como parámetro, en el árbol cuya
	 * raíz es el nodo actual. <br>
	 * <b>pre:</b> modelo!=null. <br>
	 * <b>post:</b> Se retornó el elemento que cumple con el modelo o null si no
	 * encuentra ninguno.
	 * 
	 * @param modelo
	 *            Modelo del elemento que se va a buscar
	 * @return Elemento que cumple con el modelo o null si no encuentra ninguno
	 */
	public T search(K key);

	// PESO
	/**
	 * Retorna el número de elementos del árbol.
	 * 
	 * @return El número de elementos del árbol.
	 */
	public int getWeight();

	// ALTURA
	/**
	 * Retorna la altura del árbol.
	 * 
	 * @return La altura del árbol.
	 */
	public int getHeight();

}
