package utilArboles;

public class Avl<T, K extends Comparable<K>> implements IAbb<T, K> {

	/**
	 * Raíz del árbol AVL
	 */
	private NodoAvl<T, K> root;

	/**
	 * Peso del árbol AVL
	 */
	private int  weight;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructor del árbol AVL vacío. <br>
	 * <b>post: </b> Se construyó un árbol AVL vacío.
	 */
	public Avl() {
		root = null;
		weight = 0;
	}

	/**
	 * Constructor del árbol AVL con raíz. <br>
	 *Se construyó un árbol AVL con
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
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Devuelve la raíz del árbol para navegarlo. <br>
	 * <b>post: </b> Se retornó la raíz del árbol para navegarlo.
	 * 
	 * @return Raíz del árbol para navegarlo
	 */
	public NodoAvl<T, K> getRoot() {
		return root;
	}

	
	public void add(T data, K key) throws Exception {
		if (root == null) {
			// Caso 1: el árbol es vacío
			root = new NodoAvl<T, K>(data, key);
		} else {
			// Caso 2: el árbol no es vacío
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
			// Caso 1: el árbol no es vacío
			root = root.eliminar(key);
			weight--;
		} else {
			// Caso 2: el árbol es vacío
			throw new Exception(
					"El elemento especificado no existe en el árbol");
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
	 * Devuelve el elemento mayor del árbol AVL. <br>
	 * <b>post: </b> Se retornó el elemento mayor del árbol AVL o null si el
	 * árbol está vacio.
	 * 
	 * @return Elemento mayor del árbol AVL o null si el árbol está vacio
	 */
	public T getMayor() {
		return (root != null) ? root.getMayor() : null;
	}

	/**
	 * Devuelve el elemento menor del árbol AVL. <br>
	 * <b>post: </b> Se retornó el elemento menor del árbol AVL o null si el
	 * árbol está vacio.
	 * 
	 * @return Elemento menor del árbol AVL o null si el árbol está vacio
	 */
	public T getMenor() {
		return (root != null) ? root.getMenor() : null;
	}

	

	

}
