package utilArboles;

public class Abb<T, K extends Comparable<K>> implements IAbb<T, K>{

	/**
	 * La Raiz
	 * es la referencia a la cabeza del arbol
	 */
	private NodoAbb<T, K> root;
	private int weight;
	
	public Abb(){
		
		root= null;
	}
	
	public Abb(T con, K key){
		
		NodoAbb<T, K> elNuevo= new NodoAbb<T, K>(con, key);
		this.root= elNuevo;
	}
	@Override
	public void add(T contenido, K key) {
		
		
		NodoAbb<T, K> nuevoNodo= new NodoAbb<T,K>(contenido, key);
		if(weight==0){
			root= nuevoNodo;
		}
		
		else{
			root.add(contenido, key);
			}
			
			
		}


	@Override
	public void remove(K key) throws Exception {
		// TODO Auto-generated method stub
	
        if( root != null )
        {
            // Caso 1: el árbol no es vacío
            root = root.remove(key);
        }
        else
        {
            // Caso 2: el árbol es vacío
           
				throw new Exception( "El elemento especificado no existe en el árbol" );
			
        }
	}
	
	@Override
	public T search(K key) {
		
		return (root != null) ? root.buscar(key) : null;
	}


	


	//METODOS GET AND SET
	
	public NodoAbb<T, K> getRoot() {
		
		return root;
	}

	
	@Override
	public int getWeight() {
		
		return this.weight;
	}
	
	

	
	public int getHeight() {
		
		return root.darAltura();
	}

	
	public NodoAbb<T, K> getRight() {
		// TODO Auto-generated method stub
		return root.getDer();
	}

	
	public NodoAbb<T, K> getLeft() {
		// TODO Auto-generated method stub
		return root.getIzq();
	}

	


	
	
	
	
}
