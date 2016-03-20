package JHashTableEstatic;

//TODO TABLA HASH DIRECTA HECHA POR SONDEO CUADRATICO.

public class HashTableDirect<V, K> implements IHashTable<V, K> {

	// ----------------------------------------------------------
	// Constatntes
	// ----------------------------------------------------------

	private static final int TABLE_SIZE = 17;

	// ----------------------------------------------------------
	// Atributos
	// ----------------------------------------------------------

	private double tamanioElementos;

	private double tamanioTabla;

	private Bucket<V, K>[] contenedor;

	// -----------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------

	public HashTableDirect() {
		create();
	}

	public HashTableDirect(int size) {
		create(size);
	}

	// ------------------------------------------------------------
	// Metodos
	// ------------------------------------------------------------

	@SuppressWarnings("unchecked")
	@Override
	public void create() {
		tamanioTabla = TABLE_SIZE;
		contenedor = new Bucket[TABLE_SIZE];
		tamanioElementos = 0;
	}

	@SuppressWarnings("unchecked")
	public void create(int size) {
		this.tamanioTabla = size;
		contenedor = new Bucket[size];
		tamanioElementos = 0;
	}

	@Override
	public int hash(K key) {
		int hash = (int) (key.hashCode() % tamanioTabla);
		if (hash < 0)
			hash += tamanioTabla;
		return hash;
	}

	@Override
	public void insert(V value, K key) throws Exception {

		int indice = hash(key);
		int lineal = 1;
		boolean stop = false;
		Bucket<V, K> nuevo = new Bucket<V, K>(value, key);

		if (contenedor[indice] == null) {
			contenedor[indice] = nuevo;
			tamanioElementos++;
		} else {
			while (!stop && search(key) == null) {
				int sondeo = indice + lineal;
				if (sondeo >= tamanioTabla) {
					sondeo = (int) (sondeo % tamanioTabla);
				}
				if (contenedor[sondeo] == null) {
					contenedor[sondeo] = nuevo;
					tamanioElementos++;
					stop = true;
				} else {
					lineal++;
				}
				if (tamanioElementos == tamanioTabla) {
					stop = true;
				}
				sondeo = indice;
			}
			if (search(key) != null) {
				throw new Exception("Ya existe esta clave en la tabla " + "[ "
						+ key + " ] ");
			}
		}
	}

	@Override
	public V search(K key) {
		int indice = hash(key);
		Bucket<V, K> encontre = null;
		Bucket<V, K> primero = contenedor[hash(key)];
		boolean stop = false;
		int lineal = 1;

		if (contenedor[indice] != null) {
			if (contenedor[indice].getKey().equals(key)) {
				encontre = contenedor[indice];
			} else {
				while (!stop) {
					int sondeo = (int) (indice + Math.pow(lineal, 2));
					if (sondeo >= tamanioTabla) {
						sondeo = (int) (sondeo % tamanioTabla);
					}

					if (contenedor[sondeo] != null
							&& contenedor[sondeo].getKey().equals(key)) {
						encontre = contenedor[sondeo];
						stop = true;
					} else {
						lineal++;
					}

					if (contenedor[sondeo] == primero) {
						stop = true;
					}
					sondeo = indice;
				}
			}
		}
		V elemento = (encontre != null) ? encontre.getValue() : null;

		return elemento;
	}

	@Override
	public void remove(K key) {
		int indice = hash(key);

		Bucket<V, K> primero = contenedor[hash(key)];
		boolean stop = false;
		int lineal = 1;

		if (contenedor[indice] != null) {
			if (contenedor[indice].getKey().equals(key)) {
				contenedor[indice] = null;
			} else {
				while (!stop) {
					int sondeo = (int) (indice + Math.pow(lineal, 2));
					if (sondeo >= tamanioTabla) {
						sondeo = (int) (sondeo % tamanioTabla);
					}

					if (contenedor[sondeo] != null
							&& contenedor[sondeo].getKey().equals(key)) {
						contenedor[sondeo] = null;
						stop = true;
					} else {
						lineal++;
					}

					if (contenedor[sondeo] == primero) {
						stop = true;
						System.out.println("No se encontro el elemento");
					}
					sondeo = indice;
				}
			}
		}
	}

	@Override
	public String toString() {
		String mensaje = "";
		V elemento = null;
		for (int i = 0; i < contenedor.length; i++) {
			if (contenedor[i] != null) {
				elemento = contenedor[i].getValue();
			} else {
				elemento = null;
			}
			mensaje += "[ " + elemento + " ]";
		}
		return mensaje;
	}

	public double getFactorCarga() {
		return tamanioElementos / tamanioTabla;
	}

	public int getTamanioElementos() {
		return (int) tamanioElementos;
	}
}
