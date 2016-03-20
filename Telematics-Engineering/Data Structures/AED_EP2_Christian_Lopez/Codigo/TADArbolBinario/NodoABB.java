package TADArbolBinario;

import TADListaDoble.ListaDoble;


public class NodoABB<K extends Comparable<K>, T> implements INodoArbol<K, T>, IBSTNode<K, T> {

	// ----------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------

	protected T contenido;
	protected K key;

	protected INodoArbol<K, T> izq;
	protected INodoArbol<K, T> der;
	protected INodoArbol<K, T> padre;

	// ----------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------

	public NodoABB(K key, T contenido) {
		this.contenido = contenido;
		this.key = key;
		this.padre = null;
	}

	// ----------------------------------------------------------------------------
	// METODOS
	// ----------------------------------------------------------------------------

	
	public INodoArbol<K, T> getPadre() {
		return padre;
	}

	
	public void setPadre(INodoArbol<K, T> padre) {
		this.padre = padre;

	}

	public T getContenido() {
		return contenido;
	}

	
	public void setContenido(T elemento) {
		this.contenido = elemento;

	}

	
	public K getKey() {
		return key;
	}

	
	public void setKey(K key) {
		this.key = key;

	}

	
	public INodoArbol<K, T> getIzq() {
		return izq;
	}

	
	public void setIzq(INodoArbol<K, T> izq) {
		this.izq = izq;

	}

	
	public INodoArbol<K, T> getDer() {
		return der;
	}


	public void setDer(INodoArbol<K, T> der) {
		this.der = der;

	}

	
	public void agregar(INodoArbol<K, T> nuevo) throws Exception {
		if(nuevo.getKey().compareTo(key)==0){
			throw new Exception("key ya existe");			
		}else if(nuevo.getKey().compareTo(key) < 0){
			if (izq == null) {
				izq = nuevo;
				izq.setPadre(this);
			} else {
				izq.agregar(nuevo);
			}
		} else  {
			if (der == null) {
				der = nuevo;
				der.setPadre(this);
			} else {
				der.agregar(nuevo);
			}			
		}
	}
	
	public T buscar(K key) {

		if (key.compareTo(this.key) == 0) {
			return this.contenido;
		} else if (key.compareTo(this.key) < 0) {
			return (izq == null) ? null : izq.buscar(key);
		} else {
			return (der == null) ? null : der.buscar(key);
		}

	}

	public INodoArbol<K, T> buscarNodo(K key) {

		if (key.compareTo(this.key) == 0) {
			return this;
		} else if (key.compareTo(this.key) < 0) {
			return (izq == null) ? null : ((NodoABB<K, T>) izq).buscarNodo(key);
		} else {
			return (der == null) ? null : ((NodoABB<K, T>) der).buscarNodo(key);
		}

	}

	
	public int getPeso() {

		int pesoIzq = (izq == null) ? 0 : izq.getPeso();

		int pesoDer = (der == null) ? 0 : der.getPeso();

		return 1 + pesoIzq + pesoDer;

	}

	
	public int getAltura() {

		int alturaIzq = (izq == null) ? 0 : izq.getAltura();

		int alturaDer = (der == null) ? 0 : der.getAltura();

		return 1 + Math.max(alturaIzq, alturaDer);

	}

	
	public INodoArbol<K, T> getMinimo() {
		return (izq == null) ? this :  izq.getMinimo();
	}

	
	public INodoArbol<K, T> getMaximo() {
		return (der == null) ? this :  der.getMaximo();
	}
	
	public void inorden(ListaDoble<INodoArbol<K, T>> lista) {

		if (izq != null) {
			((NodoABB<K, T>) izq).inorden(lista);
		}

		lista.agregar(this);

		if (der != null) {
			((NodoABB<K, T>) der).inorden(lista);
		}

	}
	
	public void inordenT(ListaDoble<T> lista) {

		if (izq != null) {
			((NodoABB<K, T>) izq).inordenT(lista);
		}

		lista.agregar(contenido);

		if (der != null) {
			((NodoABB<K, T>) der).inordenT(lista);
		}

	}

	public String cadenaInorden() {

		String cadena = "";

		if (izq != null) {
			cadena +=  izq.cadenaInorden();
		}

		cadena += this.key.toString()+ " ";

		if (der != null) {
			cadena +=  der.cadenaInorden();
		}

		return cadena;

	}

	public String cadenaPreorden() {

		String cadena = "";

		cadena += this.key.toString()+" ";

		if (izq != null) {
			cadena += ((NodoABB<K, T>) izq).cadenaPreorden();
		}

		if (der != null) {
			cadena += ((NodoABB<K, T>) der).cadenaPreorden();
		}

		return cadena;

	}

	public String cadenaPosorden() {

		String cadena = "";

		if (izq != null) {
			cadena += ((NodoABB<K, T>) izq).cadenaPosorden();
		}

		if (der != null) {
			cadena += ((NodoABB<K, T>) der).cadenaPosorden();
		}

		cadena += this.key.toString() + " ";

		return cadena;
	}

	public String cadenaRecorridoPorNivel(int nivel, int nivelActual) {

		String cadena = "";

		if (nivel == nivelActual) {
			cadena += this.key.toString() + " ";
		}

		if (izq != null) {
			cadena += ((NodoABB<K, T>) izq).cadenaRecorridoPorNivel(nivel,nivelActual + 1);
		}

		if (der != null) {
			cadena += ((NodoABB<K, T>) der).cadenaRecorridoPorNivel(nivel,nivelActual + 1);
		}

		return cadena;
	}

	
	public boolean esHoja() {

		boolean respuesta = false;

		if (izq == null && der == null) {
			respuesta = true;
		}

		return respuesta;
	}

	@Override
	public IBSTNode<K, T> getP() {
		
		return (IBSTNode<K, T>) padre;
	}

	@Override
	public IBSTNode<K, T> getLeft() {
		// TODO Auto-generated method stub
		return (IBSTNode<K, T>) izq;
	}

	@Override
	public IBSTNode<K, T> getRight() {
		// TODO Auto-generated method stub
		return (IBSTNode<K, T>) der;
	}
}
