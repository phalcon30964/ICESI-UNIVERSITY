package TadLista;

public interface ILista<T> {

	/**
	 * Metodo que agrega una nuevo elemento generico a la lista
	 * 
	 * pre: <b/>valor=!null<br>
	 * pos: la lista tiene un nuevo elemento
	 * 
	 * @param valor
	 *            elemento nuevo que se agregarà a la lista
	 * */
	public void agregar(T contenido);

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
	 *             tamano de la lista
	 * */
	public void agregar(int pos, T contenido) throws Exception;

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
	 *             si no existe elemento en la posicion indicada
	 * */
	public void eliminar(int pos) throws Exception;

	/**
	 * Metodo que retorna un elemento de la lista
	 * 
	 * pre: <b/>pos>=0<br>
	 * pre: <b/longitud<=pos<br>
	 * pre: <b/>lista!=null<br>
	 * 
	 * @param pos
	 *            posicion del elemento a retornar
	 * @return T elemento en la posicion indicada o null si no lo encuentra
	 * */
	public T darElemento(int pos) throws Exception;

	/**
	 * Metodo que retorna la longitud de la lista
	 * 
	 * @return int longitud de la lista
	 * */
	public int darLongitud();

	/**
	 * Metodo que retorna si la lista esta vacia
	 * 
	 * @return boolean true si esta vacia, false si no.
	 * */
	public boolean esVacia();
	
	/**
	 * Metodo que escribe en consola los elementos internos 
	 * */
	public void print();

}
