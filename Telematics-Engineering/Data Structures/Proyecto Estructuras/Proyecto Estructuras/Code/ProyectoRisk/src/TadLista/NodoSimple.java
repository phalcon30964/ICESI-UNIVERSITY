package TadLista;

import java.io.Serializable;

public class NodoSimple<T> implements INodo<T>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------

	private T contenido;

	private NodoSimple<T> siguiente;

	// ----------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------

	/**
	 * Metodo constructor de la clase NodoSimple, crea una instancia de una nodo
	 * 
	 * 
	 * @param contenido
	 *            guardara el nodo dentro de la lista
	 */
	public NodoSimple(T contenido) {

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
	 * Retorna nodo siguiente del nodo sobre el que se invoca
	 * 
	 * @return INodo siguiente
	 */
	public NodoSimple<T> getSiguiente() {
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
	 * Cambia el nodo que sigue en la lista por el pasado por parametro
	 * 
	 * pos: el nodo siguiente ha sido cambiado
	 * 
	 * @param INodo
	 *            nodo a poner como siguiente
	 */
	public void setSiguiente(INodo<T> siguiente) {

		this.siguiente = (NodoSimple<T>) siguiente;
	}

}
