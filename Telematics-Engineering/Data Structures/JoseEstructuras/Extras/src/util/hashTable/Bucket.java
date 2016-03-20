package src.util.hashTable;

public class Bucket<K,T> implements IBucket<K,T> {
	
	private K key;
	private T data;
	
	public Bucket(K key, T data){
		this.key=key;
		this.data=data;
	}

	@Override
	public T getData() {
		
		return data;
	}

	@Override
	public K getKey() {
		
		return key;
	}

}
