package src.util.pilas;

import src.util.Nods.DoubleNod;

public class NodPila<T> implements Pila<T> {

	private DoubleNod<T> first;
	
	public NodPila(){
		create();
	}
	
	public void create() {
		first=null;
		
	}
	

	
	public void push(T e) {
		DoubleNod<T> nuevo=new DoubleNod<T>(e);
		
		if(isEmpty()){
			first=nuevo;
		}else{
			first.setPrev(nuevo);
			nuevo.setNext(first);
			first=nuevo;
		}
	}

	
	public void pop() {
		first=first.getNext();
		
	}

	
	public T peek() {
		return first.getData();
	}

	
	public boolean isEmpty() {
		return (first==null)? true:false;
	}

	
	public void clear() {
		first=null;
		
	}
	

}
