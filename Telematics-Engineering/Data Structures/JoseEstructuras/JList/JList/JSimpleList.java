package JList;


public class JSimpleList<T> implements IList<T>{
	
	//-------------------------------------------------------
	// Atributos
	//-------------------------------------------------------

	protected Node<T> first;

	protected Node<T> last;
	
	@SuppressWarnings("unused")
	private T[] contenedor;

	private int size;
	
	//-------------------------------------------------------
	// Constructor
	//-------------------------------------------------------

	public JSimpleList() {
		first = last = null;
		size = 0;
	}
	
	//-------------------------------------------------------
	// Metodos
	//-------------------------------------------------------

	@Override
	public void add(T element) {
		Node<T> newNode = new Node<T>(element);
		if (first == null) {
			first = last = newNode;
			size++;
			newNode.setIndex(size);
		} else {
			last.setNext(newNode);
			last = newNode;
			size++;
			newNode.setIndex(size);
		}
	}

	@Override
	public void addFirst(T element) {
		Node<T> newNode = new Node<T>(element);
		if (first == null) {
			first = last = newNode;
			size++;
			newNode.setIndex(size);
		} else {
			newNode.setNext(first);
			first = newNode;
			newNode.setIndex(size);
			size++;
		}
	}

	@Override
	public void addLast(T element) {
		Node<T> newNode = new Node<T>(element);
		if (first == null) {
			first = last = newNode;
			size++;
			newNode.setIndex(size);
		} else {
			last.setNext(newNode);
			last = newNode;
			size++;
			newNode.setIndex(size);
		}
	}

	@Override
	public void addIndex(int index, T element) {
		Node<T> newNode = new Node<T>(element);
		if (first == null) {
			first = newNode;
			size++;
			newNode.setIndex(size);
		} else {
			Node<T> actual = first;
			boolean salir = false;
			while (actual.getNext() != null) {
				if (!salir && actual.getNext().getIndex() >= index) {
					newNode.setNext(actual.getNext());
					actual.setNext(newNode);
					aumenarIndex(newNode, index);
					size++;
					salir = true;
				}
				actual = actual.getNext();
			}
			if (!salir) {
				actual.setNext(newNode);
				size++;
				newNode.setIndex(size);
			}
		}
	}

	@Override
	public T search(T element) {
		T encontre = null;
		Node<T> actual = first;
		boolean salir = false;
		while(!salir && actual != null)
		{
			if(actual.getElement().equals(element)){
				encontre = actual.getElement();
				salir = true;
			}
			actual = actual.getNext();
		}
		return encontre;
	}
	@Override
	public void remove(T element) {
		Node<T> actual = first;
		if (actual != null && actual.getElement().equals(element)) {
			first = actual.getNext();
		} else {
			while (actual.getNext() != null) {
				if (actual.getNext().getElement().equals(element)) {
					Node<T> newNodo = actual.getNext();
					actual.setNext(newNodo.getNext());
				}
				actual = actual.getNext();
			}
			aumenarIndex(first, 1);
		}
	}

	@Override
	public void removeFirst() throws Exception {
		if (first != null) {
			Node<T> actual = first;
			if (actual.getNext() != null) {
				first = actual.getNext();
			} else {
				first = null;
			}
		} else {
			new Exception("No hay elementos en la lista");
		}
	}

	@Override
	public void removeLast() {
		Node<T> actual = first;
		while (actual.getNext().getNext() != null) {
			actual = actual.getNext();
		}
		actual.setNext(null);
		last = actual;
	}

	@Override
	public void removeIndex(int index) {
		Node<T> actual = first;
		if (first.getIndex() == index) {
			first = actual.getNext();
		} else {
			while (actual != null) {
				if (actual.getIndex() == index) {
					Node<T> segundo = actual.getNext();
					Node<T> tercero = segundo.getNext();
					actual.setNext(tercero);
				}
				actual = actual.getNext();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public T[] contenedor(){
		return contenedor = (T[])new Object[size()];
	}

	@Override
	public String toString() {
		String cadena = "";
		Node<T> actual = first;
		while (actual != null) {
			cadena += actual;
			actual = actual.getNext();
		}
		cadena += " " + null;
		return cadena;
	}

	@Override
	public boolean isEmpty() {
		return (first == null);
	}

	@Override
	public T getFirst() {
		return first.getElement();
	}

	@Override
	public T getLast() {
		return last.getElement();
	}

	@Override
	public int size() {
		return size;
	}
	
	public Node<T> getPrimero(){
		return first;
	}

	private void aumenarIndex(Node<T> temp, int index) {
		Node<T> actual = temp;
		while (actual != null) {
			actual.setIndex(index);
			actual = actual.getNext();
			index++;
		}
	}


}
