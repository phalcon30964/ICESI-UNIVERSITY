package JList;

public interface IList<T> {
	
	/**
	 * <b> Descripcion: <b> Agrega un elemento a la lista.
	 * @param element elemento que se va agregar a la lista.
	 */
	public void add(T element);
	
	/**
	 * <b> Descripcion: <b> Agrega un elemento al principio de la lista.
	 * @param element elemento que se va agregar a la lista.
	 */
	public void addFirst(T element);
	
	/**
	 * <b> Descripcion: <b> Agrega un elemento al final de la lista.
	 * @param element elemento que se va agregar a la lista.
	 */
	public void addLast(T element);
	
	/**
	 * <b> Descripcion: <b> Agrega un elemento a la lista dada la poscicion.
	 * @param index posicion del elemento que se va agregar a la lista.
	 * @param element elemento que se va a agregar.
	 */
	public void addIndex(int index, T element);
	
	/**
	 * <b> Descripcion: <b> busca un elemento en la lista.
	 * @return el elemento de la lista.
	 */
	public T search(T element);
	
	/**
	 * <b> Descripcion: <b> Elimina el elemento de la lista.
	 * @param element elemento que se va eliminar de la lista.
	 */
	public void remove(T element);
	
	/**
	 * <b> Descripcion: <b> Elimina el primer elemento de la lista..
	 */
	public void removeFirst()throws Exception;
	
	/**
	 * <b> Descripcion: <b> Elimina el ultimo elemento de la lista.
	 */
	public void removeLast();
	
	/**
	 * <b> Descripcion: <b> Elimina el elemento de la lista dada la posicion.
	 * @param index posicion del elemento que se va eliminar de la lista.
	 */
	public void removeIndex(int index);
	
	/**
	 * <b> Descripcion: <b> Convierte el objeto en String.
	 * @return retorna el String del objeto
	 */
	public String toString();
	
	/**
	 * <b> Descripcion: <b> Verifica si la lista esta vacia.
	 * @return true si la lista esta vacia.
	 */
	public boolean isEmpty();
	
	/**
	 * <b> Descripcion: <b>Devuelve el primer elemento de la lista.
	 * @return retorna el primer elemento de la lista.
	 */
	public T getFirst();
	
	/**
	 * <b> Descripcion: <b> Devuelve el ultimo elemento de la lista.
	 * @return retorna el ultimo elemento de la lista.
	 */
	public T getLast();
	/**
	 * <b> Descripcion: <b> Devuelve el tamanio de la lista.
	 * @return int con el tamanio de la lista.
	 */
	public int size();
}