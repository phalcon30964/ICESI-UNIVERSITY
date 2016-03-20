/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n1_triangulo
 * Autor inicial: Pablo Barvo - Oct 20, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.figuras.mundo;

/**
 * Esta clase Representa un punto en un plano
 */
public class Punto
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Valor X del punto
     */
    private double x;

    /**
     * Valor Y del punto
     */
    private double y;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el punto con los valores iniciales <br>
     * @param x1 Valor X del punto
     * @param y1 Valor Y del punto <b>pre: </b> las coordenadas X1 y Y1 son validas ( no son negativas, son enteras) <br>
     *        <b>post: </b> un punto se ha creado
     */
    public void inicializar( double x1, double y1 )
    {
        x = x1;
        y = y1;
    }

    /**
     * Devuelve el valor X del punto
     * @return Valor X del punto
     */
    public double darX( )
    {
        return x;
    }

    /**
     * Cambia el valor X del punto
     * @param x1 Valor X del punto
     */
    public void cambiarX( double x1 )
    {
        x = x1;
    }

    /**
     * Devuelve el valor Y del punto
     * @return Valor Y del punto
     */
    public double darY( )
    {
        return y;
    }

    /**
     * Cambia el valor Y del punto
     * @param y1 Valor Y del punto
     */
    public void cambiarY( double y1 )
    {
        y = y1;
    }

}
