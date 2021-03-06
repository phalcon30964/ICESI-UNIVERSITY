package TadCola;

import TadLista.ListaDoble;

public class Cola<T> implements ICola<T>{
	
	// ----------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------
	
	protected ListaDoble<T> cola;

	// ----------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------

	/**
	 * Metodo constructor de la clase Cola que crea una instancia vacia de la cola
	 */
	public Cola(){
		
		this.cola = new ListaDoble<T>();
	}
	
	// ----------------------------------------------------------------------------
	// METODOS
	// ----------------------------------------------------------------------------

	/**
	 * Metodo que agrega un elemento al final de la cola (back)
	 * 
	 * @param elemento a insertar dentro de la cola
	 */
	@Override
	public void enQueue(T elemento) {
		
		cola.agregar(elemento);

	}

	/**
	 *Metodo que elimina el primer elemento de la cola (front) 
	 *
	 * @return T elemento eliminado de la cola
	 */
	@Override
	public T deQueue(){
		
		T elemento = cola.darElemento(0);
		try {
			cola.eliminar(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return elemento;
	}
	
	/**
	 * Metodo que informa si la cola esta vacia
	 * 
	 * @return true si esta vacia, false de lo contrario
	 */
	@Override
	public boolean isEmpty() {

		return cola.esVacia();
	}

	/**
	 * Metodo que limpia la cola de elementos
	 * 
	 * pos:la cola queda sin elementos
	 * 
	 */
	@Override
	public void clear() {
		
		cola.limpiar();

	}

	/**
	 * Metodo que retorna el primer elemento de la cola
	 * 
	 * @return front primer elemento de la cola
	 */
	@Override
	public T getFront() {
		
		return cola.darElemento(0);
	}

	/**
	 * Metodo que retorna el ultimo y mas reciente elemento agregado a la cola
	 * 
	 * @return back elemento mas reciente agregado a la cola
	 */
	@Override
	public T getBack() {

		return cola.darElemento(cola.darLongitud()-1);
	}
	
	/**
	 * Metodo que escribe en consola los elementos internos desde el primero hacia el ultimo 
	 * */
	public void print(){
		
		cola.print();
		
	}
	
	/**
	 * Metodo que escribe en consola los elementos internos desde el ultimo hacia el primero
	 * */
	public void printback(){
		
		cola.printBack();
		
	}

}
