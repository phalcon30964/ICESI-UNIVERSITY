package JQueuePriority;

public interface IQueue<T,E> {

	
	public  void enqueue(E elemento, T prioridad);
	
	public void dequeue();
	
	public void clear();
	
	public boolean isEmpty();
	
	public E getFront();
	
}
