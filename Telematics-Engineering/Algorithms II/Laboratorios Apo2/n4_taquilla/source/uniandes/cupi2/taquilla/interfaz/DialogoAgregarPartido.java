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
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.cupi2.taquilla.mundo.Partido;

/**
 * Diálogo para agregar un partido
 */
public class DialogoAgregarPartido extends JDialog implements ActionListener
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
     * Campo de texto para el nombre del rival
     */
    private JTextField txtRival;

    /**
     * Combo box con los diferentes torneos
     */
    private JComboBox comboTorneo;

    /**
     * Combo box con los días del mes
     */
    private JComboBox comboDia;

    /**
     * Combo box con los meses del año
     */
    private JComboBox comboMes;

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
     * Construye el diálogo para agregar un partido con una referencia a la ventana principal de la aplicación. <br>
     * <b>post: </b> Construyó el panel e principal == ventana.<br>
     * @param ventana Referencia a la ventana principal. ventana != null.
     */
    public DialogoAgregarPartido( InterfazTaquilla ventana )
    {
        principal = ventana;

        setLayout( new GridLayout( 4, 2, 5, 5 ) );
        setTitle( "Agregar Partido" );
        setSize( 400, 150 );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setModal( true );
        setLocationRelativeTo( ventana );

        JLabel labTorneo = new JLabel( "Torneo:" );
        add( labTorneo );

        comboTorneo = new JComboBox( );
        comboTorneo.addItem( Partido.TORNEO_COPA );
        comboTorneo.addItem( Partido.TORNEO_LIGA );
        comboTorneo.addItem( Partido.TORNEO_SUPER_LIGA );
        add( comboTorneo );

        JLabel labRival = new JLabel( "Rival:" );
        add( labRival );

        txtRival = new JTextField( );
        add( txtRival );

        JLabel labFecha = new JLabel( "Fecha:" );
        add( labFecha );

        JPanel panelAux = new JPanel( );
        panelAux.setLayout( new GridLayout( 1, 2, 5, 5 ) );

        comboDia = new JComboBox( );
        for( int i = 1; i <= 31; i++ )
        {
            comboDia.addItem( i );
        }
        panelAux.add( comboDia );

        comboMes = new JComboBox( );
        comboMes.addItem( "Enero" );
        comboMes.addItem( "Febrero" );
        comboMes.addItem( "Marzo" );
        comboMes.addItem( "Abril" );
        comboMes.addItem( "Mayo" );
        comboMes.addItem( "Junio" );
        comboMes.addItem( "Julio" );
        comboMes.addItem( "Agosto" );
        comboMes.addItem( "Septiembre" );
        comboMes.addItem( "Octubre" );
        comboMes.addItem( "Noviembre" );
        comboMes.addItem( "Diciembre" );
        panelAux.add( comboMes );

        add( panelAux );

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

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            String torneo = ( String )comboTorneo.getSelectedItem( );
            String rival = txtRival.getText( ).trim( );
            int dia = ( Integer )comboDia.getSelectedItem( );
            String mes = ( String )comboMes.getSelectedItem( );

            if( !rival.equals( "" ) )
            {
                principal.agregarPartido( rival, torneo, dia + " " + mes );
                dispose( );
            }
            else
            {
                JOptionPane.showMessageDialog( principal, "Debe especificar el nombre del rival", "Información", JOptionPane.INFORMATION_MESSAGE );
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }
}