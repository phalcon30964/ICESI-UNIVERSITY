package src.util.colas;

public interface ICola<T> {
	
	public void create();
	public boolean isEmpty();
	public void clear();
	public void dequeue();
	public void enqueue(T e);
	public T getFront();

}
