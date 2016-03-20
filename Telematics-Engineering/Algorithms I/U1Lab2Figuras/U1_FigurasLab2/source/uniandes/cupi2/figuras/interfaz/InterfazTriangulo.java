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

package uniandes.cupi2.figuras.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.geom.Line2D;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import uniandes.cupi2.figuras.mundo.*;

/**
 * Ventana principal de la aplicación
 */
public class InterfazTriangulo extends JFrame implements ChangeListener
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
	
    /**
     * Triángulo
     */
    private Triangulo triangulo;

    /**
     * Rectángulo
     */
    private Rectangulo rectangulo;

    /**
     * Círculo
     */
    private Circulo circulo;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de los botones
     */
    private PanelBotones panelBotones;

    /**
     * Panel de visualización del triángulo
     */
    private PanelTriangulo panelTriangulo;

    /**
     * Panel de visualización del rectángulo
     */
    private PanelRectangulo panelRectangulo;

    /**
     * Panel de visualización del círculo
     */
    private PanelCirculo panelCirculo;

    /**
     * Panel de extensiones
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel con el encabezado
     */
    private PanelImagen panelImagen;
    
    JTabbedPane panelPestanas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la interfaz
     */
    public InterfazTriangulo( )
    {
        //Crea el triángulo
        triangulo = new Triangulo( );

        //Crea el rectángulo
        rectangulo = new Rectangulo( );

        //Crea el círculo
        circulo = new Circulo( );

        //Crea el punto 1
        Punto punto1 = new Punto( );
        punto1.inicializar( 120, 20 );

        //Crea el punto 2
        Punto punto2 = new Punto( );
        punto2.inicializar( 220, 180 );

        //Crea el punto 1
        Punto punto3 = new Punto( );
        punto3.inicializar( 20, 180 );

        //Crea el punto esquina superior izquierda
        Punto esquinaSuperiorIzquierda = new Punto( );
        esquinaSuperiorIzquierda.inicializar( 20, 20 );

        //Crea el punto esquina superior izquierda
        Punto centro = new Punto( );
        centro.inicializar( 100, 100 );

        //Inicializa el color del relleno en Azul
        // Valor RGB = (0, 0, 150)
        uniandes.cupi2.figuras.mundo.Color colorRelleno = new uniandes.cupi2.figuras.mundo.Color( );
        colorRelleno.inicializar( 0, 0, 170 );

        //Inicializa el color de las líneas en negro
        // Valor RGB = (0, 0, 0)
        uniandes.cupi2.figuras.mundo.Color colorLineas = new uniandes.cupi2.figuras.mundo.Color( );
        colorLineas.inicializar( 0, 0, 0 );

        //Inicializa el color del relleno en Azul
        // Valor RGB = (0, 0, 150)
        uniandes.cupi2.figuras.mundo.Color colorRelleno2 = new uniandes.cupi2.figuras.mundo.Color( );
        colorRelleno2.inicializar( 0, 0, 170 );

        //Inicializa el color de las líneas en negro
        // Valor RGB = (0, 0, 0)
        uniandes.cupi2.figuras.mundo.Color colorLineas2 = new uniandes.cupi2.figuras.mundo.Color( );
        colorLineas2.inicializar( 0, 0, 0 );

        //Inicializa el color del relleno en Azul
        // Valor RGB = (0, 0, 150)
        uniandes.cupi2.figuras.mundo.Color colorRelleno3 = new uniandes.cupi2.figuras.mundo.Color( );
        colorRelleno3.inicializar( 0, 0, 170 );

        //Inicializa el color de las líneas en negro
        // Valor RGB = (0, 0, 0)
        uniandes.cupi2.figuras.mundo.Color colorLineas3 = new uniandes.cupi2.figuras.mundo.Color( );
        colorLineas3.inicializar( 0, 0, 0 );

        //Inicializa el triángulo
        triangulo.inicializar( punto1, punto2, punto3, colorRelleno, colorLineas );

        //Inicializa el rectángulo
        rectangulo.inicializar( esquinaSuperiorIzquierda, 150, 100, colorRelleno2, colorLineas2 );

        //Inicializa el rectángulo
        circulo.inicializar( centro, 70, colorRelleno3, colorLineas3 );

        //Crea la interfaz
        setTitle( "Figuras" );
        getContentPane( ).setLayout( new BorderLayout( ) );
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        
        panelBotones = new PanelBotones( this );
        getContentPane( ).add( panelBotones, BorderLayout.WEST );
        
        panelTriangulo = new PanelTriangulo( triangulo );
        panelRectangulo = new PanelRectangulo( rectangulo );
        panelCirculo = new PanelCirculo( circulo );

        panelPestanas = new JTabbedPane();
        panelPestanas.addTab("Triángulo", panelTriangulo);
        panelPestanas.addTab("Rectángulo", panelRectangulo);
        panelPestanas.addTab("Círculo", panelCirculo);
        getContentPane( ).add( panelPestanas, BorderLayout.CENTER );
        panelPestanas.addChangeListener(this);

        panelOpciones = new PanelOpciones( this );
        getContentPane( ).add( panelOpciones, BorderLayout.SOUTH );

        panelImagen = new PanelImagen( );
        getContentPane( ).add( panelImagen, BorderLayout.NORTH );

        pack( );
        repintar( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Muestra el diálogo para cambiar los puntos del triángulo
     */
    public void cambiarPuntos( )
    {
    	switch(panelPestanas.getSelectedIndex()){
			case 0:
		        DialogoPuntos dialogoPuntos = new DialogoPuntos( this );
		        dialogoPuntos.setVisible( true );
		        setEnabled( false );
		    break;
			case 1:
				DialogoRectangulo dialogoRectangulo = new DialogoRectangulo( this );
		        dialogoRectangulo.setVisible( true );
		        setEnabled( false );
		    break;
			case 2:
				DialogoCirculo dialogoCirculo = new DialogoCirculo( this );
		        dialogoCirculo.setVisible( true );
		        setEnabled( false );
		    break;
    	}
    }

    /**
     * Cambia el color del fondo
     *  
     */
    public void cambiarColorFondo( )
    {
    	switch(panelPestanas.getSelectedIndex()){
			case 0:
		        Color colorActual = new Color( triangulo.darColorRelleno( ).darRojo( ), triangulo.darColorRelleno( ).darVerde( ), triangulo.darColorRelleno( ).darAzul( ) );
		        Color nuevoColor = JColorChooser.showDialog( this, "Color Fondo", colorActual );
		        if( nuevoColor != null )
		        {
		            //Cambia los valores
		            triangulo.darColorRelleno( ).cambiarRojo( nuevoColor.getRed( ) );
		            triangulo.darColorRelleno( ).cambiarVerde( nuevoColor.getGreen( ) );
		            triangulo.darColorRelleno( ).cambiarAzul( nuevoColor.getBlue( ) );
		        }
	        break;
			case 1:
		        Color colorActual2 = new Color( rectangulo.darColorRelleno( ).darRojo( ), rectangulo.darColorRelleno( ).darVerde( ), rectangulo.darColorRelleno( ).darAzul( ) );
		        Color nuevoColor2 = JColorChooser.showDialog( this, "Color Fondo", colorActual2 );
		        if( nuevoColor2 != null )
		        {
		            //Cambia los valores
		            rectangulo.darColorRelleno( ).cambiarRojo( nuevoColor2.getRed( ) );
		            rectangulo.darColorRelleno( ).cambiarVerde( nuevoColor2.getGreen( ) );
		            rectangulo.darColorRelleno( ).cambiarAzul( nuevoColor2.getBlue( ) );
		        }
	        break;
			case 2:
		        Color colorActual3 = new Color( circulo.darColorRelleno( ).darRojo( ), circulo.darColorRelleno( ).darVerde( ), circulo.darColorRelleno( ).darAzul( ) );
		        Color nuevoColor3 = JColorChooser.showDialog( this, "Color Fondo", colorActual3 );
		        if( nuevoColor3 != null )
		        {
		            //Cambia los valores
		            circulo.darColorRelleno( ).cambiarRojo( nuevoColor3.getRed( ) );
		            circulo.darColorRelleno( ).cambiarVerde( nuevoColor3.getGreen( ) );
		            circulo.darColorRelleno( ).cambiarAzul( nuevoColor3.getBlue( ) );
		        }
	        break;
    	}
        repintar( );
    }
    /**
     * Cambia el color de las líneas
     *  
     */
    public void cambiarColorLineas( )
    {
    	switch(panelPestanas.getSelectedIndex()){
			case 0:
		        Color colorActual = new Color( triangulo.darColorLineas( ).darRojo( ), triangulo.darColorLineas( ).darVerde( ), triangulo.darColorLineas( ).darAzul( ) );
		        Color nuevoColor = JColorChooser.showDialog( this, "Color Líneas", colorActual );
		        if( nuevoColor != null )
		        {
		            //Cambia los valores
		            triangulo.darColorLineas( ).cambiarRojo( nuevoColor.getRed( ) );
		            triangulo.darColorLineas( ).cambiarVerde( nuevoColor.getGreen( ) );
		            triangulo.darColorLineas( ).cambiarAzul( nuevoColor.getBlue( ) );
		        }
	        break;
			case 1:
		        Color colorActual2 = new Color( rectangulo.darColorLineas( ).darRojo( ), rectangulo.darColorLineas( ).darVerde( ), rectangulo.darColorLineas( ).darAzul( ) );
		        Color nuevoColor2 = JColorChooser.showDialog( this, "Color Líneas", colorActual2 );
		        if( nuevoColor2 != null )
		        {
		            //Cambia los valores
		            rectangulo.darColorLineas( ).cambiarRojo( nuevoColor2.getRed( ) );
		            rectangulo.darColorLineas( ).cambiarVerde( nuevoColor2.getGreen( ) );
		            rectangulo.darColorLineas( ).cambiarAzul( nuevoColor2.getBlue( ) );
		        }
	        break;
			case 2:
		        Color colorActual3 = new Color( circulo.darColorLineas( ).darRojo( ), circulo.darColorLineas( ).darVerde( ), circulo.darColorLineas( ).darAzul( ) );
		        Color nuevoColor3 = JColorChooser.showDialog( this, "Color Líneas", colorActual3 );
		        if( nuevoColor3 != null )
		        {
		            //Cambia los valores
		            circulo.darColorLineas( ).cambiarRojo( nuevoColor3.getRed( ) );
		            circulo.darColorLineas( ).cambiarVerde( nuevoColor3.getGreen( ) );
		            circulo.darColorLineas( ).cambiarAzul( nuevoColor3.getBlue( ) );
		        }
	        break;
    	}
        repintar( );
    }

    /**
     * Repinta el triángulo y los valores
     *  
     */
    public void repintar( )
    {
    	switch(panelPestanas.getSelectedIndex()){
    		case 0:
    			panelTriangulo.repaint( );
    			panelBotones.cambiarInformacion( triangulo.darPerimetro( ), triangulo.darArea( ), triangulo.darAltura( ) );
    		break;
    		case 1:
		        panelRectangulo.repaint( );
		        panelBotones.cambiarInformacion( rectangulo.darPerimetro( ), rectangulo.darArea( ), rectangulo.darAlto( ) );
		    break;
    		case 2:
		        panelCirculo.repaint( );
		        panelBotones.cambiarInformacionC( circulo.darPerimetro( ), circulo.darArea( ), circulo.darRadio( ) );
		    break;
    	}
    }

    /**
     * Devuelve el triángulo actual
     * @return Triángulo
     */
    public Triangulo darTriangulo( )
    {
        return triangulo;
    }

    public Rectangulo darRectangulo( )
    {
        return rectangulo;
    }

    public Circulo darCirculo( )
    {
        return circulo;
    }

    /**
     * Verifica si 3 puntos son colineales
     * @param p1x Valor X punto 1
     * @param p1y Valor Y punto 1
     * @param p2x Valor X punto 2
     * @param p2y Valor Y punto 2
     * @param p3x Valor X punto 3
     * @param p3y Valor Y punto 3
     * @return verdadero si los tres puntos dados son colineales
     */
    public boolean colineales( double p1x, double p1y, double p2x, double p2y, double p3x, double p3y )
    {
        //Verifica usando un Line2D
        Line2D linea = new Line2D.Double( p1x, p1y, p2x, p2y );
        return ( linea.ptLineDist( p3x, p3y ) == 0 );

    }
    
    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Ejecuta el punto de extensión 1
     */
    public void reqFuncOpcion1( )
    {
        String resultado = triangulo.metodo1( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Ejecuta el punto de extensión 2
     */
    public void reqFuncOpcion2( )
    {
        String resultado = triangulo.metodo2( );
        JOptionPane.showMessageDialog( this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Inicia la aplicación
     * @param args Parámetros no utilizados
     */
    public static void main( String[] args )
    {
        InterfazTriangulo interfaz = new InterfazTriangulo( );
        interfaz.setVisible( true );
    }

	@Override
	public void stateChanged(ChangeEvent arg0) {
		repintar();
		
	}

}
