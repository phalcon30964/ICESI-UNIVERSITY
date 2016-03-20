package TadColaPrioridad;

import TadLista.ListaDoble;



@SuppressWarnings("unused")
public class ColaPrioridad<T> implements IColaPrioridad<T>{

	public final static int MAX = Integer.MAX_VALUE;
	
	
	
	private NodoPrioridad<T> front;
	private NodoPrioridad<T> back;
	
	
	public ColaPrioridad(){
		front =null;
		back= null;
	}
	
	public int longitudDeCola(){
		int longitud = 0;
		NodoPrioridad<T> actual = front;
		
		while(actual!=null){
			longitud++;
			actual = actual.getSiguiente();
		}
		
		
		
		
		return longitud;
	}
	
	public NodoPrioridad<T> buscarElemento(T valor){
		NodoPrioridad<T> buscado = null;
		NodoPrioridad<T> actual = front;
		while(actual!=null  && buscado==null){
			if(actual.getContenido().equals(valor)){
				buscado = actual;
			}
			actual=actual.getSiguiente();
		}
		return buscado;
	}
	
	public void actualizarPrioridad(T valor, int nuevaPrioridad){
		NodoPrioridad<T> buscado = buscarElemento(valor);
		if(buscado!=null){
			buscado.setPrioridad(nuevaPrioridad);
			
		}
	}
	
	public void actualizarCola() {
		ListaDoble<NodoPrioridad<T>> actualizado = new ListaDoble<NodoPrioridad<T>>();
		
		try{
		if (!isEmpty()) {
			NodoPrioridad<T> actual = front;
			while(!isEmpty()){
				if(actual!= null){
				actualizado.agregar(actual);
				actual = actual.getSiguiente();
				this.deQueue();
				
				
				}
			}
		}
		
		for (int i = 0; i < actualizado.darLongitud(); i++) {
			NodoPrioridad<T> actual = actualizado.darElemento(i);
			int prioridad = actual.getPrioridad();
			enQueue(prioridad, actual.getContenido());
		}
		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
		
	
	
	public boolean estaEnCola(int prio, T valor){
		boolean esta = false;
		
		NodoPrioridad<T> buscado = new NodoPrioridad<T>(prio, valor);
		
		if(isEmpty()){
			return esta;
		}else{
			NodoPrioridad<T> actual = front;
			while(actual.getSiguiente()!=null  && !esta){
				if(actual == buscado){
					esta = true;
				}else{
			
				actual=actual.getSiguiente();
				}
			}
		}
		
		
		return esta;
	}
	
	public void enQueue(int prio, T Valor) {
		// TODO Auto-generated method stub
		NodoPrioridad<T> nuevo = new NodoPrioridad<T>(prio, Valor);
		
		
		if(isEmpty()){
			front = nuevo;
			back = nuevo;
		}else{
			NodoPrioridad<T> actual = front;
		while(actual.getSiguiente()!=null  && actual.getPrioridad()<nuevo.getPrioridad()){
			actual=actual.getSiguiente();
		}

		 if(prio<=front.getPrioridad()){
				front.setAnterior(nuevo);
				nuevo.setSiguiente(front);
			
				front = nuevo;
			} else if (prio >= back.getPrioridad()) {
				back.setSiguiente(nuevo);
				nuevo.setAnterior(back);

				back = nuevo;
			} else if (actual.getPrioridad() == prio) {
				actual.getAnterior().setSiguiente(nuevo);
				nuevo.setAnterior(actual.getAnterior());
				nuevo.setSiguiente(actual);
				actual.setAnterior(nuevo);
			} else {

				actual.getAnterior().setSiguiente(nuevo);
				nuevo.setAnterior(actual.getAnterior());
				nuevo.setSiguiente(actual);
				actual.setAnterior(nuevo);
			}
		}
		
	}

	
	public T deQueue() {
		// TODO Auto-generated method stub
		T objeto = null;
		NodoPrioridad<T> actual = front;

		if (!isEmpty()) {
		
			if(front == back){
				objeto = front.getContenido();
				front = null;
				back = null;
			}
			else if(actual.getSiguiente()!=null){
				objeto = front.getContenido();
				NodoPrioridad<T> sgte = actual.getSiguiente();
				actual.setSiguiente(null);
				sgte.setAnterior(null);
				front = sgte;
			}
					}
		
		
		return objeto;
	}

	
	public boolean isEmpty() {
		if(front==null && back== null){
			return true;
		}else{
		
		return false;
		}
		}

	
	public T getFront() {
		// TODO Auto-generated method stub
		return front.getContenido();
	}

	
	public T getBack() {
		// TODO Auto-generated method stub
		return back.getContenido();
	}

	
	public void clear() {
		// TODO Auto-generated method stub
		front = null;
		back=null;
	}
	
	public String print() {

		String cadena = "";

		NodoPrioridad<T> aux = front;

		while (aux != null) {

			T elemento = aux.getContenido();
			cadena += elemento + "-";
			aux = aux.getSiguiente();
		}
		

		return cadena;

	}


}
