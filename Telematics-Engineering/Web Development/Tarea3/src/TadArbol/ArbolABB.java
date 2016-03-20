package TadArbol;

import TadLista.ListaDoble;

public class ArbolABB<K extends Comparable<K>, T> implements IArbol<K, T>,
		IBSTTree<K, T> {

	// ----------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------

	protected INodoArbol<K, T> raiz;

	// ----------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------

	public ArbolABB() {
		
		raiz = null;

	}

	// ----------------------------------------------------------------------------
	// METODOS
	// ----------------------------------------------------------------------------

	public INodoArbol<K, T> getRaiz() {
		return raiz;
	}

	public void setRaiz(T contenido) {
		raiz.setContenido(contenido);
	}

	// metodo que se sobreescribe
	public void agregar(K key, T contenido) throws Exception {
		NodoABB<K, T> nuevo = new NodoABB<K, T>(key, contenido);
		agregar(nuevo);
	}

	// metodo a heredar
	public void agregar(NodoABB<K, T> nuevo) throws Exception {
		if (raiz == null) {
			raiz = nuevo;
		} else {
			raiz.agregar(nuevo);
		}
	}

	// metodo que se sobreescribe
	public void eliminar(K key) {
		INodoArbol<K, T> nodoAEliminar = buscarNodo(key);
		if (nodoAEliminar != null) {
			eliminar(nodoAEliminar);
		}
	}

	// metodo a heredar
	public void eliminar(INodoArbol<K, T> ne) {

		// Caso 1
		if (ne.esHoja()) {

			if (ne == raiz) {
				raiz = null;
			} else if (ne.getPadre().getIzq() == ne) {
				ne.getPadre().setIzq(null);
			} else {// Si no soy hijo izquier de mi padre TENGO que ser el hijo
					// derecho
				ne.getPadre().setDer(null);
			}
		} else if (ne.getIzq() == null || ne.getDer() == null) {// Caso 2 Tiene
																// un solo hijo

			INodoArbol<K, T> hijoUnico = (ne.getIzq() == null) ? ne.getDer()
					: ne.getIzq();

			if (ne == raiz) {
				hijoUnico.setPadre(null);
				raiz = hijoUnico;
			} else {
				hijoUnico.setPadre(ne.getPadre());
				if (ne.getPadre().getIzq() == ne) {
					ne.getPadre().setIzq(hijoUnico);
				} else {// Si no soy hijo izquierdo de mi padre TENGO que ser el
						// hijo derecho
					ne.getPadre().setDer(hijoUnico);
				}
			}
		} else { // Caso 3 Tiene los dos hijos
			INodoArbol<K, T> minimo = ne.getDer().getMinimo();
			ne.setKey(minimo.getKey());
			ne.setContenido(minimo.getContenido());
			eliminar(minimo);
		}

	}

	public T buscar(K key) {
		T resultado = null;
		if (raiz != null) {
			resultado =  raiz.buscar(key);
		}
		return resultado;

	}

	public INodoArbol<K, T> buscarNodo(K key) {

		INodoArbol<K, T> resultado = null;
		if (raiz != null) {
			resultado = ((NodoABB<K, T>) raiz).buscarNodo(key);
		}
		return resultado;

	}

	public int getPeso() {

		int respuesta = 0;
		if (raiz != null) {
			respuesta =  raiz.getPeso();
		}
		return respuesta;

	}

	public int getAltura() {

		int altura = 0;
		if (raiz != null) {
			altura =  raiz.getAltura();
		}
		return altura;

	}

	public INodoArbol<K, T> getMinimo() {

		if (raiz != null) {
			return  raiz.getMinimo();
		}
		return null;

	}

	public INodoArbol<K, T> getMaximo() {

		if (raiz != null) {
			return  raiz.getMaximo();
		}
		return null;
	}

	public ListaDoble<INodoArbol<K, T>> inorden() {

		ListaDoble<INodoArbol<K, T>> lista = new ListaDoble<INodoArbol<K, T>>();
		if (raiz != null) {
			((NodoABB<K, T>) raiz).inorden(lista);
		}
		return lista;
	}
	
	public ListaDoble<T> inordenT() {

		ListaDoble<T> lista = new ListaDoble<T>();
		if (raiz != null) {
			((NodoABB<K, T>) raiz).inordenT(lista);
		}
		return lista;
	}

	public String cadenaInorden() {

		String cadena = "";
		if (raiz != null) {
			cadena +=  raiz.cadenaInorden();
		}
		return cadena;

	}

	public String cadenaPreorden() {

		String cadena = "";

		if (raiz != null) {
			cadena += ((NodoABB<K, T>) raiz).cadenaPreorden();
		}
		return cadena;

	}

	public String cadenaPosorden() {

		String cadena = "";

		if (raiz != null) {
			cadena += ((NodoABB<K, T>) raiz).cadenaPosorden();
		}
		return cadena;

	}

	public String cadenaRecorridoPorNivel(int nivel) {

		String cadena = "";

		if (raiz != null) {
			cadena += ((NodoABB<K, T>) raiz).cadenaRecorridoPorNivel(nivel, 0);
		}

		return cadena;

	}

	@Override
	public IBSTNode<K, T> getRoot() {
		return (IBSTNode<K, T>) raiz;
	}

	@Override
	public boolean isNil(IBSTNode<K, T> node) {
		// TODO Auto-generated method stub
		return (node == null);
	}

	public boolean esVacio() {

		return raiz == null;
	}

}
