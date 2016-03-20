package TadLista;

public class Sencilla<T> implements ILista<T> {
	
	private int longitud;
	
	private NodoSimple<T> primero;
	
	/**
	 * Constructor de la clase Sencilla
	 * 
	 * Inicializa la lista con longitud = 0 y primer nodo nulo
	 * 
	 */
	public Sencilla(){
		
		longitud = 0;
		
	}

	//metodos
	@Override
	
	/**
	 * Metodo que agrega una nuevo elemento generico a la lista
	 *  
	 * pre: <b/>valor=!null<br>
	 * pos: la lista tiene un nuevo elemento
	 * 
	 * @param valor elemento nuevo que se agregarà a la lista 
	 * */
	public void agregar(T valor){
		
		NodoSimple<T> aux = new NodoSimple<T>(valor);
		
		if(getPrimero()==null){
			
			setPrimero(aux);
			longitud++;
			
		}else{
			
			NodoSimple<T> actual = primero;
			
			while(actual.getSiguiente()!=null){
				actual = actual.getSiguiente();
			}
			
			actual.setSiguiente(aux);
			longitud++;
			
		}
		
	}

	@Override
	/**
	 * Metodo que agrega una nuevo elemento generico a la lista en una posicion especifica, desde la posicion 0 hasta longitud.
	 *  
	 * pre: <b/>valor=!null<br>
	 * pre: <b/>pos>=0<br>
	 * pos: la lista tiene un nuevo elemento en la posicion indicada
	 * 
	 * @param pos posicion del elemento a agregar 
	 * @param valor elemento nuevo que se agregara a la lista
	 * @throws arroja excepcion cuando el valor pasado por parametro excede el tamano de la lista
	 * */
	public void agregar(int pos, T valor) throws Exception {
		
		if(pos<0 || pos>longitud){
			throw new Exception("Error, posicion invalido");
		}
		
		NodoSimple<T> aux = new NodoSimple<T>(valor);
		
		if(pos==0){
			
			aux.setSiguiente(primero);
			setPrimero(aux);
			longitud++;
			
		}else{
			
			NodoSimple<T> actual = primero;
			
			for (int i = 0;  i < (pos-1) && actual.getSiguiente()!=null; i++ ) {
				actual = actual.getSiguiente();
			}
		
			aux.setSiguiente(actual.getSiguiente());
			actual.setSiguiente(aux);
			longitud++;
		}
		
	}
	
	@Override
	/**
	 * Metodo que elimina el elemento en la posicion pasada por parametro
	 *  
	 * pre: <b/>longitud>pos>=0<br>
	 * pre: <b/>lista!=null<br>
	 * pos: la lista tiene elemento menos
	 * 
	 * @param pos posicion del elemento a agregar 
	 * @throws Exception si no existe elemento en la posicion indicada 
	 * */
	public void eliminar(int pos) throws Exception {
		
		validarPosicion(pos);
		
		if(esVacia()){
			
			throw new Exception("Error, no hay elementos en la lista");
			
		}else if(pos==0){
			
			setPrimero(primero.getSiguiente());
			longitud--;
			
		}else{
			
			NodoSimple<T> actual = primero;
			for (int i = 0;  i < (pos-1) && actual.getSiguiente()!=null; i++ ) {
				actual = actual.getSiguiente();
			}
			actual.setSiguiente(actual.getSiguiente().getSiguiente());
			longitud--;
		}	
		
	}
	
	
	/**
	 * Metodo que valida si el numero que entra por parametro 
	 * es o no valida como una posicion de la lista
	 * 
	 * @param pos Posicion a evaluar
	 * 
	 * @throws Exception si la posicion es menor que 0 o mayor que la longitud misma de la lista
	 */
	public void validarPosicion(int pos)throws Exception{
		
		if(pos<0 || pos>=longitud){
			throw new Exception("Error, posicion invalido");
		}
		
	}

	@Override
	/**
	 * Metodo que devuelve el elemento que esta contenido en la posicion pos
	 * 
	 * @return T contenido del elemento en la poscion pos
	 */
	public T darElemento(int pos) {
		
		try {
			validarPosicion(pos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NodoSimple<T> actual = primero;
		
		for (int i = 0;  i < pos; i++ ) {
			actual = actual.getSiguiente();
		}
		
		return actual.getContenido();
	}

	@Override
	
	/**
	 * Devuelve la longitud de la lista 
	 * 
	 * @return int con la longitud de la lista
	 */
	public int darLongitud() {
		
		return getLongitud();
	}

	@Override
	/**
	 * Verifica si la lista esta vacia
	 * 
	 * @return boolean true si esta vacia, false de lo contratrario
	 */
	public boolean esVacia() {

		return getPrimero()==null;
	}
	

	//metodos get y set

	public int getLongitud() {
		return longitud;
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

	public NodoSimple<T> getPrimero() {
		return primero;
	}

	public void setPrimero(NodoSimple<T> primero) {
		this.primero = primero;
	}
	
	public void print() {

		NodoSimple<T> actual = primero.getSiguiente();

		for (int i = 0; i < longitud; i++) {
			System.out.println(actual.getContenido().toString());
			actual = actual.getSiguiente();
		}

	}

}
