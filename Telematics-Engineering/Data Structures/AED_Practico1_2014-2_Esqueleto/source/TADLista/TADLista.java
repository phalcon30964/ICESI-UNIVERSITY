package TADLista;

public interface TADLista<T> {
	
	public void agregar(T elemento);
	public void agregar(T elemento, int posicion);
	public T dar(int pos);
	public void eliminar(T elemento);
	
}
