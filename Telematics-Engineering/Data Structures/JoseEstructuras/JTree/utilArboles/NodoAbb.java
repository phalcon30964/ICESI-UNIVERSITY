package utilArboles;

public class NodoAbb<T, K extends Comparable<K>> implements
		INodo<T, K> {


	private NodoAbb<T, K> izq;
	private NodoAbb<T, K> der;

	private T data;
	private K key;

	//CONSTRUCTOR
	public NodoAbb(T contenido, K key) {

		this.data = contenido;
		this.key = key;
		izq = null;
		der = null;

	}

	//METODOS
	public void add(T con, K key) {
		// TODO Auto-generated method stub

		NodoAbb<T, K> nodo = new NodoAbb<T, K>(con, key);
		int com = this.key.compareTo(nodo.getKey());

		if (com > 0) {
             if (izq == null) {
				  izq = nodo;
			}

		else {
              izq.add(con, key);
			            }

		} else {
			if (der == null) {
                   der = nodo;
			} else {

				der.add(con, key);
			}
		}

	}
	
	@Override
	public NodoAbb<T, K> remove(K elK) {
		// TODO Auto-generated method stub
		
		NodoAbb<T,K> elNodoRetorno=null;
		int com= this.key.compareTo(elK);
		if(com==0){
		
			// Caso 1: El elemento está en el nodo raíz
			if(izq==null){
			
				elNodoRetorno= der;	
		  }
			
			else if(der==null){
				
				elNodoRetorno= izq;
			}
			else
            {
                key = izq.darMayor( );
                izq = izq.remove( key );
                elNodoRetorno= this;
            }
        }
		
		else if( com > 0 )
        {
            // Caso 2: El key debe estar en el subárbol izquierdo
            if( izq == null )
            {
                try {
					throw new Exception( "El elemento no existe" );
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            else
            {
                izq = izq.remove(elK);
               elNodoRetorno=this;
            }
        }
		
		 else
	        {
	            // Caso 3: El elemento debe estar en el subárbol derecho
	            if( der == null )
	            {
	                try {
						throw new Exception( "El elemento no encontrado" );
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            }
	            else
	            {
	                der = der.remove(elK);
	               elNodoRetorno=this;
	            }
	        }
		return elNodoRetorno;
	
	}
	
    public T buscar( K key )
    {
        // Compara el valor con el valor del nodo
        int resultado = this.key.compareTo( key );
        if( resultado == 0 )
        {
            // Caso 1: El elemento está en el nodo raíz
            return data;
        }
        else if( resultado > 0 )
        {
            // Caso 2: El elemento debería estar en el subárbol izquierdo
            return ( izq != null ) ? izq.buscar( key) : null;
        }
        else
        {
            // Caso 3: El elemento debería estar en el subárbol derecho
            return ( der != null ) ? der.buscar( key) : null;
        }
    }

	
	public boolean isLeaf(){
		boolean re= false;
		if(izq==null && der==null){
			
			re=true;
		}
		
		return re;
	}
	
	 /**
     * Devuelve la altura del árbol cuya raíz es el nodo actual. <br>
     * <b>post:</b> Se retornó la altura del árbol cuya raíz es el nodo actual. Entero mayor o igual a 1
     * @return Altura del árbol cuya raíz es el nodo actual
     */
    public int darAltura( )
    {
        int a1 = ( izq == null ) ? 0 : izq.darAltura( );
        int a2 = ( der == null ) ? 0 : der.darAltura( );
        return ( a1 >= a2 ) ? a1 + 1 : a2 + 1;
    }
	
	
	//METODOS GET AND SET
	@Override
	public T getContenido() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void setContenido(T con) {
		// TODO Auto-generated method stub
		this.data = con;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public void setKey(K key) {
		// TODO Auto-generated method stub
		this.key = key;
	}

	@Override
	public NodoAbb<T, K> getIzq() {
		// TODO Auto-generated method stub
		return izq;
	}

	@Override
	public void setIzq(NodoAbb<T, K> nIzq) {
		// TODO Auto-generated method stub
		this.izq = nIzq;

	}

	@Override
	public NodoAbb<T, K> getDer() {
		// TODO Auto-generated method stub
		return der;
	}

	@Override
	public void setDer(NodoAbb<T, K> nDer) {
		// TODO Auto-generated method stub
		this.der = nDer;
	}
	
	
	// -----------------------------------------------------------------
    // 	OTROS METODOS
    // -----------------------------------------------------------------

    /**
     * Retorna el nodo con el mayor elemento del árbol. <br>
     * <b>post:</b> Se retornó el nodo con el mayor elemento del árbol.
     * @return Nodo Nodo con el mayor elemento del árbol
     */
    private NodoAbb<T, K> mayorElemento( )
    {
        return ( der == null ) ? this : der.mayorElemento( );
    }

    /**
     * Retorna el nodo menor elemento del árbol. <br>
     * <b>post:</b> Se retornó el nodo con el menor elemento del árbol.
     * @return Nodo El nodo con el menor elemento del árbol
     */
    private NodoAbb<T, K> menorElemento( )
    {
        return ( izq== null ) ? this : izq.menorElemento( );
    }

    /**
     * Retorna el elemento mayor del árbol cuya raíz es el nodo actual. <br>
     * <b>post:</b> Se retornó el elemento mayor del árbol cuya raíz es el nodo actual o null si el árbol es vacio.
     * @return Elemento mayor del árbol cuya raíz es el nodo actual o null si el árbol es vacío
     */
    public K darMayor( )
    {
        NodoAbb<T,K> nodo = mayorElemento( );
        return ( nodo == null ) ? null : nodo.getKey();
    }

    /**
     * Retorna el elemento menor del árbol cuya raíz es el nodo actual. <br>
     * <b>post:</b> Se retornó el elemento menor del árbol cuya raíz es el nodo actual o null si el árbol es vacio.
     * @return Elemento menor del árbol cuya raíz es el nodo actual o null si el árbol es vacío
     */
    public K darMenor( )
    {
        NodoAbb<T,K> nodo = menorElemento( );
        return ( nodo == null ) ? null : nodo.getKey();
    }
}
