package utilArboles;

public interface INodo<T, K extends Comparable<K>>  {
	
	//CONTENIDO
	public T getContenido();
	public void setContenido(T con);
	
	//KEY
	public K getKey();
	public void setKey(K key);
	
	//SUBARBOL IZQ
	public NodoAbb<T, K> getIzq();
	public void setIzq(NodoAbb<T, K> nIzq);
	
	//SUBARBOL DER
	public NodoAbb<T, K> getDer();
	public void setDer(NodoAbb<T,K> nDer);
	
	//METODOS
	public void add(T elT,K elK);
	public NodoAbb<T,K> remove(K elK);
	

}
