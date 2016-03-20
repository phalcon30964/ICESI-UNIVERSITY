package JHashTableDinamic;

import JHashTableEstatic.Bucket;

public class HashTableDinamic<V, K> implements IHashTable<V, K> {

	// ----------------------------------------------------------
	// Constatntes
	// ----------------------------------------------------------

	private static final int TABLE_SIZE = 17;

	private static final double FACTOR_CARGA = 0.75;

	// ----------------------------------------------------------
	// Atributos
	// ----------------------------------------------------------

	private double  factorCarga;
	
	private double tamanioElementos;

	private double tamanioTabla;

	private Bucket<V, K>[] contenedor;

	// -----------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------

	public HashTableDinamic() {
		create();
	}

	// ------------------------------------------------------------
	// Metodos
	// ------------------------------------------------------------

	@SuppressWarnings("unchecked")
	@Override
	public void create() {
		factorCarga = FACTOR_CARGA;
		tamanioTabla = TABLE_SIZE;
		contenedor = new Bucket[TABLE_SIZE];
		tamanioElementos = 1;
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
		int cuadratica = 1;
		boolean stop = false;
		Bucket<V, K> primero = contenedor[hash(key)];
		Bucket<V, K> nuevo = new Bucket<V, K>(value, key);
		double factor = tamanioElementos/tamanioTabla;
		if (factor>=factorCarga) {
			rehash();
		} else {
			if (contenedor[indice] == null) {
				contenedor[indice] = nuevo;
				tamanioElementos++;
			} else {
				while (!stop) {
					int sondeo = (int) (indice + Math.pow(cuadratica, 2));
					if (sondeo >= tamanioTabla) {
						sondeo = (int) (sondeo % tamanioTabla);
					}
					if (contenedor[sondeo] == null) {
						contenedor[sondeo] = nuevo;
						tamanioElementos++;
						stop = true;
					} else {
						cuadratica++;
					}
					if (primero == contenedor[sondeo]) {
						throw new Exception("No es posible insertar " + value);
					}
					sondeo = indice;
				}
			}
		}
	}

	@Override
	public V search(K key) {
		int indice = hash(key);
		Bucket<V, K> encontre = null;
		Bucket<V, K> primero = contenedor[hash(key)];
		boolean stop = false;
		int cuadratica = 1;
		if (contenedor[indice] != null) {
			if (contenedor[indice].getKey().equals(key)) {
				encontre = contenedor[indice];
			} else {
				while (!stop) {
					int sondeo = (int) (indice + Math.pow(cuadratica, 2));
					if (sondeo >= tamanioTabla) {
						sondeo = (int) (sondeo % tamanioTabla);
					}

					if (contenedor[sondeo] != null
							&& contenedor[sondeo].getKey().equals(key)) {
						encontre = contenedor[sondeo];
						stop = true;
					} else {
						cuadratica++;
					}

					if (contenedor[sondeo] == primero) {
						stop = true;
						System.out.println("No se encontro el elemento");
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
		int cuadratica = 1;

		if (contenedor[indice] != null) {
			if (contenedor[indice].getKey().equals(key)) {
				contenedor[indice] = null;
			} else {
				while (!stop) {
					int sondeo = (int) (indice + Math.pow(cuadratica, 2));
					if (sondeo >= tamanioTabla) {
						sondeo = (int) (sondeo % tamanioTabla);
					}

					if (contenedor[sondeo] != null
							&& contenedor[sondeo].getKey().equals(key)) {
						contenedor[sondeo] = null;
						stop = true;
					} else {
						cuadratica++;
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

	public int getTamanioElementos() {
		return (int) tamanioElementos;
	}

	public int obtenerPrimo(int numero) {
		int primo = numero + 1;
		while (!esPrimo(primo)) {
			primo++;
		}
		return primo;
	}

	private boolean esPrimo(int numero) {
		boolean primo = true;

		if (numero % 2 == 0 && numero != 2) {
			primo = false;
		} else {
			int raiz = (int) Math.sqrt(numero);

			for (int cont = 3; cont <= raiz && primo; cont += 2) {
				if (numero % cont == 0) {
					primo = false;
				}
			}
		}
		return primo;
	}

	@Override
	public void rehash() {
		System.out.println(1);
	}

}
