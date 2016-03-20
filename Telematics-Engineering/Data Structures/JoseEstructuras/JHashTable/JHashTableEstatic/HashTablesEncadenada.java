package JHashTableEstatic;

import JList.JSimpleList;

public class HashTablesEncadenada<V, K> {

	private static int TABLE_SIZE = 100;

	private JSimpleList<Bucket<V, K>>[] contenedor;

	private int tamanioTabla;

	private int tamanioElementos;

	public HashTablesEncadenada() {
		create();
	}

	public HashTablesEncadenada(int size) {
		create(size);
	}

	@SuppressWarnings("unchecked")
	public void create() {
		tamanioTabla = TABLE_SIZE;
		contenedor = new JSimpleList[TABLE_SIZE];
		tamanioElementos = 0;
	}

	@SuppressWarnings("unchecked")
	public void create(int size) {
		this.tamanioTabla = size;
		contenedor = new JSimpleList[size];
		tamanioElementos = 0;
	}

	public int hash(K key) {
		int hash = key.hashCode() % tamanioTabla;
		if (hash < 0)
			hash += tamanioTabla;
		return hash;
	}

	public void insert(V value, K key) throws Exception {
		Bucket<V, K> node = new Bucket<V, K>(value, key);
		int indice = hash(key);
		if (contenedor[indice] == null) {
			contenedor[indice] = new JSimpleList<>();
		}
		contenedor[indice].add(node);
		tamanioElementos++;
	}

	public V search(V value, K key) {
		Bucket<V, K> node = new Bucket<V, K>(value, key);
		int indice = hash(key);

		return (contenedor[indice].search(node) != null) ? contenedor[indice]
				.search(node).getValue() : null;
	}

	public void remove(V value, K key) {
		Bucket<V, K> node = new Bucket<V, K>(value, key);
		int indice = hash(key);
		contenedor[indice].remove(node);
		tamanioElementos--;
	}

	public String toString() {
		String mensaje = "";
		for (int i = 0; i < contenedor.length; i++) {
			if (contenedor[i] != null) {
				mensaje += "[ " + contenedor[i] + " ] \n";
			} else {
				mensaje += "[ " + null + " ] \n";
			}
		}
		return mensaje;
	}
}
