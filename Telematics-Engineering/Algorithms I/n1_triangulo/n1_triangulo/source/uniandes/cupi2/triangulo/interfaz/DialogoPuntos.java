/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_triangulo
 * Autor: Pablo Barvo - Oct 21, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.triangulo.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uniandes.cupi2.triangulo.mundo.Triangulo;

/**
 * Diálogo de cambio de puntos
 */
public class DialogoPuntos extends JDialog implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String ACEPTAR = "ACEPTAR";

    private static final String CANCELAR = "CANCELAR";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Triángulo
     */
    private Triangulo triangulo;

    /**
     * Ventana principal
     */
    private InterfazTriangulo padre;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Valor X del punto 1
     */
    private JTextField txtPunto1x;

    /**
     * Valor Y del punto 1
     */
    private JTextField txtPunto1y;

    /**
     * Valor X del punto 1
     */
    private JTextField txtPunto2x;

    /**
     * Valor Y del punto 2
     */
    private JTextField txtPunto2y;

    /**
     * Valor X del punto 3
     */
    private JTextField txtPunto3x;

    /**
     * Valor Y del punto 3
     */
    private JTextField txtPunto3y;

    /**
     * Botón aceptar
     */
    private JButton btnAceptar;

    /**
     * Botón cancelar
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo
     * @param elPadre Ventana principal
     */
    public DialogoPuntos( InterfazTriangulo elPadre )
    {
        padre = elPadre;
        triangulo = elPadre.darTriangulo( );
        setLayout( new GridLayout( 6, 3 ) );
        setTitle( "Modificar Puntos" );
        setDefaultCloseOperation( JDialog.DO_NOTHING_ON_CLOSE );

        add( new JLabel( "Punto" ) );
        add( new JLabel( "Valor X" ) );
        add( new JLabel( "Valor Y" ) );

        //Punto 1
        add( new JLabel( "Punto 1:" ) );
        txtPunto1x = new JTextField( Double.toString( triangulo.darPunto1( ).darX( ) ) );
        add( txtPunto1x );
        txtPunto1y = new JTextField( Double.toString( triangulo.darPunto1( ).darY( ) ) );
        add( txtPunto1y );

        //Punto 2
        add( new JLabel( "Punto 2:" ) );
        txtPunto2x = new JTextField( Double.toString( triangulo.darPunto2( ).darX( ) ) );
        add( txtPunto2x );
        txtPunto2y = new JTextField( Double.toString( triangulo.darPunto2( ).darY( ) ) );
        add( txtPunto2y );

        //Punto 3
        add( new JLabel( "Punto 3:" ) );
        txtPunto3x = new JTextField( Double.toString( triangulo.darPunto3( ).darX( ) ) );
        add( txtPunto3x );
        txtPunto3y = new JTextField( Double.toString( triangulo.darPunto3( ).darY( ) ) );
        add( txtPunto3y );

        //Espacio
        add( new JLabel( ) );
        add( new JLabel( ) );
        add( new JLabel( ) );
        add( new JLabel( ) );

        //Botones
        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        add( btnAceptar );

        //Botones
        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        add( btnCancelar );

        pack( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Evento del Mouse
     * @param e Acción que generó el evento
     */
    public void actionPerformed( ActionEvent e )
    {
        try
        {
            if( ACEPTAR.equals( e.getActionCommand( ) ) )
            {
                //Lee los valores
                double p1x = Double.parseDouble( txtPunto1x.getText( ) );
                double p1y = Double.parseDouble( txtPunto1y.getText( ) );
                double p2x = Double.parseDouble( txtPunto2x.getText( ) );
                double p2y = Double.parseDouble( txtPunto2y.getText( ) );
                double p3x = Double.parseDouble( txtPunto3x.getText( ) );
                double p3y = Double.parseDouble( txtPunto3y.getText( ) );

                //Valida que no sean colineales
                if( padre.colineales( p1x, p1y, p2x, p2y, p3x, p3y ) )
                {
                    JOptionPane.showMessageDialog( this, "Los puntos no pueden ser colineales.", "Error", JOptionPane.ERROR_MESSAGE );
                }
                else
                {
                    //Cambia los puntos
                    triangulo.darPunto1( ).cambiarX( p1x );
                    triangulo.darPunto1( ).cambiarY( p1y );
                    triangulo.darPunto2( ).cambiarX( p2x );
                    triangulo.darPunto2( ).cambiarY( p2y );
                    triangulo.darPunto3( ).cambiarX( p3x );
                    triangulo.darPunto3( ).cambiarY( p3y );
                    padre.setEnabled( true );
                    padre.repintar( );
                    setVisible( false );
                }
            }
            else
            {
                padre.setEnabled( true );
                padre.repintar( );
                setVisible( false );
            }
        }
        catch( NumberFormatException e2 )
        {
            JOptionPane.showMessageDialog( this, "Debe ingresar sólo números.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

}
