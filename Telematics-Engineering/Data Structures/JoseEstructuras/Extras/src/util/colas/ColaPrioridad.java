package src.util.colas;

import src.util.Nods.PriorityNod;

public class ColaPrioridad<T> implements ICola<T> {

	private PriorityNod<T> first;

	public ColaPrioridad() {
		create();
	}

	@Override
	public void create() {
		first = null;

	}

	@Override
	public boolean isEmpty() {
		return (first == null) ? true : false;
	}

	@Override
	public void clear() {
		first = null;

	}

	@Override
	public void dequeue() {
		first = first.getNext();

	}

	public void enqueue(T e, int priority) {
		PriorityNod<T> nuevo = new PriorityNod<T>(e, priority);
		if (isEmpty()) {
			first = nuevo;

		} else if (nuevo.getPriority() > first.getPriority()) {

			nuevo.setNext(first);
			nuevo.setPrev(first.getPrev());
			first.setPrev(nuevo);
			first = nuevo;

		} else {

			PriorityNod<T> actual = first;

			while (actual.getPriority() >= nuevo.getPriority() && actual.getNext() != null) {
				actual = actual.getNext();
			}
			if(actual.getNext()==null){
			nuevo.setNext(actual.getNext());
			actual.setNext(nuevo);
			}else{
				
				nuevo.setPrev(actual.getPrev());
				actual.getPrev().setNext(nuevo);
				actual.setPrev(nuevo);
				nuevo.setNext(actual);				
								
				
			}
		}

	}

	@Override
	public T getFront() {
		
		return first.getData();
	}

	public int getFPriority() {
		return first.getPriority();
	}

	@Override
	public void enqueue(T e) {

	}

}
