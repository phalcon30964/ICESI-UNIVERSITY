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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import uniandes.cupi2.taquilla.mundo.Taquilla;

/**
 * Diálogo para vender una silla
 */
public class DialogoVenderSilla extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para aceptar
     */
    private final static String ACEPTAR = "Aceptar";

    /**
     * Comando para cancelar
     */
    private final static String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazTaquilla principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Combo con las localidades
     */
    private JComboBox comboLocalidad;

    /**
     * Campo de texto para el número de la silla
     */
    private JTextField txtNumSilla;

    /**
     * Campo de texto para el nombre del comprador
     */
    private JTextField txtNombre;

    /**
     * Campo de texto para la cédula del comprador
     */
    private JTextField txtCedula;

    /**
     * Botón para aceptar
     */
    private JButton butAceptar;

    /**
     * Botón para cancelar
     */
    private JButton butCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo para vender una silla con una referencia a la ventana principal de la aplicación. <br>
     * <b>post: </b> Construyó el panel e principal == ventana.<br>
     * @param ventana Referencia a la ventana principal. ventana != null.
     */
    public DialogoVenderSilla( InterfazTaquilla ventana )
    {
        principal = ventana;

        setLayout( new GridLayout( 5, 2, 5, 5 ) );
        setTitle( "Vender Silla" );
        setSize( 600, 200 );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setModal( true );
        setLocationRelativeTo( ventana );

        JLabel labLocalidad = new JLabel( "Localidad:" );
        add( labLocalidad );

        comboLocalidad = new JComboBox( );
        comboLocalidad.addItem( Taquilla.LOCALIDAD_NORTE );
        comboLocalidad.addItem( Taquilla.LOCALIDAD_SUR );
        comboLocalidad.addItem( Taquilla.LOCALIDAD_OCCIDENTAL );
        comboLocalidad.addItem( Taquilla.LOCALIDAD_ORIENTAL );
        add( comboLocalidad );

        JLabel labNumSilla = new JLabel( "Número Silla:" );
        add( labNumSilla );

        txtNumSilla = new JTextField( );
        add( txtNumSilla );

        JLabel labNombre = new JLabel( "Nombre:" );
        add( labNombre );

        txtNombre = new JTextField( );
        add( txtNombre );

        JLabel labCedula = new JLabel( "Cédula:" );
        add( labCedula );

        txtCedula = new JTextField( );
        add( txtCedula );

        butAceptar = new JButton( ACEPTAR );
        butAceptar.setActionCommand( ACEPTAR );
        butAceptar.addActionListener( this );
        add( butAceptar );

        butCancelar = new JButton( CANCELAR );
        butCancelar.setActionCommand( CANCELAR );
        butCancelar.addActionListener( this );
        add( butCancelar );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            try
            {
                String localidad = ( String )comboLocalidad.getSelectedItem( );
                int numSilla = Integer.parseInt( txtNumSilla.getText( ) );
                String nombre = txtNombre.getText( ).trim( );
                String cedula = txtCedula.getText( ).trim( );
    
                if( !nombre.equals( "" ) && !cedula.equals( "" ) )
                {
                    principal.venderSilla( numSilla, localidad, nombre, cedula );
                    dispose( );
                }
                else
                {
                    JOptionPane.showMessageDialog( principal, "Debe especificar todos los datos", "Información", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            catch( Exception f )
            {
                JOptionPane.showMessageDialog( principal, "El número de la silla debe ser un valor numérico", "Error", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }
}