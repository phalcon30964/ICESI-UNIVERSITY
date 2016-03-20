package heap;

public class Heap<K extends Comparable<? super K>, T> implements IHeap<K, T> {

	//------------------------------------------------------------------------
	// CONSTANTES
	//------------------------------------------------------------------------
	
	/**
	 * Es el que identifica si es un heap max
	 */
	public final static int MAX = 0;
	
	/**
	 * Es el que identifica si es un heap min
	 */
	public final static int MIN = 1;
	
	// ----------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------

	/**
	 * Arreglo de nodos
	 */
	private NodeHeap<K,T>[] content;

	/**
	 * Cantidad de elementos
	 */
	private int size;
	
	/**
	 * Tipo de Heap
	 */
	private int tipo;

	// ----------------------------------------------
	// CONSTRUCTORES
	// ----------------------------------------------

	/**
	 * Se crea el heap inicializando el arreglo
	 * @param tamanio int con el tamanio del arreglo
	 */
	@SuppressWarnings("unchecked")
	public Heap(int tamanio, int tipo) {
		this.tipo = tipo;
		content = new NodeHeap[tamanio];
		size = -1;
	}

	// -----------------------------------------------
	// METODOS
	// -----------------------------------------------

	/**
	 * Metodo que agrega un nodo al heap
	 * @param key clave del nodo
	 * @param element elemento del nodo
	 */
	public void add(K key, T element) {
		boolean agregue = false;
		for (int i = 0; i < content.length && !agregue; i++) {
			if (content[i] == null) {
				content[i] = new NodeHeap<K, T>(key, element);
				size++;
				buildHeap();
				agregue = true;
			}
		}
	}
	
	/**
	 * Metodo que elimina un nodo del heap 
	 * @param key clave del nodo
	 */
	public void remove(K key) throws HeapException {
		boolean encontre = false;
		int index = -1;
		for (int i = 0; i <= heapSize() && !encontre; i++) {
			if (content[i].getKey().equals(key)) {
				encontre = true;
				index = i;
			}
		}
		if (index == -1) {
			throw new HeapException("El key " + key + " no se encuentra dentro del heap");
		}
		content[index] = content[heapSize()];
		content[heapSize()] = null;
		size--;
	}

	/**
	 * Metodo que busca un elemento en el heap 
	 * @param key clave del nodo
	 * @return el elemento, si no se encuentra nada retorna null
	 */
	public T search(K key) {
		boolean encontre = false;
		NodeHeap<K, T> newNode = null;
		for (int i = 0; i < heapSize() && !encontre; i++) {
			if (content[i].getKey().equals(key)) {
				encontre = true;
				newNode = content[i];
			}
		}
		return (encontre == true) ? newNode.getElement() : null;
	}

	
	/**
	 * Metodo que convierte un sub-arbol en heap max
	 * <b> Precondicion: </b> El padre debe cumplir la propiedad del heap max
	 * @param content arreglo con los elementos del heap max
	 * @param i indice del heap max
	 */
	public void maxHeapify(NodeHeap<K, T>[] content, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
	    
		if (l <= heapSize() && content[i].getKey().compareTo(content[l].getKey()) < 0) {
			largest = l;
		} else {
			largest = i;
		}
		if (r <= heapSize()
				&& content[largest].getKey().compareTo(content[r].getKey()) < 0) {
			largest = r;
		}
		if (largest != i) {
			NodeHeap<K, T> temp = content[i];
			content[i] = content[largest];
			content[largest] = temp;
			maxHeapify(content,largest);
		}
	}
	

