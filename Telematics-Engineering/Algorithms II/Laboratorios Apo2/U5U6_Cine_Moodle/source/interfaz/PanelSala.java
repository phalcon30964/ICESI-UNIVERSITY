/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_cine
 * Autor: Pablo Barvo - Sep 20, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package interfaz;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import mundo.*;

/**
 * Muestra el cine en la pantalla
 */
public class PanelSala extends JPanel
{
	// Modificación iljojoa 6/11/2013
	// Crear panel Sala

    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Color de silla disponible en general
     */
    private static final Color COLOR_DISPONIBLE_GENERAL = Color.WHITE;

    /**
     * Color de silla disponible en preferencial
     */
    private static final Color COLOR_DISPONIBLE_PREFERENCIAL = Color.LIGHT_GRAY;

    /**
     * Color de silla reservada
     */
    private static final Color COLOR_RESERVADO = Color.YELLOW;

    /**
     * Color de silla vendida
     */
    private static final Color COLOR_VENDIDO = Color.RED;

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------


    /**
     * Sillas de la sala de cine
     */
    private Silla[][] sillas;

    //-----------------------------------------------------------------
    // Atributos de Interfaz
    //-----------------------------------------------------------------

    /**
     * Etiquetas de las sillas
     */
    private JLabel[] etiquetaSillas;

    /**
     * Etiqueta de la pantalla
     */
    private JLabel etiquetaPantalla;

    //-----------------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------------

    /**
     * Construye el panel con las sillas
     * @param lasSillas Sillas de la sala de cine
     */
    public PanelSala()
    {

        setLayout( new GridBagLayout( ) );
        setPreferredSize(new Dimension (600, 400));
        setBorder( new TitledBorder( "Sala" ) );
        
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    public void refrescarPanelSala(Silla[][] sillas){
    	System.out.println("pintando");
    	 //Pinta las sillas
        etiquetaSillas = new JLabel[sillas.length*Cine.SILLAS_POR_FILA];
        int fila = 2;
        int numero = 0;
        for( int i = 0; i < (Cine.FILAS_GENERAL + Cine.FILAS_PREFERENCIAL); i++ )
        {
        	for (int j=0; j < Cine.SILLAS_POR_FILA; j++){
            Silla silla = sillas[i][j];
            if( silla.darNumero( ) < 10 )
            {
                etiquetaSillas[ i ] = new JLabel( Character.toString( silla.darFila( ) ) + "0" + Integer.toString( silla.darNumero( ) ) );
            }
            else
            {
                etiquetaSillas[ i ] = new JLabel( Character.toString( silla.darFila( ) ) + Integer.toString( silla.darNumero( ) ) );
            }
            etiquetaSillas[ i ].setBackground( darColorSilla( silla ) );
            etiquetaSillas[ i ].setFont( etiquetaSillas[ i ].getFont( ).deriveFont( ( float )10 ) );
            etiquetaSillas[ i ].setPreferredSize( new Dimension( 22, 22 ) );
            etiquetaSillas[ i ].setBorder( new LineBorder( Color.GRAY ) );
            etiquetaSillas[ i ].setOpaque( true );
            etiquetaSillas[ i ].setHorizontalAlignment( JLabel.CENTER );

            //Ubica la silla
            GridBagConstraints posicion = new GridBagConstraints( numero, fila, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 1, 1, 1, 1 ), 0, 0 );
            add( etiquetaSillas[ i ], posicion );
            numero++;
            if( numero == Cine.SILLAS_POR_FILA )
            {
                fila++;
                numero = 0;
            }
        }
//        	revalidate();
//        	repaint();

        }
        //Pinta la pantalla
        etiquetaPantalla = new JLabel( "PANTALLA" );
        etiquetaPantalla.setHorizontalAlignment( JLabel.CENTER );
        etiquetaPantalla.setBackground( Color.CYAN );
        etiquetaPantalla.setOpaque( true );
        etiquetaPantalla.setBorder( new LineBorder( Color.GRAY ) );
        etiquetaPantalla.setPreferredSize( new Dimension((20 - 4 ) * 22, 30 ) );
        GridBagConstraints posicion = new GridBagConstraints( 2, 0, ( Cine.SILLAS_POR_FILA - 4 ), 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets( 5, 5, 50, 5 ), 0, 0 );
        add( etiquetaPantalla, posicion );
    }
    


    /**
     * Devuelve el color de una silla especifica
     * @param silla Silla a calcular el color
     * @return Color de la silla
     */
    private Color darColorSilla( Silla silla )
    {
        if( silla.estaDisponible( ) )
        {
            if( silla.esGeneral( ) )
            {
                return COLOR_DISPONIBLE_GENERAL;
            }
            else
            {
                return COLOR_DISPONIBLE_PREFERENCIAL;
            }
        }
        else if( silla.estaReservada( ))
        {
            return COLOR_RESERVADO;
        }
        else
        {
            return COLOR_VENDIDO;
        }
    }
}