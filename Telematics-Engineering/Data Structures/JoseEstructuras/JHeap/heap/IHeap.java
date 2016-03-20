package heap;

public interface IHeap<K extends Comparable<? super K>,T> {
	
	public void add(K key,T element) throws Exception;
	
	public void buildHeap() throws Exception;
	
	public void maxHeapify(NodeHeap<K, T>[] content, int i);
	
	public void minHeapify(NodeHeap<K, T>[] content, int i);
	
	public int heapSize();
	
	public int left(int index);
	
	public int right(int index);
	
	public int p(int index);
	
	public int root();

}
