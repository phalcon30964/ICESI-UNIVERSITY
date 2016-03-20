package TadColaPrioridad;
public interface INodoPrioridad<T> {
	
	
	public T getContenido();
	public void setContenido(T contenido);
	public NodoPrioridad<T> getAnterior();
	public void setAnterior(NodoPrioridad<T> anterior); 
	public NodoPrioridad<T> getSiguiente();
	public void setSiguiente(NodoPrioridad<T> siguiente);
	public int getPrioridad();
	public void setPrioridad(int prioridad);

	

}
