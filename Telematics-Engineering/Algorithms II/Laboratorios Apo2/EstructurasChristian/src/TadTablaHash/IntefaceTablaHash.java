package TadTablaHash;

public interface IntefaceTablaHash<K,E> {
	
	public void agregar(K key, E elemento);
	
	public void eliminar(K key);
	
	public E buscar(K key);
	
	public boolean isEmpty();
	
	public int getCapacidad();
	
	public double getFactorCarga();

}
