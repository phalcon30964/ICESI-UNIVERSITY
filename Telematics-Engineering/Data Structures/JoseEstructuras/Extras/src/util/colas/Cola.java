package src.util.colas;

import src.util.Nods.SimpleNod;

public class Cola<T> implements ICola<T> {
	
	private SimpleNod<T> first;
	private SimpleNod<T> last;

	@Override
	public void create() {
		first=null;
		last=null;
		
	}

	@Override
	public boolean isEmpty() {
		
		return (first==null)? true:false;
	}

	@Override
	public void clear() {
		first=null;
		last=null;
		
	}

	@Override
	public void dequeue() {
		first=first.getNext();
		
	}

	@Override
	public void enqueue(T e) {
		SimpleNod<T> nuevo=new SimpleNod<T>(e);
		if(isEmpty()){
			first=nuevo;
			last=nuevo;
		}else{
			last.setNext(nuevo);
			last=nuevo;
		}
		
	}

	@Override
	public T getFront() {
		return first.getData();
	}
	
	

}
