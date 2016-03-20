/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n1_triangulo
 * Autor: Pablo Barvo - 21-Oct-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.triangulo.test;

import junit.framework.TestCase;
import uniandes.cupi2.figuras.mundo.Punto;
import uniandes.cupi2.figuras.mundo.Triangulo;

/**
 * Esta es la clase usada para verificar que los métodos de la clase Triangulo estén correctamente implementados
 */
public class TrianguloTest extends TestCase
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Es la clase donde se harán las pruebas
     */
    private Triangulo triangulo;

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Construye un nuevo Triangulo vacía
     *  
     */
    private void setupEscenario1( )
    {
        //Crea el triángulo
        triangulo = new Triangulo( );

        //Crea el punto 1
        Punto punto1 = new Punto( );
        punto1.inicializar( 0, 4 );

        //Crea el punto 2
        Punto punto2 = new Punto( );
        punto2.inicializar( 0, 0 );

        //Crea el punto 1
        Punto punto3 = new Punto( );
        punto3.inicializar( 8, 4 );

        //Inicializa el color del relleno en Azul
        // Valor RGB = (0, 0, 150)
        uniandes.cupi2.figuras.mundo.Color colorRelleno = new uniandes.cupi2.figuras.mundo.Color( );
        colorRelleno.inicializar( 0, 0, 170 );

        //Inicializa el color de las líneas en negro
        // Valor RGB = (0, 0, 0)
        uniandes.cupi2.figuras.mundo.Color colorLineas = new uniandes.cupi2.figuras.mundo.Color( );
        colorLineas.inicializar( 0, 0, 0 );

        //Inicializa el triángulo
        triangulo.inicializar( punto1, punto2, punto3, colorRelleno, colorLineas );
    }

    /**
     * Prueba 1 - Área del triángulo
     */
    public void testArea( )
    {
        setupEscenario1( );

        assertEquals( "El Área debe ser 16", 16, triangulo.darArea( ), 0 );
    }

    /**
     * Prueba 2 - Perímetro del Triángulo
     */
    public void testPerimetro( )
    {
        setupEscenario1( );

        assertEquals( "El perímetro debe ser 20.94427190999916", 20.94427190999916, triangulo.darPerimetro( ), 0.0000000000001 );
    }

    /**
     * Prueba 3 - Altura del Triángulo
     */
    public void testAltura( )
    {
        setupEscenario1( );

        assertEquals( "La altura debe ser 8", 8, triangulo.darAltura( ), 0 );
    }

}