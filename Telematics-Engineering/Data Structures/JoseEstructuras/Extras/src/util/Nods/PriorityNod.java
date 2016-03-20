package src.util.Nods;

public class PriorityNod<T> implements Nodo<T> {
	
	private T data;
	private PriorityNod<T> next;
	private PriorityNod<T> prev;
	private int priority;
	
	public PriorityNod(T e, int p){
		this.data=e;
		this.priority=p;
		next=null;
	}
	
	public int getPriority(){
		return priority;
	}

	public T getData() {
		return data;
	}

	

	public PriorityNod<T> getNext() {
		return next;
	}

	public void setNext(PriorityNod<T> next) {
		this.next = next;
	}
	
	public PriorityNod<T> getPrev(){
		return prev;
	}
	public void setPrev(PriorityNod<T> prev){
		this.prev=prev;
	}


	

}
