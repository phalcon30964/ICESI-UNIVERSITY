package TadLista;

import java.io.Serializable;

public class NodoOrdenado<T extends Comparable<T>> implements INodo<T>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ----------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------

	private T contenido;

	private NodoOrdenado<T> siguiente;

	// ----------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------

	/**
	 * Metodo constructor de la clase Nodo Ordenado, crea una instancia de una nodo
	 * 
	 * 
	 * @param contenido
	 *            guardara el nodo dentro de la lista
	 */
	public NodoOrdenado(T contenido) {

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
	public NodoOrdenado<T> getSiguiente() {
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
	@Override
	public void setSiguiente(INodo<T> siguiente) {
		this.siguiente = (NodoOrdenado<T>)siguiente;
		
	}
	
	/**
	 * Metodo que compara el nodo sobre el que se invoca con otro entrado por parametro
	 * 
	 * pre: el objeto contenido tiene que implementar la interfaz comparable
	 * 
	 * @param INodo
	 *            con el cual comparar
	 *            
	 * @return un numero negativo si el parametro es mayor
	 *         un numero positivo si el parametro es menor
	 *         un 0 si el parametro es igual
	 */
	public int comparar(NodoOrdenado<T> otroNodo){
		return this.contenido.compareTo(otroNodo.getContenido());
		
	}


}
