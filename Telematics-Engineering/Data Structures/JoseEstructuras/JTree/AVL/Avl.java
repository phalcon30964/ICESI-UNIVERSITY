package AVL;

import utilArboles.IAbb;

public class Avl<T, K extends Comparable<K>> implements IAbb<T, K> {

	/**
	 * Ra�z del �rbol AVL
	 */
	private NodoAvl<T, K> root;

	/**
	 * Peso del �rbol AVL
	 */
	private int  weight;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del �rbol AVL vac�o. <br>
	 * <b>post: </b> Se construy� un �rbol AVL vac�o.
	 */
	public Avl() {
		root = null;
		weight = 0;
	}

	/**
	 * Constructor del �rbol AVL con ra�z. <br>
	 *Se construy� un �rbol AVL con
	 * una raiz con el key como llave y elem como data.
	 * 
	 * @param elem: infrmacion que se desea guardar
	 *            
	 * @param key: key del nodo
	 *            
	 */
	public Avl(T elme, K key) {
		NodoAvl<T, K> elNuevo = new NodoAvl<T, K>(elme, key);
		this.root = elNuevo;
		weight++;
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------

	/**
	 * Devuelve la ra�z del �rbol para navegarlo. <br>
	 * <b>post: </b> Se retorn� la ra�z del �rbol para navegarlo.
	 * 
	 * @return Ra�z del �rbol para navegarlo
	 */
	public NodoAvl<T, K> getRoot() {
		return root;
	}

	
	public void add(T data, K key) throws Exception {
		if (root == null) {
			// Caso 1: el �rbol es vac�o
			root = new NodoAvl<T, K>(data, key);
		} else {
			// Caso 2: el �rbol no es vac�o
			root = root.insertar(data, key);
		}
		weight++;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * uniandes.cupi2.collections.arbol.IArbolOrdenado#eliminar(java.lang.Comparable
	 * )
	 */
	public void remove(K key) throws Exception {
		if (root != null) {
			// Caso 1: el �rbol no es vac�o
			root = root.eliminar(key);
			weight--;
		} else {
			// Caso 2: el �rbol es vac�o
			throw new Exception(
					"El elemento especificado no existe en el �rbol");
		}
	}

	
	public T search(K key) {
		return (root != null) ? root.buscar(key) : null;
	}

	
	
	public int getHeight() {
		return (root != null) ? root.getAltura() : 0;
	}

	
	public int getWeight() {
		return weight;
	}

	/**
	 * Devuelve el elemento mayor del �rbol AVL. <br>
	 * <b>post: </b> Se retorn� el elemento mayor del �rbol AVL o null si el
	 * �rbol est� vacio.
	 * 
	 * @return Elemento mayor del �rbol AVL o null si el �rbol est� vacio
	 */
	public T getMayor() {
		return (root != null) ? root.getMayor() : null;
	}

	/**
	 * Devuelve el elemento menor del �rbol AVL. <br>
	 * <b>post: </b> Se retorn� el elemento menor del �rbol AVL o null si el
	 * �rbol est� vacio.
	 * 
	 * @return Elemento menor del �rbol AVL o null si el �rbol est� vacio
	 */
	public T getMenor() {
		return (root != null) ? root.getMenor() : null;
	}

	

	

}
