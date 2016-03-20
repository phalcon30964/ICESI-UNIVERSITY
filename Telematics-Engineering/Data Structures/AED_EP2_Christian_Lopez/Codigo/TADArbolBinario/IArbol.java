package TADArbolBinario;

import TADListaDoble.ListaDoble;

public interface IArbol< K extends Comparable<K> , T> {
	
		//retorna el nodo raiz
	/**Este método se encarga de retornar la raíz del arbol 
	 * 
	 * 
	 * @return
	 */
		public INodoArbol<K,T> getRaiz();
		
		// cambia el contenido del nodo raiz
		public void setRaiz(T contenido);
		
		//agrega un nodo al rabol, tira excepcion al agregar un key que ya existe
		public void agregar(K key, T contenido) throws Exception;
		
		// elimina un nodo del arbol
		public void eliminar(K key);
		
		//busca un elemento del arbol por key
		public T buscar(K key);
		
		//retorna un arreglo de nodos
		public ListaDoble<INodoArbol<K, T>> inorden();
	
		//retorna una cadena de todos los elementos del arbol en inorden
		public String cadenaInorden();
		

}
