package TadCola;

public interface ICola<T>{
	
	/**
	 * Metodo que agrega un elemento al final de la cola (back)
	 * 
	 * @param elemento a insertar dentro de la cola
	 */
	public void enQueue(T elemento);
	
	/**
	 *Metodo que elimina el primer elemento de la cola (front) 
	 *
	 * @return T elemento eliminado de la cola
	 */
	public T deQueue() throws Exception;
	
	/**
	 * Metodo que informa si la cola esta vacia
	 * 
	 * @return true si esta vacia, false de lo contrario
	 */
	public boolean isEmpty();
	
	/**
	 * Metodo que limpia la cola de elementos
	 * 
	 * pos:la cola queda sin elementos
	 * 
	 */
	public void clear(); 
	
	/**
	 * Metodo que retorna el primer elemento de la cola
	 * 
	 * @return front primer elemento de la cola
	 */
	public T getFront();
	
	/**
	 * Metodo que retorna el ultimo y mas reciente elemento agregado a la cola
	 * 
	 * @return back elemento mas reciente agregado a la cola
	 */
	public T getBack();

}
