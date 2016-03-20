package RB;

import java.io.Serializable;

import utilArboles.IAbb;

public class Arn<T,K extends Comparable<K>> implements Serializable, IAbb<T,K>
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Constante para la serializaci�n
	 */
	private static final long serialVersionUID = 1L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
    /**
     * Raiz del �rbol.
     */
    private NodoArn<T,K> root;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------    

    /**
     * Constructor por defecto.
     * </p>
     * Construye un �rbol vacio.
     */
    public Arn( )
    {
        root = null;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------      
    
    /*
     * (non-Javadoc)
     * @see uniandes.cupi2.collections.arbol.IArbolOrdenado#insertar(java.lang.Comparable)
     */
    public void add( T elem, K key ) throws Exception
    {
        // Crear el nuevo nodo y agregarlo como si el arbol fuera un arbol
        // binario normal
        NodoArn<T,K> nodo = new NodoArn<T,K>( elem, key );

        NodoArn<T,K> r2 = null;

        if( root == null )
        {
            root = nodo;
            root.cambiarColor( NodoArn.NEGRO );
        }
        else
        {
            r2 = root.insertar( nodo );
        }

        root = r2 != null && r2.darPadre( ) == null ? r2 : root;
    }

    /*
     * (non-Javadoc)
     * @see uniandes.cupi2.collections.arbol.IArbolOrdenado#eliminar(java.lang.Comparable)
     */
    public void remove( K key ) throws Exception
    {
        if( root == null )
            throw new Exception( "El árbol se encuentra vacio" );
        if( root.darKeyNodo().compareTo( key) == 0 && root.hijoDerechoHoja( ) && root.hijoIzquierdoHoja( ) )
            root = null;
        else
        {
            NodoArn<T,K> r2 = root.darNodo( key ).eliminar( );
            root = r2 != null && r2.darPadre( ) == null ? r2 : root;
        }
    }
    
    public NodoArn<T,K> getRoot(){
    	return root;
    }

  

    /**
     * Verifica si un elemento existe en el arbol.
     * 
     * @param elem Elemento a buscar en el arbol.
     * @return <code>true</code> si el elemento es encontrado en el arbol o <code>false</code> en caso contrario.
     */
    public boolean existe( K key)
    {
        return root != null ? root.existe( key ) : false;
    }

    /*
     * (non-Javadoc)
     * @see uniandes.cupi2.collections.arbol.IArbol#buscar(java.lang.Object)
     */
    public T search( K modelo )
    {
        try
        {
            return root != null ? root.darNodo( modelo ).darInfoNodo( ) : null;
        }
        catch(Exception e )
        {
            return null;
        }
    }

    /**
     * Retorna la raiz del árbol.
     * 
     * @return La raiz del árbol.
     */
    public NodoArn<T,K> darRaiz( )
    {
        return root;
    }

    
    /* (non-Javadoc)
     * @see uniandes.cupi2.collections.arbol.IArbol#darPeso()
     */
    public int getWeight( )
    {
        return root == null ? 0 : root.darPeso( );
    }

    /* (non-Javadoc)
     * @see uniandes.cupi2.collections.arbol.IArbol#darAltura()
     */
    public int getHeight( )
    {
        return root == null ? 0 : root.darAltura( );
    }

    /**
     * Retorna el menor elemento del árbol.
     * 
     * @return El menor elemento del árbol o <code>null</code> si el árbol esta vacio.
     */
    public T darMinimo( )
    {
        return root == null ? null : root.darMenor( ).darInfoNodo( );
    }

    /**
     * Retorna el mayor elemento del árbol.
     * 
     * @return El mayor elemento del árbol o <code>null</code> si el árbol esta vacio.
     */
    public T darMayor( )
    {
        return root == null ? null : root.darMayor( ).darInfoNodo( );
    }

}