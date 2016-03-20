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

/**
 * Clase de pruebas para el carro de compras de libros
 */
public class CarroCompraTest extends TestCase
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
     * Ítem de compras 1 para pruebas
     */
    private ItemCompra item1;

    /**
     * Ítem de compras 2 para pruebas
     */
    private ItemCompra item2;

    /**
     * Carrito de compras
     */
    private CarroCompras carrito;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Configuración inicial para las pruebas escenario 1
     */
    private void setupEscenario1( )
    {
        String titulo, isbn;
        int precio, cantidad1, cantidad2;

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

        // Crea un ítem de compra
        cantidad1 = 2;
        item1 = new ItemCompra( libro1, cantidad1 );

        // Crea otro ítem de compra
        cantidad2 = 3;
        item2 = new ItemCompra( libro2, cantidad2 );

        // Crea el carro de compras con un ítem de compra
        carrito = new CarroCompras( );
        carrito.adicionarCompra( libro1, cantidad1 );
        carrito.adicionarCompra( libro2, cantidad2 );
    }

    /**
     * Configuración inicial para las pruebas escenario 2
     */
    private void setupEscenario2( )
    {
        String titulo, isbn;
        int precio, cantidad1, cantidad2;

        // Crea el primer libro para pruebas
        titulo = "Titulo 3";
        isbn = "ISBN 3";
        precio = 10000;
        libro1 = new Libro( titulo, isbn, precio );

        // Crea el segundo libro para pruebas
        titulo = "Titulo 4";
        isbn = "ISBN 4";
        precio = 20000;
        libro2 = new Libro( titulo, isbn, precio );

        // Crea un ítem de compra
        cantidad1 = 20;
        item1 = new ItemCompra( libro1, cantidad1 );

        // Crea otro ítem de compra
        cantidad2 = 30;
        item2 = new ItemCompra( libro2, cantidad2 );

        // Crea el carro de compras con un ítem de compra
        carrito = new CarroCompras( );
        carrito.adicionarCompra( libro1, cantidad1 );
        carrito.adicionarCompra( libro2, cantidad2 );
    }

    /**
     * Configuración inicial para las pruebas escenario 3
     */
    private void setupEscenario3( )
    {
        String titulo, isbn;
        int precio, cantidad1, cantidad2;

        // Crea el primer libro para pruebas
        titulo = "Titulo 5";
        isbn = "ISBN 5";
        precio = 10;
        libro1 = new Libro( titulo, isbn, precio );

        // Crea el segundo libro para pruebas
        titulo = "Titulo 6";
        isbn = "ISBN 6";
        precio = 20;
        libro2 = new Libro( titulo, isbn, precio );

        // Crea un ítem de compra
        cantidad1 = 1;
        item1 = new ItemCompra( libro1, cantidad1 );

        // Crea otro ítem de compra
        cantidad2 = 2;
        item2 = new ItemCompra( libro2, cantidad2 );

        // Crea el carro de compras con un ítem de compra
        carrito = new CarroCompras( );
        carrito.adicionarCompra( libro1, cantidad1 );
        carrito.adicionarCompra( libro2, cantidad2 );
    }

    /**
     * Verifica la adición de un ítem de compra
     */
    public void testAdicionaItemCompra( )
    {
        setupEscenario1( );
        int cantidad;
        ItemCompra item;

        // Obtiene el libro del ítem. El libro esperado es el libro 1
        item = carrito.buscarItemCompraLibro( libro1.darISBN( ) );

        assertTrue( item.darLibro( ).igualALibro( libro1.darISBN( ) ) );

        // Verifica cantidades
        cantidad = 2;

        assertEquals( cantidad, item.darCantidadSolicitada( ) );
    }

    /**
     * Verifica que al adicionar un libro que ya estaba sume cantidades en lugar de crear un nuevo ítem
     */
    public void testAdicionaItemCompraExiste( )
    {
        setupEscenario2( );
        ItemCompra item;
        int cantidad;

        // Adiciona el mismo ítem de compra
        carrito.adicionarCompra( item1.darLibro( ), item1.darCantidadSolicitada( ) );

        // Obtiene el libro del ítem. El libro esperado es el libro 1
        item = carrito.buscarItemCompraLibro( libro1.darISBN( ) );

        assertTrue( item.darLibro( ).igualALibro( libro1.darISBN( ) ) );

        // Verifica cantidades
        cantidad = 20;

        assertEquals( cantidad * 2, item.darCantidadSolicitada( ) );
    }

    /**
     * Verifica la eliminación de un ítem de compra
     */
    public void testBorraItemCompra( )
    {
        setupEscenario3( );
        carrito.borrarItemCompra( item1 );

        // intenta buscar el ítem por el libro
        ItemCompra item = carrito.buscarItemCompraLibro( libro1.darISBN( ) );

        if( item != null )
            fail( "El libro ya no se debe encontrar en el carro" );
    }

    /**
     * Verifica la obtención de la lista de ítems
     */
    public void testObtenerListaItems( )
    {
        setupEscenario1( );
        ArrayList items;
        ItemCompra item;
        int cantidad1, cantidad2;

        cantidad1 = 2;
        cantidad2 = 3;

        // Obtiene los ítem de compra
        items = carrito.darListaCompra( );

        // Verifica número de ítem
        assertEquals( 2, items.size( ) );

        // Verifica los libros y las cantidades
        item = ( ItemCompra )items.get( 0 );
        assertTrue( libro1.igualALibro( item.darLibro( ).darISBN( ) ) );
        assertEquals( cantidad1, item.darCantidadSolicitada( ) );
        item = ( ItemCompra )items.get( 1 );
        assertTrue( libro2.igualALibro( item.darLibro( ).darISBN( ) ) );
        assertEquals( cantidad2, item.darCantidadSolicitada( ) );
    }

    /**
     * Verifica el cálculo del total de la compra
     */
    public void testCalculoTotal( )
    {
        setupEscenario2( );
        int precio1, precio2, cantidad1, cantidad2, totalEsperado;

        // Adiciona nuevamente los ítem de compra (pedido doble)
        carrito.adicionarCompra( item1.darLibro( ), item1.darCantidadSolicitada( ) );
        carrito.adicionarCompra( item2.darLibro( ), item2.darCantidadSolicitada( ) );

        // El valor de la compra es la suma de los precios de los libros por el
        // doble de las cantidades
        precio1 = 10000;
        precio2 = 20000;
        cantidad1 = 2 * 20;
        cantidad2 = 2 * 30;

        totalEsperado = precio1 * cantidad1 + precio2 * cantidad2;

        assertEquals( totalEsperado, carrito.calcularValorTotalCompra( ) );
    }

    /**
     * Verifica la búsqueda por ISBN de un libro
     */
    public void testBuscarItemCompraLibro( )
    {
        setupEscenario3( );
        carrito.adicionarCompra( item1.darLibro( ), item1.darCantidadSolicitada( ) );
        // intenta buscar el ítem por el libro
        ItemCompra item = carrito.buscarItemCompraLibro( libro1.darISBN( ) );
        assertEquals( item.darIsbnItem( ), item1.darIsbnItem( ) );
    }

}