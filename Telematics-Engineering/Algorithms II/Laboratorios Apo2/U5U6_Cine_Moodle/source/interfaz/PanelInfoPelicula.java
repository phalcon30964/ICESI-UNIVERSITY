/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * $Id$ 
 * Universidad de los Andes (Bogotá - Colombia) 
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n4_cine
 * Autor: Pablo Barvo - Sep 19, 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package interfaz;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.*;

import mundo.*;

/**
 * Panel manejo de los datos de reserva
 */
public class PanelInfoPelicula extends JPanel 
{


    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------



    /**
     * Informacion de la pelicula
     */
    private JLabel labNombre;
    private JLabel labSinopsis;
    private JLabel labGenero;
    private JLabel labIdioma;
    private JLabel labPais;
    private JLabel labDuracion;
    private JLabel labNombrePel;
    private JLabel labSinopsisPel;
    private JLabel labGeneroPel;
    private JLabel labIdiomaPel;
    private JLabel labPaisPel;
    private JLabel labDuracionPel;
    
    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param laVentana Ventana principal
     * @param elCine Cine
     */
    public PanelInfoPelicula( )
    {
     

        //setLayout( new BorderLayout() );
        setPreferredSize(new Dimension (340, 250));
        
 
        
        setBorder( new TitledBorder( "Informaci—n de la pelicula" ));
        setLayout (new GridLayout(6,2));
        
        //Información de la pelicula
        labNombre = new JLabel( "Nombre: " );
        labNombrePel = new JLabel();
        labSinopsis = new JLabel( "Sinopsis: " );
        labSinopsisPel = new JLabel();
        labGenero = new JLabel( "GŽnero: " );
        labGeneroPel = new JLabel();
        labIdioma = new JLabel( "Idioma: " );
        labIdiomaPel = new JLabel( );
        labPais= new JLabel( "Pais: " );
        labPaisPel= new JLabel();
        labDuracion = new JLabel( "Duracion: " );
        labDuracionPel = new JLabel();
        add( labNombre );
    	add( labNombrePel );
        add( labSinopsis );
        add( labSinopsisPel );
        add( labGenero );
        add( labGeneroPel );
        add( labIdioma );
        add( labIdiomaPel );
        add( labPais );
        add( labPaisPel );
        add( labDuracion );
        add( labDuracionPel);

        


    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------
    
    public void refrescarPanelPelicula(Pelicula pel){
   
    	labNombrePel.setText(pel.darNombre());
    	labSinopsisPel.setText(pel.darSinopsis());
    	labGeneroPel.setText(pel.darGenero());
    	labIdiomaPel.setText(pel.darIdioma());
    	labPaisPel.setText(pel.darPais());
    	labDuracionPel.setText(pel.darDuracion()+"");
    	
    }
    

}
