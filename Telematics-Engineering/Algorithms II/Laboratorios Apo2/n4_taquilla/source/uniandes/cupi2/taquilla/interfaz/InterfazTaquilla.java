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

import java.awt.BorderLayout;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import uniandes.cupi2.taquilla.mundo.Partido;
import uniandes.cupi2.taquilla.mundo.Persona;
import uniandes.cupi2.taquilla.mundo.Silla;
import uniandes.cupi2.taquilla.mundo.Taquilla;

/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazTaquilla extends JFrame
{
    
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private Taquilla taquilla;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la imagen del encabezado
     */
    private PanelImagen panelImagen;

    /**
     * Panel del partido
     */
    private PanelPartido panelPartido;

    /**
     * Panel del estadio
     */
    private PanelEstadio panelEstadio;

    /**
     * Panel de acciones
     */
    private PanelAcciones panelAcciones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Descripción <br>
     * <b>post: </b> Descripción
     */
    public InterfazTaquilla( )
    {
        String nombreEquipo = "Cupi2 F.C";
        taquilla = new Taquilla( nombreEquipo );

        setTitle( "Taquilla - " + nombreEquipo );
        setLayout( new BorderLayout( ) );
        setSize( 777, 639 );
        setResizable( false );
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setLocationRelativeTo( null );

        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );

        panelPartido = new PanelPartido( this );
        add( panelPartido, BorderLayout.WEST );

        panelAcciones = new PanelAcciones( this );
        add( panelAcciones, BorderLayout.SOUTH );

        panelEstadio = new PanelEstadio( this );
        add( panelEstadio, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Abre el diálogo para agregar un partido
     */
    public void abrirDialogoAgregarPartido( )
    {
        DialogoAgregarPartido dialogoAgregarPartido = new DialogoAgregarPartido( this );
        dialogoAgregarPartido.setVisible( true );
    }

    /**
     * Método encargado de agregar un partido <br>
     * @param pRival Rival contra el que se juega - pRival != "" && pRival != null
     * @param pTorneo Nombre del torneo en el que se jugara el partido - pTorneo != null && ( pTorneo == Partido.TORNEO_LIGA || pTorneo == Partido.TORNEO_COPA || pTorneo == Partido.TORNEO_SUPER_LIGA )<br>
     * @param pFechaPartido Fecha en la que se jugara el partido - pFechaPartido != "" && pFechaPartido != null
     */
    public void agregarPartido( String pRival, String pTorneo, String pFechaPartido )
    {
        try
        {
            taquilla.agregarPartido( pRival, pTorneo, pFechaPartido );
            actualizarListaPartidos( );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Atención", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Abre el diálogo para vender una silla
     */
    public void abrirDialogoVenderSilla( )
    {
        Partido partidoActual = panelPartido.darPartidoActual( );

        if( partidoActual != null )
        {
            DialogoVenderSilla dialogoVenderSilla = new DialogoVenderSilla( this );
            dialogoVenderSilla.setVisible( true );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un partido", "Información", JOptionPane.WARNING_MESSAGE );
        }
    }
    
    /**
     * Abre el diálogo para datos de una silla
     * @param silla - Numero de la silla buscada
     * @param localidad - localidad de la silla
     */
    public void abrirDialogoSilla( String silla, String localidad )
    {
        Partido partidoActual = panelPartido.darPartidoActual( );
        Silla sillaActual = null;
       
        if( localidad.equals( PanelEstadio.LOCALIDAD_NORTE ) )
        {
            silla = silla.trim( );
            int numsilla = Integer.parseInt( silla );
            if( partidoActual != null )
            {
                sillaActual = partidoActual.darLocalidadNorte( )[ numsilla ];
                Persona comprador = sillaActual.darComprador( );
                if( comprador != null )
                {
                    JOptionPane.showMessageDialog( this, sillaActual.darLocalidad( ) + "\n Silla Numero: " + sillaActual.darNumero( ) + "\n Compador: " + sillaActual.darComprador( ).darNombre( )+ "\n Cedula: " + sillaActual.darComprador( ).darCedula( ), "Información", JOptionPane.WARNING_MESSAGE );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Silla no vendida", "Información", JOptionPane.WARNING_MESSAGE );

                }
            }
        }
        else
        if( localidad.equals( PanelEstadio.LOCALIDAD_OCCIDENTAL ) )
        {
            silla = silla.trim( );
            int numsilla = Integer.parseInt( silla );
            if( partidoActual != null )
            {
                sillaActual = partidoActual.darLocalidadOccidental( )[ numsilla ];
                Persona comprador = sillaActual.darComprador( );
                if( comprador != null )
                {
                    JOptionPane.showMessageDialog( this, sillaActual.darLocalidad( ) + "\n Silla Numero:" + sillaActual.darNumero( ) + "\n Compador:" + sillaActual.darComprador( ).darNombre( ), "Información", JOptionPane.WARNING_MESSAGE );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Silla no vendida", "Información", JOptionPane.WARNING_MESSAGE );

                }
            }
        }
        else
        if( localidad.equals( PanelEstadio.LOCALIDAD_ORIENTAL ) )
        {
            silla = silla.trim( );
            int numsilla = Integer.parseInt( silla );
            if( partidoActual != null )
            {
                sillaActual = partidoActual.darLocalidadOriental( )[ numsilla ];
                Persona comprador = sillaActual.darComprador( );
                if( comprador != null )
                {
                    JOptionPane.showMessageDialog( this, sillaActual.darLocalidad( ) + "\n Silla Numero:" + sillaActual.darNumero( ) + "\n Compador:" + sillaActual.darComprador( ).darNombre( ), "Información", JOptionPane.WARNING_MESSAGE );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Silla no vendida", "Información", JOptionPane.WARNING_MESSAGE );

                }
            }
        }
        else
            if( localidad.equals( PanelEstadio.LOCALIDAD_SUR ) )
            {
                silla = silla.trim( );
                int numsilla = Integer.parseInt( silla );
                if( partidoActual != null )
                {
                    sillaActual = partidoActual.darLocalidadSur( )[ numsilla ];
                    Persona comprador = sillaActual.darComprador( );
                    if( comprador != null )
                    {
                        JOptionPane.showMessageDialog( this, sillaActual.darLocalidad( ) + "\n Silla Numero:" + sillaActual.darNumero( ) + "\n Compador:" + sillaActual.darComprador( ).darNombre( ), "Información", JOptionPane.WARNING_MESSAGE );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "Silla no vendida", "Información", JOptionPane.WARNING_MESSAGE );

                    }
                }
            }
    }

    /**
     * Método encargado de vender una silla teniendo en cuenta una localidad, el numero de silla que llega por parámetro y la información de un partido<br>
     * Si el comprador es socio del equipo, se le vende la silla con descuento de socio. <br>
     * @param pNumeroSilla Numero de la silla que se quiere vender - pNumeroSilla >= 0
     * @param pLocalidad Localidad de la silla que se quiere vender - pLocalidad != "" && pLocalidad != null
     * @param pNombreComprador Nombre del comprador de la silla - pNombreComprador != "" && pNombreComprador != null
     * @param pCedulaComprador Cédula del comprador de la silla - pCedulaComprador != "" && pCedulaComprador != null
     */
    public void venderSilla( int pNumeroSilla, String pLocalidad, String pNombreComprador, String pCedulaComprador )
    {
        try
        {
            double costoVenta = 0;
            Partido partidoActual = panelPartido.darPartidoActual( );
            costoVenta = taquilla.venderSilla( pNumeroSilla, pLocalidad, pNombreComprador, pCedulaComprador, partidoActual.darRival( ), partidoActual.darTorneo( ), partidoActual.darFechaPartido( ) );
            DecimalFormat df = new DecimalFormat( "###,###.#" );
            String strCosto = df.format( costoVenta );
            JOptionPane.showMessageDialog( this, "Silla numero " + pNumeroSilla + " vendida exitósamente.\n" + pLocalidad +".\nCosto: $" + strCosto , "Información", JOptionPane.INFORMATION_MESSAGE );
            actualizarEstadio( partidoActual );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Atención", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Abre el diálogo para vender una silla automáticamente
     */
    public void abrirDialogoVenderSillaAutomaticamente( )
    {
        Partido partidoActual = panelPartido.darPartidoActual( );

        if( partidoActual != null )
        {
            DialogoVenderSillaAutomaticamente dialogoVenderSillaAutomaticamente = new DialogoVenderSillaAutomaticamente( this );
            dialogoVenderSillaAutomaticamente.setVisible( true );
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un partido", "Información", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Método encargado de vender la primera silla que se encuentre disponible teniendo en cuenta una localidad llega por parámetro y la información del partido <br>
     * Si el comprador es socio del equipo, se le vende la silla con descuento de socio.
     * @param pLocalidad Localidad de la silla que se quiere vender - pLocalidad != "" && pLocalidad != null
     * @param pNombreComprador Nombre del comprador de la silla - pNombreComprador != "" && pNombreComprador != null
     * @param pCedulaComprador Cédula del comprador de la silla - pCedulaComprador != "" && pCedulaComprador != null
     */
    public void venderSillaAutomaticamente( String pLocalidad, String pNombreComprador, String pCedulaComprador )
    {
        try
        {
            Partido partidoActual = panelPartido.darPartidoActual( );
            double costoVenta = taquilla.venderSillaAutomatica( pLocalidad, pNombreComprador, pCedulaComprador, partidoActual.darRival( ), partidoActual.darTorneo( ), partidoActual.darFechaPartido( ) );
            DecimalFormat df = new DecimalFormat( "###,###.#" );
            String strCosto = df.format( costoVenta );
            JOptionPane.showMessageDialog( this, " vendida exitósamente.\n" + pLocalidad +".\nCosto: $" + strCosto , "Información", JOptionPane.INFORMATION_MESSAGE );
            actualizarEstadio( partidoActual );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Atención", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Elimina un partido dado el nombre del rival, del torneo y la fecha. No se puede eliminar un partido que tiene boletas vendidas.<br>
     */
    public void eliminarPartido( )
    {
        Partido partidoActual = panelPartido.darPartidoActual( );

        if( partidoActual != null )
        {
            try
            {
                taquilla.eliminarPartido( partidoActual.darRival( ), partidoActual.darTorneo( ), partidoActual.darFechaPartido( ) );
                JOptionPane.showMessageDialog( this, "Partido eliminado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE );
                actualizarListaPartidos( );
                Partido partidoRestante = panelPartido.darPartidoActual( );
                if( partidoRestante != null )
                {
                    actualizarEstadio( partidoRestante );
                }
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, e.getMessage( ), "Atención", JOptionPane.WARNING_MESSAGE );
            }
        }
        else
        {
            JOptionPane.showMessageDialog( this, "Debe seleccionar un partido", "Información", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Abre el diálogo para agregar un socio
     */
    public void abrirDialogoAgregarSocio( )
    {
        DialogoAgregarSocio dialogoAgregarSocio = new DialogoAgregarSocio( this );
        dialogoAgregarSocio.setVisible( true );
    }

    /**
     * Agrega un socio al equipo <br>
     * @param pNombre Nombre del socio - pNombre != "" && pNombre != null
     * @param pCedula Cédula del socio - pCedula != "" && pCedula != null
     */
    public void agregarSocio( String pNombre, String pCedula )
    {
        try
        {
            taquilla.agregarSocio( pNombre, pCedula );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, e.getMessage( ), "Atención", JOptionPane.WARNING_MESSAGE );
        }
    }

    /**
     * Calcula el valor total de ingresos de todos los partidos.
     */
    public void darTotalIngresos( )
    {
        double totalIngresos = taquilla.darTotalIngresos( );
        DecimalFormat df = new DecimalFormat( "###,###.#" );
        String ftotalIngresos = df.format( totalIngresos );

        JOptionPane.showMessageDialog( this, "$" + ftotalIngresos, "Total Ingresos", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Actualiza la lista de partidos
     */
    public void actualizarListaPartidos( )
    {
        panelPartido.actualizarPartidos( taquilla.darPartidos( ) );
    }

    /**
     * Actualiza el estadio con el partido dado por parámetro
     * @param pPartido El partido que se va a mostrar.
     */
    public void actualizarEstadio( Partido pPartido )
    {
        panelEstadio.actualizarEstadio( pPartido );
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = taquilla.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = taquilla.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args
     */
    public static void main( String[] args )
    {
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
        InterfazTaquilla interfaz = new InterfazTaquilla( );
        interfaz.setVisible( true );
    }
}