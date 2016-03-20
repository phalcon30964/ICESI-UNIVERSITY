package TadTablaHash;

public class bucket<K,E> {
	
	private K key;
	
	private E elemento;
	
	private int colisiones;
	
	public bucket(K key, E elemento) {
		super();
		this.key = key;
		this.elemento = elemento;
		this.colisiones = 0;
	}
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public E getElemento() {
		return elemento;
	}

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}

	public int getColisiones() {
		return colisiones;
	}

	public void setColisiones(int colisiones) {
		this.colisiones = colisiones;
	}

	
	
	

}
