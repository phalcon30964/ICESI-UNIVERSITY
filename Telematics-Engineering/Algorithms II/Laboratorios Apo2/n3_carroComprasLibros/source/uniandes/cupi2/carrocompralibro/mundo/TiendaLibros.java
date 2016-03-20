/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Carro de Compras Libros
 * Autor inicial: Katalina Marcos
 * Autor: Jorge Jiménez- Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.carrocompralibro.mundo;

import java.util.*;

/**
 * Tienda de venta de libros
 */
public class TiendaLibros
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Catálogo o lista de libros
     */
    private ArrayList catalogo;

    /**
     * Carro de compras de los libros
     */
    private CarroCompras carrito;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea la tienda de libros con el catálogo de libros vacío
     */
    public TiendaLibros( )
    {
        catalogo = new ArrayList( );
        carrito = new CarroCompras( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Adiciona un nuevo libro al catálogo de la tienda. <br>
     * <b>post: </b> Se agregó un libro al catálogo.
     * @param nuevoLibro Nuevo libro del catálogo. nuevoLibro != null.
     */
    public void adicionarLibroCatalogo( Libro nuevoLibro )
    {
        // Verifica que el libro no se haya ingresado antes
        Libro libro = buscarLibro( nuevoLibro.darISBN( ) );
        // Sólo añade el libro si no existe ya
        if( libro == null )
            catalogo.add( nuevoLibro );
    }

    /**
     * Crea una nueva compra. <br>
     * <b>post: </b> Se creó un nuevo carrito de compras sin ítem de compra.
     */
    public void crearNuevaCompra( )
    {
        carrito = new CarroCompras( );
    }

    /**
     * Retorna el catálogo de la tienda. <br>
     * @return El catálogo de la tienda.
     */
    public ArrayList darCatalogo( )
    {
        return catalogo;
    }

    /**
     * Retorna el carro de compras.
     * @return El carro de compras.
     */
    public CarroCompras darCarritoCompras( )
    {
        return carrito;
    }

    /**
     * Retorna si existe un libro del catálogo de la tienda con el ISBN dado.
     * @param isbn ISBN del libro que se quiere buscar en el catálogo.
     * @return libro Libro encontrado en el catalogo o null si no existe.
     */
    public Libro buscarLibro( String isbn )
    {
        int indice = 0;
        int totalLibros = catalogo.size( );
        Libro libroEncontrado = null;
        boolean encontrado = false;
        while( indice < totalLibros && !encontrado )
        {
            libroEncontrado = ( Libro )catalogo.get( indice );
            if( libroEncontrado.igualALibro( isbn ) )
                encontrado = true;
            indice++;
        }
        if( encontrado )
            return libroEncontrado;
        else
            return null;
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método 1 de extensión al ejemplo
     * @return respuesta
     * Debe colocar en este metodo el nombre del libro del carro
     * de compras más barato
     */

    public String metodo1( )
    {
        return "Respuesta 1";
    }

    /**
     * Método 2 de extensión al ejemplo
     * @return respuesta
     */
    public String metodo2( )
    {
        return "Respuesta 2";
    }

}