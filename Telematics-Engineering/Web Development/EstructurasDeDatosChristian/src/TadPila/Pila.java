package TadPila;

import TadLista.ListaDoble;

public class Pila<T> implements IPila<T> {

	// ----------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------

	private ListaDoble<T> pila;

	// ----------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------

	/**
	 * Metodo constructor de la clase Pila, inicializa la pila.
	 * 
	 */
	public Pila() {

		this.pila = new ListaDoble<>();
	}

	// ----------------------------------------------------------------------------
	// METODOS
	// ----------------------------------------------------------------------------

	/**
	 * Metodo que inserta un elemento en el tope de la pila
	 * 
	 * pre: la lista debe existir. logitud>=0 pos: la pila tiene un nuevo
	 * elemento
	 * 
	 * @param contenido
	 *            del nodo a insertar en el tope
	 */
	@Override
	public void push(T contenido) {

		pila.agregar(contenido);

	}

	/**
	 * Metodo que eliminia el elemento en el tope de la pila
	 * 
	 * pre: la pila debe existir. Longitud>0 pos: la pila tiene un elemento
	 * menos longitud = longitud -1
	 * 
	 * @return T elemento eliminado de la pila
	 * @throws Exception
	 *             cuando se intenta eliminar un elemento y la longitud = 0
	 */
	@Override
	public T pop() throws Exception {

		T elemento = null;

		try {
			elemento = pila.darElemento(pila.darLongitud() - 1);
			pila.eliminar(pila.darLongitud() - 1);
		} catch (Exception e) {
			throw new Exception("No hay elementos en la pila. "
					+ e.getMessage());
		}

		return elemento;
	}

	/**
	 * Metodo que retorna el elemento en el tope de la pila
	 * 
	 * pre: la pila debe existir. Longitud>0
	 * 
	 * @return T el elemento del tope, null si la longitud es 0
	 */
	@Override
	public T peek() {

		return pila.darElemento(pila.darLongitud() - 1);
	}

	/**
	 * Metodo que informa si la pila esta vacia
	 * 
	 * pre: la pila debe existir
	 * 
	 * @return true pila tiene al menos un elemento, false de lo contrario
	 */
	@Override
	public boolean isEmpty() {

		return pila.esVacia();
	}

	/**
	 * Metodo que elimina el contenido de la pila
	 * 
	 * pre: la pila debe existir pos: la pila queda limpia de elementos
	 */
	@Override
	public void clear() {

		this.pila.limpiar();

	}

	/**
	 * Metodo que retorna el tamano de la pila
	 * 
	 * @return int entero con el tamano de la pila
	 */
	public int size() {

		return this.pila.darLongitud();
	}

	/**
	 * Metodo que imprime todos los elementos de la pila
	 * 
	 * Este metodo es el unico que no es O(1) dentro de la pila puesto que se
	 * presta de lista doble
	 * 
	 */
	public void print() {

		pila.print();

	}

}
