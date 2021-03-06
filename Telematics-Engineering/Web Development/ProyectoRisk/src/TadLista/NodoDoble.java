package TadLista;

import java.io.Serializable;

public class NodoDoble<T> implements INodo<T>,Serializable {

	// ----------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T contenido;

	private NodoDoble<T> anterior;

	private NodoDoble<T> siguiente;

	// ----------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------

	/**
	 * Metodo constructor de la clase NodoDoble, crea una instancia de una nodo
	 * doble
	 * 
	 * @param contenido
	 *            guardara el nodo dentro de la lista
	 */
	public NodoDoble(T contenido) {

		this.contenido = contenido;

	}

	// ----------------------------------------------------------------------------
	// METODOS
	// ----------------------------------------------------------------------------

	/**
	 * Retorna contenido del nodo
	 * 
	 * @return T objeto dentro del nodo
	 */
	public T getContenido() {
		return contenido;
	}

	/**
	 * Retorna nodo anterior del nodo sobre el que se invoca
	 * 
	 * @return INodo anterior
	 */
	public NodoDoble<T> getAnterior() {
		return anterior;
	}

	/**
	 * Retorna nodo siguiente del nodo sobre el que se invoca
	 * 
	 * @return INodo siguiente
	 */
	public NodoDoble<T> getSiguiente() {
		return siguiente;
	}

	/**
	 * Cambia el contenido del nodo
	 * 
	 * @param T
	 *            objeto a poner como contenido del nodo
	 */
	public void setContenido(T contenido) {
		this.contenido = contenido;
	}

	/**
	 * Cambia el nodo anterior en la lista por el pasado por parametro
	 * 
	 * pos: el nodo anterior ha sido cambiado
	 * 
	 * @param INodo
	 *            nodo a poner como siguiente
	 */
	public void setAnterior(NodoDoble<T> anterior) {
		this.anterior = anterior;
	}

	/**
	 * Cambia el nodo que sigue en la lista por el pasado por parametro
	 * 
	 * pos: el nodo siguiente ha sido cambiado
	 * 
	 * @param INodo
	 *            nodo a poner como siguiente
	 */
	@Override
	public void setSiguiente(INodo<T> siguiente) {
		this.siguiente = (NodoDoble<T>) siguiente;

	}

}
