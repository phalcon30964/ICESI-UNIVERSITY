package TadLista;

public class Doble<T> implements ILista<T> {

	private int longitud;
	
	private NodoDoble<T> primero;
	
	private NodoDoble<T> ultimo;
	
	//Constructor
	
	public Doble(){ 
		longitud=0;
	}
	
	//metodos
	
	@Override
	public void agregar(T valor) {
		
		NodoDoble<T> nuevo = new NodoDoble<T>(valor);
		
		if(esVacia()){
			
			primero = nuevo;
			ultimo = nuevo;
			ultimo.setAnterior(primero);
			
			longitud++;
			
		}else{
			
			ultimo.setSiguiente(nuevo);
			nuevo.setAnterior(ultimo);
			ultimo = nuevo;
			
			longitud++;
		}	
	}
	

	@Override
	public void agregar(int pos, T valor) throws Exception {
		//se puede agregar desde 0 hasta longitud
		
		if(pos<0 || pos>longitud){
			throw new Exception("Error, posicion invalido");
		}
		
		NodoDoble<T> nuevo = new NodoDoble<T>(valor);
		
		if(pos==0 && !esVacia()){ 
			
			nuevo.setSiguiente(primero);
			primero.setAnterior(nuevo);
			primero = nuevo;
			
		
			longitud++;
			
		}else if(pos==0 && esVacia()){
			
			primero = nuevo;
			ultimo = nuevo;
			primero.setSiguiente(ultimo);
			ultimo.setAnterior(primero);
			
			
			longitud++;
			
			
		}else if(pos==longitud-1){
			
			NodoDoble<T> anterior = ultimo.getAnterior();
			
			nuevo.setSiguiente(ultimo);
			ultimo.setAnterior(nuevo);
			anterior.setSiguiente(nuevo);
			nuevo.setAnterior(anterior);
			
			longitud++;
			
			
		}else if(pos==longitud){
			
			ultimo.setSiguiente(nuevo);
			nuevo.setAnterior(ultimo);
			ultimo = nuevo;
			
			longitud++;
			
		}else{
			
			NodoDoble<T> actual = primero;
			
			for (int i = 0;  i < (pos) && actual.getSiguiente()!=null; i++ ) {
				actual = actual.getSiguiente();
			}

			NodoDoble<T> antes = actual.getAnterior();
			nuevo.setSiguiente(actual);
			actual.setAnterior(nuevo);
			antes.setSiguiente(nuevo);
			nuevo.setAnterior(antes);
			
			longitud++;
		}
	}

	@Override
	public void eliminar(int pos) throws Exception {

		if(pos<0 || pos>=longitud){
			throw new Exception("Error, posicion invalido");
		}
		
		if(pos==0){
			
			primero = primero.getSiguiente();
			longitud--;
			
		}else if(pos==longitud-1){
			
			NodoDoble<T> anterior = ultimo.getAnterior();
			
			anterior.setSiguiente(null);
			ultimo = anterior;
			
			longitud--;
		}else{

			NodoDoble<T> actual = primero;
			
			for (int i = 0;  i < pos; i++ ) {
				actual = actual.getSiguiente();
			}
			
			NodoDoble<T> anterior = actual.getAnterior();
			anterior.setSiguiente(actual.getSiguiente());
			
			longitud--;
		}
	}
	
	//Para usar este metodo el elemento debe tener sobre escrito el metodo equals correctamente.
	public void eliminar(T elemento) throws Exception{
		
		NodoDoble<T> actual = primero;
		int pos;
		
		for (pos = 0; actual!=null &&  !actual.getContenido().equals(elemento) ; pos++ ) {
			actual = actual.getSiguiente();
		}
		
		if(actual==null){
			throw new Exception("No se encontronco el elemento a eliminar");
		}else{
			eliminar(pos);
		}
		
	}
	

	@Override
	public T darElemento(int pos) throws Exception {
		
		if(pos<0 || pos>=longitud){
			throw new Exception("Error, posicion invalido");
		}
		
		
		if(pos==longitud-1){
			return ultimo.getContenido();
		}else{
			
		NodoDoble<T> actual = primero;
		
		for (int i = 0;  i < pos; i++ ) {
			actual = actual.getSiguiente();
		}
		return actual.getContenido();
		
		}
	}

	@Override
	public int darLongitud() {
		
		return longitud;
	}

	@Override
	public boolean esVacia() {
		return primero==null;

	}
	
	// debe tener sobrescrito toString
	
	public void print(){
		
		NodoDoble<T> actual = primero;
		
		for (int i = 0; i < darLongitud(); i++) {
			
			System.out.println(actual.getContenido().toString());
			
			actual = actual.getSiguiente();
		}
		
	}
	
	// debe tener sobrescrito toString
	public void printBack(){
		
		NodoDoble<T> actual = ultimo;
		
		for (int i = darLongitud(); i > 0; i--) {
			
			System.out.println(actual.getContenido().toString());
			
			actual = actual.getAnterior();
		}
		
	}
		
	

	


}
