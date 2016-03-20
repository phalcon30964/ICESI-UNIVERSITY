package src.util.hashTable;

import src.util.listas.SimpleLinkedList;

public class LinkedHash<K,T> implements IHashTable<K, T> {
	
	private SimpleLinkedList<Bucket<K,T>>[] tabla;
	private int size;
	private int capacity;
	
	public LinkedHash(int capacity){
		create(capacity);
	}
	
	@Override
	public void add(K key, T data) throws Exception {
		int i = hashFunction(key);
		Bucket<K,T> bucket = new Bucket<K,T>(key,data);
		tabla[i].add(bucket);
		
	}

	@Override
	public void remove(K key) throws Exception {
		int i = hashFunction(key);
		boolean elimino =false;
		for (int j = 0; j < tabla[i].getSize() && !elimino; j++) {
			if(key.equals(tabla[i].get(j).getKey())){
				tabla[i].remove(j);
				elimino=true;
			}
		}
		
	}

	@Override
	public T get(K key) throws Exception {
		int i = hashFunction(key);
		boolean encontro =false;
		T data=null;
		for (int j = 0; j < tabla[i].getSize() && !encontro; j++) {
			if(key.equals(tabla[i].get(j).getKey())){
				
				encontro=true;
				data= tabla[i].get(j).getData();
			}
		}
		return data;
	}

	@Override
	public int hashFunction(K key) {
		int num = (key.hashCode()) % capacity;
		return num;
	}

	@Override
	public void create(int size) {
		tabla= new SimpleLinkedList[capacity];
		this.capacity=capacity;
		this.size=0;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return (size==capacity);
	}

}
