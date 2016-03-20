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
 * Modificación: Pablo Barvo 25-Ago-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.carrocompralibro.interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.carrocompralibro.mundo.CarroCompras;
import uniandes.cupi2.carrocompralibro.mundo.ItemCompra;
import uniandes.cupi2.carrocompralibro.mundo.Libro;
import uniandes.cupi2.carrocompralibro.mundo.TiendaLibros;

/**
 * Ventana principal de la interfaz de la tienda de libros
 */
public class InterfazTiendaLibros extends JFrame
{

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel para el carro de compras
     */
    private PanelCarritoCompra panelCarrito;

    /**
     * Panel para el catálogo
     */
    private PanelCatalogo panelCatalogo;

    /**
     * Panel de botones del catálogo
     */
    private PanelBotonesCatalogo panelBotonesCatalogo;

    /**
     * Dialogo para agregar un Libro
     */
    private DialogoAgregarLibro agregarLibro;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Carrito de compras
     */
    private CarroCompras carrito;

    /**
     * Tienda del carro
     */
    private TiendaLibros tienda;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la ventana principal de la tienda de libros.
     */
    public InterfazTiendaLibros( )
    {

        tienda = new TiendaLibros( );
        carrito = tienda.darCarritoCompras( );

        JPanel panelSuperior = new JPanel( new BorderLayout( ) );
        panelCatalogo = new PanelCatalogo( this, tienda );
        panelBotonesCatalogo = new PanelBotonesCatalogo( this );
        panelSuperior.add( panelBotonesCatalogo, BorderLayout.NORTH );
        panelSuperior.add( panelCatalogo, BorderLayout.CENTER );

        JPanel panelInferior = new JPanel( new BorderLayout( ) );
        panelCarrito = new PanelCarritoCompra( this, carrito );
        panelInferior.add( panelCarrito, BorderLayout.CENTER );

        agregarLibro = new DialogoAgregarLibro( this );
        setPreferredSize( new Dimension( 500, 500 ) );

        add( panelSuperior, BorderLayout.NORTH );
        add( panelInferior, BorderLayout.CENTER );
        setTitle( "Tienda de Libros" );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Método para desplegar el diálogo de agregación.
     */
    public void agregarLibro( )
    {
        agregarLibro.setLocation( calculaPosicionCentral( this, agregarLibro ) );
        agregarLibro.setVisible( true );
        agregarLibro.setModal( true );
    }

    /**
     * Adiciona un libro al catálogo de la tienda de libros.
     * @param titulo Título del Libro. titulo != null.
     * @param isbn ISBN del libro. isbn != null.
     * @param precio Precio del libro. precio != null.
     */
    public void adicionarLibroCatalogo( String titulo, String isbn, int precio )
    {
        Libro nuevoLibro = new Libro( titulo, isbn, precio );
        tienda.adicionarLibroCatalogo( nuevoLibro );
        panelCatalogo.actualizarCatalogo( );
    }

    /**
     * Indica si el ISBN dado existe en el inventario.
     * @param isbn ISBN del libro. isbn != null.
     * @return true si el ISBN corresponde a un libro existente, false en caso contrario.
     */
    public boolean existeLibro( String isbn )
    {
        boolean esta = false;
        Libro libroObtenido = tienda.buscarLibro( isbn );
        if( null != libroObtenido )
            esta = true;
        return esta;
    }

    /**
     * Adiciona una compra al carrito de la tienda.
     * @param libroCompra Libro a adicionar. libroCompra != null.
     * @param cantidad Cantidad de libros a adicionar. cantidad >= 0.
     */
    public void adicionarCompra( Libro libroCompra, int cantidad )
    {
        if( cantidad != 0 )
        {
            carrito.adicionarCompra( libroCompra, cantidad );
            panelCarrito.actualizarCarrito( );
            panelCarrito.colocarValorTotal( carrito.calcularValorTotalCompra( ) );
        }
    }

    /**
     * Retira una compra al carrito de la tienda.
     * @param itemBorrar Ítem a borrar del carrito. itemBorrar != null.
     */
    public void borrarCompra( ItemCompra itemBorrar )
    {
        carrito.borrarItemCompra( itemBorrar );
        panelCarrito.actualizarCarrito( );
        panelCarrito.colocarValorTotal( carrito.calcularValorTotalCompra( ) );
    }

    /**
     * Calcula el punto que indica la posición centrada del frame.
     * @param componentePadre Ventana principal. componentePadre !=null.
     * @param componenteHijo Ventana a centrar. componenteHijo != null.
     * @return punto de localización del nuevo componente. punto != null.
     */
    private Point calculaPosicionCentral( Component componentePadre, Component componenteHijo )
    {
        Dimension tamanoPantalla, tamanoPadre, tamanoHijo;
        Point localizacionPadre;

        // Centra la ventana y verifica que no sea mayor que la resolución
        // actual
        tamanoPantalla = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int max_y = tamanoPantalla.height;
        int min_y = 0;

        // Tamaño de la resolución de la pantalla
        tamanoPadre = componentePadre.getSize( );
        localizacionPadre = componentePadre.getLocation( );
        tamanoHijo = componenteHijo.getSize( );
        int x = ( tamanoPadre.width - tamanoHijo.width ) / 2 + localizacionPadre.x;
        int y = ( tamanoPadre.height - tamanoHijo.height ) / 2 + localizacionPadre.y;

        // Ajuste para abajo
        if( y + tamanoHijo.height > max_y )
        {
            y = max_y - tamanoHijo.height;
        }

        // Ajuste para arriba
        if( y < min_y )
        {
            y = 0;
        }
        return new Point( x, y );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método de ejecuta la extensión 1.
     */
    public void reqFuncOpcion1( )
    {
        String respuesta = tienda.metodo1( );
        JOptionPane.showMessageDialog( this, respuesta, "Opción 1", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método de ejecuta la extensión 2.
     */

    public void reqFuncOpcion2( )
    {
        String respuesta = tienda.metodo2( );
        JOptionPane.showMessageDialog( this, respuesta, "Opción 2", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Ejecución
    // -----------------------------------------------------------------

    /**
     * Método principal de ejecución
     * @param args Argumentos de entrada en la ejecución. No se utilizan.
     */
    public static void main( String[] args )
    {
        try
        {
            InterfazTiendaLibros gui = new InterfazTiendaLibros( );
            gui.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}