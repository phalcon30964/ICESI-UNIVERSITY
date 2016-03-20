package JQueuePriority;

public class JQueuePriority<T extends Comparable<T>, E> implements IQueue<T, E> {

	private NodePriority<T, E> first;

	private NodePriority<T, E> last;

	private int size;

	public JQueuePriority() {
		first = null;
		last = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public void enqueue(E elemento, T prioridad) {
		NodePriority<T, E> nuevo = new NodePriority<T, E>(elemento, prioridad);

		if (first == null) {
			first = last = nuevo;
		} else if (first.getPrioridad().compareTo(prioridad) < 0) {
			nuevo.insertarDespues(first);
			first = nuevo;
		} else {
			NodePriority<T, E> actual = first;
			boolean salir = false;
			while (!salir && actual.getNext() != null) {

				if (actual.getNext().getPrioridad().compareTo(prioridad) < 0) {
					nuevo.insertarDespues(actual.getNext());
					actual.insertarDespues(nuevo);
					salir = true;
				}
				actual = actual.getNext();
			}
			if (!salir) {
				last = last.insertarDespues(nuevo);
			}
		}
		size++;
	}

	public void dequeue() {
		if (first != null) {
			first = first.quitarPrimero();
			if (first == null) {
				last = null;
			}
			size--;
		}
	}

	public E getFront() {
		return (first != null) ? first.getElemento() : null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	@Override
	public String toString() {
		String resp = "";
		for (NodePriority<T, E> actual = first; actual != null; actual = actual
				.getNext()) {
			resp += actual.toString();
		}
		return resp;
	}

	@Override
	public void clear() {
		first = last = null;
	}

}
