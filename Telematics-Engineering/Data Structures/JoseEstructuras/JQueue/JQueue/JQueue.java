package JQueue;

public class JQueue<T> implements IQueue<T> {

	private Node<T> first;

	private Node<T> last;

	public JQueue() {
		crear();
	}

	@Override
	public void enqueue(T elelment) {
		Node<T> newNode = new Node<T>(elelment);
		if (first == null) {
			first = last = newNode;
		} else {
			last.setNext(newNode);
			newNode.setPrev(last);
			last = newNode;
		}
	}

	@Override
	public void dequeue() {
		if (first != null) {
			first = first.getNext();
		}
	}

	@Override
	public void clear() {
		first = null;
		last = null;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public T getFront() {
		return first.getElement();
	}

	@Override
	public void crear() {
		first = null;
		last = null;
	}

	@Override
	public String toString() {

		String mensaje = "";
		for (Node<T> actual = first; actual != null; actual = actual
				.getNext()) {
			mensaje += actual.toString() + "\n";
		}
		return mensaje;
	}
}
