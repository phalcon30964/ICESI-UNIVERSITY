package src.util.hashTable;

public class DirectHashTable<K, T> implements IHashTable<K, T> {

	private Bucket<K, T>[] buckets;
	private int size;
	private int capacity;

	public DirectHashTable(int capacity) {
		create(capacity);
	}

	@Override
	public void add(K key, T data) throws Exception {
		Bucket<K, T> bucket = new Bucket<K, T>(key, data);
		int i = hashFunction(key);
		int k = 0;
		int j = capacity - size;
		boolean agrego = false;
		if (isFull()) {
			throw new Exception("la tabla esta llena");
		} else {
			if (buckets[i] == null) {
				buckets[i] = bucket;
				size++;
			} else if (buckets[i].getKey().equals(key)) {
				throw new Exception("la llave: " + key + " , ya existe");
			} else {
				for (int n = 0; !agrego && n < k; n++) {
					k = (int) (i + Math.pow(n, 2));
					if (k >= capacity - 1) {
						k = k % capacity;
					}
					if (buckets[k] == null) {
						buckets[k] = bucket;
						agrego = true;
						size++;
					} else if (buckets[k].getKey().equals(key)) {
						throw new Exception("la llave: " + key + " , ya existe");
					}
				}
			}
		}

	}

	public void remove(K key) throws Exception {

		int i = hashFunction(key);
		int j = capacity - size;
		int k = 0;
		int contadornulls = 0;
		if(buckets[i]==null){
			throw new Exception("la llave a remover no existe");
		}
		else if (buckets[i].getKey().equals(key)) {
			buckets[i] = null;
			size--;

		} else {
			outer: 
				for (int n = 0; contadornulls < j; n++) {
				k = (int) (i + Math.pow(n, 2));
				if (k >= capacity - 1) {
					k = k % capacity;
				}
				if (buckets[k] == null) {
					contadornulls++;
					break outer;
				} else if (buckets[k].getKey().equals(key)) {
					buckets[k] = null;
					size--;

				}
			}
		}

	}

	@Override
	public T get(K key) throws Exception {
		T data = null;
		int i = hashFunction(key);
		int j = capacity - size;
		int k = 0;
		int contadornulls = 0;
		boolean encontro = false;
		if (buckets[i] == null) {
			data = null;
		} else if (buckets[i].getKey().equals(key)) {
			data = buckets[i].getData();

		} else {
			outer: 
				for (int n = 0; contadornulls < j && !encontro; n++) {
				k = (int) (i + Math.pow(n, 2));
				if (k >= capacity - 1) {
					k = k % capacity;
				}
				if (buckets[k] == null) {
					contadornulls++;
					break outer;

				} else if (buckets[k].getKey().equals(key)) {
					data = buckets[k].getData();
					encontro = true;

				}
			}
		}
		if (data == null) {
			throw new Exception("No existe una entrada para esa llave");
		} else {
			return data;
		}

	}

	@Override
	public int hashFunction(K key) {
		int num = (key.hashCode()) % capacity;
		return num;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(int capacity) {
		buckets = new Bucket[capacity];
		this.capacity = capacity;
		this.size = 0;

	}

	@Override
	public boolean isFull() {
		return size == capacity ? true : false;
	}

}
