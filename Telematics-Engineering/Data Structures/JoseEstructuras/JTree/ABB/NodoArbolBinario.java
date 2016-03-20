package ABB;

import JList.JSimpleList;

public class NodoArbolBinario<K extends Comparable<? super K>> {

	// -----------------------------------------------
	// Atributos
	// -----------------------------------------------

	/**
	 * Arbol de la izquierda
	 */
	protected NodoArbolBinario<K> derecho;

	/**
	 * Arbol de la derecha
	 */
	protected NodoArbolBinario<K> izquierdo;

	/**
	 * Clave generica
	 */
	protected K contenido;

	/**
	 * Elemento generico
	 *

	/**
	 * Nodo padre
	 */

	// ------------------------------------------------
	// Constructores
	// ------------------------------------------------

	/**
	 * Crea un arbol con un keyo
	 * 
	 * @param key
	 *            keyo se ingresa al arbol
	 */
	public NodoArbolBinario(K key) {
		this.key = key;
		this.element = element;
	}

	// -----------------------------------------------
	// Metodos
	// -----------------------------------------------

	/**
	 * Inserta un nuevo keyo al arbol
	 * 
	 * @param key
	 *            key que se adhiere al arbol
	 */
	public void agregar(K key) {
		int comparacion = this.key.compareTo(key);

		if (comparacion >= 0) {
			if (left == null) {
				left = new NodoArbolBinario<K, T>(key, element);
				left.setP(this);
			} else {
				left.add(key, element);
			}
		} else {
			if (right == null) {
				right = new NodoArbolBinario<K, T>(key, element);
				right.setP(this);
			} else {
				right.add(key, element);
			}
		}
	}

	/**
	 * Busca el keyo en el arbol binario
	 * 
	 * @param key
	 *            keyo que se va a buscar
	 * @return el keyo si es encontrado, retorna null en caso contrario.
	 */
	public T buscar(K key) {
		int comparacion = this.key.compareTo(key);
		if (comparacion == 0) {
			return element;
		} else if (comparacion > 0) {
			return (left != null) ? left.search(key) : null;
		} else {
			return (right != null) ? right.search(key) : null;
		}
	}
	
	
//	public NodoArbolBinario<K> searchNode(K key) {
//		int comparacion = this.key.compareTo(key);
//		if (comparacion == 0) {
//			return this;
//		} else if (comparacion > 0) {
//			return (left != null) ? left.searchNode(key) : null;
//		} else {
//			return (right != null) ? right.searchNode(key) : null;
//		}
//	}

	/**
	 * Busca el nodo pasado por parametro, si se encuentra en el arbol lo
	 * elimina si no lanza una excepcion.
	 * @param key
	 *            key que se quiere eliminar
	 * @throws Exception
	 *             Lanza una excepcion si el elemento no esta en el arbol
	 */
	public NodoArbolBinario<K> eliminar(K key) throws Exception {

		NodoArbolBinario<K, T> removeNode = null;
		int comparacion = this.key.compareTo(key);
		if (comparacion == 0) {
			if (left == null) {
				removeNode = right;
			} else if (right == null) {
				removeNode = left;
			} else {
				this.element = left.maximun().getElement();
				this.key = left.maximun().getkey();
				left = left.remove(this.key, this.element);
				removeNode = this;
			}
		} else if (comparacion > 0) {

			if (left == null) {
				throw new Exception("El elemento " + element
						+ " no se encuentra en el arbol");
			} else {
				left = left.remove(key, element);
				removeNode = this;
			}
		} else {
			if (right == null) {
				throw new Exception("El elemento " + element
						+ " no se encuentra en el arbol");
			} else {
				right = right.remove(key, element);
				removeNode = this;
			}
		}
		return removeNode;
	}
	

	/**
	 * retorna el tamanio del arbol
	 * @return int con el tamanio del arbol
	 */
	public int darLongitud() {

		int a = (left == null) ? 0 : left.size() + 1;
		int b = (right == null) ? 0 : right.size() + 1;

		return a + b;
	}

	/**
	 * Busca el nodo menor que todos los otros.
	 * 
	 * @return retorna el menor que todos.
	 */
	public NodoArbolBinario<K> darMinimo() {
		return (left == null) ? this : left.minimun();
	}

	/**
	 * Busca el nodo mayor que todos los otros.
	 * 
	 * @return el nodo maximo
	 */
	public NodoArbolBinario<K> darMaximo() {

		return (right == null) ? this : right.maximun();
	}

	/**
	 * Encuentra el sucessor de dicho nodo
	 * 
	 * @return Nodo sucesor del Arbol
	 */
	public NodoArbolBinario<K> darSucesor() {
		if (right != null) {
			return right.minimun();
		}
		while (p != null && p.getRight() == this) {
			setP(this.getP());
		}
		return p;
	}

	/**
	 * Encuentra el nodo predeccesor del arbol
	 * 
	 * @return Nodo predecesor del arbol
	 */
	public NodoArbolBinario<K> darPredecesor() {
		if (left != null) {
			return left.maximun();
		}
		while (p != null && p.getLeft() == this) {
			setP(this.getP());
		}
		return p;
	}

	/**
	 * Da la altura del arbol
	 * 
	 * @return int con la altura del arbol.
	 */
	public int darAltura() {
		int a = (left == null) ? 0 : left.height();
		int b = (right == null) ? 0 : right.height();

		return (a >= b) ? a + 1 : b + 1;
	}

	/**
	 * verifica si es arbol es hoja
	 * 
	 * @return true en caso de serlo
	 */
	public boolean esHoja() {
		return left == null && right == null;
	}

	/**
	 * Da el subarbol izquierdo.
	 * 
	 * @return el arbol izquierdo
	 */
	public NodoArbolBinario<K
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	> darDerecho() {
		return left;
	}

	/**
	 * Da el subarbol derecho
	 * 
	 * @return el arbol derecho
	 */
	public NodoArbolBinario<K> darIzquierdo() {
		return right;
	}

	/**
	 * Da la clave que contiene el arbol
	 * 
	 * @return key
	 */
//	public K darLlave() {
//		return key;
//	}

	/**
	 * @return el padre del arbol
	 */
//	public NodoArbolBinario<K, T> darContenido() {
//		return p;
//	}
//
//	public void cambiarContenido(NodoArbolBinario<K, T> p) {
//		this.p = p;
//	}

	/**
	 * @return the element
	 */
	public T darElemento() {
		return element;
	}

	/**
	 * @param element
	 *            the element to set
	 */
	public void cambiarElemento
	(K element) {
		this.element = element;
	}
	
	@Override
//	public String toString() {
//		String mensaje = "";
//		mensaje += (left == null) ? "" : "izq- " + left.toString();
//		mensaje += (right == null) ? "" : "der- " + right.toString();
//		return key.toString() + " " + mensaje;
//	}

	public ListaSimple<K> inorden(ListaSimple<K> list) {
		if (left != null) {
			left.inorder(list);
			list.add(element);
			if (right != null) {
				right.inorder(list);
			}
		} else {
			list.add(element);
			if (right != null) {
				right.inorder(list);
			}
		}
		return list;
	}
	
	public ListaSimple<K> preorden(ListaSimple<K> list){
		list.add(element);
		if(left != null){
			left.preorder(list);
		}
		if(right != null){
			right.preorder(list);
		}
		return list;
	}
	
	public ListaSimple<K> postorden(ListaSimple<K> list){
		list.add(element);
		if(left != null){
			left.preorder(list);
		}
		if(right != null){
			right.preorder(list);
		}
		return list;
	}
	
	
}
