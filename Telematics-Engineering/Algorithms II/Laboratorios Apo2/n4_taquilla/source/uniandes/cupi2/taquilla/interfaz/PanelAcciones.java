/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: taquilla
 * Autores: Kelvin Guerrero, Carlos Vega, Luis Ricardo Ruiz y Rafael Muñoz Lattion- 11-mar-2013
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.taquilla.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de acciones
 */
public class PanelAcciones extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Comando para agregar un nuevo socio
     */
    private final static String AGREGAR_SOCIO = "Agregar Socio";
    
    /**
     * Comando para ver el total de ingresos de la taquilla
     */
    private final static String TOTAL_INGRESOS = "Total Ingresos";
    
    /**
     * Comando para la opción 1
     */
    private final static String OPCION_1 = "Opción 1";

    /**
     * Comando para la opción 2
     */
    private final static String OPCION_2 = "Opción 2";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazTaquilla principal;

    //-----------------------------------------------------------------
    // Atributos de interfaz
    //-----------------------------------------------------------------

    /**
     * Botón para agregar un nuevo socio
     */
    private JButton butAgregarSocio;
    
    /**
     * Botón para ver el total de ingresos de la taquilla
     */
    private JButton butTotalIngresos;
    
    /**
     * Botón para la opción 1
     */
    private JButton butOpcion1;

    /**
     * Botón para la opción 2
     */
    private JButton butOpcion2;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye el panel de acciones con una referencia a la ventana principal de la aplicación. <br>
     * <b>post: </b> Construyó el panel e principal == ventana.<br>
     * @param ventana Referencia a la ventana principal. ventana != null.
     */
    public PanelAcciones( InterfazTaquilla ventana )
    {
        principal = ventana;

        setBorder( new TitledBorder( "Acciones" ) );
        setLayout( new GridLayout( 2, 2 ) );
        
        butAgregarSocio = new JButton( AGREGAR_SOCIO );
        butAgregarSocio.setActionCommand( AGREGAR_SOCIO );
        butAgregarSocio.addActionListener( this );
        add( butAgregarSocio );
        
        butTotalIngresos = new JButton( TOTAL_INGRESOS );
        butTotalIngresos.setActionCommand( TOTAL_INGRESOS );
        butTotalIngresos.addActionListener( this );
        add( butTotalIngresos );
        
        butOpcion1 = new JButton( OPCION_1 );
        butOpcion1.setActionCommand( OPCION_1 );
        butOpcion1.addActionListener( this );
        add(butOpcion1);
        
        butOpcion2 = new JButton( OPCION_2 );
        butOpcion2.setActionCommand( OPCION_2 );
        butOpcion2.addActionListener( this );
        add(butOpcion2);
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        
        if( comando.equals( AGREGAR_SOCIO ) )
        {
            principal.abrirDialogoAgregarSocio( );
        }
        else if( comando.equals( TOTAL_INGRESOS ) )
        {
            principal.darTotalIngresos( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1();
        }
        else if( comando.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2();
        }
    }

}
