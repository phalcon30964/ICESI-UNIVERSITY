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
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import uniandes.cupi2.figuras.mundo.Circulo;

/**
 * Panel donde se pinta el circulo
 */
public class PanelCirculo extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Círculo a dibujar
     */
    private Circulo circulo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param elCirculo Círculo a dibujar
     */
    public PanelCirculo( Circulo elCirculo )
    {
        circulo = elCirculo;
        setPreferredSize( new Dimension( 270, 200 ) );
    }

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Método para pintar el círculo
     * @param g Gráficas donde se debe pintar
     */
    protected void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        Graphics2D g2d = ( Graphics2D )g;
        
        double punto1x = circulo.darCentro().darX();
        double punto1y = circulo.darCentro().darY();
        
        double radio = circulo.darRadio();
        
        //Pinta el fondo
        g2d.setColor( new Color( circulo.darColorRelleno( ).darRojo( ), circulo.darColorRelleno( ).darVerde( ), circulo.darColorRelleno( ).darAzul( ) ) );
        g2d.fill( new Ellipse2D.Double( punto1x, punto1y, radio, radio ) );

        //Pinta el borde
        g2d.setColor( new Color( circulo.darColorLineas( ).darRojo( ), circulo.darColorLineas( ).darVerde( ), circulo.darColorLineas( ).darAzul( ) ) );
        g2d.draw( new Ellipse2D.Double( punto1x, punto1y, radio, radio ) );
    }
}
