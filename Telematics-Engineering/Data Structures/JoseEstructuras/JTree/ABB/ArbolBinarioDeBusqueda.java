package ABB;

import JList.JSimpleList;

public class ArbolBinarioDeBusqueda<K extends Comparable<? super K>> implements IArbolBinarioDeBusqueda<K> {

	// ---------------------------------------------------------------
	// Atributos
	// ---------------------------------------------------------------

	protected NodoArbolBinario<K> raiz;

	// ---------------------------------------------------------------
	// Constructor
	// ---------------------------------------------------------------

	public ArbolBinarioDeBusqueda() {
		create();
	}

//	public ArbolBinarioDeBusqueda(K key) {
//		create(key, element);
//	}

	// ---------------------------------------------------------------
	// Metodos
	// ---------------------------------------------------------------
	@Override
	public void crear() {
		root = null;
	}

//	@Override
//	public String toString() {
//		return root.toString();
//	}

//	@Override
//	public void create(K key, T element) {
//		// TODO Auto-generated method stub
//
//	}

//	@Override
//	public boolean esHoja() {
//		return (root == null) ? true : root.isLeaf();
//	}

	@Override
	public void eliminar(K key) throws Exception {
		if (root != null) {
			root = root.remove(key);
		} else {
			throw new Exception("El arbol esta vacio");
		}
	}

	@Override
	public void agregar(K key, T element) {
		if (root != null) {
			root.add(key, element);
		} else {
			NodoArbolBinario<K, T> nuevo = new NodoArbolBinario<K, T>(key, element);
			root = nuevo;
		}
	}

	@Override
	public T buscar(K key) {
		T buscado = null;
		if (root != null) {
			buscado = root.search(key);
		}
		return buscado;
	}

	@Override
	public boolean esVacio() {
		return (root == null) ? true : false;
	}

	@Override
	public int darLongitud() {
		return (root == null) ? 0 : root.size() + 1;
	}

	@Override
	public int darAltura() {
		return (root == null) ? 0 : root.height();
	}

	public NodoArbolBinario<K> darSucesor(K key) throws Exception {
		if (root == null) {
			throw new Exception("El arbol no tiene ningun elemento");
		} else if (root.searchNode(key) == null) {
			throw new Exception("El elemento no se encuentra en el arbol");
		} else {
			return root.searchNode(key).succesor();
		}

	}

	@Override
	public ListaSimple<k> inorden() {
		ListaSimple<k> list = new ListaSimple<T>();
		return (root == null) ? null : root.inorder(list);
	}

	@Override
	public ListaSimple<k> postorden() {
		ListaSimple<k>list = new ListaSimple<T>();
		return (root == null) ? null : root.preorder(list);
	}

	@Override
	public ListaSimple<k> preorden() {
		ListaSimple<k> list = new ListaSimple<T>();
		return (root == null) ? null : root.preorder(list);
	}

	@Override
	public NodoArbolBinario<K> darMinimo() {
		return (root == null) ? root : root.minimun();
	}

	@Override
	public NodoArbolBinario<K> darMaximo() {
		return (root == null) ? root : root.maximun();
	}

	public NodoArbolBinario<K> darDerecho() {
		return (root == null) ? null : root.getRight();
	}

	public NodoArbolBinario<K> darIzquierdo() {
		return (root == null) ? null : root.getLeft();
	}
}
