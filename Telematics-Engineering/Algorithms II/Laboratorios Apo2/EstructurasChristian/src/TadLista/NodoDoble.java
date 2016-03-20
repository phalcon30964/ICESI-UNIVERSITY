package TadLista;

public class NodoDoble <T>{
	
	//atributos
	private T contenido;
	
	private NodoDoble<T> siguiente;
	
	private NodoDoble<T> anterior;
	
	//constructor
	
	/**
	 * Constructor de la clase NodoDoble, crea un nuevo objeto nodo y 
	 * lo inicializa con un contenido pasado por parametro 
	 * 
	 * @param i contenido del nodo
	 */
	public NodoDoble (T i){
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
	 * @return NodoDoble siguiente
	 */
	public NodoDoble<T> getSiguiente() {
		return siguiente;
	}
	
	/**
	 * Cambia el nodo que sigue en la lista por el pasado por parametro
	 * 
	 */
	public void setSiguiente(NodoDoble<T> siguiente) {
		this.siguiente = siguiente;
	}
	
	/**
	 * Retorna nodo anterior del nodo sobre el que se invoca
	 * 
	 * @return NodoDoble siguiente
	 */
	public NodoDoble<T> getAnterior() {
		return anterior;
	}
	
	/**
	 * Cambia el nodo que anterior en la lista por el pasado por parametro
	 * 
	 */
	public void setAnterior(NodoDoble<T> anterior) {
		this.anterior = anterior;
	}

}
