package TADArbolBinario;

import TADListaDoble.ListaDoble;

public interface INodoArbol<K extends Comparable<K>, T> {
	
	public INodoArbol<K,T> getPadre();
	
	public void setPadre(INodoArbol<K,T> padre);
	
	public T getContenido(); 
	
	public void setContenido(T elemento);
	
	public K getKey();
	
	public void setKey(K key);
	
	public INodoArbol<K,T> getIzq();
	
	public void setIzq(INodoArbol<K,T> izq);
	
	public INodoArbol<K,T> getDer();
	
	public void setDer(INodoArbol<K,T> der);

	public void agregar(INodoArbol<K, T> nuevo) throws Exception;
	
	public T buscar(K key);
	
	public boolean esHoja();
	
	public INodoArbol<K, T> getMinimo();
	
	public INodoArbol<K, T> getMaximo();
	
	public String cadenaInorden();
	
	public int getAltura();
	
	public int getPeso();

}
