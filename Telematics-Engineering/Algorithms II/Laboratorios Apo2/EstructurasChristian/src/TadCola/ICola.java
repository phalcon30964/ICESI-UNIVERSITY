package TadCola;

public interface ICola<T>{
	
	public void enQueue(T elemento);
	
	public T deQueue();
	
	public boolean isEmpty();
	
	public void clear();
	
	public T getFront();
	
	public T getBack();

}
