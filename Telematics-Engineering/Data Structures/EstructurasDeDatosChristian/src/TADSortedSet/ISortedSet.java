package TADSortedSet;

public interface ISortedSet<T extends Comparable<T>> {
	
	/**
	 * Metodo que permite agregar un elemento al conjunto ordenado, si el elemento ya existe entonces no se añade
	 * 
	 * pos: Se ha agregado un nuevo elemento al conjunto ordenado, y 
	 *      ha quedado despues del elemento menor mas cercano a el ya existente en el conjunto
	 * 
	 * @param e elemento a agregar
	 * @throws exception si el elemento que se intenta agregar ya existe en el conjunto
	 */
	public void add(T e) throws Exception;
	
	/**
	 * Metodo que permite eliminar un elemento del conjunto ordenado
	 * 
	 * pos: Se ha eliminado un elemento del conjunto y su longitud a disminuido en 1
	 * 
	 * @param e elemento a eliminar
	 * @throws exception si el conjunto es vacio 
	 * @throws exception si el elemento a eliminar no existe en el conjunto 
	 */
	public void remove(T e) throws Exception;
	
	/**
	 * Metodo que permie verrificar si un elemento pertenece al conjunto ordenado
	 * 
	 * @return boolean false si el conjunto es vacio, o si el elemento no pertenece al conjunto.
	 *                 true si el elemento pertenece al conjunto
	 */
	public boolean isElement(T e);
	
	/**
	 * Metodo que permite genera un string con el toString de todos los elementos del conjunto
	 * 
	 * @param elemento a verificar si esta dentro del conjunto
	 * @return String con el toString de los objetos guardados en el conjunto, vacio si no hay elementos
	 * 
	 */
	public String  getSet();
	
	/**
	 * Metodo que genera un SortedSet con los elementos en comun del SortedSet pasado por parmetro y 
	 * los elementos del conjunto sobre el cual se invoca el metodo
	 * 
	 * @param s2 SortedSet a intersectar 
	 * @return SortedSet con los elementos en comun del conjunto y el sortedset pasado por parametro
	 */
	public SortedSet<T> intersection (SortedSet<T> s2);
	
	/**
	 * Metodo que genera un SortedSet con los elementos del SortedSet pasado por parmetro y 
	 * los elementos del conjunto sobre el cual se invoca el metodo
	 * 
	 * @param s2 SortedSet a unir 
	 * @return SortedSet con los elementos del conjunto y el sortedset pasado por parametro
	 */
	public SortedSet<T> union(SortedSet<T> s2);

}
