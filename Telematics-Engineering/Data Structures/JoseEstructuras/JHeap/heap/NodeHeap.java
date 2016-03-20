package heap;

public class NodeHeap<K extends Comparable<? super K>, T> {

	//-------------------------------------------------------
	// Atributos
	//-------------------------------------------------------
	
	private T element;
	
	private K key;
	
	//-------------------------------------------------------
	// Constructor
	//-------------------------------------------------------
	
	public NodeHeap(K key, T element){
		
		this.key = key;
		this.element = element;
	}
	
	//-------------------------------------------------------
	// Metodos
	//-------------------------------------------------------

	/**
	 * @return the element
	 */
	public T getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(T element) {
		this.element = element;
	}

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}
	
	public String toString(){
		return (element == null && key == null) ? null : key +" - " +  element;
	}

}
