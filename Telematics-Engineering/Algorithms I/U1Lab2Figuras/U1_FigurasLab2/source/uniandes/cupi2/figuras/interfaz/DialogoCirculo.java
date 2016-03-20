/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: U1_Figuras
 * Autor inicial: Juan M. Reyes - Ene 25, 2013
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.figuras.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uniandes.cupi2.figuras.mundo.Circulo;

/**
 * Diálogo de cambio de puntos
 */
public class DialogoCirculo extends JDialog implements ActionListener
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
    private Circulo circulo;

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
    public DialogoCirculo( InterfazTriangulo elPadre )
    {
        padre = elPadre;
        circulo = elPadre.darCirculo( );
        setLayout( new GridLayout( 0, 3 ) );
        setTitle( "Modificar Punto y Dimensiones" );
        setDefaultCloseOperation( JDialog.DO_NOTHING_ON_CLOSE );

        //add( new JLabel( "Punto" ) );
        //add( new JLabel( "Valor X" ) );
        //add( new JLabel( "Valor Y" ) );

        //Punto Único
        add( new JLabel( "Centro:" ) );
        txtPunto1x = new JTextField( Double.toString( circulo.darCentro( ).darX( ) ) );
        add( txtPunto1x );
        txtPunto1y = new JTextField( Double.toString( circulo.darCentro( ).darY( ) ) );
        add( txtPunto1y );

        //Ancho
        add( new JLabel( "Radio:" ) );
        txtPunto2x = new JTextField( Double.toString( circulo.darRadio( ) ) );
        add( txtPunto2x );
        add( new JLabel("px") );

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

                //Cambia los puntos
                circulo.darCentro( ).cambiarX( p1x );
                circulo.darCentro( ).cambiarY( p1y );
                circulo.cambiarRadio(p2x );
                padre.setEnabled( true );
                padre.repintar( );
                setVisible( false );
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
