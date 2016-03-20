package TadLista;

public class ListaSimple<T> implements ILista<T> {

	// ----------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------

	private int longitud;

	private NodoSimple<T> primero;

	// ----------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------

	/**
	 * Metodo constructor que crea una instancia de la clase ListaSimple de
	 * longitud 0.
	 */
	public ListaSimple() {

		longitud = 0;
		primero = new NodoSimple<T>(null);

	}

	// ----------------------------------------------------------------------------
	// METODOS
	// ----------------------------------------------------------------------------

	/**
	 * Metodo que agrega una nuevo elemento generico a la lista
	 * 
	 * pre: <b/>valor=!null<br>
	 * pos: la lista tiene un nuevo elemento
	 * 
	 * @param valor
	 *            elemento nuevo que se agregar� a la lista
	 * */
	@Override
	public void agregar(T contenido) {

		NodoSimple<T> nuevo = new NodoSimple<T>(contenido);

		NodoSimple<T> actual;
		for (actual = primero; actual.getSiguiente() != null; actual = actual
				.getSiguiente()) {
		}

		actual.setSiguiente(nuevo);
		longitud++;

	}

	/**
	 * Metodo que agrega una nuevo elemento generico a la lista en una posicion
	 * especifica
	 * 
	 * pre: <b/>valor=!null<br>
	 * pre: <b/>pos>=0<br>
	 * pos: la lista tiene un nuevo elemento en la posicion indicada
	 * 
	 * @param pos
	 *            posicion del elemento a agregar
	 * @param valor
	 *            elemento nuevo que se agregara a la lista
	 * @throws arroja
	 *             excepcion cuando el valor pasado por parametro excede el
	 *             tamano de la lista o es menor a 0
	 * */
	@Override
	public void agregar(int pos, T contenido) throws Exception {

		if (pos < 0 || pos > longitud) {
			throw new Exception("Error, posicion invalido");
		}

		NodoSimple<T> nuevo = new NodoSimple<T>(contenido);

		// no revise caso del primero puesto que en el contructor cree un
		// privote que me arregla esta situacion

		NodoSimple<T> actual = primero;
		for (int i = 0; (i < pos) && (actual.getSiguiente() != null); i++) {
			actual = actual.getSiguiente();
		}

		nuevo.setSiguiente(actual.getSiguiente());
		actual.setSiguiente(nuevo);
		longitud++;

	}

	/**
	 * Metodo que elimina el elemento en la posicion pasada por parametro
	 * 
	 * pre: <b/>longitud>pos>=0<br>
	 * pre: <b/>lista!=null<br>
	 * pos: la lista tiene elemento menos
	 * 
	 * 
	 * @param pos
	 *            posicion del elemento a agregar
	 * @throws Exception
	 *             si no existen elementos en la lista 
	 *             si la posicion no es igual a longitud , el rango valido va de 0 a longitud-1 
	 *             si la posicion por parametro es negativa
	 * */
	@Override
	public void eliminar(int pos) throws Exception {

		if (esVacia()) {
			throw new Exception("Error, no hay elementos en la lista");
		}
		
		if (pos < 0 || pos >= longitud) {
			throw new Exception("Error, posicion invalido");
		}

		NodoSimple<T> actual = primero;
		for (int i = 0; (i < pos) && (actual.getSiguiente() != null); i++) {
			actual = actual.getSiguiente();
		}

		actual.setSiguiente(actual.getSiguiente().getSiguiente());
		longitud--;

	}

	/**
	 * Metodo que retorna un elemento de la lista
	 * 
	 * pre: <b/>pos>=0<br>
	 * pre: <b/longitud>pos<br>
	 * pre: <b/>lista!=null<br>
	 * 
	 * @param pos
	 *            posicion del elemento a retornar
	 * @return T elemento en la posicion indicada o null si no lo encuentra
	 * */
	@Override
	public T darElemento(int pos) {

		T elemento = null;

		if (pos >= 0 && pos < longitud) {

			NodoSimple<T> actual = primero;
			for (int i = 0; (i <= pos) && (actual.getSiguiente() != null); i++) {
				actual = actual.getSiguiente();
			}

			elemento = actual.getContenido();
		}

		return elemento;
	}

	/**
	 * Metodo que retorna la longitud de la lista
	 * 
	 * @return int longitud de la lista
	 * */
	@Override
	public int darLongitud() {

		return longitud;
	}

	/**
	 * Metodo que retorna si la lista esta vacia
	 * 
	 * @return boolean true si esta vacia, false si no.
	 * */
	@Override
	public boolean esVacia() {

		return longitud == 0;
	}
	
	/**
	 * Metodo que escribe en consola los elementos internos 
	 * */
	public void print() {

		NodoSimple<T> actual = primero.getSiguiente();

		for (int i = 0; i < longitud; i++) {
			System.out.println(actual.getContenido().toString());
			actual = actual.getSiguiente();
		}

	}
	
	/**
	 * Metodo que reinicia la lista
	 * 
	 * pos: la lista queda limpia de elementos
	 * */
	public void limpiar(){
		longitud = 0;
		primero = new NodoSimple<T>(null);
	}

}
