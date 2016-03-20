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
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import uniandes.cupi2.taquilla.mundo.Partido;
import uniandes.cupi2.taquilla.mundo.Silla;

/**
 * Panel del estadio y sus localidades
 */
public class PanelEstadio extends JPanel implements MouseListener
{
    // -------------------------------------------------------------
    // Constantes
    // -------------------------------------------------------------



    /**
     * Constante que representa la Localidad Norte
     */
    public static final String LOCALIDAD_NORTE = "Localidad Norte";

    /**
     * Constante que representa la Localidad Occidental
     */
    public static final String LOCALIDAD_OCCIDENTAL = "Localidad Occidental";

    /**
     * Constante que representa la Localidad Oriental
     */
    public static final String LOCALIDAD_ORIENTAL = "Localidad Oriental";

    /**
     * Constante que representa la Localidad Sur
     */
    public static final String LOCALIDAD_SUR = "Localidad Sur";
    
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazTaquilla principal;
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------
    
    /**
     * Contenedora de etiquetas de texto para la localidad norte
     */
    private JLabel[] localidadNorte;
    
    /**
     * Contenedora de etiquetas de texto para la localidad sur
     */
    private JLabel[] localidadSur;
    
    /**
     * Contenedora de etiquetas de texto para la localidad occidental
     */
    private JLabel[] localidadOccidental;

