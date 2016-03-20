package TADLista;

public class Doble<T> implements TADLista<T> {
	private NodoDoble<T> primero;
	private NodoDoble<T> ultimo;
	private int longitud;
	
	public Doble(){
		primero=ultimo=null;
		longitud=0;
	}
	
	public boolean esVacia(){
		return primero==null&& ultimo==null&& longitud==0;
	}

	@Override
	public void agregar(T elemento) {
		NodoDoble<T> nuevo= new NodoDoble<T>(elemento);
		if (esVacia()){
			primero=nuevo;
			ultimo=nuevo;
			longitud++;
		}else{
			nuevo.setAnterior(ultimo);
			ultimo.setSiguiente(nuevo);
			longitud++;
			ultimo= nuevo;
		}
		
	}

	@Override
	public void agregar(T elemento, int posicion) {
		NodoDoble<T> nuevo= new NodoDoble<T>(elemento);
		NodoDoble<T>actual;
		int contador=0;
		
		if(esVacia()){
			primero=nuevo;
			ultimo=primero;
			longitud++;
		}else{
			for(actual=primero;actual!=null && contador<posicion;actual=actual.getSiguiente(), contador++){
				
			}
			NodoDoble<T> anterior= actual.getAnterior();
			nuevo.setSiguiente(actual);
			nuevo.setAnterior(actual.getAnterior());
			if(anterior==null){
				actual.setAnterior(nuevo);
				primero=nuevo;
			}else{
				anterior.setSiguiente(nuevo);
				nuevo.setSiguiente(actual);
			}
		}
		
	}

	@Override
	public T dar(int pos) {
		T respuesta=null;
		if (pos==0){
			respuesta= primero.getContenido();
		}
		if(pos==longitud-1){
			respuesta= ultimo.getContenido();
		}
		
		if(pos!=0 && pos != longitud-1){
			NodoDoble<T>actual;
			int contador=0;
			for(actual=primero;actual!=null && contador<pos;actual=actual.getSiguiente(), contador++){
				
			}
			respuesta=actual.getContenido();
		}
		return respuesta;
	}

	public void eliminar(int pos) {
		if (pos==0){
			if(longitud==1){
				primero=primero.getSiguiente();
				ultimo=primero;
			}else{
				primero=primero.getSiguiente();
				primero.setAnterior(null);
			}
		}else{
			if(pos==longitud-1){
				NodoDoble<T> anterior= ultimo.getAnterior();
				ultimo=anterior;
				ultimo.setSiguiente(null);
			}else{
				NodoDoble<T>actual;
				int contador=0;
				for(actual=primero;actual!=null && contador<pos;actual=actual.getSiguiente(), contador++){
					
				}
				NodoDoble<T> anterior= actual.getAnterior();
				NodoDoble<T> siguiente= actual.getSiguiente();
				
				anterior.setSiguiente(siguiente);
				siguiente.setAnterior(anterior);
				actual=null;
			}
			
		}

		longitud--;

		
	}
	public void eliminar(T elemento) {
		
	}
	public int darLongitud(){
		return longitud;
	}
	public NodoDoble<T> getPrimero(){
		return primero;
	}
	public NodoDoble<T> getUltimo(){
		return ultimo;
	}
	
	public void setPrimero(NodoDoble<T> nuevo){
		primero= nuevo;
	}
	public void setUltimo(NodoDoble<T> nuevo){
		ultimo= nuevo;
	}
	public void aumentarLongitud(){
		longitud++;
	}
	public String print(){
		String cadena= "";
		NodoDoble<T> actual=primero;
		for(actual=primero; actual!=null; actual=actual.getSiguiente()){
			cadena+=actual.getContenido()+" ";	
		}
		cadena+="--";
		//System.out.println(cadena);
		return cadena;
		
	}
	public String printback(){
		String cadena="";
		NodoDoble<T> actual;
		for(actual=ultimo; actual!=null; actual=actual.getAnterior()){
			cadena+=actual.getContenido()+ " ";	
		}
		cadena+="--";
		//System.out.println(cadena);
		return cadena;
	}

}
