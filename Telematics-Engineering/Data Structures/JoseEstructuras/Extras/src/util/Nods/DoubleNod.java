package src.util.Nods;

public class DoubleNod<T> implements Nodo<T> {
	
	private T data;
	private DoubleNod<T> next;
	private DoubleNod<T> prev;
	
	public DoubleNod(T e){
		this.data=e;
		next=null;
		prev=null;
	}
	
	

	public DoubleNod<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = (DoubleNod<T>) next;
	}

	public T getData() {
		return data;
	}

	public void setContenido(T contenido) {
		this.data = contenido;
	}
		

	public DoubleNod<T> getPrev() {
		return prev;
	}

	public void setPrev(Nodo<T> prev) {
		this.prev = (DoubleNod<T>) prev;
	}
	
	

}
