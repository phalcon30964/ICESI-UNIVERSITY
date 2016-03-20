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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

import uniandes.cupi2.triangulo.mundo.Triangulo;

/**
 * Panel donde se pinta el triangulo
 */
public class PanelTriangulo extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Triángulo a dibujar
     */
    private Triangulo triangulo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param elTriangulo Triángulo a dibujar
     */
    public PanelTriangulo( Triangulo elTriangulo )
    {
        triangulo = elTriangulo;
        setPreferredSize( new Dimension( 270, 200 ) );
    }

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Método para pintar el triángulo
     * @param g Gráficas donde se debe pintar
     */
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2d = ( Graphics2D )g;

        //Crea un polígono y lo pinta
        Polygon poligono = new Polygon( );
        poligono.addPoint( ( int )triangulo.darPunto1( ).darX( ), ( int )triangulo.darPunto1( ).darY( ) );
        poligono.addPoint( ( int )triangulo.darPunto2( ).darX( ), ( int )triangulo.darPunto2( ).darY( ) );
        poligono.addPoint( ( int )triangulo.darPunto3( ).darX( ), ( int )triangulo.darPunto3( ).darY( ) );

        //Pinta el fondo
        g2d.setColor( new Color( triangulo.darColorRelleno( ).darRojo( ), triangulo.darColorRelleno( ).darVerde( ), triangulo.darColorRelleno( ).darAzul( ) ) );
        g2d.fill( poligono );

        //Pinta el borde
        g2d.setColor( new Color( triangulo.darColorLineas( ).darRojo( ), triangulo.darColorLineas( ).darVerde( ), triangulo.darColorLineas( ).darAzul( ) ) );
        g2d.draw( poligono );
    }
}
