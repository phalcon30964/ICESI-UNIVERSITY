/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: taquilla
 * Autores: Kelvin Guerrero, Carlos Vega, Luis Ricardo Ruiz y Rafael Muñoz Lattion - 11-mar-2013
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.taquilla.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.cupi2.taquilla.mundo.Partido;

/**
 * Panel del partido
 */
public class PanelPartido extends JPanel implements ActionListener, ListSelectionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------
    
    /**
     * Comando para agregar un partido
     */
    private final static String AGREGAR_PARTIDO = "Agregar Partido";
    
    /**
     * Comando para eliminar un partido
     */
    private final static String ELIMINAR_PARTIDO = "Eliminar Partido";
    
    /**
     * Comando para vender una silla
     */
    private final static String VENDER_SILLA = "Vender Silla";
    
    /**
     * Comando para vender una silla automáticamente
     */
    private final static String VENDER_SILLA_AUTOMATICAMENTE = "Vender Silla Automáticamente";
    
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    
    /**
     * Ventana principal de la aplicación
     */
    private InterfazTaquilla principal;
    
    //-----------------------------------------------------------------
    // Atributos de la interfaz
    //-----------------------------------------------------------------
    
    /**
     * Lista de los partidos
     */
    private JList listaPartidos;
    
    /**
     * Botón para agregar un partido
     */
    private JButton butAgregarPartido;
    
    /**
     * Botón para eliminar un partido
     */
    private JButton butEliminarPartido;
    
    /**
     * Botón para vender una silla
     */
    private JButton butVenderSilla;
    
    /**
     * Botón para vender una silla automáticamente
     */
    private JButton butVenderSillaAutomatica;
    
    /**
     * Scroll de la lista de partidos
     */
    private JScrollPane scroll;
    
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------
    
    /**
     * Construye el panel de un partido con una referencia a la ventana principal de la aplicación. <br>
     * <b>post: </b> Construyó el panel e principal == ventana.<br>
     * @param ventana Referencia a la ventana principal. ventana != null.
     */
    public PanelPartido( InterfazTaquilla ventana )
    {
        principal = ventana;
        
        setLayout( new BorderLayout( ) );
        setBorder( new TitledBorder( "Partidos" ) );
        
        listaPartidos = new JList( );
        listaPartidos.addListSelectionListener( this );
        listaPartidos.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        scroll = new JScrollPane( listaPartidos );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK ) ) );
        add( scroll, BorderLayout.CENTER );
        
        JPanel panelAux = new JPanel( );
        panelAux.setLayout( new GridLayout( 4, 1, 5, 5 ) );
        
        butAgregarPartido = new JButton( AGREGAR_PARTIDO );
        butAgregarPartido.setActionCommand( AGREGAR_PARTIDO );
        butAgregarPartido.addActionListener( this );
        panelAux.add( butAgregarPartido );
        
        butEliminarPartido = new JButton( ELIMINAR_PARTIDO );
        butEliminarPartido.setActionCommand( ELIMINAR_PARTIDO );
        butEliminarPartido.addActionListener( this );
        panelAux.add( butEliminarPartido );
        
        butVenderSilla = new JButton( VENDER_SILLA );
        butVenderSilla.setActionCommand( VENDER_SILLA );
        butVenderSilla.addActionListener( this );
        panelAux.add( butVenderSilla );
        
        butVenderSillaAutomatica = new JButton( VENDER_SILLA_AUTOMATICAMENTE );
        butVenderSillaAutomatica.setActionCommand( VENDER_SILLA_AUTOMATICAMENTE );
        butVenderSillaAutomatica.addActionListener( this );
        panelAux.add( butVenderSillaAutomatica );
        
        add( panelAux, BorderLayout.SOUTH );
    }
    
    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
    
    /**
     * Retorna el partido seleccionado en la lista
     * @return El partido seleccionado en la lista
     */
    public Partido darPartidoActual( )
    {
        return ( Partido )listaPartidos.getSelectedValue( );
    }
    
    /**
     * Actualiza la lista de partidos con la que llega por parámetro.
     * @param pPartidos Los partidos que se deben mostrar en la lista
     */
    public void actualizarPartidos( ArrayList pPartidos )
    {
        listaPartidos.removeAll( );
        listaPartidos.setListData( pPartidos.toArray( ) );
        listaPartidos.setSelectedIndex( 0 );
    }
    
    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        
        if( comando.equals( AGREGAR_PARTIDO ) )
        {
            principal.abrirDialogoAgregarPartido( );
        }
        else if( comando.equals( ELIMINAR_PARTIDO ) )
        {
            principal.eliminarPartido( );
        }
        else if( comando.equals( VENDER_SILLA ) )
        {
            principal.abrirDialogoVenderSilla( );
        }
        else if( comando.equals( VENDER_SILLA_AUTOMATICAMENTE ) )
        {
            principal.abrirDialogoVenderSillaAutomaticamente( );
        }
    }

    public void valueChanged( ListSelectionEvent e )
    {
        if( listaPartidos.getSelectedIndex( ) != -1 )
        {
            principal.actualizarEstadio( ( Partido )listaPartidos.getSelectedValue( ) );
        }
    }
}