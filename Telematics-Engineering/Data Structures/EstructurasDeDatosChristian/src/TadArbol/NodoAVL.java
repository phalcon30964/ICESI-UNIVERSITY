package TadArbol;

public class NodoAVL<K extends Comparable<K>, T> extends NodoABB<K,T>{

	
	// ----------------------------------------------------------------------------
	// ATRIBUTOS
	// ----------------------------------------------------------------------------
	
    private int factorBalanceo;
    

	// ----------------------------------------------------------------------------
	// CONSTRUCTOR
	// ----------------------------------------------------------------------------

	public NodoAVL(K key, T contenido) {
		super(key, contenido);
		this.factorBalanceo=0;
	}
	
	// ----------------------------------------------------------------------------
	// METODOS
	// ----------------------------------------------------------------------------
	/*
	@Override
	public void agregar(K key, T contenido)throws Exception{
		
		NodoAVL<K, T> nuevo = new NodoAVL<K, T>(key, contenido, this);

		if(key.compareTo(this.key)==0){
			
			throw new Exception("key ya existe");
			
		}else if (key.compareTo(this.key) < 0) {

			if (izq == null) {
				izq = nuevo;
			} else {
				((NodoAVL<K, T>) izq).agregar(key, contenido);
			}

		} else {

			if (der == null) {
				der = nuevo;
			} else {
				((NodoAVL<K, T>) der).agregar(key, contenido);
			}
			
		}

		NodoAVL<K,T> actual = nuevo;
		calcularFactorBalanceo(actual);
		
		while(actual != null){
			
			balancear(actual);
			actual = ((NodoAVL<K,T>)actual.getPadre());
		}
	}*/
		
	
	public void calcularFactorBalanceo(NodoAVL<K, T> nodo){
		
		NodoAVL<K,T> actual = nodo;
		
		while(actual!=null){
			
			int alturaIzq = (this.izq==null) ? 0:Math.abs(((NodoAVL<K, T>)izq).getFactorBalanceo())+1;
			int alturaDer = (this.der==null) ? 0:Math.abs(((NodoAVL<K, T>)der).getFactorBalanceo())+1;
			this.factorBalanceo = alturaIzq-alturaDer;
			
			actual=(NodoAVL<K,T>)actual.getPadre();
		}
		
	}

	public int getFactorBalanceo() {
		return factorBalanceo;
	}

	public void setFactorBalanceo(int factorBalanceo) {
		this.factorBalanceo = factorBalanceo;
	}
	
	public String toString(){
		
		return key.toString();
	}
	

	
	
	

	
	



}
