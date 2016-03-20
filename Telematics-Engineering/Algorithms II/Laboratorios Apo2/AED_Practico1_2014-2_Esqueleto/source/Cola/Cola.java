package Cola;

import TADLista.Doble;

public class Cola<T> implements ICola<T> {
	protected Doble<T> cola;

	public Cola(){
		cola= new Doble<T>();
	}
	@Override
	public void enQueue(T valor) {
		// TODO Auto-generated method stub
		cola.agregar(valor);
	}

	@Override
	public T deQueue() {
		// TODO Auto-generated method stub
		T contenido= cola.dar(0);
		cola.eliminar(0);
		return contenido;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return cola.esVacia();
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return cola.dar(0);
	}

	@Override
	public T getBack() {
		// TODO Auto-generated method stub
		return cola.dar(cola.darLongitud() -1);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		cola= new Doble<T>();
		
	}
	public String print(){
		return cola.print();
	}
	public String printback(){
		return cola.printback();
	}

}
