/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Carro de Compras Libros
 * Autor inicial: Katalina Marcos
 * Modificación: Jorge Jiménez- Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.carrocompralibro.mundo;

/**
 * Libro de la tienda de libros
 */
public class Libro
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /** Título del libro */
    private String titulo;

    /** ISBN del libro */
    private String isbn;

    /** Precio del libro */
    private int precio;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea el libro con su información básica: título, ISBN y precio.
     * @param unTitulo Título del libro. unTitulo!= null.
     * @param unISBN ISBN del libro. unISBN != null.
     * @param unPrecio Precio del libro. unPrecio >= 0.
     */
    public Libro( String unTitulo, String unISBN, int unPrecio )
    {
        titulo = unTitulo;
        isbn = unISBN;
        precio = unPrecio;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el título del libro.
     * @return Título del libro.
     */
    public String darTitulo( )
    {
        return titulo;
    }

    /**
     * Retorna el código ISBN del libro.
     * @return ISBN del libro.
     */
    public String darISBN( )
    {
        return isbn;
    }

    /**
     * Retorna el precio del libro.
     * @return Precio del libro.
     */
    public int darPrecio( )
    {
        return precio;
    }

    /**
     * Indica si este libro es igual a otro.
     * @param otroIsbn ISBN del otro libro con el que se compara este. otroISBN != null.
     * @return true si son dos libros iguales, false en caso contrario.
     */
    public boolean igualALibro( String otroIsbn )
    {
        boolean iguales = isbn.equals( otroIsbn );
        return iguales;
    }

}