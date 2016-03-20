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
package uniandes.cupi2.triangulo.mundo;

/**
 * Triángulo
 */
public class Triangulo
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Primer punto del triángulo
     */
    private Punto punto1;

    /**
     * Segundo punto del triángulo
     */
    private Punto punto2;

    /**
     * Tercer punto del triángulo
     */
    private Punto punto3;

    /**
     * Color de las lineas
     */
    private Color colorLineas;

    /**
     * Color del relleno
     */
    private Color colorRelleno;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Inicializa el triángulo
     * @param elPunto1 Punto 1 del triángulo
     * @param elPunto2 Punto 2 del triángulo
     * @param elPunto3 Punto 3 del triángulo
     * @param relleno Color de relleno
     * @param lineas Color de las líneas
     */
    public void inicializar( Punto elPunto1, Punto elPunto2, Punto elPunto3, Color relleno, Color lineas )
    {
        //Inicializa los puntos
        punto1 = elPunto1;
        punto2 = elPunto2;
        punto3 = elPunto3;

        //Inicializa los colores
        colorRelleno = relleno;
        colorLineas = lineas;
    }

    /**
     * Devuelve el punto 1 del triángulo
     * @return Punto 1
     */
    public Punto darPunto1( )
    {
        return punto1;
    }

    /**
     * Devuelve el punto 2 del triángulo
     * @return Punto 2
     */
    public Punto darPunto2( )
    {
        return punto2;
    }

    /**
     * Devuelve el punto 3 del triángulo
     * @return Punto 3
     */
    public Punto darPunto3( )
    {
        return punto3;
    }

    /**
     * Devuelve el color de las líneas del triángulo
     * @return Color de las líneas
     */
    public Color darColorLineas( )
    {
        return colorLineas;
    }

    /**
     * Devuelve el color del relleno del triángulo
     * @return Color del relleno
     */
    public Color darColorRelleno( )
    {
        return colorRelleno;
    }

    /**
     * Devuelve el perímetro del triángulo.
     * @return Perímetro del triángulo
     */
    public double darPerimetro( )
    {
        //Devuelve la suma de todos los lados
        return darLado1( ) + darLado2( ) + darLado3( );
    }

    /**
     * Devuelve el área del triángulo, calculada utilizando la formula de Herón: <br>
     * http://en.wikipedia.org/wiki/Heron's_formula
     * @return Área del triángulo
     */
    public double darArea( )
    {
        //Calcula el valor S para la formula
        double perimetro = darPerimetro( );
        double s = perimetro / 2;

        //Calcula las restas para cada uno de los lados
        double valorLado1 = s - darLado1( );
        double valorLado2 = s - darLado2( );
        double valorLado3 = s - darLado3( );

        //Calcula y devuelve el área
        // RaizCuadrada( s * (s - Lado1) * (s - Lado2) * (s - Lado3) )
        double area = Math.sqrt( s * valorLado1 * valorLado2 * valorLado3 );
        return area;
    }

    /**
     * Calcula la altura del triángulo, teniendo en cuenta como base la línea entre el punto 1 y 2.<br>
     * Tenga en cuenta que Área = (Base * Altura) / 2
     * @return Altura del triángulo
     */
    public double darAltura( )
    {
        double area = darArea( );
        double base = darLado1( );
        double altura = ( area / base ) * 2;
        return altura;
    }

    /**
     * Calcula la distancia entre el punto 1 y 2
     * @return la distancia entre el punto 1 y el punto 2
     */
    private double darLado1( )
    {
        //Calcula las restas
        double valorX = Math.pow( punto1.darX( ) - punto2.darX( ), 2 );
        double valorY = Math.pow( punto1.darY( ) - punto2.darY( ), 2 );

        //calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 2 y 3
     * @return la distancia entre el punto 2 y 3
     */
    private double darLado2( )
    {
        //Calcula las restas
        double valorX = Math.pow( punto2.darX( ) - punto3.darX( ), 2 );
        double valorY = Math.pow( punto2.darY( ) - punto3.darY( ), 2 );

        //calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    /**
     * Calcula la distancia entre el punto 3 y 1
     * @return la distancia entre el punto 3 y 1
     */
    private double darLado3( )
    {
        //Calcula las restas
        double valorX = Math.pow( punto3.darX( ) - punto1.darX( ), 2 );
        double valorY = Math.pow( punto3.darY( ) - punto1.darY( ), 2 );

        //calcula la distancia
        double distancia = Math.sqrt( valorX + valorY );
        return distancia;
    }

    //-----------------------------------------------------------------
    // Puntos de Extensión
    //-----------------------------------------------------------------

    /**
     * Método para la extensión 1
     * 
     * @return respuesta1
     */
    public String metodo1( )
    {
        return "respuesta1";
    }

    /**
     * Método para la extensión2
     * 
     * @return respuesta2
     */
    public String metodo2( )
    {
        return "respuesta2";
    }

}