    /**
     * Contenedora de etiquetas de texto para la localidad oriental
     */
    private JLabel[] localidadOriental;
    
    
    /**
     * Campo de texto para el porcentaje de asistencia del partido
     */
    private JTextField txtPorcentajeAsistencia;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    
    /**
     * Construye el panel del estadio. <br>
     * <b>post: </b> Construyó el panel
     */
    public PanelEstadio( InterfazTaquilla ventana )
    {
        principal = ventana;
        localidadNorte = new JLabel[ 50 ];
        localidadSur = new JLabel[ 50 ];
        localidadOccidental = new JLabel[ 100 ];
        localidadOriental = new JLabel[ 100 ];
        
        setLayout( new BorderLayout( ) );
        
        JPanel panelAux = new JPanel( );
        panelAux.setLayout( new BorderLayout( ) );
        
        JPanel panelNorte = new JPanel( );
        panelNorte.setLayout( new GridLayout( 10, 5 ) );
        
        for( int i = 0; i < localidadNorte.length; i++ )
        {
            localidadNorte[ i ] = new JLabel( " " + i + " " );
            localidadNorte[ i ].setHorizontalAlignment( 0 ); 
            localidadNorte[ i ].setBorder( new LineBorder( Color.BLACK ) );
            localidadNorte[ i ].setBackground( new Color( 86, 146, 211 ) );
            localidadNorte[ i ].setOpaque( true );
            localidadNorte[ i ].addMouseListener( this );
            localidadNorte[ i ].setName( LOCALIDAD_NORTE );
            panelNorte.add( localidadNorte[ i ] );
        }
        
        JPanel panelSur = new JPanel( );
        panelSur.setLayout( new GridLayout( 10, 5 ) );
        
        for( int i = 0; i < localidadSur.length; i++ )
        {
            localidadSur[ i ] = new JLabel( " " + i + " " );
            localidadSur[ i ].setHorizontalAlignment( 0 ); 
            localidadSur[ i ].setBorder( new LineBorder( Color.BLACK ) );
            localidadSur[ i ].setBackground( new Color( 203, 166, 52 ) );
            localidadSur[ i ].setOpaque( true );
            localidadSur[ i ].addMouseListener( this );
            localidadSur[ i ].setName( LOCALIDAD_SUR );
            panelSur.add( localidadSur[ i ] );
        }
        
        JPanel panelOccidental = new JPanel( );
        panelOccidental.setLayout( new GridLayout( 5, 20 ) );
        
        for( int i = 0; i < localidadOccidental.length; i++ )
        {
            localidadOccidental[ i ] = new JLabel( "" + i );
            localidadOccidental[ i ].setHorizontalAlignment( 0 ); 
            localidadOccidental[ i ].setBorder( new LineBorder( Color.BLACK ) );
            localidadOccidental[ i ].setBackground( new Color( 41, 214, 149 ) );
            localidadOccidental[ i ].setOpaque( true );
            localidadOccidental[ i ].addMouseListener( this );
            localidadOccidental[ i ].setName( LOCALIDAD_OCCIDENTAL );
            panelOccidental.add( localidadOccidental[ i ] );
        }
        
        JPanel panelOriental = new JPanel( );
        panelOriental.setLayout( new GridLayout( 5, 20 ) );
        
        for( int i = 0; i < localidadOriental.length; i++ )
        {
            localidadOriental[ i ] = new JLabel( "" + i );
            localidadOriental[ i ].setHorizontalAlignment( 0 ); 
            localidadOriental[ i ].setBorder( new LineBorder( Color.BLACK ) );
            localidadOriental[ i ].setOpaque( true );
            localidadOriental[ i ].setBackground( new Color( 255, 249, 119 ) );
            localidadOriental[ i ].addMouseListener( this );
            localidadOriental[ i ].setName( LOCALIDAD_ORIENTAL );
            panelOriental.add( localidadOriental[ i ] );
        }
        
        JLabel labEstadio = new JLabel( new ImageIcon( "./data/imagenes/estadio.png" ) );
        labEstadio.setForeground( Color.WHITE );
        
        panelAux.add( panelOriental, BorderLayout.NORTH );
        panelAux.add( panelOccidental, BorderLayout.SOUTH );
        panelAux.add( panelNorte, BorderLayout.WEST );
        panelAux.add( panelSur, BorderLayout.EAST );
        panelAux.add( labEstadio, BorderLayout.CENTER );
        
        add( panelAux, BorderLayout.CENTER );
        
        JPanel panelDatos = new JPanel( );
        panelDatos.setLayout( new GridLayout( 2, 2, 1, 1 ) );
        panelDatos.add( new JLabel( ) );
        panelDatos.add( new JLabel( ) );
        
        JLabel labPorcentajeAsistencia = new JLabel( "Porcentaje de Asistencia:" );
        panelDatos.add( labPorcentajeAsistencia );
        
        txtPorcentajeAsistencia = new JTextField( );
        txtPorcentajeAsistencia.setEditable( false );
        panelDatos.add( txtPorcentajeAsistencia );
        
        add( panelAux, BorderLayout.CENTER );
        add( panelDatos, BorderLayout.SOUTH );
    }
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Actualiza el estadio con el partido que llega por parámetro.
     * @param pPartido El partido que se va a mostrar.
     */
    public void actualizarEstadio( Partido pPartido )
    {
        Silla[] sillasLocalidadNorte = pPartido.darLocalidadNorte( );
        Silla[] sillasLocalidadSur = pPartido.darLocalidadSur( );
        Silla[] sillasLocalidadOccidental = pPartido.darLocalidadOccidental( );
        Silla[] sillasLocalidadOriental = pPartido.darLocalidadOriental( );
        
        for( int i = 0; i < sillasLocalidadNorte.length; i++ )
        {
            Silla sillaActual = sillasLocalidadNorte[ i ];
            
            if( sillaActual.estaAsignada( ) )
            {
                localidadNorte[ i ].setBackground( Color.RED );
            }
            else
            {
                localidadNorte[ i ].setBackground( new Color( 86, 146, 211 ) );
            }
        }
        
        for( int i = 0; i < sillasLocalidadSur.length; i++ )
        {
            Silla sillaActual = sillasLocalidadSur[ i ];
            
            if( sillaActual.estaAsignada( ) )
            {
                localidadSur[ i ].setBackground( Color.RED );
            }
            else
            {
                localidadSur[ i ].setBackground( new Color( 203, 166, 52 ) );
            }
        }
        
        for( int i = 0; i < sillasLocalidadOccidental.length; i++ )
        {
            Silla sillaActual = sillasLocalidadOccidental[ i ];
            
            if( sillaActual.estaAsignada( ) )
            {
                localidadOccidental[ i ].setBackground( Color.RED );
            }
            else
            {
                localidadOccidental[ i ].setBackground( new Color( 41, 214, 149 ) );
            }
        }
        
        for( int i = 0; i < sillasLocalidadOriental.length; i++ )
        {
            Silla sillaActual = sillasLocalidadOriental[ i ];
            
            if( sillaActual.estaAsignada( ) )
            {
                localidadOriental[ i ].setBackground( Color.RED );
            }
            else
            {
                localidadOriental[ i ].setBackground( new Color( 255, 249, 119 ) );
            }
        }
        DecimalFormat df = new DecimalFormat( "###,###.#" );
        
        df = new DecimalFormat( "#.###" );
        String strPorcentajeAsistencia = df.format(pPartido.darPorcentajeDeAsistencia( ) );
        txtPorcentajeAsistencia.setText( strPorcentajeAsistencia + "%" );
    }

    @Override
    public void mouseClicked( MouseEvent e )
    {
        Component componente =e.getComponent( );
        JLabel sillaActual = (JLabel)componente;
        principal.abrirDialogoSilla( sillaActual.getText( ), sillaActual.getName( ) );
    }

    @Override
    public void mouseEntered( MouseEvent e )
    { }

    @Override
    public void mouseExited( MouseEvent e )
    { }

    @Override
    public void mousePressed( MouseEvent e )
    { }

    @Override
    public void mouseReleased( MouseEvent e )
    { }

}
