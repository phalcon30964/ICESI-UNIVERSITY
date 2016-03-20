package src.util.listas;

public interface List<T> {
	
	public T get(int i);
	public boolean isEmpty();
	public void add(T e);
	public void remove(int i);
	public int getSize();
	
}
