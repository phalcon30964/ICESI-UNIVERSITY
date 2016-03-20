package JQueuePriority;

public class NodePriority<T extends Comparable<? super T>, E> {

	private T prioridad;

	private E elemento;

	private NodePriority<T, E> next;

	public NodePriority(E elemento, T prioridad) {
		this.elemento = elemento;
		this.prioridad = prioridad;
		this.next = null;
	}

	public T getPrioridad() {
		return prioridad;
	}

	public E getElemento() {
		return elemento;
	}

	public NodePriority<T, E> quitarPrimero() {

		NodePriority<T, E> retirar = next;
		next = null;
		return retirar;
	}

	public NodePriority<T, E> insertarDespues(NodePriority<T, E> nuevo) {
		next = nuevo;
		return nuevo;
	}

	public NodePriority<T, E> getNext() {
		return next;
	}

	@Override
	public String toString() {
		return elemento.toString() + "\n";
	}
}
