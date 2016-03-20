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

import junit.framework.TestCase;
import uniandes.cupi2.triangulo.mundo.Punto;

/**
 * Pruebas de la clase Punto
 */
public class PuntoTest extends TestCase
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Punto a probar
     */
    private Punto punto;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Construye el Punto
     */
    private void setupEscenario1( )
    {
        punto = new Punto( );
        punto.inicializar( 1, 1 );
    }

    /**
     * Prueba 1 - Valor X
     */
    public void testValorX( )
    {
        setupEscenario1( );

        //Prueba el valor X
        assertEquals( "El valor X debe estar inicializado en 1", 1, punto.darX( ), 0 );
        punto.cambiarX( 25 );
        assertEquals( "El valor X debe ser 25", 25, punto.darX( ), 0 );
    }

    /**
     * Prueba 2 - Valor Y
     */
    public void testValorY( )
    {
        setupEscenario1( );

        //Prueba el valor Y
        assertEquals( "El valor Y debe estar inicializado en 1", 1, punto.darY( ), 0 );
        punto.cambiarY( 25 );
        assertEquals( "El valor Y debe ser 25", 25, punto.darY( ), 0 );
    }

}
