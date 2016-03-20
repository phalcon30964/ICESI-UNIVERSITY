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

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.carrocompralibro.mundo.CarroCompras;
import uniandes.cupi2.carrocompralibro.mundo.ItemCompra;
import uniandes.cupi2.carrocompralibro.mundo.Libro;
import uniandes.cupi2.carrocompralibro.mundo.TiendaLibros;

/**
 * Clase de pruebas para la tienda de libros
 */
public class TiendaLibrosTest extends TestCase
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Un libro de pruebas
     */
    private Libro libro1;

    /**
     * Segundo libro de pruebas
     */
    private Libro libro2;

    /**
     * Tienda de Libros
     */
    private TiendaLibros tienda;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Configuración inicial para las pruebas escenario 1
     */
    private void setupEscenario1( )
    {
        String titulo, isbn;
        int precio, cantidad;
        CarroCompras carro;

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

        // Adiciona los libros al catálogo
        tienda = new TiendaLibros( );
        tienda.adicionarLibroCatalogo( libro1 );
        tienda.adicionarLibroCatalogo( libro2 );

        // Inicializa el carro de compras
        carro = tienda.darCarritoCompras( );
        cantidad = 1;
        carro.adicionarCompra( libro1, cantidad );
    }

    /**
     * Configuración inicial para las pruebas escenario 2.
     */
    private void setupEscenario2( )
    {
        String titulo, isbn;
        int precio, cantidad;
        CarroCompras carro;

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

        // Adiciona los libros al catálogo
        tienda = new TiendaLibros( );
        tienda.adicionarLibroCatalogo( libro1 );
        tienda.adicionarLibroCatalogo( libro2 );

        // Inicializa el carro de compras
        carro = tienda.darCarritoCompras( );
        cantidad = 2;
        carro.adicionarCompra( libro1, cantidad );
    }

    /**
     * Configuración inicial para las pruebas escenario 3
     */
    private void setupEscenario3( )
    {
        String titulo, isbn;
        int precio, cantidad;
        CarroCompras carro;
        // Obtiene los datos de prueba

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

        // Adiciona los libros al catalogo
        tienda = new TiendaLibros( );
        tienda.adicionarLibroCatalogo( libro1 );
        tienda.adicionarLibroCatalogo( libro2 );

        // Inicializa el carro de compras
        carro = tienda.darCarritoCompras( );
        cantidad = 3;
        carro.adicionarCompra( libro1, cantidad );
    }

    /**
     * Verifica la adición de y obtención de libros del catálogo
     */
    public void testAdicionaLibroCatalogo( )
    {
        setupEscenario1( );
        Libro libroObtenido;
        libroObtenido = tienda.buscarLibro( libro1.darISBN( ) );
        assertTrue( "Adición libro", libroObtenido.igualALibro( libro1.darISBN( ) ) );
        assertEquals( "ISBN adición libro", libroObtenido.darISBN( ), libro1.darISBN( ) );
        assertEquals( "Titulo adición libro", libroObtenido.darTitulo( ), libro1.darTitulo( ) );
        assertEquals( "Precio adición libro", libroObtenido.darPrecio( ), libro1.darPrecio( ) );
    }

    /**
     * Verifica que al adicionar un libro que ya existe no lo adicione
     */
    public void testAdicionaLibroExiste( )
    {
        setupEscenario2( );
        int numeroLibrosAntes, numeroLibrosDespues;

        numeroLibrosAntes = tienda.darCatalogo( ).size( );
        tienda.adicionarLibroCatalogo( libro1 );
        numeroLibrosDespues = tienda.darCatalogo( ).size( );

        assertEquals( "Adición libro existe", numeroLibrosAntes, numeroLibrosDespues );
    }

    /**
     * Verifica la obtención del catálogo
     */
    public void testObtenerCatalogo( )
    {
        setupEscenario3( );
        Libro libro;
        ArrayList catalogo = tienda.darCatalogo( );

        // Verifica el primer libro
        libro = ( Libro )catalogo.get( 0 );
        assertTrue( libro.igualALibro( libro1.darISBN( ) ) );

        // Verifica el segundo libro
        libro = ( Libro )catalogo.get( 1 );
        assertTrue( libro.igualALibro( libro2.darISBN( ) ) );
    }

    /**
     * Verifica la obtención del carrito de compras
     */
    public void testObtenerCarro( )
    {
        setupEscenario1( );
        CarroCompras carro = tienda.darCarritoCompras( );
        ItemCompra item = carro.buscarItemCompraLibro( libro1.darISBN( ) );
        assertTrue( libro1.igualALibro( item.darLibro( ).darISBN( ) ) );
    }

    /**
     * Verifica que al inicializa la compra el carro quede vacío
     */
    public void testNuevaCompra( )
    {
        setupEscenario2( );
        tienda.crearNuevaCompra( );
        CarroCompras carro = tienda.darCarritoCompras( );
        assertEquals( 0, carro.darListaCompra( ).size( ) );
    }

    /**
     * Verifica que el libro insertado esté
     */
    public void testBuscarLibro( )
    {
        setupEscenario3( );
        CarroCompras carro = tienda.darCarritoCompras( );
        ItemCompra item = carro.buscarItemCompraLibro( libro1.darISBN( ) );
        Libro libro = item.darLibro( );
        assertEquals( libro, tienda.buscarLibro( libro.darISBN( ) ) );
    }

}