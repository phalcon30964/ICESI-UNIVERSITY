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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

import uniandes.cupi2.figuras.mundo.Rectangulo;

/**
 * Panel donde se pinta el rectangulo
 */
public class PanelRectangulo extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Rectángulo a dibujar
     */
    private Rectangulo rectangulo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param elRectangulo Rectángulo a dibujar
     */
    public PanelRectangulo( Rectangulo elRectangulo )
    {
        rectangulo = elRectangulo;
        setPreferredSize( new Dimension( 270, 200 ) );
    }

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Método para pintar el rectángulo
     * @param g Gráficas donde se debe pintar
     */
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2d = ( Graphics2D )g;
        
        double punto1x = rectangulo.darEsquinaSuperiorIzquierda().darX();
        double punto1y = rectangulo.darEsquinaSuperiorIzquierda().darY();
        
        double punto2x = rectangulo.calcularEsquinaSuperiorDerecha().darX();
        double punto2y = rectangulo.calcularEsquinaSuperiorDerecha().darY();
        
        double punto3x = rectangulo.calcularEsquinaInferiorDerecha().darX();
        double punto3y = rectangulo.calcularEsquinaInferiorDerecha().darY();
        
        double punto4x = rectangulo.calcularEsquinaInferiorIzquierda().darX();
        double punto4y = rectangulo.calcularEsquinaInferiorIzquierda().darY();
        
        //Crea un polígono y lo pinta
        Polygon poligono = new Polygon( );
        poligono.addPoint( ( int )punto1x, ( int )punto1y);
        poligono.addPoint( ( int )punto2x, ( int )punto2y);
        poligono.addPoint( ( int )punto3x, ( int )punto3y);
        poligono.addPoint( ( int )punto4x, ( int )punto4y);

        //Pinta el fondo
        g2d.setColor( new Color( rectangulo.darColorRelleno( ).darRojo( ), rectangulo.darColorRelleno( ).darVerde( ), rectangulo.darColorRelleno( ).darAzul( ) ) );
        g2d.fill( poligono );

        //Pinta el borde
        g2d.setColor( new Color( rectangulo.darColorLineas( ).darRojo( ), rectangulo.darColorLineas( ).darVerde( ), rectangulo.darColorLineas( ).darAzul( ) ) );
        g2d.draw( poligono );
    }
}
