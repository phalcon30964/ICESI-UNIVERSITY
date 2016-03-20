/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazOrganigrama.java,v 1.16 2009/04/17 15:27:46 ju-cort1 Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Todos los derechos reservados 2005
 *
 * Proyecto Cupi2
 * Ejercicio: n11_organigrama
 * Autor: Mario Sánchez - 21-nov-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.organigrama.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uniandes.cupi2.organigrama.mundo.Cargo;
import uniandes.cupi2.organigrama.mundo.Empresa;
import uniandes.cupi2.organigrama.mundo.OrganigramaException;

/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazOrganigrama extends JFrame
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String ARCHIVO_EMPRESA = "./data/empresa.dat";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private Empresa empresa;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /*
     * Es el panel donde se muestra la representación gráfica del organigrama
     */
    private PanelGraficoOrganigrama panelGrafico;

    /**
     * Es el panel donde se muestran los botones para controlar la aplicación
     */
    private PanelBotones panelBotones;

    /**
     * Es el panel donde se muestran los datos del empleado seleccionado
     */
    private PanelDatos panelDatos;

    /**
     * Es el panel donde se muestran los botones para los puntos de extensión
     */
    private PanelExtension panelExtension;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Inicializa la aplicación y construye la ventana principal<br>
     * @param em La empresa de la que se va a manejar la información
     */
    public InterfazOrganigrama( Empresa em )
    {
        // Crea la clase principal
        empresa = em;

        // Construye la forma
        construirForma( );
        centrar( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Centra la ventana en la pantalla
     */
    private void centrar( )
    {
        Dimension screen = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int xEsquina = ( screen.width - getWidth( ) ) / 2;
        int yEsquina = ( screen.height - getHeight( ) ) / 2;
        setLocation( xEsquina, yEsquina );
    }

    /**
     * Este método sirve para construir la forma inicializando cada uno de los componentes. <br>
     * <b>pre: </b> La ventana está vacía <br>
     * <b>post: </b> Se inicializaron los componentes gráficos de la aplicación
     */
    private void construirForma( )
    {
        // Configurar el panel Principal
        getContentPane( ).setLayout( new BorderLayout( ) );
        setSize( 800, 613 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setTitle( "Organigrama" );

        // Inicializar los componentes de la interfaz
        panelGrafico = new PanelGraficoOrganigrama( empresa );
        JScrollPane scroll = new JScrollPane( panelGrafico );
        scroll.setPreferredSize( getPreferredSize( ) );
        getContentPane( ).add( scroll, BorderLayout.CENTER );

        JPanel panelContenedor = new JPanel( new BorderLayout( ) );
        panelBotones = new PanelBotones( this );
        panelContenedor.add( panelBotones, BorderLayout.CENTER );

        panelDatos = new PanelDatos( );
        panelContenedor.add( panelDatos, BorderLayout.NORTH );

        panelExtension = new PanelExtension( this );
        panelContenedor.add( panelExtension, BorderLayout.SOUTH );

        getContentPane( ).add( panelContenedor, BorderLayout.SOUTH );
    }

    /**
     * Este método se usa para eliminar un cargo de la empresa
     */
    public void eliminarCargo( )
    {
        String cargo = JOptionPane.showInputDialog( this, "Indique el nombre del cargo a ser eliminado", "Eliminación Cargos", JOptionPane.QUESTION_MESSAGE );
        if( cargo != null )
        {
            try
            {
                empresa.eliminarCargo( cargo );
                panelGrafico.seleccionar( null );
                panelGrafico.actualizarImagen( );
                panelDatos.limpiar( );
                guardar( );
            }
            catch( OrganigramaException e )
            {

                JOptionPane.showMessageDialog( this, e.getMessage( ), "Eliminación Cargos", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }

    /**
     * Este método se usa para realizar una búsqueda usando el código de un empleado
     */
    public void buscarEmpleado( )
    {
        String codigo = JOptionPane.showInputDialog( this, "Indique el código del empleado del que desea ver la información", "Código", JOptionPane.QUESTION_MESSAGE );
        if( codigo != null )
        {
            // Se busca el cargo asociado con el empleado
            Cargo buscado = empresa.buscarCargoEmpleado( codigo );
            if( buscado != null )
            {
                panelGrafico.seleccionar( buscado.darNombreCargo( ) );
                panelGrafico.actualizarImagen( );
                panelDatos.cambiarElemento( buscado );
            }
            else
            {
                panelGrafico.seleccionar( null );
                panelGrafico.actualizarImagen( );
                panelDatos.limpiar( );
                JOptionPane.showMessageDialog( this, "No se encontró ningún empleado con el código buscado", "Búsqueda Empleados", JOptionPane.INFORMATION_MESSAGE );
            }
        }
    }

    /**
     * Este método se usa para despedir un empleado de la organización
     */
    public void despedirEmpleado( )
    {
        String codigo = JOptionPane.showInputDialog( this, "Indique el código del empleado que desea despedir", "Código", JOptionPane.QUESTION_MESSAGE );
        if( codigo != null )
        {
            // Se busca el cargo asociado con el empleado
            try
            {
                empresa.despedirEmpleado( codigo );
                guardar( );
            }
            catch( OrganigramaException e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Despido Empleados", JOptionPane.INFORMATION_MESSAGE );
            }
            panelGrafico.seleccionar( null );
            panelGrafico.actualizarImagen( );
        }
    }

    /**
     * Este método se usa para crear un nuevo cargo en la empresa
     */
    public void crearCargo( )
    {
        String nombreCargo = JOptionPane.showInputDialog( this, "Indique el nombre del cargo", "Nombre Cargo", JOptionPane.QUESTION_MESSAGE );
        String salarioS = JOptionPane.showInputDialog( this, "Indique el salario", "Salario Cargo", JOptionPane.QUESTION_MESSAGE );
        String cargoDepende = JOptionPane.showInputDialog( this, "Indique el cargo del que depende", "Cargo del que Depende", JOptionPane.QUESTION_MESSAGE );

        try
        {

            int salario = Integer.parseInt( salarioS );

            if( nombreCargo == null || nombreCargo.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Ingrese el nombre del cargo", "Creación Cargos", JOptionPane.ERROR_MESSAGE );
            }
            else if( salario <= 0 )
            {
                JOptionPane.showMessageDialog( this, "El salario del cargo no es válido", "Creación Cargos", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                empresa.crearCargo( nombreCargo, salario, cargoDepende );
                panelGrafico.seleccionar( null );
                panelGrafico.actualizarImagen( );
                panelDatos.limpiar( );
                guardar( );
            }

        }
        catch( NumberFormatException e )
        {
            JOptionPane.showMessageDialog( this, "El salario del cargo no es válido", "Creación Cargos", JOptionPane.ERROR_MESSAGE );
        }
        catch( OrganigramaException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Creación Cargos", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Este método se usar para mostrar el diálogo que sirve para agregar un nuevo empleado.
     */
    public void mostrarVentanaContratar( )
    {
        DialogoContratarEmpleado d = new DialogoContratarEmpleado( this, empresa.darListaCargosDisponibles( ) );
        d.setVisible( true );
    }

    /**
     * Este método se usa para agregar un nuevo empleado a la organización.
     * @param dialogo Es el diálogo en el que se introdujeron los datos del nuevo empleado
     * @param codigo Código del empleado
     * @param cargo Es el cargo del nuevo empleado. No puede estar repetido.
     * @param nombre Es el nombre del nuevo empleado.
     * @param fechaIngreso Es la fecha de ingreso del nuevo empleado.
     */
    public void contratarEmpleado( DialogoContratarEmpleado dialogo, String codigo, String cargo, String nombre, Date fechaIngreso )
    {

        try
        {
            if( cargo == null )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar el cargo del empleado", "Error", JOptionPane.ERROR_MESSAGE );
            }
            if( codigo == null || codigo.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar el código del empleado", "Error", JOptionPane.ERROR_MESSAGE );
            }
            else if( nombre == null || nombre.equals( "" ) )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar el nombre del empleado", "Error", JOptionPane.ERROR_MESSAGE );
            }
            else if( fechaIngreso == null )
            {
                JOptionPane.showMessageDialog( this, "Debe ingresar la fecha de ingreso del empleado", "Error", JOptionPane.ERROR_MESSAGE );
            }
            else
            {
                empresa.contratarPersona( codigo, nombre, fechaIngreso, cargo );
                dialogo.dispose( );
                panelGrafico.seleccionar( null );
                panelGrafico.actualizarImagen( );
                guardar( );
            }
        }
        catch( OrganigramaException e )
        {
            JOptionPane.showMessageDialog( this, "No se pudo agregar el empleado: \n" + e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }

    }

    /**
     * Guarda el estado actual en el que se encuentra la empresa
     */
    private void guardar( )
    {
        try
        {
            empresa.guardar( );
        }
        catch( OrganigramaException e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Este método se encarga de salvar la información de la empresa, justo antes de cerrar la aplicación
     */
    public void dispose( )
    {
        guardar( );
        super.dispose( );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = empresa.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = empresa.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 3
     */
    public void reqFuncOpcion3( )
    {
        String resultado = empresa.metodo3( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 4
     */
    public void reqFuncOpcion4( )
    {
        String resultado = empresa.metodo4( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 5
     */
    public void reqFuncOpcion5( )
    {
        String resultado = empresa.metodo5( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 6
     */
    public void reqFuncOpcion6( )
    {
        String resultado = empresa.metodo6( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }
    
    /**
     * Método para la extensión 7
     */
    public void reqFuncOpcion7( )
    {
        String resultado = empresa.metodo7( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }
    
    /**
     * Método para la extensión 8
     */
    public void reqFuncOpcion8( )
    {
        String resultado = empresa.metodo8( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Argumentos para la ejecución de la aplicación. En este caso no son necesarios
     */
    public static void main( String[] args )
    {
        Empresa empresa = null;
        try
        {
            empresa = new Empresa( ARCHIVO_EMPRESA );
        }
        catch( OrganigramaException e )
        {
            e.printStackTrace( );
            System.exit( 1 );
        }
        InterfazOrganigrama interfaz = new InterfazOrganigrama( empresa );
        interfaz.setVisible( true );
    }

}