package JQueue;


public class Node<T> {

	@Override
	public String toString() {
		return "[ " + element + " ]  ";
	}

	private Node<T> next;

	private Node<T> prev;

	private T element;

	public Node(T element) {
		this.setElement(element);
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrev() {
		return prev;
	}

	public void setPrev(Node<T> anterior) {
		this.prev = anterior;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

}
