/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Carro de Compras Libros
 * Autor inicial: Katalina Marcos
 * Modificación: Jorge Jiménez - Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.carrocompralibro.test;

import junit.framework.TestCase;
import uniandes.cupi2.carrocompralibro.mundo.Libro;

/**
 * Clase de pruebas para libro
 */
public class LibroTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Libro 1 para pruebas
     */
    private Libro libro1;

    /**
     * Libro 2 para pruebas
     */
    private Libro libro2;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Configuración inicial para las pruebas escenario 1
     */
    private void setupEscenario1( )
    {
        String titulo, isbn;
        int precio;

        // Crea el primer libro para pruebas
        titulo = "Titulo 1";
        isbn = "ISBN 1";
        precio = 1000;
        libro1 = new Libro( titulo, isbn, precio );

        // Crea el segundo libro para pruebas
        titulo = "Titulo 2";
        isbn = "ISBN 2";
        precio = 2000;
        libro2 = new Libro( titulo, isbn, precio );

    }

    /**
     * Configuración inicial para las pruebas escenario 2
     */
    private void setupEscenario2( )
    {
        String titulo, isbn;
        int precio;

        // Crea el primer libro para pruebas
        titulo = "Titulo 3";
        isbn = "ISBN 3";
        precio = 10;
        libro1 = new Libro( titulo, isbn, precio );

        // Crea el segundo libro para pruebas
        titulo = "Titulo 4";
        isbn = "ISBN 4";
        precio = 20;
        libro2 = new Libro( titulo, isbn, precio );

    }

    /**
     * Configuración inicial para las pruebas escenario 3
     */
    private void setupEscenario3( )
    {
        String titulo, isbn;
        int precio;

        // Crea el primer libro para pruebas
        titulo = "Titulo 5";
        isbn = "ISBN 5";
        precio = 100;
        libro1 = new Libro( titulo, isbn, precio );

        // Crea el segundo libro para pruebas
        titulo = "Titulo 6";
        isbn = "ISBN 6";
        precio = 200;
        libro2 = new Libro( titulo, isbn, precio );

    }

    /**
     * Verifica que los datos del libro sean correctamente creados
     */
    public void testCrearLibro( )
    {
        setupEscenario1( );
        String titulo, isbn;
        int precio;

        titulo = "Titulo 1";
        isbn = "ISBN 1";
        precio = 1000;

        assertEquals( titulo, libro1.darTitulo( ) );
        assertEquals( isbn, libro1.darISBN( ) );
        assertEquals( precio, libro1.darPrecio( ) );
    }

    /**
     * Verifica que la igualdad de libros sea correcta, comparando al libro consigo mismo
     */
    public void testLibrosIguales( )
    {
        setupEscenario3( );
        assertTrue( libro1.igualALibro( libro1.darISBN( ) ) );
    }

    /**
     * Verifica la desigualdad de libros
     */
    public void testLibrosDiferentes( )
    {
        setupEscenario1( );
        assertFalse( libro1.igualALibro( libro2.darISBN( ) ) );
    }

    /**
     * Verifica los títulos de los libros
     */
    public void testDarTitulos( )
    {
        setupEscenario2( );
        String titulo = "Titulo 3";

        assertEquals( libro1.darTitulo( ), titulo );
    }

    /**
     * Verifica los ISBN de los libros
     */
    public void testDarISBN( )
    {
        setupEscenario3( );
        String ISBN = "ISBN 5";

        assertEquals( libro1.darISBN( ), ISBN );
    }

    /**
     * Verifica los precios de los libros
     */
    public void testDarPrecios( )
    {
        setupEscenario1( );
        int precio = 1000;

        assertEquals( libro1.darPrecio( ), precio );
    }

}