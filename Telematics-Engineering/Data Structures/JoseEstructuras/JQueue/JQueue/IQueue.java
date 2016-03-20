package JQueue;

public interface IQueue<T> {

	public void crear();
	
	public  void enqueue(T elelment);
	
	public void dequeue();
	
	public void clear();
	
	public boolean isEmpty();
	
	public T getFront();
	
	
}
