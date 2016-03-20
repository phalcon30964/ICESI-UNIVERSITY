package utilArboles;

public class NodoAvl<T, K extends Comparable<K>> {

	// -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Constantes para la serialización
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	/**
     * Constante que representa el hecho de que el nodo está balanceado hacia la izquierda.
     */
    private static final int BIZQ = 1;

    /**
     * Constante que representa el hecho de que el nodo está balanceado.
     */
    private static final int BAL = 0;

    /**
     * Constante que representa el hecho de que el nodo está balanceado hacia la derecha.
     */
    private static final int BDER = -1;
    

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Elemento almacenado en el nodo
     */
    private T elem;
    
    private K key;

    /**
     * Nodo a la derecha
     */
    private NodoAvl<T,K> derNodo;

    /**
     * Nodo a la izquierda
     */
    private NodoAvl<T,K> izqNodo;

    /**
     * Indica el estado de balanceo del nodo
     */
    private int balance;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del nodo. <br>
     * <b>post: </b> Se construyó el nodo con el elemento especificado, derNodo= null y izqNodo= null.
     * @param pElemento Elemento que va a ser almacenado en el nodo
     */
    public NodoAvl( T pElemento, K key )
    {
        elem = pElemento;
        this.key= key;
        derNodo = null;
        izqNodo = null;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    
    /**
     * Agrega un nuevo elemento en el árbol cuya raíz es el nodo actual. <br>
     * <b>pre: </b> pElemento!=null. <br>
     * <b>post: </b> Se insertó el elemento especificado en el árbol.
     * @param pElemento elemento que se va a agregar
     * @return Raíz del árbol producto de insertar en el árbol que comienza en el nodo actual el elemento que llega como parámetro
     * @throws Exception El elemento ya existe en el árbol
     */
    public NodoAvl<T,K> insertar( T el, K key) throws Exception
    {
        // Agrega el elemento al árbol utilizando una operación auxiliar
        Retorno retorno = new Retorno( null, false );
        auxInsertar( el, key, retorno );
        return retorno.respuesta;
    }

    /**
     * Elimina el elemento dado como parámetro, del árbol cuya raíz es el nodo actual. <br>
     * <b>pre: </b> pElemento!=null. <br>
     * <b>post: </b> Se eliminó el elemento especificado si existía en el árbol.
     * @param pElemento Elemento que se va a eliminar
     * @return Raíz del árbol producto de eliminar del árbol que comienza en el nodo actual el elemento que llega como parámetro
     * @throws Exception El elemento no se encontró en el árbol
     */
    public NodoAvl<T,K> eliminar( K elK) throws Exception
    {
        // Elimina el elemento utilizando una operación auxiliar
        Retorno retorno = new Retorno( null, false );
        auxEliminar( elK, retorno );
        return retorno.respuesta;
    }

    /**
     * Busca el elemento cuyo modelo viene dado como parámetro, en el árbol cuya raíz es el nodo actual. <br>
     * <b>pre: </b> modelo!=null. <br>
     * <b>post: </b> Se retornó el elemento que cumple con el modelo o null si no encuentra ninguno.
     * @param modelo Modelo del elemento que se va a buscar
     * @return Elemento que cumple con el modelo o null si no encuentra ninguno
     */
    public T buscar( K modelo )
    {
        // Compara el valor con el valor del nodo
        int resultado = key.compareTo( modelo );
        if( resultado == 0 )
        {
            // Caso 1: El elemento está en el nodo raíz
            return elem;
        }
        else if( resultado > 0 )
        {
            // Caso 2: El elemento puede estar en el subárbol izquierdo
            return ( izqNodo != null ) ? izqNodo.buscar( modelo ) : null;
        }
        else
        {
            // Caso 3: El elemento puede estar en el subárbol derecho
            return ( derNodo != null ) ? derNodo.buscar( modelo ) : null;
        }
    }




    // -----------------------------------------------------------------
    // Operaciones Auxiliares
    // -----------------------------------------------------------------

    /**
     * Agrega el elemento al árbol cuya raíz es el nodo actual. <br>
     * <b>pre: </b> pElemento!=null, retorno!=null. <br>
     * <b>post: </b> Se insertó el elemento en el árbol.
     * @param pElemento que se va a insertar
     * @param retorno Objeto con la información de la nueva raíz del árbol y un indicador de cambio de altura
     * @throws Exception el elemento ya existe en el arbol
     */
    private void auxInsertar( T pElemento, K key, Retorno retorno ) throws Exception
    {
        // Compara el elemento con el valor almacenado en el nodo
    	NodoAvl<T, K> elN= new NodoAvl<T,K> (pElemento, key);
        int resultado = (this.key).compareTo( key );
        if( resultado == 0 )
        {
            // Caso 1: El elemento está en el nodo actual
            throw new Exception( "El elemento ya existe en el árbol" );
        }
        else if( resultado > 0 )
        {
            // Caso 2: Debe agregar por la izquierda
            if( izqNodo == null )
            {
                // Se debe crear el nodo nuevo
                izqNodo = elN;
                retorno.respuesta = this;
                if( derNodo == null )
                {
                    balance = BIZQ;
                    retorno.diferenciaAltura = true;
                }
                else
                {
                    balance = BAL;
                    retorno.diferenciaAltura = false;
                }
            }
            else
            {
                // Caso general de inserción por la izquierda
                izqNodo.auxInsertar( pElemento, key, retorno );
                izqNodo = retorno.respuesta;

                // Balancea si es necesario
                if( retorno.diferenciaAltura )
                {
                    // El subárbol izquierdo aumentó de altura, debe corregirse
                    // el balance
                    switch( balance )
                    {
                        case BIZQ:
                            retorno.diferenciaAltura = false;
                            retorno.respuesta = balanceaIzq( );
                            break;
                        case BAL:
                            balance = BIZQ;
                            retorno.respuesta = this;
                            break;
                        case BDER:
                            balance = BAL;
                            retorno.diferenciaAltura = false;
                            retorno.respuesta = this;
                            break;
                    }
                }
                else
                {
                    retorno.respuesta = this;
                }
            }
        }
        else
        {
            // Caso 3: Debe agregar por la derecha
            if( derNodo == null )
            {
                // Se debe crear el nodo nuevo
                derNodo = elN;
                retorno.respuesta = this;
                if( izqNodo == null )
                {
                    balance = BDER;
                    retorno.diferenciaAltura = true;
                }
                else
                {
                    balance = BAL;
                    retorno.diferenciaAltura = false;
                }
            }
            else
            {
                // Caso general de inserción por la derecha
                derNodo.auxInsertar( pElemento, key, retorno );
                derNodo = retorno.respuesta;

                // Balancea si es necesario
                if( retorno.diferenciaAltura )
                {
                    // El subárbol derecho aumentó de altura, debe corregirse el
                    // balance
                    switch( balance )
                    {
                        case BIZQ:
                            balance = BAL;
                            retorno.diferenciaAltura = false;
                            retorno.respuesta = this;
                            break;
                        case BAL:
                            balance = BDER;
                            retorno.respuesta = this;
                            break;
                        case BDER:
                            retorno.diferenciaAltura = false;
                            retorno.respuesta = balanceaDer( );
                            break;
                    }
                }
                else
                {
                    retorno.respuesta = this;
                }
            }
        }
    }

    /**
     * Elimina el elemento del árbol cuya raíz es el nodo actual. <br>
     * <b>pre: </b> pElemento!=null, retorno!=null. <br>
     * <b>post: </b> Se eliminó el elemento del árbol si existía.
     * @param pElemento Elemento que se va a eliminar
     * @param retorno Objeto con la información de la nueva raíz del árbol y un indicador de cambio de altura
     * @throws Exception Elemento no encontrado en el árbol
     */
    private void auxEliminar( K pElemento, Retorno retorno ) throws Exception
    {
        // Compara el elemento con el valor almacenado en el nodo
        int resultado = key.compareTo( pElemento );
        if( resultado == 0 )
        {
            // Caso 1: El elemento está en el nodo actual
            if( izqNodo == null & derNodo == null )
            {
                // No tiene hijos, simplemente debe eliminarlo
                retorno.diferenciaAltura = true;
                retorno.respuesta = null;
            }
            else if( izqNodo == null )
            {
                retorno.respuesta = derNodo;
                retorno.diferenciaAltura = true;
            }
            else
            {
                // Reemplaza el nodo con la mayor elemento del nodo izquierdo
                NodoAvl<T,K> reemplazo = izqNodo.mayorElemento( );
                key= reemplazo.key;
                izqNodo.auxEliminar( reemplazo.key, retorno );
                izqNodo = retorno.respuesta;

                // Balancea si es necesario
                if( retorno.diferenciaAltura )
                {
                    balanElimDer( retorno );
                }
                else
                {
                    retorno.respuesta = this;
                }
            }
        }
        else if( resultado > 0 )
        {
            // Caso 2: El elemento debe estar por la izquierda
            if( izqNodo == null )
            {
                throw new Exception( "El elemento no se encuentra en el árbol" );
            }
            izqNodo.auxEliminar( pElemento, retorno );
            izqNodo = retorno.respuesta;

            // Balancea si es necesario
            if( retorno.diferenciaAltura )
            {
                balanElimDer( retorno );
            }
            else
            {
                retorno.respuesta = this;
            }
        }
        else
        {
            // Caso 3: El elemento debe estar por la derecha
            if( derNodo == null )
            {
                throw new Exception( "El elemento no se encuentra en el árbol" );
            }
            derNodo.auxEliminar( pElemento, retorno );
            derNodo = retorno.respuesta;

            // Balancea si es necesario
            if( retorno.diferenciaAltura )
            {
                balanElimIzq( retorno );
            }
            else
            {
                retorno.respuesta = this;
            }
        }
    }

    /**
     * Balancea el subárbol izquierdo de un árbol AVL que se ha desbalanceado por una inserción. Actualiza los factores de balanceo. <br>
     * <b>post: </b> Se balanceó el subárbol izquierdo y se actualizarón los factores de balanceo. <br>
     * @return Nodo balanceado
     */
    private NodoAvl<T,K> balanceaIzq( )
    {
        if( izqNodo.balance == BIZQ )
        {
            // Caso 3
            balance = BAL;
            izqNodo.balance = BAL;
            return roteDer( );
        }
        else
        {
            // Caso 5
            switch( izqNodo.derNodo.balance )
            {
                case BIZQ:
                    balance = BDER;
                    izqNodo.balance = BAL;
                    break;
                case BAL:
                    balance = BAL;
                    izqNodo.balance = BAL;
                    break;
                case BDER:
                    balance = BAL;
                    izqNodo.balance = BIZQ;
                    break;
            }
            izqNodo.derNodo.balance = BAL;
            return roteIzqDer( );
        }
    }

    /**
     * Balancea el subárbol derecho de un árbol AVL que se ha desbalanceado por una inserción. Actualiza los factores de balanceo. <br>
     * <b>post: </b> Se balanceó el subárbol derecho y se actualizarón los factores de balanceo.
     * @return Nodo balanceado
     */
    private NodoAvl<T,K> balanceaDer( )
    {
        if( derNodo.balance == BDER )
        {
            // Caso 2
            balance = BAL;
            derNodo.balance = BAL;
            return roteIzq( );
        }
        else
        {
            // Caso 4
            switch( derNodo.izqNodo.balance )
            {
                case BIZQ:
                    balance = BAL;
                    derNodo.balance = BDER;
                    break;
                case BAL:
                    balance = BAL;
                    derNodo.balance = BAL;
                    break;
                case BDER:
                    balance = BIZQ;
                    derNodo.balance = BAL;
                    break;
            }
            derNodo.izqNodo.balance = BAL;
            return roteDerIzq( );
        }
    }

    /**
     * Rota a la izquierda un nodo y sus hijos. <br>
     * <b>post: </b> Se rotó a la izquierda un nodo y sus hijos.
     * @return El nodo rotado a la izquierda
     */
    private NodoAvl<T, K> roteIzq( )
    {
        NodoAvl<T,K> temp = derNodo;
        derNodo = temp.izqNodo;
        temp.izqNodo = this;
        return temp;
    }

    /**
     * Rota a la derecha un nodo y sus hijos. <br>
     * <b>post: </b> Se rotó a la derecha un nodo y sus hijos.
     * @return Nodo El nodo rotado a la derecha
     */
    private NodoAvl<T,K> roteDer( )
    {
        NodoAvl<T,K> temp = izqNodo;
        izqNodo = temp.derNodo;
        temp.derNodo = this;
        return temp;
    }

    /**
     * Rota a la derecha y después a la izquierda un nodo y sus hijos. <br>
     * <b>post: </b> Se rotó a la derecha y despues a la izquierda un nodo y sus hijos.
     * @return Nodo El nodo rotado a la derecha y luego a la izquierda
     */
    private NodoAvl<T,K> roteDerIzq( )
    {
        derNodo = derNodo.roteDer( );
        return roteIzq( );
    }

    /**
     * Rota a la izquierda y después a la derecha un nodo y sus hijos. <br>
     * <b>post: </b> Se rotó a la izquierda y despues a la derecha un nodo y sus hijos.
     * @return Nodo El nodo rotado a la izquierda y luego a la derecha
     */
    private NodoAvl<T,K> roteIzqDer( )
    {
        izqNodo = izqNodo.roteIzq( );
        return roteDer( );
    }

    /**
     * Se ha eliminado un elemento del subárbol izquierdo y por esta razón el subárbol derecho se encuentra desbalanceado. Esta rutina reestablece el balance perdido. Al
     * entrar, retorno.diferenciaAltura == TRUE. <br>
     * <b>pre: </b> retorno!=null. <br>
     * <b>post: </b> Se restableció el balanceó perdido a causa de una eliminacón en el subárbol izquierdo.
     * @param retorno Estructura que contiene el árbol resultado y una variable que me permite determinar si el nodo está desbalanceado
     */
    private void balanElimDer( Retorno retorno )
    {
        switch( balance )
        {
            case BIZQ:
                balance = BAL;
                retorno.respuesta = this;
                break;
            case BAL:
                balance = BDER;
                retorno.diferenciaAltura = false;
                retorno.respuesta = this;
                break;
            case BDER:
                if( derNodo.balance != BIZQ )
                {
                    retorno.respuesta = roteIzq( );
                    if( retorno.respuesta.balance == BAL )
                    {
                        retorno.respuesta.balance = BIZQ;
                        retorno.respuesta.izqNodo.balance = BDER;
                        retorno.diferenciaAltura = false;
                    }
                    else
                    {
                        retorno.respuesta.balance = BAL;
                        retorno.respuesta.izqNodo.balance = BAL;
                    }
                }
                else
                {
                    retorno.respuesta = roteDerIzq( );
                    if( retorno.respuesta.balance == BDER )
                    {
                        retorno.respuesta.izqNodo.balance = BIZQ;
                    }
                    else
                    {
                        retorno.respuesta.izqNodo.balance = BAL;
                    }
                    if( retorno.respuesta.balance == BIZQ )
                    {
                        retorno.respuesta.derNodo.balance = BDER;
                    }
                    else
                    {
                        retorno.respuesta.derNodo.balance = BAL;
                    }
                    retorno.respuesta.balance = BAL;
                }
                break;
        }
    }

    /**
     * Se ha eliminado un elemento del subárbol derecho y por esta razón el subárbol izquierdo se encuentra desbalanceado. Esta rutina reestablece el balance perdido. Al
     * entrar, ret.difAltura == TRUE. <br>
     * <b>pre: </b> retorno!=null. <br>
     * <b>post: </b> Se restableció el balanceó perdido a causa de una eliminacón en el subárbol derecho.
     * @param retorno Estructura que contiene el árbol resultado y una variable que me permite determinar si el nodo está desbalanceado
     */
    private void balanElimIzq( Retorno retorno )
    {
        switch( balance )
        {
            case BIZQ:
                if( izqNodo.balance != BDER )
                {
                    retorno.respuesta = roteDer( );
                    if( retorno.respuesta.balance == BAL )
                    {
                        retorno.respuesta.balance = BDER;
                        retorno.respuesta.derNodo.balance = BIZQ;
                        retorno.diferenciaAltura = false;
                    }
                    else
                    {
                        retorno.respuesta.balance = BAL;
                        retorno.respuesta.derNodo.balance = BAL;
                    }
                }
                else
                {
                    retorno.respuesta = roteIzqDer( );
                    if( retorno.respuesta.balance == BIZQ )
                    {
                        retorno.respuesta.derNodo.balance = BDER;
                    }
                    else
                    {
                        retorno.respuesta.derNodo.balance = BAL;
                    }
                    if( retorno.respuesta.balance == BDER )
                    {
                        retorno.respuesta.izqNodo.balance = BIZQ;
                    }
                    else
                    {
                        retorno.respuesta.izqNodo.balance = BAL;
                    }
                    retorno.respuesta.balance = BAL;
                }
                break;
            case BAL:
                balance = BIZQ;
                retorno.diferenciaAltura = false;
                retorno.respuesta = this;
                break;
            case BDER:
                balance = BAL;
                retorno.respuesta = this;
                break;
        }
    }

    /**
     * Retorna el nodo con el mayor elemento de un árbol AVL. <br>
     * <b>post: </b> Se retornó el nodo con el mayor elemento de un árbol AVL.
     * @return Nodo Nodo con el mayor elemento de un árbol AVL
     */
    private NodoAvl<T,K> mayorElemento( )
    {
        return ( derNodo == null ) ? this : derNodo.mayorElemento( );
    }

    /**
     * Retorna el nodo con el menor elemento de un árbol AVL.<br>
     * <b>post: </b> Se retornó el nodo con el menor elemento de un árbol AVL.
     * @return Nodo Nodo con el menor elemento de un árbol AVL
     */
    private NodoAvl<T,K> menorElemento( )
    {
        return ( izqNodo == null ) ? this : izqNodo.menorElemento( );
    }

    

    
    //METODOS GET AND SET

    /**
     * Devuelve la altura del árbol cuya raíz es el nodo actual. <br>
     * <b>post: </b> Se retornó la altura del árbol cuya raíz es el nodo actual.
     * @return Altura del árbol cuya raíz es el nodo actual
     */
    public int getAltura( )
    {
        int a1 = ( izqNodo == null ) ? 0 : izqNodo.getAltura( );
        int a2 = ( derNodo == null ) ? 0 : derNodo.getAltura( );
        return ( a1 >= a2 ) ? a1 + 1 : a2 + 1;
    }

    /**
     * Devuelve el elemento mayor del árbol cuya raíz es el nodo actual. <br>
     * <b>post: </b> Se retornó el elemento mayor del árbol cuya raíz es el nodo actual.
     * @return Elemento mayor del árbol cuya raíz es el nodo actual
     */
    public T getMayor( )
    {
        NodoAvl<T,K> nodo = mayorElemento( );
        return ( nodo == null ) ? null : nodo.getElem();
    }

    /**
     * Devuelve el elemento menor del árbol cuya raíz es el nodo actual. <br>
     * <b>post: </b> Se retornó el elemento menor del árbol cuya raíz es el nodo actual.
     * @return Elemento menor del árbol cuya raíz es el nodo actual
     */
    public T getMenor( )
    {
        NodoAvl<T,K> nodo = menorElemento( );
        return ( nodo == null ) ? null : nodo.getElem();
    }

    public T getElem() {
		return elem;
	}

	public void setElem(T elem) {
		this.elem = elem;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public NodoAvl<T, K> getDerNodo() {
		return derNodo;
	}

	public void setDerNodo(NodoAvl<T, K> derNodo) {
		this.derNodo = derNodo;
	}

	public NodoAvl<T, K> getIzqNodo() {
		return izqNodo;
	}

	public void setIzqNodo(NodoAvl<T, K> izqNodo) {
		this.izqNodo = izqNodo;
	}

    // -----------------------------------------------------------------
    // Clases Privadas
    // ----------------------------------------------------------------

	/**
     * Estructura para retornar la raíz del árbol AVL resultado de un proceso de modificación, con un indicador de si su altura ha sido modificada.
     */
    private class Retorno
    {
        // -----------------------------------------------------------------
        // Atributos
        // -----------------------------------------------------------------

        /**
         * Raíz del árbol de respuesta
         */
        private NodoAvl<T, K> respuesta;

        /**
         * Indicador de cambio de altura del árbol.
         */
        private boolean diferenciaAltura;

        // -----------------------------------------------------------------
        // Constructores
        // -----------------------------------------------------------------

        /**
         * Método constructor de la clase Retorno<br>
         * <b>post: </b> Se construyó en objeto retorno con los valores especificados<br>
         * @param pRespuesta Raíz del árbol de respuesta
         * @param pDiferenciaAltura Indicador de cambio de altura del árbol
         */
        private Retorno( NodoAvl<T,K> pRespuesta, boolean pDiferenciaAltura )
        {
            respuesta = pRespuesta;
            diferenciaAltura = pDiferenciaAltura;
        }
    }
    
  

    
}
