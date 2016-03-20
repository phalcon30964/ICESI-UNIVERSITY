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
package uniandes.cupi2.carrocompralibro.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import uniandes.cupi2.carrocompralibro.mundo.Libro;
import uniandes.cupi2.carrocompralibro.mundo.TiendaLibros;

/**
 * Panel para el manejo del Catálogo
 */
public class PanelCatalogo extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    private static final String AGREGAR_CARRO = "AGREGAR_CARRO";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Modelo de la tabla del catálogo
     */
    private TablaModeloCatalogo catalogo;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Tabla del catálogo
     */
    private JTable tablaCatalogo;

    /**
     * Barra de desplazamiento
     */
    private JScrollPane desplazamientoPanel;

    /**
     * Instancia del la clase principal de la interfaz
     */
    private InterfazTiendaLibros ventanaPrincipal;

    /**
     * Botón Comprar Libro
     */
    private JButton botonComprarLibro;

    /**
     * Etiqueta título
     */
    private JLabel etiquetaCantidad;

    /**
     * Campo del título
     */
    private JTextField txtCantidad;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel que maneja el catálogo.
     * @param interfaz Interfaz principal. interfaz != null.
     * @param tienda Tienda de libros a desplegar. tienda != null.
     */

    public PanelCatalogo( InterfazTiendaLibros interfaz, TiendaLibros tienda )
    {
        ventanaPrincipal = interfaz;

        setLayout( new BorderLayout( ) );
        setBorder( new EmptyBorder( 5, 1, 5, 1 ) );
        setBorder( BorderFactory.createTitledBorder( "Detalle del catálogo" ) );

        // Crea la tabla para el catálogo
        catalogo = new TablaModeloCatalogo( tienda );
        tablaCatalogo = new JTable( catalogo );
        tablaCatalogo.setPreferredScrollableViewportSize( new Dimension( 480, 100 ) );

        desplazamientoPanel = new JScrollPane( tablaCatalogo );
        add( desplazamientoPanel, BorderLayout.CENTER );

        //Botón de compra y cantidad
        JPanel panelCompra = new JPanel( );
        panelCompra.setLayout( new FlowLayout( ) );
        panelCompra.setPreferredSize( new Dimension( 200, 50 ) );

        //Cantidad
        JPanel panelCantidad = new JPanel( );
        etiquetaCantidad = new JLabel( "Cantidad " );
        etiquetaCantidad.setPreferredSize( new Dimension( 100, 20 ) );
        txtCantidad = new JTextField( );
        txtCantidad.setPreferredSize( new Dimension( 100, 20 ) );
        txtCantidad.setColumns( 15 );
        txtCantidad.setPreferredSize( new Dimension( 100, 20 ) );
        panelCantidad.setLayout( new GridLayout( 3, 0 ) );
        panelCantidad.setPreferredSize( new Dimension( 80, 50 ) );
        panelCantidad.add( etiquetaCantidad );
        panelCantidad.add( txtCantidad );
        panelCompra.add( panelCantidad );

        botonComprarLibro = new JButton( );
        inicializarBotones( botonComprarLibro, "Comprar", PanelCatalogo.AGREGAR_CARRO, Color.black, "Agregar libro al carro de compras" );
        panelCompra.add( botonComprarLibro );
        add( panelCompra, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información que se despliega en el catálogo
     */
    public void actualizarCatalogo( )
    {
        catalogo.fireTableDataChanged( );
    }

    /**
     * Define las propiedades para un botón.
     * @param boton Botón al cual se le definen las propiedades. boton != null.
     * @param etiqueta Texto de presentación del botón. etiqueta != null.
     * @param comando Acción asociada al botón. comando != null.
     * @param colorTexto Color del texto de presentación. colorTexto != null.
     * @param ayuda Texto ayuda del botón. ayuda != null.
     */
    private void inicializarBotones( JButton boton, String etiqueta, String comando, Color colorTexto, String ayuda )
    {
        boton.setText( etiqueta );
        boton.setFocusable( false );
        boton.setActionCommand( comando );
        boton.addActionListener( this );
        boton.setForeground( colorTexto );
        boton.setToolTipText( ayuda );
        boton.setDefaultCapable( false );
    }

    /**
     * Respuestas a los eventos ejecutados por el usuario.
     * @param evento Evento generado por el usuario. evento !=null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String actionCommand = evento.getActionCommand( );

        if( actionCommand.equals( PanelCatalogo.AGREGAR_CARRO ) )
        {
            //Saca la cantidad
            int cantidad;
            try
            {
                cantidad = Integer.parseInt( txtCantidad.getText( ) );
                if( cantidad <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "La cantidad debe ser mayor a cero", "Compra de libro", JOptionPane.ERROR_MESSAGE );
                    return;
                }
            }
            catch( Exception exception )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar un número", "Compra de libro", JOptionPane.ERROR_MESSAGE );
                return;
            }

            //Saca el libro
            Libro libro;
            try
            {
                libro = ( Libro )tablaCatalogo.getValueAt( tablaCatalogo.getSelectedRow( ), -1 );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "Debe seleccionar un libro válido", "Compra de libro", JOptionPane.ERROR_MESSAGE );
                return;
            }

            //Delega el llamado
            ventanaPrincipal.adicionarCompra( libro, cantidad );
        }

    }
}