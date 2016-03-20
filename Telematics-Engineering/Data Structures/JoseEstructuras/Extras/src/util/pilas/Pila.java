package src.util.pilas;

public interface Pila<T> {
	
	public void create();
	public void push(T e);
	public void pop();
	public T peek();
	public boolean isEmpty();
	public void clear();

}
