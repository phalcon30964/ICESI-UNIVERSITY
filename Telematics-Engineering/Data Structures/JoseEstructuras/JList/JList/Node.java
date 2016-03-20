package JList;

public class Node<T> {

	private Node<T> next;
	
	private Node<T> prev;

	private T element;
	
	private int index;

	public Node(T element) {
		this.element = element;
		index = 0;
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> nodo) {
		this.next = nodo;
	}
	
	public Node<T> getPrev() {
		return prev;
	}
	
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	
	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public int getIndex(){
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		//return "[ " + element + ", posicion = " + index + "] \n 	| \n 	V \n";
		return "[ " + element + " ] -> ";
	}

}