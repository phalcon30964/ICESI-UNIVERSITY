package Cola;

public interface ICola<T> {
	public void enQueue(T valor);
	public T deQueue();
	public boolean isEmpty();
	public T getFront();
	public T getBack();
	public void clear();
	

}
