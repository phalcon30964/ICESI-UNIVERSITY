package TadCola;

import TadLista.*;

public class Cola<T> implements ICola<T> {
	
	protected Doble<T> cola;
	
	
	public Cola(){
		
		cola = new Doble<T>();
		
	}
	

	@Override
	public void enQueue(T elemento) {
		
		cola.agregar(elemento);
		
	}

	@Override
	public T deQueue(){
		
		T eliminado = null;
		
		try {
			eliminado = cola.darElemento(0);
			cola.eliminar(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return eliminado;
	}

	@Override
	public boolean isEmpty() {
		
		return cola.esVacia();
	}

	@Override
	public void clear() {

		cola = new Doble<T>();
	}

	@Override
	public T getFront() {
		
		T front = null;
		
		try {
			front = cola.darElemento(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return front;
	}

	@Override
	public T getBack() {
		
		T back = null;
		
		try {
			back = cola.darElemento(cola.darLongitud()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return back;
	}
	
	public void print(){
		
		cola.print();
		
	}
	
	public void printback(){
		
		cola.printBack();
		
	}


}
