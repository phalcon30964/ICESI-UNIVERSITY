package TADListaDoble;

public interface INodo<T> {

	/**
	 * Retorna contenido del nodo
	 * 
	 * @return T objeto dentro del nodo
	 */
	public T getContenido();

	/**
	 * Cambia el contenido del nodo
	 * 
	 * @param T
	 *            objeto a poner como contenido del nodo
	 */
	public void setContenido(T contenido);

	/**
	 * Retorna nodo siguiente del nodo sobre el que se invoca
	 * 
	 * @return INodo siguiente
	 */
	public INodo<T> getSiguiente();

	/**
	 * Cambia el nodo que sigue en la lista por el pasado por parametro
	 * 
	 * pos: el nodo siguiente ha sido cambiado
	 * 
	 * @param INodo
	 *            nodo a poner como siguiente
	 */
	public void setSiguiente(INodo<T> siguiente);

}
