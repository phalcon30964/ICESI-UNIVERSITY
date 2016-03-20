package TadLista;

public class NodoSimple <T>{
	
	//atributos
	private T contenido;
	
	private NodoSimple<T> siguiente;
	
	//constructor
	
	/**
	 * Constructor de la clase NodoSimple, crea un nuevo objeto nodo y 
	 * lo inicializa con un contenido pasado por parametro 
	 * 
	 * @param i contenido del nodo
	 */
	public NodoSimple (T i){
		contenido = i;
	}
	
	//metodos
	/**
	 * retorna contenido
	 * 
	 * @return T valor del nodo
	 */
	public T getContenido() {
		return contenido;
	}

	/**
	 * Cambia el atributo contenido
	 * 
	 * @param contenido para cambiar 
	 */
	public void setContenido(T contenido) {
		this.contenido = contenido;
	}

	/**
	 * Retorna nodo siguiente del nodo sobre el que se invoca
	 * 
	 * @return NodoSimple siguiente
	 */
	public NodoSimple<T> getSiguiente() {
		return siguiente;
	}
	
	/**
	 * Cambia el nodo que sigue en la lista por el pasado por parametro
	 * 
	 */
	public void setSiguiente(NodoSimple<T> siguiente) {
		this.siguiente = siguiente;
	}


}
