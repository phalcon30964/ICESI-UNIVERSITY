package JStack;

public class JStack<T> implements IStack<T> {

	private Node<T> first;

	public JStack() {
		first = null;
	}

	/**
	 * Agrega un elmemento en la pila
	 */
	@Override
	public void push(T element) {
		Node<T> actual = first;
		Node<T> nuevo = new Node<T>(element);

		if (actual == null) {
			first = nuevo;
		} else {
			nuevo.setNext(first);
			first = nuevo;
		}
	}

	/**
	 * Elimina el elemento en el tope de la pila
	 */
	@Override
	public void pop() {
		if (first != null) {
			Node<T> next = first.getNext();
			first = next;
		}
	}

	/**
	 * Retorna el ultimo elemento de la pila
	 */
	@Override
	public T peek() {
		if (first != null) {
			return first.getElement();
		} else {
			return null;
		}
	}

	/**
	 * Determina si la pila esta vacio retorna true en caso de serlo de lo
	 * contrario retorna false.
	 */
	@Override
	public boolean isEmpty() {
		return (first == null);
	}

	/**
	 * Metodo toString.
	 */
	@Override
	public String toString() {

		Node<T> actual = first;
		String mensaje = "";
		while (actual != null) {
			mensaje += "[ " + actual.getElement() + " ] ";
			actual = actual.getNext();
		}
		return mensaje;
	}

	/**
	 * Elimina todos los elementos de la pila
	 */
	@Override
	public void clear() {
		first = null;
	}

}
