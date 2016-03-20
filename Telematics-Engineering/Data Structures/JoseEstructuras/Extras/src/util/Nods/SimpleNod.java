package src.util.Nods;

public class SimpleNod<T> implements Nodo<T> {
	
	private T data;
	private SimpleNod<T> next;
	
	public SimpleNod(T e){
		this.data=e;
		next=null;
	}

	public T getData() {
		return data;
	}

	

	public SimpleNod<T> getNext() {
		return next;
	}

	public void setNext(SimpleNod<T> next) {
		this.next = next;
	}

	
	
	
	

}
