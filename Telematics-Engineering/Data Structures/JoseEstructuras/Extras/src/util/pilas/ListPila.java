package src.util.pilas;

import src.util.listas.SimpleLinkedList;

public class ListPila<T> implements Pila<T> {
	
	private SimpleLinkedList<T> laLista;;

	
	public void create() {
		laLista=new SimpleLinkedList<T>();
		
	}
	
	public ListPila(){
		create();
	}

	@Override
	public void push(T e) {
		laLista.addAtbeginning(e);
		
	}

	@Override
	public void pop() {
		laLista.remove(0);
		
	}

	@Override
	public T peek() {
		return laLista.getFirst().getData();
	}

	@Override
	public boolean isEmpty() {
		return laLista.isEmpty();
	}

	@Override
	public void clear() {
		laLista=null;
		
	}

}
