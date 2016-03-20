/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n4_cine
 * Autor: Pablo Barvo - 13-Sep-2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package interfaz;

import java.awt.*;
import java.io.*;

import javax.swing.*;

import mundo.*;

/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazCine extends JFrame
{
    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Clase principal del modelo del mundo
     */
    private Cine cine;

  
    //-----------------------------------------------------------------
    // Atributos de la interfaz
    //-----------------------------------------------------------------

    /**
     * Panel con los datos de la reserva
     */
    private PanelInfoPelicula panelPeli;
    

    

    /**
     * Panel de extensiones
     */
    private PanelOpciones panelOpciones;

    /**
     * Panel de visualización del cine
     */
    private PanelSala panelCine;

    /**
     * Panel con la imagen
     */
    private PanelImagen panelImagen;
    
    //panel de inforacion sillas
    
    private PanelInfoSillas panelInfoSillas;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea la ventana principal de la interfaz
     */
    public InterfazCine( )
    {
        // Crea la clase principal
        cine = new Cine( );

        // Organiza el panel principal
        
        setLayout( new BorderLayout( ) );
        setTitle( "Cinema Paradiso" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setResizable(true);
        
        //Panel informaci—n de las peliculas
   
        
        panelPeli = new PanelInfoPelicula();
        
        //panel infoSillas
        panelInfoSillas = new PanelInfoSillas();
        
        //panel interno
        
        JPanel panelInterno = new JPanel();
        panelInterno.setLayout(new BorderLayout());
        panelInterno.add(panelPeli, BorderLayout.NORTH);
        panelInterno.add(panelInfoSillas);
        

        add( panelInterno, BorderLayout.WEST );
        

        //Panel Cine y Extensiones
        panelCine = new PanelSala();
        inicializarCine();
        panelOpciones = new PanelOpciones( this );
        add( panelCine, BorderLayout.EAST );
        add( panelOpciones, BorderLayout.SOUTH );

        //Panel Imagen
        panelImagen = new PanelImagen( );
        add( panelImagen, BorderLayout.NORTH );
        pack( );
        
        
        
    }

    //-----------------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------------

    
    public Silla[][] darSillas(){
    	return cine.darSillas();
    }
    
    public void inicializarCine(){
			
			cine = new Cine();
			Silla[][] sillas = darSillas();
			panelCine.refrescarPanelSala(sillas);


    }
    
    public void cargarDeArchivo(){
		try{
			File archivo= cargarArchivo();
			cine.cargar(archivo);
			Silla[][] sillas = darSillas();
			panelCine.refrescarPanelSala(sillas);
			panelPeli.refrescarPanelPelicula(cine.darPelicula());
			panelInfoSillas.refrescarSillasReservadas(cine.darSillasReservadas()+"");
			panelInfoSillas.refrescarSillasVendidas(cine.darSillasVendidas()+"");
			panelInfoSillas.refrescarPorcentajeOcupacion(cine.darPorcentajeOcupacion()+"");
			panelInfoSillas.refrescarFilaDisponibleEnGeneral(cine.darFilaGralDisponible()+"");
			
//TODO llamar al refrescar del panel con la informaci—n de las sillas
			pack();
			}catch(Exception e){
				e.printStackTrace();
				int respuesta = JOptionPane.showConfirmDialog(this, "Hubo un error al cargar el archivo.\n¿Desea salir del programa?");
				if(respuesta==JOptionPane.YES_OPTION){
					System.exit(0);
				}
				
			}
    }
    
	private File cargarArchivo()throws Exception{
		boolean cargaBien = false;
		File salida = null;
		while(!cargaBien){
			JFileChooser fc = new JFileChooser("./data");
			fc.setDialogTitle("Abrir el archivo de sillas");
			int resultado = fc.showOpenDialog(this);
			if(resultado == JFileChooser.APPROVE_OPTION){
				salida = fc.getSelectedFile();
				cargaBien=true;
			}
		}
		
		if (salida == null){
			throw new Exception("No se eligió un archivo");
		}
		return salida;
	}
	
	public void SillaGanadora(){
    	JOptionPane.showMessageDialog(this,"La silla ganadora es: " + darSillaGanadora(), "Silla Ganadora", JOptionPane.INFORMATION_MESSAGE);

	}
    

   public String darSillasReservadas(){
	   return cine.darSillasReservadas()+ "";
   }
   
   public String darSillasVendidas(){
	   return cine.darSillasVendidas()+"";
   }
   public String darPorcentajeOcupacion(){
	   return cine.darPorcentajeOcupacion()+"";
   }
   public String darFilaGralDisponible(){
	   return cine.darFilaGralDisponible();

   }
   
   public Pelicula darInfoPelicula(){
	   return cine.darPelicula();
   }
   
   public String darSillaGanadora(){
	   return cine.darSillaGanadora();
   }
   
    
    //-----------------------------------------------------------------
    // Programa principal
    //-----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz.
     * @param args. No se requieren argumentos
     */
    public static void main( String[] args )
    {
        InterfazCine interfaz = new InterfazCine( );
        interfaz.setVisible( true );
    }
}