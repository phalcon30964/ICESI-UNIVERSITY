package ColaPrioridad;

public class ColaPrioridad<T> implements IColaPrioridad<T>{
	
	public final static int MAX = Integer.MAX_VALUE;
	
	private NodoPrioridad<T> front;
	
	private NodoPrioridad<T> back;

	@Override
	public void enQueue(T valor) {
		
		NodoPrioridad<T> nuevo = new NodoPrioridad<T>(MAX,valor);
		
		if(isEmpty()){
			front=nuevo;
			back=nuevo;
		}else{
			back.setSiguiente(nuevo);
			nuevo.setAnterior(back);
			back=nuevo;
		}
	
	}

	@Override
	public T deQueue() {
		
		T elemento = front.getContenido();


		if(front.getCola().isEmpty()){
			
			front = front.getSiguiente();
			front.setAnterior(null);
			
		}else{
			
			front.setContenido(front.getCola().deQueue());
			
		}
		
		return elemento;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front==null && back == null;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		return front.getContenido();
	}

	@Override
	public T getBack() {
		// TODO Auto-generated method stub
		return back.getContenido();
	}

	@Override
	public void clear() {
		front=null;
		back=null;
		
	}
	
	public String print(){

		String cadena= "";

		NodoPrioridad<T> aux= front;

		while(aux!=null){

		T elemento=aux.getContenido();

		cadena+=elemento+ " ";

		if(!aux.getCola().isEmpty()){

		cadena+= aux.getCola().print();

		}

		aux=aux.getSiguiente();

		}

		cadena+="---";

		System.out.println(cadena);

		return cadena;

		}

		public String printback(){

		String cadena="";

		NodoPrioridad<T> aux= back;

		while(aux!=null){

		T elemento=aux.getContenido();

		if(!aux.getCola().isEmpty()){

		cadena+=aux.getCola().printback();

		}

		cadena+=elemento+ " ";

		aux=aux.getAnterior();

		}

		cadena+="---";

		System.out.println(cadena);

		return cadena;

		}
	

	@Override
	public void enQueue(int prioridad, T valor) {
		
		NodoPrioridad<T> nuevo = new NodoPrioridad<T>(prioridad,valor);
		
		if(isEmpty()){
			
			front=nuevo;
			back=nuevo;
			
		}else if(nuevo.getPrioridad()<front.getPrioridad()){
			nuevo.setSiguiente(front);
			front.setAnterior(nuevo);
			front = nuevo;
		}else if(nuevo.getPrioridad()>back.getPrioridad()){
			back.setSiguiente(nuevo);
			nuevo.setAnterior(back);
			back=nuevo;
		}else{
			
			NodoPrioridad<T> actual = front;
			
			while(actual.getSiguiente()!=null && actual.getSiguiente().getPrioridad()<=nuevo.getPrioridad()){
				actual = actual.getSiguiente();
			}
			
			if(actual.getPrioridad()==nuevo.getPrioridad()){
				actual.encolar(valor);
			}else{
				nuevo.setSiguiente(actual.getSiguiente());
				nuevo.setAnterior(actual);
				actual.setSiguiente(nuevo);
			}
		}
		
		

	}
	
	
	
	
	

}
