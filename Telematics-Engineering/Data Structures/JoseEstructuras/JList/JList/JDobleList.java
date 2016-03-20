package JList;

import java.util.Iterator;

public class JDobleList<T> implements IList<T>, Iterable<T> {

	// ------------------------------------------------------
	// Atributos
	// ------------------------------------------------------

	private Node<T> first;

	private Node<T> last;

	private int size;

	// -------------------------------------------------------
	// Constructor
	// -------------------------------------------------------

	public JDobleList() {
		first = last = null;
		size = 0;
	}

	// --------------------------------------------------------
	// Metodos
	// --------------------------------------------------------

	@Override
	public void add(T element) {
		Node<T> newNode = new Node<T>(element);
		if (first == null) {
			first = last = newNode;
			size++;
			newNode.setIndex(size);
		} else {
			last.setNext(newNode);
			newNode.setPrev(last);
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
			first.setPrev(newNode);
			first = newNode;
			size++;
			newNode.setIndex(size);
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
			newNode.setPrev(last);
			last = newNode;
			size++;
			newNode.setIndex(size);
		}
	}

	@Override
	public void addIndex(int index, T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
	}

	@Override
	public void removeFirst() throws Exception {
		if (first.getNext() != null) {
			Node<T> next = first.getNext();
			next.setPrev(null);
			first = next;
		}
	}

	@Override
	public void removeLast() {
		if (first.getNext() != null) {
			Node<T> prev = last.getPrev();
			prev.setNext(null);
			last = prev;
		} else {
			first = null;
		}
	}

	@Override
	public void removeIndex(int index) {
		Node<T> actual = first;
		while(actual != null){
			if(actual.getIndex() == index  && actual == first){
				first = actual.getNext();
			}
			else if (actual.getIndex() == index){
				actual.getPrev().setNext(actual.getNext());
				actual.getNext().setPrev(actual.getPrev());
			}
			actual = actual.getNext();
		}
		
		
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public T getFirst() {
		return (first != null) ? first.getElement() : null;
	}

	@Override
	public T getLast() {
		return (last != null) ? last.getElement() : null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		String cadena = "";
		Node<T> actual = first;
		while (actual != null) {
			cadena += actual;
			actual = actual.getNext();
		}
		cadena +=  null;
		return cadena;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unused")
	private void aumenarIndex(Node<T> temp, int index) {
		Node<T> actual = temp;
		while (actual != null) {
			actual.setIndex(index);
			actual = actual.getNext();
			index++;
		}
	}

	@Override
	public T search(T element) {
		// TODO Auto-generated method stub
		return null;
	}
}
