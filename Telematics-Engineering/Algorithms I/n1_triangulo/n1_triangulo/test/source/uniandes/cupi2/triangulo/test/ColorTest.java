/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_triangulo
 * Autor: Pablo Barvo - Oct 25, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.triangulo.test;

import uniandes.cupi2.triangulo.mundo.Color;
import junit.framework.TestCase;

/**
 * Pruebas de la clase Color
 */
public class ColorTest extends TestCase
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Color a probar
     */
    private Color color;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Construye el Color
     */
    private void setupEscenario1( )
    {
        color = new Color( );
        color.inicializar( 1, 1, 1 );
    }

    /**
     * Prueba 1 - Rojo
     */
    public void testRojo( )
    {
        setupEscenario1( );

        //Prueba el color Rojo
        assertEquals( "El rojo debe estar inicializado en 1", 1, color.darRojo( ) );
        color.cambiarRojo( 25 );
        assertEquals( "El rojo debe ser 25", 25, color.darRojo( ) );
    }

    /**
     * Prueba 1 - Verde
     */
    public void testVerde( )
    {
        setupEscenario1( );

        //Prueba el color Verde
        assertEquals( "El verde debe estar inicializado en 1", 1, color.darVerde( ) );
        color.cambiarVerde( 25 );
        assertEquals( "El verde debe ser 25", 25, color.darVerde( ) );
    }

    /**
     * Prueba 1 - Azul
     */
    public void testAzul( )
    {
        setupEscenario1( );

        //Prueba el color Azul
        assertEquals( "El azul debe estar inicializado en 1", 1, color.darAzul( ) );
        color.cambiarAzul( 25 );
        assertEquals( "El azul debe ser 25", 25, color.darAzul( ) );
    }

}
