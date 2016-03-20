package src.util.hashTable;

public interface IHashTable<K, T> {
	
	public void add(K key, T data) throws Exception;
	public void remove(K key) throws Exception;
	public T get(K key) throws Exception;
	public int hashFunction(K key);
	public void create(int capacity);
	public boolean isFull();
	

}
