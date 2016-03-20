/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_cine
 * Autor: Pablo Barvo - Sep 13, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package mundo;

/**
 * Representa una silla en el teatro
 */
public class Silla
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Tipo de silla General
     */
    public static final String GENERAL = "GENERAL";

    /**
     * Tipo de silla Preferencial
     */
    public static final String PREFERENCIAL = "PREFERENCIAL";

    /**
     * Estado de silla libre
     */
    public static final String ESTADO_DISPONIBLE = "ESTADO_DISPONIBLE";

    /**
     * Estado de silla reservada
     */
    public static final String ESTADO_RESERVADA = "ESTADO_RESERVADA";

    /**
     * Estado de silla vendida
     */
    public static final String ESTADO_VENDIDA = "ESTADO_VENDIDA";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ubicación de la silla en el teatro
     */
    private char fila;

    /**
     * Tipo de Silla
     */
    private String tipo;

    /**
     * Número de la silla en la fila
     */
    private int numero;

    /**
     * Estado de la silla
     */
    private String estado;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor de la silla
     * @param filaActual Ubicación de la silla
     * @param numeroSilla Número de la silla en la fila
     * @param tipoSilla Tipo de la silla. tipoSilla pertenece a {GERENCIAL, PREFERENCIAL}
     * @param est estado de la silla. est pertenece a {DISPONIBLE, RESERVADA, VENDIDA}
     */
    public Silla( char filaActual,int numeroSilla, String tipoSilla, String est )
    {
        fila = filaActual;
        numero = numeroSilla;
        tipo = tipoSilla;
        estado = est;
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    /**
     * Devuelve la fila de la silla
     * @return Fila de la silla
     */
    public char darFila( )
    {
        return fila;
    }

    /**
     * Devuelve el número de la silla en la fila
     * @return Numero de la silla en la fila
     */
    public int darNumero( )
    {
        return numero;
    }

    

    /**
     * Indica si la silla está disponible
     * @return verdadero si la silla está disponible, falso en caso contrario
     */
    public boolean estaDisponible( )
    {
        return estado.equals(ESTADO_DISPONIBLE);
    }

    /**
     * Deja una silla en estado disponible
     */
    public void dejarDisponible( )
    {
        estado = ESTADO_DISPONIBLE;
    }

    /**
     * Indica si la silla está vendida
     * @return verdadero si la silla está vendida, falso en caso contrario
     */
    public boolean estaVendida( )
    {
        return estado.equals( ESTADO_VENDIDA);
    }

    /**
     * Deja una silla en estado vendida
     */
    public void venderSilla( )
    {
        estado = ESTADO_VENDIDA;
    }

    /**
     * Indica si la silla está reservada
     * @return verdadero si la silla está reservada, falso en caso contrario
     */
    public boolean estaReservada( )
    {
        return estado.equals(ESTADO_RESERVADA);
    }

    /**
     * Deja una silla en estado reservada
     */
    public void reservarSilla( )
    {
        estado = ESTADO_RESERVADA;
    }

    /**
     * Indica si la silla es de tipo general
     * @return verdadero si la silla es de tipo general, falso en caso contrario
     */
    public boolean esGeneral( )
    {
        return tipo == GENERAL;
    }

    /**
     * Indica si la silla es de tipo preferencial
     * @return verdadero si la silla es de tipo preferencial, falso en caso contrario
     */
    public boolean esPreferencial( )
    {
        return tipo == PREFERENCIAL;
    }
}