package JHashTableDinamic;

public interface IHashTable<V,K> {
	
	public void create();
	
	public int hash(K key);
	
	public void insert(V value, K key) throws Exception;
	
	public V search(K key);
	
	public void remove(K key);
	
	public void rehash();
}