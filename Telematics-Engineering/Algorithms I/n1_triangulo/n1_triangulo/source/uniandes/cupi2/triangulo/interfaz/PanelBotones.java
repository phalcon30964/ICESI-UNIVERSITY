/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_triangulo
 * Autor: Pablo Barvo - Oct 20, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.triangulo.interfaz;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel Modificaciones al Triángulo
 */
public class PanelBotones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String PUNTOS = "PUNTOS";

    private static final String COLOR_FONDO = "COLOR_FONDO";

    private static final String COLOR_LINEAS = "COLOR_LINEAS";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal
     */
    private InterfazTriangulo padre;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón Cambio de puntos
     */
    private JButton btnPuntos;

    /**
     * Botón Cambio color línea
     */
    private JButton btnColorLinea;

    /**
     * Botón Cambio color fondo
     */
    private JButton btnColorFondo;

    /**
     * Etiqueta con el Área
     */
    private JLabel etiquetaArea;

    /**
     * Etiqueta con la Altura del triángulo
     */
    private JLabel etiquetaAltura;

    /**
     * Etiqueta con el Perímetro
     */
    private JLabel etiquetaPerimetro;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param elPadre Ventana principal
     */
    public PanelBotones( InterfazTriangulo elPadre )
    {
        padre = elPadre;
        setLayout( new GridBagLayout( ) );

        //Panel Modificaciones
        JPanel panelModificaciones = new JPanel( new GridLayout( 3, 1 ) );
        panelModificaciones.setBorder( new TitledBorder( "Modificaciones" ) );

        btnPuntos = new JButton( "Cambiar Puntos" );
        btnPuntos.setActionCommand( PUNTOS );
        btnPuntos.addActionListener( this );
        panelModificaciones.add( btnPuntos );

        btnColorLinea = new JButton( "Cambiar Líneas" );
        btnColorLinea.setActionCommand( COLOR_LINEAS );
        btnColorLinea.addActionListener( this );
        panelModificaciones.add( btnColorLinea );

        btnColorFondo = new JButton( "Cambiar Fondo" );
        btnColorFondo.setActionCommand( COLOR_FONDO );
        btnColorFondo.addActionListener( this );
        panelModificaciones.add( btnColorFondo );

        GridBagConstraints posicion = new GridBagConstraints( 0, 0, 1, 3, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets( 3, 3, 3, 3 ), 0, 0 );
        add( panelModificaciones, posicion );

        //Panel Datos
        JPanel panelInformacion = new JPanel( new GridLayout( 3, 1 ) );
        panelInformacion.setBorder( new TitledBorder( "Información" ) );
        panelInformacion.setPreferredSize( new Dimension( 170, 100 ) );

        etiquetaPerimetro = new JLabel( "Perímetro" );
        etiquetaPerimetro.setFont( etiquetaPerimetro.getFont( ).deriveFont( Font.PLAIN ) );
        panelInformacion.add( etiquetaPerimetro );

        etiquetaArea = new JLabel( "Área" );
        etiquetaArea.setFont( etiquetaArea.getFont( ).deriveFont( Font.PLAIN ) );
        panelInformacion.add( etiquetaArea );

        etiquetaAltura = new JLabel( "Altura" );
        etiquetaAltura.setFont( etiquetaAltura.getFont( ).deriveFont( Font.PLAIN ) );
        panelInformacion.add( etiquetaAltura );

        posicion = new GridBagConstraints( 0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets( 3, 3, 3, 3 ), 0, 0 );
        add( panelInformacion, posicion );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cambia la información del triángulo
     * @param perimetro Nuevo perímetro
     * @param area Nueva área.
     * @param altura nueva altura.
     */
    public void cambiarInformacion( double perimetro, double area, double altura )
    {
        etiquetaArea.setText( "Área: " + formatearValor( area ) + " px" );
        etiquetaPerimetro.setText( "Perímetro: " + formatearValor( perimetro ) + " px" );
        etiquetaAltura.setText( "Altura: " + formatearValor( altura ) + " px" );
    }

    /**
     * Manejo de eventos del mouse
     * @param e Acción que generó el evento
     */
    public void actionPerformed( ActionEvent e )
    {
        if( PUNTOS.equals( e.getActionCommand( ) ) )
        {
            padre.cambiarPuntos( );
        }
        else if( COLOR_FONDO.equals( e.getActionCommand( ) ) )
        {
            padre.cambiarColorFondo( );
        }
        else if( COLOR_LINEAS.equals( e.getActionCommand( ) ) )
        {
            padre.cambiarColorLineas( );
        }
    }

    /**
     * Formatea un valor numérico para presentar en la interfaz <br>
     * @param valor - El valor numérico a ser formateado
     * @return Retorna un string con el valor formateado con puntos y signos.
     */
    private String formatearValor( double valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

}
