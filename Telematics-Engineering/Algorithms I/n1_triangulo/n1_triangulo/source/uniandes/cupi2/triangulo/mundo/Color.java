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

package uniandes.cupi2.triangulo.mundo;

/**
 * Representación de un color
 */
public class Color
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Componente R de RGB (Red)
     */
    private int rojo;

    /**
     * Componente G de RGB (Green)
     */
    private int verde;

    /**
     * Componente B de RBG (Blue)
     */
    private int azul;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el color
     * @param elRojo valor R de RGB
     * @param elVerde valor G de RGB
     * @param elAzul valor B de RGB
     */
    public void inicializar( int elRojo, int elVerde, int elAzul )
    {
        rojo = elRojo;
        verde = elVerde;
        azul = elAzul;
    }

    /**
     * Devuelve la cantidad de rojo (R) en el color
     * @return Cantidad de rojo
     */
    public int darRojo( )
    {
        return rojo;
    }

    /**
     * Cambia la cantidad de rojo (R) en el color
     * @param elRojo Nuevo valor
     */
    public void cambiarRojo( int elRojo )
    {
        rojo = elRojo;
    }

    /**
     * Devuelve la cantidad de verde (G) en el color
     * @return Cantidad de verde
     */
    public int darVerde( )
    {
        return verde;
    }

    /**
     * Cambia la cantidad de verde (G) en el color
     * @param elVerde Cantidad de verde
     */
    public void cambiarVerde( int elVerde )
    {
        verde = elVerde;
    }

    /**
     * Devuelve la cantidad de azul (B) en el color
     * @return Cantidad de azul
     */
    public int darAzul( )
    {
        return azul;
    }

    /**
     * Cambia la cantidad de azul (B) en el color
     * @param elAzul Cantidad de azul
     */
    public void cambiarAzul( int elAzul )
    {
        azul = elAzul;
    }

}
