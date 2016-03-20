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

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Panel que organiza los botones del catálogo
 */
public class PanelBotonesCatalogo extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String OPCION_1 = "OPCION_1";
    private static final String OPCION_2 = "OPCION_2";
    private static final String AGREGAR_LIBRO = "AGREGAR_LIBRO";

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Botón extensión 1
     */
    private JButton botonOpcion1;

    /**
     * Botón extensión 2
     */
    private JButton botonOpcion2;
    /**
     * Botón Agregar Libro
     */
    private JButton botonAgregarLibro;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Instancia del la clase principal de la interfaz
     */

    private InterfazTiendaLibros ventanaPrincipal;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de operaciones.
     * @param principal Ventana principal. principal != null.
     */
    public PanelBotonesCatalogo( InterfazTiendaLibros principal )
    {
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setLayout( new GridLayout( 1, 3, 8, 1 ) );
        ventanaPrincipal = principal;

        botonAgregarLibro = new JButton( );
        inicializarBotones( botonAgregarLibro, "Adicionar libro", PanelBotonesCatalogo.AGREGAR_LIBRO, Color.black, "Adicionar un nuevo libro al catálogo" );
        add( botonAgregarLibro );

        botonOpcion1 = new JButton( );
        inicializarBotones( botonOpcion1, "Opción 1", PanelBotonesCatalogo.OPCION_1, Color.black, "Opcion 1" );
        add( botonOpcion1 );

        botonOpcion2 = new JButton( );
        inicializarBotones( botonOpcion2, "Opción 2", PanelBotonesCatalogo.OPCION_2, Color.black, "Opcion 2" );
        add( botonOpcion2 );

    }

    /**
     * Define las propiedades para un botón.
     * @param boton Botón al cual se le definen las propiedades. boton !=null.
     * @param etiqueta Texto de presentación del botón. etiqueta != null.
     * @param comando Acción asociada al botón. comando != null
     * @param colorTexto Color del texto del botón. colorTexto != null.
     * @param ayuda Texto de ayuda del botón. ayuda != null.
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
     * Atiende los eventos del usuario.
     * @param evento Evento generado por el usuario. evento != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String actionCommand = evento.getActionCommand( );

        // Botón Agregar Libro
        if( actionCommand.equals( PanelBotonesCatalogo.AGREGAR_LIBRO ) )
        {
            ventanaPrincipal.agregarLibro( );
        }
        // Botón opción 1
        else if( actionCommand.equals( PanelBotonesCatalogo.OPCION_1 ) )
        {
            ventanaPrincipal.reqFuncOpcion1( );
        }
        // Botón opción 2
        else if( actionCommand.equals( PanelBotonesCatalogo.OPCION_2 ) )
        {
            ventanaPrincipal.reqFuncOpcion2( );
        }
    }
}