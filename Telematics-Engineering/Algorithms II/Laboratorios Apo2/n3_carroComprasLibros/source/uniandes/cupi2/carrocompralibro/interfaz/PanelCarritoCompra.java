/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Carro de Compras Libros
 * Autor: Jorge Jiménez- Junio 2005
 * Autor inicial: Katalina Marcos
 * Modificación: Jorge Jiménez- Junio 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.carrocompralibro.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import uniandes.cupi2.carrocompralibro.mundo.CarroCompras;
import uniandes.cupi2.carrocompralibro.mundo.ItemCompra;

/**
 * Panel para el manejo del carrito de compras
 */
public class PanelCarritoCompra extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String BORRAR_CARRO = "BORRAR_CARRO";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    /**
     * Modelo de la tabla del carrito de compras
     */
    private TablaModeloCarroCompras carroCompras;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------
    /**
     * Tabla del carro de compras
     */
    private JTable tablaCarrito;

    /**
     * Barra de desplazamiento
     */
    private JScrollPane desplazamientoPanel;

    /**
     * Etiqueta de cantidad
     */
    private JLabel campoTotal;

    /**
     * Campo valor Cantidad
     */
    private JTextField valorTotal;

    /**
     * Botón borrar libro
     */
    private JButton botonBorrarLibro;

    /**
     * Interfaz principal
     */
    private InterfazTiendaLibros ventanaPrincipal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de operaciones.
     * @param unaVentana Ventana Principal. unaVentana != null.
     * @param unCarro Carro de compras de la tienda. unCarro != null.
     */
    public PanelCarritoCompra( InterfazTiendaLibros unaVentana, CarroCompras unCarro )
    {
        ventanaPrincipal = unaVentana;

        setLayout( new BorderLayout( ) );
        setBorder( new EmptyBorder( 5, 1, 5, 1 ) );
        setBorder( BorderFactory.createTitledBorder( "Detalle del carrito de compras" ) );

        // Crea el panel para presentar al carrito
        carroCompras = new TablaModeloCarroCompras( unCarro );
        tablaCarrito = new JTable( carroCompras );
        tablaCarrito.setPreferredScrollableViewportSize( new Dimension( 475, 100 ) );
        desplazamientoPanel = new JScrollPane( tablaCarrito );

        add( desplazamientoPanel, BorderLayout.CENTER );

        //Botones de manejo
        JPanel panelOpciones = new JPanel( );
        panelOpciones.setLayout( new GridLayout( 1, 4, 8, 2 ) );
        panelOpciones.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        botonBorrarLibro = new JButton( );
        inicializarBotones( botonBorrarLibro, "Borrar", PanelCarritoCompra.BORRAR_CARRO, Color.black, "Borra un libro del carro de compras" );
        campoTotal = new JLabel( "Total" );
        campoTotal.setHorizontalAlignment( SwingConstants.RIGHT );
        valorTotal = new JTextField( "" + 0 );
        valorTotal.setPreferredSize( new Dimension( 100, 20 ) );
        valorTotal.setEditable( false );
        panelOpciones.add( botonBorrarLibro );
        panelOpciones.add( campoTotal );
        panelOpciones.add( valorTotal );
        add( panelOpciones, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la tabla que modela el carrito de compras.
     * @return tablaCarrito .Tabla del carrito. tablaCarrito != null.
     */
    public JTable darTablaCarrito( )
    {
        return tablaCarrito;
    }

    /**
     * Actualiza la información que se despliega del carro de compras
     */
    public void actualizarCarrito( )
    {
        carroCompras.fireTableDataChanged( );
    }

    /**
     * Acciones de respuesta a eventos ejecutados por el usuario.
     * @param evento Evento realizado por el usuario. evento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String actionCommand = evento.getActionCommand( );

        // Botón Borrar del Carro
        if( actionCommand.equals( PanelCarritoCompra.BORRAR_CARRO ) )
        {
            try
            {
                //Busca el ítem a borrar
                int filaSeleccionada = tablaCarrito.getSelectedRow( );

                if( filaSeleccionada == -1 )
                {
                    JOptionPane.showMessageDialog( this, "Debe seleccionar primero un libro en el carro para borrarlo", "Compra de libro", JOptionPane.WARNING_MESSAGE );
                    return;
                }

                ItemCompra itemBorrar = ( ItemCompra )tablaCarrito.getValueAt( filaSeleccionada, -1 );

                //Borra el elemento
                ventanaPrincipal.borrarCompra( itemBorrar );
            }
            catch( Exception e2 )
            {
                JOptionPane.showMessageDialog( this, "Debe seleccionar primero un libro en el carro para borrarlo", "Compra de libro", JOptionPane.WARNING_MESSAGE );
                return;
            }
        }

    }

    /**
     * Cambia el valor del campo de resultados.
     * @param valor Nuevo valor.
     */
    public void colocarValorTotal( int valor )
    {
        valorTotal.setText( formatearValor( valor ) );
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
     * Formatea un valor numérico para presentar en la interfaz.
     * @param valor Valor numérico a ser formateado.
     * @return Retorna una cadena con el valor formateado con puntos y signos.
     */
    private String formatearValor( int valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }
}