	/**
	 * Metodo que convierte un sub-arbol en heap min
	 * <b> Precondicion: </b> El padre debe cumplir la propiedad del heap min
	 * @param content arreglo con los elementos del heap min
	 * @param i indice del heap min
	 */
	public void minHeapify(NodeHeap<K, T>[] content, int i) {
		int l = left(i);
		int r = right(i);
		int largest = 0;
	    
		if (l <= heapSize() && content[i].getKey().compareTo(content[l].getKey()) > 0) {
			largest = l;
		} else {
			largest = i;
		}
		if (r <= heapSize()
				&& content[largest].getKey().compareTo(content[r].getKey()) > 0) {
			largest = r;
		}
		if (largest != i) {
			NodeHeap<K, T> temp = content[i];
			content[i] = content[largest];
			content[largest] = temp;
			minHeapify(content,largest);
		}
	}

	/**
	 * Metodo que convierte un arreglo en un heap
	 */
	public void buildHeap(){
		for (int i = p(heapSize()); i >= 0; i = p(i)) {
			switch (tipo) {
			case MAX:
				maxHeapify(content, i);
				break;
			case MIN:
				minHeapify(content, i);
				break;
			}
		}
	}
	
	/**
	 * Metodo de ordenamiento se encarga de ordenar ascendentemente </br>
	 * si es un heapMax y descendentemente si es un heapMin
	 */
	
	public void heapSort() {
		for (int i = heapSize(); i >= 1; i--) {
			NodeHeap<K, T> temp = content[0];
			content[0] = content[i];
			content[i] = temp;
			size = size - 1;
			switch (tipo) {
			case MAX:
				maxHeapify(content, 0);
				break;
			case MIN:
				minHeapify(content, 0);
				break;
			}
		}
	}

	/**
	 * @return int con la posicion del nodo heap
	 */
	public int root() {
		return 0;
	}

	/**
	 * Nodo Padre 
	 * @param i int con la poscion dada como parametro
	 * @return int con la posicion del padre
	 */
	public int p(int i) {
		return (i==0) ? -1:((i -1)/ 2);
	}

	/**
	 * Nodo derecho 
	 * @param i int con la poscion dada como parametro
	 * @return int con la posicion del nodo derecho
	 */
	public int right(int i) {
		return (2 * i) + 2;
	}

	/**
	 * Nodo izquierdo 
	 * @param i int con la poscion dada como parametro
	 * @return int con la posicion del nodo izquierdo
	 */
	public int left(int i) {
		return (2 * i)+1;
	}

	/**
	 * Tamanio del heap
	 * @return int con el tamenio del heap
	 */
	public int heapSize() {
		return size;
	}

	public String toString() {
		String mensaje = "";
		for (int i = 0; i < content.length; i++) {
			mensaje += " [ " + content[i] + " ]  ";
		}
		return mensaje;
	}
	
	//----------------------------------------------------------------
	// Priority Queue
	//----------------------------------------------------------------

	
	public NodeHeap<K, T> heapMaximun() {
		if (tipo == MAX) {
			return content[0];
		}
		return null;
	}
	
	public NodeHeap<K, T> heapExtractMaximun() throws HeapException {
		if (size < 0) {
			throw new HeapException("Capacidad inferior en el heap");
		}
		NodeHeap<K, T> maximun = content[0];
		content[0] = content[heapSize()];
		content[heapSize()] = null;
		size = size - 1;
		maxHeapify(content, 0);
		return maximun;
	}
	
	public void heapIncreaseKey(int i, K key)throws HeapException{
		if(key.compareTo(content[i].getKey()) < 0){
			throw new HeapException("La nueva clave es mas pequeña que la clave anterior");
		}
		content[i].setKey(key);
		while(i>0 && content[p(i)].getKey().compareTo(content[i].getKey()) < 0){
			NodeHeap<K, T> temp = content[i];
			content[i] = content[p(i)];
			content[p(i)] = temp;
			i = p(i);
		}
		
	}
	
	public void maxHeapInsert(K key,T element) throws HeapException{
		NodeHeap<K, T> newNode = new NodeHeap<K,T>(key, element);
		size = size + 1;
		content[heapSize()] = newNode; 
		heapIncreaseKey(heapSize(), key);
	}
}
